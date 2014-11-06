/*
 * @author Olga
 */
public class MedioTransporte {

	private String nombre;
	private int precioDistancia;

	/*
	 * Creadora por defecto
	 */
	MedioTransporte() {}

	/*
	 * Creadora con parametros 
	 * @param String nombreTransporte
	 * @param int precio 
	 */
	public MedioTransporte (String nombreTransporte, int precio){
		setNombre(nombreTransporte);
		setPrecio(precio);
	}
	
	/*
	 * Devuelve el nombre del medio de transporte
	 * @return String correspondiente al nombre del medio de transporte
	 */
	public String getNombre() {
		return nombre;
	}
	
	/*
	 * Devuelve el precio por distancia del medio de transporte
	 * @return Integer correspondiente al precio por distancia del medio de transporte
	 */
	public int getPrecio() {
		return precioDistancia;
	}

	/*
	 * Asigna un nombre al medio de transporte
	 */
	public void setNombre(String nombreTransporte) {
		this.nombre = nombreTransporte;
	}
	
	/*
	 * Asigna un precio al medio de transporte
	 */
	public void setPrecio(int precio) {
		this.precioDistancia = precio;
	}
	
	

}
