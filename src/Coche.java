/**
 * @author Olga
 */
public class Coche extends MedioTransporte {

	public Coche() {
		super(); 
	}
	
	/**
	 * Constructora de Tren
	 * @param String nombreTransporte
	 * @param int precio 
	 */
	public Coche(String nombreTransporte, int precio) {
		super(nombreTransporte, precio);
		super.carretera = true; 
		super.via = false; 
	}

}
