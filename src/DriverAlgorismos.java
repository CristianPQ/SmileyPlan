
import java.util.*;

import javax.lang.model.type.NullType;
/*
 * @author Daniel Villanueva 
 */

public class DriverAlgorismos {

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
	                + "\n 14. ejecutar PushRelabel (int s, int t, int numAgentes) --> itinerarios disponibles"
	                + "\n 15. ejecutar FordFulkerson (int s, int t, int numAgentes) --> itinerarios disponibles"
	                + "\n 16. ejecutar Dinic (int s, int t, int numAgentes) --> itinerarios disponibles"
	                +"\n");
}

public static void main(String [] args) throws Exception {
			//GrafoAntiguo g = null;
	    	menu();
	    	Scanner sc = new Scanner(System.in);
	    	String[] lsplited;
	    	PushRelabel a = new PushRelabel();
	    	FordFulkerson f = new FordFulkerson();
	    	Dinic d = new Dinic();
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
	    				case 14: {//
	    					int s = Integer.parseInt(lsplited[1]);
	    					int t = Integer.parseInt(lsplited[2]);
	    					int num = Integer.parseInt(lsplited[3]);
	    					int flow = 0;
	    					e.modificarNumeroAgentes(num);
	    					e.modificarSink(t);
	    					e.modificarSource(s);
	    					Solucion sol;
	    					sol = a.ejecutar(e);
	    					if (sol.consultarTieneSolucion() == false)    System.out.println("No tiene solucion");
	    					else {
	    						System.out.println("El max flow es " + sol.consultarNumItinerarios()); 
	    						System.out.println("Los itinerarios disponibles son: ");
	    						for ( int i = 0; i < sol.obtenNumeroItinerarios(); ++i){
	    							for ( int j = 0; j < sol.obtenNumCiudades(i);++j){
	    								System.out.print(sol.obtenVertice(i, j) + " ");
	    							}
	    							System.out.println();
	    						}
	    						System.out.println("el tiempo: "+ sol.consultarTiempo() + "ms");
	    					}
	    				
	    					break;
	    				}
	    				case 15: {//
	    					int s = Integer.parseInt(lsplited[1]);
	    					int t = Integer.parseInt(lsplited[2]);
	    					int num = Integer.parseInt(lsplited[3]);
	    					int flow = 0;
	    					e.modificarNumeroAgentes(num);
	    					e.modificarSink(t);
	    					e.modificarSource(s);
	    					Solucion sol;
	    					sol = f.ejecutar(e);
	    					if (sol.consultarTieneSolucion() == false)    System.out.println("No tiene solucion");
	    					else {
	    						System.out.println("El max flow es " + sol.consultarNumItinerarios());
	    						System.out.println("Los itinerarios disponibles son: ");
	    						for ( int i = 0; i < sol.obtenNumeroItinerarios(); ++i){
	    							for ( int j = 0; j < sol.obtenNumCiudades(i);++j){
	    								System.out.print(sol.obtenVertice(i, j) + " ");
	    							}
	    							System.out.println();
	    						}
	    						System.out.println("el tiempo: " + sol.consultarTiempo() + "ms");
	    					}
	    				
	    					break;
	    				}
	    				case 16: {//
	    					int s = Integer.parseInt(lsplited[1]);
	    					int t = Integer.parseInt(lsplited[2]);
	    					int num = Integer.parseInt(lsplited[3]);
	    					int flow = 0;
	    					e.modificarNumeroAgentes(num);
	    					e.modificarSink(t);
	    					e.modificarSource(s);
	    					Solucion sol;
	    					sol = d.ejecutar(e);
	    					if (sol.consultarTieneSolucion() == false)    System.out.println("No tiene solucion");
	    					else {
	    						System.out.println("El max flow es " + sol.consultarNumItinerarios());
	    						System.out.println("Los itinerarios disponibles son: ");
	    						for ( int i = 0; i < sol.obtenNumeroItinerarios(); ++i){
	    							for ( int j = 0; j < sol.obtenNumCiudades(i);++j){
	    								System.out.print(sol.obtenVertice(i, j) + " ");
	    							}
	    							System.out.println();
	    						}
	    						System.out.println("el tiempo: " + sol.consultarTiempo() + "ms");
	    					}
	    				
	    					break;
	    				}
	    				/*case 16:{
	    					String path = "C:\\Users\\joan\\Desktop\\uni\\2naEntrega\\SmileyPlan\\src"; 
	    					String file = "prova"; 
	    					a.Guardar(path,file); 
	    				}	*/
	    			/*	case 17: {//
	    					int s = Integer.parseInt(lsplited[1]);
	    					int t = Integer.parseInt(lsplited[2]);
	    					int flow = 0;
	    					Solucion sol = new Solucion(19);
	    					d.ejecutar(g, s, t, flow);
	    					d.crearItinerarios(sol, g, 0, 18, 19, 0, 5, 0);
	    					System.out.println("final ejecucion el max flow es  " + flow );
	    					for ( int i = 0; i < sol.obtenNumeroItinerarios(); ++i){
	    						for ( int j = 0; j < sol.obtenNumCiudades(i);++j){
	    	    					//System.out.println(sol.obtenVertice(i, j) + " ");
	    						}
	    						System.out.println();
	    					}
	    					break;
	    				} */
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
		

