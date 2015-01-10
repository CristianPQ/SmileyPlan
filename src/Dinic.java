import java.util.*;


public class Dinic extends Algoritmo {

	static ArrayList<String> seq = new ArrayList<String>(); 
	private ArrayList<Integer> seguimiento;
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
	void crearItinerarios ( Solucion sol, Entrada g, int indiceI, int indiceF, int flow, int u, int t, int coste){
		
		//System.out.println();
		for (int i = indiceI; i <= indiceF; ++i){
				sol.agregarVertice(i, u);
				if (u == t) sol.agregarCosteAItinerario(i, coste );
		}
		if (u != t){
			ArrayList <Arista> adyacencias = g.consultarAdyacentes(u);
			for (int j = 0; j < adyacencias.size(); ++j){		
				int v = adyacencias.get(j).consultarVerticeDestino();
				if (adyacencias.get(j).consultarCoste() != -1 && adyacencias.get(j).consultarFlujo() > 0 ){
					coste +=  adyacencias.get(j).consultarCoste();
					int nuevoIndiceF = indiceI + Math.min(flow,adyacencias.get(j).consultarFlujo()) - 1; 
					int nuevoFlujo = g.consultarFlujoArista(u, v) - Math.min(flow,adyacencias.get(j).consultarFlujo());
					crearItinerarios (sol,g,indiceI,nuevoIndiceF,Math.min(flow,adyacencias.get(j).consultarFlujo()),v,t,coste);
					flow -= Math.min(flow,adyacencias.get(j).consultarFlujo());
					g.modificarFlujoArista(u, v, nuevoFlujo);
					indiceI = nuevoIndiceF+1;
				}
			}
			
		}
		
	}
		
	private void inicializacion(Entrada g,int s, int t){
		int v;
		ArrayList <Arista> adyacencias;
		/** creo todos las aristas inversas **/
		for (int i = 0; i < g.consultarNumeroVertices(); ++i){
			adyacencias = g.consultarAdyacentes(i);
			for (int j = 0; j < adyacencias.size(); ++j){
				
				v = adyacencias.get(j).consultarVerticeDestino();
				if (adyacencias.get(j).consultarFlujo() == 0 )g.anadirArista(v,i,adyacencias.get(j).consultarCapacidad(),adyacencias.get(j).consultarCapacidad(),-1);
			}
		}
		
	}
	
		  static boolean dinicBfs(Entrada g, int src, int dest, int[] dist) {
		    Arrays.fill(dist, -1);
		    dist[src] = 0;
		    int[] Q = new int[g.consultarNumeroVertices()];
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
/*
		  static int dinicDfs(Entrada g, int[] ptr, int[] dist, int dest, int u, int f) {
		    if (u == dest)
		      return f;
		    ArrayList <Arista> adyacencias =  g.consultarAdyacentes(u);
		    System.out.println("Estoy en el vertice " + u);
		    for (; ptr[u] < adyacencias.size(); ++ptr[u]) {
		      System.out.println("ptr[] es " + ptr[u]);
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
		  */
	/*	  
			 static int findPath(Entrada g, boolean[] vis, int[] dist, int u, int t, int f) {
				    if (u == t)
				      return f;
				    vis[u] = true;
				    for (int v = 0; v < vis.length; v++){
				    	int capacidadResidual = g.consultarCapacidadArista(u, v) - g.consultarFlujoArista(u, v);
				      if ( (!vis[v] || dist[v] == dist[u] + 1)   && capacidadResidual > 0) {
				        int df = findPath(g, vis, dist, v, t, Math.min(f, capacidadResidual));
				        if (df > 0) {
				          int nuevoFlujo = g.consultarFlujoArista(u, v) + df;
				          g.modificarFlujoArista(u,v,nuevoFlujo);
				          nuevoFlujo = g.consultarFlujoArista(v, u) - df;
				          g.modificarFlujoArista(v,u,nuevoFlujo);
				          return df;
				        }
				      }
				    }
				    return 0;
				  }
*/
		  
		  
		  

		  public Solucion ejecutar(Entrada g) {
			 seguimiento = new ArrayList<Integer>();
			double t1 = System.nanoTime();
			BFS bfs = new BFS();
			DFS dfs = new DFS();
		    int flow = 0;
			//GrafoAntiguo g = e.consultarGrafo();
			int src = g.consultarSource();
			int dest = g.consultarSink();
			int numA = g.consultarNumeroAgentes();
			inicializacion(g,src,dest);
		    int[] dist = new int[g.consultarNumeroVertices()];
		    while (bfs.dinicBfs(g, src, dest, dist, seguimiento)) {
		      //int[] ptr = new int[g.consultarNumeroVertices()];
		      while (true) {
		    	  boolean[] vis = new boolean[g.consultarNumeroVertices()];
		       // int df = findPath(g, vis, dist, src, dest, Integer.MAX_VALUE);
		    	  int df = dfs.findPath(g, vis, dist, src, dest, Integer.MAX_VALUE,seguimiento);
		        if (df == 0)
		          break;
		        flow += df;
		      }
		    }
			Solucion sol = new Solucion(flow);
			for (int k = 0; k < seguimiento.size(); ++k)
				sol.agregarVerticeSeguimiento(seguimiento.get(k));
			if (flow >= numA){
				sol.modificartieneSolucion(true);
				///sol.modificarGrafo(g);
				crearItinerarios(sol,g,0,flow-1,flow,src,dest,0);
			}
		//	Guardar(path,file); 
			System.out.println("el flow es" + flow);
			//float t2 = System.currentTimeMillis();
			//sol.modificarTiempo(t2-t1);
			sol.seqsol = seq; 
			double t2 = System.nanoTime();
			double div = 1000000;
			System.out.println("Estoy en el algorismo " + (t2-t1)/div);
			sol.modificarTiempo((t2-t1)/1000000);
			return sol;
		  }
		  
}

