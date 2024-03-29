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
	                + "\n 12.obtenerNombresAgentes()"
	                + "\n 13.Guardar(String path, String file)"
	                + "\n 14.Cargar(String path, String file)"
	                + "\n 15.ConsultarAgentesOrigenObjetivo(String ciudadInicial, String ciudadObjetivo)"
	                + "\n 16.NumeroAgentesOrigenObjetivo(String ciudadInicial, String ciudadObjetivo)"
	                + "\n 17.CasosDiferentes()"
	                + "\n\nDISPONES DE LAS SIGUIENTES CIUDADES: "
	                + "\nbarcelona, madrid, oviedo, sevilla, valencia, zaragoza\n"
	        		+"\n");
}

public static void main(String [] args) throws Exception {
			ControladorAgentes conjAgentes = null;
			//////MAPA DE PRUEBAS///////////////////////
			ControladorMapa cm = new ControladorMapa(100, 100, " ");
			cm.agregarCiudad("barcelona", 0, 1);
			cm.agregarCiudad("madrid", 0, 10);
			cm.agregarCiudad("oviedo", 20, 12);
			cm.agregarCiudad("sevilla", 34, 56);
			cm.agregarCiudad("valencia", 2, 40);
			cm.agregarCiudad("zaragoza", 12, 70);
	    	menu();
	    	Scanner sc = new Scanner(System.in);
	    	String[] lsplited;
	    	
	    	while(sc.hasNextLine()){ 
	    		try{
	    			lsplited = sc.nextLine().split(" ");
	    			switch(Integer.parseInt(lsplited[0])){
	    				case 1: {//INIT
	    					conjAgentes = new ControladorAgentes();
	    					System.out.println("Conjunto de agentes inicializado\n");
	    					break;
	    				}
	    				
	    				case 2: {//ANADIR
	    					String nombre = lsplited[1];
	    					String ciudadInicial = lsplited[2];
	    					String ciudadObjetivo = lsplited[3];	    					
	    					conjAgentes.anadirAgente(nombre, ciudadInicial, ciudadObjetivo,cm);
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
	    					if (existe) System.out.println("El agente "+ nombre+" existe\n");
	    					else System.out.println("El agente no existe\n");
	    					break;
	    				}	    			
	    				
	    				case 5: {//consultarCiudadInicial
	    					String nombre = lsplited[1];
	    					String ciudadInicial = conjAgentes.consultarCiudadInicialAgente(nombre);
	    					System.out.println("El agente "+ nombre+" tiene "+ ciudadInicial+ " como ciudadInicial\n");
	    					break;
	    				}	    				
	    				case 6: {//consultarCiudadObjetivo
	    					String nombre = lsplited[1];
	    					String ciudadObjetivo = conjAgentes.consultarCiudadObjetivoAgente(nombre);
	    					System.out.println("El agente "+ nombre+" tiene "+ ciudadObjetivo+ " como ciudadObjetivo\n");
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
	    					System.out.println("\n");
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
	    				
	    				case 12:{//consultar nombre de todos los agentes
	    					ArrayList<String> aS = conjAgentes.consultarNombresAgentes();
			            	Iterator<String> it = aS.iterator();
			            	while(it.hasNext()) {
			            		System.out.println(it.next() + "\n");
			            	}
	    					System.out.println("\n");
			                break;
	    				}
	    				
	    	            case 13:{ //Guardado
	    	            	String file = lsplited[1]; 
	    	            	conjAgentes.Guardar(file);
	    	            	break;
	    	            }
	    	            case 14:{ //Cargar
	    	            	String file = lsplited[1];
	    	            	conjAgentes.Cargar(file, cm);
	    	            	break;
	    	            }
	    	            
	    	            
	    	            case 15:{//Consulta agentes por ciudadOrigen + ciudadObjetivo
	    					String ciudadInicial = lsplited[1];
	    					String ciudadObjetivo = lsplited[2];
	    					ArrayList <String> nombres = conjAgentes.consultarAgentesOrigenObjetivo(ciudadInicial, ciudadObjetivo);
	    					for (int i = 0; i < nombres.size(); ++i)
	    						System.out.println(nombres.get(i) +"\n");
	    					
	    					System.out.println("\n");
	    					break;
	    	            }
	    	            
	    	            case 16:{
	    					String ciudadInicial = lsplited[1];
	    					String ciudadObjetivo = lsplited[2];
	    					System.out.println(conjAgentes.numeroAgentesOrigenObjetivo(ciudadInicial, ciudadObjetivo));
	    					System.out.println("\n");
	    					break;

	    	            }
	    	            
	    	            case 17:{
	    	            	ArrayList<String[]> resultado = conjAgentes.casosDiferentes();
	    	            	String[] caso;
	    	            	for (int i = 0; i < resultado.size(); ++i){
	    	            		caso = resultado.get(i);
	    	            		System.out.println(caso[0] + " " + caso[1]);		
	    	            	}
	    	            	System.out.println("\n");
	    	            	break;
	    	            }
	    					
	    				case 0: {
	    	                System.exit(0);
	    	            }
	    				default: {
	    	                System.out.println("Entrada de datos no valida, pruebe con un valor entre 1 y 19 o 0 para salir\n");
	    	                break;
	    	            } 
	    			}
	    		} catch(Exception e) {
	    	        System.out.println("Error: " + e.getMessage() + "\n");
	    	}
    	}

} //Cierra funcion
} //Cierra clase