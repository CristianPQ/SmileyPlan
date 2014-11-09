import java.util.*;
public class Grafo {

	//constructora
	ArrayList<ArrayList<Arista>> grafo;

	public Grafo(){
		grafo = new ArrayList<ArrayList<Arista>>();
	}
	
	public void vaciarGrafo(){
		for (int i = 0; i < grafo.size(); i++) grafo.get(i).clear();
	}
	
	public void anadirArista (int vertex, int targetVertex,
			int flow, int capacity, int cost){
		ArrayList<Arista> ar = new ArrayList<Arista>();
		grafo.add(ar);
		Arista a = new Arista(targetVertex, flow, capacity, cost);
		grafo.get(vertex).add(targetVertex, a);	
	}
	
	public void eliminarArista(int vertex, int targetVertex){
		grafo.get(vertex).remove(targetVertex);
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
	Arista a = grafo.get(vertex).get(targetVertex);
	return a.consultarFlujo();
	}

	public void modificarFlujoArista(int vertex, int targetVertex, int nuevoFlujo) {
		Arista a = grafo.get(vertex).get(targetVertex);
		a.modificarFlujo(nuevoFlujo);
		grafo.get(vertex).add(targetVertex, a);	
	}

	public int consultarCapacidadArista(int vertex, int targetVertex){
		Arista a = grafo.get(vertex).get(targetVertex);
		return a.consultarCapacidad();
			}

	public void modificarCapacidadArista(int vertex, int targetVertex, int nuevaCapacidad) {
		Arista a = grafo.get(vertex).get(targetVertex);
		a.modificarFlujo(nuevaCapacidad);
		grafo.get(vertex).add(targetVertex, a);	
	}

	public int consultarCosteArista(int vertex, int targetVertex){
		Arista a = grafo.get(vertex).get(targetVertex);
		return a.consultarCoste();

	}

	public void modificarCosteArista(int vertex, int targetVertex, int nuevoCoste) {
		Arista a = grafo.get(vertex).get(targetVertex);
		a.modificarCoste(nuevoCoste);
		grafo.get(vertex).add(targetVertex,a);
	}
	//consulta num vertices
	public int consultarNumVertices(){
		return grafo.size();
	}

	public int consultarNumAristasVertice(int vertex){
		return grafo.get(vertex).size();
	}

}