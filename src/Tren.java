//import java.util.*;
/**
 * @author Olga
 */
public class Tren extends MedioTransporte {

	public Tren() {
		super(); 
	}
	
	/**
	 * Constructora de Tren
	 * @param String nombreTransporte
	 * @param int precio 
	 */
	public Tren(String nombreTransporte, int precio) {
		super(nombreTransporte, precio);
		super.via = true; 
		super.carretera = false; 
	}

	
}

