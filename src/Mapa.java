import java.util.*;


public class Mapa {
	
	
	
	private static String marca = "$";
	private TST<TST<ArrayList<Camino>>> caminos;
	private TST <Ciudad> ciudades;
	private String[][] mapa;
	
	private String buffer; 
	private static int BUFFER_SIZE = 3250; //aprox 250 elem
	private static int CARGA_MAX = 250; 
	
	private static Exception CoordInvalidas = new Exception ("Estas "
			+ "coordenadas no son validas para este mapa");
	private static Exception Existe = new Exception ("Este elemento ya existe");
	private static Exception NoExiste = new Exception ("Este elemento no existe");
	private static Exception NoExistenCiudades = new Exception ("No existe alguna"
			+ "de las ciudades o ambas");
	private static Exception Vacio = new Exception ("Esta vacio");
	private static Exception HayCaminos = new Exception ("Hay caminos que usan esta ciudad");
	private static Exception NoValido = new Exception ("No valido");
	
	
	
	/*
	 * Constructor Ciudad
	 */
	public Mapa(int anchuraX, int alturaY, String continente) throws Exception {
		//continente es cerrado siempre
		ciudades = new TST<Ciudad>();
		caminos = new TST<TST<ArrayList<Camino>>>();
		mapa = new String[alturaY][anchuraX];
		
		//continente debe de tener una doble marca de  $ para indicar que es el final
		//de la forma: numeroX " " numeroY " "...
		agregarContinente(continente);
	}
	
	private void delimitar(String noValido) throws Exception {
		int x = 0;
		int xAnt = x;
		int y  = 0;
		int yAnt = y;
		
		int xPrim = x;
		int yPrim = y;
		
		char num;
		boolean primero = true;
		for(int j = 0; x >= 0 && y >= 0;) {
			xAnt = x;
			yAnt = y;
			num = noValido.charAt(j);
			++j;
			if(num == '$') {
				x = -1;
			}
			else {
				//Creando la x
				x = Character.getNumericValue(num);
				while(noValido.charAt(j) != ' ') {
					x = x*10 + Character.getNumericValue(noValido.charAt(j));
					++j;
				}
				//fin de la creacion de x
				++j;
				//creacion de y
				num = noValido.charAt(j);
				++j;
				if(num == '$') {
					y = -1;
				}
				else {
					y = Character.getNumericValue(num);
					while(noValido.charAt(j) != ' ') {
						y = y*10 + Character.getNumericValue(noValido.charAt(j));
						++j;
					}
					//Fin de cracion de y
					++j;
					//marcar el mapa
					if(primero) {
						mapa[x][y] = "$";
						xPrim = x;
						yPrim = y;
						primero = false;
					}
					else {
						//El punto anterior esta al lado del actual
						if((x == (xAnt + 1) && y == yAnt) ||
								(x == (xAnt + 1) && y == (yAnt + 1)) ||
								(y == (yAnt + 1) && x == xAnt) ||
								(x == (xAnt - 1) && y == (yAnt + 1)) ||
								(x == (xAnt - 1) && y == yAnt) ||
								(x == (xAnt - 1) && y == (yAnt - 1)) ||
								(y == (yAnt - 1) && x == xAnt) ||
								(x == (xAnt + 1) && y == (yAnt - 1))) {
							mapa[x][y] = "$";
						}
						else throw CoordInvalidas;
					}
						
				}
			}
		}
		if((xPrim == (xAnt + 1) && yPrim == yAnt) ||
				(xPrim == (xAnt + 1) && yPrim == (yAnt + 1)) ||
				(yPrim == (yAnt + 1) && xPrim == xAnt) ||
				(xPrim == (xAnt - 1) && yPrim == (yAnt + 1)) ||
				(xPrim == (xAnt - 1) && yPrim == yAnt) ||
				(xPrim == (xAnt - 1) && yPrim == (yAnt - 1)) ||
				(yPrim == (yAnt - 1) && xPrim == xAnt) ||
				(xPrim == (xAnt + 1) && yPrim == (yAnt - 1))) {
			return;
		}
		else throw CoordInvalidas;
	}
	
	
	private void agregarContinente(String noValido) throws Exception {
		if(noValido != null) {
			delimitar(noValido);
			//invalidar el exterior del are util
			for(int i = 0; i < mapa.length; ++i) {
				for(int j = 0; j < mapa[0].length && mapa[i][j] != "$"; ++j) {
					mapa[i][j] ="$";
				}
				for(int k = mapa[0].length - 1; k >= 0 && mapa[i][k] != "$"; ++k) {
					mapa[i][k] ="$";
				}
			}
		}
	}
	
	
	/*
	 * Comprobar si la Coord es valida para el mapa
	 */
	private void posicionValida(Coordenadas coord) throws Exception {
		int x = coord.consultarX();
		int y = coord.consultarY();
		if(y >= mapa.length || x >= mapa[0].length ||
				mapa[y][x] != null) {
			throw CoordInvalidas;
		}
	}
	
	
	//#########################################
	//##########SOBRE CIUDADES
	//#########################################
	
