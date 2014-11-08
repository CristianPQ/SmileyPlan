import java.util.*;
public class Grafo {

	//constructora
	ArrayList<Arista> grafo;

	public Grafo(){
		grafo = new ArrayList<Arista>();
	}
	
	public void vaciarGrafo(){
		grafo.clear();
	}
	
	public void anadirArista (int vertex, int targetVertex,
			int flow, int capacity, int cost){
		Arista a = new Arista();
		a.modificarVerticeDestino(targetVertex);
		a.modificarCapacidad(capacity);
		a.modificarFlujo(flow);
		a.modificarCoste(cost);
		grafo.add(vertex, a);	
	}
	
	public void eliminarArista(int vertex){
		grafo.remove(vertex);
	}
	
	public int consultarVerticeDestinoArista
		(int vertex){
			Arista a = grafo.get(vertex);
			return a.consultarVerticeDestino();
	}

	public void modificarVerticeDestinoArista
		(int vertex, int nuevoFlujo) {
			Arista a = grafo.get(vertex);
			a.modificarVerticeDestino(nuevoFlujo);
			grafo.add(vertex,a);
	}
	
	public int consultarFlujoArista(int vertex){
	Arista a = grafo.get(vertex);
	return a.consultarFlujo();
	
	}

	public void modificarFlujoArista(int vertex, int nuevoFlujo) {
		Arista a = grafo.get(vertex);
		a.modificarFlujo(nuevoFlujo);
		grafo.add(vertex,a);
	}

	public int consultarCapacidadArista(int vertex){
		Arista a = grafo.get(vertex);
		return a.consultarCapacidad();
	
	}

	public void modificarCapacidadArista(int vertex, int nuevaCapacidad) {
		Arista a = grafo.get(vertex);
		a.modificarCapacidad(nuevaCapacidad);
		grafo.add(vertex,a);
	}

	public int consultarCosteArista(int vertex){
		Arista a = grafo.get(vertex);
		return a.consultarCoste();
	
	}

	public void modificarCosteArista(int vertex, int nuevoCoste) {
		Arista a = grafo.get(vertex);
		a.modificarCoste(nuevoCoste);
		grafo.add(vertex,a);
	}
	//getter num vertices
	public int consultarNumVertices(){
		return grafo.size();
	}

}