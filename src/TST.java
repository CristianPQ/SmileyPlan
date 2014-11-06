/**
 ** Java Program to Implement Ternary Search Tree
 **/
 
import java.util.ArrayList;
import java.util.*;
 
/** class TSTNode **/

/** class TernarySearchTree **/
class TST<E>
{
	class TSTNode
	{
		E val;              // value associated with string
	    char data;
	    boolean isEnd;
	    TSTNode left, middle, right;
	 
	    /** Constructor **/
	    public TSTNode(char data,E e)
	    {
	        this.data = data;
	        this.isEnd = false;
	        this.left = null;
	        this.middle = null;
	        this.right = null;
	        this.val = e;
	    }        
	}
	 
    private TSTNode root;
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
    public void insert(String word, E e)
    {
        root = insert(root, word.toCharArray(), 0, e);
    }
    /** function to insert for a word **/
    public TSTNode insert(TSTNode r, char[] word, int ptr, E e)
    {
        if (r == null)
            r = new TSTNode(word[ptr], e);
 
        if (word[ptr] < r.data)
            r.left = insert(r.left, word, ptr, e);
        else if (word[ptr] > r.data)
            r.right = insert(r.right, word, ptr, e);
        else
        {
            if (ptr + 1 < word.length)
                r.middle = insert(r.middle, word, ptr + 1, e);
            else
                r.isEnd = true;
        }
        return r;
    }
 
    /** function to delete a word **/
    public void delete(String word)
    {
        delete(root, word.toCharArray(), 0);
    }
    /** function to delete a word **/
    private void delete(TSTNode r, char[] word, int ptr)
    {
        if (r == null)
            return;
 
        if (word[ptr] < r.data)
            delete(r.left, word, ptr);
        else if (word[ptr] > r.data)
            delete(r.right, word, ptr);
        else
        {
            /** to delete a word just make isEnd false **/
            if (r.isEnd && ptr == word.length - 1)
                r.isEnd = false;
 
            else if (ptr + 1 < word.length)
                delete(r.middle, word, ptr + 1);
        }        
    }
 
    /** function to search for a word **/
    public boolean search(String word)
    {
        return contains(root, word.toCharArray(), 0);
    }
    public E get(String word){
    	return buscar(root, word.toCharArray(), 0);
    }
    /** function to search for a word **/ //retorna null si no esta
    public E buscar (TSTNode r, char[] word, int ptr)
    {
        if (r == null)
            return null;
 
        if (word[ptr] < r.data)
            return buscar(r.left, word, ptr);
        else if (word[ptr] > r.data)
            return buscar(r.right, word, ptr);
        else
        {
            if (r.isEnd && ptr == word.length - 1)
                return  r.val;
            else if (ptr == word.length - 1)
                return null;
            else
                return buscar(r.middle, word, ptr + 1);
        }        
    }
    
    
    
    private boolean contains(TSTNode r, char[] word, int ptr)
    {
        if (r == null)
            return false;
 
        if (word[ptr] < r.data)
            return contains(r.left, word, ptr);
        else if (word[ptr] > r.data)
            return contains(r.right, word, ptr);
        else
        {
            if (r.isEnd && ptr == word.length - 1)
                return true;
            else if (ptr == word.length - 1)
                return false;
            else
                return contains(r.middle, word, ptr + 1);
        }        
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
 
            str = str + r.data;
            if (r.isEnd)
                al.add(str);
 
            traverse(r.middle, str);
            str = str.substring(0, str.length() - 1);
 
            traverse(r.right, str);
        }
    }
}
 
