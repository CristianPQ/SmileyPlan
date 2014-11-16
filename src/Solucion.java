import java.util.*;

public class Solucion {
	
	private int tiempo;
	private int espacio; //???
	
	private ArrayList<ArrayList<Integer>> itinerarios; 
	//private ArrayList<Integer> capacidadIt; 
	private ArrayList<Integer> costeIt; 
	
	/**
	 * Agregar un vertice, o ciudad, en el itinerario
	 * @param i identificador del itinerario
	 * @param vertex vertice que sera una ciudad del itinerario
	 */
	public void agregarVertice(int i, int vertex){
		itinerarios.get(i).add(vertex); 
	}
	//la de Relabel s'haura de llegir al reves 
	
	
	/**
	 * Agregar el coste total de un itinerario
	 * @param i identificador del itinerario
	 * @param c coste
	 */
	public void agregarCosteAItinerario(int i, int c){
		itinerarios.get(i).add(c); 
	}
	
	/**
	 * Obtener el vertice de un cierto itinerario
	 * @param i identificador del itinerario
	 * @param posv posicion del vertice que queremos
	 * @return entero que equivale al identificador del vertice
	 */
	public int obtenVertice(int i, int posv) {
		return (itinerarios.get(i)).get(i); 
	}
	
	/**
	 * Obtener el numero de ciudades del itinerario
	 * @param i identificador del itinerario
	 * @return el numero de ciudades de dicho itinerario
	 */
	public int obtenNumCiudades(int i){
		return itinerarios.get(i).size(); 
	}
	
	/**
	 * devuelve el numero de itinerarios de solucion 
	 */
	public int obtenNumeroItinerarios(){
		return itinerarios.size(); 
	}
	
}
