import java.util.*;


public class Dinic {


		  static boolean dinicBfs(GrafoAntiguo g, int src, int dest, int[] dist) {
		    Arrays.fill(dist, -1);
		    dist[src] = 0;
		    int[] Q = new int[g.consultarNumVertices()];
		    int sizeQ = 0;
		    Q[sizeQ++] = src;
		    for (int i = 0; i < sizeQ; i++) {
		      int u = Q[i];
		      ArrayList <Arista> adyacencias =  g.consultarAdyacentes(u);
		      for (int j = 0; j < adyacencias.size(); ++j) {
		    	Arista e = adyacencias.get(j);
		    	int capacidadResidual = e.consultarCapacidad() - e.consultarFlujo();
		        if (dist[e.consultarVerticeDestino()] < 0 && capacidadResidual > 0) {
		          dist[e.consultarVerticeDestino()] = dist[u] + 1;
		          Q[sizeQ++] = e.consultarVerticeDestino();
		        }
		      }
		    }
		    return dist[dest] >= 0;
		  }

		  static int dinicDfs(GrafoAntiguo g, int[] ptr, int[] dist, int dest, int u, int f) {
		    if (u == dest)
		      return f;
		    ArrayList <Arista> adyacencias =  g.consultarAdyacentes(u);
		    for (; ptr[u] < adyacencias.size(); ++ptr[u]) {
		      Arista e = adyacencias.get(ptr[u]);
		      int v = e.consultarVerticeDestino();
		      if (dist[v] == dist[u] + 1 && e.consultarFlujo() < e.consultarCapacidad()) {
		    	 int capacidadResidual = e.consultarCapacidad() - e.consultarFlujo();
		        int df = dinicDfs(g, ptr, dist, dest, v, Math.min(f, capacidadResidual ));
		        if (df > 0) {
		        	//System.out.println("aqui");
			          int nuevoFlujo = g.consultarFlujoArista(u, v) + df;
			          //System.out.println("nuevoFlujo de " + u + " a " + v + " es " + nuevoFlujo);
			          g.modificarFlujoArista(u,v,nuevoFlujo);
			          nuevoFlujo = g.consultarFlujoArista(v, u) - df;
			         // cap[v][u] += df;
			          g.modificarFlujoArista(v,u,nuevoFlujo);
			          return df;
		        }
		      }
		    }
		    return 0;
		  }

		  public static int ejecutar(GrafoAntiguo g, int src, int dest) {
		    int flow = 0;
		    int[] dist = new int[g.consultarNumVertices()];
		    while (dinicBfs(g, src, dest, dist)) {
		      int[] ptr = new int[g.consultarNumVertices()];
		      while (true) {
		        int df = dinicDfs(g, ptr, dist, dest, src, Integer.MAX_VALUE);
		        if (df == 0)
		          break;
		        flow += df;
		      }
		    }
		    return flow;
		  }

}

