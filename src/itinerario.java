
public class itinerario {

	//Datos
	private static final int numCaminosPorDefecto = 60; 
	private String nombre; 
	private Camino[] caminos = new Camino[numCaminosPorDefecto]; 
	
	//Constructora de itinerario vacio
	public setItinerario(String nombrei) {
		nombre = nombrei; 
		//caminos = Camino
		//caminos??
	}
	
	public int getLength(){
		return caminos.length(); 
	}
	
	public String getNombre() {
		return nombre; 
	}
	
	public Camino getCamino(int pos){
		return caminos[pos]; 
	}
	
	/*public void setVectorVacio(int){
		
	}*/
	
	//Informar al vector de una posicion concreta 
	public void setCamino(int pos, Camino valor){
		caminos[pos] = valor; 
	}
	



}

