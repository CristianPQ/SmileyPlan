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

	public Agente (String nombre, String ciudadInicial, String ciudadObjetivo){
		setNombre(nombre);
		setCiudadObjetivo(ciudadObjetivo);
        setCiudadInicial(ciudadInicial);
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
	
	public void setNombre(String nombre) { //setter for nombre
		this.nombre = nombre;
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
	
	public void setCiudadInicial(String ciudadInicial) {//setter for ciudad_ini
		this.ciudadInicial = ciudadInicial;
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
	
	public void setCiudadObjetivo(String ciudadObjetivo) {//setter for ciudad_obj
		this.ciudadObjetivo = ciudadObjetivo;
	}
}
