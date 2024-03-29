import java.util.ArrayList;
 
/**
 * @author olgacarbo 
 */

public class ControladorMedioTransporte {
	
	 
	private TST<MedioTransporte> medios;	
	
	private final static int BUFFER_SIZE = 3250; //aprox 250 elem
	private int CARGA_MAX = 250; 
	public String buffer = null; 
	
	//control errores 
	private static Exception NombreYaExiste = new Exception ("El nombre ya existe");
	private static Exception NoExiste = new Exception ("El nombre no existe");
	private static Exception Negativo = new Exception("El valor no puede ser negativo"); 
	
	/**
	 * Controladora por defecto
	 */
	public ControladorMedioTransporte() 
	{
		medios = new TST<MedioTransporte>(); 	 
	}
	
	
	
	/**
	 * Agregar un medio de transporte
	 * @param nombre del medio de transporte
	 * @param coste por kilometro del medio de transporte
	 * @throws Exception si el medio con dicho nombre ya existe
	 */
	public void agregarMedioTransporte(String nombre, int coste) throws Exception{
		if (medios.existe(nombre)) throw NombreYaExiste;
		else if (coste < 0) throw Negativo; 
		else{
			MedioTransporte m = new MedioTransporte(nombre,coste); 
			medios.insert(nombre,m);
		}
	}
	
	/**
	 * Agregar un coche
	 * @param nombre del coche
	 * @param coste por kilometro del coche
	 * @throws Exception si existe un medio con dicho nombre
	 */
	public void agregarCoche(String nombre, int coste) throws Exception {
		if (medios.existe(nombre)) throw NombreYaExiste;
		else{
			Coche m = new Coche(nombre,coste); 
			medios.insert(nombre,m);
		}
	}
	
	/**
	 * Agregar un tren
	 * @param nombre del tren
	 * @param coste por kilometro del tren
	 * @throws Exception si existe un medio con dicho nombre
	 */
	public void agregarTren(String nombre, int coste) throws Exception {
		if (medios.existe(nombre)) throw NombreYaExiste;
		else{
			Tren m = new Tren(nombre,coste); 
			medios.insert(nombre,m);
		}
	}
	
