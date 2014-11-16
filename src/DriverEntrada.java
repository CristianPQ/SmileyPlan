/*
 * @author Daniel Villanueva 
 */

import java.util.*;


public class DriverEntrada{
	
private static void menu() {
	        System.out.println("Driver clase ControladorAgente"
	                + "\n 0.Salir"
	                + "\n 1.new ControladorMapa(int longX, int longY, int continente)  - rellenar - new ControladorMedioTransporte()"
	                + "\n 2.new ControladorMedioTransporte()"
	                + "\n 3.new "
	                + "\n 3."
	                + "\n 4."
	                + "\n 5."
	                + "\n 6."
	        		+ "\n 7." 
	                + "\n 8."
	        		+ "\n 9." 
	                + "\n 10."
	        		+ "\n 11."
	                + "\n 12."
	                + "\n 13."
	                + "\n 14."
	                + "\n 15."
	                + "\n 16."
	        		+"\n");
}

public static void main(String [] args) throws Exception {
			Entrada ent;
			ControladorMapa m;
			ControladorMedioTransporte mt;
			
	    	menu();
	    	Scanner sc = new Scanner(System.in);
	    	String[] lsplited;
	    	
	    	while(sc.hasNextLine()){ 
	    		try{
	    			lsplited = sc.nextLine().split(" ");
	    			switch(Integer.parseInt(lsplited[0])){
	    				case 1: {
	    					//INIT controlador mapa
	    					m = new ControladorMapa(100,100,null);		
	    					m.agregarCiudad("barcelona", 0, 1);
	    					m.agregarCiudad("madrid", 0, 10);
	    					m.agregarCiudad("oviedo", 20, 12);
	    					m.agregarCiudad("sevilla", 34, 56);
	    					m.agregarCiudad("valencia", 2, 40);
	    					m.agregarCiudad("zaragoza", 12, 70);
	    					
	    					mt = new ControladorMedioTransporte();
	    					mt.agregarMedioTransporte("coche", 1);
	    					
	    					m.agregarCamino("barcelona", "madrid", "coche", 10, mt);
	    					m.agregarCamino("barcelona", "oviedo", "coche", 10, mt);
	    					m.agregarCamino("madrid", "oviedo", "coche", 2, mt);
	    					m.agregarCamino("madrid", "sevilla", "coche", 4, mt);
	    					m.agregarCamino("madrid", "valencia", "coche", 8, mt);
	    					m.agregarCamino("sevilla", "zaragoza", "coche", 10, mt);
	    					m.agregarCamino("valencia", "zaragoza", "coche", 10, mt);
	    					m.agregarCamino("valencia", "sevilla", "coche", 6, mt);
	    					m.agregarCamino("barcelona", "madrid", "coche", 10, mt);
	    					

	    					System.out.println("Base inicializada\n");
	    					break;
	    				}
	    				
	    				case 2: {//INIT ENTRADA
	    					ent = new Entrada(m, mt, throws)
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
			                break;
	    				}
	    				
	    	            case 13:{ //Guardado
	    	            	String  path = "/Users/Dani/Desktop/SmileyPlan/src/"; 
	    	            	String file = "provaAgente"; 
	    	            	conjAgentes.Guardar(path, file);
	    	            	break;
	    	            }
	    	            case 14:{ //Carga
	    	            	String  path = "/Users/Dani/Desktop/SmileyPlan/src/";
	    	            	String file = "provaAgente"; 
	    	            	conjAgentes.Cargar(path, file);
	    	            	break;
	    	            }
	    	            
	    	            
	    	            case 15:{//Consulta agentes por ciudadOrigen + ciudadObjetivo
	    					String ciudadInicial = lsplited[1];
	    					String ciudadObjetivo = lsplited[2];
	    					ArrayList <String> nombres = conjAgentes.consultarAgentesOrigenObjetivo(ciudadInicial, ciudadObjetivo);
	    					for (int i = 0; i < nombres.size(); ++i)
	    						System.out.println(nombres.get(i) +"\n");
	    					break;
	    	            }
	    	            
	    	            case 16:{
	    					String ciudadInicial = lsplited[1];
	    					String ciudadObjetivo = lsplited[2];
	    					System.out.println(conjAgentes.numeroAgentesOrigenObjetivo(ciudadInicial, ciudadObjetivo));
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