import java.util.*; 

/*
 * @author Olga 
 */

public class DriverMedioTransporte {
	
	private static void menu() {
        System.out.println("Driver clase Medio de Transporte"
                + "\n 0.Salir"
                + "\n 1.crear MedioTransporte(String nombreTransporte, int precio)"
                + "\n 2.getNombre()"
                + "\n 3.getPrecio()"
                + "\n 4.setNombre(String nombreTransporte)"
                + "\n 5.setPrecio(int precio)"
                //casos para ver si funciona con tren y coche vv ?
                + "\n 6.crear Tren(String nombreTransporte, int precio)"
                + "\n 7.crear Coche(String nombreTransporte, int precio)"
        		+"\n");
    }
	
    public static void main(String [] args) throws Exception {
    	MedioTransporte med = null;
        menu();
        Scanner sc = new Scanner(System.in);
        String[] lsplited;
        while (sc.hasNextLine()) {
    	try {
	        lsplited = sc.nextLine().split(" ");
	        switch(Integer.parseInt(lsplited[0])) {
	            case 1: {
	            	String nombre = lsplited[1]; 
	            	int precio = Integer.parseInt(lsplited[2]);  
	                med = new MedioTransporte(nombre,precio);
	                break;
	            }
	           case 2: {
	        	   System.out.print(med.getNombre() +"\n");
	                break;
	            }
	            case 3: {
	               System.out.print( med.getPrecio() + "\n");
	               break;
	            }
	            case 4:{
	            	String nom = lsplited[1];
	            	med.setNombre(nom); 
	                break;
	            }
	            case 5:{
	            	int precio = Integer.parseInt(lsplited[1]); 
	            	med.setPrecio(precio); 
	                break;
	            }
	            case 6: {
	            	String nombre = lsplited[1]; 
	            	int precio = Integer.parseInt(lsplited[2]);  
	                med = new Tren(nombre,precio);
	                break;
	            }
	            case 7: {
	            	String nombre = lsplited[1]; 
	            	int precio = Integer.parseInt(lsplited[2]);  
	                med = new Coche(nombre,precio);
	                break;
	            }
	            case 0: {
	                System.exit(0);
	            }
	            default: {
	                System.out.println("Entrada de datos no valida, pruebe con un valor entre 1 y 7 o 0 para salir\n");
	                break;
	            }       
	        }
	      
        } catch(Exception e) {
        System.out.println("Error: " + e.getMessage() + "\n");
        }
       }

    }
	
}
