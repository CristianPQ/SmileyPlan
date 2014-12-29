import java.util.*;

import javax.lang.model.type.NullType;


public class ControladorMapa {

	private Mapa m;
	private String[] mapping;
	
	private String buffer; 
	private static int BUFFER_SIZE = 3250; 
	private static int CARGA_MAX = 250; 
	
	private static Exception NoExiste = new Exception ("El medio de transporte no existe");
	
	public ControladorMapa(){
	
	}
	/**
	 * Constructora de ControladorMapa
	 * @param anchuraX
	 * @param alturaY
	 * @param continente
	 * @throws Exception
	 */
	public ControladorMapa(int anchuraX, int alturaY, String continente) throws Exception {
		//Para delimitar el continente son necesarios por lo menos 4 coordenadas
		ArrayList<Coordenadas> cont = continente(continente);
		m = new Mapa(anchuraX, alturaY, cont);
	}
	
	
	//Transforma el String en un tipo valido para mapa
	/**
	 * Transforma un string en un ArrayList para la constructora de Mapa
	 * @param cont
	 * @return Un arrayList de coordenadas que delimitaran el terreno util
	 */
	private ArrayList<Coordenadas> continente(String cont) {
		ArrayList<Coordenadas> borde = new ArrayList<Coordenadas>();
		String[] cArray = cont.split(" ");
			if(cArray.length < 8) return null;
		for(int i = 0; i < cArray.length; i += 2) {
			int x = Integer.parseInt(cArray[i]);
			int y = Integer.parseInt(cArray[i+1]);
			borde.add(new Coordenadas(x, y));
		}
		return borde;
	}
	
	public int conusltarAnchura() {
		return m.consultarAnchura();
	}
	
	public int consultarAltura() {
		return m.consultarAltura();
	}
	
	public String consultarContinente() {
		 ArrayList<Coordenadas> c = m.consultarArrayCoord();
		 String continente = new String(); 
		 for(int i = 0; i < c.size(); ++i) {
			 Coordenadas aux = c.get(i); 
			 int c1 = aux.consultarX(); 
			 int c2 = aux.consultarY();
			 String par = c1 + " " + c2 + " "; 
			 continente = continente + par; 
		 } 
		return continente;
	}
	
	public boolean existeContinente() {
		return m.existeContinenteEnMapa(); 
	}
	
	//#########################################
	//##########SOBRE CIUDADES
	//#########################################
	
	/**
	 * Comprobar si existe una ciudad
	 * @param nombre
	 * @return
	 */
	public boolean existeCiudad(String nombre) {
		return m.existeCiudad(nombre);
	}
	
	public int coordXCiudad(String nombre) throws Exception {
		Ciudad c = consultarCiudad(nombre);
		Coordenadas coord = c.consultarCoordenadas();
		return coord.consultarX();
	}
	
	public int coordYCiudad(String nombre) throws Exception {
		Ciudad c = consultarCiudad(nombre);
		Coordenadas coord = c.consultarCoordenadas();
		return coord.consultarY();
	}
	
	/**
	 * Devuelve la distancia entre 2 ciudades
	 * @param cOrig
	 * @param cDest
	 * @return distancia entre 2 ciudades
	 * @throws Exception
	 */
	public int distanciaCiudades(String cOrig, String cDest) throws Exception {
		return m.distanciaCiudades(cOrig, cDest);
	}
	
	/**
	 * Agregar una nueva ciudad
	 * @param nombre
	 * @param x
	 * @param y
	 * @throws Exception si la ciudad ya existe o las coordenadas no son validas
	 */
	public void agregarCiudad(String nombre, int x, int y) throws Exception {
		Coordenadas coord = new Coordenadas(x,y);
		Ciudad c = new Ciudad(nombre, coord);
		m.agregarCiudad(c);
	}
	
	/**
	 * Elimina una ciudad existente
	 * @param c
	 * @throws Exception Si la ciudad no existe
	 */
	public void eliminarCiudad(String c/*, ControladorAgentes ca*/) throws Exception {
		m.eliminarCiudad(c);
	//	System.out.println(listarCiudades().size()+" cMap");
		//ca.eliminarAgentesConCiudad(c);
	}
	
