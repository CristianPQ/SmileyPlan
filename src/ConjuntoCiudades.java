import java.util.*;


public class ConjuntoCiudades {
	
	private TST<Ciudad> ciudades;

	//Consultar todas los nombres de las ciudades que componen ciudades
	/*
	 * Devuelve un Set con todas las keys de ciudades, en nuestro caso los nombres de las ciudades
	 */
	
	/*
	 * Anadir ciudad al Map ciudades
	 */
	
	public ConjuntoCiudades() {
		ciudades = new TST<Ciudad>();
	}
	
	
	public void agregarCiudad(Ciudad c) {
			//System.out.println("antes de putCiudad(getNombre) en ConjuntoCiudades" + "\n");
		String nombreCiudad = c.getNombre();
			//System.out.println("antes de putCiudad en ConjuntoCiudades" + "\n");
		this.ciudades.put(nombreCiudad, c);
			//System.out.println("despues de putCiudad en ConjuntoCiudades" + "\n");
	}
	
	/*
	 * Buscar Ciudad a partir del nombre
	 */
	public Ciudad buscarCiudad(String nombreCiudad) {
		Ciudad c = this.ciudades.get(nombreCiudad);
		return c;
	}
	
	/*
	 * Consultar coordenadas de una ciudad
	 */
	public Coordenadas getCoordenadasCiudad(String nombreCiudad) {
		Coordenadas coord;
		Ciudad c = buscarCiudad(nombreCiudad);
		coord = c.getCoord();
		return coord;
	}
	
	/*
	 * Borrar ciudad
	 */
	public void borrarCiudad(String nombreCiudad) {
		this.ciudades.remove(nombreCiudad);
	}
	
	/*
	 * Consultar numero de ciudades existentes en el Map ciudades
	 */
	public int numeroCiudades() {
		return this.ciudades.size();
	}

	

}
