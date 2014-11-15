/**
 * @author Daniel Villanueva 
 */

public class Agente {
	private String nombre;
	private String ciudadInicial;
	private String ciudadObjetivo;
	
	/**
	 * Constructora de agente
	 */

	public Agente (String name, String InitialCity, String TargetCity){
		nombre = name;
		ciudadInicial = InitialCity;
        ciudadObjetivo = TargetCity;
	}
	
	/**
	 * Consultora de nombre
	 */
	
	public String consultarNombre() { 
		return nombre;
	}
	
	/**
	 * Modificadora de nombre
	 * * @param name es el nuevo nombre que queremos asignar al agente
	 */
	
	public void modificarNombre(String name) { //setter for nombre
		nombre = name;
	}
	
	/**
	 * Consultora de ciudadInicial
	*/
	
	public String consultarCiudadInicial() { //getter for ciudad_ini
		return ciudadInicial;
	}
	
	/**
	 * Modificadora de ciudadInicial
	 * @param InitialCity es la nueva ciudadInicial que queremos asignar al agente
	*/
	
	public void modificarCiudadInicial(String InitialCity) {//setter for ciudad_ini
		ciudadInicial = InitialCity;
	}
	
	/**
	 * Consultora de ciudadObjetivo
	*/
	
	public String consultarCiudadObjetivo() {//getter for ciudad_obj
		return ciudadObjetivo;
	}
	
	/**
	 * Modificadora de ciudadObjetivo
	 * @param TargetCity es la nueva ciudadObjetivo que queremos asignar al agente
	*/
	
	public void modificarCiudadObjetivo(String TargetCity) {//setter for ciudad_obj
		ciudadObjetivo = TargetCity;
	}
}
