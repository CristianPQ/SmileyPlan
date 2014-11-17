import java.util.*;


public class Dinic extends Algoritmo {

	static ArrayList<String> seq = new ArrayList<String>(); 
	
	/**
	 * Crea los itinerarios de la solucion 
	 * @param sol
	 * @param g
	 * @param indiceI
	 * @param indiceF
	 * @param flow
	 * @param u
	 * @param t
	 * @param coste
	 */
	void crearItinerarios ( Solucion sol, GrafoAntiguo g, int indiceI, int indiceF, int flow, int u, int t, int coste){
		
		for (int i = indiceI; i <= indiceF; ++i){
				sol.agregarVertice(i, u);
				if (u == t) sol.agregarCosteAItinerario(i, coste );
		}
		if (u != t){
			ArrayList <Arista> adyacencias = g.consultarAdyacentes(u);
			for (int j = 0; j < adyacencias.size(); ++j){		
				int v = adyacencias.get(j).consultarVerticeDestino();
				if (adyacencias.get(j).consultarCoste() != -1 && adyacencias.get(j).consultarFlujo() > 0 ){
					int nuevoIndiceF = indiceI + Math.min(flow,adyacencias.get(j).consultarFlujo()) - 1; 
					int nuevoFlujo = g.consultarFlujoArista(u, v) - Math.min(flow,adyacencias.get(j).consultarFlujo());
					crearItinerarios (sol,g,indiceI,nuevoIndiceF,Math.min(flow,adyacencias.get(j).consultarFlujo()),v,t,coste + adyacencias.get(j).consultarCoste());
					flow -= Math.min(flow,adyacencias.get(j).consultarFlujo());
					g.modificarFlujoArista(u, v, nuevoFlujo);
					indiceI = nuevoIndiceF+1;
				}
			}
			
		}
		
	}
		
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
			          int nuevoFlujo = g.consultarFlujoArista(u, v) + df;
			          ///////////////////////////////////////per guardar ////////////
			          String s = "Pasara un flujo de "+df+" entre "+u+" y "+v+"\n";
			          seq.add(s); 
			          ////////////////////////////////////////////////////////////////
			          g.modificarFlujoArista(u,v,nuevoFlujo);
			          nuevoFlujo = g.consultarFlujoArista(v, u) - df;
			          g.modificarFlujoArista(v,u,nuevoFlujo);
			          return df;
		        }
		      }
		    }
		    return 0;
		  }

		  public Solucion ejecutar(Entrada e) {
			double t1 = System.currentTimeMillis();
		    int flow = 0;
			GrafoAntiguo g = e.consultarGrafo();
			int src = e.consultarSource();
			int dest = e.consultarSink();
			int numA = e.consultarNumeroAgentes();
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
			Solucion sol = new Solucion(flow);
			if (flow >= numA){
				sol.modificartieneSolucion(true);
				sol.modificarGrafo(g);
				crearItinerarios(sol,g,0,flow-1,flow,src,dest,0);
			}
		//	Guardar(path,file); 
			double t2 = System.currentTimeMillis();
			sol.modificarTiempo(t2-t1);
			sol.seqsol = seq; 
			return sol;
		  }
		  
}

