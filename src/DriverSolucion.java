import java.util.*;

public class DriverSolucion {
	
	private static void menu() {
        System.out.println("Driver clase Controlador de Medios de Transporte"
                + "\n 0.Salir"
                + "\n 1.crear Solucion()"
                + "\n 2.agregarVertice(int i, int vertex)"
                + "\n 3 agregarCosteAItinerario(int i, int c)"
                + "\n 4.obtenVertice(int i, int posv)"
                + "\n 5 obten numCiudades(int i)"
                + "\n 6.obtenNumeroItinerarios()"  
        		+"\n");
    }
	
    public static void main(String [] args) throws Exception {
    	Solucion so = null;
        menu();
        Scanner sc = new Scanner(System.in);
        String[] lsplited;
        while (sc.hasNextLine()) {
    	try {
	        lsplited = sc.nextLine().split(" ");
	        switch(Integer.parseInt(lsplited[0])) {
	            case 1: {
	            	int i = Integer.parseInt(lsplited[1]);
	                so = new Solucion(i);
	                break;
	            }
	           case 2: {
	        
	               break;
	            }
	            case 3: {
	            	int c  = Integer.parseInt(lsplited[1]);
	            	int i = Integer.parseInt(lsplited[1]);
	            	so.agregarCosteAItinerario(i, c);
	               break;
	            }
	            case 4:{
	            	int posv  = Integer.parseInt(lsplited[1]);
	            	int i = Integer.parseInt(lsplited[1]);
	            	int v = so.obtenVertice(i,posv);
	            	System.out.print(v + "/n"); 
	                break;
	            }
	            case 5:{
	            	int i = Integer.parseInt(lsplited[1]);
	            	System.out.print(so.obtenNumCiudades(i) + "/n");            	
	                break;            	
	            }
	            case 6: {
	            	System.out.println(so.obtenNumeroItinerarios() + "/n");
	            	break; 
	            }
	            case 0: {
	                System.exit(0);
	            }
	            default: {
	                System.out.println("Entrada de datos no valida, pruebe con un valor entre 1 y 6 o 0 para salir\n");
	                break;
	            }       
	        }
	      
        } catch(Exception e) {
        System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    }
	

}
