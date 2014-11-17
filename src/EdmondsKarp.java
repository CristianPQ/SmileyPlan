import java.util.*;

public class EdmondsKarp {
	int flow = 0;
	
	/**
	 * Inicializadora
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
		


		}
	/**
	 * 
	 * @param g
	 * @param s
	 * @param t
	 * @return
	 */
	 public static int maxFlow(GrafoAntiguo g, int s, int t) {
		    int flow = 0;
		    int[] q = new int[g.consultarNumVertices()];
		    while (true) {
		      int qt = 0;
		      q[qt++] = s;
		      Arista[] pred = new Arista[g.consultarNumVertices()];
		      for (int qh = 0; qh < qt && pred[t] == null; qh++) {
		    	  int cur = q[qh];
		          for (Arista e : g.consultarAdyacentes(cur)) {
		            if (pred[e.consultarVerticeDestino()] == null && e.consultarCapacidad() > e.consultarFlujo()) {
		              pred[e.consultarVerticeDestino()] = e;
		              q[qt++] = e.consultarVerticeDestino();
		            }
		          }
		        }
		        if (pred[t] == null)
		          break;
		        int df = Integer.MAX_VALUE;
		        for (int u = t; u != s; u = pred[u].s)
		          df = Math.min(df, pred[u].cap - pred[u].f);
		        for (int u = t; u != s; u = pred[u].s) {
		          pred[u].f += df;
		          graph[pred[u].t].get(pred[u].rev).f -= df;
		        }
		        flow += df;
		      }
		      return flow;
		    }