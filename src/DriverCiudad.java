import java.util.Scanner;


public class DriverCiudad {
    private static Scanner sc;

	private static void menu() {
        System.out.println("Driver clase Ciudad"
                + "\n 0.Salir"
                + "\n 1.Ciudad(String nombre, int coordX, int coordY)"
                + "\n 2.getNombre():String"
                + "\n 3.getCoord():Coordenadas"
                + "\n 4.setCoord(int coordX, int coorY)"
        		+"\n");
    }
	
	public static void main(String [] args) throws Exception {
		Ciudad ciudad = null;
		menu();
		sc = new Scanner(System.in);
        String[] lsplited;
        while (sc.hasNextLine()) {
        	try {
        		lsplited = sc.nextLine().split(" ");
    	        switch(Integer.parseInt(lsplited[0])) {
    	        	case 1: {
    	        		String nombre = lsplited[1];
    	            	int coordX = Integer.parseInt(lsplited[2]);
    	                int coordY = Integer.parseInt(lsplited[3]);
    	                Coordenadas coord = new Coordenadas(coordX, coordY);
    	                ciudad = new Ciudad(nombre, coord);
    	        		break;
    	        	}
    	        	case 2: {
    	        		String nombre = ciudad.consultarNombre();
    	        		System.out.print(nombre +"\n");
    	        		break;
    	        	}
    	        	case 3: {
    	        		Coordenadas coord = ciudad.consultarCoordenadas();
    	        		System.out.print(coord.consultarX() + " " + coord.consultarY() +"\n");
    	        		break;
    	        	}
    	        	case 4: {
    	            	int coordX = Integer.parseInt(lsplited[1]);
    	                int coordY = Integer.parseInt(lsplited[2]);
    	                Coordenadas coord = new Coordenadas(coordX, coordY);
    	                ciudad.modificarCoordenadas(coord);
    	        		break;
    	        	}
    	        	case 0: {
    	                System.exit(0);
    	            }
    	            default: {
    	                System.out.println("Entrada de datos no valida, pruebe con un valor entre 1 y 6 o 0 para salir\n");
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
