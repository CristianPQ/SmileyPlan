import java.util.*;

public class Solucion {
	
	private int tiempo;
	private int espacio; //???
	
	private ArrayList<Integer>[] itinerarios; 
	//private ArrayList<Integer> capacidadIt; 
	private int[] costeIt; 
	
	
	
	public Solucion(int numItinerarios){
		itinerarios = new ArrayList[numItinerarios];
		for(int i = 0; i < numItinerarios; ++i) itinerarios[i] = new ArrayList<Integer>();
		costeIt = new int[numItinerarios];	
	}
	
	/**
	 * Agregar un vertice, o ciudad, en el itinerario
	 * @param i identificador del itinerario
	 * @param vertex vertice que sera una ciudad del itinerario
	 */
	public void agregarVertice(int i, int vertex){
		itinerarios[i].add(vertex); 
	}
	//la de Relabel s'haura de llegir al reves 
	
	
	/**
	 * Agregar el coste total de un itinerario
	 * @param i identificador del itinerario
	 * @param c coste
	 */
	public void agregarCosteAItinerario(int i, int c){
		costeIt[i] = c; 
	}
	
	/**
	 * Obtener el vertice de un cierto itinerario
	 * @param i identificador del itinerario
	 * @param posv posicion del vertice que queremos
	 * @return entero que equivale al identificador del vertice
	 */
	public int obtenVertice(int i, int posv) {
		return itinerarios[i].get(posv); 
	}
	
	/**
	 * Obtener el numero de ciudades del itinerario
	 * @param i identificador del itinerario
	 * @return el numero de ciudades de dicho itinerario
	 */
	public int obtenNumCiudades(int i){
		return itinerarios[i].size(); 
	}
	
	/**
	 * devuelve el numero de itinerarios de solucion 
	 */
	public int obtenNumeroItinerarios(){
		return itinerarios.length; 
	}
	
}
