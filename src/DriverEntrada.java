
import java.util.*;

import javax.lang.model.type.NullType;
/*
 * @author Daniel Villanueva 
 */

public class DriverEntrada {

private static void menu() {
	        System.out.println("Driver clase GrafoAntiguoAntiguo"
	                + "\n 0.Salir"
	                + "\n 1.[Constructora] GrafoAntiguoAntiguo()"
	                + "\n 2.anadirNumeroAdyacencias(int numvertex, int numAd)"
	                + "\n 3.anadirArista(int vertex, int targetVertex, int flow, int capacity, int cost)"
	                + "\n 4.consultarFlujoArista(int vertex, int targetVertex)"
	                + "\n 5.modificarFlujoArista(int vertex,int targetVertex, int nuevoFlujo)"
	                + "\n 6.modificarFlujoArista(int vertex, int targetVertex, int nuevoFlujo)"
	                + "\n 7.consultarCapacidadArista(int vertex,int targetVertex)"
	                + "\n 8.modificarCapacidadArista(int vertex, int targetVertex, int nuevaCapacidad)"
	                + "\n 9.consultarCosteArista(int vertex,int targetVertex)"
	                + "\n 10.modificarCosteArista(int vertex, int targetVertex, int nuevoCoste)"
	                + "\n 11.consultarNumVertices()"
	                + "\n 12.consultarNumAristasVertice(int vertex)"
	                + "\n 13.CONSULTARADYACENTES(int vertex)"
	                + "\n 14.modificarSink(int t)"
	                + "\n 15.modificarSource(int s)"
	                + "\n 16.modificarNumAg(int numAg)"
	                + "\n 17.consultarSource()"
	                + "\n 18.consultarSink()"
	                + "\n 19.consultarNumAg()"
	                +"\n");
}

public static void main(String [] args) throws Exception {
			//GrafoAntiguo g = null;
	    	menu();
	    	Scanner sc = new Scanner(System.in);
	    	String[] lsplited;
			Entrada e = null;


	    	
	    	while(sc.hasNextLine()){ 
	    		try{
	    			lsplited = sc.nextLine().split(" ");
	    			switch(Integer.parseInt(lsplited[0])){
	    				case 1: {
	    					int numVertex = Integer.parseInt(lsplited[1]);
	    					Grafo<NullType,Arista> g2 = new Grafo<NullType, Arista> (numVertex);
	    					e = new Entrada(g2, numVertex);

	    					break;
	    				}
	    				case 2:{//existe la arista?    				
	    					int numVertex = Integer.parseInt(lsplited[1]);
	    					int numAd = Integer.parseInt(lsplited[2]);
	    					if(e.existeAdyacente(numVertex, numAd))
	    					System.out.println("Si existe arista desde " + numVertex + " hacia "+ numAd);
	    					else System.out.println("Esa arista no existe");
	    					break;
	    				}

	    				case 3: {//AnadirArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int targetVertex = Integer.parseInt(lsplited[2]);
	    					int flow = Integer.parseInt(lsplited[3]);
	    					int capacity = Integer.parseInt(lsplited[4]);
	    					int cost = Integer.parseInt(lsplited[5]);
	    					e.anadirArista(vertex, targetVertex, flow, capacity, cost);
	    					break;
	    				}
	    				case 4:{ //eliminarArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int targetVertex = Integer.parseInt(lsplited[2]);
	    					e.eliminarArista(vertex, targetVertex);
	    					break;
	    				}
	    				
	    				case 5: {//consultarFlujoArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int targetVertex = Integer.parseInt(lsplited[2]);
	    					int flujoArista = e.consultarFlujoArista(vertex, targetVertex);
	    					System.out.println("Flujo Arista ("+ vertex + "," +  targetVertex +"): "+ flujoArista +"\n");
	    					break;
	    				}
	    				  				
	    				case 6: {//modificarFlujoArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int targetVertex = Integer.parseInt(lsplited[2]);
	    					int nuevoFlujo = Integer.parseInt(lsplited[3]);
	    					e.modificarFlujoArista(vertex, targetVertex, nuevoFlujo);
	    					break;
	    				}
	    				
	    				case 7: {//consultarCapacidadArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int targetVertex = Integer.parseInt(lsplited[2]);
	    					int capacidadArista = e.consultarCapacidadArista(vertex, targetVertex);
	    					System.out.println("Capacidad Arista ("+ vertex + "," +  targetVertex +"): "+ capacidadArista +"\n");
	    					break;
	    				}
	    				
	    				case 8: {//modificarCapacidadArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int targetVertex = Integer.parseInt(lsplited[2]);
	    					int nuevaCapacidad = Integer.parseInt(lsplited[3]);
	    					e.modificarCapacidadArista(vertex, targetVertex, nuevaCapacidad);
	    					break;
	    				}
	    				
	    				case 9: {//ConsultarCosteArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int targetVertex = Integer.parseInt(lsplited[2]);
	    					int costeArista = e.consultarCosteArista(vertex, targetVertex);
	    					System.out.println("Coste Arista ("+ vertex + "," +  targetVertex +"): "+ costeArista +"\n");
	    					break;
	    				}
	    				
	    				case 10: {//modificarCosteArista
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int targetVertex = Integer.parseInt(lsplited[2]);
	    					int nuevoCoste = Integer.parseInt(lsplited[3]);
	    					e.modificarCosteArista(vertex, targetVertex, nuevoCoste);
	    					break;
	    				}
	    				
	    				case 11: {
	    					int num = e.consultarNumeroVertices();
	    					System.out.println("Numero de vertices:" + num + "\n");
	    					break;
	    					
	    				}
	    				
	    				
	    				case 12: {
	    					int vertex = Integer.parseInt(lsplited[1]);
	    					int num = e.consultarNumAristasVertice(vertex);
	    					System.out.println("Aristas desde vertice "+ vertex+ ": " + num + "\n");
	    				
	    					break;
	    				}	
	    				
	    				case 13: {
	    					int numVertex = Integer.parseInt(lsplited[1]);
	    					ArrayList <Arista> l =e.consultarAdyacentes(numVertex);
	    					for (int i = 0; i < l.size(); ++i){
	    						System.out.println(l.get(i).consultarVerticeDestino()  + " ");
	    					}
	    					System.out.println("\n");
	    					break;
	    					
	    				}	
	 					case 14: {//modificarSink
	    					int sink = Integer.parseInt(lsplited[1]);
	    					e.modificarSink(sink);
	    					break;
	    				}
	    				
	    				case 15: {//modificarSource
	    					int source = Integer.parseInt(lsplited[1]);
	    					e.modificarSource(source);
	    					break;
	    				}
	    				case 16: {//modificarNumAg
	    					int numAg = Integer.parseInt(lsplited[1]);
	    					e.modificarNumeroAgentes(numAg);
	    					break;
	    				}
	    				case 17: {//ConsultarSink
	    					System.out.println(e.consultarSink()+"\n");
	    					break;
	    				}
	    				
	    				case 18:{ //ConsultarSource
	    					System.out.println(e.consultarSource()+"\n");

	    					break;
	    				}
	    				
	    				case 19: {//consultarNumAg
	    					System.out.println(e.consultarNumeroAgentes()+"\n");

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
	    		} catch(Exception o) {
	    	        System.out.println("Error: " + o.getMessage() + "\n");
	    	}
    	}

} //Cierra funcion
} //Cierra clase