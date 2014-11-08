import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/**
 * @author Olga 
 */

public class GestorDatos {
	 private String nomD;
	 private String nomF;
	 private File f;
	 private BufferedWriter bw; //Mantiene buffer de 8KB
	 private BufferedReader br; //Mantiene buffer de 8KB
	 private FileWriter fw;
	 private FileReader fr;
	 private boolean lectura;
	 private boolean escritura;
	 private final static int BUFF_SIZE = 1000;
	    
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
	     * @return true if created, otherwise false
	     * @throws Exception File IOException
	     */
	    public boolean createFile() throws Exception{
	        if (!f.exists()) {
		    return f.createNewFile();
		}
		return false;
	    }
	    
	    /**
	     * Abre un archivo previamente creado
	     * @param read true for read, false for write
	     * @return true if opened, otherwise false
	     * @throws Exception File, BufferedReader and BufferedWriter IOExceptions
	     */
	    public boolean openFile(boolean read) throws Exception {
	        if (read && f.exists() && !lectura) {
	            fr = new FileReader(f);
	            br = new BufferedReader(fr); 
	            lectura = true;
	            return true;
	        }
	        if (!read && f.exists() && !escritura) {
	            fw = new FileWriter(f);
	            bw = new BufferedWriter(fw);
	            escritura = true;
	            return true;
	        }
	        return false;
	    }
	    
	    /**
	     * Closes file
	     * @return true if closed, otherwise false
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
	     * deletes file
	     * @return true if deleted, otherwise false
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
	     * @param buffer stream to write into file
	     * @return true if written, otherwise false
	     * @throws Exception BufferedWriter exception
	     */
	    public boolean writeBuffer(String buffer) throws Exception {
	        if (escritura) {
	            bw.write(buffer);
	            //bw.newLine();
	            return true;
	        }
	        return false;
	    }
	    
	    /**
	     * read stream of a file
	     * @param numLines lines to be read
	     * @return stream read
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
	     * read a line of a file
	     * @return line read
	     * @throws Exception BufferedWrite exception 
	     */
	    public String readLine() throws Exception {
	        if (lectura) {
	            return br.readLine();
	        }
	        return null;
	    }
	}
