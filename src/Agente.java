public class Agente {
	private String nombre;
	private String ciudad_inicial;
	private String ciudad_objetivo;
	 
	public String getNombre() { //getter for nombre
		return nombre;
	}
	public void setNombre(String nombre) { //setter for nombre
		this.nombre = nombre;
	}
	public String getCiudad_inicial() { //getter for ciudad_ini
		return ciudad_inicial;
	}
	public void setCiudad_inicial(String ciudad_inicial) {//setter for ciudad_ini
		this.ciudad_inicial = ciudad_inicial;
	}
	public String getCiudad_objetivo() {//getter for ciudad_obj
		return ciudad_objetivo;
	}
	public void setCiudad_objetivo(String ciudad_objetivo) {//setter for ciudad_obj
		this.ciudad_objetivo = ciudad_objetivo;
	}
}