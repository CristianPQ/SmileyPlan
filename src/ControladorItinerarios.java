import java.util.*;

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
	public void agregarItinerario(String nombreAg, ArrayList<String> ciudades, int nuevoCoste) throws Exception {
		Itinerario aux = new Itinerario(nombreAg, ciudades, nuevoCoste); 
		cjtoit.add(aux);  
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
	
	/**
	 * 
	 * @return
	 */
	public String escribirItinerarios() {
		String its = new String();
		for(int i = 0; i < cjtoit.size(); ++i) {
			Itinerario iti = cjtoit.get(i);
			its = its + "Agente: " + iti.getNombreItinerario() + "\n";
			for(int j = 0; j < iti.getNumeroCiudades(); ++j) {
				its = its + "    " + iti.consultarCiudad(j) + " ";
			}
			its = its + " Coste: " + iti.consultarCoste();
			its = its + "\n";
		}
		return its;
	}
	
}
