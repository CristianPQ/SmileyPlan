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
	    					mt.agregarMedioTransporte("tren", 2);
	    					
	    					System.out.println("dhdhhd");
	    					m.agregarCamino("barcelona", "madrid", "coche", 10, mt);//01
	    					m.agregarCamino("barcelona", "madrid", "tren", 10, mt);//01
	    					m.agregarCamino("barcelona", "oviedo", "coche", 10, mt);//02
	    					System.out.println("pasado");
	    					m.agregarCamino("oviedo", "valencia", "coche", 9, mt);//24
	    					m.agregarCamino("oviedo", "valencia", "tren",12, mt);
	    					m.agregarCamino("madrid", "oviedo", "coche", 2, mt);//12
	    					m.agregarCamino("madrid", "sevilla", "coche", 4, mt);//13
	    					m.agregarCamino("madrid", "valencia", "coche", 8, mt);//14
	    					m.agregarCamino("sevilla", "zaragoza", "coche", 10, mt);//3 5
	    					m.agregarCamino("valencia", "zaragoza", "coche", 10, mt);//3 4
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
	    					
	    					for(int i = 0; i < m.listarCiudades().size();++i){
	    						System.out.println(m.listarCiudades().get(i));
	    						System.out.println(ent.returnCityIndex(m.listarCiudades().get(i)));
	    					}
	    					System.out.println("TAMANO MAPPING" + ent.tamanoMapping());
	    					GrafoAntiguo G = ent.consultarGrafo();
	    					System.out.println("IMPRIMIENDO ARISTAS");
	    					
	    					ArrayList<Arista> a = G.consultarAdyacentes(0);
	    					for(int i = 0; i < G.consultarAdyacentes(0).size(); ++i)
	    						System.out.println(a.get(i).consultarVerticeDestino());
	    						System.out.println("\n");
	    					
	    					ArrayList<Arista> ab = G.consultarAdyacentes(1);
	    					for(int i = 0; i < G.consultarAdyacentes(1).size(); ++i)
	    						System.out.println(ab.get(i).consultarVerticeDestino());
	    					System.out.println("\n");
	    					
	    					ArrayList<Arista> ac = G.consultarAdyacentes(2);
	    					for(int i = 0; i < G.consultarAdyacentes(2).size(); ++i)
	    						System.out.println(ac.get(i).consultarVerticeDestino());
	    					
	    					System.out.println("\n");
	    					
	    					ArrayList<Arista> ad = G.consultarAdyacentes(3);
	    					for(int i = 0; i < G.consultarAdyacentes(3).size(); ++i)
	    						System.out.println(ad.get(i).consultarVerticeDestino());
	    					
	    					System.out.println("\n");
	    					
	    					ArrayList<Arista> af = G.consultarAdyacentes(4);
	    					for(int i = 0; i < G.consultarAdyacentes(4).size(); ++i)
	    						System.out.println(af.get(i).consultarVerticeDestino());
	    					System.out.println("\n");
	    					
	    					ArrayList<Arista> ag = G.consultarAdyacentes(5);
	    					for(int i = 0; i < G.consultarAdyacentes(5).size(); ++i)
	    						System.out.println(ag.get(i).consultarVerticeDestino());
	    					System.out.println("\n");
	    					
	    					ArrayList<Arista> aw = G.consultarAdyacentes(6);
	    					for(int i = 0; i < G.consultarAdyacentes(6).size(); ++i)
	    						System.out.println(ag.get(i).consultarVerticeDestino());
	    					System.out.println("\n");
	    					
	    					ArrayList<Arista> aj = G.consultarAdyacentes(6);
	    					for(int i = 0; i < G.consultarAdyacentes(6).size(); ++i)
	    						System.out.println(ag.get(i).consultarVerticeDestino());
	    					System.out.println("\n");

	    					int wee = G.consultarCapacidadArista(0,1);
	    					System.out.println(wee +"\n");
	    					break;
	    					
	    					
	    				}
	    				
	    				case 3:{//relacCiudades

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