import java.util.ArrayList;


public class ControladorPresentacionMapa {
	
	private static ControladorMapa cm;
	private static VistaMapa vm;
	private static VistaCrearMapa vCrearMapa;
	private static ControladorPresentacionMedios cmed;
	private static ControladorPresentacionAgentes cag;

	public ControladorPresentacionMapa( ControladorPresentacionMedios cmd, ControladorPresentacionAgentes cagen){
		cmd.setContPresMapa(this);
		cmed = cmd;
		vm = new VistaMapa(this);
		vCrearMapa = new VistaCrearMapa(this);
		cm = new ControladorMapa();
		cagen.setContPresMapa(this);
		cag = cagen;
	}
	
	public void crearMapa(int x, int y, String cont){
		try{
			cm = new ControladorMapa(x,y,cont);
			String map = cm.consultarMapaToString();
			vCrearMapa.actualizarMapa();
		}
		catch (Exception e) {
			//System.out.println(e.getMessage()); 
			vm.setError(e.getMessage());
		}
	}
	
	public boolean cargarMapa(String file) throws Exception{
		//System.out.println("controlador presentacion mapa"); 
		return cm.cargarMapa(file);
	}
	
	public void guardarMapa(String file) {
		try {
			cm.guardarMapa(file);
		} catch (Exception e) {
			vm.setError(e.getMessage());
		}
	}
	
	public int consultarAnchura(){
		return cm.conusltarAnchura(); 
	}
	
	public int consultarAltura() {
		return cm.consultarAltura(); 
	}
	
	public String consultarContinente(){
		return cm.consultarContinente(); 
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
			cag.eliminarAgentesConCiudad(c);
			cag.actualizarLista();
			/*String cam1 = cm.consultarCaminosDestinoToString(c);
			String cam2 = cm.consultarCaminosDestinoToString(c);
			
			for(int i = 0; i < cam1.length(); i+=3){
				String co = cam1.split(" ")[i]; 
				String cd = cam1.split(" ")[i+1]; 
				String medio = cam1.split(" ")[i+2]; 
				cm.eliminarCamino(co, cd, medio);
			}*/
			
			//TAMBE AMB AGENTES
			
		} catch (Exception e) {
			vm.setError(e.getMessage());
		}
	}
	
/*	public int coordX(String ciudad) {
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
	

*/	
	public void modificarCoordenadas(String n, int x, int y){
		try {
			cm.modificarAtributosCiudad(n, x, y);
		} catch (Exception e) {
			vm.setError(e.getMessage());
		}
	}
	
	public VistaMapa getVistaMapa() {
		return vm;
	}
	
	public VistaCrearMapa getVistaCrearMapa() {
		return vCrearMapa;
	}
	
	public ControladorMapa devolverControlador(){
		return cm;
	}
	
	public String[] listarCiudades() throws Exception {
		String nombres = cm.listarCiudadesToString();
		String[] ret = nombres.split("\n"); 
		return ret; 
	}
	
	public boolean cargarCiudades(String file) throws Exception{
		return cm.cargarCiudades(file);
	}
	
	public void guardarCiudades(String file) {
		try {
			cm.guardarCiudades(file);
		} catch (Exception e) {
			vm.setError(e.getMessage());
		}
	}
	
	///// CAMINO ///

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

	public void eliminarCamino(String COrig, String cDest, String medio){
		try {
			cm.eliminarCamino(COrig, cDest, medio);
		} catch (Exception e) {
			vm.setError(e.getMessage());
		}
	}
	
	public boolean cargarCaminos(String file) throws Exception {
		return cm.cargarCaminos(file, cmed.devolverControlador()); 
	}
	
	public ControladorMapa devolverControladorMapa() {
		return cm; 
	}
	
	public void guardarCaminos(String file) {
		try {
			cm.guardarCaminos(file);
		} catch (Exception e) {
			vm.setError(e.getMessage());
		}
	}

	public void eliminarCaminosConMedio(String nombre) throws Exception {
		cm.eliminarCaminosConMedio(nombre);
		vm.actualizarListaCaminos();
	}
	
	public boolean existeContinente(){
		return cm.existeContinente(); 
	}
	
	public void guardarBrowser() {
		vm.abrirBrowserGuardar();
	}
	
	public void guardarBrowserCaminos(){
		vm.abrirBrowserGuardarCaminos();
	}
	
	public void guardarBrowserCiudades(){
		try {
			vm.abrirBrowserGuardarCiudades();
		} catch (Exception e) {
			vm.setError(e.getMessage());
		}
	}
	
	public void cargarBrowserCiudades(){
		try {
			vm.abrirBrowserCargarCiudades();
		} catch (Exception e) {
			vm.setError(e.getMessage());
		}
	}
	
	public void cargarBrowserCaminos(){
		try {
			vm.abrirBrowserCargarCaminos();
		} catch (Exception e) {
			vm.setError(e.getMessage());
		}
	}
	
	public void cargarBrowser(){
		try {
			vm.abrirBrowserCargar();
		} catch (Exception e) {
			vm.setError(e.getMessage());
		}
	}
	
}

