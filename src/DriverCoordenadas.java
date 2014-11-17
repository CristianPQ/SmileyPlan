import java.util.Scanner;


public class DriverCoordenadas {
	private static Scanner sc;

	private static void menu() {
        System.out.println("Driver clase Ciudad"
                + "\n 0.Salir"
                + "\n 1.Coordenadas(int coordX, int coordY)"
                + "\n 2.getCoordX():int"
                + "\n 3.getCoordY():int"
                + "\n 4.distancia(Coordenadas coordD):int"
        		+"\n");
    }
	
	public static void main(String [] args) throws Exception {
		Coordenadas coord = null;
		menu();
		sc = new Scanner(System.in);
        String[] lsplited;
        while (sc.hasNextLine()) {
        	try {
        		lsplited = sc.nextLine().split(" ");
    	        switch(Integer.parseInt(lsplited[0])) {
    	        	case 1: {
    	        		int coordX = Integer.parseInt(lsplited[1]);
    	            	int coordY = Integer.parseInt(lsplited[2]);
    	                coord = new Coordenadas(coordX, coordY);
    	        		break;
    	        	}
    	        	case 2: {
    	        		int coordX = coord.consultarX();
    	        		System.out.println(coordX + "\n");
    	        		break;
    	        	}
    	        	case 3: {
    	        		int coordY = coord.consultarY();
    	        		System.out.println(coordY + "\n");
    	        		break;
    	        	}
    	        	case 4: {
    	        		int coordX = Integer.parseInt(lsplited[1]);
    	            	int coordY = Integer.parseInt(lsplited[2]);
    	                Coordenadas co = new Coordenadas(coordX, coordY);
    	                int d = coord.distancia(co);
    	                System.out.println(d + "\n");
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
