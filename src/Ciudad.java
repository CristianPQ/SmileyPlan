
/*
 * Clase Ciudad
*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cristian Pinto
 */
public class Ciudad {
	
	private String nombre; 		//Identificador
	private Coordenadas coord;	//Senala la ubicacion
	
	/**
	 * Constructor de Ciudad
	 * @param nombreCiudad identificador de la categoria que se va a crear
	 * @param coordCiudad posicion de la ciudad
	 */
	public Ciudad(String nombreCiudad, Coordenadas coordCiudad){
		nombre = nombreCiudad;
		coord = coordCiudad;
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
	
	public String consultarKey() {
		return nombre;
	}
}