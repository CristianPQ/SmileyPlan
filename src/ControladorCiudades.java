import java.util.*;


public class ControladorCiudades {
	
	private TST<Ciudad> ciudades;
	
	public ArrayList<Ciudad> gc;  //array para guardar y cargar

	//Consultar todas los nombres de las ciudades que componen ciudades
	/*
	 * Devuelve un Set con todas las keys de ciudades, en nuestro caso los nombres de las ciudades
	 */
	
	/*
	 * Anadir ciudad al Map ciudades
	 */
	
	public ControladorCiudades() {
		ciudades = new TST<Ciudad>();
	}
	
	
	public void agregarCiudad(Ciudad c) {
		ciudades.insert(c.consultarNombre(),c);
	}
	
	/*
	 * Buscar Ciudad a partir del nombre
	 */
	public Ciudad buscarCiudad(String nombreCiudad) {
		return ciudades.consultar(nombreCiudad);
	}
	
	/*
	 * Consultar coordenadas de una ciudad
	 */
	public Coordenadas getCoordenadasCiudad(String nombreCiudad) {
		Coordenadas coord;
		Ciudad c = buscarCiudad(nombreCiudad);
		coord = c.consultarCoordenadas();
		return coord;
	}
	
	/*
	 * Borrar ciudad
	 */
	public void borrarCiudad(String nombreCiudad) {
		ciudades.delete(nombreCiudad);
	}
	
	
	//True si la ciudad existe
	public boolean existe(String nombreCiudad) {
		return ciudades.existe(nombreCiudad);
	}
	
	public String escribir() {
		return ciudades.toString();
	}
	
	public void vaciar() {
		ciudades.makeEmpty();
	}
	
	public boolean isEmpty() {
		return ciudades.isEmpty();
	}
	
	public ArrayList<String> consultar() {
		return ciudades.consultar();
	}
	
	public int numero() {
		return ciudades.numero();
	}
	
	/*
	 * Consultar numero de ciudades existentes en el Map ciudades
	 
	public int numeroCiudades() {
		return this.ciudades.size();
	}*/

    /**
  	 * Cargar 
  	 * @param path donde esta el archivo
  	 * @param file donde esta la informacion que queremos cargar
  	 * @throws Exception si el fichero esta vacio 
  	 */
  	public void Cargar(String path, String file) throws Exception{
  		
  		GestorDatosCiudad ga = new GestorDatosCiudad(); 
  		gc = ga.cargarCiudades(path,file); 
  		
  		 for(int i = 0; i < gc.size(); ++i ){
  			 Ciudad aux = gc.get(i); 
  			 agregarCiudad(aux); 
  		 }	
  	}
  	
  	/**
  	 * Guarda las ciudades
  	 * @param path donde vamos a guardar el arhivo
  	 * @param file donde vamos a guardar la informacion
  	 * @Exception al crear archivo 
  	 */
  	public void Guardar(String path, String file) throws Exception {
  		gc = new ArrayList<Ciudad>();
  		ArrayList<String> lista = new ArrayList<String>();
  		lista = ciudades.consultar(); //obtenim un array ordenada amb els ident de TST
  		for(int i = 0; i < lista.size(); ++i){
  			String s = lista.get(i); //obtenim el primer nom
  			Ciudad aux = ciudades.consultar(s); 
  			gc.add(aux); //ho passem a l'array 
  		}
  		GestorDatosCiudad gestor = new GestorDatosCiudad();
  		
  		gestor.guardarCiudades(path,file,gc); 
  	}
	

}
