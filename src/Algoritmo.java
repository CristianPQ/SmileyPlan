import java.util.ArrayList;


public class Algoritmo {
	/**
	 * 
	 * @param g
	 * @param s origen
	 * @param t destino
	 * devuelve un grafo con las capaciades resultado de hacer fluir el maxflow de s a t, en caso de que sea posible 
	 * @throws Exception 
	 */
	
	GrafoAntiguo ejecutar ( GrafoAntiguo g, int s, int t) throws Exception{
		return g;}
		
	void crearItinerarios ( Solucion sol, GrafoAntiguo g, int indiceI, int indiceF, int flow, int u, int t, int coste){
		
		for (int i = indiceI; i < indiceF; ++i){
				sol.agregarVertice(i, u);
				sol.agregarCosteAItinerario(i, coste );
		}
		if (u != t){
			ArrayList <Arista> adyacencias = g.consultarAdyacentes(u);
			for (int j = 0; j < adyacencias.size(); ++j){		
				int v = adyacencias.get(j).consultarVerticeDestino();
				if (adyacencias.get(j).consultarCoste() != -1 ){
					crearItinerarios (sol,g,indiceI,indiceI+adyacencias.get(j).consultarFlujo(),flow,v,t, adyacencias.get(j).consultarCoste());
					indiceI += adyacencias.get(j).consultarFlujo();
				}
			}
			
		}
	}
		
		
}
