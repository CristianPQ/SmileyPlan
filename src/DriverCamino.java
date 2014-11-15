import java.util.Scanner;


public class DriverCamino {
	private static void menu() {
        System.out.println("Driver clase Camino"
                + "\n 0.Salir"
                + "\n 1.crear Camino(String ciudadOrigen, String ciudadDestino, int capacidad, String transporte)"
                + "\n 2.Camino(String ciudadOrigen, String ciudadDestino,  String transporte)"
                + "\n 3.consultarTransporte() -> String"
                + "\n 4.consultarOrigen() -> String"
                + "\n 5.consultarDestino() -> String"
                + "\n 6.consultarCapacidad() -> int"
                + "\n 7.modificar Transporte(String transporte)"
                + "\n 8.modificarCapacidad(int capacidad)"
                + "\n 9.modificarCiudadOrigen(string ciudadOrigen)"
                + "\n 10.modificarCiudadDesino(string ciudadDestino)"
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
	               System.out.print( camino.consultarTransporte() + "\n");
	               break;
	            }
	            case 4:{
		               System.out.print( camino.consultarOrigen() + "\n");
		               break;
	            }
	            case 5:{
		               System.out.print( camino.consultarDestino() + "\n");
		               break;
	            }
	            case 6:{
		               System.out.print( camino.consultarCapacidad() + "\n");
		               break;
	            }
	            case 7: {
	            	String transporte = lsplited[1]; 
	            	camino.modificarTransporte(transporte);
	                break;
	            }
	            case 8: {
	            	int capacidad = Integer.parseInt(lsplited[1]); 
	            	camino.modificarCapacidad(capacidad);
	                break;
	            }	
	            case 9: {
	            	String ciudadOrigen = lsplited[1]; 
	            	camino.modificarCiudadOrigen(ciudadOrigen);
	                break;
	            }
	            case 10: {
	            	String ciudadDestino = lsplited[1]; 
	            	camino.modificarCiudadDestino(ciudadDestino);
	                break;
	            }
	            case 0: {
	                System.exit(0);
	            }
	            default: {
	                System.out.println("Entrada de datos no valida, pruebe con un valor entre 1 y 10 o 0 para salir\n");
	                break;
	            }       
	        }
	      
        } catch(Exception e) {
        System.out.println("Error: " + e.getMessage() + "\n");
        }
       }

    }
	
}


