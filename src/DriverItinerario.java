import java.util.*;

/**
 * @author Olga 
 */

public class DriverItinerario {
	
	private static void menu() {
        System.out.println("Driver clase Itinerario"
                + "\n 0.Salir"
                + "\n 1.crear itinerario(Agente ag)"
                + "\n 2.setNombre(String nombre)"
                + "\n 3.getNumeroCaminos()"
                + "\n 4.getNombreItinerario()"
                + "\n 5.getCamino(int pos)"
                + "\n 6.agregarCamino(int pos, Camino c)"  
                + "\n 7. ConsultaCiudadOrigenCamino(int pos)"
                + "\n 8. ConsultaCiudadDestinoCamino(int pos)"
        		+"\n");
    }
	
    public static void main(String [] args) throws Exception {
    	Itinerario it = null;
        menu();
        Scanner sc = new Scanner(System.in);
        String[] lsplited;
        while (sc.hasNextLine()) {
    	try {
	        lsplited = sc.nextLine().split(" ");
	        switch(Integer.parseInt(lsplited[0])) {
	            case 1: {
	            	Agente aux = null; 
	            	String nombre = lsplited[1]; 
	            	String CO = lsplited[2]; 
	            	String CD = lsplited[3]; 
	            	aux = new Agente(nombre,CO,CD); 
	            	aux.modificarNombre(nombre);
	            	aux.modificarCiudadInicial(CO);
	            	aux.modificarCiudadObjetivo(CD);
	                it = new Itinerario(aux);
	                break;
	            }
	           case 2: {
	            	String nom = lsplited[1];
	            	it.setNombre(nom); 
	                break;
	            }
	            case 3: {
	               System.out.print( it.getNumeroCaminos() + "\n");
	               break;
	            }

	            case 4:{
	            	System.out.print(it.getNombreItinerario() +"\n");
	                break;
	            }
	            case 5:{
	            	int pos = Integer.parseInt(lsplited[1]);
	            	Camino aux = it.getCamino(pos);
	            	System.out.print(aux.getOrigen() +"\n");
	            	System.out.print(aux.getDestino()+ "\n");
	                break;
	            }
	            case 6: {
	            	int pos = Integer.parseInt(lsplited[1]);
	            	String CO = lsplited[2];
	            	String CD = lsplited[3];
	            	int cap = Integer.parseInt(lsplited[4]);
	            	String tra = lsplited[5]; 
	            	Camino aux = new Camino(CO,CD,cap,tra); 
	            	it.agregarCamino(aux, pos); 
	                break;
	            }
	            case 7:{
	            	int pos = Integer.parseInt(lsplited[1]);
	            	Camino aux = it.getCamino(pos);
	            	System.out.print(aux.getOrigen() +"\n");
	                break;	
	            }
	            case 8: {
	            	int pos = Integer.parseInt(lsplited[1]);
	            	Camino aux = it.getCamino(pos);
	            	System.out.print(aux.getDestino()+ "\n");
	                break;
	            }
	            case 0: {
	                System.exit(0);
	            }
	            default: {
	                System.out.println("Entrada de datos no valida, pruebe con un valor entre 1 y 8 o 0 para salir\n");
	                break;
	            }       
	        }
	      
        } catch(Exception e) {
        System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    }

}
