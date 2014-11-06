import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
 * @author Olga 
 */

public class GestorDatos {
	private File file; 
	private String mode; 
	private boolean open; 
	
	private Scanner scanner; 
	private FileWriter filewriter;
	
	public void GestorDatos() {
		open = false; 
	}
	
	/* 
	 * abre un nuevo fichero 
	 * @param String filename, nombre del fichero que abrimos 
	 * @param String mode, modo del fichero, puede ser R = read o W = Write 
	 */
	public void openFile(String filename, String mode) throws Exception {        
	        if (!mode.equals("R") && !mode.equals("W")) throw new Exception("Modo invalido en el Gestor de Datos");
	        file = new File(filename);
	        this.mode = mode;
	  
	        if (mode.equals("W")) {
	            if (!file.exists()) file.createNewFile();
	            filewriter = new FileWriter(file);
	        }	        
	        scanner = new Scanner(new FileReader(file));
	        open = true;
	}
	
	public void closeFile() throws Exception {
		if (!open) throw new Exception ("No hay ficheros abiertos");
		scanner.close();
    	if (mode.equals("W")) filewriter.close();
    	open = false;
	}
	
	/*
     * Cargar lineas de informacio en un fichero
     * Pre: tiene que haber un afichero abierto
     * @param int n, numero de lineas que vamos a cargar 
     * @return lineas
     */
    public String[] cargarLineas(int n) throws Exception{ 
        
        if (!open) throw new Exception ("No hay ficheros abiertos");
        
        String[] lineas = new String[n];
        int index = 0;

        while(index < n && scanner.hasNextLine()) {
            lineas[index] = scanner.nextLine();
            ++index;
        }
        
        if (index < n){
            String[] aux = new String[index];
            for (int i = 0; i < index; ++i) {
                aux[i] = lineas[i];
            }
            return aux;
        }        
        return lineas;
    }
    
    /*
     * Guardar lineas de informacio en un fichero
     * Pre: el archivo debe ser modo W
     * @param @String[] lineas, lineas que queremos guardar 
     */
    public void guardarLineas(String[] lineas) throws Exception{   
        
        if (!open) throw new Exception ("No hay ficheros abiertos");
        if (!mode.equals("W")) throw new Exception("No se puede escribir en modo lectura");
        
        for (int i = 0; i < lineas.length; ++i) {
            filewriter.write(lineas[i]+"\n");
        } 
    } 
	
	
}
	

