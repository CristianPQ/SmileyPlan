import java.util.*;
public class ControladorAlgoritmo {
	private String[] relacCiudades;
	private Entrada ent;
	private Solucion sol;
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
	
	public void prepararEjecucion() {
		g = obtenerGrafo(); 
		s = obtenerCiudadSalida();  //s'ha de crear una funcio per aquestes
		t = obtenerCiudadObjetivo(); //que vagi a entrada 
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
	

	
	public void guardarSolucion(String path, String filename){}
}