	/**
	 * Consultora de ciudad a partir del nombre
	 * @param c
	 * @return La ciudad consultada
	 * @throws Exception Si la ciudad no existe
	 */
	public Ciudad consultarCiudad(String c) throws Exception {
		return m.consultarCiudad(c);
	}
	
	//Consulta una ciudad y ademas la devuelve en String para poder pasarla entre capas
	/**
	 * Consultora de ciudad a partir del nombre
	 * @param nombre
	 * @return Devuelve un String con el contenido de la ciduad
	 * 
	 * @throws Exception
	 */
	public String consultarCiudadToString(String nombre) throws Exception {
		Ciudad c = m.consultarCiudad(nombre);
		int x = c.consultarCoordenadas().consultarX();
		int y = c.consultarCoordenadas().consultarY();
		String ciudadSt = nombre + " " + Integer.toString(x) + " " + Integer.toString(y) + "\n";
		//System.out.println("coordX: " + x +"    coordY: " + y + "\n" + ciudad + "\n");
		return ciudadSt;
	}
	
	/**
	 * Modificador de los atributos de una ciudad
	 * @param nombre
	 * @param x
	 * @param y
	 * @throws Exception No existe una ciudad con ese nombre
	 */
	public void modificarAtributosCiudad(String nombre, int x, int y) throws Exception {
		m.modificarAtributosCiudad(nombre, x, y);
	}
	
