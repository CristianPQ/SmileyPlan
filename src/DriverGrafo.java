import java.util.*;


public class DriverGrafo {
	private static Scanner sc;

	private static void menu() {
        System.out.println("Driver clase Grafo"
                + "\n 0.Salir"
                + "\n 1.Grafo()"
                + "\n 2.consultarAdyacenciasSalida(int indice):ArrayList<E>"
                + "\n 3.consultarAdyacenciasEntrada(int indice):ArrayList<E>"
                + "\n 4.existeAristaCon(indice)"
                + "\n 5.agregarArista(E e, int in, int out)"
                + "\n 6. eliminarArista(E e, int in, int out)"
                + "\n 7.Grafo(int n)"
        		+"\n");
    }
	
	public static void main(String [] args) throws Exception {
		Grafo<Integer, String> g = null;
		menu();
		sc = new Scanner(System.in);
        String[] lsplited;
        while (sc.hasNextLine()) {
        	try {
        		lsplited = sc.nextLine().split(" ");
    	        switch(Integer.parseInt(lsplited[0])) {
    	        	case 1: {
    	        		g = new Grafo<Integer,String>();
    	        		break;
    	        	}
    	        	case 2: {
    	        		int indice = Integer.parseInt(lsplited[1]);
    	        		ArrayList<String> li = g.consultarAristasSalida(indice);
    	        		String s = new String();
    	        		for(int i = 0; i < li.size(); ++i) {
    	        			s = s + li.get(i) + "\n";
    	        		}
    	        		System.out.println(s);
    	        		break;
    	        	}
    	        	case 3: {
    	        		int indice = Integer.parseInt(lsplited[1]);
    	        		ArrayList<String> li = g.consultarAristasEntrada(indice);
    	        		String s = new String();
    	        		for(int i = 0; i < li.size(); ++i) {
    	        			s = s + li.get(i) + "\n";
    	        		}
    	        		System.out.println(s);
    	        		break;
    	        	}
    	        	case 4: {
    	        		int indice = Integer.parseInt(lsplited[1]);
    	                boolean b = g.existeAristaCon(indice);
    	                System.out.println(b + "\n");
    	        		break;
    	        	}
    	        	case 5: {
    	        		int in = Integer.parseInt(lsplited[1]);
    	        		int out = Integer.parseInt(lsplited[2]);
    	        		while(g.size() <= in || g.size() <= out) {
    	        			g.agrandar();
    	        		}
    	            	String st = lsplited[3];
    	                g.agregarArista(st, in, out);
    	        		break;
    	        	}
    	        	case 6: {
    	        		int in = Integer.parseInt(lsplited[1]);
    	        		int out = Integer.parseInt(lsplited[2]);
    	            	String st = lsplited[3];
    	                g.eliminarArista(st, in, out);
    	        		break;
    	        	}
    	        	case 7: {
    	        		int n = Integer.parseInt(lsplited[1]);
    	        		g = new Grafo<Integer, String>(n);
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
