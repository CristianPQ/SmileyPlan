/**
 ** Java Program to Implement Ternary Search Tree
 **/
 
import java.util.ArrayList;
//import java.util.*;
 
/** class TSTNode **/

/** class TernarySearchTree **/
class TST<E>  //no estava la <E>
{
	class TSTNode
	{
		//E val;              // no existia aques atribut
	    //char data;
	    //boolean isEnd;
	    TSTNode left, middle, right;
	 
	    /** Constructor **/
	    public TSTNode()
	    {
	        //this.val = null;// = e;  //tampoc s'inicialitza
	        //this.data = data;
	        //this.isEnd = false;
	        left = null;
	        middle = null;
	        right = null;
	    }        
	}
	
	//NODO MEDIO
	class TSTNodeChar extends TSTNode
	{
		char data;
		public TSTNodeChar(char newData) {
			super();
			data = newData;
		}
		
	}
	
	// NODO FINAL
	class TSTNodeFinal extends TSTNode
	{
		E val;
		public TSTNodeFinal(E value) {
			super();
			val = value;
		}
	}
	
	//El primer elemento siempre tendra que ser un char
    private TSTNodeChar root;
    private ArrayList<String> al;
 
    /** Constructor **/
    public TST()
    {
        root = null;
    }
    
    /** function to check if empty **/
    
    public boolean isEmpty()
    {
        return root == null;
    }
    
    
    /** function to clear **/
    public void makeEmpty()
    {
        root = null;
    }
    /** function to insert for a word **/
    public void insert(E e) //++
    {
    	String key = ((Ciudad) e).consultarKey();
    	
    	//e es una Ciudad
    	/*if(e instanceof Ciudad) {
    		key = ((Ciudad) e).consultarKey();
    	}
    	
    	//e es un Camino
    	if(e instanceof Camino) {
    		key = ((Camino) e).consultarKey();
    	}
    	
    	//e es un Agente
    	if(e instanceof Agente) {
    		key = ((Agente) e).consultarKey();
    	}
    	
    	//e es un MedioTransporte
    	if(e instanceof MedioTransporte) {
    		key = ((MedioTransporte) e).consultarKey();
    	}*/
    	
        root = (TSTNodeChar) insert(root, key.toCharArray(), 0, e); //*
    }
    
    
    /** function to insert for a word **/
   //AGREGAR NUEVO ELEMENTO
    public TSTNode insert(TSTNode r, char[] word, int ptr, E e) //sense el parametre e
    {
    	char letra;
    	//Si ya se ha recorrido toda la palabra es una word[ptr], sino es $
    	if(ptr < word.length) {
    		letra = word[ptr];
    	}
    	else letra = '$';
    	
    	
		if(r == null) {
			r = new TSTNodeChar(letra);
			if(letra == '$') r.middle = new TSTNodeFinal(e);
			else r.middle = insert(r.middle, word, ptr + 1, e);
		}
		else {
			// rChar = r(con funcion de TSTNodeChar)
			TSTNodeChar rChar = (TSTNodeChar)r;
			
			//Si letra es menor a la izquierda
			if(letra < rChar.data) {
				r.left = insert(r.left, word, ptr, e);
			}
			// Si letra es mayor a la derecha
			else if(letra > rChar.data) {
				r.right = insert(r.right, word, ptr, e);
			}
			//Si letra es igual al medio
			else {
				r.middle = insert(r.middle, word, ptr + 1, e);
			}
		}
		return r;
   
/*	
		
        //Si yas has recorrido la palabra
        TSTNodeChar rChar = (TSTNodeChar)r;
		if(rChar.data == '$') {
			//Guarda el elemento en la siguiente posicion central
        	r.middle = new TSTNodeFinal(e);
        }
        //Si estas recorriendo la palabra
        else {
        	if(r.middle == null) {
        		r.middle = insert(r.middle, word, ptr + 1, e);
        	}
        	else if(word[ptr] == rChar.data)
                r.middle = insert(r.middle, word, ptr, e);
        	else if(word[ptr] < rChar.data)
                r.left = insert(r.left, word, ptr, e);
            else if (word[ptr] > rChar.data)
                r.right = insert(r.right, word, ptr, e);	
        	
        }

        return r;*/
    }
 
    
    /** function to delete a word **/
    //ELIMINAR ELEMENTO
    public void delete(String word)
    {
        root = (TST<E>.TSTNodeChar) delete(null, root, word.toCharArray(), 0);
    }
    
    
    /** function to delete a word **/
    private TSTNode delete(TSTNode f, TSTNode r, char[] word, int ptr)
    {
        if (r == null)
            return null;
        
        char letra;
    	//Si ya se ha recorrido toda la palabra es una word[ptr], sino es $
    	if(ptr < word.length) {
    		letra = word[ptr];
    	}
    	else letra = '$';
        
    	// rChar = r(con funcion de TSTNodeChar)
    	TSTNodeChar rChar = (TSTNodeChar)r;
    	
    	if(ptr == word.length && rChar.data == '$') {
    		
    		
    		r = deleteNode(r);
    		
    		
    	}

        
    	System.out.println("rChar.data: " + rChar.data + "\n" + "letra: " + letra + "\n" + "\n");
    	
        if (letra < rChar.data)
            r.left = delete(r, r.left, word, ptr);
        else if (letra > rChar.data)
            r.right = delete(r, r.right, word, ptr);
        else
        {
        	if(ptr < word.length)
        		r.middle = delete(r, r.middle, word, ptr + 1);
/*        	
        	
            /** to delete a word just make isEnd false **
            if (r.isEnd && ptr == word.length - 1)
                r.isEnd = false;
 
            else if (ptr + 1 < word.length)
                delete(r.middle, word, ptr + 1);
            */
        }
        return r;
    }
    
