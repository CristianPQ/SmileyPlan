import java.util.*;


public class FordFulkerson extends Algoritmo{
	
	static ArrayList<String> list = new ArrayList <String>(); 
	private ArrayList<Integer> seguimiento;
	private int inicio;
	
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
	void crearItinerarios ( Solucion sol, Entrada g, int indiceI, int indiceF, int flow, int u, int t, int coste){
		
		for (int i = indiceI; i <= indiceF; ++i){
				sol.agregarVertice(i, u);
				if (u == t) sol.agregarCosteAItinerario(i, coste );
		}
		if (u != t){
			ArrayList <Arista> adyacencias = g.consultarAdyacentes(u);			
			for (int j = 0; j < adyacencias.size(); ++j){	//todad las adyacencias de u	
				int v = adyacencias.get(j).consultarVerticeDestino(); //elige un vertice
					
				if (adyacencias.get(j).consultarFlujo() > 0 /* && control < 20 */){ //si no es una arista inversa y tiene flujo
					coste +=  adyacencias.get(j).consultarCoste(); //actualizamos el coste
					int nuevoIndiceF = indiceI + Math.min(flow,adyacencias.get(j).consultarFlujo()) - 1; //indiceFinal es indiceInicial mas el minimo del flow con el que ha sido llamada la funcion y el flujo que tiene la arista
					int nuevoFlujo = g.consultarFlujoArista(u, v) - Math.min(flow,adyacencias.get(j).consultarFlujo()); // el flujo que quedara en esa arista
					System.out.println(" u es "+ u + " y v es " + v + " i li envia un flow de " + adyacencias.get(j).consultarFlujo() + " indicesI es " + indiceI + " incideF es " + indiceF);
					
					int viejoFlujo = adyacencias.get(j).consultarFlujo();
					int viejoFlow = flow;
					g.modificarFlujoArista(u, v, nuevoFlujo); //actualiza el flow de la arista 
					if (Math.min(flow,viejoFlujo) > 0 && v != inicio  )//segunda condicion evitar bucles //si queda flow del que nos han llamado y queda flow pen la arista, llamamos al vertice adyacente
						crearItinerarios (sol,g,indiceI,nuevoIndiceF,Math.min(flow,viejoFlujo),v,t,coste); 
					flow -= Math.min(flow,viejoFlujo); //actualiza el flow con el q le han llamado
					
					indiceI = nuevoIndiceF+1; //nuevo indice inicial es el final + 1
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
	
	/**
	 * Encuentra un camino
	 * @param g
	 * @param vis
	 * @param u
	 * @param t
	 * @param f
	 * @return
	 */
	/*
	 static int findPath(Entrada g, boolean[] vis, int u, int t, int f) {
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
		          String s = "Pasara un flujo de "+ df +" entre "+ u +" y "+ v +"\n"; 
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
	 
	 
	/**
	 * Ejecuta el algoritmo 
	 */
	public Solucion ejecutar ( Entrada g) throws Exception{
		seguimiento = new ArrayList<Integer>();
		double t1 = System.nanoTime();
		//GrafoAntiguo g = e.consultarGrafo();
		DFS dfs = new DFS();
		int s = g.consultarSource();
		inicio = s;
		int t = g.consultarSink();
		int numA = g.consultarNumeroAgentes();
		inicializacion(g,s,t);
		int flow = 0;
	    for (flow = 0;;) {
	        int df = dfs.findPath(g, new boolean[g.consultarNumeroVertices()], new int[g.consultarNumeroVertices()], s, t, Integer.MAX_VALUE,seguimiento);
	        if (df == 0)
	          break;
	        flow += df;
	      }
		Solucion sol = new Solucion(flow);
		//System.out.println("el flow es" + flow);
		double t2 = System.currentTimeMillis();
		sol.modificarTiempo(t2-t1);
		sol.modificarTiempo((System.nanoTime()-t1)/1000000);
		for (int k = 0; k < seguimiento.size(); ++k)
			sol.agregarVerticeSeguimiento(seguimiento.get(k));
		if (flow >= numA){
			sol.modificartieneSolucion(true);
			//sol.modificarGrafo(g);
			
		}
		crearItinerarios(sol,g,0,flow-1,flow,s,t,0);
		sol.seqsol = list; 
		return sol;
		
		
	}
	
}