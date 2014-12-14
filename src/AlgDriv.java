
import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.type.NullType;

public class AlgDriv {





	private static void menu() {
	        System.out.println("Driver clase GrafoAntiguo"
	                + "\n 0.Salir"
	                + "\n 1.[Constructora] GrafoAntiguo(int numVertex)"
	                + "\n 2.existeAdyacente(int numVertex, int targetVertex)"
	                + "\n 3.anadirArista(int vertex, int targetVertex, int flow, int capacity, int cost)"
	                + "\n 4.eliminarArista(int vertex, int targetVertex)"
	                + "\n 5.consultarFlujoArista(int vertex,int targetVertex, int nuevoFlujo)"
	                + "\n 6.modificarFlujoArista(int vertex, int targetVertex, int nuevoFlujo)"
	                + "\n 7.consultarCapacidadArista(int vertex,int targetVertex)"
	                + "\n 8.modificarCapacidadArista(int vertex, int targetVertex, int nuevaCapacidad)"
	                + "\n 9.consultarCosteArista(int vertex,int targetVertex)"
	                + "\n 10.modificarCosteArista(int vertex, int targetVertex, int nuevoCoste)"
	                + "\n 11.consultarNumVertices()"
	                + "\n 12.consultarNumAristasVertice(int vertex)"
	                + "\n 13.ConsultarAdyacentesDe(int vertex)"
	                +"\n");
}

public static void main(String [] args) throws Exception {
			AlgGraph g = null;
	    	menu();
	    	Scanner sc = new Scanner(System.in);
	    	String[] lsplited;
	    	
	    	while(sc.hasNextLine()){ 
	    		try{
	    			lsplited = sc.nextLine().split(" ");
	    			switch(Integer.parseInt(lsplited[0])){
	    				case 1: {
	    					int numVertex = Integer.parseInt(lsplited[1]);
	    					System.out.println("Llego");
	    					Grafo<NullType,Arista> g2 = new Grafo<NullType, Arista> (numVertex);
	    					System.out.println("Llego");
	    					g = new AlgGraph(g2);
	    					System.out.println("Llego");

	    					break;
	    				}
	    				case 2:{//existe la arista?    				
	    					int numVertex = Integer.parseInt(lsplited[1]);
	    					int numAd = Integer.parseInt(lsplited[2]);
	    					if(g.existeAdyacente(numVertex, numAd))
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
	    					int targetVertex = Integer.parseInt(lsplited[2]);
	    					g.eliminarArista(vertex, targetVertex);
	    					break;
	    				}
	    				
	    				case 5: {//consultarFlujoArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int targetVertex = Integer.parseInt(lsplited[2]);
	    					int flujoArista = g.consultarFlujoArista(vertex, targetVertex);
	    					System.out.println("Flujo Arista ("+ vertex + "," +  targetVertex +"): "+ flujoArista +"\n");
	    					break;
	    				}
	    				  				
	    				case 6: {//modificarFlujoArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int targetVertex = Integer.parseInt(lsplited[2]);
	    					int nuevoFlujo = Integer.parseInt(lsplited[3]);
	    					g.modificarFlujoArista(vertex, targetVertex, nuevoFlujo);
	    					break;
	    				}
	    				
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
	    				
	    			/*	case 11: {
	    					int num = g.consultarNumVertices();
	    					System.out.println("Numero de vertices:" + num + "\n");
	    					break;
	    					
	    				}
	    				*/
	    				
	    				case 12: {
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int num = g.consultarNumAristasVertice(vertex);
	    					System.out.println("Aristas desde vertice "+ vertex+ ": " + num + "\n");
	    				
	    					break;
	    				}	
	    				
	    				case 13: {
	    					int numVertex = Integer.parseInt(lsplited[1]);
	    					ArrayList <Arista> l = g.g.consultarAristasSalida(numVertex);
	    					for (int i = 0; i < l.size(); ++i){
	    						System.out.println(l.get(i).consultarVerticeDestino()  + " ");
	    					}
	    					System.out.println("\n");
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
}
