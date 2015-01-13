import java.util.ArrayList;
//import java.util.Arrays;


public class DFS extends Recorrido {
	
		
	public DFS(){};

	int findPath(Entrada g, boolean[] vis, int[] dist, int u, int t, int f, ArrayList<Integer> seguimiento) {
		if (u == t)
	      return f;
	    vis[u] = true;
	    for (int v = 0; v < vis.length; v++){
	    	int capacidadResidual = g.consultarCapacidadArista(u, v) - g.consultarFlujoArista(u, v);
	      if ( (!vis[v] || dist[v] == dist[u] + 1)   && capacidadResidual > 0) {
	    	  seguimiento.add(u);
			  seguimiento.add(v);
	        int df = findPath(g, vis, dist, v, t, Math.min(f, capacidadResidual),seguimiento);
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

}
