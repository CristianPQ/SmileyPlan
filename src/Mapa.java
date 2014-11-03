import java.util.Set;


public class Mapa {
	
	static private int anchuraX = 1000;
	static private int alturaY = 1000;
	private ConjuntoCiudades ciudades;
	private ConjuntoCaminos caminos;
	private Coordenadas[] continente;
	
	public Mapa(Coordenadas[] continente) {
		this.continente = continente;
	}
	
	/*
	 * Getter Set de nombres de ciudades
	 */
	public Set<String> todasLasCiudades() {
		Set<String> ciudades = this.ciudades.getCiudades();
		return ciudades;
		
	}
	
}
