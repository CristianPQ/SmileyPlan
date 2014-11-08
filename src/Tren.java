/**
 * @author Olga
 */
public class Tren extends MedioTransporte {

	public Tren() {
		super(); 
	}
	
	static private Exception ErrorPrecio = new Exception("Este precio no es posible para un tren");
	
	static private int limitePrecio = 40; 
	
	/**
	 * Constructora de Tren
	 * @param String nombreTransporte
	 * @param int precio 
	 */
	public Tren(String nombreTransporte, int precio) throws Exception {
		super(nombreTransporte, precio);
		if(precio > limitePrecio) throw ErrorPrecio;
		
	}
	

}

