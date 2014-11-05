import java.util.Scanner;


public class DriverCamino {
	private static void menu() {
        System.out.println("Driver clase Camino"
                + "\n 0.Salir"
                + "\n 1.crear Camino(String ciudadOrigen, String ciudadDestino, int capacidad, String transporte)"
                + "\n 2.Camino(String ciudadOrigen, String ciudadDestino,  String transporte)"
                + "\n 3.getTransporte() -> String"
                + "\n 4.getOrigen() -> String"
                + "\n 5.getDestino() -> String"
                + "\n 6.getCapacidad() -> int"
                + "\n 7.setTransporte(String transporte)"
                + "\n 8.setCapacidad(int capacidad)"
        		+"\n");
    }
	
    public static void main(String [] args) throws Exception {
    	Camino camino = null;
        menu();
        Scanner sc = new Scanner(System.in);
        String[] lsplited;
        while (sc.hasNextLine()) {
    	try {
	        lsplited = sc.nextLine().split(" ");
	        switch(Integer.parseInt(lsplited[0])) {
	            case 1: {
	            	String ciudadOrigen = lsplited[1]; 
	            	String ciudadDestino = lsplited[2];
	            	int capacidad = Integer.parseInt(lsplited[3]); 
	            	String medioTransporte= lsplited[4];
	                camino = new Camino(ciudadOrigen,ciudadDestino, capacidad, medioTransporte);
	                break;
	            }
	           case 2: {
	            	String ciudadOrigen = lsplited[1]; 
	            	String ciudadDestino = lsplited[2];
	            	String medioTransporte= lsplited[3];
	                camino = new Camino(ciudadOrigen,ciudadDestino, medioTransporte);
	                break;
	            }
	            case 3: {
	               System.out.print( camino.getTransporte() + "\n");
	               break;
	            }
	            case 4:{
		               System.out.print( camino.getOrigen() + "\n");
		               break;
	            }
	            case 5:{
		               System.out.print( camino.getDestino() + "\n");
		               break;
	            }
	            case 6:{
		               System.out.print( camino.getCapacidad() + "\n");
		               break;
	            }
	            case 7: {
	            	String transporte = lsplited[1]; 
	            	camino.setTransporte(transporte);
	                break;
	            }
	            case 8: {
	            	String capacidad = lsplited[1]; 
	            	camino.setTransporte(capacidad);
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


