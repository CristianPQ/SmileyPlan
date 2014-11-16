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
                + "\n 5.agregarCamino(Camino c)"
                + "\n 6.crear Camino(co,cd)"
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
	            	String nombre = lsplited[1]; 
	            	it = new Itinerario(nombre); 
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
	            case 5: {
	            	String CO = lsplited[1];
	            	String CD = lsplited[2];
	            	String tra = lsplited[3]; 
	            	Camino c = new Camino(CO,CD, tra);
	            	it.agregarCamino(c); 
	                break;
	            }
	            case 6: {
	            	String co = lsplited[1];
	            	String cd = lsplited[2];
	            	Camino c = it.crearCamino(co, cd);
	            	//System.out.print(c.consultarOrigen()); 
	            	break; 
	            }
	            case 0: {
	                System.exit(0);
	            }
	            default: {
	                System.out.println("Entrada de datos no valida, pruebe con un valor entre 1 y 5 o 0 para salir\n");
	                break;
	            }       
	        }
	      
        } catch(Exception e) {
        System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    }

}
