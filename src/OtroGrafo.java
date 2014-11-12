import java.util.*;
public class OtroGrafo {

	//constructora
//	ArrayList<ArrayList<Arista>> grafo;

	List <Arista> Adyacencias[];
	int numVertices;
	
	//private static Exception NoExiste = new Exception ("La adyacencia NO existe");


	
	public OtroGrafo(int numVertex){
		numVertices = numVertex;
		for (int i = 0; i < numVertex; ++i) Adyacencias[i] = new ArrayList<Arista>();

	}
	/*
	//*public void anadirNumeroAdyacencias(int numVertex, int numAd ){
		Adyacencias[numVertex] = new Arista[numAd];
	}
		
*/
	
	/*public void vaciarGrafo(){
		for (int i = 0; i < Adyacencias.length; i+){
			
		}
			grafo[i].makeEmpty();
	}

	*/

	public List <Arista> consultarAdyacentes(int vertex){
		return Adyacencias[vertex];
	}

	public void anadirArista (int vertex, int targetVertex,
			int flow, int capacity, int cost){
		Arista a = new Arista(targetVertex, flow, capacity, cost);
		
		Adyacencias[vertex].add(a);
		}

	public void eliminarArista(int vertex, int targetVertex){
		int i;
		boolean trobat = false;
		for (i = 0; i < Adyacencias[vertex].size() && !trobat; ++i){
			if( !Adyacencias[vertex].get(i).equals(null) &&
					Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex){
				Adyacencias[vertex].remove(i);
				trobat = true;
			}
			
		}
	}

/*	public int consultarVerticeDestinoArista
		(int vertex){
			Arista a = grafo.get(vertex);
			return a.consultarVerticeDestino();
	}

	public void modificarVerticeDestinoArista
		(int vertex, int nuevoVerticeDestino) {
			Arista a = grafo.get(vertex);
			a.modificarVerticeDestino(nuevoFlujo);
			grafo.add(vertex,a);
	}
*/
	
	public int consultarFlujoArista(int vertex, int targetVertex){
		int i;
		boolean trobat = false;
		for (i = 0; i < Adyacencias[vertex].size() && !trobat; ++i){
			if( !Adyacencias[vertex].get(i).equals(null) &&
					Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex){
						return Adyacencias[vertex].get(i).consultarFlujo();
			}			
		}
		return 0;
	}

	public void modificarFlujoArista(int vertex, int targetVertex, int nuevoFlujo){ 
	int i;
	boolean trobat = false;
	for (i = 0; i < Adyacencias[vertex].size() && !trobat; ++i){
		if( !Adyacencias[vertex].get(i).equals(null) &&
				Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex){
					Arista a = Adyacencias[vertex].get(i);
					a.modificarFlujo(nuevoFlujo);
					Adyacencias[vertex].remove(i);
					Adyacencias[vertex].add(i,a);
		}			
	}
}

	
	public int consultarCapacidadArista(int vertex, int targetVertex) {
		int i;
		boolean trobat = false;
		for (i = 0; i < Adyacencias[vertex].size() && !trobat; ++i){
			if( !Adyacencias[vertex].get(i).equals(null) &&
					Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex){
						return Adyacencias[vertex].get(i).consultarCapacidad();
			}			
		}
		return 0;
	}


	public void modificarCapacidadArista(int vertex, int targetVertex, int nuevaCapacidad) {
	int i;
	boolean trobat = false;
	for (i = 0; i < Adyacencias[vertex].size() && !trobat; ++i){
		if( !Adyacencias[vertex].get(i).equals(null) &&
				Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex){
					Arista a = Adyacencias[vertex].get(i);
					a.modificarFlujo(nuevaCapacidad);
					Adyacencias[vertex].remove(i);
					Adyacencias[vertex].add(i,a);
		}			
	}
}
	
	public int consultarCosteArista(int vertex, int targetVertex)throws Exception{
		int i;
		boolean trobat = false;
		for (i = 0; i < Adyacencias[vertex].size() && !trobat; ++i){
			if( !Adyacencias[vertex].get(i).equals(null) &&
					Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex){
						return Adyacencias[vertex].get(i).consultarCoste();
			}			
		}
		return 0;
	}

	
	public void modificarCosteArista(int vertex, int targetVertex, int nuevoCoste)
		{
			
		int i;
		boolean trobat = false;
		for (i = 0; i < Adyacencias[vertex].size() && !trobat; ++i){
			if( !Adyacencias[vertex].get(i).equals(null) &&
					Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex){
						Arista a = Adyacencias[vertex].get(i);
						a.modificarFlujo(nuevoCoste);
						Adyacencias[vertex].remove(i);
						Adyacencias[vertex].add(i,a);
			}			
		}
	}
	
	
	//consulta num vertices
	public int consultarNumVertices(){
		return Adyacencias.length;
	}

	
	public int consultarNumAristasVertice(int vertex){
		return Adyacencias[vertex].size();
	}
	

}