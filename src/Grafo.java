import java.util.*;
public class Grafo {

	//constructora
//	ArrayList<ArrayList<Arista>> grafo;

	TST<Arista> grafo[];
	int numVertices;
	int numAdyacencias[];
	
	private static Exception NoExiste = new Exception ("La adyacencia NO existe");


	
	public Grafo(int numVertex){
		numVertices = numVertex;
		for(int i = 0; i < numVertices; ++i){
			grafo[i] = new TST<Arista>();
			numAdyacencias[i] = 0;
		}
		
	}
	
	public void vaciarGrafo(){
		for (int i = 0; i < numVertices; i++) grafo[i].makeEmpty();
	}
	
	public boolean existeAdyacencia(int vertex, int targetVertex){
		return grafo[vertex].existe(Integer.toString(targetVertex));
	}
	
	public void anadirArista (int vertex, int targetVertex,
			int flow, int capacity, int cost){
		Arista a = new Arista(targetVertex, flow, capacity, cost);
		grafo[vertex].insert(a);
		numAdyacencias[vertex]++;
	}
	
	public void eliminarArista(int vertex, int targetVertex){
		grafo[vertex].delete(Integer.toString(targetVertex));
		numAdyacencias[vertex]--;
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
	
	public int consultarFlujoArista(int vertex, int targetVertex) throws Exception{
		if(existeAdyacencia(vertex,targetVertex)){
			Arista a = grafo[vertex].consultar(Integer.toString(targetVertex));
			return a.consultarFlujo();
		}
		else throw NoExiste;
	}

	public void modificarFlujoArista(int vertex, int targetVertex, int nuevoFlujo) 
			throws Exception{
			
			if (existeAdyacencia(vertex, targetVertex)){
				Arista a = grafo[vertex].consultar(Integer.toString(targetVertex));
				a.modificarFlujo(nuevoFlujo);
				grafo[vertex].delete(Integer.toString(targetVertex));
				grafo[vertex].insert(a);	
				}
				else throw NoExiste;
			}

	
	public int consultarCapacidadArista(int vertex, int targetVertex) throws Exception{
		if(existeAdyacencia(vertex,targetVertex)){
			Arista a = grafo[vertex].consultar(Integer.toString(targetVertex));
			return a.consultarCapacidad();
		}
		else throw NoExiste;
	}


	public void modificarCapacidadArista(int vertex, int targetVertex, int nuevaCapacidad) 
				throws Exception{
				
		if (existeAdyacencia(vertex, targetVertex)){
				Arista a = grafo[vertex].consultar(Integer.toString(targetVertex));
				a.modificarFlujo(nuevaCapacidad);
				grafo[vertex].delete(Integer.toString(targetVertex));
				grafo[vertex].insert(a);	
				}
		
		else throw NoExiste;
		}
	
	public int consultarCosteArista(int vertex, int targetVertex)throws Exception{
		if(existeAdyacencia(vertex,targetVertex)){
			Arista a = grafo[vertex].consultar(Integer.toString(targetVertex));
			return a.consultarCoste();
		}
		else throw NoExiste;
	}

	
	public void modificarCosteArista(int vertex, int targetVertex, int nuevoCoste) throws Exception{
		if (existeAdyacencia(vertex, targetVertex)){
			Arista a = grafo[vertex].consultar(Integer.toString(targetVertex));
			a.modificarFlujo(nuevoCoste);
			grafo[vertex].delete(Integer.toString(targetVertex));
			grafo[vertex].insert(a);	
			}
	
		else throw NoExiste;
	}
	
	
	//consulta num vertices
	public int consultarNumVertices(){
		return numVertices;
	}

	public int consultarNumAristasVertice(int vertex){
		return numAdyacencias[vertex];
	}

}