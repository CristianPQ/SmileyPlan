import java.util.*;
/**
 * @author Olga
 */
public class Tren extends MedioTransporte {

	public Tren() {
		super(); 
	}
	
	static private Exception ErrorPrecio = new Exception("Para un tren: precio inferior a 40");
	
	static private int limitePrecio = 40; 
	
	/**
	 * Constructora de Tren
	 * @param String nombreTransporte
	 * @param int precio 
	 */
	public Tren(String nombreTransporte, int precio) throws Exception {
		super(nombreTransporte, precio);
		if(precio > limitePrecio) throw ErrorPrecio;	
		super.via = true; 
		super.carretera = false; 
	}

	
}

