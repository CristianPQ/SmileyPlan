
import java.util.*;

public class DriverEntrada {

private static void menu() {
	        System.out.println("Driver clase Entrada"
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
			////////////CREO UN GRAFO DE EJEMPLO/////////////////
			GrafoAntiguo g = new GrafoAntiguo(6);
			g.anadirArista(0, 1, 0, 10, 0);
			g.anadirArista(1, 2, 0, 10, 0);
			g.anadirArista(2, 3, 0, 10, 0);
			g.anadirArista(3, 4, 0, 10, 0);
			g.anadirArista(4, 5, 0, 10, 0);
			g.anadirArista(5, 3, 0, 10, 0);
			//////////////////////////////////////
	    	menu();
	    	Scanner sc = new Scanner(System.in);
	    	String[] lsplited;
	    	
	    	while(sc.hasNextLine()){ 
	    		try{
	    			lsplited = sc.nextLine().split(" ");
	    			switch(Integer.parseInt(lsplited[0])){
	    				case 1: {
	  
	    					int s = Integer.parseInt(lsplited[1]);
	    					int t = Integer.parseInt(lsplited[2]);
	    					int numAg = Integer.parseInt(lsplited[3]);
	    					e = new Entrada(g, s, t, numAg);
	    					break;
	    				}
	    				case 2:{//ConsultarGrafo
	    					GrafoAntiguo G = e.consultarGrafo();
	    					ArrayList<Arista> r = new ArrayList<Arista>();
	    					for (int i = 0; i < G.consultarNumVertices();++i){
	    						System.out.println("Adyacencias vertice "+ i +":");
	    						r = G.consultarAdyacentes(i);
	    							for (int j = 0; j < r.size(); ++j){
	    								System.out.println(r.get(j).consultarVerticeDestino() + "\n");
	    							}
	    						}

	    					break;
	    				}

	    				case 4: {//ConsultarSink
	    					System.out.println(e.consultarSink()+"\n");
	    					break;
	    				}
	    				
	    				case 3:{ //ConsultarSource
	    					System.out.println(e.consultarSource()+"\n");

	    					break;
	    				}
	    				
	    				case 5: {//consultarNumAg
	    					System.out.println(e.consultarNumeroAgentes()+"\n");

	    					break;
	    				}
	    				  				
	    				case 6: {//modificarGrafo
	    					GrafoAntiguo g1 = g;
	    					g1.anadirArista(1, 4, 0, 9, 0);
	    					e.modificarGrafo(g1);
	    					break;
	    				}
	    				
	    				case 8: {//modificarSink
	    					int sink = Integer.parseInt(lsplited[1]);
	    					e.modificarSink(sink);
	    					break;
	    				}
	    				
	    				case 7: {//modificarSource
	    					int source = Integer.parseInt(lsplited[1]);
	    					e.modificarSource(source);
	    					break;
	    				}
	    				
	    				case 9: {//modificarNumAg
	    					int numAg = Integer.parseInt(lsplited[1]);
	    					e.modificarNumeroAgentes(numAg);
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
	    		} catch(Exception ef) {
	    	        System.out.println("Error: " + ef.getMessage() + "\n");
	    	}
    	}

} //Cierra funcion
} //Cierra clase