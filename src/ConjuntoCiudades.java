import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ConjuntoCiudades {
	
	private Map<String, Ciudad> ciudades = new HashMap<String, Ciudad>();

	//Consultar todas los nombres de las ciudades que componen ciudades
	/*
	 * Devuelve un Set con todas las keys de ciudades, en nuestro caso los nombres de las ciudades
	 */
	public Set<String> getCiudades() {
		return this.ciudades.keySet();
	}
	
	/*
	 * Anadir ciudad al Map ciudades
	 */
	public void agregarCiudad(Ciudad c) {
		String nombreCiudad = c.getNombre();
		this.ciudades.put(nombreCiudad, c);
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
	
	/*
	 * Consultar caminos existentes desde una ciudad
	 */
	public ArrayList<Camino> conCiudadOrigen(String ciudadOrigen){
		return this.caminos.getCiudadOrigen(ciudadOrigen);
	}
	
	/*
	 * Agregar camino en ConjuntoCaminos caminos
	 */
	public void agregarCamino(Camino c) {
		this.caminos.agregarCamino(c);
	}
	

}
