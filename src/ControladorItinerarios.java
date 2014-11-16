import java.util.*;

/**
 * 
 * @author olgacarbo
 *
 */

public class ControladorItinerarios {
	
	private ArrayList<Itinerario> cjtoit; 
	
	private static Exception ItinerarioYaExiste = new Exception("el itinerario ya existe");
	
	/**
	 * Constructora Controlador Itinerarios
	 */
	public ControladorItinerarios() {
		cjtoit = new ArrayList<Itinerario>(); 

	}
	
	
	/**
	 * Agregar un itinerario al conjunto
	 * @param nombreAg el nombre del itinerario que coincide con el 
	 * del agente al que esta relacionado
	 * @throws Exception si el itinerario ya existe
	 */
	public Itinerario agregarItinerario(String nombreAg, ArrayList<String> ciudades) throws Exception {
		Itinerario aux = new Itinerario(nombreAg); 
		aux.agregarCiudades(ciudades); 
		cjtoit.add(aux); 
		return aux; 
	}
	
	
	/**
	 * consultora tamano conjunto 
	 * @return
	 */
	public int consultarSize(){
		return cjtoit.size(); 
	}
	
	/**
	 * consultora numero caminos de un itinerario
	 * @param it
	 * @return
	 */
	public int consultarCiudadesIt(Itinerario aux){
		return aux.getNumeroCiudades(); 
	}
		
	
}
