import java.util.*;
import java.io.*;

public class GestorDatosMedioTransporte extends GestorDatos{
	
	
	/**
	 * Constructora por defecto
	 */
	public GestorDatosMedioTransporte(){
		super(); 
	}
	
	/**
	 * Constructora del gestor de datos de los medios de transporte
	 * @param nomD2 nombre del directorio
	 * @param nomF2 nombre del archivo
	 */
	public GestorDatosMedioTransporte(String nomD2, String nomF2){
		super(nomD2,nomF2); 	
	}
	
	/**
	 * Guardar datos en el fichero filename ubicado en path 
	 * @param path, donde se ubica el fichero
	 * @param filename, nombre que queremos dar al fichero
	 * @throws Exception
	 */
	public void guardarMediosTransporte(String path, String filename, ArrayList<MedioTransporte> listamed) throws Exception {
		
		String fn = "CAT".concat(filename); 
		GestorDatosMedioTransporte gd = new GestorDatosMedioTransporte(path, filename); 
		gd.createFile();
		gd.openFile("write");
		
		String buffer = null; 
		String linea; 
		
		
		int numMeds = listamed.size(); 
		
		linea = Integer.toString(numMeds) + "\n"; 
		buffer = linea; 
		
		for(MedioTransporte m: listamed) {
			linea = m.getNombre() + " " + m.getPrecio();
			//per comprovar: System.out.println( m.getNombre() + m.getPrecio() + "\n");
			buffer = buffer + linea + "\n"; 
			
			if (buffer.length() > BUFF_SIZE) {
				gd.writeBuffer(buffer); 
				buffer = null; 
			}
		}
		
		if (buffer != null) {
			gd.writeBuffer(buffer); 
		}
		
		gd.closeFile(); 
	}
	
	
	/**
	 * Cargar Medios de transporte de un archivo
	 * @param path
	 * @param filename
	 * @throws Exception
	 */
	public ArrayList<MedioTransporte> cargarMediosTransporte(String path, String filename) throws Exception {
		
		//creem el conjunt de medios per poderlos guardar
		//ControladorMedioTransporte newmedios = new ControladorMedioTransporte();
		ArrayList<MedioTransporte> newmedios = new ArrayList<MedioTransporte>(); 
		//obrim nou gestor dades 
		GestorDatosMedioTransporte gd = new GestorDatosMedioTransporte(path, filename); 
		//creem nou fitxer dins gestor dades
		gd.createFile();
		//preparem aquest fitxer perque sigui lectura 
		gd.openFile("read");
		String buff; 
				
		int i = 0;

		//mirem el numero de caracters de la linia
		int numMeds = Integer.parseInt(gd.readLine());

		//si hi ha 0 caracters es que esta buit
		if ((buff = gd.readBuffer(numMeds)) == null) {
			throw new Exception("fichero vacio"); 
		}
		
		//cada conjunt d'string entre "\n" es un medio transporte
		String[] lineas = buff.split("\n"); 

		while (i < numMeds) {
			//cada string entre " " es un parametre
			//System.out.println(lineas[i]+ "\n");
			String[] cortarstring = lineas[i].split(" "); 
			MedioTransporte mt = new MedioTransporte(); 
			mt.setNombre(cortarstring[0]);
			//per test //////////////
			//String s = cortarstring[0]; 
			//int o = Integer.parseInt(cortarstring[1]); 
			//System.out.println("he guardat:" + s + " " + o + "\n");
			// per test //////////
			mt.setPrecio(Integer.parseInt(cortarstring[1]));
			//agrega el nombre que es ya un string y luego el entero que es el precio
			newmedios.add(mt); 
			i++; 
		}
		gd.closeFile(); 
		return newmedios; 		

	}
}



	
	
	
	
	
	


