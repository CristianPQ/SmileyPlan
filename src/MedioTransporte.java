

/**
 * @author Olga
 */
public class MedioTransporte {

	protected String nombre;
	protected int precioDistancia;
	protected boolean carretera; 
	protected boolean via; 

	/**
	 * Creadora por defecto
	 */
	MedioTransporte() {}

	/**
	 * Creadora con parametros 
	 * @param String nombreTransporte
	 * @param int precio 
	 */
	public MedioTransporte (String nombreTransporte, int precio){
		setNombre(nombreTransporte);
		setPrecio(precio);
	}
	
	/**
	 * Devuelve el nombre del medio de transporte
	 * @return String correspondiente al nombre del medio de transporte
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Devuelve el precio por distancia del medio de transporte
	 * @return Integer correspondiente al precio por distancia del medio de transporte
	 */
	public int getPrecio() {
		return precioDistancia;
	}

	/**
	 * Asigna un nombre al medio de transporte
	 * @param String nombreTransporte
	 */
	public void setNombre(String nombreTransporte) {
		nombre = nombreTransporte;
	}
	
	/**
	 * Asigna un precio al medio de transporte
	 * @param int precio
	 */
	public void setPrecio(int precio) {
		precioDistancia = precio;
	}
	
	public boolean esTren(){
		return via; 
	}
}
