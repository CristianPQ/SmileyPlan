/*
 * @author Daniel Villanueva 
 */

public class Agente {
	private String nombre;
	private String ciudadInicial;
	private String ciudadObjetivo;
	
	/*
	 * Constructora de agente
	 */

	public Agente (String name, String InitialCity, String TargetCity){
		nombre = name;
		ciudadInicial = InitialCity;
        ciudadObjetivo = TargetCity;
	}
	/*
	 * Consultora de nombre
	 */
	
	public String consultarNombre() { //getter for nombre
		return nombre;
	}
	
	/*
	 * Modificadora de nombre
	 */
	
	public void modificarNombre(String name) { //setter for nombre
		nombre = name;
	}
	
	/*
	 * Consultora de ciudadInicial
	*/
	
	public String consultarCiudadInicial() { //getter for ciudad_ini
		return ciudadInicial;
	}
	
	/*
	 * Modificadora de ciudadInicial
	*/
	
	public void modificarCiudadInicial(String InitialCity) {//setter for ciudad_ini
		ciudadInicial = InitialCity;
	}
	
	/*
	 * Consultora de ciudadObjetivo
	*/
	
	public String consultarCiudadObjetivo() {//getter for ciudad_obj
		return ciudadObjetivo;
	}
	
	/*
	 * Modificadora de ciudadObjetivo
	*/
	
	public void modificarCiudadObjetivo(String TargetCity) {//setter for ciudad_obj
		ciudadObjetivo = TargetCity;
	}
}
