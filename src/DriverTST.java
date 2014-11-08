import java.util.Scanner;



	/** class TernarySearchTree **/
	public class DriverTST
	{
	    public static void main(String[] args)
	    {
	        Scanner scan = new Scanner(System.in);
	 
	        /* Creating object of TernarySearchTree */
	        TST<Camino> tst = new TST();
	        System.out.println("Ternary Search Tree Test\n"); 
	 
	        char ch;
	        /*  Perform tree operations  */
	        do    
	        {
	            System.out.println("\nTernary Search Tree Operations\n");
	            System.out.println("1. insert element");
	            System.out.println("2. contains elemnt");
	            System.out.println("3. delete key");
	            System.out.println("4. check empty");
	            System.out.println("5. make empty");
	            System.out.println("6. get word");
	 
	            int choice = scan.nextInt();            
	            switch (choice)
	            {
	            case 1 : 
	                System.out.println("Enter word to insert");
		        	   String ciudadOrigen = scan.next(); 
		        	   String ciudadDestino = scan.next(); 
		        	   String transporte = scan.next(); 
		        	   Camino c = new Camino(ciudadOrigen, ciudadDestino, transporte);
	                tst.insert( ciudadOrigen, c  );                     
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
