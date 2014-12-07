
import javax.swing.*;

public class ControladorPresentacionAgentes {
	private static ControladorAgentes ca;
	private static VistaAgentes vistaAg;
	private static ControladorMapa mapa;

	
	public ControladorPresentacionAgentes(ControladorMapa ma){
		ca = new ControladorAgentes();
		vistaAg = new VistaAgentes(this);
		
	}
	
	public void agregarAgente (String n, String ciuIni, String ciuObj) 
			throws Exception{
				ca.anadirAgente(n, ciuIni, ciuObj, mapa);
				}
	
	public void modificarNombre(String antiguo, String nuevo) throws Exception {
		ca.modificarNombreAgente(antiguo, nuevo);
	}
	
	public void modificarCiudadInicial(String n, String ciuIni) throws Exception{
		ca.modificarCiudadInicialAgente(n, ciuIni);
	}
	
	public void modificarCiudadObjetivo (String n, String ciuObj) throws Exception{
		ca.modificarCiudadObjetivoAgente(n, ciuObj);
	}

	public void eliminarAgente(String n) throws Exception{
		ca.eliminarAgente(n);
	}
	
	public void guardarAgente(String path, String file) throws Exception {
		ca.Guardar(file);
	}
	
	public void cargarAgente(String path, String file) throws Exception {
		ca.Cargar(file);
	}

	//*****************PANEL*****************************
	
	public static VistaAgentes getVista(){
		return vistaAg;
	}
}