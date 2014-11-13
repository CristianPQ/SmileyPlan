/*
 * @author Daniel Villanueva 
 */

import java.util.*;


public class DriverControladorAgente{
private static void menu() {
	        System.out.println("Driver clase ControladorAgente"
	                + "\n 0.Salir"
	                + "\n 1.new Controlador()"
	                + "\n 2.anadirAgente(String nombre, String ciudadInicial, String ciudadObjetivo)"
	                + "\n 3.eliminarAgente(String nombre)"
	                + "\n 4.existeAgente(String nombre)"
	                + "\n 5.consultarCiudadInicialAgente(String nombre)"
	                + "\n 6.consultarCiudadObjetivo(String nombre)"
	        		+ "\n 7.modificarNombreAgente(String nombreAntiguo, String nombreNuevo)" 
	                + "\n 8.modificarCiudadInicialAgente(String nombre, String ciudadInicial)"
	        		+ "\n 9.modificarCiudadObjetivoAgente(String nombre, String ciudadObjetivo)" 
	                + "\n 10.getNumeroDeAgentes()"
	        		+ "\n 11.eliminarTodo()"
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
	    					System.out.println("Conjunto de agentes inicializado");
	    					break;
	    				}
	    				
	    				case 2: {//ANADIR
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
	    				case 4: {//EXISTE?
	    					String nombre = lsplited[1];
	    					boolean existe = conjAgentes.existeAgente(nombre);
	    					if (existe) System.out.println("El agente "+ nombre+" existe");
	    					else System.out.println("El agente no existe");
	    					break;
	    				}	    			
	    				
	    				case 5: {//consultarCiudadInicial
	    					String nombre = lsplited[1];
	    					String ciudadInicial = conjAgentes.consultarCiudadInicialAgente(nombre);
	    					System.out.println("El agente "+ nombre+" tiene "+ ciudadInicial+ " como ciudadInicial");
	    					break;
	    				}	    				
	    				case 6: {//consultarCiudadObjetivo
	    					String nombre = lsplited[1];
	    					String ciudadObjetivo = conjAgentes.consultarCiudadObjetivoAgente(nombre);
	    					System.out.println("El agente "+ nombre+" tiene "+ ciudadObjetivo+ " como ciudadObjetivo");
	    					break;
	    				}
	    				
	    				case 7: {//modificarNombre
	    					String nombreAntiguo = lsplited[1];
	    					String nombreNuevo = lsplited[2];
	    					conjAgentes.modificarNombreAgente(nombreAntiguo, nombreNuevo);
	    					break;
	    				}

	    				case 8: {//modificarCiudadInicial
	    					String nombre = lsplited[1];
	    					String ciudadInicial = lsplited[2];
	    					conjAgentes.modificarCiudadInicialAgente(nombre, ciudadInicial);
	    					break;
	    				}
	    				
	    				case 9: {//modificarCiudadObjetivo
	    					String nombre = lsplited[1];
	    					String ciudadObjetivo = lsplited[2];
	    					conjAgentes.modificarCiudadObjetivoAgente(nombre, ciudadObjetivo);
	    					break;
	    				}

	    				case 10: {//numeroAgentes
	    					
	    					int numAg = conjAgentes.getNumeroDeAgentes();
	    					System.out.println("Numero de agentes:" + numAg + "\n");
	    					break;
	    				}
	    				
	    				case 11:{//eliminarTodo
	    					conjAgentes.eliminarTodo();
	    					break;
	    				}
	    				
	    				case 12:{
	    					ArrayList<String> aS = conjAgentes.getNombresAgentes();
			            	Iterator<String> it = aS.iterator();
			            	while(it.hasNext()) {
			            		System.out.println(it.next() + "\n");
			            	}
			                break;
	    				}
	    				
	    	            case 13:{
	    	            	String  path = "/Users/Dani/Desktop/SmileyPlan/src/"; 
	    	            	String file = "provaAgente"; 
	    	            	conjAgentes.Guardar(path, file);
	    	            	break;
	    	            }
	    	            case 14:{
	    	            	String  path = "/Users/Dani/Desktop/SmileyPlan/src/";
	    	            	String file = "provaAgente"; 
	    	            	conjAgentes.Cargar(path, file);
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