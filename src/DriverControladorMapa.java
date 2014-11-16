import java.util.Scanner;


public class DriverControladorMapa {
	private static Scanner sc;

	private static void menu() {
        System.out.println("Driver clase Mapa"
                + "\n 0.Salir"
                + "\n 1.new Mapa(int anchuraX, int alturaY, Coordenadas[] continente)"
                + "\n ##########CIUDADES##########"
                + "\n 2.agregarCiudad(String nombre, int x, int y)"
                + "\n 3.eliminarCiudad(String c)"
                + "\n 4.consultarCiudadToString(String nombre): String"
                + "\n 5.modificarAtributosCiudad(String nombre, int x, int y)"
                + "\n 6.listarCiudadesToString(): String"
                + "\n ##########CAMINOS##########"
                + "\n 7.agregarCamino(String cOrig, String cDest, String medio, int cap)"
                + "\n 8.consultarCaminosToString(String cOrig, String cDest): String"
                + "\n 9.eliminarCamino(String cOrig, String cDest, String medio, int cap)"
        		+ "\n 10.modificarAtributosCamino(String cOrig, String cDest, String medio, int cap)"
        		+ "\n 11.consultarCaminosDestinoToString(String cOrig): String"
        		+ "\n 12.consultarMapaToString(): String"   
        		+ "\n 13.consultarCaminoToString(String cOrig, String cDest, String medio): String"
        		+ "\n 14.consultarTodosCaminosToString(): String"
        		+"\n");
    }
	
    public static void main(String [] args) throws Exception {
    	Mapa m = null;
        menu();
        sc = new Scanner(System.in);
        String[] lsplited;
        while (sc.hasNextLine()) {
	    	try {
		        lsplited = sc.nextLine().split(" ");
		        switch(Integer.parseInt(lsplited[0])) {
		            case 1: {
		            	int anchuraX = Integer.parseInt(lsplited[1]);
		                int alturaY = Integer.parseInt(lsplited[2]);
		                /*String coord = new String();
		                for(int i = 3;lsplited[i] != "$" && lsplited[i+i] != "$";i += 2) {
		                	
		                		System.out.println("lsplited size: " + lsplited.length + "\n");
		                		System.out.println("Coord X " + i + ": " + lsplited[i] + "\n"
		                			+ "Coord Y " + (i+1) + ": " + lsplited[i+1] + "\n");
		                		
		                	coord.concat(lsplited[i] + " " + lsplited[i+1] + " ");
		                	
		                		System.out.println("despues del split" + "\n");
		                	
		                }
		                coord.concat("$ $");*/
		                	//System.out.println("Antes de inicializar mapa" + "\n");
		                m = new Mapa(anchuraX, alturaY, null);
		                	//System.out.println("Despues de inicializar mapa" + "\n");
		                break;
		            }
		            case 2: {
		            	String nombre = lsplited[1];
		            	int coordX = Integer.parseInt(lsplited[2]);
		                int coordY = Integer.parseInt(lsplited[3]);
		            	m.agregarCiudad(nombre, coordX, coordY);
		                break;
		            }
		            case 3: {
		                String nombre = lsplited[1];
		                m.eliminarCiudad(nombre);
		                break;
		            }
	
		            case 4:{
		            	String nombre = lsplited[1];
		            	String ciudad = m.consultarCiudadToString(nombre);
		            	System.out.print(ciudad +"\n");
		                break;
		            }
		            case 5:{
		            	String nombre = lsplited[1];
		            	int coordX = Integer.parseInt(lsplited[2]);
		                int coordY = Integer.parseInt(lsplited[3]);
		            	m.modificarAtributosCiudad(nombre, coordX, coordY);
		                break;
		            }
		            case 6: {
		            	String li = m.listarCiudadesToString();
		            	System.out.print(li +"\n");
		                break;
		            }
		            case 7: {
		            	String cOrig = lsplited[1];
		            	String cDest = lsplited[2];
		            	String medio = lsplited[3];
		            	int cap = Integer.parseInt(lsplited[4]);
		            	m.agregarCamino(cOrig, cDest, medio, cap);
		                break;
		            }
		            case 8: {
		            	String cOrig = lsplited[1];
		            	String cDest = lsplited[2];
		            	String cons = m.consultarCaminosToString(cOrig, cDest);
		            	System.out.println(cons + "\n");
		                break;
		            }
		            case 9: {
		            	String cOrig = lsplited[1];
		            	String cDest = lsplited[2];
		            	String medio = lsplited[3];
		            	m.eliminarCamino(cOrig, cDest, medio);
		                break;
		            }
		            case 10: {
		            	String cOrig = lsplited[1];
		            	String cDest = lsplited[2];
		            	String medio = lsplited[3];
		            	int cap = Integer.parseInt(lsplited[4]);
		            	m.modificarAtributosCamino(cOrig, cDest, medio, cap);
		                break;
		            }
		            case 11: {
		            	String cOrig = lsplited[1];
		            	String ciu = m.consultarCaminosDestinoToString(cOrig);
		            	System.out.println(ciu + "\n");
		                break;
		            }
		            case 12: {
		            	String map = m.consultarMapaToString();
		            	System.out.println(map + "\n");
		                break;
		            }
		            case 13: {
		            	String cOrig = lsplited[1];
		            	String cDest = lsplited[2];
		            	String medio = lsplited[3];
		            	String cam = m.consultarCaminoToString(cOrig, cDest, medio);
		            	System.out.println(cam + "\n");
		            	break;
		            }
		            case 14: {
		            	String cam = m.consultarTodosCaminosToString();
		            	System.out.println(cam + "\n");
		            	break;
		            }
		            case 0: {
		                System.exit(0);
		            }
		            default: {
		                System.out.println("Entrada de datos no valida, pruebe con un valor entre 1 y 17 o 0 para salir\n");
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
