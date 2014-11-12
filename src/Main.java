import java.util.*;

public class Main {
	
	/*private static Scanner sc;
	
	private static void menu() {
        System.out.println("Driver clase Ciudad"
                + "\n 0.Salir"
                + "\n 1.add(String s)"
                + "\n 2.delete(String s)"
                + "\n 3.escribirString():String"
                + "\n 4.escribirStringModif():String"
        		+"\n");
    }
	
	public static void main(String [] args) throws Exception {
		ArrayList<String> nombres = null;
		menu();
		sc = new Scanner(System.in);
        String[] lsplited;
        while (sc.hasNextLine()) {
        	try {
        		lsplited = sc.nextLine().split(" ");
    	        switch(Integer.parseInt(lsplited[0])) {
    	        	case 1: {
    	        		String s = lsplited[1];
    	            	nombres.add(s);
    	            	break;
    	        	}
    	        	case 2: {
    	        		String s = lsplited[1];
    	            	nombres.remove(s);
    	            	break;
    	        	}
    	        	case 3: {
    	        		for(Iterator<String> it = nombres.iterator(); it.hasNext(); ) {
    	        			System.out.println(it.next() + '\n');
    	        		}
    	        		break;
    	        	}
    	        	case 4: {
    	        		for(ListIterator<String> it = nombres.listIterator(); it.hasNext(); ) {
    	        			String str = it.next();
    	        			
    	        			it.set("hola");
    	        			it.remove();
    	        			System.out.println(str + '\n');
    	        		}
    	        		break;
    	        	}
    	        	case 5: {
    	        		nombres = new ArrayList<String>();
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
	}*/

}
