import java.util.*;


public class Mapa {
	
	
	private TST<TST<ArrayList<Camino>>> caminos;
	private TST <Ciudad> ciudades;
	private String[][] mapa;
	
	private static Exception CoordInvalidas = new Exception ("Estas "
			+ "coordenadas no son validas para este mapa");
	private static Exception Existe = new Exception ("Este elemento ya existe");
	private static Exception NoExiste = new Exception ("Este elemento no existe");
	private static Exception NoExistenCiudades = new Exception ("No existe alguna"
			+ "de las ciudades o ambas");
	private static Exception Vacio = new Exception ("Esta vacio");
	//private static Exception HayCaminos = new Exception ("Hay caminos que usan esta ciudad");
	private static Exception NoValido = new Exception ("No valido");
	
	
	
	/*
	 * Constructor Ciudad
	 */
	/**
	 * Constructora de Mapa
	 * @param anchuraX
	 * @param alturaY
	 * @param continente
	 * @throws Exception
	 */
	public Mapa(int anchuraX, int alturaY, ArrayList<Coordenadas> continente) throws Exception {
		//continente es cerrado siempre
		ciudades = new TST<Ciudad>();
		caminos = new TST<TST<ArrayList<Camino>>>();
		mapa = new String[alturaY][anchuraX];
		
		//continente debe de tener una doble marca de  $ para indicar que es el final
		//de la forma: numeroX " " numeroY " "...
		agregarContinente(continente);
	}
	
	//#########################################
	//##########SOBRE MAPA
	//#########################################
	
	/**
	 * 
	 * @param noValido
	 * @throws Exception
	 */
	private void delimitar(ArrayList<Coordenadas> noValido) throws Exception {
		Coordenadas co = noValido.get(0);
		int xAnt = co.consultarX();
		int yAnt = co.consultarY();
		mapa[yAnt][xAnt] = "$";
		for(int i = 1; i < noValido.size(); ++i) {
			co = noValido.get(i);
			int x = co.consultarX();
			int y = co.consultarY();
			if(x < 0 || x >= mapa[0].length || y < 0 || y >= mapa.length) throw CoordInvalidas;
				//System.out.println("Comprobando validez de la limitacion x: " + x + "    y: " + y + "\n");
			//Comprobar si con consecuentes las coordenadas
			if((x == (xAnt + 1) && y == yAnt) ||
					(x == (xAnt + 1) && y == (yAnt + 1)) ||
					(y == (yAnt + 1) && x == xAnt) ||
					(x == (xAnt - 1) && y == (yAnt + 1)) ||
					(x == (xAnt - 1) && y == yAnt) ||
					(x == (xAnt - 1) && y == (yAnt - 1)) ||
					(y == (yAnt - 1) && x == xAnt) ||
					(x == (xAnt + 1) && y == (yAnt - 1))) {
					//System.out.println("Delimitando x y: " + x + " " + y + "\n");
				mapa[y][x] = "$";
			}
			else {
					//System.out.println("no conexa con siguiente" + "\n");
				throw CoordInvalidas;
			}
			xAnt = x;
			yAnt = y;
			if(i+1 == noValido.size()) {
					//System.out.println("ultimo elemento" + "\n");
				co = noValido.get(0);
				int xPrim = co.consultarX();
				int yPrim = co.consultarY();
					//System.out.println("ultimo elemento2" + "\n");
				if((xPrim == (xAnt + 1) && yPrim == yAnt) ||
						(xPrim == (xAnt + 1) && yPrim == (yAnt + 1)) ||
						(yPrim == (yAnt + 1) && xPrim == xAnt) ||
						(xPrim == (xAnt - 1) && yPrim == (yAnt + 1)) ||
						(xPrim == (xAnt - 1) && yPrim == yAnt) ||
						(xPrim == (xAnt - 1) && yPrim == (yAnt - 1)) ||
						(yPrim == (yAnt - 1) && xPrim == xAnt) ||
						(xPrim == (xAnt + 1) && yPrim == (yAnt - 1))) {
						//System.out.println("antes de return" + "\n");
					return;
				}
				else {
						//System.out.println("ultima no conexa con primera" + "\n");
					throw CoordInvalidas;
				}
			}
		}
	}
	
