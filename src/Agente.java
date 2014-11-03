public class Agente {
	private String nombre;
	private String ciudadInicial;
	private String ciudadObjetivo;
	
	public Agente (String nom, String ciuIni, String ciuObj){
		nombre = nom;
		ciudadObjetivo = ciuObj;
		ciudadInicial = ciuIni;
	}
	
	public String getNombre() { //getter for nombre
		return nombre;
	}
	public void setNombre(String nombre) { //setter for nombre
		this.nombre = nombre;
	}
	public String getCiudadInicial() { //getter for ciudad_ini
		return ciudadInicial;
	}
	public void setCiudadInicial(String ciudadInicial) {//setter for ciudad_ini
		this.ciudadInicial = ciudadInicial;
	}
	public String getCiudadObjetivo() {//getter for ciudad_obj
		return ciudadObjetivo;
	}
	public void setCiudadObjetivo(String ciudadObjetivo) {//setter for ciudad_obj
		this.ciudadObjetivo = ciudadObjetivo;
	}
}
