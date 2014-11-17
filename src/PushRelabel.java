import java.util.*;


public class PushRelabel extends Algoritmo {
	
	
	private int[] alturas;
	private int[] exceso;
	private int[] active;
	private LinkedList<Integer> q;
	private int flow;
	
	ArrayList<String> seq = new ArrayList <String>(); 
	
	/**
	 * Crea los itinerarios de la solucion con el algorismo PushRelabel
	 * @param sol Solucion
	 * @param g Grafo del qual queremos la solucion
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
					coste +=  adyacencias.get(j).consultarCoste();
					int nuevoIndiceF = indiceI + Math.min(flow,adyacencias.get(j).consultarFlujo()) - 1; 
					int nuevoFlujo = g.consultarFlujoArista(u, v) - Math.min(flow,adyacencias.get(j).consultarFlujo());
					//System.out.println(" u es "+ u + " y v es " + v + " i li envia un flow de " + Math.min(flow,adyacencias.get(j).consultarFlujo()) + " indicesI es " + indiceI + " incideF es" + indiceF);
					if (Math.min(flow,adyacencias.get(j).consultarFlujo()) > 0 ) crearItinerarios (sol,g,indiceI,nuevoIndiceF,Math.min(flow,adyacencias.get(j).consultarFlujo()),v,t,coste);
					flow -= Math.min(flow,adyacencias.get(j).consultarFlujo());
					g.modificarFlujoArista(u, v, nuevoFlujo);
					indiceI = nuevoIndiceF+1;
				}
			}
			
		}
		
	}
		
	
	
	/**
	 * Inicializa el grafo g
	 * @param g
	 * @param s
	 * @param t
	 */
	private void inicializacion(GrafoAntiguo g,int s, int t){
		int v;
		flow = 0;
		ArrayList <Arista> adyacencias;
		/** creo todos las aristas inversas **/
		for (int i = 0; i < g.consultarNumVertices(); ++i){
			adyacencias = g.consultarAdyacentes(i);
			for (int j = 0; j < adyacencias.size(); ++j){		
				v = adyacencias.get(j).consultarVerticeDestino();
				if (adyacencias.get(j).consultarFlujo() == 0 )g.anadirArista(v,i,adyacencias.get(j).consultarCapacidad(),adyacencias.get(j).consultarCapacidad(),-1);
			}
		}
		

		for (int i = 0; i < alturas.length; ++i){
			if ( i == s) {
				alturas[i] = g.consultarNumVertices();
				adyacencias = g.consultarAdyacentes(i);
				for (int j = 0; j < adyacencias.size(); ++j){
					v = adyacencias.get(j).consultarVerticeDestino();
					if (v != t){ 
						active[v] = 1;
						q.addLast(v);
						exceso[v]= adyacencias.get(j).consultarCapacidad();
						g.modificarFlujoArista(s,v,adyacencias.get(j).consultarCapacidad());
						g.modificarFlujoArista(v,s,0);		
					}
					else {
						g.modificarFlujoArista(s,v,adyacencias.get(j).consultarCapacidad());
						g.modificarFlujoArista(v,s,0);
						flow += adyacencias.get(j).consultarCapacidad();
					}
					
				}
			}
			else alturas[i] = 0; 
		}
		
		

	}
	/**
	 * envia flujo de un vertice a otro envia min(capacidad residual de v,u, flujo le entra u) capacidad residual es 
	 * capacidad - flujo
	 * @param g
	 * @param v
	 * @throws Exception 
	 */
	private void push(GrafoAntiguo g, int u, int v, int t) throws Exception{
		int capacidadResidual = g.consultarCapacidadArista(u, v) - g.consultarFlujoArista(u, v);
		int temp = Math.min(capacidadResidual,exceso[u]);
		int nuevoFlujo = g.consultarFlujoArista(u, v) + temp;
		g.modificarFlujoArista(u, v, nuevoFlujo); 
		if (v == t) {
			flow+=temp;
			//System.out.println( "el flujo en este momento es " + flow );
		}
		nuevoFlujo =  g.consultarFlujoArista(v, u) - temp;
		////////////per guardar /////////////////
		String sa = "el flujo en este momento es "+ flow +"\n"; 
		seq.add(sa); 
		//////////////////////////////////
		g.modificarFlujoArista(v, u, nuevoFlujo ); /** arista residual **/
		exceso[u] -= temp;
		exceso[v] += temp;
		///////// per guardar //////////////////////////
		String o = "el exceso de " + u + " despues del push es " + exceso[u] + "\n";
 		String s = + u + " hace push a " + v + " de flow: " + temp + "\n";
		seq.add(s); 
		/////////////////////////////////
		//System.out.println( u + " pushea a " + v + " con " + temp + " el exceso de 1 es " + exceso[1] );
		//System.out.println( "el vertice 1 esta en estado " + active[1] + " la altura es " + alturas[1] );
		//System.out.println(" la altura de 4 es "+ alturas[4]);
	}

