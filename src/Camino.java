import java.util.Comparator;

//package Dominio;

class OrdenCamino implements Comparator<Camino> {
	public int compare(Camino a, Camino b) {
		int orig = a.consultarOrigen().compareTo(b.consultarOrigen());
		if(orig != 0) return orig;
		else {
			int dest = a.consultarDestino().compareTo(b.consultarDestino());
			if(dest != 0) return dest;
			else return a.consultarTransporte().compareTo(b.consultarDestino());
		}
	}
}

public class Camino {

	private String ciudadDestino;
	private int capacidad;
	private String transporte;
	private String ciudadOrigen;
	
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		Camino c = (Camino) obj;
		if(ciudadDestino == null) {
			if(c.ciudadDestino != null) return false;
		} else if(!ciudadDestino.equals(c.ciudadDestino)) return false;
		if(transporte == null) {
			if(c.transporte != null) return false;
		} else if(!transporte.equals(c.transporte)) return false;
		if(ciudadOrigen == null) {
			if(c.ciudadOrigen != null) return false;
		} else if(!ciudadOrigen.equals(c.ciudadOrigen)) return false;
		return true;
	}
	
	
	/**
	 * Creadora 
	 * @param string ciudadOrigen2
	 * @param string ciudadDestino2
	 * @param int capacidad2
	 * @param string transporte2
	 */
	public Camino(String ciudadOrigen2, String ciudadDestino2, int capacidad2, String transporte2){
		
		ciudadOrigen = ciudadOrigen2;
		ciudadDestino = ciudadDestino2;
		capacidad = capacidad2;
		transporte = transporte2;
	}
	/**
	 * Creadora sin el parametro capacidad, asignara 1 por defecto
	 * @param string ciudadOrigen2
	 * @param string ciudadDestino2
	 * @param string transporte2
	 */
	public Camino(String ciudadOrigen2, String ciudadDestino2,  String transporte2){
		
		ciudadOrigen = ciudadOrigen2;
		ciudadDestino = ciudadDestino2;
		transporte = transporte2;
		capacidad = 1;
	}
	/**
	 * Devuelve el medio de transporte del camino
	 * @return string medio de transporte del camino
	 */
    public String consultarTransporte(){
    	return transporte;
    }
    /**
     * Devuelve la ciudad destino del camino
     * @return string ciudad destino
     */
    public String consultarDestino(){
    	return ciudadDestino;
    }
    /**
     * Devuelve la ciudad origen del camino
     * @return string ciudad origen
     */
    public String consultarOrigen(){
    	return ciudadOrigen;
    }
    /**
     * Devuelve la capacidad del camino
     * @return int capacidad
     */
    public int consultarCapacidad(){
    	return capacidad;
    }
    /**
     * Modificadora de la ciudad origen del camino
     * @param string ciudad nueva ciudad Origen
     */
    public void modificarCiudadOrigen(String ciudad){
    	ciudadOrigen = ciudad;
    }  
    /**
     * Modificadora de la ciudad destino del camino
     * @param ciudad nueva ciudad Destino
     */
    public void modificarCiudadDestino(String ciudad){
    	ciudadDestino = ciudad;
    }    
    /**
     * Modificadora de medio de transporte del camino
     * @param string transporte2 el nuevo medio de transporte del camino
     */
    public void modificarTransporte(String transporte2){
    	transporte = transporte2;
    }
    /**
     * Modificadora de la capacidad del camino
     * @param int capacidad2 nueva capacidad del camino
     */
    public void modificarCapacidad(int capacidad2){
    	capacidad = capacidad2;
    }
    /**
     * Devuelve la key para utilizar en un TsT, esta sera ciudadOrigen
     * @return
     */
    public String consultarKey(){
    	return ciudadOrigen;
    }
 
	
	
	
	
	
	
	
	
}
