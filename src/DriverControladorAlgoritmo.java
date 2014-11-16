import java.util.*;

public class DriverControladorAlgoritmo {
	private static void menu() {
        System.out.println("Driver clase Itinerario"
                + "\n 0.Salir"
                + "\n 1.crear ControladorAlgoritmo(Entrada e)"
                + "\n 2.asignarItinerarioAAgente()"
        		+"\n");
    }
	
    public static void main(String [] args) throws Exception {
    	ControladorAlgoritmo ca = null;
        menu();
        Scanner sc = new Scanner(System.in);
        String[] lsplited;
        while (sc.hasNextLine()) {
    	try {
	        lsplited = sc.nextLine().split(" ");
	        switch(Integer.parseInt(lsplited[0])) {
	            case 1: {
	            	
	            	
	                break;
	            }
	           case 2: {
	            	
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
