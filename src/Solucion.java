import java.util.*;

public class Solucion {
	//private GrafoAntiguo g;
	private double tiempo;
	private boolean tieneSolucion; //falso si no la tiene true en caso contrario
	
	private ArrayList<Integer>[] itinerarios; 
	private ArrayList<Integer> seguimiento;
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
		seguimiento = new ArrayList<Integer>();
		for(int i = 0; i < numItinerarios; ++i) itinerarios[i] = new ArrayList<Integer>();
		costeIt = new int[numItinerarios];	
		tieneSolucion = false;
	}
	
	/**
	 * Agregar un vertice, o ciudad, en el itinerario
	 * @param i identificador del itinerario
	 * @param vertex vertice que sera una ciudad del itinerario
	 */
	public void agregarVertice(int i, int vertex){
		itinerarios[i].add(vertex); 
	}
	public void agregarVerticeSeguimiento(int vertex){
		seguimiento.add(vertex); 
	}
	//la de Relabel s'haura de llegir al reves 
	public int consultarNumSeguimiento(){
		return seguimiento.size();
	}
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
	
	/**
	 * Obtener el vertice de un cierto itinerario
	 * @param i identificador del itinerario
	 * @param posv posicion del vertice que queremos
	 * @return entero que equivale al identificador del vertice
	 */
	public int obtenVertice(int i, int posv) {
		return itinerarios[i].get(posv); 
	}
	
	public int obtenVerticeSeguimiento(int posv) {
		return seguimiento.get(posv); 
	}
	
	
	
	public String subirSeg(ControladorMapa cm){
		ArrayList<String> seg = simplificaSeg(cm);
		String buff = null; 
		if(seg.isEmpty()) return buff;
		String linea = seg.get(0) + ' ';
		buff = linea;
		for (int i = 1; i < seg.size(); ++i){
			linea = seg.get(i) + ' ';
			buff = buff + linea;
		}
		
		return buff;
		
	}
	
	
	
	private ArrayList<String> simplificaSeg(ControladorMapa cm){
		ArrayList<String> simple = new ArrayList<String>();
		ArrayList<String> rem = reMap(cm);
		
	
		for(int i = 0; i < rem.size(); i = i + 2){
			if(!rem.get(i).equals(rem.get(i+1))) {		
				simple.add(rem.get(i));
				simple.add(rem.get(i+1));
			}
		}
		//System.out.println(" ");
		//for (int w = 0; w < simple.size(); ++w) System.out.println(simple.get(w) + " ");
		
		
		return simple;
	}
	

	private ArrayList<String> reMap(ControladorMapa cm){
		ArrayList<String> res = new ArrayList<String>();
		String[] map = cm.consultarMapping();
		for(int i = 0; i < seguimiento.size(); ++i ){
			res.add(map[seguimiento.get(i)]);
		}
		/*for (int j = 0; j < map.length; ++j) System.out.println(map[j] + " ");
		System.out.println(" ");
		for (int w = 0; w < res.size(); ++w) System.out.println(res.get(w) + " ");
		*/
		return res;
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
