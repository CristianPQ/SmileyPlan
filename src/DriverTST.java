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
			            case 1:
			            	break;
			            case 2 : 
			                System.out.println("Empty Status : "+ tst.isEmpty() );                
			                break;    
			            case 3 : 
			                System.out.println("Ternary Search Tree cleared"); 
			                tst.makeEmpty();               
			                break; 
			            case 4 : 
			                System.out.println("Enter word to insert");
				        	String st = sc.next(); 
			                tst.insert(st, st);                     
			                break; 
			            case 5 : 
			                System.out.println("Enter word to delete");
			                tst.delete( sc.next() );                     
			                break;
			            case 6:
			            	break;
			            case 7:
			            	break;
			            case 8 : 
			                System.out.println("Enter word to search");
			                System.out.println("Search result : "+ tst.consultar( sc.next() ));
			                break;
			            case 9:
			            	break;
			            case 10:
			            	break;
			            case 11:
			            	break;
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
