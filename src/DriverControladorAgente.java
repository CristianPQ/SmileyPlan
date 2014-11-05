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
	                + "\n 9.consultarAgentesCiudadInicialCiudadObjetivo(String ciudadInicial, String ciudadObjetivo)"
	        		+ "\n 10.getNumeroDeAgentes()" 
	        		+"\n");
}

private static void main(String [] args) throws Exception {
	    	menu();
	    	ControladorAgentes conjAgentes = null;
	    	Scanner sc = new Scanner(System.in);
	    	String[] lsplited;
	    	
	    	while(sc.hasNextLine()){ 
	    		try{
	    			lsplited = sc.nextLine().split(" ");
	    			switch(Integer.parseInt(lsplited[0])){
	    				case 1: {//INIT
	    					conjAgentes = new ControladorAgentes();
	    					//System.out.println("Ya se inicializa por defecto");
	    				}
	    				
	    				case 2: {//CREAR/ANADIR
	    					String nombre = lsplited[1];
	    					String ciudadInicial = lsplited[2];
	    					String ciudadObjetivo = lsplited[3];	    					
	    					conjAgentes.anadirAgente(nombre, ciudadInicial, ciudadObjetivo);
	    				}
	    				
	    				case 3: {//ELIMINAR
	    					String nombre = lsplited[1];
	    					conjAgentes.eliminarAgente(nombre);
	    				}
	    				
	    				case 4: {//modificarNombre
	    					String nombreAntiguo = lsplited[1];
	    					String nombreNuevo = lsplited[2];
	    					conjAgentes.modificarNombreAgente(nombreAntiguo, nombreNuevo);
	    				}
	    				
	    				case 5: {//modificarCiudadInicial
	    					String nombre = lsplited[1];
	    					String ciudadInicial = lsplited[2];
	    					conjAgentes.modificarCiudadInicialAgente(nombre, ciudadInicial);
	    				}
	    				
	    				case 6: {//modificarCiudadObjetivo
	    					String nombre = lsplited[1];
	    					String ciudadObjetivo = lsplited[2];
	    				}
	    				
	    				case 7: {//consultarAgentes
	    					
	    				}
	    			}
	    		}
	    	}
}

}