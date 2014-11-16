import java.util.*;

/**
 * @author Olga 
 */

public class Itinerario {

	//Datos
	private String nombre; 
	private ArrayList<Camino> caminos; 

	private static Exception CaminoYaExiste = new Exception("el camino ya esta en el itinerario");
		
	public Itinerario() {	
	}
	
	/**
	 * Creadora de camino con transporte null
	 * @param co
	 * @param cd
	 * @param trans
	 */
	public Camino crearCamino(String co, String cd){
		Camino cam = new Camino(co,cd,null); 
		return cam; 
	}
		
	/**
	 * Constructora itinerario con parametros
	 * El nombre del itinerario tiene que coincidir con el nombre del agente
	 * al cual esta vinculado el itinerario
	 * @param Agente ag, para asociar el nombre del agente al nombre 
	 * del itinerario (un itinerario por agente)
	 */
	public Itinerario(String nombreAg) throws Exception{ 
			caminos = new ArrayList<Camino>();
			nombre = nombreAg; 
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
	public int getNumeroCaminos(){
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
	public void agregarCamino(Camino c) throws Exception{
		if (caminos.contains(c)) throw CaminoYaExiste; 
		else caminos.add(c); 
	}
		
	

}

