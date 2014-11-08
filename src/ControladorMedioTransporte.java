import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
 
/**
 * @author Olga 
 */

public class ControladorMedioTransporte {
	
	//WORK IN PROGRESS --> s'ha de canviar casi tot per TST
	/*private static ControladorAlgoritmo cntrlAl; 
	private static ControladorMapa cntrlMap; */
	//private static Map <String, MedioTransporte> medios =  new HashMap<String,MedioTransporte>(); 
	private TST<MedioTransporte> medios;
	medios = new TST(); 
	private final static int BUFFER_SIZE = 1000; 
	
	//control errors 
	private static Exception NombreYaExiste = new Exception ("El nombre ya existe");
	private static Exception NoExiste = new Exception ("El nombre no existe");
	
	//creadora per defecte
	public ControladorMedioTransporte() 
	{
		medios = new TST(); 
	}
	
	//creadora de controlador 
	/* ControladorMedioTransporte(ControladorAlgoritmo al,ControladorMapa map){
		cntrlAl = al; 
		cntrlMap = map; 	
	}*/
	
	//agregar medio de transporte
	public void agregarMedioTransporte(String nombre, int coste) throws Exception{
		if (!medios.search(nombre)) throw NombreYaExiste; 
		else{
			MedioTransporte m = new MedioTransporte(nombre,coste); 
			medios.put(nombre,m);
		}
	}
	
	//borrar un medio de transporte por nombre
	public void borrarMedioTransporte(String nombre) throws Exception{
		if (!medios.contains(nombre)) throw NoExiste;
		//else medios.delete(nombre); 
		//mirar si s'ha de moure tota l'estructura
	}
	
	//modifica el nombre del medio
	public void modificarNombre(String nNuevo, MedioTransporte m) throws Exception {
		String n = m.getNombre();
		if (!medios.contains(n)) throw NoExiste;
		else if (medios.contains(nNuevo)) throw NombreYaExiste; 
		else {
			int c = m.getPrecio();
			borrarMedioTransporte(n);
			agregarMedioTransporte(nNuevo,c);
		}	
	}
	
	//modifica el precio del medio
		public void modificarPrecio(int pNuevo, MedioTransporte m) throws Exception {
			String n = m.getNombre();
			if (!medios.contains(n)) throw NoExiste;
			else {
				borrarMedioTransporte(n);
				agregarMedioTransporte(n,pNuevo);
			}	
		}
	
	//devuelve el num de transportes que hay en el map 
	public int getCantidadTransportes(){
		return medios.size(); 
	}
	
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
		ArrayList<MedioTransporte> am = //MedioTransporte.inorder();
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
	public void cargar(String path, String filename) throws Exception {
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
	}
}
