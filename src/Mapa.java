import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Mapa {
	
	/*private int anchuraX;
	private int alturaY;
	private ConjuntoCiudades ciudades;*/
	private TST<TST<TST<Camino>>> caminos;
	TST <Ciudad> ciudades;
	private String[][] mapa;
	
	
	/*
	 * Constructor Ciudad
	 */
	public Mapa(int anchuraX, int alturaY, Coordenadas[] continente) {
		/*this.setContinente(continente);
		this.setAnchuraX(anchuraX);
		this.setAlturaY(alturaY);
		ciudades = new ConjuntoCiudades();*/
		
		mapa = new String[alturaY][anchuraX];
		
		agregarContinente(continente);
		
		//caminos = new HashMap<String, ArrayList<Camino/*destino*/>>();
	}
	
	private void agregarContinente(Coordenadas[] continente) {
		/*
		 * funcion para crear la zona inválida del mapa, el agua
		 */
	}
	
	/*
	 * Getter Set de nombres de ciudades
	 */
	public Set<String> getCiudades() {
		Set<String> ciudades = this.ciudades.getCiudades();
		return ciudades;	
	}
	
	/*
	 * Agregar una nueva ciudad al ConjuntoCiudades ciudades
	 */
	public void agregarCiudad(Ciudad c) {
			//System.out.println("antes de agregarCiudad en Mapa" + "\n");
		this.ciudades.agregarCiudad(c);
			//System.out.println("despues de agregarCiudad en Mapa" + "\n");
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
