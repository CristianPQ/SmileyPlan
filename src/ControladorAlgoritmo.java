import java.text.SimpleDateFormat;
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
	long tiempo; 
	
	
	
	public ControladorAlgoritmo(Entrada entrada) throws Exception{
		ent = entrada;
		//sol= new Solucion(); //esto puede cambiar
		
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
		//s = obtenerCiudadSalida();  
		//t = obtenerCiudadObjetivo(); 
		//int flow = null; 
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
		Date date = new Date();  
		long t1 = date.getTime(); 
		g = p.ejecutar(g, s, t, f); 
		tiempo = t1 - date.getTime();
		System.out.println(tiempo); 
	}
	
	
	//#########################################
	//########## Salida ##################
	//#########################################
	
	/**
	 * Asigna los itinerarios a los agentes 
	 * @throws Exception
	 */
	public void asignarItinerarioAAgente() throws Exception{
		int numAg = AgentesConSyT.size(); //numero de agentes para asignar
		int numIt = sol.obtenNumeroItinerarios(); 
		//cas no solucio?
		
		//cas falten o igual camins
		if(numIt <= numAg) {
			for(int i = 0; i < numAg; ++i) {
				String s = AgentesConSyT.get(i); 
				convertirItinerario(i,s); 
			}
		}
		//cas que sobren camins, mirem els de menys cost
		else if (numIt > numAg){ 
			int min = 1000; 
			int pos = 1000; 
			for(int i = 0; i < numAg; ++i){
				for(int j = 0; j < numIt; ++j){
					if(sol.obtenCoste(j) < min) {
						min = sol.obtenCoste(j);
						pos = j; 
					}
					sol.agregarCosteAItinerario(pos, 1000);//posem marca
					String s = AgentesConSyT.get(i); 
					convertirItinerario(i,s); 
				}
			}
		}
	}
	
	
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
	
	/**
	 * Guarda la sequencia del PushRelabel
	 * @param path
	 * @param filename
	 * @throws Exception
	 */
	public void guardarSeqPR(String path, String filename) throws Exception{
		GestorDatos gd = new GestorDatos(path,filename); 
		PushRelabel pr = new PushRelabel(); 
		
		//int n = pr.obtenerSeqSize(); 
		gd.createFile(); 
		gd.openFile("write"); 
		
		String buffer; 
		
		/*for(int i = 0; i < n; ++i) {
			buffer = pr.LeerSeq(i); 
			gd.writeBuffer(buffer); 
		}*/
		gd.closeFile(); 
	}
}
