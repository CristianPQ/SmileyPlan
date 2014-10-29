
public class medioTransporte {

	//Datos
	private String nombre; 
	private int precioDistancia; 
	
	//Creadora
	public void transporte (String nombreTransporte, int precio) {
		nombre = nombreTransporte;
		precioDistancia = precio; 
	}
	
	public String getNombre() {
		return nombre; 
	}
	
	public int getPrecio(){
		return precioDistancia; 
	}
	
	/*Medios de Transporte

	Inicializar_medios_transporte()
	Anadir_medio(string medio, int coste)
	Borrar_medio(string medio)
	consultar_medios()
	consultar_costes_de_todos_los_medios()
	leer_medio()
	crear_a_partir_de_lectura()
	actualizar_coste(string medio, int coste_nuevo)
	consultar_coste(string_medio)*/
	
	
}
