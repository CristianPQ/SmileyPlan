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
		else ciudades.insert(c.consultarNombre(), c);
	}
	
	public void eliminarCiudad(String c) throws Exception {
		if(!existeCiudad(c)) throw NoExiste;
		else ciudades.delete(c);
	}
	
	public Ciudad consultarCiudad(String c) throws Exception {
		if(!existeCiudad(c)) throw NoExiste;
		else return ciudades.consultar(c);
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
	
	/*
	 * Agregar camino en ConjuntoCaminos caminos
	 */
	public void agregarCamino(Camino c) throws Exception {
			System.out.println("antes de agregarCamino en Mapa" + "\n");
		this.caminos.agregarCamino(c);
			System.out.println("despues de agregarCamino en Mapa" + "\n");
	}
}
