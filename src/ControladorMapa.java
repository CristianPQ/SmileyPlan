import java.util.*;

public class ControladorMapa {

	private Mapa m;
	
	private static Exception NoExiste = new Exception ("Este elemento no existe");
	
	public ControladorMapa(int anchuraX, int alturaY, String continente) throws Exception {
		
		//Para delimitar el continente son necesarios por lo menos 4 coordenadas
		ArrayList<Coordenadas> cont = continente(continente);
		m = new Mapa(anchuraX, alturaY, cont);
	}
	
	//Transforma el String en un tipo valido para mapa
	private ArrayList<Coordenadas> continente(String cont) {
		ArrayList<Coordenadas> borde = new ArrayList<Coordenadas>();
		String[] cArray = cont.split(" ");;
		for(int i = 0; cArray[i] != "$" && cArray[i+1] != "$"; i += 2) {
			int x = Integer.parseInt(cArray[1]);
			int y = Integer.parseInt(cArray[1+1]);
			borde.add(new Coordenadas(x, y));
		}
		if(borde.size() < 4) return null;
		return borde;
	}
	
	
	//#########################################
	//##########SOBRE CIUDADES
	//#########################################
	
	public void agregarCiudad(String nombre, int x, int y) throws Exception {
		Coordenadas coord = new Coordenadas(x,y);
		Ciudad c = new Ciudad(nombre, coord);
		m.agregarCiudad(c);
	}
	
	public void eliminarCiudad(String c) throws Exception {
		m.eliminarCiudad(c);
	}
	
	public Ciudad consultarCiudad(String c) throws Exception {
		return m.consultarCiudad(c);
	}
	
	//Consulta una ciudad y ademas la devuelve en String para poder pasarla entre capas
	public String consultarCiudadToString(String nombre) throws Exception {
		Ciudad c = m.consultarCiudad(nombre);
		int x = c.consultarCoordenadas().consultarX();
		int y = c.consultarCoordenadas().consultarY();
		String ciudadSt = nombre + " " + Integer.toString(x) + " " + Integer.toString(y) + "\n";
		//System.out.println("coordX: " + x +"    coordY: " + y + "\n" + ciudad + "\n");
		return ciudadSt;
	}
	
	public void modificarAtributosCiudad(String nombre, int x, int y) throws Exception {
		m.modificarAtributosCiudad(nombre, x, y);
	}
	
	public ArrayList<String> listarCiudades() throws Exception{
		return m.listarCiudades();
	}
	
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
	
	public void agregarCamino(String cOrig, String cDest, String medio, int cap, ControladorMedioTransporte contMT) throws Exception {
		
		//Comprobar que el medioTransporte ya existe
		if(!contMT.existe(medio)) throw NoExiste;
		Camino c = new Camino(cOrig, cDest, cap, medio);
		m.agregarCamino(c);
	}
	
	public Camino consultarCamino(String cOrig, String cDest, String med) throws Exception {
		return m.consultarCamino(cOrig, cDest, med);
	}

	public String consultarCaminoToString(String cOrig, String cDest, String medio) throws Exception {
		Camino c = m.consultarCamino(cOrig, cDest, medio);
		String cam = cOrig + " " + cDest + " " + medio + " " + Integer.toString(c.consultarCapacidad()) + "\n";
		return cam;
	}
	
	public ArrayList<Camino> consultarCaminosEntre(String cOrig, String cDest) throws Exception {
		return m.consultarCaminosEntre(cOrig, cDest);
	}
	
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
	
	public void modificarAtributosCamino(String cOrig, String cDest, String medio, int cap) throws Exception {
		m.modificarAtributosCamino(cOrig, cDest, medio, cap);
	}
	
	//A partir de una ciudad origen se devuelven los identificadores de las ciudades que se pueden alcanzar
	public ArrayList<Camino> consultarCaminosDestino(String cOrig) {
		return m.consultarCaminosDestino(cOrig);
	}
	
	public ArrayList<Camino> consultarTodosCaminos() {
		return m.consultarTodosCaminos();
	}
	
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
	
	public String consultarCaminosDestinoToString(String cOrig) throws Exception {
		ArrayList<Camino> listCamino = m.consultarCaminosDestino(cOrig);
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
	
	//#########################################
	//##########OTROS
	//#########################################
	
	public String[][] consultarMapa() {
		return m.consultarMapa();
	}
	
	public String consultarMapaToString() {
		String map = new String();
		String[][] ma = consultarMapa();
		for(int i = 0; i < ma.length; ++i) {
			for(int j = 0; j < ma[0].length; ++j) {
				map = map + ma[i][j] + " ";
			}
			map = map + "\n";
		}
		return map;
	}
	
	//#########################################
	//##########Gestion de datos
	//#########################################
	
	/**
	 * Guardar caminos del mapa
	 * @param path
	 * @param file
	 * @throws Exception
	 */
	public void GuardarCaminos(String path,String file) throws Exception{
		GestorDatos gd = new GestorDatos(path,file); 
		m.GuardarCaminos(gd);
	}
	
	/**
	 * Guardar ciudades del mapa
	 * @param path
	 * @param file
	 * @throws Exception
	 */
	public void GuardarCiudades(String path,String file) throws Exception{
		GestorDatos gd = new GestorDatos(path,file); 
		m.GuardarCiudades(gd);
	}
	
	/**
	 * Cargar ciudades del mapa
	 * @param path
	 * @param file
	 * @throws Exception
	 */
	public void CargarCiudades(String path,String file) throws Exception {
		GestorDatos gd = new GestorDatos(path,file); 
		m.CargarCiudades(gd);
	}
	
	/**
	 * Cargar caminos del mapa
	 * @param path
	 * @param file
	 * @throws Exception
	 */
	public void CargarCaminos(String path, String file) throws Exception {
		GestorDatos gd = new GestorDatos(path,file); 
		m.CargarCaminos(gd); 
	}

	
}
