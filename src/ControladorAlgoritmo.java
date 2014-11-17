import java.text.SimpleDateFormat;
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
	
	private int consultarIntCiudad(String c) {
		int i;
		for(i = 0; i < relacCiudades.size(); ++i) {
			if(relacCiudades.get(i).equals(c)) return i;
		}
		return -1;
	}
	
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
	//##########Entrada ##################
	//#########################################
	
	public void prepararEjecucion() {
		g = consultarGrafo(); 
		//s = obtenerCiudadSalida();  
		//t = obtenerCiudadObjetivo(); 
		//int flow = null; 
	}
	

	public int consultarOrigen(){
		return s;
	}
	
	public int consultarDestino(){
		return t;
	}
	
	public int consultarNumAgentes(){
		return NumAgentesConSyT;
	}
	
	//#########################################
	//########## MAPEADO ##################
	//#########################################
	
	/*public void insertarCiudadesMapping( Mapa m) throws Exception{
		int i;
		int donde_guardo = 0;
		ArrayList<String> mapeo = new ArrayList<String>();

		for (i = 0; i < m.listarCiudades().size();++i){ //per cada ciutat
			int necesito = 1;
			for (int j = 0; j < m.listarCiudades().size(); ++j){ 
				//per cada ciutat possiblement adjacent a la ciutat (i)
				
				if (j != i){	//consultar caminos (i,j) 	
					ArrayList<Camino> Caminos = m.consultarCaminosEntre(m.listarCiudades().get(i), m.listarCiudades().get(j));		
					if (!Caminos.equals(null) && Caminos.size() > necesito ) necesito = Caminos.size();							
				}
			}
			
			for (int w = donde_guardo; w < (donde_guardo + necesito); ++w) mapeo.add(m.listarCiudades().get(i));
			donde_guardo += necesito;
		}
		
		relacCiudades = new String[mapeo.size()];
		for (int z = 0; z < mapeo.size(); ++z) relacCiudades[z] = mapeo.get(z);
	}*/

	
	


	public int returnCityIndex(String city){
		int indice = -1;
		for (int i = 0; i < relacCiudades.length; ++i) 
			if (relacCiudades[i].equals(city)) {indice = i; return indice;}
			return indice;
	}


	
	
	
	
	//#########################################
	//########## CREACION GRAFO ################
	//#########################################	
	
	
	public void crearGrafo(ControladorMapa m, ControladorAlgoritmo ca, ControladorMedioTransporte cm)throws Exception{
		g = new GrafoAntiguo(ca.consultarNumeroVertices()); //init grafo
		ArrayList<Camino> aristando;
		for (int i = 0; i < m.listarCiudades().size(); ++i){ //cada ciudad del mapa
			aristando = m.consultarCaminosDestino(m.listarCiudades().get(i)); //consultar ciudades adyacentes
			for (int j = 0; j < aristando.size(); ++j){ //cada ciudad adyacente...
				////////////////PREPARAR LA ARISTA
				int targetVertex  = returnCityIndex(aristando.get(j).consultarDestino());
				int capacity = aristando.get(i).consultarCapacidad();
				////////CALCULO TEMA COSTE
				MedioTransporte mtrans = cm.buscarMedio(aristando.get(j).consultarTransporte());
				int x1 = m.consultarCiudad(m.listarCiudades().get(i)).consultarCoordenadas().consultarX();
				int y1 =  m.consultarCiudad(m.listarCiudades().get(i)).consultarCoordenadas().consultarY();
				int x2 = m.consultarCiudad(aristando.get(j).consultarDestino()).consultarCoordenadas().consultarX();
				int y2 = m.consultarCiudad(aristando.get(j).consultarDestino()).consultarCoordenadas().consultarY();
				int x; int y;
				if (x1 > x2) x= x1-x2; else x = x2-x1;
				if (y1 > y2) y= y1-y2; else y = y2-y1;
				int cost = (x + y)* mtrans.getPrecio(); //REVISAR ESTO
				///////////////////////
				
				int insert_here = 0;
				boolean insertado = false;
				while (!insertado){
					if (!g.existeAdyacente(ca.devolverIndiceCiudad(m.listarCiudades().get(i)) + insert_here, targetVertex)){
						insertado = true;
						g.anadirArista(i,targetVertex, 0, capacity, cost);}
					++insert_here;
				}
				
				for (int d = 0; d < insert_here; ++d) 
					g.anadirArista(returnCityIndex(m.listarCiudades().get(i)) + d, 
							returnCityIndex(m.listarCiudades().get(i)) +1, 0, 2147483647, 0);
					
				}
			}
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
