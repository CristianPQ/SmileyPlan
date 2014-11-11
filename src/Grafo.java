
public class Grafo {

	//constructora
//	ArrayList<ArrayList<Arista>> grafo;

	Arista[][] Adyacencias;
	int numVertices;
	
	//private static Exception NoExiste = new Exception ("La adyacencia NO existe");


	
	public Grafo(int numVertex){
		numVertices = numVertex;
		Adyacencias = new Arista[numVertex][];
		}
	
	public void anadirNumeroAdyacencias(int numVertex, int numAd ){
		Adyacencias[numVertex] = new Arista[numAd];
	}
		


	public Arista[] consultarAdyacentes(int vertex){
		return Adyacencias[vertex];
	}
	
	public void anadirArista (int vertex, int targetVertex,
			int flow, int capacity, int cost){
		Arista a = new Arista(targetVertex, flow, capacity, cost);
		int i = 0;
		boolean trobat = false;
		while (i < Adyacencias[vertex].length && !trobat){
			if (Adyacencias[vertex][i] == null) {
				Adyacencias[vertex][i] = a;
				trobat = true;
			
			}
			++i;
		}

	}

	
	public int consultarFlujoArista(int vertex, int targetVertex){
		int i = 0;
		while (i < Adyacencias[vertex].length){
			if (Adyacencias[vertex][i].consultarVerticeDestino() == targetVertex) {
				return Adyacencias[vertex][i].consultarFlujo();
			}
			++i;
		}
		return 0;
	}

	public void modificarFlujoArista(int vertex, int targetVertex, int nuevoFlujo) 
			{
		boolean trobat = false;
		int i = 0;
		while (i < Adyacencias[vertex].length && !trobat){
			if (Adyacencias[vertex][i].consultarVerticeDestino() == targetVertex) {
				Adyacencias[vertex][i].modificarFlujo(nuevoFlujo);
				trobat = true;
				}
			++i;
		}
	}

	
	public int consultarCapacidadArista(int vertex, int targetVertex) {
		int i = 0;
		while (i < Adyacencias[vertex].length){
			if (Adyacencias[vertex][i].consultarVerticeDestino() == targetVertex) {
				return Adyacencias[vertex][i].consultarCapacidad();
			}
			++i;
		}
		return 0;
	}


	public void modificarCapacidadArista(int vertex, int targetVertex, int nuevaCapacidad) 
			{
				
		boolean trobat = false;
		int i = 0;
		while (i < Adyacencias[vertex].length && !trobat){
			if (Adyacencias[vertex][i].consultarVerticeDestino() == targetVertex) {
				Adyacencias[vertex][i].modificarCapacidad(nuevaCapacidad);
				trobat = true;
				}
			++i;
		}
	}
	
	public int consultarCosteArista(int vertex, int targetVertex)throws Exception{
		int i = 0;
		while (i < Adyacencias[vertex].length){
			if (Adyacencias[vertex][i].consultarVerticeDestino() == targetVertex) {
				return Adyacencias[vertex][i].consultarCoste();
			}
			++i;
		}
		return 0;
	}

	
	public void modificarCosteArista(int vertex, int targetVertex, int nuevoCoste)
		{
			
	boolean trobat = false;
	int i = 0;
	while (i < Adyacencias[vertex].length && !trobat){
		if (Adyacencias[vertex][i].consultarVerticeDestino() == targetVertex) {
			Adyacencias[vertex][i].modificarCoste(nuevoCoste);
			trobat = true;
			}
		++i;
	}
}
	
	
	//consulta num vertices
	public int consultarNumVertices(){
		return numVertices;
	}


}