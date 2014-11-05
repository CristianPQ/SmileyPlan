public class MedioTransporte {

	private String nombre;
	private int precioDistancia;

	MedioTransporte() {}

	// Creadora con parametros
	public MedioTransporte (String nombreTransporte, int precio){
		setNombre(nombreTransporte);
		setPrecio(precio);
	}

	// getter que devuelve el nombre del medio de transporte
	public String getNombre() {
		return nombre;
	}

	// getter que devuelve el precio por distancia del medio de transporte
	public int getPrecio() {
		return precioDistancia;
	}

	//seter nombre
	public void setNombre(String nombreTransporte) {
		this.nombre = nombreTransporte;
	}
	
	//seter precio
	public void setPrecio(int precio) {
		this.precioDistancia = precio;
	}
	
	

}
