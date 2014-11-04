
public class Itinerario {

	//Datos
	private static final int numCaminosPorDefecto = 60; 
	private String nombre; 
	private Camino[] caminos = new Camino[numCaminosPorDefecto]; 
	
	//Constructora de itinerario vacio
	public void Itinerario(String nombrei) {
		nombre = nombrei; 
		//caminos = Camino
		//caminos??
	}
	
	//getter que devuelve el numero de caminos en el itinerario
	public int numeroCaminos(){
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
	
	/*public void setVectorVacio(int){
		
	}*/
	
	//Informar al vector de una posicion concreta 
	public void agregarCamino(int pos, Camino c){
		caminos[pos] = c; 
	}
	



}

