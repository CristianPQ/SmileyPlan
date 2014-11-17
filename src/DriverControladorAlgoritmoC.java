import java.util.Scanner;


public class DriverControladorAlgoritmoC {
	private static void menu() {
        System.out.println("Driver clase Itinerario"
                + "\n 0.Salir"
                + "\n 1.ControladorAlgoritmoC(ControladorAgentes ca, ControladorMapa cm, "
			+ "ControladorMedioTransporte mt, String cOrig, String cDest)"
                + "\n 2.ejecutar(i)"
                + "\n 3.asignarItinerarioAAgente()"
                + "\n 4.guardarSeqPR(String path, String filename)"
        		+"\n");
    }
	
    public static void main(String [] args) throws Exception {
    	ControladorAlgoritmoC cAl = null;
    	
    	ControladorMedioTransporte medioT = new ControladorMedioTransporte();
    	medioT.agregarCoche("bmw", 15);
    	medioT.agregarCoche("audi", 7);
    	medioT.agregarCoche("renault", 20);
    	medioT.agregarTren("cercanias", 12);
    	medioT.agregarTren("ave", 36);
    	
    	ControladorMapa ma = new ControladorMapa(10, 10, "2 3 2 4 2 5 3 6 4 6 5 6 6 5 6 4 6 3 5 2 4 2 3");
    	ma.agregarCiudad("bcn", 3, 3);
    	ma.agregarCiudad("bil", 3, 4);
    	ma.agregarCiudad("mad", 3, 5);
    	ma.agregarCiudad("ams", 4, 3);
    	ma.agregarCiudad("lim", 4, 4);
    	ma.agregarCiudad("sev", 4, 5);
    	ma.agregarCiudad("gir", 5, 3);
    	ma.agregarCiudad("tar", 5, 4);
    	ma.agregarCiudad("gal", 5, 5);
    	
    	ControladorAgentes cAgentes = new ControladorAgentes();
    	cAgentes.anadirAgente("joan", "bcn", "gal");
    	cAgentes.anadirAgente("olga", "bcn", "gal");
    	cAgentes.anadirAgente("dani", "bcn", "gal");
    	cAgentes.anadirAgente("cristian", "bcn", "gal");
        
    	menu();
        Scanner sc = new Scanner(System.in);
        String[] lsplited;
        while (sc.hasNextLine()) {
	    	try {
		        lsplited = sc.nextLine().split(" ");
		        switch(Integer.parseInt(lsplited[0])) {
		            case 1: {
		            	
		            	
		                break;
		            }
		           case 2: {
		            	
		                break;
		            }
		           case 3: {
		        	   
		        	   //ca.ejecutarAlgoritmoPushRelabel(g, s, t);
		        	   break;
		           }
		           case 4:{
		        	   
		           }
		            case 0: {
		                System.exit(0);
		            }
		            default: {
		                System.out.println("Entrada de datos no valida, pruebe con un valor entre 1 y 5 o 0 para salir\n");
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
