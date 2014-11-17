import java.util.*;
public class GrafoAntiguo {

	//constructora
//	ArrayList<ArrayList<Arista>> grafo;

	private ArrayList<Arista>[] Adyacencias;
	private int numVertices;
	
	//private static Exception NoExiste = new Exception ("La adyacencia NO existe");


	/**
	 * Constructora del grafo
	 * @param numVertex que tendra el grafo
	 */
	public GrafoAntiguo(int numVertex){
		numVertices = numVertex;
		Adyacencias = new ArrayList[numVertices];
		for(int i = 0; i < numVertices; i++) Adyacencias[i] = new ArrayList<Arista>();
	}

	/**
	 * Devuelve un array con los vertices adyacentes a vertex
	 * @param vertex
	 * @return
	 */
	public ArrayList<Arista> consultarAdyacentes(int vertex){
		return Adyacencias[vertex];
	}
	
	/**
	 * Consulta si existe un vertice adyacente a vertex 
	 * @param vertex
	 * @param targetVertex
	 * @return
	 */
	public boolean existeAdyacente(int vertex, int targetVertex){
		for (int i = 0; i < Adyacencias[vertex].size();++i) 
			if (Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex) return true;
			return false;
	}
	
	/**
	 * Agrega una arista al vertice vertex 
	 * @param vertex
	 * @param targetVertex
	 * @param flow
	 * @param capacity
	 * @param cost
	 */
	public void anadirArista (int vertex, int targetVertex,
			int flow, int capacity, int cost){
		Arista a = new Arista(targetVertex, flow, capacity, cost);
		Adyacencias[vertex].add(a);
	}

	/**
	 * Elimina una arista del vertice vertex 
	 * @param vertex
	 * @param targetVertex
	 */
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
	
	
	/**
	 * Consultora del flujo de una arista del vertice vertex 
	 * @param vertex
	 * @param targetVertex
	 * @return
	 */
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

	/**
	 * Modificadora del flujo de la arista entre vertex y targetVertex
	 * @param vertex
	 * @param targetVertex
	 * @param nuevoFlujo
	 */
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


	/**
	 * Consultora de la capacidad de la arista entre vertex y targetVertex
	 * @param vertex
	 * @param targetVertex
	 * @return
	 */
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

	/**
	 * Modificadora de la capacidad de la arista entre vertex y targetVertex
	 * @param vertex
	 * @param targetVertex
	 * @param nuevaCapacidad
	 */
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
	
	/**
	 * Consultora del coste de la artista entre vertex y targetVertex
	 * @param vertex
	 * @param targetVertex
	 * @return
	 * @throws Exception
	 */
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

	
	/**
	 * Modificadora de la arista que se encuentra entre vertex y targetVertex
	 * @param vertex
	 * @param targetVertex
	 * @param nuevoCoste
	 */
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
	/**
	 * Consultora del numero de vertices 
	 * @return
	 */
	public int consultarNumVertices(){
		return numVertices;
	}
	
	/**
	 * Consultora del numero de aristas del vertice vertex 
	 * @param vertex
	 * @return
	 */
	public int consultarNumAristasVertice(int vertex){
		return Adyacencias[vertex].size();
	}
	

}