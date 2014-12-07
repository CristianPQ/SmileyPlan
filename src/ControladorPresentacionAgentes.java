
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
					// TODO Auto-generated catch block
					vistaAg.setError(e.getMessage());
				}
			}
	
	public void modificarNombre(String antiguo, String nuevo) {
		try {
			ca.modificarNombreAgente(antiguo, nuevo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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