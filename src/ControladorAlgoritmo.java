
import java.util.*;

public class ControladorAlgoritmo {
	private ArrayList<String> relacCiudades;
	private Entrada ent;
	private Solucion sol;
	private ControladorItinerarios cit;
	private ArrayList<String > agentes;
	long tiempo; 
	
	
	
	public ControladorAlgoritmo(ControladorAgentes ca, ControladorMapa cm, 
			ControladorMedioTransporte mt, String cOrig, String cDest) throws Exception{
		relacCiudades = cm.listarCiudades();
		int orig = consultarIntCiudad(cOrig);
		int dest = consultarIntCiudad(cDest);
		GrafoAntiguo g = crearGrafo(cm, mt);
		int nAgent = ca.numeroAgentesOrigenObjetivo(cOrig, cDest);
		ent = new Entrada(g, orig, dest, nAgent);
		cit = new ControladorItinerarios();
		agentes = ca.consultarAgentesOrigenObjetivo(cOrig, cDest);
		sol = new Solucion(nAgent);
	}
	
	public void EjecutarGrafo(int i) {
		
	}
	
	private int consultarIntCiudad(String c) {
		int i;
		for(i = 0; i < relacCiudades.size(); ++i) {
			if(relacCiudades.get(i).equals(c)) return i;
		}
		return -1;
	}
	

	//#########################################
	//##########Entrada ##################
	//#########################################

	
	//#########################################
	//########## MAPEADO ##################
	//#########################################
	

	
	
	
	
	//#########################################
	//########## CREACION GRAFO ################
	//#########################################
	
	private GrafoAntiguo crearGrafo(ControladorMapa m, ControladorMedioTransporte mt) throws Exception {
		GrafoAntiguo g = new GrafoAntiguo(relacCiudades.size());
		for(int i = 0; i < relacCiudades.size(); ++i) {
			String cOrig = relacCiudades.get(i);
			ArrayList<Camino> listCam = m.consultarCaminosDestino(cOrig);
			Iterator<Camino> it = listCam.iterator();
			while(it.hasNext()) {
				Camino c = it.next();
				String cDest = c.consultarDestino();
				String medioT = c.consultarTransporte();
				int cap = c.consultarCapacidad();
				int coste = mt.getPrecioTransporte(medioT)*m.distanciaCiudades(cOrig, cDest);
				int iDest =consultarIntCiudad(cDest); 
				g.anadirArista(i, iDest, 0, cap, coste);
			}
		}
		return g;
	}
	
	//#########################################
	//########## ALGORITMOS ################
	//#########################################

	public void ejecutarAlgoritmoFordFulkerson() throws Exception {
		FordFulkerson ff = new FordFulkerson(); 
		sol = ff.ejecutar(ent);	
	}
	
	public void ejecutarAlgoritmoPushRelabel() throws Exception{
		PushRelabel p = new PushRelabel(); 
		sol = p.ejecutar(ent);
	}
	
	
	//#########################################
	//########## SALIDA ##################
	//#########################################
	
	/**
	 * Asigna los itinerarios a los agentes 
	 * @throws Exception
	 */
	public void asignarItinerarioAAgente() throws Exception{
		int numAg = agentes.size(); //numero de agentes para asignar
		int numIt = sol.obtenNumeroItinerarios(); 
		//cas no solucio?
		
		//cas falten o igual camins
		if(numIt <= numAg) {
			for(int i = 0; i < numAg; ++i) {
				String s = agentes.get(i); 
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
					String s = agentes.get(i); 
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
		ArrayList<String> listaciudades = new ArrayList<String>();	
		for(int j = 0; j < num; ++j) {
			int v = sol.obtenVertice(i, j); 
			String c = relacCiudades.get(v); 
			listaciudades.add(c);
		}
		cit.agregarItinerario(nombreAg,listaciudades); 
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
		
		gd.createFile(); 
		gd.openFile("write"); 
		
		String buffer; 
		
		ArrayList<String> guardaseq = pr.obtenSeq(); 
		int n = guardaseq.size(); 
		
		for(int i = 0; i < n; ++i) {
			buffer = guardaseq.get(i); 
			gd.writeBuffer(buffer); 
		}
		gd.closeFile(); 
	}
}
