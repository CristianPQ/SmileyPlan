import java.util.*;


public class PushRelabel extends Algoritmo {
	
	
	private int[] alturas;
	private int[] exceso;
	private int[] active;
	private LinkedList<Integer> q;
	private int flow;
	private Date da;
	private int inicio;
	
	public ArrayList<String> seq = new ArrayList <String>(); 
	
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
	
	/** funcion recursiva para crear los itinerarios a partir del grafo, cada llamada agrega su vertice al itinerario tantas veces como la diferencia entre indiceF y indiceI
	 * estos son el numero de flow por el que ha sido llamado**/
	void crearItinerarios ( Solucion sol, Entrada g, int indiceI, int indiceF, int flow, int u, int t, int coste){
		
		for (int i = indiceI; i <= indiceF; ++i){
				sol.agregarVertice(i, u);
				if (u == t) sol.agregarCosteAItinerario(i, coste );
		}
		if (u != t){
			ArrayList <Arista> adyacencias = g.consultarAdyacentes(u);
			for (int j = 0; j < adyacencias.size(); ++j){	//todad las adyacencias de u	
				int v = adyacencias.get(j).consultarVerticeDestino(); //elige un vertice
				if (adyacencias.get(j).consultarFlujo() > 0 ){ //si no es una arista inversa y tiene flujo
					coste +=  adyacencias.get(j).consultarCoste(); //actualizamos el coste
					int nuevoIndiceF = indiceI + Math.min(flow,adyacencias.get(j).consultarFlujo()) - 1; //indiceFinal es indiceInicial mas el minimo del flow con el que ha sido llamada la funcion y el flujo que tiene la arista
					int nuevoFlujo = g.consultarFlujoArista(u, v) - Math.min(flow,adyacencias.get(j).consultarFlujo()); // el flujo que quedara en esa arista
					System.out.println(" u es "+ u + " y v es " + v + " i li envia un flow de " + Math.min(flow,adyacencias.get(j).consultarFlujo()) + " indicesI es " + indiceI + " incideF es" + indiceF);
					if (Math.min(flow,adyacencias.get(j).consultarFlujo()) > 0 && v != inicio && adyacencias.get(j).consultarCoste() != -1 )//segunda condicion evitar bucles //si queda flow del que nos han llamado y queda flow pen la arista, llamamos al vertice adyacente
						crearItinerarios (sol,g,indiceI,nuevoIndiceF,Math.min(flow,adyacencias.get(j).consultarFlujo()),v,t,coste); 
					flow -= Math.min(flow,adyacencias.get(j).consultarFlujo()); //actualiza el flow con el q le han llamado
					g.modificarFlujoArista(u, v, nuevoFlujo); //actualiza el flow de la arista 
					indiceI = nuevoIndiceF+1; //nuevo indice inicial es el final + 1
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
	private void inicializacion(Entrada g,int s, int t){
		int v;
		flow = 0;
		ArrayList <Arista> adyacencias;
		/** creo todos las aristas inversas **/
		for (int i = 0; i < g.consultarNumeroVertices(); ++i){
			adyacencias = g.consultarAdyacentes(i);
			for (int j = 0; j < adyacencias.size(); ++j){		
				v = adyacencias.get(j).consultarVerticeDestino();
				if (adyacencias.get(j).consultarFlujo() == 0 && adyacencias.get(j).consultarCoste() != -1 )g.anadirArista(v,i,adyacencias.get(j).consultarCapacidad(),adyacencias.get(j).consultarCapacidad(),-1);
			}
		}
		
		/** Pongo todas las alturas a 0 menos la de la salida, pongo todos los vertices adyacentes en la cola de activos y en el caso de que el adyacente
		 * es el destino aumento el flow **/
		for (int i = 0; i < alturas.length; ++i){
			if ( i == s) {
				alturas[i] = g.consultarNumeroVertices();
				adyacencias = g.consultarAdyacentes(i);
				//System.out.println("los vertices adyacentes a 0 son ");
				for (int j = 0; j < adyacencias.size(); ++j){
					v = adyacencias.get(j).consultarVerticeDestino();
					//System.out.print(v + " ");
					if (v != t && adyacencias.get(j).consultarCoste()!=-1){ 
						active[v] = 1;
						q.addLast(v);
						exceso[v]= adyacencias.get(j).consultarCapacidad();
					//	System.out.println("El exceso de " + v + " es " + exceso[v]);
						g.modificarFlujoArista(s,v,adyacencias.get(j).consultarCapacidad()); //envio todo el flow posible desde el origen
						g.modificarFlujoArista(v,s,0);	// actualizo la inversa
					}
					else if (adyacencias.get(j).consultarCoste()!=-1) {
						g.modificarFlujoArista(s,v,adyacencias.get(j).consultarCapacidad()); //envio todo el flow posible desde el origen
						g.modificarFlujoArista(v,s,0); //actualizo la inversa
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
	private void push(Entrada g, int u, int v, int t) throws Exception{
		//System.out.println( u + "  va pushear a " + v + " con " + " el exceso de " + u + " es " + exceso[u] );
		int capacidadResidual = g.consultarCapacidadArista(u, v) - g.consultarFlujoArista(u, v); //la capacidad redidual sera la capacidad de la arista menos el flujo que passa por esta
		int temp = Math.min(capacidadResidual,exceso[u]); // temporal para saber cuanto podemos pushear
		int nuevoFlujo = g.consultarFlujoArista(u, v) + temp; //el nuevo flujo de la arista sera el antiguo mas el que ahora pasa
		 g.modificarFlujoArista(u, v, nuevoFlujo); 
		if (v == t ) { // si v es igual a t, aumentamos el flow maximo tanto como el que podemos pushear
			flow+=temp;
			System.out.println( "el flujo en este momento es " + flow );
			////////////per guardar /////////////////
			String sa = "el flujo en este momento es "+ flow +"\n"; 
			seq.add(sa); 
			//////////////////////////////////
		}
		nuevoFlujo =  g.consultarFlujoArista(v, u) - temp; // restamos el nuevo flujo a la arista residual
		//System.out.println("el exceso de "+ u + " es " + exceso[u] + " y el de " + v + " es " + exceso[v]);
		g.modificarFlujoArista(v, u, nuevoFlujo ); /** arista residual **/
		exceso[u] -= temp;
		 exceso[v] += temp;
		
		///////// per guardar //////////////////////////
 		String s = + u + " hace push a " + v + " de flow: " + temp + "\n";
		seq.add(s); 
		String o = "el exceso de " + u + " despues del push es " + exceso[u] + "\n";
		seq.add(o);
		/////////////////////////////////
		

		System.out.println( u + " pushea a " + v + " con " + temp + " el exceso de " + u + " es " + exceso[u] + "\n");
		//System.out.println( "el vertice 1 esta en estado " + active[1] + " la altura es " + alturas[1] );
		//System.out.println(" la altura de 4 es "+ alturas[4]);
	}


	/**
	 * anado el la salida a la cola, mientras la cola no este vacia consulto los vertices adyacentes del primer elemnto
	 * m la utilizo para q en caso de que no puede dar flujo aumentar la altura en ese valor
	 * para cada vertice adyacente miro si este aun le cabe mas flujo, si es asi y ademas esta mas bajo que yo le hago push,
	 * si no estava en la cola pasa a estarlo porque tiene un exceso, en caso de no tenga voy actualizando m
	 * una vez visitados todos los adyacentes si aun tengo un exceso vuelvo a iterar pero con altura m + 1, si no 
	 * lo quito de la cola y vuelvo a iterar con el siguiente vertice de la cola.
	 * @throws Exception 
	 */
	public Solucion ejecutar (Entrada g) throws Exception{
		da = new Date();
		long diff = da.getTime();
		double t1 = System.nanoTime();
		//GrafoAntiguo g = e.consultarGrafo();
		
		int s = g.consultarSource();
		int t = g.consultarSink();
		int numA = g.consultarNumeroAgentes();
		inicio = s;
		alturas = new int[g.consultarNumeroVertices()];
		exceso = new int[g.consultarNumeroVertices()];
		active = new int[g.consultarNumeroVertices()];
		q = new LinkedList<Integer>();
		inicializacion(g, s, t);
		int capacidadResidual,u,v,m;
		ArrayList <Arista> adyacencias = new ArrayList<Arista>();
		while (q.size() > 0  ){ //mientras quede algo en la cola itero
			//System.out.println("el exceso de 1 es " + exceso[1] );
			u = q.getFirst();
			m = -1;
			adyacencias = g.consultarAdyacentes(u); 
			for (int i = 0; exceso[u]> 0 && i < adyacencias.size(); ++i){ //mientras el vertice tenga exceso y vertices adyascentes
				v = adyacencias.get(i).consultarVerticeDestino();
				capacidadResidual = g.consultarCapacidadArista(u, v) - g.consultarFlujoArista(u, v);
				//si la arista aun puede soportar mas flujo y si el vertice esta mas alto q el destino
				if ( capacidadResidual > 0){
					if (alturas[u] > alturas[v]){ 
						push(g,u,v,t); 
						if (active[v] == 0 && v != s && v != t){ //se pone como activo solo si ya no lo esta y si no es s o t.
							active[u] = 1;
							q.addLast(v); 
						}
					}
					else if (m==-1) m = alturas[v];  //si no pude pushear i es la primera vez m es la del vertice
					else m = Math.min(m, alturas[v]); //sino se queda con la minima
				}
				
			}
			if (exceso[u] != 0 ){ // si aun queda exceso aumenta la altura hasta m
				alturas[u] = 1 + m;  
				/////per guardar ///////////////////
				int aux = m+1; 
				String li = "la altura de " + u + " ahora es "+ aux + "\n"; 
				seq.add(li); 
				///////////////////////////////////
			}
			else {
				active[u] = 0; // si no queda exceso se quita de la cola
				q.removeFirst();
			}

		} 
		Solucion sol = new Solucion(flow);
		if (flow >= numA){ //si el flow es mas grande que numero de agentes hay solucion
			sol.modificartieneSolucion(true);
			//sol.modificarGrafo(g);
			System.out.println("el max flow es " + flow);
			crearItinerarios(sol,g,0,flow-1,flow,s,t,0); //crea los itinerarios a partir del grafo
		}

		double t2 = System.currentTimeMillis();
		//System.out.println(System.nanoTime());
		//Thread.sleep (10000);
		//System.curre
		//System.out.println(System.nanoTime());
		//System.out.println(da.getTime());
		sol.modificarTiempo((System.nanoTime()-t1)/1000000);
		sol.seqsol = seq; 
		return sol;
		
	}
	
}
