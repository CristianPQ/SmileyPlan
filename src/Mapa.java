import java.util.*;


public class Mapa {
	
	
	private Grafo<Ciudad,Camino> g;
	/*private TST<TST<ArrayList<Camino>>> caminos;
	private TST <Ciudad> ciudades;*/
	private String[][] mapa;
	private ArrayList<Coordenadas> coord; 
	
	private static Exception CoordInvalidas = new Exception ("Estas "
			+ "coordenadas no son validas para este mapa");
	private static Exception Existe = new Exception ("Este elemento ya existe");
	private static Exception NoExiste = new Exception ("Este elemento no existe");
	private static Exception NoExistenCiudades = new Exception ("No existe alguna"
			+ "de las ciudades o ambas");
	private static Exception Vacio = new Exception ("Esta vacio");
	//private static Exception HayCaminos = new Exception ("Hay caminos que usan esta ciudad");
	private static Exception NoValido = new Exception ("No valido");
	
	
	
	/**
	 * Constructora de Mapa
	 * @param anchuraX
	 * @param alturaY
	 * @param continente
	 * @throws Exception
	 */
	public Mapa(int anchuraX, int alturaY, ArrayList<Coordenadas> continente) throws Exception {
		//continente es cerrado siempre
		g = new Grafo<Ciudad, Camino>();
		mapa = new String[alturaY][anchuraX];
		coord = continente; 
		
		agregarContinente(continente);
	}
	
	//#########################################
	//##########SOBRE MAPA
	//#########################################
	
	/**
	 * Delimita el mapa 
	 * @param noValido posiciones que delimitan el mapa
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
	 * Agregar un continente en el mapa 
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
	
	
	
	/**
	 * Comprueva si una coordenada es valida para el mapa 
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
	
	/**
	 * Consultora de la anchura de mapa
	 * @return anchura mapa
	 */
	public int consultarAnchura() {
		return mapa[0].length; 
	}
	
	/**
	 * Consultora de la altura de mapa
	 * @return altura de mapa
	 */
	public int consultarAltura() {
		return mapa.length; 
	}
	
	public ArrayList<Coordenadas> consultarArrayCoord(){
		return coord; 
	}
	
	//#########################################
	//##########SOBRE CIUDADES
	//#########################################
	
	/**
	 * Devuelve la distancia entre las ciudades cOrig y cDest
	 * @param cOrig
	 * @param cDest
	 * @return distancia 
	 * @throws Exception
	 */
	public int distanciaCiudades(String cOrig, String cDest) throws Exception {
		if(!existeCiudad(cOrig) || !existeCiudad(cDest)) throw NoExiste;
		Ciudad ciuO = consultarCiudad(cOrig);
		Coordenadas coordO = ciuO.consultarCoordenadas();
		Ciudad ciuD = consultarCiudad(cDest);
		Coordenadas coordD = ciuD.consultarCoordenadas();
		return coordO.distancia(coordD);
	}
	
	
	/**
	 * Comprueva si la ciudad ya existe
	 * @param c
	 * @return
	 */
	public boolean existeCiudad(String c) {
		return g.existeVertice(c);
	}
	
	/**
	 * Agrega una ciudad c en el mapa
	 * @param c
	 * @throws Exception
	 */
	public void agregarCiudad(Ciudad c) throws Exception {
		Coordenadas coord = c.consultarCoordenadas();
		String nombre = c.consultarNombre();
		posicionValida(coord);
		if(existeCiudad(nombre)) throw Existe;
		int x = coord.consultarX();
		int y = coord.consultarY();
		mapa[y][x] = nombre;
		
		int index = g.siguiente();
		c.equivalente(index);
		g.agregarVertice(c, index);
	}
	
	/**
	 * Elimina una ciudad c del mapa
	 * @param c
	 * @throws Exception
	 */
	public void eliminarCiudad(String c) throws Exception {
		if(!existeCiudad(c)) throw NoExiste;
		//if(existenCaminosCon(c)) throw HayCaminos;
			//System.out.println("Antes de eliminar caminos con destino" + "\n");
			//System.out.println("Antes de eliminar la ciudad" + "\n");
		Ciudad ciu = g.consultarVertice(c);
		int index = ciu.consultarEquivalente();
		eliminarCaminosConDestino(c);
		eliminarCaminosConOrigen(c);
		g.eliminarVertice(c, index);
		Coordenadas coord = ciu.consultarCoordenadas();
			//System.out.println("Antes de eliminar en mapa" + "\n");
		int x = coord.consultarX();
		int y = coord.consultarY();
		mapa[y][x] = null;
	}
	
	/**
	 * Devuelve la ciudad con el nombre que se pasa como parametro
	 * @param nombre
	 * @return ciudad
	 * @throws Exception
	 */
	public Ciudad consultarCiudad(String nombre) throws Exception {
		if(!existeCiudad(nombre)) throw NoExiste;
		return g.consultarVertice(nombre);
	}

	/**
	 * Modificadora de los atributos x e y de ciudad
	 * @param nombre de la ciudad que se quiere modificar
	 * @param x
	 * @param y
	 * @throws Exception
	 */
	public void modificarAtributosCiudad(String nombre, int x, int y) throws Exception {
		if(!existeCiudad(nombre)) throw NoExiste;
		Coordenadas coord = new Coordenadas(x,y);
		posicionValida(coord);
		Ciudad cAnt = g.consultarVertice(nombre);
		int eq = cAnt.consultarEquivalente();
		Coordenadas coordAnt = cAnt.consultarCoordenadas();
		mapa[coordAnt.consultarY()][coordAnt.consultarX()] = null;
		Ciudad c = new Ciudad(nombre, coord, eq);
		g.modificarVertice(nombre, c);
		mapa[y][x] = nombre;
	}
	
