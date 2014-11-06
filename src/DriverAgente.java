import java.util.*;
public class DriverAgente{
private static void menu() {
	        System.out.println("Driver clase ControladorAgente"
	                + "\n 0.Salir"
	                + "\n 1.new Agente(String nombre, String ciudadInicial, String ciudadObjetivo)"
	                + "\n 2.getNombre()"
	                + "\n 3.setNombre(String nombre)"
	                + "\n 4.getCiudadInicial()"
	                + "\n 5.setCiudadInicial(String ciudadInicial)"
	                + "\n 6.getCiudadObjetivo()"
	                + "\n 7.setCiudadObjetivo (String ciudadObjetivo)"
	        		+"\n");
}

public static void main(String [] args) throws Exception {
			Agente a = null;
	    	menu();
	    	Scanner sc = new Scanner(System.in);
	    	String[] lsplited;
	    	
	    	while(sc.hasNextLine()){ 
	    		try{
	    			lsplited = sc.nextLine().split(" ");
	    			switch(Integer.parseInt(lsplited[0])){
	    				case 1: {//INIT
	    					String nombre = lsplited[1];
	    					String ciudadInicial = lsplited[2];
	    					String ciudadObjetivo = lsplited[3];
	    					a = new Agente(nombre, ciudadInicial, ciudadObjetivo);
	    					//System.out.println("Ya se inicializa por defecto");
	    					break;
	    				}
	    				
	    				case 2: {//getNombre
	    					String n = a.getNombre();
	    					System.out.println("Nombre agente:" + n + "\n");
	    					break;
	    				}
	    				
	    				case 3: {//setNombre
	    					String nombre = lsplited[1];
	    					a.setNombre(nombre);
	    					System.out.println("Nuevo nombre agente:" + a.getNombre() + "\n");
	    					break;
	    				}
	    				
	    				case 4: {//getCiudadInicial
	    					String n = a.getCiudadInicial();
	    					System.out.println("Nombre ciudadInicial:" + n + "\n");
	    					break;
	    				}
	    				
	    				case 5: {//setciudadInicial
	    					String ciudadInicial = lsplited[1];
	    					a.setCiudadInicial(ciudadInicial);
	    					System.out.println("Nueva ciudadInicial:" + a.getCiudadInicial() + "\n");
	    					break;
	    				}
	    				
	    				case 6: {//getCiudadObjetivo
	    					String n = a.getCiudadObjetivo();
	    					System.out.println("Nombre ciudadObjetivo:" + n + "\n");
	    					break;
	    				}
	    				
	    				case 7: {//setciudadObjetivo
	    					String ciudadObjetivo = lsplited[1];
	    					a.setCiudadObjetivo(ciudadObjetivo);
	    					System.out.println("Nueva ciudadObjetivo:" + a.getCiudadObjetivo() + "\n");
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
	    		} catch(Exception e) {
	    	        System.out.println("Error: " + e.getMessage() + "\n");
	    	}
    	}

} //Cierra funcion
} //Cierra clase