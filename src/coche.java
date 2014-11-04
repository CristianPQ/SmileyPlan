
public class Coche extends MedioTransporte {

	public Coche() {
		super(); 
	}
	

	//Datos
	private String nombre; 
	private int precioDistancia; 
	static private int limitePrecio = 5; 
	
	static private Exception ErrorPrecio = new Exception("Este precio no es posible para un coche");
	
	
	public void Coche (String nombreTransporte, int precio) throws Exception{
		nombre = nombreTransporte;
		precioDistancia = precio; 
		if(precio < limitePrecio) throw ErrorPrecio; 
	}

}