	/**
	 * 
	 * @param noValido
	 * @throws Exception
	 */
	private void agregarContinente(ArrayList<Coordenadas> noValido) throws Exception {
		if(noValido != null) {
			delimitar(noValido);
				//System.out.println("despues de delimitar" + "\n");
			//invalidar el exterior del are util
			for(int i = 0; i < mapa.length; ++i) {
				for(int j = 0; j < mapa[0].length && mapa[i][j] != "$"; ++j) {
					mapa[i][j] ="$";
						//System.out.println("Posicionhacia -->: " + i + " " + j + "\n");
				}
				for(int k = mapa[0].length - 1; k >= 0 && mapa[i][k] != "$"; --k) {
					mapa[i][k] ="$";
						//System.out.println("Posicionhacia <--: " + i + " " + k + "\n");
				}
			}
		}
	}
	
	
	/*
	 * Comprobar si la Coord es valida para el mapa
	 */
	/**
	 * 
	 * @param coord
	 * @throws Exception
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
	/**
	 * 
	 * @param c
	 * @return
	 */
	private boolean existeCiudad(String c) {
		return ciudades.existe(c);
	}
	
	public void agregarCiudad(Ciudad c) throws Exception {
		Coordenadas coord = c.consultarCoordenadas();
		String nombre = c.consultarNombre();
		posicionValida(coord);
		if(existeCiudad(nombre)) throw Existe;
		int x = coord.consultarX();
		int y = coord.consultarY();
		mapa[y][x] = nombre;
		ciudades.insert(nombre, c);
	}
	
	/**
	 * 
	 * @param c
	 * @throws Exception
	 */
	public void eliminarCiudad(String c) throws Exception {
		if(!existeCiudad(c)) throw NoExiste;
		//if(existenCaminosCon(c)) throw HayCaminos;
			//System.out.println("Antes de eliminar caminos con destino" + "\n");
		eliminarCaminosConDestino(c);
			//System.out.println("Antes de eliminar la ciudad" + "\n");
		Ciudad ciu = ciudades.consultar(c);
		ciudades.delete(c);
		Coordenadas coord = ciu.consultarCoordenadas();
			//System.out.println("Antes de eliminar en mapa" + "\n");
		int x = coord.consultarX();
		int y = coord.consultarY();
		mapa[y][x] = null;
	}
	
	/**
	 * 
	 * @param nombre
	 * @return
	 * @throws Exception
	 */
	public Ciudad consultarCiudad(String nombre) throws Exception {
		if(!existeCiudad(nombre)) throw NoExiste;
		return ciudades.consultar(nombre);
	}

