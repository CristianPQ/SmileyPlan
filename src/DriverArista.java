import java.util.*;
/*
 * @author Daniel Villanueva 
 */

public class DriverArista{
private static void menu() {
	        System.out.println("Driver clase Arista"
	                + "\n 0.Salir"
	                + "\n 1.[Constructora] Arista (int targetVertex, int flow, int capacity, int cost)"
	                + "\n 2.consultarVerticeDestino()"
	                + "\n 3.modificarVerticeDestino(int targetVertex)"
	                + "\n 4.consultarFlujo()"
	                + "\n 5.modificarFlujo(int flow)"
	                + "\n 6.consultarCapacidad()"
	                + "\n 7.modificarCapacidad(int capacity)"
	                + "\n 8.consultarCoste()"
	                + "\n 9.modificarCoste(int cost)"
	                +"\n");
}

public static void main(String [] args) throws Exception {
			Arista a = null;
	    	menu();
	    	Scanner sc = new Scanner(System.in);
	    	String[] lsplited;
	    	
	    	while(sc.hasNextLine()){ 
	    		try{
	    			lsplited = sc.nextLine().split(" ");
	    			switch(Integer.parseInt(lsplited[0])){
	    				case 1: {//INIT
	    					int targetVertex = Integer.parseInt(lsplited[1]);
	    					int flow = Integer.parseInt(lsplited[2]);
	    					int capacity = Integer.parseInt(lsplited[3]);
	    					int cost = Integer.parseInt(lsplited[4]);
	    					a = new Arista(targetVertex, flow, capacity, cost);
	    					break;
	    				}
	    				
	    				case 2: {//consultarVerticeDestino
	    					int TV = a.consultarVerticeDestino();
	    					System.out.println("Vertice destino:" + TG + "\n");
	    					break;
	    				}
	    				
	    				case 3: {//modificarVerticeDestino
	    					int TV = Integer.parseInt(lsplited[1]);
	    					a.modificarVerticeDestino(TV);
	    					System.out.println("Nuevo vertice destino:" + a.consultarVerticeDestino() + "\n");
	    					break;
	    				}
	    				
	    				case 4: {//consultarFlujo
	    					int f = a.consultarFlujo();
	    					System.out.println("Flujo:" + n + "\n");
	    					break;
	    				}
	    				
	    				case 5: {//setciudadInicial
	    					String ciudadInicial = lsplited[1];
	    					a.modificarCiudadInicial(ciudadInicial);
	    					System.out.println("Nueva ciudadInicial:" + a.consultarCiudadInicial() + "\n");
	    					break;
	    				}
	    				
	    				case 6: {//getCiudadObjetivo
	    					String n = a.consultarCiudadObjetivo();
	    					System.out.println("Nombre ciudadObjetivo:" + n + "\n");
	    					break;
	    				}
	    				
	    				case 7: {//setciudadObjetivo
	    					String ciudadObjetivo = lsplited[1];
	    					a.modificarCiudadObjetivo(ciudadObjetivo);
	    					System.out.println("Nueva ciudadObjetivo:" + a.consultarCiudadObjetivo() + "\n");
	    					break;
	    				}	
	    				
	    				case 0: {
	    	                System.exit(0);
	    	            }
	    				default: {
	    	                System.out.println("Entrada de datos no valida, pruebe con un valor entre 1 y 17 o 0 para salir\n");
	    	                break;
	    	            } 
	    			}
	    		} catch(Exception e) {
	    	        System.out.println("Error: " + e.getMessage() + "\n");
	    	}
    	}

} //Cierra funcion
} //Cierra clase