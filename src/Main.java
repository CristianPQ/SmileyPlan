import java.util.*;

public class Main {
	
	private static Scanner sc;
	
	private static void menu() {
        System.out.println("main"
                + "\n 0.Salir"
                + "\n 1.Crear Controlador mapa (int x, int y, string continente"
                + "\n 2.Crear Controlador Agentes"
                + "\n 3.Crear Controlador MediosTransporte"
                + "\n 4.Crear Controlador Algoritmos"
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
    	        		cAlgo = new ControladorAlgoritmo(cAgentes, cMapa, cMedio);
    	        	}
    	        	case 5: {
    	        		nombres = new ArrayList<String>();
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