	/**
	 * Devuelve un array con los identificadores de las ciudades
	 * @return array 
	 * @throws Exception
	 */
	public ArrayList<String> listarCiudades() throws Exception{
		if(g.isEmpty()) throw Vacio;
		return g.consultarVerticesID();
	}
	
	//#########################################
	//##########SOBRE CAMINOS
	//#########################################
	
	/**
	 * Consultora de si existe un Camino con el origen cOrig
	 * @param cOrig
	 * @return booleano
	 */
	public boolean existeCaminoConOrigen(String cOrig) {
		Ciudad c = g.consultarVertice(cOrig);
		int index = c.consultarEquivalente();
		return g.existeAristaConOrigen(index);
	}
	
	/**
	 * Consultora de si existe un Camino con el destino cDest
	 * @param cDest
	 * @return booleano
	 */
	private boolean existenCaminosCon(String nC) {
		Ciudad c = g.consultarVertice(nC);
		int index = c.consultarEquivalente();
		return g.existeAristaCon(index);
	}
	
	private void eliminarCaminosCon(String c) {
		Ciudad ciu = g.consultarVertice(c);
		int index = ciu.consultarEquivalente();
		ArrayList<Camino> ent = g.consultarAristasEntrada(index);
		ArrayList<Camino> sal = g.consultarAristasSalida(index);
		for(int i = 0; i < ent.size(); ++i) {
			Camino cam = ent.get(i);
			int index2 = g.consultarVertice(cam.consultarOrigen()).consultarEquivalente();
			g.eliminarArista(cam, index, index2);
		}
		for(int j = 0; j < sal.size(); ++j) {
			Camino cam = sal.get(j);
			int index2 = g.consultarVertice(cam.consultarDestino()).consultarEquivalente();
			
		}
	}
	
	/**
	 * Elimina caminos con el destino cDest
	 * @param cDest
	 */
	private void eliminarCaminosConDestino(String cDest) {
		Ciudad c = g.consultarVertice(cDest);
		int index = c.consultarEquivalente();
		ArrayList<Camino> ent = g.consultarAristasEntrada(index);
		for(int i = 0; i < ent.size(); ++i) {
			Camino cam = ent.get(i);
			int index2 = g.consultarVertice(cam.consultarOrigen()).consultarEquivalente();
			g.el
		}
		
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
	
	private void eliminarCaminosConOrigen(String cOrig) {
		dd
	}
	
	/**
	 * Consulta si existe un camino con los atributos que pasamos como parametro
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
	 * Consulta si existe un camino desde cOrig hasta cDest 
	 * @param cOrig
	 * @param cDest
	 * @return booleano
	 */
	public boolean existeCaminoDesdeA(String cOrig, String cDest) {
		if(caminos.existe(cOrig)) {
			return (caminos.consultar(cOrig).existe(cDest));
		}
		return false;
	}
	
	/**
	 * Consulta si existe un camino c
	 * @param c
	 * @return booleano
	 */
	private boolean existeCamino(Camino c) {
		String cOrig = c.consultarOrigen();
		String cDest = c.consultarDestino();
		String medio = c.consultarTransporte();
		return existeCamino(cOrig, cDest, medio);
	}
	
	/**
	 * Agrega un camino c en el mapa 
	 * @param c
	 * @throws Exception
	 */
	public void agregarCamino(Camino c) throws Exception {
		String cOrig = c.consultarOrigen();
		String cDest = c.consultarDestino();
		String medio = c.consultarTransporte();
		if(!existeCiudad(cOrig) || !existeCiudad(cDest)) throw NoExistenCiudades;
		if(cOrig.equals(cDest)) throw NoValido;
		if(existeCamino(cOrig, cDest, medio)) throw Existe;
		TST<ArrayList<Camino>> camOrig = new TST<ArrayList<Camino>>();
		ArrayList<Camino> camDest = new ArrayList<Camino>();
		if(caminos.existe(cOrig)) {
			camOrig = caminos.consultar(cOrig);
			if(camOrig.existe(cDest)) {
				camDest = camOrig.consultar(cDest);
				camDest.add(c);
				camOrig.modificar(cDest, camDest);
			}
			else {
				camDest = new ArrayList<Camino>();
				camDest.add(c);
				camOrig.insert(cDest, camDest);
			}
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
	
	/**
	 * Devuelve un array con los caminos entre cOrig y cDest 
	 * @param cOrig
	 * @param cDest
	 * @return array
	 * @throws Exception
	 */
	public ArrayList<Camino> consultarCaminosEntre(String cOrig, String cDest) throws Exception {
		ArrayList<Camino> listCamino =  caminos.consultar(cOrig).consultar(cDest);
		if(listCamino == null) throw NoExiste;
		return listCamino;		
	}
	
	/**
	 * Devuelve el camino con cOrig, cDest y medio 
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
	 * Elimina el camino con cOrig, cDest y medio
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
	 * Modifica los atributos del camino 
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
	 * Devuelve un array con todos los caminos del mapa 
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
	
	
	
	//TIENE QUE SER PRIVADA O NO SE PUEDE DEVOLVER UNA ESTRUCTURA DE ESTE TIPO
	/**
	 * Consultora de la matriz de string
	 * @return matriz con los identificadores de las ciudades en su posicion
	 */
	public String[][] consultarMapa() {
		return mapa;
	}
}