	/**
	 * Consultora de todas las ciudades existentes
	 * @return Los nombres de todas las ciudades
	 * @throws Exception Si no hay ninguna ciudad
	 */
	public ArrayList<String> listarCiudades() throws Exception{
		return m.listarCiudades();
	}
	
	
	/**
	 * Consultora de todas las ciudades existentes
	 * @return Los nombres de todas las ciudades en un String
	 * @throws Exception Si no hay ninguna ciudad
	 */
	public String listarCiudadesToString() throws Exception {
			//System.out.println("Entra en listar");
		ArrayList<String> list = m.listarCiudades();
		String nombreC = new String();
		if(list != null) {
			for(int i = 0; i < list.size(); ++i) {
				nombreC = nombreC + list.get(i) + "\n";
			}
		}
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String n = it.next();
			nombreC = nombreC + n + " " + Integer.toString(coordXCiudad(n)) +" " + 
					Integer.toString(coordYCiudad(n)) + "\n";
		}
		return nombreC;
	}
	
	//#########################################
	//##########SOBRE CAMINOS
	//#########################################
	
	/**
	 * Consultar si existe un camino con origen a cOrig
	 * @param cOrig
	 * @return
	 */
	public boolean existeCaminoConOrigen(String cOrig) {
		return m.existeCaminoConOrigen(cOrig);
	}
	
	/**
	 * Consultar si existe un camino entre las ciudades cOrig, cDest
	 * @param cOrig
	 * @param cDest
	 * @return
	 */
	public boolean existeCaminoDesdeA(String cOrig, String cDest) {
		return m.existeCaminoDesdeA(cOrig, cDest);
	}
	
	/**
	 * Agregar un camino en el mapa
	 * @param cOrig
	 * @param cDest
	 * @param medio
	 * @param cap
	 * @param contMT
	 * @throws Exception
	 */
	public void agregarCamino(String cOrig, String cDest, String medio, int cap, ControladorMedioTransporte contMT) throws Exception {
		
		//Comprobar que el medioTransporte ya existe
		//System.out.println("dins agregar camino" + contMT.existe(medio));
		if(!contMT.existe(medio)) throw NoExiste;
		Camino c = new Camino(cOrig, cDest, cap, medio);
		m.agregarCamino(c);
		//System.out.println("camino agregado con exito");
	}
	
	/**
	 * Devuelve el camino representado por cOrig, cDest y med 
	 * @param cOrig
	 * @param cDest
	 * @param med
	 * @return
	 * @throws Exception
	 */
	public Camino consultarCamino(String cOrig, String cDest, String med) throws Exception {
		return m.consultarCamino(cOrig, cDest, med);
	}

	/**
	 * Devuelve string con los caminos
	 * @param cOrig
	 * @param cDest
	 * @param medio
	 * @return
	 * @throws Exception
	 */
	public String consultarCaminoToString(String cOrig, String cDest, String medio) throws Exception {
		Camino c = m.consultarCamino(cOrig, cDest, medio);
		String cam = cOrig + " " + cDest + " " + medio + " " + Integer.toString(c.consultarCapacidad()) + "\n";
		return cam;
	}
	
	/**
	 * Elimina el camino representado por cOrig, cDest y medio
	 * @param cOrig
	 * @param cDest
	 * @param medio
	 * @throws Exception
	 */
	public void eliminarCamino(String cOrig, String cDest, String medio) throws Exception {
		m.eliminarCamino(cOrig, cDest, medio);
	}
	
	/**
	 * Consultora que devuelve un array con los caminos entre cOrig y cDest
	 * @param cOrig
	 * @param cDest
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Camino> consultarCaminosEntre(String cOrig, String cDest) throws Exception {
		return m.consultarCaminosEntre(cOrig, cDest);
	}
	
	/**
	 * Consultora de los caminos entre ciudades cOirg y cDest
	 * @param cOrig
	 * @param cDest
	 * @return lista caminos
	 * @throws Exception
	 */
	public String consultarCaminosEntreToString(String cOrig, String cDest) throws Exception {
		ArrayList<Camino> listCamino = m.consultarCaminosEntre(cOrig, cDest);
		Iterator<Camino> it = listCamino.iterator();
		String listC = new String();
		Camino c = null;
		while(it.hasNext()) {
			c = it.next();
			listC = listC + c.consultarOrigen() + " " + c.consultarDestino() + " " + 
			c.consultarTransporte() + " " + Integer.toString(c.consultarCapacidad()) + "\n";
		}
		return listC;
	}
	
	/**
	 * Modificadora de los atributos de caminos 
	 * @param cOrig
	 * @param cDest
	 * @param medio
	 * @param cap
	 * @throws Exception
	 */
	public void modificarAtributosCamino(String cOrig, String cDest, String medio, int cap) throws Exception {
		m.modificarAtributosCamino(cOrig, cDest, medio, cap);
	}
	
	/**
	 * Devuelve los identificadores de las ciudades que se pueden alcanzar 
	 * a partir de una ciudad
	 * @param cOrig
	 * @return
	 */
	//A partir de una ciudad origen se devuelven los identificadores de las ciudades que se pueden alcanzar
	public ArrayList<Camino> consultarCaminosDestino(String cOrig) {
		return m.consultarCaminosDestino(cOrig);
	}
	
	/**
	 * Devuelve array con todos los caminos
	 * @return
	 */
	public ArrayList<Camino> consultarTodosCaminos() {
		return m.consultarTodosCaminos();
	}
	
	/**
	 * Devuelve string con todos los caminos 
	 * @return lista de caminos
	 */
	public String consultarTodosCaminosToString() {
		ArrayList<Camino> todoCaminos = m.consultarTodosCaminos();
		Iterator<Camino> it = todoCaminos.iterator();
		String listC = new String();
		while(it.hasNext()) {
			Camino c = it.next();
			listC = listC + c.consultarOrigen() + " " + c.consultarDestino() + " " + 
			c.consultarTransporte() + " " + Integer.toString(c.consultarCapacidad()) + "\n";
		}
		return listC;
	}
	
	/**
	 * Devuelve string con los caminos que tengan destino a cOrig
	 * @param cOrig
	 * @return lista de caminos
	 * @throws Exception
	 */
	public String consultarCaminosDestinoToString(String cOrig) throws Exception {
		ArrayList<Camino> listCamino = m.consultarCaminosDestino(cOrig);
		if(listCamino.isEmpty()) {
			//System.out.println("Esta vacio");
			return null;
		}
		Iterator<Camino> it = listCamino.iterator();
		String listC = new String();
		Camino c = null;
		while(it.hasNext()) {
			c = it.next();
			listC = listC + c.consultarOrigen() + " " + c.consultarDestino() + " " + 
			c.consultarTransporte() + " " + Integer.toString(c.consultarCapacidad()) + " ";
		}
		return listC;
	}
	
	//#########################################
	//##########OTROS
	//#########################################
	
	/**
	 * Consultora de la matriz mapa
	 * @return matriz de strings mapa
	 */
	/*public String[][] consultarMapa() {
		return m.consultarMapa();
	}*/
	
	/**
	 * Consultora del string que compone mapa
	 * @return un string con la info de la matriz mapa
	 */
	public String consultarMapaToString() {
		return m.consultarMapa();
	}
	
	//#########################################
	//##########Gestion de datos
	//#########################################
	
	//******************************
	/////////Guardar///////////////////
	
		
	/**
	 * Guardar el mapa con sus limites, sus coordenadas, sus ciudades y sus caminos
	 * @param path
	 * @param file
	 * @throws Exception
	 */
	public void guardarMapa(String file) throws Exception {
		 GestorDatos gd = new GestorDatos(file); 
		 
		 gd.abrirArchivo("write"); 
		 
		 //altura y anchura
		 int x = m.consultarAnchura();
		 int y = m.consultarAltura(); 
		 String linea = x + " " + y + "\n"; 
		 buffer = linea; 
		 //System.out.println(linea);
		 
		 
		 ArrayList<Coordenadas> c = m.consultarArrayCoord(); 
		 //System.out.println(c);
		 //guardar coordenadas
		 if(c != null) {
			 for(int i = 0; i < c.size(); ++i) {
				 Coordenadas aux = c.get(i); 
				 int c1 = aux.consultarX(); 
				 int c2 = aux.consultarY();
				 linea = c1 + " " + c2; 
				 //System.out.println(linea);
				 buffer = buffer + linea + "\n"; 
				 
				 if(buffer.length() > BUFFER_SIZE) {
						gd.writeBuffer(buffer); 
						buffer = null; 
				 }
			 }
		 }
		 
		if(buffer != null) {
			gd.writeBuffer(buffer);
		}
		 
		gd.cerrarArchivo(); 
	}
	
	
	
	/**
	 * Guardar ciudades
	 * @param path
	 * @param file
	 * @throws Exception si file no existe
	 */
	public void guardarCiudades(String file) throws Exception{
		GestorDatos gd = new GestorDatos(file);
		gd.abrirArchivo("write"); 
		
		ArrayList<String> lista = new ArrayList<String>();
		lista = m.listarCiudades();
		
		String s = lista.get(0); 
		Ciudad aux = m.consultarCiudad(s); 
		int x = (aux.consultarCoordenadas()).consultarX(); 
		int y = (aux.consultarCoordenadas()).consultarY(); 
		String linea = aux.consultarNombre() + " " + x + " " + y; 
		buffer = linea + "\n"; 
		
		for(int i = 1; i < lista.size(); ++i){
			s = lista.get(i); 
			aux = m.consultarCiudad(s); 
			x = (aux.consultarCoordenadas()).consultarX(); 
			y = (aux.consultarCoordenadas()).consultarY(); 
			linea = aux.consultarNombre() + " " + x + " " + y; 
			buffer = buffer + linea + "\n"; 
			
			if(buffer.length() > BUFFER_SIZE) {
				gd.writeBuffer(buffer); 
				buffer = null; 
			}
		}
		
		if(buffer != null) {
			gd.writeBuffer(buffer);
		}	
	
		gd.cerrarArchivo(); 
	}
	
	
	/**
	 * Guardar caminos del mapa
	 * @param path
	 * @param file
	 * @throws Exception
	 */
	public void guardarCaminos(String file) throws Exception{
		
		GestorDatos gd = new GestorDatos(file); 
		gd.abrirArchivo("write"); 
		
		ArrayList<Camino> lista = new ArrayList<Camino>(); 
		lista = m.consultarTodosCaminos(); 
		//System.out.println(lista);
		
		String co = lista.get(0).consultarOrigen(); 
		String cap = Integer.toString(lista.get(0).consultarCapacidad()); 
		String transporte = lista.get(0).consultarTransporte(); 
		String cd = lista.get(0).consultarDestino();  
		String linea = co + " " + cd + " " + transporte + " " + cap; 
		buffer = linea + "\n"; 
		
		for(int i = 1; i < lista.size(); ++i) {
			co = lista.get(i).consultarOrigen(); 
			cap = Integer.toString(lista.get(i).consultarCapacidad()); 
			transporte = lista.get(i).consultarTransporte(); 
			cd = lista.get(i).consultarDestino();  
			linea = co + " " + cd + " " + transporte + " " + cap; 
			buffer = buffer + linea + "\n";
			
			if(buffer.length() > BUFFER_SIZE) {
				gd.writeBuffer(buffer); 
				buffer = null; 
			}
		}
		if(buffer != null) {
			gd.writeBuffer(buffer);
		}
	
		gd.cerrarArchivo(); 
	}
	
	
	//******************************
	/////////CARGAR///////////////////
	
	
	/**
	 * Convertir el string a mapa 
	 * @param l
	 * @throws Exception 
	 */
	private void convertirMapa(String[] l) throws Exception {
		int total = l.length; 
		int i = 0; 
		String[] cortarstring = l[i].split(" ");
		
		int x = Integer.parseInt(cortarstring[0]);
		int y = Integer.parseInt(cortarstring[1]);
		//System.out.println(x + " " + y);
		//++i; 
		
		ArrayList<Coordenadas> cont = new ArrayList<Coordenadas>(); 
		if(total == 1) {
			//System.out.println("no continent"); 
			m = new Mapa(x,y,"");  
		}
		else {
			for (int j = 1; j < total; ++j) {
				cortarstring = l[j].split(" ");
				int pos1 = Integer.parseInt(cortarstring[0]);
				int pos2 = Integer.parseInt(cortarstring[1]);
				//System.out.println(pos1+ " " + pos2);
				cont.add(new Coordenadas(pos1, pos2));
			}
			m = new Mapa(x, y, cont);
		}
	}
	
	
	/**
	 * Cargar el mapa con sus limites, sus coordenadas, sus ciudades y sus caminos 
	 * @param path
	 * @param file
	 * @throws Exception
	 */
	public boolean cargarMapa(String file) throws Exception {
		
		GestorDatos gd = new GestorDatos(file); 
		gd.abrirArchivo("read"); 
		
		
		int num = gd.bufferToStrings(); 
		String carga = gd.obtenerTodoElString(); 
		//System.out.println("dins cargarMapa");
		
		String[] lineas = carga.split("\n");
		convertirMapa(lineas);
		
		gd.cerrarArchivo();
		//System.out.println("fi"); 
		return true; 
	}
	
	
	/**
	 * Convierte el string a ciudades
	 * @param l
	 * @throws Exception
	 */
	private void convertirCiudades(String[] l) throws Exception {
		int total = l.length; 
		for(int i = 0; i < total; ++i) {
			String[] cortarstring = l[i].split(" "); 
			String nombre = cortarstring[0];
			int x = Integer.parseInt(cortarstring[1]); 
			int y = Integer.parseInt(cortarstring[2]); 
			agregarCiudad(nombre,x,y); 
			/////////////per comprovar ////////////////
			//System.out.print(nombre + " "+ x + " " + y +"\n"); 
			/////////////////////////////////////////////
		}
	}
	
	/**
	 * Cargar caminos en el mapa
	 * @param path
	 * @param file
	 * @throws Exception
	 */
	public boolean cargarCiudades(String file) throws Exception {
		
		GestorDatos gd = new GestorDatos(file); 
		gd.abrirArchivo("read"); 
		int num = gd.bufferToStrings(); 
		String carga; 
		
		if (num <= CARGA_MAX) {
			carga = gd.obtenerTodoElString(); 
			//System.out.println("tinc string:" + carga); 
			String[] l = carga.split("\n"); 
			convertirCiudades(l); 
		}
		else {
			while(num >= CARGA_MAX){
				num = num - CARGA_MAX; 
				carga = gd.obtenerStrings(CARGA_MAX);
				String[] l = carga.split("\n"); 
				convertirCiudades(l);  
			}
			if(num != 0) { //si queden restes
				//System.out.println("restes");
				carga = gd.obtenerStrings(num); 
				String[] l = carga.split("\n"); 
				convertirCiudades(l); 
			}
		}
		gd.cerrarArchivo(); 
		return true; 
	}
	
	/**
	 * Convierte el string a caminos 
	 * @param l
	 * @throws Exception
	 */
	private void convertirCaminos(String[] l, ControladorMedioTransporte contMT) throws Exception {
		int total = l.length; 
		//System.out.println("soc dins convertir "); 
		for(int i = 0; i < total; ++i) {
			String[] cortarstring = l[i].split(" "); 
			String co = cortarstring[0]; 
			String cd = cortarstring[1];
			String trans = cortarstring[2];
			int capac = Integer.parseInt(cortarstring[3]);  
			agregarCamino(co, cd, trans, capac, contMT); 
			//Camino c = new Camino(co,cd,capac, trans);
			//m.agregarCamino(c); 
			/////////////per comprovar ////////////////
			//System.out.print(co + " "+ capac + " " + cd + " " + trans + "\n"); 
			/////////////////////////////////////////////
		}
	}
	
	/**
	 * Cargar caminos en el mapa
	 * @param path
	 * @param file
	 * @throws Exception
	 */
	public boolean cargarCaminos(String file, ControladorMedioTransporte contMT) throws Exception {
		
		GestorDatos gd = new GestorDatos(file); 
		gd.abrirArchivo("read"); 
		int num = gd.bufferToStrings(); 
		String carga; 
		
		if (num <= CARGA_MAX) {
			carga = gd.obtenerTodoElString(); 
			String[] l = carga.split("\n"); 
			convertirCaminos(l,contMT); 
		}
		else {
			while(num >= CARGA_MAX){
				num = num - CARGA_MAX; 
				carga = gd.obtenerStrings(CARGA_MAX);
				String[] l = carga.split("\n"); 
				convertirCaminos(l,contMT);  
			}
			if(num != 0) { //si queden restes
				//System.out.println("restes");
				carga = gd.obtenerStrings(num); 
				String[] l = carga.split("\n"); 
				convertirCaminos(l,contMT); 
			}
		}
		gd.cerrarArchivo(); 
		return true; 
	
	}
	
	//////////////////////////////////////////////////////
	/////////////////////MAPPING///////////////////////////
	//////////////////////////////////////////////////////
	
	public void initMapeo() throws Exception{

		int i;

		ArrayList<String> mapeo = new ArrayList<String>();

		for (i = 0; i < listarCiudades().size();++i){ //per cada ciutat
			int necesito = 1;
			for (int j = 0; j < listarCiudades().size(); ++j){ 
			//per cada ciutat possiblement adjacent a la ciutat (i)					
				
				if (j != i){//hacer a ver si existen caminos para EVITAR EXCEPCIONES
					//consultar caminos (i,j) 	
					if(existeCaminoDesdeA(listarCiudades().get(i), listarCiudades().get(j))){
						
						ArrayList<Camino> Caminos = consultarCaminosEntre(listarCiudades().get(i), listarCiudades().get(j));
						
						if (!Caminos.equals(null) && Caminos.size() > necesito ){
							necesito = Caminos.size();


						}	
							/*if((i > j) && existeCaminoDesdeA(listarCiudades().get(j),listarCiudades().get(i))){
								ArrayList<Camino> Caminosj = consultarCaminosEntre(listarCiudades().get(j),listarCiudades().get(i));
								if(Caminosj.size() > Caminos.size()) necesito+=Caminos.size();
								else necesito += Caminosj.size();
								}
							if (necesito != 1) --necesito;*/
							//}
						}
					}
				/*if((i>j) && existeCaminoDesdeA(listarCiudades().get(i), listarCiudades().get(j)) &&
						existeCaminoDesdeA(listarCiudades().get(j), listarCiudades().get(i))){
					++necesito;
				}*/
				}
			++necesito;
			int w = 0;
			while (w < necesito) { //porque a lo mejor necesito + vertices!
				mapeo.add(listarCiudades().get(i));
				++w;
			}
		}	
		
		mapping = new String[mapeo.size()];

		for (int z = 0; z < mapeo.size(); ++z) {
			mapping[z] = mapeo.get(z);
		//	System.out.println(mapping[z]);
		}
		
	}
	
	
	public int returnCityIndex(String city){
		int indice = -1;
		for (int i = 0; i < mapping.length; ++i) 
			if (mapping[i].equals(city)) {indice = i; return indice;}
			return indice;
	}
	
	public String[] consultarMapping(){
		return mapping;
	}
	
	public int consultarNumVertices(){
		return mapping.length;
	}
	
	public Entrada crearGrafo(boolean calcCoste, ControladorMedioTransporte mt) 
			throws Exception{

		//for (int i = 0; i < consultarNumVertices();++i)	System.out.println(mapping[i]);

		Grafo<NullType,Arista> g1 = new Grafo<NullType, Arista>(consultarNumVertices()); //init grafo	
		
		
		Entrada e = new Entrada (g1, mapping.length);
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
					FuncionCoste f;
					int precio = mt.getPrecioTransporte(aristando.get(j).consultarTransporte());
					int distanciaCiudades = m.distanciaCiudades(m.listarCiudades().get(i), 
												aristando.get(j).consultarDestino());
					
					if (calcCoste)	f = new FuncionCostePorDistancia();
					
					else f = new FuncionPorDistancia();
		
					precio = f.getCoste(precio, distanciaCiudades);		

					////////////////////////////////////////////////
					//////MECANISMO PARA SALTAR DE VERTICE DENTRO DE LA MISMA CIUDAD
					e.anadirArista(returnCityIndex(ciudadEncontrandoAristas), 
							returnCityIndex(ciudadEncontrandoAristas) + 1, 0,2147483647,0);
					int insert_here = 0;
					boolean insertado = false;
					
					while (!insertado){
						++insert_here;
						if (!e.existeAdyacente(returnCityIndex(ciudadEncontrandoAristas) + insert_here, targetVertex)){
							insertado = true;
							e.anadirArista(returnCityIndex(ciudadEncontrandoAristas) + insert_here, targetVertex, 0, capacity, precio);
						}
						
						//Aqui abajo: para tener en cuenta y poder anadir los vertices auxiliares
						else if (!e.existeAdyacente(returnCityIndex(ciudadEncontrandoAristas) + insert_here, 
								returnCityIndex(ciudadEncontrandoAristas) + insert_here + 1)){
							e.anadirArista(returnCityIndex(ciudadEncontrandoAristas) + insert_here, 
									returnCityIndex(ciudadEncontrandoAristas) +insert_here +1, 0, 2147483647, 0);
							}
						}

					}
					
				}
				
			}
	/*	for(int i = 0; i < mapping.length; ++i){
			ArrayList <Arista> a = e.consultarAdyacentes(i);
			System.out.println("Aristas vertice " + i);
			if (!a.equals(null))
			for(int j = 0; j< a.size(); ++j){
				if(!a.get(j).equals(null))
				System.out.println(a.get(j).consultarVerticeDestino() + a.get(j).consultarCapacidad() + ' ');
				System.out.println(" ");			
		}
		}
		*/
		
		return e;
	}
	
	
	public void eliminarCaminosConMedio(String nombre) {
		m.eliminarCaminosConMedio(nombre);
	}
	
}