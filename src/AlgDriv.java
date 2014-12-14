
import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.type.NullType;

public class AlgDriv {

	class AlgGraph {
		 Grafo<NullType, Arista> g;
	///////////////////////////////////////////////
	///////////////FUNCIONES GRAFO ARISTA///////////
	////////////////////////////////////////////////
	
		AlgGraph(Grafo<NullType, Arista> g1) {
		g = g1;
		}
	//ArrayList<Arista> consultarAdyacentes(int vertex) -> g.consultarAdyacentesSalida(int vertex)
		boolean existeAdyacente(int vertex, int targetVertex){
		ArrayList<Arista> a = g.consultarAristasSalida(vertex);
		for (int i = 0; i < a.size(); ++i)
			if (a.get(i).consultarVerticeDestino() == targetVertex) return true;
		return false;
	}
	
	 void anadirArista (int vertex, int targetVertex,
			int flow, int capacity, int cost){
		Arista a = new Arista(targetVertex, flow, capacity, cost);
		g.agregarElemento(targetVertex, vertex, a);
	}
	
	 void eliminarArista(int vertex, int targetVertex){
		ArrayList<Arista> adj = g.consultarAristasSalida(vertex);
		boolean trobat = false;
		Arista ar = null;
		for(int i = 0; i < adj.size() && !trobat; ++i){	
			if(!adj.get(i).equals(null) && adj.get(i).consultarVerticeDestino() == targetVertex){
			ar = adj.get(i);
			trobat = true;				
			}
		}
		if (trobat) g.eliminarAristaSalida(ar, vertex);					
	}
	
	 int consultarFlujoArista(int vertex, int targetVertex){
		int i;
		ArrayList<Arista> adj = g.consultarAristasSalida(vertex);
		for (i = 0; i < adj.size(); ++i){
			if( !adj.get(i).equals(null) &&
					adj.get(i).consultarVerticeDestino() == targetVertex){
						return adj.get(i).consultarFlujo();
			}			
		}
		return -1;
	}
	
	 void modificarFlujoArista(int vertex, int targetVertex, int nuevoFlujo){
		int i;
		ArrayList<Arista> adj = g.consultarAristasSalida(vertex);
		Arista ar = null;
		for (i = 0; i < adj.size(); ++i){
			if( !adj.get(i).equals(null) &&
					adj.get(i).consultarVerticeDestino() == targetVertex){
						ar = adj.get(i);
				}			
			}
		
		g.eliminarAristaSalida(ar, vertex);
		ar.modificarFlujo(nuevoFlujo);		
		g.agregarArista(ar, targetVertex, vertex);
	}
	
	 int consultarCapacidadArista(int vertex, int targetVertex){
		int i;
		ArrayList<Arista> adj = g.consultarAristasSalida(vertex);
		for (i = 0; i < adj.size(); ++i){
			if( !adj.get(i).equals(null) &&
					adj.get(i).consultarVerticeDestino() == targetVertex){
						return adj.get(i).consultarCapacidad();
			}			
		}
		return -1;
	}
	
	public void modificarCapacidadArista(int vertex, int targetVertex, int nuevaCapacidad){
		int i;
		ArrayList<Arista> adj = g.consultarAristasSalida(vertex);
		Arista ar = null;
		for (i = 0; i < adj.size(); ++i){
			if( !adj.get(i).equals(null) &&
					adj.get(i).consultarVerticeDestino() == targetVertex){
						ar = adj.get(i);
				}			
			}
		
		g.eliminarAristaSalida(ar, vertex);
		ar.modificarCapacidad(nuevaCapacidad);		
		g.agregarArista(ar, targetVertex, vertex);
	}

	 int consultarCosteArista(int vertex, int targetVertex){
		int i;
		ArrayList<Arista> adj = g.consultarAristasSalida(vertex);
		for (i = 0; i < adj.size(); ++i){
			if( !adj.get(i).equals(null) &&
					adj.get(i).consultarVerticeDestino() == targetVertex){
						return adj.get(i).consultarCoste();
			}			
		}
		return -1;
	}
	
	 void modificarCosteArista(int vertex, int targetVertex, int nuevaCapacidad){
		int i;
		ArrayList<Arista> adj = g.consultarAristasSalida(vertex);
		Arista ar = null;
		for (i = 0; i < adj.size(); ++i){
			if( !adj.get(i).equals(null) &&
					adj.get(i).consultarVerticeDestino() == targetVertex){
						ar = adj.get(i);
				}			
			}
		
		g.eliminarAristaSalida(ar, vertex);
		ar.modificarCoste(nuevaCapacidad);		
		g.agregarArista(ar, targetVertex, vertex);
	}	
	
	//Yo haria una funcion que devolviera el NUM DE VERTICES
	//o sea almacenaría el numero que le pasas por la constructora
	//y lo devolveria, se puede hacer en mismo grafo easy
	
	
	 int consultarNumAristasVertice(int vertex){
		return g.consultarAristasSalida(vertex).size();
	}
	
	
	
}



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
	    					Grafo<NullType,Arista> g1 = new Grafo<NullType, Arista> (numVertex);
	    					g.g = g1;
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
