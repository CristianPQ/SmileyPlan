import java.util.*;

/**
 * 
 * @author olgacarbo
 *
 */

public class ControladorItinerarios {
	
	private ArrayList<Itinerario> ci; 
	
	private static Exception ItinerarioYaExiste = new Exception("el itinerario ya existe");
	
	/**
	 * Constructora Controlador Itinerarios
	 */
	public void ControladorItinerario() {
		ci = new ArrayList<Itinerario>(); 
	}
	
	/**
	 * Agregar un itinerario al conjunto
	 * @param nombreAg el nombre del itinerario que coincide con el 
	 * del agente al que esta relacionado
	 * @throws Exception si el itinerario ya existe
	 */
	public void agregarItinerario(String nombreAg) throws Exception {
		Itinerario i = new Itinerario(nombreAg); 
		if(ci.contains(i)) throw ItinerarioYaExiste; 
		else ci.add(i); 
	}

	/**
	 * Agregar un camino a un itinerario 
	 * @param it objeto itinerario al que queremos agregar el camino
	 * @param co ciudad de origen del camino
	 * @param cd ciudad destino del camino
	 * @param trans medio de transporte del camino
	 * @throws Exception si ya existe dicha ciudad en dicho camino
	 */
	public void agregarCaminoAlItinerario(Itinerario it, String co, String cd, String trans) throws Exception {
		Camino aux = new Camino(co,cd,trans); 
		it.agregarCamino(aux);
	}
	
}
