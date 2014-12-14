
public class Ciudad {
	
	private String nombre; 		//Identificador
	private Coordenadas coord;	//Senala la ubicacion
	private int equivalente;
	
	/**
	 * Constructor de Ciudad
	 * @param nombreCiudad identificador de la categoria que se va a crear
	 * @param coordCiudad posicion de la ciudad
	 */
	public Ciudad(String nombreCiudad, Coordenadas coordCiudad){
		nombre = nombreCiudad;
		coord = coordCiudad;
	}
	
	public Ciudad(String nombreCiudad, Coordenadas coordCiudad, int eq){
		nombre = nombreCiudad;
		coord = coordCiudad;
		equivalente = eq;
	}
	
	public void equivalente(int eq) {
		equivalente = eq;
	}
	
	public int consultarEquivalente() {
		return equivalente;
	}

	/**
	 * Consultor del nombre de la ciudad
	 * @return el nombre de la ciudad
	 */
	public String consultarNombre() {
		return nombre;
	}

	/**
	 * Consultor de las coordenadas de la ciudad
	 * @return las coordenadas de ciudad
	 */
	public Coordenadas consultarCoordenadas() {
		return coord;
	}

	/**
	 * Modificador de las coordenadas de la ciudad
	 * @param coordCiudad nuevas coordenadas de ciudad
	 */
	public void modificarCoordenadas(Coordenadas coordCiudad) {
		coord = coordCiudad;
	}
	
	public String toString() {
		return nombre;
	}
}