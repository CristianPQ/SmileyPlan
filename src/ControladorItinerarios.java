import java.util.*;

/**
 * 
 * @author olgacarbo
 *
 */

public class ControladorItinerarios {
	
	private ArrayList<Itinerario> cjtoit; 
	private Itinerario iti = new Itinerario(); 
	
	private static Exception ItinerarioYaExiste = new Exception("el itinerario ya existe");
	
	/**
	 * Constructora Controlador Itinerarios
	 */
	public ControladorItinerarios() {
		cjtoit = new ArrayList<Itinerario>(); 

	}
	
	/*/**
	 * Devuelve el camino creado
	 * @param co
	 * @param cd
	 * @return
	 */
	/*public Camino crearCamino(String co, String cd) throws Exception{
		return iti.crearCamino(co, cd);
	}*/
	
	/**
	 * Agregar un itinerario al conjunto
	 * @param nombreAg el nombre del itinerario que coincide con el 
	 * del agente al que esta relacionado
	 * @throws Exception si el itinerario ya existe
	 */
	public Itinerario agregarItinerario(String nombreAg) throws Exception {
		Itinerario i = new Itinerario(nombreAg); 
		//if(cjtoit.contains(i)) throw ItinerarioYaExiste; 
		//else {
			cjtoit.add(i); 
		//}
		return i; 
	}


	/**
	 * Agregar una ciudad al itinerario
	 * @param it
	 * @param name
	 * @throws Exception
	 */
	public void agregarCiudadAlItinerario(Itinerario it, String name) throws Exception{
		it.agregarCiudad(name); 
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
