import java.util.*;
public class ControladorAlgoritmo {
	private String[] relacCiudades;
	private Entrada ent;
	private Solucion sol;
	private ControladorItinerarios cit; 
	private GrafoAntiguo g; 
	private int flow; 
	private int s; 
	private int t; 
	private ArrayList<String > AgentesConSyT;
	private int NumAgentesConSyT;
	
	
	
	public ControladorAlgoritmo(Entrada entrada) throws Exception{
		ent = entrada;
		sol= new Solucion(); //esto puede cambiar
		
	}
	
	public GrafoAntiguo consultarGrafo(){
		return ent.consultarGrafo();
	}
	public void inicializarRelacCiudades(int size){
		relacCiudades = new String[size];
	}
	public void modificarRelacCiudad(String a, int i){
		relacCiudades[i] = a;
		}
	
	public String consultarElementRelacCiudades(int i){
		return relacCiudades[i];
	}
	
	public int consultarNumeroVertices(){
		return relacCiudades.length;
	}
	
	public int devolverIndiceCiudad(String city){
		int indice = -1;
		for (int i = 0; i < relacCiudades.length; ++i) 
			if (relacCiudades[i] == city) {indice = i; return indice;}
			return indice;
	}
	
	
	//#########################################
	//##########Entrada ##################
	//#########################################
	
	public void prepararEjecucion() {
		g = obtenerGrafo(); 
		s = obtenerCiudadSalida();  
		t = obtenerCiudadObjetivo(); 
		int flow = null; 
	}
	
	public GrafoAntiguo obtenerGrafo(){
		return ent.consultarGrafo(); 
	}
	
	public void ejecutarAlgoritmoFordFulkerson(GrafoAntiguo g, int s, int t) {
		FordFulkerson ff = new FordFulkerson(); 
		//g = ff.ejecutar(g,s,t,f); 	
	}
	
	public void ejecutarAlgoritmoPushRelabel(GrafoAntiguo g, int s, int t, int f) throws Exception{
		PushRelabel p = new PushRelabel(); 
		g = p.ejecutar(g, s, t, f); 
	}
	
	
	//#########################################
	//########## Salida ##################
	//#########################################
	
	/**
	 * Convierte una fila de la matriz solucion en un itinerario 
	 * del conjunto de itinerarios
	 * @param i fila que trabajamos, que equivale a un itinerario
	 * @param nombreAg, nombre identificador que tendra el itinerario
	 * @throws Exception si ya existe el nombre del itinerario
	 */
	public void convertirItinerario(int i, String nombreAg) throws Exception{
		int num = sol.obtenNumCiudades(i); 
		Itinerario it = cit.agregarItinerario(nombreAg); 
		for(int j = 0; j < num; ++j) {
			int v = sol.obtenVertice(i, j); 
			int w = sol.obtenVertice(i, j+1); 
			//buscar equivalencies int amb ciutat 
			String co = consultarElementRelacCiudades(v); 
			String cd = consultarElementRelacCiudades(w); 
			//convertir de ciutat v a ciutat w a cami
			Camino c = cit.crearCamino(co,cd); 
			//afegir cami 
			cit.agregarCaminoAlItinerario(it,c); 
		}
	}
	
	
	public void guardarSolucion(String path, String filename){}
}
