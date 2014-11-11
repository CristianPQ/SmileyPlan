
import java.util.*;
/*
 * @author Daniel Villanueva 
 */

public class DriverGNode {

private static void menu() {
	        System.out.println("Driver clase GNode"
	                + "\n 0.Salir"
	                + "\n 1.[Constructora] GNode()"
	                + "\n 2.vaciarGrafo()"
	                + "\n 3.agregarHijo(int flujo, int capacidad, int coste, String nCiudad)"
	                + "\n 4.eliminarHijo(String nCiudad)"
	                + "\n 5.consultarIteradorHijo(String nCiudad)"
	   //             + "\n 6.modificarFlujoArista(int vertex, int targetVertex, int nuevoFlujo)"
	     //           + "\n 7.consultarCapacidadArista(int vertex,int targetVertex)"
	       //         + "\n 8.modificarCapacidadArista(int vertex, int targetVertex, int nuevaCapacidad)"
	         //       + "\n 9.consultarCosteArista(int vertex,int targetVertex)"
	                +"\n");
}

public static void main(String [] args) throws Exception {
			GNode g = null;
	    	menu();
	    	Scanner sc = new Scanner(System.in);
	    	String[] lsplited;
	    	
	    	while(sc.hasNextLine()){ 
	    		try{
	    			lsplited = sc.nextLine().split(" ");
	    			switch(Integer.parseInt(lsplited[0])){
	    				case 1: {
	    					String nCiudad = lsplited[0];
	    					g = new GNode(nCiudad);
	    					break;
	    				}
	    				
	    				case 2: {//AnadirHijo
	    					int flow = Integer.parseInt(lsplited[1]);
	    					int capacity = Integer.parseInt(lsplited[2]);
	    					int cost = Integer.parseInt(lsplited[3]);
	    					String nCiudad = lsplited[4];
	    					g.agregarHijo(flow, capacity, cost, nCiudad);
	    					break;
	    				}
	    				/*
	    				case 4:{ //eliminarHijo 
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int targetVertex = Integer.parseInt(lsplited[2]);
	    					g.eliminarArista(vertex, targetVertex);
	    				}
	    				*/
	    					
	    				case 5: {//consultarIteradorHijo
	    					Iterator<GNodePeso> it = g.consultarIteradorHijos();
	    					int coste = it.next().consultarCoste();
	    					int capacidad = it.next().consultarCapacidad();
	    					int flujo = it.get(0);
	    					
	    					System.out.println(coste + flujo + capacidad);
	    					break;
	    				}
/*	    				
	    				case 6: {//modificarFlujoArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int targetVertex = Integer.parseInt(lsplited[2]);
	    					int nuevoFlujo = Integer.parseInt(lsplited[3]);
	    					g.modificarFlujoArista(vertex, targetVertex, nuevoFlujo);
	    					break;
	    					    				
	    				case 7: {//consultarCapacidadArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int targetVertex = Integer.parseInt(lsplited[2]);
	    					int capacidadArista = g.consultarCapacidadArista(vertex, targetVertex);
	    					System.out.println("Capacidad Arista ("+ vertex + "," +  targetVertex +"): "+ capacidadArista +"\n");
	    					break;
	    				}
	    				
	    				case 8: {//modificarCapacidadArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int targetVertex = Integer.parseInt(lsplited[2]);
	    					int nuevaCapacidad = Integer.parseInt(lsplited[3]);
	    					g.modificarCapacidadArista(vertex, targetVertex, nuevaCapacidad);
	    					break;
	    				}
	    				
	    				case 9: {//ConsultarCosteArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int targetVertex = Integer.parseInt(lsplited[2]);
	    					int costeArista = g.consultarCosteArista(vertex, targetVertex);
	    					System.out.println("Coste Arista ("+ vertex + "," +  targetVertex +"): "+ costeArista +"\n");
	    					break;
	    				}
	    				
	    				case 10: {//modificarCosteArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int targetVertex = Integer.parseInt(lsplited[2]);
	    					int nuevoCoste = Integer.parseInt(lsplited[3]);
	    					g.modificarCapacidadArista(vertex, targetVertex, nuevoCoste);
	    					break;
	    				}
	    				
	    				case 11: {
	    					int num = g.consultarNumVertices();
	    					System.out.println("Numero de vertices:" + num + "\n");
	    					
	    				}
	    				
	    				case 12: {
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int num = g.consultarNumAristasVertice(vertex);
	    					System.out.println("Aristas desde vertice "+ vertex+ ": " + num + "\n");
	    				}
	    		
	    */				
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
