import java.util.Scanner;


public class DriverConjuntoCiudades {
    private static Scanner sc;

	private static void menu() {
        System.out.println("Driver clase Mapa"
                + "\n 0.Salir"
                + "\n 1.new ConjuntoCiudades()"
                + "\n 2.agregarCiudad(String nombre, int CoordX, int CoordY)"
                + "\n 3.buscarCiudad(String nombreCiudad):Ciudad"
                + "\n 4.getCoordenadas(String nombre):Coordenadas"
                + "\n 5.borrarCiudad(String nombre)"
                + "\n 6.numeroCiudades():int"
        		+"\n");
    }
	
    public static void main(String [] args) throws Exception {
    	ConjuntoCiudades ciudades = null;
        menu();
        sc = new Scanner(System.in);
        String[] lsplited;
        while (sc.hasNextLine()) {
	    	try {
		        lsplited = sc.nextLine().split(" ");
		        switch(Integer.parseInt(lsplited[0])) {
		            case 1: {
		            	ciudades = new ConjuntoCiudades();
		                break;
		            }
		            case 2: {
		            	String nombre = lsplited[1];
		                int x = Integer.parseInt(lsplited[2]);
		                int y = Integer.parseInt(lsplited[3]);
		                Coordenadas coord = new  Coordenadas(x,y);
		                Ciudad c = new Ciudad(nombre,coord);
		                ciudades.agregarCiudad(c);
		                break;
		            }
		            case 3: {
		            	String nombre = lsplited[1];
		            	Ciudad ciudad = ciudades.buscarCiudad(nombre);
		                System.out.print(ciudad.getNombre()+ ' ' + '(' + ciudad.getCoord().getX() +',' + ciudad.getCoord().getY() + ')' + "\n");
		                break;
		            }
	
		            case 4:{
		            	String nombre = lsplited[1];
		            	Coordenadas coord = ciudades.getCoordenadasCiudad(nombre);
		                System.out.print(coord.getX() + " " + coord.getY() + "\n");
		                break;
		            }
		            case 5:{
		            	String nombre = lsplited[1];
		            	ciudades.borrarCiudad(nombre);
		                break;
		            }
		            case 6: {
		            	int n = ciudades.numeroCiudades();
		                System.out.print( n + "\n");
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
		      
	        }
	    	catch(Exception e) {
	    		System.out.println("Error: " + e.getMessage() + "\n");
	        }
	    }
    }
}