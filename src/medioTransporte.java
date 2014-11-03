public class MedioTransporte {

	private static String nombre;
	private int precioDistancia;

	MedioTransporte() {}

	// Creadora con parametros
	public MedioTransporte (String nombreTransporte, int precio){
		this.nombre = nombreTransporte;
		this.precioDistancia = precio;
	}

	// getter que devuelve el nombre del medio de transporte
	public static String getNombre() {
		return nombre;
	}

	// getter que devuelve el precio por distancia del medio de transporte
	public int getPrecio() {
		return precioDistancia;
	}

	public void setNombre(String nombreTransporte) {
		this.nombre = nombreTransporte;
	}

	public void setPrecio(int precio) {
		this.precioDistancia = precio;
	}
	
	

}
