import java.util.Set;


public class Mapa {
	
	private int anchuraX;
	private int alturaY;
	private ConjuntoCiudades ciudades;
	private ConjuntoCaminos caminos;
	private Coordenadas[] continente;
	
	public Mapa(Coordenadas[] continente, int anchuraX, int alturaY) {
		this.continente = continente;
		this.anchuraX = anchuraX;
		this.alturaY = alturaY;
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
		this.ciudades.agregarCiudad(c);
	}
	
	/*
	 *Consultar el numero de ciudades que tiene el ConjuntoCiudades 
	 */
	public int numeroCiudades() {
		this.numeroCiudades();
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
}
