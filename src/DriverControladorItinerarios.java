import java.util.*;

/**
 * @author olgacarbo
 */

public class DriverControladorItinerarios {
	private static void menu() {
        System.out.println("Driver clase Controlador Itinerarios"
                + "\n 0.Salir"
                + "\n 1.crear ControladorItinerario()"
                + "\n 2.agregarItinerario(String nombre, ciudades, integer)" 
                + "\n 3.escribirItinerario()"
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
	        	  it = new Itinerario(); 
	        	  String nombre = lsplited[1];
	        	  ArrayList<String> ciudades = new ArrayList<String>(); 
	        	  String n1 = lsplited[2]; ciudades.add(n1); 
	        	  String n2 = lsplited[3]; ciudades.add(n2); 
	        	  String n3 = lsplited[4]; ciudades.add(n3); 
	        	  String n4 = lsplited[5]; ciudades.add(n4); 
	        	  String n5 = lsplited[6]; ciudades.add(n5); 
	        	  String n6 = lsplited[7]; ciudades.add(n6); 
<<<<<<< HEAD
	        	  int coste = Integer.parseInt(lsplited[8]);
	        	  aux.agregarItinerario(nombre, ciudades, coste);
=======
	        	  int nuevoCoste = Integer.parseInt(lsplited[8]);
	        	  aux.agregarItinerario(nombre, ciudades, nuevoCoste);
>>>>>>> FETCH_HEAD
	        	  int n = aux.consultarSize(); 
	        	  int m = aux.consultarCiudadesIt(it); 
	        	  System.out.println( n + " " + m + "\n");
	              break;
	            }
	           case 3: {
	        	  aux.escribirItinerarios(); 
	        	  break;
	           }
 
	            case 0: {
	                System.exit(0);
	            }
	            default: {
	                System.out.println("Entrada de datos no valida, pruebe con un valor entre 1 y 2 o 0 para salir\n");
	                break;
	            }       
	        }
	      
        } catch(Exception e) {
        System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    }
	

}
