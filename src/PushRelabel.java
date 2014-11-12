import java.util.*;


public class PushRelabel extends Algoritmo {
	
	
	private int[] alturas;
	private int[] exceso;
	private int[] active;
	private LinkedList<Integer> q;
	/**
	 * inicializa todas las alturas a 0 menos la del origen a numero de vertices, incializo
	 * el exceso de del origen a tanto como la suma de los flujos q tiene de salida
	 * @param g
	 * @param s
	 */
	private void inicializacion(Grafo g,int s, int t){
		int v;
		for (int i = 0; i < alturas.length; ++i){
			

			if ( i == s) {
		
				alturas[i] = g.consultarNumVertices();
				Arista[] adyacencias = g.consultarAdyacentes(s);
		
				for (int j = 0; j < adyacencias.length; ++j){
					v = adyacencias[j].consultarVerticeDestino();
					if (v != t){
						active[v] = 1;
						q.addLast(v);
						exceso[v]= adyacencias[j].consultarCapacidad();
					}
					//System.out.println("exceso " + exceso[s]);
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
	private void push(Grafo g, int u, int v) throws Exception{
		System.out.println(u + " pushea a " + v);

		int capacidadResidual = g.consultarCapacidadArista(u, v) - g.consultarFlujoArista(u, v);
		int temp = Math.min(capacidadResidual,exceso[u]);
		int nuevoFlujo = g.consultarFlujoArista(u, v) + temp;
		g.modificarFlujoArista(u, v, nuevoFlujo); 
		exceso[u] -= temp;
		exceso[v] += temp;
	}

	/**
	 * aumenta la altura del vertice u a la altura a uno mas que el  vertice adyacente menos alto q se le pueda anadir flow.
	 * @param g
	 * @param u
	 * @throws Exception
	 */
	private void relabel(Grafo g, int u) throws Exception{
		Arista[] adyacencias = g.consultarAdyacentes(u);
		int capacidadResidual;
		int nuevaAltura = alturas[u];   //empiezo comparando con su altura actual
		for (int i = 0; i < adyacencias.length; ++i){
			capacidadResidual = adyacencias[i].consultarCapacidad() - adyacencias[i].consultarFlujo();
			if (capacidadResidual > 0)
				if (nuevaAltura > alturas[adyacencias[i].consultarVerticeDestino()]) nuevaAltura = alturas[adyacencias[i].consultarVerticeDestino()]+1;
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
	public Grafo ejecutar ( Grafo g, int s, int t) throws Exception{
	
		alturas = new int[g.consultarNumVertices()];
		exceso = new int[g.consultarNumVertices()];
		active = new int[g.consultarNumVertices()];
		q = new LinkedList<Integer>();
		inicializacion(g, s, t);
	
		//q.addLast(s);
		int capacidadResidual,u,v,m;
		int cont = 0;
		while (q.size() > 0 ){
			++cont;
			u = q.getFirst();
			 m = -1;
			Arista[] adyacencias = g.consultarAdyacentes(u);
			System.out.println(" \n" + u + " es " + u + " y tiene un exceso de " + exceso[u]);
			for (int i = 0; exceso[u]> 0 && i < adyacencias.length; ++i){
	
				v = adyacencias[i].consultarVerticeDestino();
				System.out.println("v es "  + v  + " el exceso de u es ahora " + exceso[u]);
				capacidadResidual = g.consultarCapacidadArista(u, v) - g.consultarFlujoArista(u, v);
				System.out.println("la capacidad residual de "+  u + " " + v + " es " + capacidadResidual);
				//si la arista aun puede soportar mas flujo y si el vertize esta mas alto q el destino
				if ( capacidadResidual > 0){
					if (alturas[u] > alturas[v]){ 
						push(g,u,v);
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
				alturas[u]++; // = 1 + m;
				if(alturas[u] > g.consultarNumVertices()){
					active[u] = 0;
					q.removeFirst();
				} 
			}
			else {
				active[u] = 0;
				q.removeFirst();
			}

		}
		return g;
		
	}
	
	
	
	
}
