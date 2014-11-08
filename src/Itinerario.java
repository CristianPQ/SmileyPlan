import java.util.*;

/**
 * @author Olga 
 */

public class Itinerario {

	//Datos
	private static final int numCaminosPorDefecto = 60; 
	private String nombre; 
	private Camino[] caminos = new Camino[numCaminosPorDefecto]; 
	

	/**
	 * Constructora itinerario
	 * @param Agente ag, para asociar el nombre del agente al nombre 
	 * del itinerario (un itinerario por agente)
	 */
	public Itinerario(Agente ag) {
		String nombre = ag.consultarNombre(); 
		setNombre(nombre); 
		caminos = null; 
	}
	
	/**
	 * Modificar nombre del itinerario
	 * @param String nombre 
	 */
	public void setNombre(String nombre){
		nombre = nombre;
	}
	
	/**
	 * Consultora de numero de caminos
	 * @return nombre de caminos que hay en el itinerario
	 */
	public int getNumeroCaminos(){
		return caminos.length; 
	}
	
	/**
	 * Consultora de nombre del itinerario
	 * @return nombre del itinerario
	 */
	public String getNombreItinerario() {
		return nombre; 
	}
	
	/**
	 * Consultora de el camino que esta en una cierta posicion
	 * @return camino que se encuentra en la posicion indicada
	 */
	public Camino getCamino(int pos){
		return caminos[pos]; 
	}
	
	/**
	 * Consultora de la ciudad origen de una posicion determinada
	 * @return nombre de la ciudad de origen del camino de dicha posicion
	 */
	public String ConsultaCiudadOrigenCamino(int pos){
		return caminos[pos].getOrigen(); 
	}
	
	/**
	 * Consultora de la ciudad destino de una posicion determinada
	 * @return nombre de la ciudad destino del camino de dicha posicion
	 */
	public String ConsultaCiudadDestinoCamino(int pos){
		return caminos[pos].getDestino(); 
	}
	
	
	/**
	 * Agregar camino en una posicion determinada
	 * @param Camino c, camino que queremos agregar 
	 */
	public void agregarCamino(Camino c, int pos){
		caminos[pos] = c; 
	}


}

