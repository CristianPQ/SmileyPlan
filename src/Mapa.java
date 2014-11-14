import java.util.*;


public class Mapa {
	
	
	private static String marca = "$";
	private TST<TST<ArrayList<Camino>>> caminos;
	private TST <Ciudad> ciudades;
	private String[][] mapa;
	
	private static Exception CoordInvalidas = new Exception ("Estas "
			+ "coordenadas no son validas para este mapa");
	private static Exception Existe = new Exception ("Este elemento ya existe");
	private static Exception NoExiste = new Exception ("Este elemento no existe");
	private static Exception Vacio = new Exception ("Esta vacio");
	
	
	/*
	 * Constructor Ciudad
	 */
	public Mapa(int anchuraX, int alturaY, Coordenadas[] continente) throws Exception {
		//continente es cerrado siempre
		ciudades = new TST<Ciudad>();
		caminos = new TST<TST<ArrayList<Camino>>>();
		mapa = new String[alturaY][anchuraX];
		agregarContinente(continente);
	}
	
	private void agregarContinente(Coordenadas[] noValido) throws Exception {
		for(int i = 0; i< noValido.length; ++i) {
			Coordenadas c = noValido[i];
			posicionValida(c);
			mapa[c.consultarY()][c.consultarX()] = marca;
		}
		
		//Si se hace por espacio delimitado
		/*for(int i = 0; i < mapa.length; ++i) {
			int agua = -1;  
			for(int j = 0; j < mapa[0].length; ++j) {
				if(mapa[i][j] == "$" && agua >= 0) {
					for(mapa)
				}
				if(mapa[i][j] == "$") agua = j;
				
			}
		}*/
	}
	
	/*
	 * Comprobar si la Coord es valida para el mapa
	 */
	private void posicionValida(Coordenadas coord) throws Exception {
		if(coord.consultarY()  >= mapa.length || coord.consultarX() >= mapa[0].length) {
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
	
	public void agregarCiudad(Ciudad c) throws Exception {
		posicionValida(c.consultarCoordenadas());
		if(existeCiudad(c.consultarNombre())) throw Existe;
		ciudades.insert(c.consultarNombre(), c);
	}
	
	public void eliminarCiudad(String c) throws Exception {
		if(!existeCiudad(c)) throw NoExiste;
		ciudades.delete(c);
	}
	
	public Ciudad consultarCiudad(String c) throws Exception {
		if(!existeCiudad(c)) throw NoExiste;
		return ciudades.consultar(c);
	}
	
	public ArrayList<String> listarCiudades() throws Exception{
		if(ciudades.isEmpty()) throw Vacio;
		return ciudades.consultar();
	}
	
	
	//#########################################
	//##########SOBRE CAMINOS
	//#########################################
	
	private boolean existeCamino(Camino c) {
		String cOrig = c.consultarOrigen();
		String cDest = c.consultarDestino();
		return caminos.consultar(cOrig).consultar(cDest).contains(c);
	}
	
	public void agregarCamino(Camino c) throws Exception {
		if(existeCamino(c)) throw Existe;
		String cOrig = c.consultarOrigen();
		String cDest = c.consultarDestino();
		if(!existeCiudad(cOrig) || !existeCiudad(cDest)) throw NoExiste;
		TST<ArrayList<Camino>> camOrig = null;
		ArrayList<Camino> camDest = null;
		
		if(caminos.existe(cOrig)) {
			//camOrig tiene el TST de TST de caminos con ciudad origen cOrig
			camOrig = caminos.consultar(cOrig);
			caminos.delete(cOrig);
			if(camOrig.existe(cDest)) {
				//camDest tiene tiene el TST de ciudades con origen cOrig y destino cDest
				camDest = camOrig.consultar(cDest);
				camOrig.delete(cDest);
				camDest.add(c);
			}
			else {
				camDest = new ArrayList<Camino>();
				camDest.add(c);
			}
			camOrig.insert(cDest, camDest);
		}
		else {
			//No hay ningun camino con ciudad de origen cOrig
			camDest = new ArrayList<Camino>();
			camDest.add(c);
			camOrig = new TST<ArrayList<Camino>>();
			camOrig.insert(cDest, camDest);
		}
		//Se vuelve a insertar el TST de TST de caminos con origen cOrig.
		caminos.insert(cOrig, camOrig);
	}
	
	public ArrayList<Camino> consultarCaminos(String cOrig, String cDest) throws Exception {
		ArrayList<Camino> listCamino =  caminos.consultar(cOrig).consultar(cDest);
		if(listCamino == null) throw NoExiste;
		return listCamino;		
	}
	
	public void eliminarCamino(Camino c) throws Exception {
		String cOrig = c.consultarOrigen();
		String cDest = c.consultarDestino();
		TST<ArrayList<Camino>> camOrig = caminos.consultar(cOrig);
		ArrayList<Camino> camDest = camOrig.consultar(cDest);
		camOrig.delete(cDest);
		camDest.remove(c);
		if(!camDest.isEmpty()) camOrig.modificar(cDest, camDest);
		if(!camOrig.isEmpty()) caminos.modificar(cOrig, camOrig);
	}
	
	
	public ArrayList<Camino> consultarCiudadesDestino(String cOrig) {
		//Caminos de la misma ciudad origen
		TST<TST<Camino>> camOrig = caminos.consultar(cOrig);
		
		//Lista de ciudades destino
		ArrayList<String> nCamDest = camOrig.consultar();
		
		//Donde se guardaran todos los caminos de salida posibles
		ArrayList<Camino> cPosibles = new ArrayList<Camino>();
		
		//Iterador para recorrer todos los destinos existentes
		Iterator<String> it = nCamDest.iterator();
		while(it.hasNext()) {
			
			//TST de las ciudades con las misma cOrig y cDest
			TST<Camino> camDest = camOrig.consultar(it.next());
			
			//Lista de medios con los que hay caminos
			ArrayList<String> nCamMed = camDest.consultar();
			Iterator<String> itMed = nCamMed.iterator();
			
			//Por cada medio se añade un camino
			while(itMed.hasNext()) {
				cPosibles.add(camDest.consultar(itMed.next()));
			}
		}
		//cPosibles tiene todos los caminos ordenadoes por la ciudad destino
		// y de entre ellos por el medio que tienen
		return cPosibles;
	}
}
