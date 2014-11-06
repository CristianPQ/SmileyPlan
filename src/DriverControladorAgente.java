import java.util.*;
public class DriverControladorAgente{
private static void menu() {
	        System.out.println("Driver clase ControladorAgente"
	                + "\n 0.Salir"
	                + "\n 1.new Controlador()"
	                + "\n 2.anadirAgente(String nombre, String ciudadInicial, String ciudadObjetivo)"
	                + "\n 3.eliminarAgente(String nombre)"
	                + "\n 4.modificarNombreAgente(String nombreAntiguo, String nombreNuevo)"
	                + "\n 5.modificarCiudadInicialAgente(String nombre, String ciudadInicial)"
	                + "\n 6.modificarCiudadObjetivoAgente(String nombre, String ciudadObjetivo)"
	                + "\n 7.consultarAgentesCiudadInicial(String ciudadInicial)"
	                + "\n 8.consultarAgentesCiudadObjetivo(String ciudadObjetivo)"
	                + "\n 9.consultarAgentesCiudadInicialObjetivo(String ciudadInicial, String ciudadObjetivo)"
	        		+ "\n 10.getNumeroDeAgentes()" 
	        		+"\n");
}

public static void main(String [] args) throws Exception {
			ControladorAgentes conjAgentes = null;
	    	menu();
	    	Scanner sc = new Scanner(System.in);
	    	String[] lsplited;
	    	
	    	while(sc.hasNextLine()){ 
	    		try{
	    			lsplited = sc.nextLine().split(" ");
	    			switch(Integer.parseInt(lsplited[0])){
	    				case 1: {//INIT
	    					conjAgentes = new ControladorAgentes();
	    					//System.out.println("Ya se inicializa por defecto");
	    					break;
	    				}
	    				
	    				case 2: {//CREAR/ANADIR
	    					String nombre = lsplited[1];
	    					String ciudadInicial = lsplited[2];
	    					String ciudadObjetivo = lsplited[3];	    					
	    					conjAgentes.anadirAgente(nombre, ciudadInicial, ciudadObjetivo);
	    					break;
	    				}
	    				
	    				case 3: {//ELIMINAR
	    					String nombre = lsplited[1];
	    					conjAgentes.eliminarAgente(nombre);
	    					break;
	    				}
	    				
	    				case 4: {//modificarNombre
	    					String nombreAntiguo = lsplited[1];
	    					String nombreNuevo = lsplited[2];
	    					conjAgentes.modificarNombreAgente(nombreAntiguo, nombreNuevo);
	    					break;
	    				}
	    				
	    				case 5: {//modificarCiudadInicial
	    					String nombre = lsplited[1];
	    					String ciudadInicial = lsplited[2];
	    					conjAgentes.modificarCiudadInicialAgente(nombre, ciudadInicial);
	    					break;
	    				}
	    				
	    				case 6: {//modificarCiudadObjetivo
	    					String nombre = lsplited[1];
	    					String ciudadObjetivo = lsplited[2];
	    					conjAgentes.modificarCiudadObjetivoAgente(nombre, ciudadObjetivo);
	    					break;
	    				}
	    				
	    				case 7: {//consultarAgentesCiudadInicial
	    					String ciudadInicial= lsplited[1];
	    					conjAgentes.consultarAgentesCiudadInicial(ciudadInicial);
	    					//faltaria imprimir la consulta
	    					break;					
	    				}
	    				
	    				case 8: {//consultarAgentesCiudadObjetivo
	    					String ciudadObjetivo = lsplited[1];
	    					conjAgentes.consultarAgentesCiudadObjetivo(ciudadObjetivo);
	    					//faltaria imprimir la consulta
	    					break;					
	    				} 
	    				
	    				case 9: {//consultarAgentesCiudadInicialCiudadObjetivo
	    					String ciudadInicial = lsplited[1];
	    					String ciudadObjetivo = lsplited[2];
	    					conjAgentes.consultarAgentesCiudadInicialObjetivo(ciudadInicial, ciudadObjetivo);
	    					//faltaria imprimir la consulta
	    					break;					
	    				}
	    				case 10: {//numeroAgentes
	    					
	    					int numAg = conjAgentes.getNumeroDeAgentes();
	    					System.out.println("Numero de agentes:" + numAg + "\n");
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