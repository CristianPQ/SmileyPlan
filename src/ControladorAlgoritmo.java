
import java.util.*;

public class ControladorAlgoritmo {
	private String[] mapping;
	private Entrada ent;
	private Solucion sol;
	private ControladorItinerarios cit;
	private ArrayList<String > agentes;
	long tiempo; 
	
	public String[] consultarMapping(){
		return mapping;
	}

	public int consultarNumVertices(){
		return mapping.length;
	}
	
	public int returnCityIndex(String city){
		int indice = -1;
		for (int i = 0; i < mapping.length; ++i) 
			if (mapping[i].equals(city)) {indice = i; return indice;}
			return indice;
	}
	
	public ControladorAlgoritmo(ControladorAgentes ca, ControladorMapa cm, 
			ControladorMedioTransporte mt, String cOrig, String cDest) throws Exception{
		//#########################################
		//########## MAPEADO ##################
		//#########################################
		int i;

		ArrayList<String> mapeo = new ArrayList<String>();

		for (i = 0; i < cm.listarCiudades().size();++i){ //per cada ciutat
			int necesito = 1;
			for (int j = 0; j < cm.listarCiudades().size(); ++j){ 
				//per cada ciutat possiblement adjacent a la ciutat (i)					
					
			if (j != i){//hacer a ver si existen caminos para EVITAR EXCEPCIONES
					//consultar caminos (i,j) 	
					if(cm.existeCaminoDesdeA(cm.listarCiudades().get(i), cm.listarCiudades().get(j))){
							
						ArrayList<Camino> Caminos = cm.consultarCaminosEntre(cm.listarCiudades().get(i), cm.listarCiudades().get(j));
						if (!Caminos.equals(null) && Caminos.size() > necesito ) necesito = Caminos.size();
						}
					}
				}
			int w = 0;
			while (w < necesito) { //porque a lo mejor necesito + vertices!
				mapeo.add(cm.listarCiudades().get(i));
				++w;
			}
		}
			
		mapping = new String[mapeo.size()];
		for (int z = 0; z < mapeo.size(); ++z) mapping[z] = mapeo.get(z);
		
		//#########################################
		//########## FIN MAPEADO ##################
		//#########################################
	
		int orig = returnCityIndex(cOrig);
		int dest = returnCityIndex(cDest);
		GrafoAntiguo g = crearGrafo(cm, mt);
		int nAgent = ca.numeroAgentesOrigenObjetivo(cOrig, cDest);
		ent = new Entrada(g, orig, dest, nAgent);
		cit = new ControladorItinerarios();
		agentes = ca.consultarAgentesOrigenObjetivo(cOrig, cDest);
		sol = new Solucion(nAgent);
	}
	
	/////////FIN CONSTRUCTORA////////////////////////////
	
	public ControladorItinerarios consultarItinerarios() {
		return cit;
	}
	
	public void EjecutarGrafo(int i) {
		
	}


