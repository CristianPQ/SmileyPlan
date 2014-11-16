import java.util.*;

/**
 * @author olgacarbo
 */

public class DriverControladorItinerarios {
	private static void menu() {
        System.out.println("Driver clase Controlador Itinerarios"
                + "\n 0.Salir"
                + "\n 1.crear ControladorItinerario()"
                + "\n 2.agregarItinerario(String nombre)"
                + "\n 3.agregarCaminoAlItinerario(Itinerario it,camino c)"  
        		+ "\n 4.crear camino(co,cd)"
                +"\n");
    }
	
    public static void main(String [] args) throws Exception {
    	ControladorItinerarios aux = null;
    	Itinerario it; 
        menu();
        Scanner sc = new Scanner(System.in);
        String[] lsplited;
        while (sc.hasNextLine()) {
    	try {
	        lsplited = sc.nextLine().split(" ");
	        switch(Integer.parseInt(lsplited[0])) {
	            case 1: {
	            	aux = new ControladorItinerarios(); 
	                break;
	            }
	           case 2: {
	        	  String nombre = lsplited[1];
	        	  aux.agregarItinerario(nombre);
	        	  int n = aux.consultarSize(); 
	        	  System.out.println( n +"\n");
	              break;
	            }
	            case 3: {
	            	String nA = lsplited[1]; 
	            	String co = lsplited[2];
	            	String cd = lsplited[3];
	            	//it = new Itinerario(nA);
	            	Camino c = new Camino(co,cd, null); 
	            	aux.agregarCaminoAlItinerario(nA,c);
	            	Itinerario m = new Itinerario(nA); 
	            	int n = aux.consultarCaminosIt(m); 
	            	System.out.println( n +"\n");
	               break;
	            }
	            case 4:{
	            	String CO = lsplited[1];
	            	String CD = lsplited[2];
	            	Camino c = aux.crearCamino(CO,CD);
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
