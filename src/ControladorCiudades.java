import java.util.*;


public class ControladorCiudades {
	
	private TST<Ciudad> ciudades;

	//Consultar todas los nombres de las ciudades que componen ciudades
	/*
	 * Devuelve un Set con todas las keys de ciudades, en nuestro caso los nombres de las ciudades
	 */
	
	/*
	 * Anadir ciudad al Map ciudades
	 */
	
	public ControladorCiudades() {
		ciudades = new TST<Ciudad>();
	}
	
	
	public void agregarCiudad(Ciudad c) {
		ciudades.insert(c);
	}
	
	/*
	 * Buscar Ciudad a partir del nombre
	 */
	public Ciudad buscarCiudad(String nombreCiudad) {
		return ciudades.consultar(nombreCiudad);
	}
	
	/*
	 * Consultar coordenadas de una ciudad
	 */
	public Coordenadas getCoordenadasCiudad(String nombreCiudad) {
		Coordenadas coord;
		Ciudad c = buscarCiudad(nombreCiudad);
		coord = c.consultarCoordenadas();
		return coord;
	}
	
	/*
	 * Borrar ciudad
	 */
	public void borrarCiudad(String nombreCiudad) {
		ciudades.delete(nombreCiudad);
	}
	
	
	//True si la ciudad existe
	public boolean existe(String nombreCiudad) {
		return ciudades.existe(nombreCiudad);
	}
	
	public String escribir() {
		return ciudades.toString();
	}
	
	public void vaciar() {
		ciudades.makeEmpty();
	}
	
	public boolean isEmpty() {
		return ciudades.isEmpty();
	}
	
	/*
	 * Consultar numero de ciudades existentes en el Map ciudades
	 
	public int numeroCiudades() {
		return this.ciudades.size();
	}*/

	

}
