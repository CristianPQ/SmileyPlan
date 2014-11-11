//package Dominio;


public class Camino {

	private String ciudadDestino;
	private int capacidad;
	private String transporte;
	private String ciudadOrigen;
	
	
	/** Constructor de Camino   
	 *  con capacidad
	 */
	public Camino(String ciudadOrigen2, String ciudadDestino2, int capacidad2, String transporte2){
		
		ciudadOrigen = ciudadOrigen2;
		ciudadDestino = ciudadDestino2;
		capacidad = capacidad2;
		transporte = transporte2;
	}
	/**
	 * Constructor de Camino sin capacidad, 1 por defecto
	 */
	public Camino(String ciudadOrigen2, String ciudadDestino2,  String transporte2){
		
		ciudadOrigen = ciudadOrigen2;
		ciudadDestino = ciudadDestino2;
		transporte = transporte2;
		capacidad = 1;
	}
    public String consultarTransporte(){
    	return transporte;
    }
    public String consultarDestino(){
    	return ciudadDestino;
    }
    public String consultarOrigen(){
    	return ciudadOrigen;
    }
    public int consultarCapacidad(){
    	return capacidad;
    }

    public void setTransporte(String transporte2){
    	transporte = transporte2;
    }
    public void setCapacidad(int capacidad2){
    	capacidad = capacidad2;
    }
    public String consultarKey(){
    	return ciudadOrigen;
    }
 
	
	
	
	
	
	
	
	
}
