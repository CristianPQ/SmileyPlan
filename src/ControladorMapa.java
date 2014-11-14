import java.util.*;

public class ControladorMapa {

	private Mapa m;
	private final static int BUFFER_SIZE = 1000;
	
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
	
	/*
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
	
	
	public void Guardar(String path, String file) throws Exception {
		mt = new ArrayList<MedioTransporte>();
		ArrayList<String> lista = new ArrayList<String>();
		lista = medios.consultar(); //obtenim un array ordenada amb els ident de TST
		for(int i = 0; i < lista.size(); ++i){
			String s = lista.get(i); 
			MedioTransporte aux = medios.consultar(s); 
			mt.add(aux); //ho passem a l'array de medios de transporte
		}
		GestorDatosMedioTransporte gd = new GestorDatosMedioTransporte();
		//System.out.println("He guardat l'array amb el que vull carregar\n");
		gd.guardarMediosTransporte(path,file,mt); 
	}
	*/
	
}
