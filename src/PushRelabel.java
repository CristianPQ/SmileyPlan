import java.util.*;


public class PushRelabel extends Algoritmo {
	
	
	private int[] alturas;
	private int[] exceso;
	private int[] active;
	private LinkedList<Integer> q;
	private int flow;
	
/*	
	String path; 
	String file;
	String buffer; 
	
	
	/**
	 * inicializa todas las alturas a 0 menos la del origen a numero de vertices, incializo
	 * el exceso de del origen a tanto como la suma de los flujos q tiene de salida
	 * @param g
	 * @param s
	 */
	
	void crearItinerarios ( Solucion sol, GrafoAntiguo g, int indiceI, int indiceF, int flow, int u, int t, int coste){
		
		
		for (int i = indiceI; i < indiceF; ++i){
				sol.agregarVertice(i, u);
				if (u == t) sol.agregarCosteAItinerario(i, coste );
		}
		if (u != t){
			ArrayList <Arista> adyacencias = g.consultarAdyacentes(u);
			for (int j = 0; j < adyacencias.size(); ++j){		
				int v = adyacencias.get(j).consultarVerticeDestino();
				if (adyacencias.get(j).consultarCoste() != -1 ){
					coste +=  adyacencias.get(j).consultarCoste();
					crearItinerarios (sol,g,indiceI,indiceI+adyacencias.get(j).consultarFlujo(),flow,v,t,coste);
					indiceI += adyacencias.get(j).consultarFlujo();
				}
			}
			
		}
		
	}
		
	
	
	
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
			///////// per guardar //////////////////////////
		//	buffer = buffer + u + " hace push a " + v + " de flow: " + temp + "\n";
			/////////////////////////////////
		}
		nuevoFlujo =  g.consultarFlujoArista(u, v) - temp;
		//////////// per guardar /////////////////
		//buffer = buffer + "el flujo en este momento es "+ nuevoFlujo +"\n"; 
		//////////////////////////////////
		g.modificarFlujoArista(v, u, nuevoFlujo ); /** arista residual **/
		exceso[u] -= temp;
		exceso[v] += temp;
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
	public GrafoAntiguo ejecutar ( GrafoAntiguo g, int s, int t, int f) throws Exception{
	
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
							active[i] = 1;
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
			//	buffer = buffer + "la altura de " + u + " ahora es "+ aux + "\n"; 
				///////////////////////////////////
			}
			else {
				active[u] = 0;
				q.removeFirst();
			}

		} 
		f = flow;
	//	Guardar(path,file); 
		return g;
		
	}
	
	/**
	 * Guardar la sequencia de pasos de algoritmo 
	 * @param path
	 * @param file
	 * @param buffer
	 * @throws Exception
	 */
/*	public void Guardar(String path,String file) throws Exception {
		
		GestorDatos gd = new GestorDatos(path,file); 
		
		gd.createFile(); 
		gd.openFile("write"); 
		
		gd.writeBuffer(buffer); 
		buffer = null; 
		
		gd.closeFile(); 
	}
	
	*/
	
	
}
