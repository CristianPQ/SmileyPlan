import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;


public class GestorDatos {
	
	 protected String nomD;
	 protected String nomF;
	 protected File f;
	 private BufferedWriter bw; 
	 private BufferedReader br; 
	 private FileWriter fw;
	 private FileReader fr;
	 private boolean lectura;
	 private boolean escritura;
	 
	 
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
	  public GestorDatos(String nomD2, String nomF2) {
	       br = null;
	       bw = null;
	       fr = null;
	       fw = null;
	       lectura = false;
	       escritura = false;
	       nomD = nomD2;
	       nomF = nomF2;
	       f = new File(nomD2, nomF2);
	    }
	    
	    /**
	     * creadora de un archivo con control de errores
	     * @return true si se ha creado
	     * @throws Exception 
	     */
	    public boolean createFile() throws Exception{
	        if (!f.exists()) {
		    return f.createNewFile();
		}
		return false;
	    }
	    
	    /**
	     * Abre un archivo previamente creado
	     * @param read o write 
	     * @return true si se abre el archivo sin problema 
	     * @throws Exception File, BufferedReader and BufferedWriter IOExceptions
	     */
	    public boolean openFile(String s) throws Exception {
	        if (s == "read" && f.exists()) {
	            fr = new FileReader(f);
	            br = new BufferedReader(fr); 
	            lectura = true;
	            return true;
	        }
	        if (s == "write" && f.exists()) {
	            fw = new FileWriter(f);
	            bw = new BufferedWriter(fw);
	            escritura = true;
	            return true;
	        }
	        return false;
	    }
	    
	    /**
	     * Cerrar el archivo
	     * @return true si se cierra sin problemas
	     * @throws Exception BufferedReader and BufferedWriter exceptions
	     */
	    public boolean closeFile() throws Exception {
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
	     * Elimina el archivo
	     * @return true si se elimina con exito
	     * @throws Exception File exception 
	     */
	    public boolean deleteFile() throws Exception {
	        closeFile();
	        if(f.exists()) {
	            return f.delete();
	        }
	        return false;
	    }
	    
	    /**
	     * 
	     * @param buffer que vamos a escribir dentro del archivo
	     * @return true 
	     * @throws Exception BufferedWriter exception
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
	     * @throws Exception BufferedWriter exception
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
	    
	    /**
	     * lee la linea de un archivo
	     * @return la linea leida
	     * @throws Exception BufferedWrite exception 
	     */
	    public String readLine() throws Exception {
	        if (lectura) {
	            return br.readLine();
	        }
	        return null;
	    }
	}
