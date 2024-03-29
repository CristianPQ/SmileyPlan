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
		
		//%%%%%%%%%%%%%%%%%%%%%%%%%%
		//%%%%%%MODIFICAR VALOR%%%%%
		//%%%%%%%%%%%%%%%%%%%%%%%%%%
		public void modificar(E e) {
			val = e;
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
    public void insert(String key, E e) //++
    {	
        root = (TSTNodeChar) insert(root, key.toCharArray(), 0, e); //*
    }
    
    /** function to insert for a word **/
    public void insert(E e) //++
    {
    	String key = e.toString(); 
        root = (TSTNodeChar) insert(root, key.toCharArray(), 0, e); //*
    }
    
    
    /** function to insert for a word **/
   //AGREGAR NUEVO ELEMENTO
    private TSTNode insert(TSTNode r, char[] word, int ptr, E e) 
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
    }
 
    
    /** function to delete a word **/
    //ELIMINAR ELEMENTO
    public void delete(String word)
    {
    	if(numero() == 1) makeEmpty();
    	else root = (TSTNodeChar) delete(null, root, word.toCharArray(), 0);
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

        
    	//System.out.println("rChar.data: " + rChar.data + "\n" + "letra: " + letra + "\n" + "\n");
    	
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
    		
    		//En pricipio el siempre se intentara subir el hijo derecho
    		//que sera el mayor
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
    
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //%%%%%%%%Modificador del elemento%%%%%%%%%%%
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    
    public void modificar(String word, E e)
    {
        root = (TSTNodeChar) modificarNodo(null, root, word.toCharArray(), 0, e);
    }
    
    private TSTNode modificarNodo(TSTNode f, TSTNode r, char[] word, int ptr, E e)
    {
        if (r == null) {
        	//System.out.println("ESTE NODO ES NULL" + " \n");
            return null;
        }
        	//System.out.println("ESTE NODO NUEVO NO ES NULL" + " \n");
        
        char letra;
    	//Si ya se ha recorrido toda la palabra es una word[ptr], sino es $
    	if(ptr < word.length) {
    		letra = word[ptr];
    	}
    	else letra = '$';
        
    	// rChar = r(con funcion de TSTNodeChar)
    	TSTNodeChar rChar = (TSTNodeChar)r;
    	
    	if(ptr == word.length && rChar.data == '$') {
    		//Se ha encontrado la palabra
    		TSTNodeFinal rFinal = (TSTNodeFinal)r.middle;
    			//System.out.println("Antes modificar en TST" + " \n");
    		rFinal.modificar(e);
    			//System.out.println("Despues modificar en TST" + " \n");
    		r.middle = rFinal;
    		
    		
    	}
    		//System.out.println("rChar.data: " + rChar.data + "\n" + "letra: " + letra + "\n" + "\n");
    	
    	//Profundizando en el arbol, siguiente letra de la palabra
        if (letra < rChar.data)
            r.left = modificarNodo(r, r.left, word, ptr, e);
        else if (letra > rChar.data) {
        		//System.out.println("Entro en hijo derecho con letra mayor" + "\n");
            r.right = modificarNodo(r, r.right, word, ptr, e);
            	//System.out.println("Salgo de hijo derecho con letra mayor" + "\n");
        }
        else
        {
        	if(ptr < word.length)
        		r.middle = modificarNodo(r, r.middle, word, ptr + 1, e);
        }
        return r;
    }
    
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%    
 
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
    
    
    //CONSULTAR UN ELEMENTO
    public E consultar(String word){ //aquesta funcio no existia
    	return buscar(root, word.toCharArray(), 0);
    }
    
    
    /** function to search for a word **/ //retorna null si no esta
    //aquesta tampoc
    private E buscar(TSTNode r, char[] word, int ptr)
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
            if(rChar.data == '$') {
            	al.add(str);	
            }
            else {
            	
            	str = str + rChar.data;
            	 
                traverse(r.middle, str);
                str = str.substring(0, str.length() - 1);
     
                //traverse(r.right, str);
            }
            traverse(r.right, str);
        }
    }
    
    public ArrayList<String> consultar() {
    	al = new ArrayList<String>();
    	traverse(root, "");
    	return al;
    }
    
    public int numero() {
    	return quantity(root);
    }
    
    private int quantity(TSTNode t) {
    	if(t != null) {
    		TSTNodeChar tChar = (TSTNodeChar)t;
    			//System.out.print("letra: " + tChar.data + "\n");
    		if(tChar.data == '$') {
    			int fl = quantity(t.left);
    			int fr = quantity(t.right);
    			return fl+fr+1;
    		}
    		else {
	    		int f1 = quantity(t.left);
	    			//System.out.print("f1: " + f1 + "\n");
	    		int f2 = quantity(t.middle);
	    			//System.out.print("f2: " + f2 + "\n");
	    		int f3 = quantity(t.right);
	    			//System.out.print("f3: " + f3 + "\n");
	    		return f1+f2+f3;
    		}
    	}
    	return 0;
    }
    
}
 
