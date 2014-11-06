//package Dominio;


public class Camino {

	private String ciudadOrigen;
	private String ciudadDestino;
	private int capacidad;
	private String transporte;
	
	
	/** Constructor de Camino   
	 *  con capacidad
	 */
	public Camino(String ciudadOrigen, String ciudadDestino, int capacidad, String transporte){
		
		this.ciudadOrigen = ciudadOrigen;
		this.ciudadDestino = ciudadDestino;
		this.capacidad = capacidad;
		this.transporte = transporte;
	}
	/**
	 * Constructor de Camino sin capacidad, 1 por defecto
	 */
	public Camino(String ciudadOrigen, String ciudadDestino,  String transporte){
		
		this.ciudadOrigen = ciudadOrigen;
		this.ciudadDestino = ciudadDestino;
		this.transporte = transporte;
		this.capacidad = 1;
	}

    public String getTransporte(){
    	return transporte;
    }
    public String getOrigen(){
    	return ciudadOrigen;
    }
    public String getDestino(){
    	return ciudadDestino;
    }
    public int getCapacidad(){
    	return capacidad;
    }

    public void setTransporte(String transporte){
    	this.transporte = transporte;
    }
    public void setCapacidad(int capacidad){
    	this.capacidad = capacidad;
    }

 
	
	
	
	
	
	
	
	
}