	//#########################################
	//########## CREACION GRAFO ################
	//#########################################
	private GrafoAntiguo crearGrafo(ControladorMapa m, ControladorMedioTransporte mt) throws Exception{
		GrafoAntiguo g = new GrafoAntiguo(mapping.length); //init grafo		
		ArrayList<Camino> aristando;
		for (int i = 0; i < m.listarCiudades().size(); ++i){//cada ciudad del mapa
			aristando = new ArrayList<Camino>();

			String ciudadEncontrandoAristas = m.listarCiudades().get(i);
			if(m.existeCaminoConOrigen(ciudadEncontrandoAristas))
			aristando = m.consultarCaminosDestino(ciudadEncontrandoAristas); //consultar ciudades adyacentes
			if (!aristando.equals(null)){
				for (int j = 0; j < aristando.size(); ++j){ //cada ciudad adyacente...
					
				////////////////PREPARAR LA ARISTA
					int targetVertex  = returnCityIndex(aristando.get(j).consultarDestino()); 
					////aqui arriba traduzco el nombre de la ciudad por el indice correspondiente
					int capacity = aristando.get(j).consultarCapacidad();
					///aqui arriba otengo la capacidad

					////////CALCULO TEMA COSTE//////////////////////////
					////////////////////////////////////////////////
					MedioTransporte mtrans = mt.buscarMedio(aristando.get(j).consultarTransporte());
					//aqui arriba busco el medio						
					int x1 = m.consultarCiudad(ciudadEncontrandoAristas).consultarCoordenadas().consultarX();
					int y1 =  m.consultarCiudad(ciudadEncontrandoAristas).consultarCoordenadas().consultarY();
					//consulta cordenadas x e y de la ciudad de la cual sale el camino

					int x2 = m.consultarCiudad(aristando.get(j).consultarDestino()).consultarCoordenadas().consultarX();						
					int y2 = m.consultarCiudad(aristando.get(j).consultarDestino()).consultarCoordenadas().consultarY();
					//consulta coordenadas x e y de la ciudad donde acaba el camino

					int x; int y;
					if (x1 > x2) x= x1-x2; else x = x2-x1;
					if (y1 > y2) y= y1-y2; else y = y2-y1;
					int cost = (x + y)* mtrans.getPrecio(); //REVISAR ESTO!!!!!!!!!!
					
					//////MECANISMO PARA SALTAR DE VERTICE DENTRO DE LA MISMA CIUDAD

					int insert_here = -1;
					boolean insertado = false;
					
					while (!insertado){ //para tener en cuenta y poder anadir los vertices auxiliares
						++insert_here;
						if (!g.existeAdyacente(returnCityIndex(ciudadEncontrandoAristas) + insert_here, targetVertex)){
							insertado = true;
							g.anadirArista(returnCityIndex(ciudadEncontrandoAristas) + insert_here,targetVertex, 0, capacity, cost);
							}
						
						//Aqui abajo: para tener en cuenta y poder anadir los vertices auxiliares
						else if (!g.existeAdyacente(returnCityIndex(ciudadEncontrandoAristas) + insert_here, 
								returnCityIndex(ciudadEncontrandoAristas) + insert_here + 1)){
							g.anadirArista(returnCityIndex(ciudadEncontrandoAristas) + insert_here, 
									returnCityIndex(ciudadEncontrandoAristas) +insert_here +1, 0, 2147483647, 0);
							}
						}

					}
					
				}
				
			}
			
		return g;
	}
	
	
	///////DUDA: TAMBIEN HAY QUE CREARL DENTRO DE LA CONSTRUCTORA NO?
	public void ejecutar(int i) throws Exception {
		switch(i) {
			case 1: {
				ejecutarAlgoritmoFordFulkerson();
				break;
			}
			case 2: {
				ejecutarAlgoritmoPushRelabel();
				break;
			}
			case 3: {
				ejecutarAlgoritmoDinic();
				break;
			}
			default: {
				System.out.println("No hay mas algoritmos" + "\n");
				System.exit(0);
				break;
			}
		}
		if(!sol.consultarTieneSolucion()) {
			System.out.println(" #######################"
				+ "\n NO HAY SOLUCION POSIBLE"
				+ "\n #######################"
				+ "\n Carque nuevamente el ControladorAlgoritmo");
			ent = null;
			sol = null;
			cit = null;
			agentes = null;
		}
	}
	
	public void ejecutarAlgoritmoDinic() throws Exception{
		Dinic d = new Dinic(); 
		sol = d.ejecutar(ent);
	}
	

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
		/*if(numIt <= numAg) {
				//System.out.println("numIt menor o igual que numAg \n");
			for(int i = 0; i < numAg; ++i) {
				String s;
				while(i< numIt) {
					s = agentes.get(i); 
					convertirItinerario(i,s);
					++i;
				}
				if(i < numAg) {
					s = agentes.get(i);
					ArrayList<String> ciudades = new ArrayList<String>();
					ciudades.add("No tiene solucion");
					cit.agregarItinerario(s, ciudades);
				}

			}
		}*/
		//cas que sobren camins, mirem els de menys cost
		//else if (numIt > numAg){ 
				//System.out.println("numIt mayor que numAg \n"); 
			for(int i = 0; i < numAg; ++i){
				int min = 1000;
				int pos = 1000;
				for(int j = 0; j < numIt; ++j){
					if(sol.obtenCoste(j) < min) {
						min = sol.obtenCoste(j);
						pos = j; 
					}
				}
				String s = agentes.get(i); 
				convertirItinerario(pos,s);
				sol.agregarCosteAItinerario(pos, 1000);//posem marca 
			}
		//}
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
			String c = mapping[v]; 
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
