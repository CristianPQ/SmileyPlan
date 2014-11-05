import java.util.ArrayList;
import java.util.Scanner;


public class DriverConjuntoCaminos {
	private static void menu() {
        System.out.println("Driver clase Controlador de Conujunto de Caminos"
                + "\n 0.Salir"
                + "\n 1.crear ConjuntoCaminos()"
                + "\n 2.void agregarCamino(String ciudadOrigen, String ciudadDestno, String transporte)"
                + "\n 3.getCapacidad(String ciudadOrigen, String ciudadDestno, String transporte) --> int"
                + "\n 4.getNumCaminos() --> int"
                + "\n 5.borrarCamino (Camino camino)"
                + "\n 6. ArrayList<Camino> getCaminosConCiudadOrigen (String ciudadOrigen)"  
        		+"\n");
    }
	
    public static void main(String [] args) throws Exception {
    	ConjuntoCaminos cc = null;
        menu();
        Scanner sc = new Scanner(System.in);
        String[] lsplited;
        while (sc.hasNextLine()) {
    	try {
	        lsplited = sc.nextLine().split(" ");
	        switch(Integer.parseInt(lsplited[0])) {
	            case 1: {
	                cc = new ConjuntoCaminos();
	                break;
	            }
	           case 2: {
	        	   String ciudadOrigen = lsplited[1]; 
	        	   String ciudadDestino = lsplited[2]; 
	        	   String transporte = lsplited[3]; 
	        	   Camino c = new Camino(ciudadOrigen, ciudadDestino, transporte);
	               cc.agregarCamino(c);
	               break;
	            }
	            case 3: {
		        	   String ciudadOrigen = lsplited[1]; 
		        	   String ciudadDestino = lsplited[2]; 
		        	   String transporte = lsplited[3]; 
		        	   Camino c = new Camino(ciudadOrigen, ciudadDestino, transporte);
	            	System.out.print(cc.getCapacidad(c) + "\n");
	               break;
	            }
	            case 4:{
	            	System.out.print(cc.getNumCaminos() + "\n");
	                break;
	            }
	            case 5:{
	            	String ciudadOrigen = lsplited[1]; 
		        	String ciudadDestino = lsplited[2]; 
		        	String transporte = lsplited[3]; 
		        	Camino c = new Camino(ciudadOrigen, ciudadDestino, transporte);
		            cc.borrarCamino(c);
		            break;          	
	            }
	            case 6: {
	            	String ciudadOrigen = lsplited[1]; 
	            	ArrayList<Camino> l = cc.getCaminosConCiudadOrigen(ciudadOrigen);
	            	for (int i = 0; i < l.size(); ++i)
	            		System.out.print(l.get(i).getOrigen() + ' ' + l.get(i).getDestino() + ' ' + l.get(i).getTransporte() + "\n");
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
