
import java.util.*;
/*
 * @author Daniel Villanueva 
 */

public class DriverEntrada {

private static void menu() {
	        System.out.println("Driver clase GrafoAntiguo"
	                + "\n 0.Salir"
	                + "\n 1.[Constructora] Entrada(GrafoAntiguo G, int s, int t, int numAgentes)"
	                + "\n 2.GrafoAntiguo consultarGrafo()"
	                + "\n 3.consultarSource()"	                
	                + "\n 4.consultarSink()"
	                + "\n 5.consultarNumeroAgentes()"
	                + "\n 6.modificarGrafo(GrafoAntiguo G)"
	                + "\n 7.modificarSource(int source)"
	                + "\n 8.modificarSink(int sink)"
	                + "\n 9.modificarNumeroAgentes(int numAg)"
	                +"\n");
}

public static void main(String [] args) throws Exception {
			Entrada e = null;
	    	menu();
	    	Scanner sc = new Scanner(System.in);
	    	String[] lsplited;
	    	
	    	while(sc.hasNextLine()){ 
	    		try{
	    			lsplited = sc.nextLine().split(" ");
	    			switch(Integer.parseInt(lsplited[0])){
	    				case 1: {
	    					int numVertex = Integer.parseInt(lsplited[1]);
	    					e = new Entrada(g, s, t, numAg);
	    					break;
	    				}
	    				case 2:{//existe la arista?    				
	    					int numVertex = Integer.parseInt(lsplited[1]);
	    					int numAd = Integer.parseInt(lsplited[2]);
	    					g.existeAdyacente(numVertex, numAd);
	    					System.out.println("Si existe arista desde " + numVertex + " hacia "+ numAd);
	    					break;
	    				}

	    				case 3: {//AnadirArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int targetVertex = Integer.parseInt(lsplited[2]);
	    					int flow = Integer.parseInt(lsplited[3]);
	    					int capacity = Integer.parseInt(lsplited[4]);
	    					int cost = Integer.parseInt(lsplited[5]);
	    					g.anadirArista(vertex, targetVertex, flow, capacity, cost);
	    					break;
	    				}
	    				case 4:{ //eliminarArista
	    					int vertex = Integer.parseInt(lsplited[1]);

	    					break;
	    				}
	    				
	    				case 5: {//consultarFlujoArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					System.out.println("Flujo Arista ("+ vertex + "," +  targetVertex +"): "+ flujoArista +"\n");
	    					break;
	    				}
	    				  				
	    				case 6: {//modificarFlujoArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					break;
	    				}
	    				
	    				case 7: {//consultarCapacidadArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					break;
	    				}
	    				
	    				case 8: {//modificarCapacidadArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					break;
	    				}
	    				
	    				case 9: {//ConsultarCosteArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					break;
	    				}

	    				
	   		
	    				case 0: {
	    	                System.exit(0);
	    	            }
	    				default: {
	    	                System.out.println("Entrada de datos no valida, pruebe con un valor entre 1 y 9 o 0 para salir\n");
	    	                break;
	    	            } 
	    			}
	    		} catch(Exception e) {
	    	        System.out.println("Error: " + e.getMessage() + "\n");
	    	}
    	}

} //Cierra funcion
} //Cierra clase