import java.util.*;
import java.io.*;

public class GestorDatosCiudad extends GestorDatos {

	/**
	 * Constructora por defecto
	 */
	public GestorDatosCiudad() {
		super();
	}
	
	/**
	 * Constructora del gestor de datos de las ciudades
	 * @param nomD2 nombre del directorio
	 * @param nomF2 nombre del archivo
	 */
	public GestorDatosCiudad(String nomD2, String nomF2){
		super(nomD2,nomF2); 
	}
	
	/**
	 * Guardar datos en el fichero filename ubicado en path 
	 * @param path, donde se ubica el fichero
	 * @param filename, nombre que queremos dar al fichero
	 * @throws Exception
	 */
	public void guardarCiudades(String path, String filename, ArrayList<Ciudad> lista) throws Exception {
		
		String fn = "CAT".concat(filename); 
		GestorDatosCiudad ci = new GestorDatosCiudad(path, filename); 
		ci.createFile();
		ci.openFile("write");
		
		String buffer = null; 
		String linea; 
		
		
		int numMeds = lista.size(); 
		
		linea = Integer.toString(numMeds) + "\n"; 
		buffer = linea; 
		
		for(Ciudad c: lista) {
			linea = c.consultarNombre() + "" + (c.consultarCoordenadas()).consultarX() + "" + (c.consultarCoordenadas()).consultarY();
			buffer = buffer + linea + "\n"; 
			
			if (buffer.length() > BUFF_SIZE) {
				ci.writeBuffer(buffer); 
				buffer = null; 
			}
		}
		
		if (buffer != null) {
			ci.writeBuffer(buffer); 
		}
		
		ci.closeFile(); 
	}
	
	/**
	 * CargarAgentes de un archivo
	 * @param path
	 * @param filename
	 * @throws Exception
	 */
	public ArrayList<Ciudad> cargarAgente(String path, String filename) throws Exception {
		
		ArrayList<Ciudad> newci = new ArrayList<Ciudad>(); 
		
		//obrim nou gestor dades 
		GestorDatosCiudad ci = new GestorDatosCiudad(path, filename); 
		//creem nou fitxer dins gestor dades
		ci.createFile();
		//preparem aquest fitxer perque sigui lectura 
		ci.openFile("read");
		String buff; 
				
		int i = 0;
		
		//mirem el numero de caracters de la linia
		int numMeds = Integer.parseInt(ci.readLine());
		
		//si hi ha 0 caracters es que esta buit
		if ((buff = ci.readBuffer(numMeds)) == null) {
			throw new Exception("fichero vacio"); 
		}
		
		
		//cada conjunt d'string entre "\n" es un agente
		String[] lineas = buff.split("\n"); 
		
		while (i < numMeds) {
			//cada string entre " " es un parametre
			String[] cortarstring = lineas[i].split(" "); 
			String nombreciudad = cortarstring[0]; 
			int X = Integer.parseInt(cortarstring[1]);
			int Y = Integer.parseInt(cortarstring[2]);
			Coordenadas co = new Coordenadas(X,Y);
			Ciudad c = new Ciudad(nombreciudad, co);
			newci.add(c); 
			i++; 
		}
	
		ci.closeFile(); 
		return newci; 		
	}	
	
}
