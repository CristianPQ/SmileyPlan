import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
 
/**
 * @author Olga 
 */

public class ControladorMedioTransporte {
	
	//WORK IN PROGRESS --> millorar els metodes per guardar i fer size
	
	 
	private TST<MedioTransporte> medios;	//Aqui no es fa el new... es fa al metode constructor
	private final static int BUFFER_SIZE = 1000; 
	
	//control errores 
	private static Exception NombreYaExiste = new Exception ("El nombre ya existe");
	private static Exception NoExiste = new Exception ("El nombre no existe");
	
	/**
	 * Controladora por defecto
	 */
	public ControladorMedioTransporte() 
	{
		medios = new TST<MedioTransporte>(); 	//només aquí cal el new...
	}
	
	
	/**
	 * Agregar un medio de transporte
	 * @param nombre del medio de transporte
	 * @param coste por kilometro del medio de transporte
	 * @throws Exception si el medio con dicho nombre ya existe
	 */
	public void agregarMedioTransporte(String nombre, int coste) throws Exception{
		if (medios.existe(nombre)) throw NombreYaExiste;
		else{
			System.out.println("Nombre bueno\n");
			MedioTransporte m = new MedioTransporte(nombre,coste); 
			medios.insert(m);
		}
	}
	
	/**
	 * Borrar un medio de transporte por nombre
	 * @param nombre del medio que se quiere borrar
	 * @throws Exception si no existe dicho nombre
	 */
	public void borrarMedioTransporte(String nombre) throws Exception{
		if (!medios.existe(nombre)) throw NoExiste;
		else medios.delete(nombre); 
	}
	
	/**
	 * Modificadora de nombre
	 * @param nNuevo nombre nuevo
	 * @param m medio que queremos modificar
	 * @throws Exception si el nombre ya existe o no existe el medio
	 */
	/*
	 * no acabo de entendre perque has de pasar-li el parametre MedioTransporte
	 * si de cas l'identificador, que seria el nom actual
	 * les altres clases no tindran mediosTransporte, tindran si de cas el seu identificador
	 * com es el cas del cami
	 */
	public void modificarNombre(String nNuevo, MedioTransporte m) throws Exception {
		String n = m.getNombre();
		if (!medios.existe(n)) throw NoExiste;
		else if (medios.existe(nNuevo)) throw NombreYaExiste; 
		else {
			int c = m.getPrecio();
			borrarMedioTransporte(n);
			agregarMedioTransporte(nNuevo,c);
		}	
	}
	
	/**
	 * Modificadora del precio 
	 * @param pNuevo precio nuevo que queremos asignar
	 * @param m medio de transporte que queremos modificar
	 * @throws Exception si no existe el medio de transporte
	 */
	/*
	 * igual que a l'anterior metodo, en lloc de medioTransporte
	 * s'hauria de demanar el nombre
	 */
	public void modificarPrecio(int pNuevo, MedioTransporte m) throws Exception {
		String n = m.getNombre();
		if (!medios.existe(n)) throw NoExiste;
		else {
			borrarMedioTransporte(n);
			agregarMedioTransporte(n,pNuevo);
		}	
	}
	
	/*devuelve el num de transportes que hay en el map 
	public int getCantidadTransportes(){
		return medios.size(); 
	}*/
	
	/**
	 * Guardar datos en el fichero filename ubicado en path 
	 * @param path, donde se ubica el fichero
	 * @param filename, nombre que queremos dar al fichero
	 * @throws Exception
	 */
	public void guardar(String path, String filename) throws Exception {
		
		String fn = "CAT".concat(filename); 
		GestorDatos gd = null; 
		gd = new GestorDatos(path, fn); 
		gd.createFile();
		gd.openFile(false);
		
		String buffer = null; 
		String linea; 
		/*ArrayList<MedioTransporte> am// = //MedioTransporte.inorder();
		//int numMeds = am.size(); 
		//linea = Integer.toString(numMeds) + "\n"; 
		//buffer = linea; 
		for(MedioTransporte m: am) {
			linea = m.getNombre() + "" + m.getPrecio();
			buffer = buffer + linea + "\n"; 
			if (buffer.length() > BUFFER_SIZE) {
				gd.writeBuffer(buffer); 
				buffer = null; 
			}
		}*/
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
	/*public void cargar(String path, String filename) throws Exception {
		newmedios = new TST<MedioTransporte>();
		
		GestorDatos gd = null; 
		gd = new GestorDatos(path, filename); 
		gd.createFile();
		gd.openFile(false);
		
		int i = 0, j = 0; 
		int numMeds = 0; 
		String buffer; 
		String[] params; 
		String lineas[] = null; 
		numMeds = Integer.parseInt(gd.readLine());
		//ArrayList<Integer> temp = new ArrayList<Integer>(numMeds); 
		if (buffer = gd.readBuffer(numMeds) == null) {
			throw new Exception("nada que leer al cargar"); 
		}
		lineas = buffer.split("\n"); 
		while (i < numMeds) {
			params = lineas[i].split(" "); 
			//agrega el nombre que es ya un string y luego el entero que es el precio
			newmedios.agregarMedioTransporte(params[0],Integer.parseInt(params[1]));
			i++; 
		}
		if ((buffer = gd.readBuffer(numMeds)) == null) {
			return; 
		}
		gd.closeFile(); 
	}*/
}
