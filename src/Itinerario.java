import java.util.*;

/**
 * @author Olga 
 */

public class Itinerario {

	//Datos
	//private static final int numCaminosPorDefecto = 60; 
	private String nombre; 
	private Set<Camino> caminos; 
	//private Camino[] caminos = new Camino[numCaminosPorDefecto]; 
	private static Exception NoAgente = new Exception("el agente no existe");
	private static Exception CaminoYaExiste = new Exception("el camino ya esta en el itinerario");
	

	/**
	 * Constructora itinerario
	 * El nombre del itinerario tiene que coincidir con el nombre del agente
	 * al cual esta vinculado el itinerario
	 * @param Agente ag, para asociar el nombre del agente al nombre 
	 * del itinerario (un itinerario por agente)
	 * @throws Exception si no hay ningun agente con este nombre
	 */
	public Itinerario(String nombre) throws Exception{ 
		Agente ag; 
		if (!ag.existeAgente(nombre)) throw NoAgente;
		else{
			setNombre(nombre); 
			caminos = null; 
		}
		
	}
	
	/**
	 * Modificar nombre del itinerario
	 * El nombre del itinerario tiene que coincidir con el nombre del agente
	 * al cual esta vinculado el itinerario
	 * @param String nombre 
	 * @throws Exception si el nombre de agente no existe 
	 */
	public void setNombre(String nombrenuevo) throws Exception {
		Agente ag; 
		if (!ag.existeAgente(nombre)) throw NoAgente;
		else nombre = nombrenuevo;
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
	public void agregarCamino(String co, String cd, String trans) throws Exception{
		Iterator<Camino> it = caminos.iterator(); 
		Camino c; 
		while(it.hasNext()){
			c = it.next();
			if(c.getOrigen().equals(co) && c.getDestino().equals(cd) && c.getTransporte().equals(trans)){
				throw CaminoYaExiste;
			}
		}
		Camino aux = new Camino(co,cd,trans); 
		caminos.add(aux); 
	}

}