	public int consultarCoste(String nombre){
		MedioTransporte mt =  medios.consultar(nombre);
		return mt.getPrecio();
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
	public void modificarNombre(String nNuevo, String n) throws Exception {
		if (!medios.existe(n)) throw NoExiste;
		else if (medios.existe(nNuevo)) throw NombreYaExiste; 
		else {
			MedioTransporte aux = buscarMedio(n);
			//medios.modificar(nNuevo, aux);
			int c = aux.getPrecio(); 
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
	public void modificarPrecio(int pNuevo, String ident) throws Exception {
		if (!medios.existe(ident)) throw NoExiste;
		else {
			borrarMedioTransporte(ident);
			agregarMedioTransporte(ident,pNuevo);
		}	
	}
	
	/**
	 * Devuelve un medio de transporte del conjunto medios a partir de su identificador
	 * @param ident del medio que queremos obtener
	 * @return el medio con el nombre ident
	 */
	public MedioTransporte buscarMedio(String ident) {
		return medios.consultar(ident); //funcio TST que retorna lobjecte
	}
	
	/**
	 * Devuelve el numero de transportes
	 */
	public int getCantidadTransportes(){
		return medios.numero(); 
	}
	
	/**
	 * Devuelve el precio del medio de transporte cuyo nombre pasamos como parametro
	 * @param ident
	 * @return precio del medio de transporte ident
	 * @throws Exception
	 */
	public int getPrecioTransporte(String ident) throws Exception {
		if(!medios.existe(ident)) throw NoExiste; 
		else return medios.consultar(ident).getPrecio();
	}
	
	/**
	 * Mira si existe un medio de transporte
	 * @param ident
	 * @return true si existe, false si no
	 */
	public boolean existe(String ident){
		if(medios.existe(ident)) return true; 
		return false;
	}
	
	/**
	 * Funcion que devuelve true si el medio es un tren
	 * y false si es un coche
	 * @param ident
	 * @return true si es tren, false si es coche
	 */
	public boolean esTren(String ident) {
		return (medios.consultar(ident)).esTren(); 
	}
	
	/**
	 * Nombre medios en string
	 * @return String con todos los nombres de los medios
	 */
	public String NombresMedios(){
		ArrayList<String> nombres = medios.consultar();
		String buff = null;
		if(nombres.isEmpty()) return buff;
		String linea = nombres.get(0) +' ';
		buff =linea;
		for (int i = 1; i < nombres.size(); ++i) {
			linea = nombres.get(i) + ' ';
			buff = buff + linea;
		}
		return buff;
		
	}	
	
	/**
	 * Guardar datos en el fichero filename ubicado en path 
	 * @param path donde vamos a guardar el arhivo
	 * @param file donde vamos a guardar la informacion
	 * @Exception al crear archivo 
	 */
	public void Guardar(String file) throws Exception {
		
		GestorDatos gd = new GestorDatos(file);

		gd.abrirArchivo("write"); 
		
		ArrayList<String> lista = new ArrayList<String>();
		lista = medios.consultar(); //obtenim un array ordenada amb els ident de TST
		
		String s = lista.get(0); 
		MedioTransporte aux = medios.consultar(s); 
		String linea = aux.getNombre() + " " + aux.getPrecio() + " " +  aux.esTren();
		buffer = linea + "\n"; 

		for(int i = 1; i < lista.size(); ++i){
			s = lista.get(i); 
			aux = medios.consultar(s); 
			linea = aux.getNombre() + " " + aux.getPrecio() + " " + aux.esTren(); 
			buffer = buffer + linea + "\n"; 
			
			if(buffer.length() > BUFFER_SIZE) {
				gd.writeBuffer(buffer); 
				buffer = null; 
			}
		}
		
		if(buffer != null) {
			gd.writeBuffer(buffer);
		}
		
		gd.cerrarArchivo(); 
	}

	
	
	/**
	 * Convierte el string a medios de transporte
	 * @param carga
	 * @throws Exception si el medio ya existe
	 */
	public void ConvertirGuardados(String[] l) throws Exception {
		int total = l.length; 
		//System.out.println("carga.size " + l.length);
		for(int i = 0; i < total; ++i) {
			//guardo el primer string i el tallo en petits strings separats per " "
			String[] cortarstring = l[i].split(" "); 
			String nombre = cortarstring[0];
			int Precio = Integer.parseInt(cortarstring[1]);
			boolean t = Boolean.valueOf(cortarstring[2]); 
			/////////////per comprovar ////////////////
			//System.out.println("he carregat medio " + i); 
			//System.out.println(nombre + " " + Precio + " " + t); 
			/////////////////////////////////////////////
			if(t) agregarTren(nombre,Precio); 
			else agregarCoche(nombre,Precio); 
			//agregarMedioTransporte(nombre,Precio);
			//System.out.println("medio agregat");
		}
	}
	
	/**
	 * Cargar medios de transporte
	 * @param path donde esta el archivo
	 * @param file donde esta la informacion que queremos cargar
	 * @throws Exception si el fichero esta vacio 
	 */
	public boolean Cargar(String file) throws Exception{
		String carga; 
		GestorDatos gd = new GestorDatos(file); 
		
		gd.abrirArchivo("read"); 
		int num = gd.bufferToStrings(); 
		//System.out.println("numero de strings " + num);

		if (num <= CARGA_MAX) {
			carga = gd.obtenerTodoElString(); 
			/////prova///
			//System.out.println(carga);
			String[] l = carga.split("\n"); 
			ConvertirGuardados(l); 
		}
		else {
			while(num >= CARGA_MAX){
				num = num - CARGA_MAX; 
				carga = gd.obtenerStrings(CARGA_MAX);
				String[] l = carga.split("\n"); 
				ConvertirGuardados(l);  
			}
			if(num != 0) { //si queden restes
				//System.out.println("restes");
				carga = gd.obtenerStrings(num); 
				String[] l = carga.split("\n"); 
				ConvertirGuardados(l); 
			}
		}
		//System.out.println("he acabat de guardar");
		gd.cerrarArchivo(); 
		return true; 
	}
}
