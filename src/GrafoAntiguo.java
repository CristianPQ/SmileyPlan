import java.util.*;
public class GrafoAntiguo {

	//constructora
//	ArrayList<ArrayList<Arista>> grafo;

	private ArrayList<Arista>[] Adyacencias;
	private int numVertices;
	
	private static Exception NoExiste = new Exception ("La adyacencia NO existe");
	private static Exception Existe = new Exception ("Ya existe");
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
	 * @return la lista de aristas de salida que tiene ese vertice
	 */
	public ArrayList<Arista> consultarAdyacentes(int vertex){
		return Adyacencias[vertex];
	}
	
	/**
	 * Consulta si existe un vertice adyacente a vertex 
	 * @param vertex
	 * @param targetVertex
	 * @return booleano que indica si existe esa arista o no
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
	public void anadirArista (int vertex, int targetVertex, int flow, int capacity, int cost) throws Exception{
		
		if(existeAdyacente(vertex,targetVertex)) throw Existe;
		
		Arista a = new Arista(targetVertex, flow, capacity, cost);
		Adyacencias[vertex].add(a);
	}

	/**
	 * Elimina una arista del vertice vertex 
	 * @param vertex
	 * @param targetVertex
	 * @throws Exception si no existe
	 */
	public void eliminarArista(int vertex, int targetVertex) throws Exception{
		if (existeAdyacente(vertex, targetVertex)){
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
		else throw NoExiste;
	}
	
	
	/**
	 * Consultora del flujo de una arista del vertice vertex 
	 * @param vertex
	 * @param targetVertex
	 * @return flujo de la arista solicitada
	 * @throws Exception si no existe
	 */
	public int consultarFlujoArista(int vertex, int targetVertex) throws Exception{
		int i;
		for (i = 0; i < Adyacencias[vertex].size(); ++i){
			if( !Adyacencias[vertex].get(i).equals(null) &&
					Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex){
						return Adyacencias[vertex].get(i).consultarFlujo();
				}			
			}
		throw NoExiste;
		}	


	/**
	 * Modificadora del flujo de la arista entre vertex y targetVertex
	 * @param vertex
	 * @param targetVertex
	 * @param nuevoFlujo
	 * @throws Exception si no existe
	 */
	public void modificarFlujoArista(int vertex, int targetVertex, int nuevoFlujo) throws Exception{
		if(existeAdyacente(vertex, targetVertex)){
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
		else throw NoExiste;
	}


	/**
	 * Consultora de la capacidad de la arista entre vertex y targetVertex
	 * @param vertex
	 * @param targetVertex
	 * @return capacidad de la arista solicitada
	 * @throws Exception si no existe
	 */
	public int consultarCapacidadArista(int vertex, int targetVertex) throws Exception {
		int i;
		for (i = 0; i < Adyacencias[vertex].size(); ++i){
			if( !Adyacencias[vertex].get(i).equals(null) &&
					Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex){
						return Adyacencias[vertex].get(i).consultarCapacidad();
				}			
			}
		throw NoExiste;
		}	

	/**
	 * Modificadora de la capacidad de la arista entre vertex y targetVertex
	 * @param vertex
	 * @param targetVertex
	 * @param nuevaCapacidad
	 * @throws Exception si no existe
	 */
	public void modificarCapacidadArista(int vertex, int targetVertex, int nuevaCapacidad) throws Exception{
		if(existeAdyacente(vertex, targetVertex)){
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
		else throw NoExiste;
	}
	
	/**
	 * Consultora del coste de la artista entre vertex y targetVertex
	 * @param vertex
	 * @param targetVertex
	 * @return Coste de la arista solicitada
	 * @throws Exception si no existe
	 */
	public int consultarCosteArista(int vertex, int targetVertex) throws Exception {
		int i;
		for (i = 0; i < Adyacencias[vertex].size(); ++i){
			if( !Adyacencias[vertex].get(i).equals(null) &&
					Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex){
						return Adyacencias[vertex].get(i).consultarCoste();
				}			
			}
		throw NoExiste;
		}	

	
	/**
	 * Modificadora de la arista que se encuentra entre vertex y targetVertex
	 * @param vertex
	 * @param targetVertex
	 * @param nuevoCoste
	 * @throws Exception si no existe
	 */
	public void modificarCosteArista(int vertex, int targetVertex, int nuevoCoste) throws Exception {
		if(existeAdyacente(vertex, targetVertex)){
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
		else throw NoExiste;
	}
	


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