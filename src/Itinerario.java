
public class Itinerario {

	//Datos
	private static final int numCaminosPorDefecto = 60; 
	private String nombre; 
	private Camino[] caminos = new Camino[numCaminosPorDefecto]; 
	

	//Constructora de itinerario vacio
	public Itinerario(Agente ag) {
		String nombre = ag.getNombre(); 
		setNombre(nombre); 
		caminos = null; //--> vector o TST? 
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	//getter que devuelve el numero de caminos en el itinerario
	public int getNumeroCaminos(){
		return caminos.length; 
	}
	
	//getter que devuelve el nombre del itinerario
	public String getNombreItinerario() {
		return nombre; 
	}
	
	//getter que devuelve el camino de la posicion que pasa por parametro
	public Camino getCamino(int pos){
		return caminos[pos]; 
	}
	
	//Agregar al vector de una posicion concreta 
	public void agregarCamino(int pos, Camino c){
		caminos[pos] = c; 
	}
	



}