	public void modificarAtributosCiudad(String nombre, int x, int y) throws Exception {
		if(!ciudades.existe(nombre)) throw NoExiste;
		Coordenadas coord = new Coordenadas(x,y);
		posicionValida(coord);
		Ciudad cAnt = ciudades.consultar(nombre);
		Coordenadas coordAnt = cAnt.consultarCoordenadas();
		mapa[coordAnt.consultarY()][coordAnt.consultarX()] = null;
		Ciudad c = new Ciudad(nombre, coord);
		ciudades.modificar(nombre, c);
		mapa[y][x] = nombre;
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String> listarCiudades() throws Exception{
		if(ciudades.isEmpty()) throw Vacio;
		return ciudades.consultar();
	}
	
	//#########################################
	//##########SOBRE CAMINOS
	//#########################################
	
	/**
	 * 
	 * @param cDest
	 * @return
	 */
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
	
	/**
	 * 
	 * @param cDest
	 */
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
	
	/**
	 * 
	 * @param cOrig
	 * @param cDest
	 * @param medio
	 * @return
	 */
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
							//System.out.println("exitCamino devuelve: " + true + "\n");
						return true;
					}
				}
			}
		}
			//System.out.println("exitCamino devuelve: " + false + "\n");
		return false;
	}
	
	/**
	 * 
	 * @param cOrig
	 * @param cDest
	 * @return
	 */
	public boolean existeCaminoDesdeA(String cOrig, String cDest) {
		if(caminos.existe(cOrig)) {
			return (caminos.consultar(cOrig).existe(cDest));
		}
		return false;
	}
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	private boolean existeCamino(Camino c) {
		String cOrig = c.consultarOrigen();
		String cDest = c.consultarDestino();
		String medio = c.consultarTransporte();
		return existeCamino(cOrig, cDest, medio);
	}
	
	/**
	 * 
	 * @param c
	 * @throws Exception
	 */
	public void agregarCamino(Camino c) throws Exception {
		String cOrig = c.consultarOrigen();
		String cDest = c.consultarDestino();
		String medio = c.consultarTransporte();
		if(!existeCiudad(cOrig) || !existeCiudad(cDest)) throw NoExistenCiudades;
			//System.out.println("Entra en agregarCamino" + "\n");
		if(cOrig.equals(cDest)) throw NoValido;
			//System.out.println("cOrig:" + cOrig + "cDest:" + cDest +"fin" +"\n" +
			//"medio" + medio + cap + "\n");
			//System.out.println("Despues de comparacion" + "\n");
		if(existeCamino(cOrig, cDest, medio)) throw Existe;
			//System.out.println("Despues de comparacion existe camino" + "\n");
		TST<ArrayList<Camino>> camOrig = new TST<ArrayList<Camino>>();
		ArrayList<Camino> camDest = new ArrayList<Camino>();
			//System.out.println("Despues inicializar" + "\n");
			//System.out.println(cOrig + " " + cDest + "\n");
		if(caminos.existe(cOrig)) {
			//camOrig tiene el TST de TST de caminos con ciudad origen cOrig
			camOrig = caminos.consultar(cOrig);
			if(camOrig.existe(cDest)) {
					//System.out.println("en IF camOrig.existe(cDest)" + "\n");
				//camDest tiene tiene el TST de ciudades con origen cOrig y destino cDest
				camDest = camOrig.consultar(cDest);
				camDest.add(c);
					//System.out.println("Tiene " + camDest.size() + " \n");
				camOrig.modificar(cDest, camDest);
			}
			else {
					//System.out.println("en ELSE camOrig.existe(cDest)" + "\n");
				camDest = new ArrayList<Camino>();
				camDest.add(c);
				camOrig.insert(cDest, camDest);
			}
				//System.out.println("antes de modificar)" + "\n");
				//System.out.println("Tiene " + camDest.size() + " \n");
			caminos.modificar(cOrig, camOrig);
				//System.out.println("Despues de modificar)" + "\n");
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
	
	/**
	 * 
	 * @param cOrig
	 * @param cDest
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Camino> consultarCaminosEntre(String cOrig, String cDest) throws Exception {
		ArrayList<Camino> listCamino =  caminos.consultar(cOrig).consultar(cDest);
		if(listCamino == null) throw NoExiste;
		return listCamino;		
	}
	
	/**
	 * 
	 * @param cOrig
	 * @param cDest
	 * @param medio
	 * @return
	 * @throws Exception
	 */
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
	
	/**
	 * 
	 * @param cOrig
	 * @param cDest
	 * @param medio
	 * @throws Exception
	 */
	public void eliminarCamino(String cOrig, String cDest, String medio) throws Exception {
		Camino c = consultarCamino(cOrig, cDest, medio);
		TST<ArrayList<Camino>> camOrig = caminos.consultar(cOrig);
		ArrayList<Camino> camDest = camOrig.consultar(cDest);
		camDest.remove(c);
		camOrig.modificar(cDest, camDest);
		caminos.modificar(cOrig, camOrig);
	}
	
	/**
	 * 
	 * @param cOrig
	 * @param cDest
	 * @param medio
	 * @param cap
	 * @throws Exception
	 */
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
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Camino> consultarTodosCaminos() {
		ArrayList<Camino> todoCaminos = new ArrayList<Camino>();
		ArrayList<String> camOrig = caminos.consultar();
		Iterator<String> it = camOrig.iterator();
		while(it.hasNext()) {
			todoCaminos.addAll(consultarCaminosDestino(it.next()));
		}
		return todoCaminos;
	}
	
	/**
	 * Consultora de los caminos desde una ciudad
	 * @param cOrig
	 * @return Todos los caminos alcanzables desde una ciudad cOrig
	 */
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
	

	//#########################################
	//##########CONSULTORAS
	//#########################################
	
	/**
	 * Consultora de la matriz de string
	 * @return matriz con los identificadores de las ciudades en su posicion
	 */
	public String[][] consultarMapa() {
		return mapa;
	}
	

	
}
