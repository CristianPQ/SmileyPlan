
import java.util.*;

public class ControladorAlgoritmo {
	private Entrada ent;
	private Solucion sol;
	private ControladorItinerarios cit;

	private ArrayList<String > agentes;
	private String[] mapping;
	
	private static Exception AlgoritmoNoEjecutado = new Exception("No se ha ejecutado ningun algoritmo");
	private static Exception NoAgentesOD = new Exception("No hay agentes que quieran hacer este viaje");
	private static Exception NoHayAgentes = new Exception ("No existe ningún agente");
	public double consultarTiempo() throws Exception {
		//if(!sol.consultarTieneSolucion()) throw AlgoritmoNoEjecutado;
		return sol.consultarTiempo();
	}

	
	public ControladorAlgoritmo() {}
	
	public ControladorAlgoritmo(ControladorAgentes ca, ControladorMapa cm, 
			ControladorMedioTransporte mt, String cOrig, String cDest, boolean CosteDistancia, ControladorItinerarios cI) throws Exception{
		//System.out.println("entro a domini");
		cm.initMapeo();
		mapping = cm.consultarMapping();
		//System.out.println("sorto del mapping");
		if (ca.getNumeroDeAgentes() == 0) throw NoHayAgentes;
		int nAgent = ca.numeroAgentesOrigenObjetivo(cOrig, cDest);
		if (nAgent < 1) throw NoAgentesOD;
		//System.out.println("entro a crearGrafo");
		ent  = cm.crearGrafo(CosteDistancia, mt); //CosteDistancia: si 0, coste*distancia; si 1, distancia

		//System.out.println("acabo CrearGrafo");
		ent.modificarNumeroAgentes(nAgent);
		int s = cm.returnCityIndex(cOrig);
		int t = cm.returnCityIndex(cDest);
		ent.modificarSource(s);
		ent.modificarSink(t);
		cit = cI;
		agentes = ca.consultarAgentesOrigenObjetivo(cOrig, cDest);
		sol = new Solucion(nAgent);
		//System.out.println("acabo de crear el controlador");
	}
	

	
	public ControladorItinerarios consultarItinerarios() {
		return cit;
	}
	
/*	public void EjecutarGrafo(int i) {
	
	}
*/
	
	public void ejecutar(int i) throws Exception {
		//if (ent.consultarNumeroAgentes() < 1) throw NoAgentesOD;
		switch(i) {
			case 1: {
				//System.out.println("entro FF");
				ejecutarAlgoritmoFordFulkerson();
				//System.out.println("acabo FF");
				//System.out.println("el numero de soluciones es" + sol.consultarNumItinerarios());
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
				//System.out.println("No hay mas algoritmos" + "\n");
				System.exit(0);
				break;
			}
		}
		if(!sol.consultarTieneSolucion()) {
			ent = null;
			//sol = null;
			cit = null;
			agentes = null;
		}
		else asignarItinerarioAAgente();
	}
	public boolean haySoucion(){
		return sol.consultarTieneSolucion();
	}
	
	public void ejecutarAlgoritmoDinic() throws Exception{
		Dinic d = new Dinic(); 
		sol = d.ejecutar(ent);
		//System.out.println(" DOMINIO: EL TIEMPO DE DINIC ES " + sol.consultarTiempo());
	}
	

	public void ejecutarAlgoritmoFordFulkerson() throws Exception {
		FordFulkerson ff = new FordFulkerson(); 
		sol = ff.ejecutar(ent);	
	}
	
	public void ejecutarAlgoritmoPushRelabel() throws Exception{
		PushRelabel p = new PushRelabel(); 
		sol = p.ejecutar(ent);
	}
	public int consultarMaxFlow(){
		return sol.consultarNumItinerarios();
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
			
		
		/*
		//System.out.println("numIt mayor que numAg \n"); 
		for(int j = 0; j < numIt; ++j){
				System.out.println("coste del itinerario " + j +   " es = " + sol.obtenCoste(j));
			}
		*/
			for(int i = 0; i < numAg; ++i){
				
				int min = 2147483647; //max int
				int pos = 1000;
				for(int j = 0; j < numIt; ++j){
					if(sol.obtenCoste(j) < min) {
						min = sol.obtenCoste(j);
						pos = j; 
					}
				}
				
				String s = agentes.get(i); 
				convertirItinerario(pos,s,min);
				sol.agregarCosteAItinerario(pos, 2147483647);//posem marca 
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
	public void convertirItinerario(int i, String nombreAg, int coste) throws Exception{
		int num = sol.obtenNumCiudades(i); 
		ArrayList<String> listaciudades = new ArrayList<String>();	
		for(int j = 0; j < num; ++j) {
			int v = sol.obtenVertice(i, j); 
			String c = mapping[v]; 
			boolean trobat = false;
			for (int z = 0; z < listaciudades.size() & !trobat;++z)
				if(listaciudades.get(z).equals(c)) trobat = true;
			if(!trobat) listaciudades.add(c);
		}

		cit.agregarItinerario(nombreAg,listaciudades,coste); 
	}
	
	
	/**
	 * Guarda la sequencia del ultimo algoritmo ejecutado
	 * primero hay que ejecutar para que funcione
	 * @param path
	 * @param filename
	 * @throws Exception
	 */
	public void guardarSeq (String filename) throws Exception{
		GestorDatos gd = new GestorDatos(filename); 		
		gd.abrirArchivo("write");
		
		String buffer; 
		
		ArrayList<String> guardaseq = sol.obtenSeq(); 
		int n = guardaseq.size();
		
		for(int i = 0; i < n; ++i) {
			buffer = guardaseq.get(i); 
			String prova = guardaseq.get(i); 
			//System.out.println(prova+ "\n");
			gd.writeBuffer(buffer); 
		}
		gd.cerrarArchivo(); 
	}
}
