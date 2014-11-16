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
	public void ControladorItinerarios() {
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
		System.out.println("itinerario " + i.getNombreItinerario() + "\n");
		if(ci.contains(i)) throw ItinerarioYaExiste; 
		else {
			System.out.println("no hi ha cap itinerari igual \n");
			ci.add(i); 
		}
		System.out.println("itinerario" + i.getNombreItinerario() + "\n");
		return i; 
	}


	/**
	 * Agrega un camino c al itinerario it 
	 * @param it
	 * @param c
	 * @throws Exception si el nombre de itinerario ya existe
	 */
	public void agregarCaminoAlItinerario(Itinerario it, Camino c) throws Exception {
		System.out.println("he entrat a la funcio\n");
		System.out.println("itinerario" + it.getNombreItinerario() + "\n");
		System.out.println("itinerario" + c.consultarOrigen() + "\n");
		it.agregarCamino(c);
	}
	
}
