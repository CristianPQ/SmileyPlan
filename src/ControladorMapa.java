import java.util.*;

public class ControladorMapa {

	private Mapa m;
	
	
	private String buffer; 
	private static int BUFFER_SIZE = 3250; //aprox 250 elem
	private static int CARGA_MAX = 250; 
	
	private static Exception NoExiste = new Exception ("Este elemento no existe");
	
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
		String[] cArray = cont.split(" ");;
		for(int i = 0; i < cArray.length; i += 2) {
			int x = Integer.parseInt(cArray[i]);
			int y = Integer.parseInt(cArray[i+1]);
			borde.add(new Coordenadas(x, y));
		}
		if(borde.size() < 4) return null;
		return borde;
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
	public void eliminarCiudad(String c) throws Exception {
		m.eliminarCiudad(c);
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
		ArrayList<String> list = m.listarCiudades();
		String nombreC = new String();
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String n = it.next();
				//System.out.println(n + "\n");
			nombreC = nombreC + n + "\n";
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
		if(!contMT.existe(medio)) throw NoExiste;
		Camino c = new Camino(cOrig, cDest, cap, medio);
		m.agregarCamino(c);
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
	public String[][] consultarMapa() {
		return m.consultarMapa();
	}
	
	/**
	 * Consultora del string que compone mapa
	 * @return un string con la info de la matriz mapa
	 */
	public String consultarMapaToString() {
		String map = new String();
		String[][] ma = m.consultarMapa();
		for(int i = 0; i < ma.length; ++i) {
			for(int j = 0; j < ma[0].length; ++j) {
				map = map + "[" + ma[i][j] + "]" + " ";
			}
			map = map + "\n";
		}
		return map;
	}
	
	//#########################################
		//##########Gestion de datos
		//#########################################
		
	
	/**
	 * Cargar el mapa con sus limites, sus coordenadas, sus ciudades y sus caminos 
	 * @param path
	 * @param file
	 * @throws Exception
	 */
	public void cargarMapa(String path, String file) throws Exception {
		
		//gestor datos
		GestorDatos gd = new GestorDatos(path,file); 
		gd.createFile();
		gd.openFile("read"); 
		
		//cargar mapa
		int i = 0; 
		int num = Integer.parseInt(gd.readLine()); 
		buffer = gd.readBuffer(num+1); //totes les linies de coordenades + la de x i y 
		if(buffer == null) throw new Exception("fichero vacio"); 

		
		String[] lineas = buffer.split("\n"); 
		String[] cortarstring = lineas[i].split(" ");
		int x = Integer.parseInt(cortarstring[i]);
		int y = Integer.parseInt(cortarstring[i+1]);
		//captar continente y luego crear mapa 
		
		ArrayList<Coordenadas> cont = new ArrayList<Coordenadas>(); 
		
		for (int j = 1; j < num; ++j) {
			cortarstring = lineas[j].split(" ");
			int pos1 = Integer.parseInt(cortarstring[1]);
			int pos2 = Integer.parseInt(cortarstring[2]);
			Coordenadas aux = new Coordenadas(pos1,pos2); 
			cont.add(aux); 
		}
		
		//crear mapa con (x,y,cont); 
		 
		
		//cargar ciudades
		
		//cargar caminos 
	}
		
		
	/**
	 * Guardar el mapa con sus limites, sus coordenadas, sus ciudades y sus caminos
	 * @param path
	 * @param file
	 * @throws Exception
	 */
	public void guardarMapa(String path, String file) throws Exception {
		 GestorDatos gd = new GestorDatos(path,file); 
		 
		 /**
		  * En mapa guardar primer el num de coordenades, despres la x i la y i despres les coordenades
		  * cada una en una linia
		  */
		 
		 gd.createFile(); 
		 gd.openFile("write"); 
		 System.out.print("he obert file \n");
		 gd.writeBuffer("hola"); 
		 
		 //numero de coordenadas
		 ArrayList<Coordenadas> c = m.consultarArrayCoord(); 
		 String linea = Integer.toString(c.size())+ "\n";  
		 buffer = buffer+ linea + "\n"; 
		 
		 //altura y anchura
		 int x = m.consultarAnchura();
		 int y = m.consultarAltura(); 
		 linea = x + " " + y + "\n"; 
		 buffer = buffer + linea; 
		 
		 //guardar coordenadas
		 for(int i = 0; i < c.size(); ++i) {
			 Coordenadas aux = c.get(i); 
			 int c1 = aux.consultarX(); 
			 int c2 = aux.consultarY();
			 linea = c1 + " " + c2; 
			 buffer = buffer + linea + "\n"; 
			 
			 if(buffer.length() > BUFFER_SIZE) {
					gd.writeBuffer(buffer); 
					buffer = null; 
			 }
		 }
		 
		if(buffer != null) {
			gd.writeBuffer(buffer);
		}
		 
		 //guardarCiutats
		 guardarCiudadSinCerrar(gd); 
		 System.out.print("he guardat ciutats \n");
		 
		 //guardarCamins 
		 guardarCaminosSinCerrar(gd); 
		 System.out.print("he guardat caminos \n");
		 //guardar medidas mapa 
		
		gd.closeFile(); 
}
	
	
	 /**
	  * guardar Ciudades sin cerrar el archivo. util para poder guardar
	  * los caminos y el mapa a continuacion
	  * @param gd 
	  * @throws Exception
	  */
	 public void guardarCiudadSinCerrar(GestorDatos gd) throws Exception {
		 
		 ArrayList<String> lista = new ArrayList<String>();
			lista = m.listarCiudades();
			
			String linea = Integer.toString(lista.size()) + "\n"; 
			buffer = linea; 
			
					
			for(int i = 0; i < lista.size(); ++i){
				String s = lista.get(i); 
				Ciudad aux = m.consultarCiudad(s); 
				int x = (aux.consultarCoordenadas()).consultarX(); 
				int y = (aux.consultarCoordenadas()).consultarY(); 
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
	 }
	 
	 
	/**
	 * Guardar ciudades
	 * @param path
	 * @param file
	 * @throws Exception si file no existe
	 */
	public void guardarCiudades(String path,String file) throws Exception{
		GestorDatos gd = new GestorDatos(path,file);
		
		gd.createFile(); 
		gd.openFile("write"); 
		
		guardarCiudadSinCerrar(gd); 
		
		gd.closeFile(); 
	}
	
	/**
	 * Cargar ciudades a mapa 
	 * @param path
	 * @param file
	 * @throws Exception
	 */
	public void cargarCiudades(String path,String file) throws Exception {
		GestorDatos gd = new GestorDatos(path,file); 
		//GestorDatos gd = new GestorDatos(path,file); 
		
		gd.createFile();
		gd.openFile("read"); 
		
		int num = Integer.parseInt(gd.readLine()); 
		buffer = gd.readBuffer(num); 
		if(buffer == null) throw new Exception("fichero vacio"); 
		
		String[] lineas = buffer.split("\n"); 
		int i = 0; 
		
		if (num <= CARGA_MAX) {
			while(i < num) {
				String[] cortarstring = lineas[i].split(" "); 
				String nombre = cortarstring[0];
				int x = Integer.parseInt(cortarstring[1]); 
				int y = Integer.parseInt(cortarstring[2]); 
				agregarCiudad(nombre,x,y); 
				/////////////per comprovar ////////////////
				System.out.print(nombre + " "+ x + " " + y +"\n"); 
				/////////////////////////////////////////////
				i++; 
			}
		}
		
		else {
			while(num >= CARGA_MAX) {
				buffer = gd.readBuffer(CARGA_MAX); 
				num = num - CARGA_MAX; 
				while(i < CARGA_MAX) {
					String[] cortarstring = lineas[i].split(" "); 
					String nombre = cortarstring[0];
					int x = Integer.parseInt(cortarstring[1]); 
					int y = Integer.parseInt(cortarstring[2]); 
					agregarCiudad(nombre,x,y); 
					/////////////per comprovar ////////////////
					System.out.print(nombre + " "+ x + " " + y +"\n"); 
					/////////////////////////////////////////////
					i++; 
					
				}
			}
		
		gd.closeFile(); 
	}
	}
	
	/**
	 * Guarda los caminos sin cerrar el archivo 
	 * @param gd
	 * @throws Exception
	 */
	public void guardarCaminosSinCerrar(GestorDatos gd) throws Exception {
		
		ArrayList<Camino> lista = new ArrayList<Camino>(); 
		lista = m.consultarTodosCaminos(); 
		String linea = Integer.toString(lista.size()) + "\n"; 
		buffer = linea; 
		for(int i = 0; i < lista.size(); ++i){
			String co = lista.get(i).consultarOrigen(); 
			String cap = Integer.toString(lista.get(i).consultarCapacidad()); 
			String transporte = lista.get(i).consultarTransporte(); 
			String cd = lista.get(i).consultarDestino();  
			linea = co + " " + cap + " " + transporte + " " + cd; 
			buffer = buffer + linea + "\n"; 
			
			if(buffer.length() > BUFFER_SIZE) {
				gd.writeBuffer(buffer); 
				buffer = null; 
			}
		}
		
		if(buffer != null) {
			gd.writeBuffer(buffer);
		}
	}
	
	/**
	 * Guardar caminos del mapa
	 * @param path
	 * @param file
	 * @throws Exception
	 */
	public void guardarCaminos(String path,String file) throws Exception{
		GestorDatos gd = new GestorDatos(path,file); 
		
		gd.createFile(); 
		gd.openFile("write"); 
		
		guardarCaminosSinCerrar(gd); 
		
		gd.closeFile(); 
	}
	
	/**
	 * Cargar caminos en el mapa
	 * @param path
	 * @param file
	 * @throws Exception
	 */
	public void cargarCaminos(String path, String file) throws Exception {
		GestorDatos gd = new GestorDatos(path,file); 
		gd.createFile();
		gd.openFile("read"); 
		
		int num = Integer.parseInt(gd.readLine()); 
		
		buffer = gd.readBuffer(num); 
		if(buffer == null) throw new Exception("fichero vacio"); 
		
		String[] lineas = buffer.split("\n"); 
		int i = 0; 
		
		if (num <= CARGA_MAX) {
			while(i < num) {
				String[] cortarstring = lineas[i].split(" "); 
				String co = cortarstring[0];
				int capac = Integer.parseInt(cortarstring[1]); 
				String trans = cortarstring[2]; 
				String cd = cortarstring[3]; 
				Camino c = new Camino(co,cd,capac,trans);
				m.agregarCamino(c); 
				/////////////per comprovar ////////////////
				System.out.print(co + " "+ capac + " " + cd + " " + trans + "\n"); 
				/////////////////////////////////////////////
				i++; 
			}
		}
		
		else {
			while(num >= CARGA_MAX) {
				buffer = gd.readBuffer(CARGA_MAX); 
				num = num - CARGA_MAX; 
				while(i < CARGA_MAX) {
					String[] cortarstring = lineas[i].split(" "); 
					String co = cortarstring[0];
					int capac = Integer.parseInt(cortarstring[1]); 
					String trans = cortarstring[2]; 
					String cd = cortarstring[3]; 
					Camino c = new Camino(co,cd,capac,trans);
					m.agregarCamino(c); 
					/////////////per comprovar ////////////////
					System.out.print(co + " "+ capac + " " + cd + " " + trans + "\n"); 
					/////////////////////////////////////////////
					i++; 
				}
			}
		
		}
		gd.closeFile(); 
	}
	
	public void CargarCaminosSinCerrar(GestorDatos gd) {
		
	}
		
}
