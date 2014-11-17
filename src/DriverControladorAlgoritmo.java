import java.util.*;

public class Main {
	
	private static Scanner sc;
	
	private static void menu() {
        System.out.println("main"
                + "\n 0.Salir"
                + "\n 1.Crear Controlador mapa (int x, int y, string continente"
                + "\n 2.Crear Controlador Agentes"
                + "\n 3.Crear Controlador MediosTransporte"
                + "\n 4.Crear Controlador Algoritmos( string s, string t)"
                + "\n 5.Crear Controlador Itinerarios"
        		+"\n");
    }
	
	public static void main(String [] args) throws Exception {
		ControladorMapa cMapa;
		ControladorAgentes cAgentes;
		ControladorMedioTransporte cMedio;
		ControladorAlgoritmo cAlgo;
		ControladorItinerarios cIt;
		menu();
		sc = new Scanner(System.in);
        String[] lsplited;
        while (sc.hasNextLine()) {
        	try {
        		lsplited = sc.nextLine().split(" ");
    	        switch(Integer.parseInt(lsplited[0])) {
    	        	case 1: {
    	        		int x = Integer.parseInt(lsplited[1]);
    	        		int y = Integer.parseInt(lsplited[2]);
    	        		//llegir continent
    	        		cMapa = new ControladorMapa (x,y,continente);
    	     
    	            	break;
    	        	}
    	        	case 2: {
    	        		cAgentes = new ControladorAgentes();
    	            	break;
    	        	}
    	        	case 3: {
    	        		cMedio = new ControladorMedioTransporte();
    	        		break;
    	        	}
    	        	case 4: {
    	        		String s = lsplited[1];
    	        		String t = lsplited[2];
    	        		cAlgo = new ControladorAlgoritmo(cAgentes, cMapa, cMedio, s,t);
    	        	}
    	        	case 5: {
    	        		cIt = new ControladorItinerarios();
    	        		break;
    	        	}
    	        	case 6: {
    	        		//leer ciudades
    	        		int n = Integer.parseInt(lsplited[1]); //Numero de ciudades a leer
    	        		for (int i = 0; i < n; i++) {
    	        			lsplited = sc.nextLine().split(" ");
    	        			String nombre = lsplited[1];
    		            	int coordX = Integer.parseInt(lsplited[2]);
    		                int coordY = Integer.parseInt(lsplited[3]);
    		                Coordenadas coord = new Coordenadas(coordX, coordY);
    		                Ciudad c = new Ciudad(nombre, coord);
    	        			cMapa.agregarCiudad(nombre, coordX, coordY);
    	        		}
    	        		break;
    	        		
    	        	}
    	        	case 7: {
    	        		//leer caminos
    	        		int n = Integer.parseInt(lsplited[1]); //Numero de caminos a leer
    	        		for (int i = 0; i < n; i++) {
    	        			lsplited = sc.nextLine().split(" ");
    	        			String nombre = lsplited[1];
    	        			String cOrig = lsplited[1];
    		            	String cDest = lsplited[2];
    		            	String medio = lsplited[3];
    		            	int cap = Integer.parseInt(lsplited[4]);
    		            	Camino c = new Camino(cOrig, cDest, cap, medio);
    		            	//cMapa.agregarCamino(cDest,cap, medio,medioT);
    	        		}
    		            break;
    	        		
    	        	}
    	        	case 0: {
    	                System.exit(0);
    	            }
    	            default: {
    	                System.out.println("Entrada de datos no valida, pruebe con un valor entre 1 y 6 o 0 para salir\n");
    	                break;
    	            }    
    	        }
        	}
    		catch(Exception e) {
	    		System.out.println("Error: " + e.getMessage() + "\n");
        	}
        }
	}*/

}
