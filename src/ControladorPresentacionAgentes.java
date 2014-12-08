import java.util.*;
import javax.swing.*;

public class ControladorPresentacionAgentes{
	private static ControladorAgentes ca;
	private static VistaAgentes vistaAg;
	private static ControladorMapa mapa;

	
	public ControladorPresentacionAgentes( ControladorPresentacionMapa cpmapa){
		ca = new ControladorAgentes();
		vistaAg = new VistaAgentes(this);

		
	}
	
	public void agregarAgente (String n, String ciuIni, String ciuObj) 
			{
				try {
					ca.anadirAgente(n, ciuIni, ciuObj, mapa);
					
				} catch (Exception e) {
					vistaAg.setError(e.getMessage());
				}
			}
	
	public void modificarNombre(String antiguo, String nuevo) {
		try {
			ca.modificarNombreAgente(antiguo, nuevo);
		} catch (Exception e) {
			vistaAg.setError(e.getMessage());
		}
		
	}
	
	public String consultarCiudadInicial(String n){
		try {
			return ca.consultarCiudadInicialAgente(n);
		} catch (Exception e) {
			vistaAg.setError(e.getMessage());
		}
		return null; //No se que devolver, aunque tampoco importa porque no deberia saltar
	}
	
	public String consultarCiudadObjetivo(String n){
		try {
			return ca.consultarCiudadObjetivoAgente(n);
		} catch (Exception e) {
			vistaAg.setError(e.getMessage());
		}
		return null;  //No se que devolver, aunque tampoco importa porque no deberia saltar
	}

	
	public void modificarCiudadInicial(String n, String ciuIni) {
		try {
			ca.modificarCiudadInicialAgente(n, ciuIni);
		} catch (Exception e) {
			vistaAg.setError(e.getMessage());
		}
	}
	
	public void modificarCiudadObjetivo (String n, String ciuObj){
		try {
			ca.modificarCiudadObjetivoAgente(n, ciuObj);
		} catch (Exception e) {
			vistaAg.setError(e.getMessage());

		}
	}

	public void eliminarAgente(String n){
		try {
			ca.eliminarAgente(n);
		} catch (Exception e) {
			vistaAg.setError(e.getMessage());

		}
	}
	
	public ArrayList<String> listarAgentes(){
		
		String nombres = ca.NombresAgentes();
		ArrayList<String> ret = new ArrayList<String>();
		if(nombres == null) return ret;
		int i = 0;
		String nom;
		while (i < nombres.length()){
			nom = "";
			nom += nombres.charAt(i);
			++i;
			while (nombres.charAt(i) != ' '){
				nom += nombres.charAt(i);
				++i;	
			}
			++i;
			if (nom.charAt(0) != ' ') ret.add(nom);			
		}
		
		return ret;
	}
	
	
	public void guardarAgente(String path, String file){
		try {
			ca.Guardar(file);
		} catch (Exception e) {
			vistaAg.setError(e.getMessage());
		}
	}
	
	public void cargarAgente(String path, String file) {
		try {
			ca.Cargar(file);
		} catch (Exception e) {
			vistaAg.setError(e.getMessage());
		}
	}

	//*****************PANEL*****************************
	
	public static VistaAgentes getVista(){
		return vistaAg;
	}
}