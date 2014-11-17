/*
 * @author Daniel Villanueva 
 */

import java.util.*;


public class ANTIGUODriverEntrada{
	
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
			ANTIGUOEntrada ent;
			ControladorMapa m = new ControladorMapa(100,100," ");		
			ControladorMedioTransporte mt = new ControladorMedioTransporte();
			
	    	menu();
	    	Scanner sc = new Scanner(System.in);
	    	String[] lsplited;
	    	
	    	while(sc.hasNextLine()){ 
	    		try{
	    			lsplited = sc.nextLine().split(" ");
	    			switch(Integer.parseInt(lsplited[0])){
	    				case 1: {
	    					//INIT controlador mapa
	    					
	    					m.agregarCiudad("barcelona", 0, 1);
	    					m.agregarCiudad("madrid", 0, 10);
	    					m.agregarCiudad("oviedo", 20, 12);
	    					m.agregarCiudad("sevilla", 34, 56);
	    					m.agregarCiudad("valencia", 2, 40);
	    					m.agregarCiudad("zaragoza", 12, 70);
	    					
	    					mt.agregarMedioTransporte("coche", 1);
	    					
	    					System.out.println("dhdhhd");
	    					m.agregarCamino("barcelona", "madrid", "coche", 10, mt);
	    					m.agregarCamino("barcelona", "oviedo", "coche", 10, mt);
	    					System.out.println("pasado");
	    					m.agregarCamino("oviedo", "valencia", "coche", 9, mt);
	    					m.agregarCamino("madrid", "oviedo", "coche", 2, mt);
	    					m.agregarCamino("madrid", "sevilla", "coche", 4, mt);
	    					m.agregarCamino("madrid", "valencia", "coche", 8, mt);
	    					m.agregarCamino("sevilla", "zaragoza", "coche", 10, mt);
	    					m.agregarCamino("valencia", "zaragoza", "coche", 10, mt);
	    					m.agregarCamino("valencia", "sevilla", "coche", 6, mt);
	    					

	    					System.out.println("Base inicializada\n");
	    					break;
	    				}
	    				
	    				case 2: {//INIT ENTRADA E IMPRESION DEL MAPEO
	    					ent = new ANTIGUOEntrada(m, mt,"barcelona", "zaragoza",17);
	    					ent.insertarCiudadesMapping(m);
	    					String[] relacion = ent.consultarMapping();
	    					for(int i = 0; i < relacion.length; ++i) 
	    						System.out.println(i + " " + relacion[i]+"\n");
	    					
	    					ent.crearGrafo(m, mt);
	    					break;
	    					
	    				}
	    			/*	
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
	*/		
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