	/*
	 * Comprobar si la ciudad ya existe
	 */
	private boolean existeCiudad(String c) {
		return ciudades.existe(c);
	}
	
	public void agregarCiudad(String nombre, int x, int y) throws Exception {
		Coordenadas coord = new Coordenadas(x,y);
		Ciudad c = new Ciudad(nombre, coord);
		posicionValida(coord);
		if(existeCiudad(nombre)) throw Existe;
		mapa[x][y] = nombre;
		ciudades.insert(nombre, c);
	}
	
	public void eliminarCiudad(String c) throws Exception {
		if(!existeCiudad(c)) throw NoExiste;
		Ciudad ciu = ciudades.consultar(c);
		//if(existenCaminosCon(c)) throw HayCaminos;
		eliminarCaminosConDestino(c);
		ciudades.delete(c);
		Coordenadas coord = ciu.consultarCoordenadas();
		mapa[coord.consultarY()][coord.consultarX()] = null;
		
	}
	
	//No aparece en el driver porque es llamaada por la funcion inferior
	public Ciudad consultarCiudad(String nombre) throws Exception {
		if(!existeCiudad(nombre)) throw NoExiste;
		return ciudades.consultar(nombre);
	}
	
	//Consulta una ciudad y ademas la devuelve en String para poder pasarla entre capas
	public String consultarCiudadToString(String nombre) throws Exception {
		Ciudad c = consultarCiudad(nombre);
		String ciudad = c.consultarNombre();
		int x = c.consultarCoordenadas().consultarX();
		int y = c.consultarCoordenadas().consultarY();
		String ciudadSt = String.format(ciudad + " " + Integer.toString(x) + " " + Integer.toString(y));
		//System.out.println("coordX: " + x +"    coordY: " + y + "\n" + ciudad + "\n");
		return ciudadSt;
	}
	
	public void modificarAtributosCiudad(String nombre, int x, int y) throws Exception {
		if(!ciudades.existe(nombre)) throw NoExiste;
		Ciudad cAnt = ciudades.consultar(nombre);
		Coordenadas coordAnt = cAnt.consultarCoordenadas();
		mapa[coordAnt.consultarY()][coordAnt.consultarX()] = null;
		Coordenadas coord = new Coordenadas(x,y);
		Ciudad c = new Ciudad(nombre, coord);
		ciudades.modificar(nombre, c);
		mapa[y][x] = nombre;
	}
	
