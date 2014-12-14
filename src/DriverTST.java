import java.util.ArrayList;
import java.util.Scanner;

	/** class TernarySearchTree **/
	public class DriverTST {
	    
		private static void menu() {
			System.out.println("\nTernary Search Tree Operations\n");
			System.out.println("0. Salir");
            System.out.println("1. TST()");
            System.out.println("2. isEmpty():boolean");
            System.out.println("3. makeEmpty()");
            System.out.println("4. insert(String key, E e)");
            System.out.println("5. delete(String word)");
            System.out.println("6. modificar(String word, E e)");
            System.out.println("7. existe(String word):boolean");
            System.out.println("8. consultar(String word): E");
            System.out.println("9. toString(): String");
            System.out.println("10. consultar(): ArrayList<String>");
            System.out.println("11. numero(): int");
		}
		
		public static void main(String[] args) {
			
			TST<String> tst = null;
			menu();
	    	Scanner sc = new Scanner(System.in);
	    	String[] lsplited;
	    	while(sc.hasNextLine()){   
	    		try{
	    			lsplited = sc.nextLine().split(" ");
	    			switch(Integer.parseInt(lsplited[0])){
			            case 1:{
			            	tst = new TST<String>();
			            	break;
			            }
			            case 2 :{ 
			                System.out.println("Empty Status : "+ tst.isEmpty() );                
			                break;
			            }
			            case 3 :{ 
			                tst.makeEmpty();               
			                break;
			            }
			            case 4 :{ 
				        	String st = lsplited[1];
				        	if(!lsplited[1].equals(lsplited[2])) {
				        		System.out.println("key incorrecta");
				        		break;
				        	}
			                tst.insert(lsplited[1], lsplited[2]);                     
			                break; 
			            }
			            case 5 :{ 
			                tst.delete(lsplited[1]);                     
			                break;
			            }
			            case 6:{
			            	tst.modificar(lsplited[1], lsplited[2]);
			            	break;
			            }
			            case 7:{
			            	System.out.println("Este elemento " + tst.existe(lsplited[1]) + "existe");
			            	break;
			            }
			            case 8 :{ 
			                System.out.println("Search result : "+ tst.consultar(lsplited[1]));
			                break;
			            }
			            case 9:{
			            	System.out.println("Elementos: \n" + tst.toString());
			            	break;
			            }
			            case 10:{
			            	ArrayList<String> st = tst.consultar();
			            	System.out.println("Elementos:");
			            	for(int i = 0; i < st.size(); ++i) {
			            		System.out.println(st.get(i));
			            	}
			            	break;
			            }
			            case 11:{
			            	System.out.println("Hay " + tst.numero() + "elementos");
			            	break;
			            }
			            case 0: {
	    	                System.exit(0);
	    	            }
			            default : 
			                System.out.println("Wrong Entry \n ");
			                break; 
	    			}
	            } catch(Exception e) {
	    	        System.out.println("Error: " + e.getMessage() + "\n");
	                                 
	        }    
	    }
	}
}
