import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
 
/**
 * @author olgacarbo 
 */

public class ControladorMedioTransporte {
	
	//WORK IN PROGRESS --> millorar els metodes per guardar i fer size
	
	 
	private TST<MedioTransporte> medios;	
	private final static int BUFFER_SIZE = 1000; 
	private ArrayList<MedioTransporte> mt; 
	
	//control errores 
	private static Exception NombreYaExiste = new Exception ("El nombre ya existe");
	private static Exception NoExiste = new Exception ("El nombre no existe");
	
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
		else{
			//System.out.println("Nombre bueno\n");
			MedioTransporte m = new MedioTransporte(nombre,coste); 
			medios.insert(nombre,m);
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
	public void modificarNombre(String nNuevo, String n) throws Exception {
		if (!medios.existe(n)) throw NoExiste;
		else if (medios.existe(nNuevo)) throw NombreYaExiste; 
		else {
			MedioTransporte aux = buscarMedio(n);
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
	 * Cargar medios de transporte
	 * @param path donde esta el archivo
	 * @param file donde esta la informacion que queremos cargar
	 * @throws Exception si el fichero esta vacio 
	 */
	public void Cargar(String path, String file) throws Exception{
		
		GestorDatosMedioTransporte gd = new GestorDatosMedioTransporte(); 
		 
		mt = gd.cargarMediosTransporte(path,file); 
		//cargar medios retorna una array amb tots els medios nous
		 
		 for(int i = 0; i < mt.size(); ++i ){
			 String n = mt.get(i).getNombre(); 
			 int p = mt.get(i).getPrecio(); 
			 agregarMedioTransporte(n,p); 
		 }	
	}
	
	public void Guardar(String path, String file) {
		mt = new ArrayList<MedioTransporte>();
		MedioTransporte aux = null; 
		
		mt.add(aux); 
		
	}
	

	
}