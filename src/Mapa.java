import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Mapa {
	
	private static String marca = "$";
	private TST<TST<TST<Camino>>> caminos;
	TST <Ciudad> ciudades;
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
		ciudades = new TST<Ciudad>();
		caminos = new TST<TST<TST<Camino>>>();
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
	
	/*
	 * Comprobar si la ciudad ya existe
	 */
	private boolean existeCiudad(String c) {
		return ciudades.existe(c);
	}
	
	//#########################################
	//##########SOBRE CIUDADES
	//#########################################
	
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
		if(caminos.isEmpty()) return false;
		String cOrig = c.consultarOrigen();
		String cDest = c.consultarDestino();
		String med = c.consultarTransporte();
		return caminos.consultar(cOrig).consultar(cDest).existe(med);
	}
	
	private void agregarCamino(Camino c) throws Exception {
		if(existeCamino(c)) throw Existe;
		String cOrig = c.consultarOrigen();
		String cDest = c.consultarDestino();
		String med = c.consultarTransporte();
		TST<TST<Camino>> camOrig = null;
		TST<Camino> camDest = null;
		
		if(caminos.existe(cOrig)) {
			//camOrig tiene el TST de TST de caminos con ciudad origen cOrig
			camOrig = caminos.consultar(cOrig);
			caminos.delete(cOrig);
			if(camOrig.existe(cDest)) {
				//camDest tiene tiene el TST de ciudades con origen cOrig y destino cDest
				camDest = camOrig.consultar(cDest);
				camOrig.delete(cDest);
				camDest.insert(med, c);
			}
			else {
				camDest = new TST<Camino>();
				camDest.insert(med, c);
			}
			camOrig.insert(cDest, camDest);
		}
		else {
			//No hay ningun camino con ciudad de origen cOrig
			camDest = new TST<Camino>();
			camDest.insert(med, c);
			camOrig = new TST<TST<Camino>>();
			camOrig.insert(cDest, camDest);
		}
		//Se vuelve a insertar el TST de TST de caminos con origen cOrig.
		caminos.insert(cOrig, camOrig);
	}
	
	public TST<TST<Camino>> consultarCaminoPorMedio(String cOrig, String cDest, String mTrans) {
		return caminos.consultar(cOrig);
	}	
	
	
	
	private ArrayList<String> consultarCiudadesDestino(String cOrig) {
		ArrayList<String> cPosibles = new ArrayList<String>();
		
		
		return cPosibles;
	}
	
	
	/*
	 * Getter Set de nombres de ciudades
	 */
	public Set<String> getCiudades() {
		Set<String> ciudades = this.ciudades.getCiudades();
		return ciudades;	
	}
	
	
	/*
	 *Consultar el numero de ciudades que tiene el ConjuntoCiudades 
	 */
	public int numeroCiudades() {
		return this.ciudades.numeroCiudades();
	}
	
	/*
	 * Consultar el numero de ciudades que tiene el ConjuntoCaminos
	 */
	public int numeroCaminos() {
		return this.caminos.getNumCaminos();
	}
	
	//Buscar Ciudad a partir del nombre
	public Ciudad buscarCiudad(String nombreCiudad) {
		return this.ciudades.buscarCiudad(nombreCiudad);
	}
	
	//Consultar coordenadas de una ciudad
	public Coordenadas getCoordenadasCiudad(String nombreCiudad) {
		return this.ciudades.getCoordenadasCiudad(nombreCiudad);
	}
	
	//Borrar ciudad
	public void borrarCiudad(String nombreCiudad) {
		this.ciudades.borrarCiudad(nombreCiudad);
	}



	public int getAnchuraX() {
		return anchuraX;
	}



	public void setAnchuraX(int anchuraX) {
		this.anchuraX = anchuraX;
	}



	public int getAlturaY() {
		return alturaY;
	}



	public void setAlturaY(int alturaY) {
		this.alturaY = alturaY;
	}



	public Coordenadas[] getContinente() {
		return continente;
	}



	public void setContinente(Coordenadas[] continente) {
		this.continente = continente;
	}
	
	/*
	 * Consultar caminos existentes desde una ciudad
	 */
	public ArrayList<Camino> conCiudadOrigen(String ciudadOrigen){
		return this.caminos.getCaminosConCiudadOrigen(ciudadOrigen);
	}


}
