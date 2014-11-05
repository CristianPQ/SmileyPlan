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
	    	Scanner sc = new Scanner(System.in);
	    	String[] lsplited;
	    	
	    	while(sc.hasNextLine()){
	    	
	    }
}

}