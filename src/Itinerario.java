import java.util.*;

public class Itinerario {

	//Datos
	private String nombre; 
	private ArrayList<String> caminos; 

	private static Exception CiudadYaExiste = new Exception("la ciudad ya esta en el itinerario");
		
	public Itinerario() {	
	}
	
	/*/**
	 * Creadora de camino con transporte null
	 * @param co
	 * @param cd
	 * @param trans
	 */
	/*public Camino crearCamino(String co, String cd){
		Camino cam = new Camino(co,cd,null); 
		return cam; 
	}*/
		
	/**
	 * Constructora itinerario con parametros
	 * El nombre del itinerario tiene que coincidir con el nombre del agente
	 * al cual esta vinculado el itinerario
	 * @param Agente ag, para asociar el nombre del agente al nombre 
	 * del itinerario (un itinerario por agente)
	 */
	public Itinerario(String nombreAg, ArrayList<String> ciudades) throws Exception{ 
			caminos = ciudades;
			nombre = nombreAg; 
	}	
	
	/**
	 * Agregar la array de ciudades al itinerario
	 * @param c
	 */
	public void agregarCiudades(ArrayList<String> c) {
		caminos = c; 
	}
	
	/**
	 * Modificar nombre del itinerario
	 * El nombre del itinerario tiene que coincidir con el nombre del agente
	 * al cual esta vinculado el itinerario
	 * @param String nombre 
	 */
	public void setNombre(String nombrenuevo) {
		 nombre = nombrenuevo;
	}
	
	
	/**
	 * Consultora de numero de caminos
	 * @return nombre de caminos que hay en el itinerario
	 */
	public int getNumeroCiudades(){
		return caminos.size(); 
	}
	
	/**
	 * Consultora de nombre del itinerario
	 * @return nombre del itinerario
	 */
	public String getNombreItinerario() {
		return nombre; 
	}

	
	/**
	 * Agregar un camino nuevo en el itinerario
	 * @param co ciudad origen
	 * @param cd ciudad destino
	 * @param trans medio transporte
	 * @throws Exception si el camino ya se encuentra en el itinerario
	 */
	public void agregarCiudad(String s) throws Exception{
		if (caminos.contains(s)) throw CiudadYaExiste; 
		else caminos.add(s); 
	}
	
	/**
	 * Consulta el string en una posicion
	 * @param i
	 * @return String de caminos en la posicion i
	 */
	public String consultarCiudad(int i) {
		return caminos.get(i);
	}
		
	

}