    private TSTNode deleteNode(TSTNode r) {
    	if(r != null) {
    		/*if(f != null) {
	        	if(f.right == r) {
	        		f.right = r.right;
	        	}
	        	else f.left = r.right;
    		}*/
    		if(r.right == null) {
    			r = r.left;
    		}
    		else {
    			TSTNode aux = r;
        		r = r.right;
        		TSTNode aux2 = r.right;
        		r.right = aux;
        		aux.right = aux2;
        		aux2 = r.left;
        		r.left = aux.left;
        		aux.left = aux2;
        		
        		r.right = deleteNode(r.right);
    		}
    	}
    	return r;
    }
 
    /** function to search for a word **/
    public boolean existe(String word)
    {
        return contains(root, word.toCharArray(), 0);
    }
    
    private boolean contains(TSTNode r, char[] word, int ptr)
    {
        if (r == null)
            return false;
        
        char letra;
    	//Si ya se ha recorrido toda la palabra es una word[ptr], sino es $
    	if(ptr < word.length) {
    		letra = word[ptr];
    	}
    	else letra = '$';
    	
    	// rChar = r(con funcion de TSTNodeChar)
    	TSTNodeChar rChar = (TSTNodeChar)r;
 
        if(letra < rChar.data)
            return contains(r.left, word, ptr);
        else if (letra > rChar.data)
            return contains(r.right, word, ptr);
        else
        {
            if (ptr < word.length)
            	return contains(r.middle, word, ptr + 1);
            else if(rChar.data == letra)
        		return true;
        }
        return false;
    }
    
    
    
    public E consultar(String word){ //aquesta funcio no existia
    	return buscar(root, word.toCharArray(), 0);
    }
    
    
    /** function to search for a word **/ //retorna null si no esta
    //aquesta tampoc
    public E buscar (TSTNode r, char[] word, int ptr)
    {
    	if (r == null)
            return null;
        
        char letra;
    	//Si ya se ha recorrido toda la palabra es una word[ptr], sino es $
    	if(ptr < word.length) {
    		letra = word[ptr];
    	}
    	else letra = '$';
    	
    	// rChar = r(con funcion de TSTNodeChar)
    	TSTNodeChar rChar = (TSTNodeChar)r;
 
        if(letra < rChar.data)
            return buscar(r.left, word, ptr);
        else if (letra > rChar.data)
            return buscar(r.right, word, ptr);
        else
        {
            if (ptr < word.length)
            	return buscar(r.middle, word, ptr + 1);
            else if(rChar.data == letra)
        		return ((TSTNodeFinal) r.middle).val;
        }
        return null;      
    }
    
    

    /** function to print tree **/
    public String toString()
    {
        al = new ArrayList<String>();
        traverse(root, "");
        return "\nTernary Search Tree : "+ al;
    }
    /** function to traverse tree **/
    private void traverse(TSTNode r, String str)
    {
        if (r != null)
        {
            traverse(r.left, str);
            
         // rChar = r(con funcion de TSTNodeChar)
        	TSTNodeChar rChar = (TSTNodeChar)r;
            if(rChar.data == '$')
            	al.add(str);
            else {
            	str = str + rChar.data;
            	 
                traverse(r.middle, str);
                str = str.substring(0, str.length() - 1);
     
                traverse(r.right, str);
            }
        }
    }
}
 
