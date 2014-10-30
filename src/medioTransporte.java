
public class medioTransporte {

	//Datos
	private String nombre; 
	private int precioDistancia; 
	
	//Creadora con parametros 
	public void transporte (String nombreTransporte, int precio) {
		nombre = nombreTransporte;
		precioDistancia = precio; 
	}
	
	//getter que devuelve el nombre del medio de transporte
	public String getNombre() {
		return nombre; 
	}
	
	//getter que devuelve el precio por distancia del medio de transporte
	public int getPrecio(){
		return precioDistancia; 
	}
		
}
