import java.util.*;

public class Main {
	
	private static Scanner sc;
	
	private static void menu() {
        System.out.println("main"
                + "\n 0.Salir"
                + "\n 1.Inicializar ControladorMedioTransporte()"
                + "\n 2.Inicializar ControladorMapa(int anchuraX, int alturaY, String continente)"
                + "\n 3.Inicializar ControladorAgentes()"
                + "\n 4.Crear Controlador Algoritmos( string s, string t)"
                + "\n 5.Crear Controlador Itinerarios"
        		+"\n");
    }
	
	public static void main(String [] args) throws Exception {
		Scanner in = new Scanner(System.in);
		ControladorMapa m = null;
		ControladorAgentes cAge = null;
		ControladorMedioTransporte cMed = null;
		ControladorAlgoritmo cAlg = null;
		ControladorItinerarios cIt;
		menu();
        while (in.hasNext()) {
        	try {
        		String linea = in.nextLine();
                String[] lsplited;
                lsplited = linea.split(" ");
    	        switch(Integer.parseInt(lsplited[0])) {
    	        	case 1: {
                        cMed = new ControladorMedioTransporte();
                        System.out.println("Numero coches a agregar");
                        linea = in.nextLine();
                        lsplited = linea.split(" ");
                        int n = Integer.parseInt(lsplited[0]);
                        for (int i = 0; i < n; i++) {
                        	System.out.println("agregarCoche(String Nombre, int Coste");
                            linea = in.nextLine();
                            lsplited = linea.split(" ");
                            cMed.agregarCoche(lsplited[0], Integer.parseInt(lsplited[1]));
                        }
                        System.out.println("numero de trenes a agregar: int");
                        linea = in.nextLine();
                        lsplited = linea.split(" ");
                        n = Integer.parseInt(lsplited[1]);
                        for (int i = 0; i < n; i++) {
                        	System.out.println("agregarTren(String Nombre, int Coste");
                            linea = in.nextLine();
                            lsplited = linea.split(" ");
                            cMed.agregarTren(lsplited[0], Integer.parseInt(lsplited[1]));
                        }
                        System.out.println("FIN de agregarMediosTransporte");
                        break;
    	        	}
    	        	case 2: {
    	        		int x = Integer.parseInt(lsplited[1]);
    	        		int y = Integer.parseInt(lsplited[2]);
    	        		String cont = new String();
    	        		for(int i = 3;i < lsplited.length;i += 2) {
    	        			cont = cont + lsplited[i] + " " + lsplited[i+1] + " ";
    	        		}
                        m = new ControladorMapa(x, y , cont);
                        System.out.println("Numero ciudades a agregar");
                        linea = in.nextLine();
                        lsplited = linea.split(" ");
                        int n = Integer.parseInt(lsplited[0]);
                        for (int i = 0; i < n; i++) {
                        	System.out.println("agregarCiudad(String Nombre, int x, int y");
                            linea = in.nextLine();
                            lsplited = linea.split(" ");
                            String nombre = lsplited[0];
                            x = Integer.parseInt(lsplited[1]);
        	        		y = Integer.parseInt(lsplited[2]);
                            m.agregarCiudad(nombre, x, y);
                        }
                        System.out.println("Ciudades agregadas");
                        System.out.println("numero de caminos");
                        linea = in.nextLine();
                        lsplited = linea.split(" ");
                        n = Integer.parseInt(lsplited[1]);
                        for (int i = 0; i < n; i++) {
                        	System.out.println("agregarCamino(cOrig, cDest, medio, cap, contMT)");
                        	linea = in.nextLine();
                            lsplited = linea.split(" ");
                            linea = in.nextLine();
                            lsplited = linea.split(" ");
                            String cOrig = lsplited[0];
                            String cDest = lsplited[1];
                            String medio = lsplited[2];
                            int cap = Integer.parseInt(lsplited[2]);
                            m.agregarCamino(cOrig, cDest, medio, cap, cMed);
                        }
                        System.out.println("Caminos agregadas");
                        System.out.println("FIN agregarCiudad y agregarCaminos");
                        break;
    	        	}
    	        	case 3: {
    	        		cAge = new ControladorAgentes();
    	        		System.out.println("Numero Agentes a agregar");
                        linea = in.nextLine();
                        lsplited = linea.split(" ");
                        int n = Integer.parseInt(lsplited[0]);
                        for (int i = 0; i < n; i++) {
                        	System.out.println("agregarAgente(String nombew, String cOrig, String cObj");
                            linea = in.nextLine();
                            lsplited = linea.split(" ");
                            String nombre = lsplited[0];
                            String cOrig = lsplited[1];
                            String cObj = lsplited[2];
                            cAge.anadirAgente(nombre, cOrig, cObj);
                        }
                        System.out.println("FIN agregarAgentes");
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
