import java.util.Scanner;


public class DriverCiudad {
    private static Scanner sc;

	private static void menu() {
        System.out.println("Driver clase Ciudad"
                + "\n 0.Salir"
                + "\n 1.Ciudad(String nombre, int coordX, int coordY)"
                + "\n 2.getNombre():String"
                + "\n 3.setNombre(String nombre)"
                + "\n 4.getCoord():Coordenadas"
                + "\n 5.setCoord(Coordenadas coord)"
                + "\n 6.mover(int x, int y)" 
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
    	        		String nombre = ciudad.getNombre();
    	        		System.out.print(nombre +"\n");
    	        		break;
    	        	}
    	        	case 3: {
    	        		String nombre = lsplited[1];
    	            	ciudad.setNombre(nombre);
    	        		break;
    	        	}
    	        	case 4: {
    	        		Coordenadas coord = ciudad.getCoord();
    	        		System.out.print(coord.getX() + " " + coord.getY() +"\n");
    	        		break;
    	        	}
    	        	case 5: {
    	            	int coordX = Integer.parseInt(lsplited[1]);
    	                int coordY = Integer.parseInt(lsplited[2]);
    	                Coordenadas coord = new Coordenadas(coordX, coordY);
    	                ciudad.setCoord(coord);
    	        		break;
    	        	}
    	        	case 6: {
    	        		int x = Integer.parseInt(lsplited[1]);
    	                int y = Integer.parseInt(lsplited[2]);
    	                ciudad.mover(x, y);
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
