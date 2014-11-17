import java.util.*;

public class Solucion {
	private GrafoAntiguo g;
	private double tiempo;
	private int espacio; //???
	private boolean tieneSolucion = false; //falso si no la tiene true en caso contrario
	
	private ArrayList<Integer>[] itinerarios; 
	//private ArrayList<Integer> capacidadIt; 
	private int[] costeIt; 
	
	public ArrayList< String > seqsol = new ArrayList<String>(); 
	
	
	
	 /**
		 * Devuelve una arrayList con la sequencia de pasos que ha seguido 
		 * el algorismo
		 * @return seq
		 */
		public ArrayList<String> obtenSeq() {
			//System.out.println("dins sol " +seqsol.size() + "\n");
			return seqsol; 
		} 
		
	
	/**
	 * Creadora de solucion
	 * @param numItinerarios 
	 */
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
	 * Consultador del numero de Itinerarios
	 * @return numero de itinerarios
	 */
	public int consultarNumItinerarios(){
		return itinerarios.length;
	}
	/**
	 * Agregar el coste total de un itinerario
	 * @param i identificador del itinerario
	 * @param c coste
	 */
	public void agregarCosteAItinerario(int i, int c){
		costeIt[i] = c; 
	}
	
	/**
	 * Devuelve el coste del itinerario i
	 * @param i identificador itinerario
	 * @return coste
	 */
	public double consultarTiempo(){
		return tiempo;
	}
	
	/**
	 * Modificadora del tiempo
	 * @param t
	 */
	public void modificarTiempo(double t){
		tiempo = t;
	}
	
	/**
	 * Consultora del coste de un itinerario
	 * @param i
	 * @return
	 */
	public int obtenCoste(int i){
		return costeIt[i]; 
	}
	
	/**
	 * Consultora que devuelve si la ejecucion con dicho algoritmo
	 * tiene solucion
	 * @return
	 */
	public boolean consultarTieneSolucion(){
		return tieneSolucion;
	}
	
	/**
	 * Modificadora del parametro tieneSolucion
	 * @param s booleano
	 */
	public void modificartieneSolucion(boolean s){
		tieneSolucion = s;
	}
	
	/**
	 * Modificadora del grafo
	 * @param g2 grafo nuevo 
	 */
	public void modificarGrafo(GrafoAntiguo g2){
		g = g2;
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
