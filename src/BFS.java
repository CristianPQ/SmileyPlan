import java.util.ArrayList;
import java.util.Arrays;


public class BFS extends Recorrido {
	
	public BFS(){};
	
	   boolean dinicBfs(Entrada g, int src, int dest, int[] dist, ArrayList<Integer> seguimiento) {
		    Arrays.fill(dist, -1);
		    dist[src] = 0;
		    int[] Q = new int[g.consultarNumeroVertices()];
		    int sizeQ = 0;
		    Q[sizeQ++] = src;
		    for (int i = 0; i < sizeQ; i++) {
		      int u = Q[i];
		      ArrayList <Arista> adyacencias =  g.consultarAdyacentes(u);
		      for (int j = 0; j < adyacencias.size(); ++j) {
		    	Arista e = adyacencias.get(j);
		    	int capacidadResidual = e.consultarCapacidad() - e.consultarFlujo();
		        if (dist[e.consultarVerticeDestino()] < 0 && capacidadResidual > 0) {
		        	//seguimiento.add(u);
					//seguimiento.add(e.consultarVerticeDestino());
		          dist[e.consultarVerticeDestino()] = dist[u] + 1;
		          Q[sizeQ++] = e.consultarVerticeDestino();
		        }
		      }
		    }
		    return dist[dest] >= 0;
		  }
}