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
	 * Getter de nombre
	 */
	
	public String getNombre() { //getter for nombre
		return nombre;
	}
	
	/*
	 * Setter de nombre
	 */
	
	public void setNombre(String name) { //setter for nombre
		nombre = name;
	}
	
	/*
	 * Getter de ciudadInicial
	*/
	
	public String getCiudadInicial() { //getter for ciudad_ini
		return ciudadInicial;
	}
	
	/*
	 * Setter de ciudadInicial
	*/
	
	public void setCiudadInicial(String InitialCity) {//setter for ciudad_ini
		ciudadInicial = InitialCity;
	}
	
	/*
	 * Getter de ciudadObjetivo
	*/
	
	public String getCiudadObjetivo() {//getter for ciudad_obj
		return ciudadObjetivo;
	}
	
	/*
	 * Setter de ciudadObjetivo
	*/
	
	public void setCiudadObjetivo(String TargetCity) {//setter for ciudad_obj
		ciudadObjetivo = TargetCity;
	}
}
