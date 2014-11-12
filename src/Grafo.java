import java.util.ArrayList;
import java.util.List;
public class Grafo {

	//constructora
//	ArrayList<ArrayList<Arista>> grafo;

	List <ArrayList<Arista> > Adyacencias;
	int numVertices;
	
	//private static Exception NoExiste = new Exception ("La adyacencia NO existe");


	
	public Grafo(int numVertex){
		Adyacencias = new ArrayList<ArrayList<Arista>>();
		numVertices = numVertex;
		for (int i = 0; i < numVertex; ++i) Adyacencias.add(new ArrayList<Arista>());

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

	public ArrayList <Arista> consultarAdyacentes(int vertex){
		return Adyacencias.get(vertex);
	}

	public void anadirArista (int vertex, int targetVertex,
			int flow, int capacity, int cost){
		Arista a = new Arista(targetVertex, flow, capacity, cost);
		ArrayList<Arista> l = Adyacencias.get(vertex);
		l.add(a);
		Adyacencias.remove(vertex);
		Adyacencias.add(vertex, l);		
		}

	public void eliminarArista(int vertex, int targetVertex){
		int i;
		boolean trobat = false;
		ArrayList<Arista> l = Adyacencias.get(vertex);
		for (i = 0; i < l.size() && !trobat; ++i){
			if( !l.get(i).equals(null) &&
					l.get(i).consultarVerticeDestino() == targetVertex){
					l.remove(i);
					Adyacencias.remove(vertex);
					Adyacencias.add(vertex, l);
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
		ArrayList<Arista> l = Adyacencias.get(vertex);
		for (i = 0; i < l.size() && !trobat; ++i){
			if( !l.get(i).equals(null) &&
					l.get(i).consultarVerticeDestino() == targetVertex){
						return l.get(i).consultarFlujo();
			}			
		}
		return -1;
	}

	public void modificarFlujoArista(int vertex, int targetVertex, int nuevoFlujo){ 
	int i;
	boolean trobat = false;
	ArrayList<Arista> l = Adyacencias.get(vertex);
	for (i = 0; i < l.size() && !trobat; ++i){
		if( !l.get(i).equals(null) &&
				l.get(i).consultarVerticeDestino() == targetVertex){
					Arista a = l.get(i);
					a.modificarFlujo(nuevoFlujo);
					l.remove(i);
					l.add(i,a);
					Adyacencias.remove(i);
					Adyacencias.add(l);
		}			
	}
}

	
	public int consultarCapacidadArista(int vertex, int targetVertex) {
		int i;
		boolean trobat = false;
		ArrayList<Arista> l = Adyacencias.get(vertex);
		for (i = 0; i < l.size() && !trobat; ++i){
			if( !l.get(i).equals(null) &&
					l.get(i).consultarVerticeDestino() == targetVertex){
						return l.get(i).consultarCapacidad();
			}			
		}
		return -1;
	}



	public void modificarCapacidadArista(int vertex, int targetVertex, int nuevaCapacidad) {
		int i;
		boolean trobat = false;
		ArrayList<Arista> l = Adyacencias.get(vertex);
		for (i = 0; i < l.size() && !trobat; ++i){
			if( !l.get(i).equals(null) &&
					l.get(i).consultarVerticeDestino() == targetVertex){
						Arista a = l.get(i);
						a.modificarCapacidad(nuevaCapacidad);
						l.remove(i);
						l.add(i,a);
						Adyacencias.remove(i);
						Adyacencias.add(l);
			}			
		}
	}
	
	public int consultarCosteArista(int vertex, int targetVertex)throws Exception{
		int i;
		boolean trobat = false;
		ArrayList<Arista> l = Adyacencias.get(vertex);
		for (i = 0; i < l.size() && !trobat; ++i){
			if( !l.get(i).equals(null) &&
					l.get(i).consultarVerticeDestino() == targetVertex){
						return l.get(i).consultarCoste();
			}			
		}
		return -1;
	}


	
	public void modificarCosteArista(int vertex, int targetVertex, int nuevoCoste)
		{
			
		int i;
		boolean trobat = false;
		ArrayList<Arista> l = Adyacencias.get(vertex);
		for (i = 0; i < l.size() && !trobat; ++i){
			if( !l.get(i).equals(null) &&
					l.get(i).consultarVerticeDestino() == targetVertex){
						Arista a = l.get(i);
						a.modificarCoste(nuevoCoste);
						l.remove(i);
						l.add(i,a);
						Adyacencias.remove(i);
						Adyacencias.add(l);
			}			
		}
	}
	
	
	
	//consulta num vertices
	public int consultarNumVertices(){
		return Adyacencias.size();
	}

	
	public int consultarNumAristasVertice(int vertex){
		ArrayList<Arista> l = Adyacencias.get(vertex);
		return l.size();
	}
	

}