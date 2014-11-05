import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class GestorDatos {
	private File file; 
	private String mode; 
	private boolean open; 
	
	private Scanner scanner; 
	private FileWriter filewriter;
	
	public void GestorDatos() {
		open = false; 
	}
	
	/* abre un nuevo archivo 
	 * R = Read, W = Write 
	 * 
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
		if (!open) throw new Exception ("No hay archivos abiertos");
		scanner.close();
    	if (mode.equals("W")) filewriter.close();
    	open = false;
	}
	
	/*
     * Cargar lineas de informacio en un archivo
     * Pre: tiene que haber un archivo abierto
     */
    public String[] cargarLineas(int n) throws Exception{ 
        
        if (!open) throw new Exception ("No hay archivos abiertos");
        
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
     * Guardar lineas de informacio en un archivo
     * Pre: el archivo debe ser modo W
     */
    public void guardarLineas(String[] lineas) throws Exception{   
        
        if (!open) throw new Exception ("No hay archivos abiertos");
        if (!mode.equals("W")) throw new Exception("No se puede escribir en modo lectura");
        
        for (int i = 0; i < lineas.length; ++i) {
            filewriter.write(lineas[i]+"\n");
        } 
    } 
	
	
}
	

