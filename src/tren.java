
public class Tren extends MedioTransporte {

	public Tren() {
		super(); 
	}
	
	static private Exception ErrorPrecio = new Exception("Este precio no es posible para un tren");
	
	//Datos
	private String nombre; 
	private int precioDistancia; 
	static private int limitePrecio = 40; 
	
	public Tren (String nombreTransporte, int precio) throws Exception{
		this.nombre = nombreTransporte;
		precioDistancia = precio; 
		if(precio > limitePrecio) throw ErrorPrecio; 
	}
	

}

