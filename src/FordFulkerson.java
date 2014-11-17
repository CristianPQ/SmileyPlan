import java.util.*;


public class FordFulkerson extends Algoritmo{
	
	static ArrayList<String> list = new ArrayList <String>(); 
	
	/**
	 * Crea los itinerarios que forman parte de la solucion de esta ejecucion
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
	/**
	 * Inicializadora	
	 * @param g
	 * @param s
	 * @param t
	 */
	private void inicializacion(GrafoAntiguo g,int s, int t){
		int v;
		ArrayList <Arista> adyacencias;
		/** creo todos las aristas inversas **/
		for (int i = 0; i < g.consultarNumVertices(); ++i){
			adyacencias = g.consultarAdyacentes(i);
			for (int j = 0; j < adyacencias.size(); ++j){
				
				v = adyacencias.get(j).consultarVerticeDestino();
				if (adyacencias.get(j).consultarFlujo() == 0 )g.anadirArista(v,i,adyacencias.get(j).consultarCapacidad(),adyacencias.get(j).consultarCapacidad(),-1);
			}
		}
		
	}
	
	/**
	 * Encuentra un camino
	 * @param g
	 * @param vis
	 * @param u
	 * @param t
	 * @param f
	 * @return
	 */
	 static int findPath(GrafoAntiguo g, boolean[] vis, int u, int t, int f) {
		    if (u == t)
		      return f;
		    vis[u] = true;
		    for (int v = 0; v < vis.length; v++){
		    	int capacidadResidual = g.consultarCapacidadArista(u, v) - g.consultarFlujoArista(u, v);
		      if (!vis[v] && capacidadResidual > 0) {
		        int df = findPath(g, vis, v, t, Math.min(f, capacidadResidual));
		        if (df > 0) {
		          int nuevoFlujo = g.consultarFlujoArista(u, v) + df;
		          /////////////////// per guardar /////////////////////
		          String s = "Pasara un flujo de "+df+" entre "+u+" y "+v+"\n"; 
		          list.add(s); 
		          /////////////////////////////////////////////////////
		          g.modificarFlujoArista(u,v,nuevoFlujo);
		          nuevoFlujo = g.consultarFlujoArista(v, u) - df;
		          g.modificarFlujoArista(v,u,nuevoFlujo);
		          return df;
		        }
		      }
		    }
		    return 0;
		  }
	 
	/**
	 * Ejecuta el algoritmo 
	 */
	public Solucion ejecutar ( Entrada e) throws Exception{
		float t1 = System.currentTimeMillis();
		GrafoAntiguo g = e.consultarGrafo();
		int s = e.consultarSource();
		int t = e.consultarSink();
		int numA = e.consultarNumeroAgentes();
		inicializacion(g,s,t);
		int flow = 0;
	    for (flow = 0;;) {
	        int df = findPath(g, new boolean[g.consultarNumVertices()], s, t, Integer.MAX_VALUE);
	        if (df == 0)
	          break;
	        flow += df;
	      }
		Solucion sol = new Solucion(flow);
		//System.out.println("el flow es" + flow);
		if (flow >= numA){
			sol.modificartieneSolucion(true);
			sol.modificarGrafo(g);
			crearItinerarios(sol,g,0,flow-1,flow,s,t,0);
		}
		float t2 = System.currentTimeMillis();
		sol.modificarTiempo(t2-t1);
		sol.seqsol = list; 
		return sol;
		
		
	}
	
}
	
	
	
	
