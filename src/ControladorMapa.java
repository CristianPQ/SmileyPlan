import java.util.*;

public class ControladorMapa {

	private Mapa m;
	
	private static Exception NoExiste = new Exception ("Este elemento no existe");
	
	public ControladorMapa(int anchuraX, int alturaY, Coordenadas[] continente) throws Exception {
		m = new Mapa(anchuraX, alturaY, continente);
	}
	
	
	//#########################################
	//##########SOBRE CIUDADES
	//#########################################
	
	public void agregarCiudad(String nCiudad, int x, int y) throws Exception {
		Coordenadas coord = new Coordenadas(x,y);
		Ciudad c = new Ciudad(nCiudad, coord);
		m.agregarCiudad(c);
	}
	
	public void eliminarCiudad(String c) throws Exception {
		m.eliminarCiudad(c);
	}
	
	public Ciudad consultarCiudad(String c) throws Exception {
		return m.consultarCiudad(c);
	}
	
	public ArrayList<String> listarCiudades() throws Exception{
		return m.listarCiudades();
	}
	
	//#########################################
	//##########SOBRE CAMINOS
	//#########################################
	
	public void agregarCamino(String cOrig, String cDest, String medio, int cap, ControladorMedioTransporte contMT) throws Exception {
		
		//Comprobar que el medioTransporte ya existe
		if(!contMT.existe(medio)) throw NoExiste;
		Camino c = new Camino(cOrig, cDest, cap, medio);
		m.agregarCamino(c);
	}
	
	public Camino consultarCamino(String cOrig, String cDest, String med) throws Exception {
		return m.consultarCamino(cOrig, cDest, med);
	}
	
	//A partir de una ciudad origen se devuelven los identificadores de las ciudades que se pueden alcanzar
	public ArrayList<Camino> consultarCiudadesDestino(String cOrig) {
		return m.consultarCiudadesDestino(cOrig);
	}
	
	//#########################################
	//##########Gestion de datos
	//#########################################
	
	/**
	 * Guardar caminos del mapa
	 * @param path
	 * @param file
	 * @throws Exception
	 */
	public void GuardarCaminos(String path,String file) throws Exception{
		GestorDatos gd = new GestorDatos(path,file); 
		m.GuardarCaminos(gd);
	}
	
	/**
	 * Guardar ciudades del mapa
	 * @param path
	 * @param file
	 * @throws Exception
	 */
	public void GuardarCiudades(String path,String file) throws Exception{
		GestorDatos gd = new GestorDatos(path,file); 
		m.GuardarCiudades(gd);
	}
	
	/**
	 * Cargar ciudades del mapa
	 * @param path
	 * @param file
	 * @throws Exception
	 */
	public void CargarCiudades(String path,String file) throws Exception {
		GestorDatos gd = new GestorDatos(path,file); 
		m.CargarCiudades(gd);
	}
	
	/**
	 * Cargar caminos del mapa
	 * @param path
	 * @param file
	 * @throws Exception
	 */
	public void CargarCaminos(String path, String file) throws Exception {
		GestorDatos gd = new GestorDatos(path,file); 
		m.CargarCaminos(gd); 
	}

	
}
