import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.LineNumberReader;
import java.util.*;


public class GestorDatos {
	
	 //protected String Directorio;
	 protected String Archivo;
	 //protected File f;
	 private BufferedWriter bw; 
	 private BufferedReader br; 
	 private FileWriter fw;
	 private FileReader fr;
	 private boolean lectura;
	 private boolean escritura;
	 protected String buffer; 
	 //private int cont; 
 	private ArrayList<String> sol = new ArrayList<String>();
 	private Iterator<String> it = sol.iterator();
 	private int pos = 0; 
	 
	 /**
	  * Constructora por defecto
	  */
	 public GestorDatos(){
		 
	 }
	    
	 /**
	   * Constructora
	   * @param nomD2 nombre del directorio
	   * @param nomF2 nombre del archivo
	  */
	  public GestorDatos(String file) {
	       br = null;
	       bw = null;
	       fr = null;
	       fw = null;
	       lectura = false;
	       escritura = false;
	       Archivo = file;
	    }
	    

	    /**
	     * Abre un archivo previamente creado
	     * @param read o write 
	     * @return true si se abre el archivo sin problema 
	     * @throws 
	     */
	    public void abrirArchivo(String modo) throws Exception {
	    	File f = new File(Archivo);
	    	System.out.println("he creat arxiu"); 
	    	f.createNewFile(); 
	        if (modo == "read") { 
	        	System.out.print("dins opcio read \n");
	            fr = new FileReader(f);
	            br = new BufferedReader(fr); 
	            lectura = true;
	        }
	        if (modo == "write") { 
	        	System.out.print("dins opcio write \n");
	            fw = new FileWriter(f);
	            bw = new BufferedWriter(fw);
	            escritura = true;
	        }
	    }
	    
	    /**
	     * Cerrar el archivo
	     * @return true si se cierra sin problemas
	     * @throws 
	     */
	    public boolean cerrarArchivo() throws Exception {
	        if (!lectura && !escritura) return false;
	        if (lectura) {
	            br.close();
	            fr.close();
	            lectura = false;
	        } 
	        if (escritura) {
	            bw.close();
	            fw.close();
	            escritura = false;
	        }	
	        return true;
	    }
	    
	    /**
	     * Obtener todos los strings de la arraylist
	     * @return arraylist d'strings
	     */
	    public String obtenerTodoElString(){
	    	int i = 1; 
	    	String line = sol.get(0) + "\n"; 
	    	while(i < sol.size()){
	    		line = line + sol.get(i) + "\n";
	    		++i; 
	    	}
	    	return line; 
	    }
	    
	    
	    /**
	     * Devuelve los strings en bloques de 250  
	     * @param n que equivale a 250 que es la carga maxima
	     * @return el string con 250 elementos
	     */
	    public String obtenerStrings(int n) {
	    	String line = sol.get(pos) + "\n";
	    	++pos; 
	    	System.out.println("posicio on segueixo" + pos); 
	    	int j; 
	    	--n; 
	    	for(j= 0; j < n; ++j){    		
	    		line = line + sol.get(pos) + "\n"; 
	    		//System.out.println(line); 
	    		++pos; 
	    	}
	    	return line; 
	    }
	    
	    /**
	     * Convierte el buffer en array de strings y devuelve el numero de lineas de este
	     * @return numero de lineas
	     * @throws Exception si el archivo esta vacio
	     */
	    public int bufferToStrings() throws Exception{
	    	String s; 
	    	int cont = 0; 
	    	if ((s = br.readLine()) == null) throw new Exception ("fichero vacío"); 
	    	sol.add(s);
	    	++cont; 
	    	while( (s = br.readLine()) != null) {
	    		sol.add(s); 
	    		++cont; 
	    	}
	    	return cont; 
	    }
	    
	
	    /**
	     * 
	     * @param buffer que vamos a escribir dentro del archivo
	     * @return true 
	     * @throws 
	     */
	    public boolean writeBuffer(String buffer) throws Exception {
	        if (escritura) {
	            bw.write(buffer);
	            bw.newLine();
	            return true;
	        }
	        return false;
	    }
	    
	    /**
	     * Lee las lineas de un buffer
	     * @param numLines lineas que vamos a leer
	     * @return 
	     * @throws 
	     */
	    public String readBuffer(int numLines) throws Exception {
	        String result = null;
	        if (lectura) {
	            int i = 0;
	            result = br.readLine() + "\n";
	            i++;
	            while (i < numLines) {
	                result += br.readLine() + "\n";
	                i++;
	            }
	        }
	        return result;
	    }
	    
	}
