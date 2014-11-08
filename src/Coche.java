/**
 * @author Olga
 */
public class Coche extends MedioTransporte {

	public Coche() {
		super(); 
	}
	
	static private int limitePrecio = 5; 

	static private Exception ErrorPrecio = new Exception("Este precio no es posible para un coche");
	
	/**
	 * Constructora de Tren
	 * @param String nombreTransporte
	 * @param int precio 
	 */
	public Coche(String nombreTransporte, int precio) throws Exception {
		super(nombreTransporte, precio);
		if(precio < limitePrecio) throw ErrorPrecio;
		
	}

}