	//No aparece en el driver porque es llamaada por la funcion inferior
	public ArrayList<String> listarCiudades() throws Exception{
		if(ciudades.isEmpty()) throw Vacio;
		return ciudades.consultar();
	}
	
	
	public String listarCiudadesToString() throws Exception {
		ArrayList<String> list = listarCiudades();
		String nombreC = new String();
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String n = it.next();
				//System.out.println(n + "\n");
			nombreC = nombreC + n + " ";
		}
		return nombreC;
	}
	
	
	//#########################################
	//##########SOBRE CAMINOS
	//#########################################
	
	private boolean existenCaminosCon(String cDest) {
		if(ciudades.existe(cDest)) return true;
		ArrayList<String> todosCamOrig = caminos.consultar();
		Iterator<String> it = todosCamOrig.iterator();
		
		boolean hay = false;
		while(it.hasNext()) {
			hay = caminos.consultar(it.next()).existe(cDest);
			if(hay) break;
		}
		return hay;
	}
	
	private void eliminarCaminosConDestino(String cDest) {
		caminos.delete(cDest);
		ArrayList<String> todosCamOrig = caminos.consultar();
		Iterator<String> it = todosCamOrig.iterator();
		while(it.hasNext()) {
			String nCiudad = it.next(); 
			boolean hay = caminos.consultar(nCiudad).existe(cDest);
			if(hay) {
				TST<ArrayList<Camino>> camDest = caminos.consultar(nCiudad);
				camDest.delete(cDest);
				caminos.modificar(nCiudad, camDest);
			}
		}
	}
	
	private boolean existeCamino(String cOrig, String cDest, String medio) {
			//System.out.println("Entra en existeCamino" + "\n");
		if(caminos.existe(cOrig)) {
			if(caminos.consultar(cOrig).existe(cDest)) {
				ArrayList<Camino> liCam= caminos.consultar(cOrig).consultar(cDest);
				Iterator<Camino> it = liCam.iterator();
				while(it.hasNext()) {
					Camino cAux = it.next();
					String cOrig2 = cAux.consultarOrigen(); 
					String cDest2 = cAux.consultarDestino();
					String medio2 = cAux.consultarTransporte();
					if(cOrig2.equals(cOrig) && 
							cDest2.equals(cDest) && 
							medio2.equals(medio)) {
						System.out.println("exitCamino devuelve: " + true + "\n");
						return true;
					}
				}
			}
		}
		System.out.println("exitCamino devuelve: " + false + "\n");
		return false;
	}
	
	private boolean existeCamino(Camino c) {
		String cOrig = c.consultarOrigen();
		String cDest = c.consultarDestino();
		String medio = c.consultarTransporte();
		return existeCamino(cOrig, cDest, medio);
	}
	
	public void agregarCamino(String cOrig, String cDest, String medio, int cap) throws Exception {
		if(!existeCiudad(cOrig) || !existeCiudad(cDest)) throw NoExistenCiudades;
			//System.out.println("Entra en agregarCamino" + "\n");
		if(cOrig.equals(cDest)) throw NoValido;
			//System.out.println("cOrig:" + cOrig + "cDest:" + cDest +"fin" +"\n" +
			//"medio" + medio + cap + "\n");
			//System.out.println("Despues de comparacion" + "\n");
		Camino c = new Camino(cOrig, cDest, cap, medio);
			//System.out.println("Despues de camino" + "\n");
		if(existeCamino(c)) throw Existe;
			//System.out.println("Despues de comparacion existe camino" + "\n");
		TST<ArrayList<Camino>> camOrig = new TST<ArrayList<Camino>>();
		ArrayList<Camino> camDest = new ArrayList<Camino>();
			//System.out.println("Despues inicializar" + "\n");
		if(caminos.existe(cOrig)) {
			//camOrig tiene el TST de TST de caminos con ciudad origen cOrig
			camOrig = caminos.consultar(cOrig);
			if(camOrig.existe(cDest)) {
				//camDest tiene tiene el TST de ciudades con origen cOrig y destino cDest
				camDest = camOrig.consultar(cDest);
				camDest.add(c);
			}
			else {
				camDest = new ArrayList<Camino>();
				camDest.add(c);
			}
			camOrig.modificar(cDest, camDest);
			caminos.modificar(cOrig, camOrig);
		}
		else {
			//No hay ningun camino con ciudad de origen cOrig
			camDest = new ArrayList<Camino>();
			camDest.add(c);
			camOrig = new TST<ArrayList<Camino>>();
			camOrig.insert(cDest, camDest);
			caminos.insert(cOrig, camOrig);
		}
	}
	
	//No aparece en el driver porque es llamaada por la funcion inferior
	public ArrayList<Camino> consultarCaminos(String cOrig, String cDest) throws Exception {
		ArrayList<Camino> listCamino =  caminos.consultar(cOrig).consultar(cDest);
		if(listCamino == null) throw NoExiste;
		return listCamino;		
	}
	
	public String consultarCaminosToString(String cOrig, String cDest) throws Exception {
		ArrayList<Camino> listCamino = consultarCaminos(cOrig, cDest);
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
	
	//No aparece en el driver porque es llamaada por la funcion inferior
	public Camino consultarCamino(String cOrig, String cDest, String medio) throws Exception {
		if(!existeCamino(cOrig, cDest, medio)) throw NoExiste;
		ArrayList<Camino> liCam= caminos.consultar(cOrig).consultar(cDest);
		Iterator<Camino> it = liCam.iterator();
		while(it.hasNext()) {
			Camino cAux = it.next();
			String cOrig2 = cAux.consultarOrigen(); 
			String cDest2 = cAux.consultarDestino();
			String medio2 = cAux.consultarTransporte();
			if(cOrig2.equals(cOrig) && 
					cDest2.equals(cDest) && 
					medio2.equals(medio)) {
				return cAux;
			}
		}
		return null;
	}
	
	public String consultarCaminoToString(String cOrig, String cDest, String medio) throws Exception {
		Camino c = consultarCamino(cOrig, cDest, medio);
		String cam = cOrig + " " + cDest + " " + medio + " " + Integer.toString(c.consultarCapacidad());
		return cam;
	}
	
	public void eliminarCamino(String cOrig, String cDest, String medio) throws Exception {
		Camino c = consultarCamino(cOrig, cDest, medio);
		TST<ArrayList<Camino>> camOrig = caminos.consultar(cOrig);
		ArrayList<Camino> camDest = camOrig.consultar(cDest);
		camDest.remove(c);
		camOrig.modificar(cDest, camDest);
		caminos.modificar(cOrig, camOrig);
	}
	
	public void modificarAtributosCamino(String cOrig, String cDest, String medio, int cap) throws Exception {
		Camino c = new Camino(cOrig, cDest, cap, medio);
		if(!existeCamino(c)) throw NoExiste;
		TST<ArrayList<Camino>> camOrig = caminos.consultar(cOrig);
		ArrayList<Camino> camDest = camOrig.consultar(cDest);
		Camino cam = null;
		Iterator<Camino> it = camDest.iterator();
		while(it.hasNext()) {
			cam = it.next();
			if(cam.consultarTransporte().equals(c.consultarTransporte())) {
				break;
			}
			else cam = null;
		}
		//if(cam == null) throw 
		camDest.remove(cam);
		camDest.add(c);
		camOrig.modificar(cDest, camDest);
		caminos.modificar(cOrig, camOrig);
	}
	
	
	public ArrayList<Camino> consultarTodosCaminos() {
		ArrayList<Camino> todoCaminos = new ArrayList<Camino>();
		ArrayList<String> camOrig = caminos.consultar();
		Iterator<String> it = camOrig.iterator();
		while(it.hasNext()) {
			todoCaminos.addAll(consultarCaminosDestino(it.next()));
		}
		return todoCaminos;
	}
	
	public String consultarTodosCaminosToString() {
		ArrayList<Camino> todoCaminos = consultarTodosCaminos();
		Iterator<Camino> it = todoCaminos.iterator();
		String listC = new String();
		while(it.hasNext()) {
			Camino c = it.next();
			listC = listC + c.consultarOrigen() + " " + c.consultarDestino() + " " + 
			c.consultarTransporte() + " " + Integer.toString(c.consultarCapacidad()) + "\n";
		}
		return listC;
	}
	
	
	
	//No aparece en el driver porque es llamaada por la funcion inferior
	public ArrayList<Camino> consultarCaminosDestino(String cOrig) {
		//Caminos de la misma ciudad origen
		TST<ArrayList<Camino>> camOrig = caminos.consultar(cOrig);
		
		//Lista de ciudades destino
		ArrayList<String> nCamDest = camOrig.consultar();
		
		//Donde se guardaran todos los caminos de salida posibles
		ArrayList<Camino> cPosibles = new ArrayList<Camino>();
		//Iterador para recorrer todos los destinos existentes
		Iterator<String> it = nCamDest.iterator();
		while(it.hasNext()) {
			cPosibles.addAll(camOrig.consultar(it.next()));

		}
		//cPosibles tiene todos los caminos ordenadoes por la ciudad destino
		return cPosibles;
	}
	
	public String consultarCaminosDestinoToString(String cOrig) throws Exception {
		ArrayList<Camino> listCamino = consultarCaminosDestino(cOrig);
		if(listCamino.isEmpty()) return null;
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
	
	
	public ArrayList<Camino> consultarTodosCaminos() {
		  ArrayList<Camino> todoCaminos = new ArrayList<Camino>();
		  ArrayList<String> camOrig = caminos.consultar();
		  Iterator<String> it = camOrig.iterator();
		  while(it.hasNext()) {
		   todoCaminos.addAll(consultarCiudadesDestino(it.next()));
		  }
		  return todoCaminos;
	}
	
	
	//#########################################
	//##########Gestion de datos
	//#########################################
	
	/**
	 * Guardar ciudades
	 * @param path
	 * @param file
	 * @throws Exception si file no existe
	 */
	public void GuardarCiudades(GestorDatos gd) throws Exception {
		
		//GestorDatos gd = new GestorDatos(path,file);
		
		gd.createFile(); 
		gd.openFile("write"); 
		
		
		ArrayList<String> lista = new ArrayList<String>();
		lista = ciudades.consultar(); 
		
		String linea = Integer.toString(lista.size()) + "\n"; 
		buffer = linea; 
		
				
		for(int i = 0; i < lista.size(); ++i){
			String s = lista.get(i); 
			Ciudad aux = ciudades.consultar(s); 
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
		
		gd.closeFile(); 
	}
	
	/**
	 * Cargar ciudades a mapa 
	 * @param path
	 * @param file
	 * @throws Exception
	 */
	public void CargarCiudades(GestorDatos gd) throws Exception{
		
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
	 * Guardar caminos del mapa
	 * @param path
	 * @param file
	 * @throws Exception
	 */
	public void GuardarCaminos(GestorDatos gd) throws Exception {
		//GestorDatos gd = new GestorDatos(path,file);
		
		gd.createFile(); 
		gd.openFile("write"); 
		
		ArrayList<Camino> lista = new ArrayList<Camino>(); 
		lista = consultarTodosCaminos(); 

		String linea = Integer.toString(lista.size()) + "\n"; 
		buffer = linea; 
				
		for(int i = 0; i < lista.size(); ++i){

			String co = lista.get(i).consultarOrigen(); 
			int cap = lista.get(i).consultarCapacidad(); 
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
		
		gd.closeFile(); 
	}
	
	/**
	 * Cargar caminos en el mapa
	 * @param path
	 * @param file
	 * @throws Exception
	 */
	public void CargarCaminos(GestorDatos gd) throws Exception{
		
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
				agregarCamino(c); 
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
					agregarCamino(c); 
					/////////////per comprovar ////////////////
					System.out.print(co + " "+ capac + " " + cd + " " + trans + "\n"); 
					/////////////////////////////////////////////
					i++; 
				}
			}
		
		gd.closeFile(); 
	}
	}
	
	
	
	//#########################################
	//##########CONSULTORAS
	//#########################################
	
	//No aparece en el driver porque es llamaada por la funcion inferior
	public String[][] consultarMapa() {
		return mapa;
	}
	
	public String consultarMapaToString() {
		String map = new String();
		for(int i = 0; i < mapa.length; ++i) {
			for(int j = 0; j < mapa[0].length; ++j) {
				map = map + mapa[i][j] + " ";
			}
			map = map + "\n";
		}
		return map;
	}
	
}
