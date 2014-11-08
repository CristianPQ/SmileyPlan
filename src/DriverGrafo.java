
import java.util.Scanner;
/*
 * @author Daniel Villanueva 
 */

public class DriverGrafo {

private static void menu() {
	        System.out.println("Driver clase Grafo"
	                + "\n 0.Salir"
	                + "\n 1.[Constructora] Grafo()"
	                + "\n 2.vaciarGrafo()"
	                + "\n 3.anadirArista(int vertex, int targetVertex, int flow, int capacity, int cost)"
	                + "\n 4.eliminarArista()"
	                + "\n 5.consultarVerticeDestinoArista(int vertex)"
	                + "\n 6.modificarVerticeDestinoArista(int vertex, int nuevoFlujo)"
	                + "\n 7.consultarFlujoArista(int vertex)"
	                + "\n 8.modificarFlujoArista(int vertex, int nuevoFlujo)"
	                + "\n 9.consultarCapacidadArista(int vertex)"
	                + "\n 10.modificarCapacidadArista(int vertex, int nuevaCapacidad)"
	                + "\n 11.consultarCosteArista(int vertex)"
	                + "\n 12.modificarCosteArista(int vertex, int nuevoCoste)"
	                + "\n 13.consultarNumVertices()"
	                +"\n");
}

public static void main(String [] args) throws Exception {
			Grafo g = null;
	    	menu();
	    	Scanner sc = new Scanner(System.in);
	    	String[] lsplited;
	    	
	    	while(sc.hasNextLine()){ 
	    		try{
	    			lsplited = sc.nextLine().split(" ");
	    			switch(Integer.parseInt(lsplited[0])){
	    				case 1: {
	    					g = new Grafo();
	    					break;
	    				}
	    				case 2:{
	    					g.vaciarGrafo();
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
	    				case 4:{
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					g.eliminarArista(vertex);
	    				}
	    				
	    				case 5: {//consultarVerticeDestinoArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int verticeDestinoArista = g.consultarVerticeDestinoArista(vertex);
	    					System.out.println("Vertice destino:" + verticeDestinoArista + "\n");
	    					break;
	    				}
	    				
	    				case 6: {//modificarVerticeDestinoArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int nuevoVerticeDestino = Integer.parseInt(lsplited[2]);
	    					g.modificarVerticeDestinoArista(vertex, nuevoVerticeDestino);
	    					break;
	    				}
	    				
	    				case 7: {//consultarFlujoArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int f = g.consultarFlujoArista(vertex);
	    					System.out.println("Flujo:" + f + "\n");
	    					break;
	    				}
	    				
	    				case 8: {//modificarFlujoArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int f = Integer.parseInt(lsplited[2]);
	    					g.modificarFlujoArista(vertex, f);
	    					break;
	    				}
	    				
	    				case 9: {//consultarCapacidadArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int c = g.consultarCapacidadArista(vertex);
	    					System.out.println("Capacidad:" + c + "\n");
	    					break;
	    				}
	    				
	    				case 10: {//modificarCapacidadArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int c = Integer.parseInt(lsplited[2]);
	    					g.modificarCapacidadArista(vertex, c);
	    					break;
	    				}
	    				
	    				case 11: {//consultarCosteArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int c = g.consultarCapacidadArista(vertex);
	    					System.out.println("Capacidad:" + c + "\n");
	    					break;
	    				}
	    				
	    				case 12: {//modificarCosteArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int c = Integer.parseInt(lsplited[2]);
	    					g.modificarCosteArista(vertex, c);
	    					break;
	    				}
	    				
	    				case 13: {
	    					int num = g.consultarNumVertices();
	    					System.out.println("Capacidad:" + c + "\n")
	    					
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
