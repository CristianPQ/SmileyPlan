import java.util.ArrayList;


public class ControladorPresentacionMapa {
	
	private static ControladorMapa cm;
	private static VistaMapa vm;
	private static ControladorPresentacionMedios cmed;
	
	public ControladorPresentacionMapa( ControladorPresentacionMedios cmd){
		cmed = cmd;
		vm = new VistaMapa(this);
		//cm = new ControladorMapa();	
	}
	
	public void crearMapa(int x, int y, String cont){
		try{
			cm = new ControladorMapa(x,y,cont);
		}
		catch (Exception e) {
			vm.setError(e.getMessage());
		}
	}
	
	////////////////CIUDADES//////////////////
	public void agregarCiudad(String n, int x, int y){
		try {
			cm.agregarCiudad(n,x,y);
		} catch (Exception e) {
			vm.setError(e.getMessage());
		}

	}
	
	
	public void eliminarCiudad(String c){
		try {
			cm.eliminarCiudad(c);
		} catch (Exception e) {
			vm.setError(e.getMessage());
		}
	}
	
	public int coordX(String ciudad) {
			try {
				return cm.coordXCiudad(ciudad);
			} catch (Exception e) {
				vm.setError(e.getMessage());
			}
			return -1;
	}
	
	public int coordY(String ciudad) {
		try {
			return cm.coordYCiudad(ciudad);
		} catch (Exception e) {
			vm.setError(e.getMessage());
		}
		return -1;
	}
	
	
	public void modificarCoordenadas(String n, int x, int y){
		try {
			cm.modificarAtributosCiudad(n, x, y);
		} catch (Exception e) {
			vm.setError(e.getMessage());
		}
	}
	
	public VistaMapa getVista() {
		return vm;
	}
	
	public ControladorMapa devolverControlador(){
		return cm;
	}
	
	
	///// CAMINO ///
	
	
	
	
	public String[] listarCiudades() throws Exception {
		String nombres = cm.listarCiudadesToString();
		String[] ret = nombres.split("\n"); 
		return ret; 
	}
	
	public String[] listarCaminos() throws Exception {
		//System.out.println("control present mapa");
		String nombres = cm.consultarTodosCaminosToString();
		String[] ret = nombres.split("\n"); 
		return ret;
	}
	
	public void agregarCamino(String cOrig, String cDest, String medio, int cap){
		try{
			//System.out.println("estic a controlador presnt per crear");
			cm.agregarCamino(cOrig, cDest, medio, cap, cmed.devolverControlador());}
		catch (Exception e) {
			vm.setError(e.getMessage());
		}
	}
	
	public void modificarCamino(String COrig, String cDest, String medio, int cap){
		try {
			cm.modificarAtributosCamino(COrig, cDest, medio, cap);
		} catch (Exception e) {
			vm.setError(e.getMessage());
		}
	}

	
}

