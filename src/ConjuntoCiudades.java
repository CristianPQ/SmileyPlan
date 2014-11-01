import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ConjuntoCiudades {
	
	private Map<String, Ciudad> ciudades = new HashMap<String, Ciudad>();

	//Consultar todas los nombres de las ciudades que componen ciudades
	/*
	 * Devuelve un Set con todas las keys de ciudades, en nuestro caso los nombres de las ciudades
	 */
	public Set<String> getCiudades()
	{
		return ciudades.keySet();
	}
	
	//Anadir ciudad al Map ciudades
	public void setCiudad(Ciudad c) {
		String nombreCiudad = c.getNombre();
		ciudades.put(nombreCiudad, c);
	}
	
	//Buscar Ciudad a partir del nombre
	public Ciudad buscarCiudadPorNombre(String nombreCiudad) {
		Ciudad c = ciudades.get(nombreCiudad);
		return c;
	}
	
	//Consultar coordenadas de una ciudad
	public Coordenadas getCoordenadasCiudadPorNombre(String nombreCiudad) {
		Coordenadas coord;
		Ciudad c = buscarCiudadPorNombre(nombreCiudad);
		coord = c.getCoord();
		return coord;
	}
	
	

}
