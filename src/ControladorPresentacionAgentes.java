
import javax.swing.*;

public class ControladorPresentacionAgentes{
	private static ControladorAgentes ca;
	private static VistaAgentes vistaAg;
	private static ControladorMapa mapa;

	
	public ControladorPresentacionAgentes(){
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