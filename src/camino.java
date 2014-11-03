//package Dominio;


public class Camino {

	private String ciudadOrigen;
	private String ciudadDestino;
	private int capacidad = 1;
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
	}

    public String consultarTransporte(){
    	return transporte;
    }
    public String consultarOrigen(){
    	return ciudadOrigen;
    }
    public String consultarDestino(){
    	return ciudadDestino;
    }
    public int consultarCapacidad(){
    	return capacidad;
    }

    public void modificarTransporte(String transporte){
    	this.transporte = transporte;
    }
    public void modificarCapacidad(int capacidad){
    	this.capacidad = capacidad;
    }

 
	
	
	
	
	
	
	
	
}
