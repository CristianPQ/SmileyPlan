import java.util.*;


public class PushRelabel extends Algoritmo {
	
	
	private int[] alturas;
	private int[] exceso;
	/**
	 * inicializa todas las alturas a 0 menos la del origen a numero de vertices, incializo
	 * el exceso de del origen a tanto como la suma de los flujos q tiene de salida
	 * @param g
	 * @param s
	 */
	private void inicializacion(Grafo g,int s){
		for (int i = 0; i < alturas.length; ++i){
			if ( i == s) {
				alturas[i] = g.consultarNumVertices();
				int[] adyacencias = g.consultarAdyacencias(s);
				for (int j = 0; i < adyacencias.length; ++j){
					alturas[s] += g.consultarCapacidadArista(s, adyacencias[j]);
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
		int[] adyacencias = g.consultarAdyacencias(u);
		int capacidadResidual;
		int nuevaAltura = alturas[u];   //empiezo comparando con su altura actual
		for (int i = 0; i < adyacencias.length; ++i){
			capacidadResidual = g.consultarCapacidadArista(u, adyacencias[i]) - g.consultarFlujoArista(u,  adyacencias[i]);
			if (capacidadResidual > 0)
				if (nuevaAltura > alturas[adyacencias[i]]) nuevaAltura = alturas[adyacencias[i]]+1;
		}
	}
	public Grafo ejecutar ( Grafo g, int s, int t){
		LinkedList<Integer> q = new LinkedList<Integer>();
		inicializacion(g, s);
		q.addLast(s);
		int capacidadResidual,u,v,m;
		while (q.size() > 0 ){
			u = q.getFirst();
			 m = -1;
			int[] adyacencias = g.consultarAdyacencias(u);
			for (int i = 0; exceso[u]> 0 && i < adyacencias.length; ++i){
				v = adyacencias[i];
				capacidadResidual = g.consultarCapacidadArista(u, v) - g.consultarFlujoArista(u, v);
				//si la arista aun puede soportar mas flujo y si el vertize esta mas alto q el destino
				if ( capacidadResidual > 0){
					if (alturas[u] > alturas[v]){ 
						push(g,u,adyacencias[i]);
						if (!q.contains(v) && v != s && v != t) q.addLast(v); 
					}
					else if (m==-1) m = alturas[v];
					else m = Math.min(m, alturas[v]);
				}
				
			}
			if (exceso[u] != 0) exceso[u] = 1 + m;
			else {
				q.pollFirst();
			}

		}
		return g;
		
	}
	
	
	
	
}
