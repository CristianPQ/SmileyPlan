import java.util.*;

/**
 * @author Olga 
 */

public class DriverControladorMedioTransporte {
	
	private static void menu() {
        System.out.println("Driver clase Controlador de Medios de Transporte"
                + "\n 0.Salir"
                + "\n 1.crear ControladorMedioTransporte()"
                + "\n 2.agregarMedioTransporte(String nombre, int coste)"
                + "\n 3.borrarMedioTransporte(String nombre)"
                + "\n 4.modificarNombre(String nNuevo, MedioTransporte m)"
                + "\n 5.modificarPrecio(int pNuevo, MedioTransporte m)"
                + "\n 6.getCantidadTransportes()"  
        		+"\n");
    }
	
    public static void main(String [] args) throws Exception {
    	ControladorMedioTransporte cm = null;
        menu();
        Scanner sc = new Scanner(System.in);
        String[] lsplited;
        while (sc.hasNextLine()) {
    	try {
	        lsplited = sc.nextLine().split(" ");
	        switch(Integer.parseInt(lsplited[0])) {
	            case 1: {
	                cm = new ControladorMedioTransporte();
	                break;
	            }
	           case 2: {
	        	   Agente aux = null; 
	        	   String nombre = lsplited[1]; 
	        	   int p = Integer.parseInt(lsplited[2]);
	               cm.agregarMedioTransporte(nombre,p);
	               break;
	            }
	            case 3: {
	               String nombre = lsplited[1];
	               cm.borrarMedioTransporte(nombre);
	               break;
	            }
	            case 4:{
	            	MedioTransporte med = null; 
	            	String nombreNuevo = lsplited[1];
	            	String nombreViejo = lsplited[2];
	            	int precio = Integer.parseInt(lsplited[3]);
	            	med = new MedioTransporte(nombreViejo,precio);
	            	cm.modificarNombre(nombreNuevo,med); 
	                break;
	            }
	            case 5:{
	            	MedioTransporte med = null; 
	            	int precioNuevo = Integer.parseInt(lsplited[1]);
	            	String nombre = lsplited[2];
	            	int precio = Integer.parseInt(lsplited[3]);
	            	med = new MedioTransporte(nombre,precio);
	            	cm.modificarPrecio(precioNuevo,med); 
	                break;            	
	            }
	            case 6: {
	            	//System.out.print(cm.getCantidadTransportes() + "\n");
	            	//break; 
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



