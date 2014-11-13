import java.util.*;


public class FordFulkerson {
	
	
	private void inicializacion(GrafoAntiguo g,int s, int t){
		int v;
		ArrayList <Arista> adyacencias;
		/** creo todos las aristas inversas **/
		for (int i = 0; i < g.consultarNumVertices(); ++i){
			adyacencias = g.consultarAdyacentes(i);
			for (int j = 0; j < adyacencias.size(); ++j){
				
				v = adyacencias.get(j).consultarVerticeDestino();
				if (adyacencias.get(j).consultarFlujo() == 0 )g.anadirArista(v,i,adyacencias.get(j).consultarCapacidad(),adyacencias.get(j).consultarCapacidad(),0);
			}
		}
		
	}
	 static int findPath(GrafoAntiguo g, boolean[] vis, int u, int t, int f) {
		    if (u == t)
		      return f;
		    vis[u] = true;
		    for (int v = 0; v < vis.length; v++){
		    	int capacidadResidual = g.consultarCapacidadArista(u, v) - g.consultarFlujoArista(u, v);
		      if (!vis[v] && capacidadResidual > 0) {
		        int df = findPath(g, vis, v, t, Math.min(f, capacidadResidual));
		        if (df > 0) {
		         // cap[u][v] -= df;
		        	System.out.println("aqui");
		          int nuevoFlujo = g.consultarFlujoArista(u, v) + df;
		          System.out.println("nuevoFlujo de " + u + " a " + v + " es " + nuevoFlujo);
		          g.modificarFlujoArista(u,v,nuevoFlujo);
		          nuevoFlujo = g.consultarFlujoArista(u, v) - df;
		         // cap[v][u] += df;
		          g.modificarFlujoArista(v,u,nuevoFlujo);
		          return df;
		        }
		      }
		    }
		    return 0;
		  }
	 
	 

	public int ejecutar ( GrafoAntiguo g, int s, int t) throws Exception{
		
	    for (int flow = 0;;) {
	        int df = findPath(g, new boolean[g.consultarNumVertices()], s, t, Integer.MAX_VALUE);
	        if (df == 0)
	          return flow;
	        flow += df;
	      }
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
/*	
	public GNode ejecutar(GNode g, GNode f, String destino, ArrayList<String> rec) {
		if(g != null) {
			Iterator<GNodePeso> it = g.consultarIteradorHijos();
			while(it.hasNext()) {
				GNodePeso nPeso = it.next();
				GNode n = nPeso.consultarNodo();
				n =  ejecutar(n, f, destino, rec);
				((GNodePeso) it).modificarNodo(n);
			}
			
		}
		return g;
	}
}
*/