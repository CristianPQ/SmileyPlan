import java.util.*;
import java.io.*;

public class GestorDatosAgente extends GestorDatos {
	

	/**
	 * Constructora por defecto
	 */
	public GestorDatosAgente() {
		super();
	}
	
	/**
	 * Constructora del gestor de datos de los agentes
	 * @param nomD2 nombre del directorio
	 * @param nomF2 nombre del archivo
	 */
	public GestorDatosAgente(String nomD2, String nomF2){
		super(nomD2,nomF2); 
	}
	
	/**
	 * Guardar datos en el fichero filename ubicado en path 
	 * @param path, donde se ubica el fichero
	 * @param filename, nombre que queremos dar al fichero
	 * @throws Exception
	 */
	public void guardarAgentes(String path, String filename, ArrayList<Agente> lista) throws Exception {
		
		String fn = "CAT".concat(filename); 
		GestorDatosAgente ga = new GestorDatosAgente(path, filename); 
		ga.createFile();
		ga.openFile("write");
		
		String buffer = null; 
		String linea; 
		
		
		int numMeds = lista.size(); 
		
		linea = Integer.toString(numMeds) + "\n"; 
		buffer = linea; 
		
		for(Agente a: lista) {
			linea = a.consultarNombre() + " " + a.consultarCiudadInicial() + "" + a.consultarCiudadObjetivo();
			buffer = buffer + linea + "\n"; 
			
			if (buffer.length() > BUFF_SIZE) {
				ga.writeBuffer(buffer); 
				buffer = null; 
			}
		}
		
		if (buffer != null) {
			ga.writeBuffer(buffer); 
		}
		
		ga.closeFile(); 
	}
	
	/**
	 * CargarAgentes de un archivo
	 * @param path
	 * @param filename
	 * @throws Exception
	 */
	public ArrayList<Agente> cargarAgente(String path, String filename) throws Exception {
		
		ArrayList<Agente> newag = new ArrayList<Agente>(); 
		
		//obrim nou gestor dades 
		GestorDatosAgente ga = new GestorDatosAgente(path, filename); 
		//creem nou fitxer dins gestor dades
		ga.createFile();
		//preparem aquest fitxer perque sigui lectura 
		ga.openFile("read");
		String buff; 
				
		int i = 0;
		
		//mirem el numero de caracters de la linia
		int numMeds = Integer.parseInt(ga.readLine());
		
		//si hi ha 0 caracters es que esta buit
		if ((buff = ga.readBuffer(numMeds)) == null) {
			throw new Exception("fichero vacio"); 
		}
		
		
		//cada conjunt d'string entre "\n" es un agente
		String[] lineas = buff.split("\n"); 
		
		while (i < numMeds) {
			//cada string entre " " es un parametre
			String[] cortarstring = lineas[i].split(" "); 
			Agente a = new Agente(cortarstring[0],cortarstring[1],cortarstring[2]);  
			newag.add(a); 
			i++; 
		}
	
		ga.closeFile(); 
		return newag; 		
	}
}
	
	


