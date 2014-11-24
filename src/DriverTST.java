import java.util.Scanner;



	/** class TernarySearchTree **/
	public class DriverTST
	{
	    public static void main(String[] args)
	    {
	        Scanner scan = new Scanner(System.in);
	 
	        /* Creating object of TernarySearchTree */
	        TST<String> tst = new TST();
	        System.out.println("Ternary Search Tree Test\n"); 
	 
	        char ch;
	        /*  Perform tree operations  */
	        do    
	        {
	            System.out.println("\nTernary Search Tree Operations\n");
	            System.out.println("1. insert(String key, E e)");
	            System.out.println("2. existe(String word)");
	            System.out.println("3. delete(String word)");
	            System.out.println("4. modificar(String word, E e)");
	            System.out.println("5. consultar(String word): E");
	            System.out.println("6. toString()");
	            System.out.println("6. numero(): int");
	 
	            int choice = scan.nextInt();            
	            switch (choice)
	            {
	            case 1 : 
	                System.out.println("Enter word to insert");
		        	String st = scan.next(); 
	                tst.insert(st, st);                     
	                break;                          
	            case 2 : 
	                System.out.println("Enter word to search");
	                System.out.println("Search result : "+ tst.search( scan.next() ));
	                break; 
	            case 3 : 
	                System.out.println("Enter word to delete");
	                tst.delete( scan.next() );                     
	                break; 
	            case 4 : 
	                System.out.println("Empty Status : "+ tst.isEmpty() );                
	                break;    
	            case 5 : 
	                System.out.println("Ternary Search Tree cleared"); 
	                tst.makeEmpty();               
	                break;
	            case 6 : 
	                System.out.println("Ternary Search Tree cleared"); 
	                String ciudadOrigen1 = scan.next(); 
	                Camino c2 = tst.get(ciudadOrigen1);
	                System.out.println(c2.getOrigen() + ' ' + c2.getDestino() + ' ' + c2.getTransporte());
	                break;   
	            default : 
	                System.out.println("Wrong Entry \n ");
	                break;   
	            }
	            System.out.println(tst);
	 
	            System.out.println("\nDo you want to continue (Type y or n) \n");
	            ch = scan.next().charAt(0);                        
	        } while (ch == 'Y'|| ch == 'y');        
	    }
	}