	/**
	 * aumenta la altura del vertice u a la altura a uno mas que el  vertice adyacente menos alto q se le pueda anadir flow.
	 * @param g
	 * @param u
	 * @throws Exception
	 */
	// alfinal no usada
	private void relabel(GrafoAntiguo g, int u) throws Exception{
		ArrayList <Arista> adyacencias = new ArrayList<Arista>();
		adyacencias = g.consultarAdyacentes(u);
		int capacidadResidual;
		int nuevaAltura = alturas[u];   //empiezo comparando con su altura actual
		for (int i = 0; i < adyacencias.size(); ++i){
			capacidadResidual = adyacencias.get(i).consultarCapacidad() - adyacencias.get(i).consultarFlujo();
			if (capacidadResidual > 0)
				if (nuevaAltura > alturas[adyacencias.get(i).consultarVerticeDestino()]) nuevaAltura = alturas[adyacencias.get(i).consultarVerticeDestino()]+1;
		}
	}
	/**
	 * anado el la salida a la cola, mientras la cola no este vacia conuslto los vertices adyacentes del primer elemnto
	 * m la utilizo para q en caso de que no puede dar flujo aumentar la altura en ese valor
	 * para cada vertice adyacente miro si este aun le cabe mas flujo, si es asi y ademas esta mas bajo que yo le hago push,
	 * si no estava en la cola pasa a estarlo porque tiene un exceso, en caso de no tenga voy actualizando m
	 * una vez visitados todos los adyacentes si aun tengo un exceso vuelvo a iterar pero con altura m + 1, si no 
	 * lo quito de la cola y vuelvo a iterar con el siguiente vertice de la cola.
	 * @throws Exception 
	 */
	public Solucion ejecutar (Entrada e) throws Exception{
		double t1 = System.currentTimeMillis();
		GrafoAntiguo g = e.consultarGrafo();
		int s = e.consultarSource();
		int t = e.consultarSink();
		int numA = e.consultarNumeroAgentes();
		
		alturas = new int[g.consultarNumVertices()];
		exceso = new int[g.consultarNumVertices()];
		active = new int[g.consultarNumVertices()];
		q = new LinkedList<Integer>();
		inicializacion(g, s, t);
		int capacidadResidual,u,v,m;
		ArrayList <Arista> adyacencias = new ArrayList<Arista>();
		while (q.size() > 0 ){
			u = q.getFirst();
			 m = -1;
			adyacencias = g.consultarAdyacentes(u);
			for (int i = 0; exceso[u]> 0 && i < adyacencias.size(); ++i){
				v = adyacencias.get(i).consultarVerticeDestino();
				capacidadResidual = g.consultarCapacidadArista(u, v) - g.consultarFlujoArista(u, v);
				//si la arista aun puede soportar mas flujo y si el vertize esta mas alto q el destino
				if ( capacidadResidual > 0){
					if (alturas[u] > alturas[v]){ 
						push(g,u,v,t); 
						if (active[v] == 0 && v != s && v != t){
							active[u] = 1;
							q.addLast(v); 
						}
					}
					else if (m==-1) m = alturas[v];
					else m = Math.min(m, alturas[v]);
				}
				
			}
			if (exceso[u] != 0){
				alturas[u] = 1 + m;
				/////per guardar ///////////////////
				int aux = m+1; 
				String li = "la altura de " + u + " ahora es "+ aux + "\n"; 
				seq.add(li); 
				///////////////////////////////////
			}
			else {
				active[u] = 0;
				q.removeFirst();
			}

		} 
		Solucion sol = new Solucion(flow);
		if (flow >= numA){
			sol.modificartieneSolucion(true);
			sol.modificarGrafo(g);
			crearItinerarios(sol,g,0,flow-1,flow,s,t,0);
		}

		double t2 = System.currentTimeMillis();
		sol.modificarTiempo(t2-t1);
		return sol;
		
	}
	
	
	 /**
	 * Devuelve una arrayList con la sequencia de pasos que ha seguido 
	 * el algorismo
	 * @return seq
	 */
	public ArrayList<String> obtenSeq() {
		return seq; 
	}  
	
	
	
	
}
