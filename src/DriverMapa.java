
//package Dominio;
import java.util.*;


public class DriverMapa {
    private static void menu() {
        System.out.println("Driver clase Mapa"
                + "\n 0.Salir"
                + "\n 1.new Mapa(Coordenadas[] continente, int anchuraX, int alturaY)"
                + "\n 2.getCiudades()"
                + "\n 3.agregarCiudad(Ciudad c)"
                + "\n 4.int numeroCiudades()"
                + "\n 5.numeroCaminos()"
                + "\n 6.Ciudad buscarCiudad(String nombreCiudad)"
                + "\n 7.Coordenadas getCoordenadasCiudad(String nombreCiudad)"
                + "\n 8.borrarCiudad(String nombreCiudad)"
                + "\n 9.getAnchuraX()"
        		+ "\n 10.setAnchuraX(int anchuraX)"
        		+ "\n 11.getAlturaY()"
        		+ "\n 12.setAlturaY(int alturaY)"
        		+ "\n 13.Coordenadas[] getContinente()"
        		+ "\n 14.setContinente(Coordenadas[] continente)"
        		+ "\n 15.setAlturaY(int alturaY)"
        		+ "\n 16.conCiudadOrigen(String ciudadOrigen)"
        		+ "\n 17.agregarCamino(Camino c)"   
        		+"\n");
    }
	
    public static void main(String [] args) throws Exception {
    	Mapa m = null;
        menu();
        Scanner sc = new Scanner(System.in);
        String[] lsplited;
        while (sc.hasNextLine()) {
    	try {
	        lsplited = sc.nextLine().split(" ");
	        switch(Integer.parseInt(lsplited[0])) {
	            case 1: {
	            	Coordenadas[] aux = null;
	            	int anchuraX = Integer.parseInt(lsplited[1]);
	                int alturaY = Integer.parseInt(lsplited[2]);
	                 m = new Mapa(aux, anchuraX, alturaY);
	                break;
	            }
	           /* case 2: {
	            	
	            	Set<String> aux = m.getCiudades();
	            	String[]aux2 = new
	            	String[]aux2 = aux.toArray(aux2);
	            	for (int i = 0; i < aux.size(); ++i)
	            		System.out.print(aux2[i] + "\n");
	                break;
	            }*/
	            case 3: {
	                String nombre = lsplited[1];
	                int x = Integer.parseInt(lsplited[2]);
	                int y = Integer.parseInt(lsplited[3]);
	                Coordenadas coord = new  Coordenadas(x,y);
	                Ciudad c = new Ciudad(nombre,coord);
	                m.agregarCiudad(c);
	                break;
	            }

	            case 4:{
	            	System.out.print(m.numeroCiudades() +"\n");
	                break;
	            }
	            case 5:{
	            	System.out.print(m.numeroCaminos()+"\n");
	                break;
	            }
	            case 6: {
	            	String nombre = lsplited[1];
	            	Ciudad aux = m.buscarCiudad(nombre);
	                System.out.print(aux.getNombre()+ ' ' + '(' + aux.getCoord().getX() +',' + aux.getCoord().getY() + "\n");
	                break;
	            }
	            case 17: {
	            	String ciudadOrigen = lsplited[1];
	            	String ciudadDestino = lsplited[2];
	            	String medioTransporte = lsplited[3];
	            	Camino c = new Camino(ciudadOrigen,ciudadDestino,medioTransporte);
	            	m.agregarCamino(c);
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

}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

