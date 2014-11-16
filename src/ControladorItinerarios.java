import java.util.*;

/**
 * 
 * @author olgacarbo
 *
 */

public class ControladorItinerarios {
	
	private ArrayList<Itinerario> ci; 
	
	Itinerario iti; 
	
	private static Exception ItinerarioYaExiste = new Exception("el itinerario ya existe");
	
	/**
	 * Constructora Controlador Itinerarios
	 */
	public void ControladorItinerario() {
		ci = new ArrayList<Itinerario>(); 
	}
	
	/**
	 * Devuelve el camino creado
	 * @param co
	 * @param cd
	 * @return
	 */
	public Camino crearCamino(String co, String cd){
		return iti.crearCamino(co, cd);
	}
	
	/**
	 * Agregar un itinerario al conjunto
	 * @param nombreAg el nombre del itinerario que coincide con el 
	 * del agente al que esta relacionado
	 * @throws Exception si el itinerario ya existe
	 */
	public Itinerario agregarItinerario(String nombreAg) throws Exception {
		Itinerario i = new Itinerario(nombreAg); 
		if(ci.contains(i)) throw ItinerarioYaExiste; 
		else ci.add(i); 
		return i; 
	}


	/**
	 * Agrega un camino c al itinerario it 
	 * @param it
	 * @param c
	 * @throws Exception si el nombre de itinerario ya existe
	 */
	public void agregarCaminoAlItinerario(Itinerario it, Camino c) throws Exception {
		it.agregarCamino(c);
	}
	
}
