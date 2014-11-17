import java.util.*;

public class DriverControladorAlgoritmo {
	
	private static Scanner in;

	private static void menu() {
        System.out.println("main"
                + "\n 0.Salir"
                + "\n 1.Inicializar ControladorMedioTransporte()"
                + "\n 2.Inicializar ControladorMapa(int anchuraX, int alturaY, String continente)"
                + "\n 3.Inicializar ControladorAgentes()"
                + "\n 4.Crear Controlador Algoritmos( string s, string t)"
                + "\n 5.ejecutar(int i)"
                + "\n 6.Consultar ControladorItinerarios"
                + "\n 7.Guardar sequencia algoritmo pushRelabel"
                + "\n 8.Consultar tiempo de ejecucion"
        		+"\n");
    }
	
	public static void main(String [] args) throws Exception {
		in = new Scanner(System.in);
		ControladorMapa m = null;
		ControladorAgentes cAge = null;
		ControladorMedioTransporte cMed = null;
		ControladorAlgoritmo cAlg = null;
		ControladorItinerarios cIt;
		menu();
        String[] lsplited;
        while (in.hasNextLine()) {
        	try {
        		String linea = in.nextLine();
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
                        System.out.println("Fin agregarCoches");
                        System.out.println("numero de trenes a agregar: int");
                        linea = in.nextLine();
                        lsplited = linea.split(" ");
                        n = Integer.parseInt(lsplited[0]);
                        for (int j = 0; j < n; j++) {
                        	System.out.println("agregarTren(String Nombre, int Coste");
                            linea = in.nextLine();
                            lsplited = linea.split(" ");
                            cMed.agregarTren(lsplited[0], Integer.parseInt(lsplited[1]));
                        }
                        System.out.println("Fin agregarTrenes");
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
                        n = Integer.parseInt(lsplited[0]);
                        for (int i = 0; i < n; i++) {
                        	System.out.println("agregarCamino(cOrig, cDest, medio, cap, contMT)");
                            linea = in.nextLine();
                            lsplited = linea.split(" ");
                            String cOrig = lsplited[0];
                            String cDest = lsplited[1];
                            String medio = lsplited[3];
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
                            cAge.anadirAgente(nombre, cOrig, cObj, m);
                        }
                        System.out.println("FIN agregarAgentes");
    	        		break;
    	        	}
    	        	case 4: {
    	        		System.out.println("CiudadOrigen y CiudadDestino a tratar");
    	        		linea = in.nextLine();
                        lsplited = linea.split(" ");
    	        		String s = lsplited[0];
    	        		String t = lsplited[1];
    	        		cAlg = new ControladorAlgoritmo(cAge, m, cMed, s,t);
    	        		break;
    	        	}
    	        	case 5: {
    	        		System.out.println("\n 1.FordFulkerson()"
    	        				+ "\n 2. PushRelabel"
    	        				+ "\n 3. Dinic");
    	        		linea = in.nextLine();
                        lsplited = linea.split(" ");
                        int i = Integer.parseInt(lsplited[0]);
    	        		cAlg.ejecutar(i);
    	        		break;
    	        	}
    	        	case 6: {
    	        		cAlg.asignarItinerarioAAgente();
    	        		cIt = cAlg.consultarItinerarios();
    	        		String its = cIt.escribirItinerarios();
    	        		System.out.println(its + "\n");
    	        		break;
    	        	}
    	        	case 7: {
    	        		String path = "/Users/olgacarbo/Desktop/SmileyPlan/src/";
    	        		String filename = "prova alg"; 
    	        		cAlg.guardarSeq(path, filename);
    	        	}
    	        	case 8: {
    	        		long t = cAlg.consultarTiempo();
    	        		System.out.println(t + "\n");
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
	}

}
