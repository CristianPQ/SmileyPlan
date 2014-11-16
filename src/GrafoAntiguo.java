import java.util.*;
public class GrafoAntiguo {

	//constructora
//	ArrayList<ArrayList<Arista>> grafo;

	private ArrayList<Arista>[] Adyacencias;
	private int numVertices;
	
	//private static Exception NoExiste = new Exception ("La adyacencia NO existe");


	
	public GrafoAntiguo(int numVertex){
		numVertices = numVertex;
		Adyacencias = new ArrayList[numVertices];
		for(int i = 0; i < numVertices; i++) Adyacencias[i] = new ArrayList<Arista>();
	}

	
	public ArrayList<Arista> consultarAdyacentes(int vertex){
		return Adyacencias[vertex];
	}

	public boolean existeAdyacente(int vertex, int targetVertex){
		for (int i = 0; i < Adyacencias[vertex].size();++i) 
			if (Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex) return true;
			return false;
	}
	
	public void anadirArista (int vertex, int targetVertex,
			int flow, int capacity, int cost){
		Arista a = new Arista(targetVertex, flow, capacity, cost);
		Adyacencias[vertex].add(a);
	}

	public void eliminarArista(int vertex, int targetVertex){
		int i = 0;
		boolean trobat = false;
		for (i = 0; i < Adyacencias[vertex].size() && !trobat; ++i){			
			if( !Adyacencias[vertex].get(i).equals(null) &&
					Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex){
					Adyacencias[vertex].remove(i);
				trobat = true;
			}
			
		}
	}
	
	
	public int consultarFlujoArista(int vertex, int targetVertex){
		int i;
		for (i = 0; i < Adyacencias[vertex].size(); ++i){
			if( !Adyacencias[vertex].get(i).equals(null) &&
					Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex){
						return Adyacencias[vertex].get(i).consultarFlujo();
			}			
		}
		return -1;
	}

	public void modificarFlujoArista(int vertex, int targetVertex, int nuevoFlujo) 
			{
		int i;
		for (i = 0; i < Adyacencias[vertex].size(); ++i){
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
		for (i = 0; i < Adyacencias[vertex].size(); ++i){
			if( !Adyacencias[vertex].get(i).equals(null) &&
					Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex){
						return Adyacencias[vertex].get(i).consultarCapacidad();
			}			
		}
		return -1;
	}


	public void modificarCapacidadArista(int vertex, int targetVertex, int nuevaCapacidad) 
			{
				
		int i;
		for (i = 0; i < Adyacencias[vertex].size(); ++i){
			if( !Adyacencias[vertex].get(i).equals(null) &&
					Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex){
						Arista a = Adyacencias[vertex].get(i);
						a.modificarCapacidad(nuevaCapacidad);
						Adyacencias[vertex].remove(i);
						Adyacencias[vertex].add(i,a);
			}			
		}
	}
	
	public int consultarCosteArista(int vertex, int targetVertex)throws Exception{
		int i;
		for (i = 0; i < Adyacencias[vertex].size(); ++i){
			if( !Adyacencias[vertex].get(i).equals(null) &&
					Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex){
						return Adyacencias[vertex].get(i).consultarCoste();
			}			
		}
		return -1;
	}

	
	public void modificarCosteArista(int vertex, int targetVertex, int nuevoCoste)
		{
		int i;
		for (i = 0; i < Adyacencias[vertex].size(); ++i){
			if( !Adyacencias[vertex].get(i).equals(null) &&
					Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex){
						Arista a = Adyacencias[vertex].get(i);
						a.modificarCoste(nuevoCoste);
						Adyacencias[vertex].remove(i);
						Adyacencias[vertex].add(i,a);

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
	//consulta num vertices
	public int consultarNumVertices(){
		return numVertices;
	}

	public int consultarNumAristasVertice(int vertex){
		return Adyacencias[vertex].size();
	}
	

}