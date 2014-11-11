import java.util.*;


public class FordFulkerson {
	
	public GNode ejecutar(GNode g, GNode f, String destino, ArrayList<String> rec) {
		if(g != null) {
			Iterator<GNodePeso> it = g.consultarIteradorHijos();
			while(it.hasNext()) {
				GNode n = it.next().consultarNodo();
				n =  ejecutar(n, f, destino, rec);
				((GNodePeso) it).modificarNodo(n);
			}
			
		}
		return g;
	}
}
