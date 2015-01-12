import java.util.ArrayList;


public class ControladorPresentacionMapa {
	
	private static ControladorMapa cm;
	private static VistaMapa vm;
	private static VistaCrearMapa vCrearMapa;
	private VistaGrafo vg;
	private static ControladorPresentacionMedios cmed;
	private static ControladorPresentacionAgentes cag;

	public ControladorPresentacionMapa( ControladorPresentacionMedios cmd, ControladorPresentacionAgentes cagen){
		cmd.setContPresMapa(this);
		cmed = cmd;
		vm = new VistaMapa(this);
		vg = new VistaGrafo(this);
		//vg.dibujar();
		vCrearMapa = new VistaCrearMapa(this);
		cm = new ControladorMapa();
		cagen.setContPresMapa(this);
		cag = cagen;
	}
	
	public void crearMapa(int x, int y, String cont){
		try{
			cm = new ControladorMapa(x,y,cont);
			//String map = cm.consultarMapaToString();
			//vCrearMapa.actualizarMapa();
		}
		catch (Exception e) {
			//System.out.println(e.getMessage()); 
			vm.setError(e.getMessage());
		}
	}
	

	public void crearMapa(int x, int y) {
		try{
			cm = new ControladorMapa(x,y);
			//String map = cm.consultarMapaToString();
			//vCrearMapa.actualizarMapa();
		}
		catch (Exception e) {
			vm.setError(e.getMessage());
		}
	}
	
	public void definirContinente(String cont) {
		try {
			cm.definirContinente(cont);
		}
		catch (Exception e) {
			vm.setError(e.getMessage());
		}
	}
	
	public boolean cargarMapa(String file) throws Exception{
		//System.out.println("controlador presentacion mapa"); 
		return cm.cargarMapa(file);
	}
	
	public void guardarMapa(String file, boolean tieneCont) {
		try {
			if(tieneCont) cm.guardarMapaCont(file);
			else cm.guardarMapa(file);
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
			vCrearMapa.pintarCiudad(n);
			
		} catch (Exception e) {
			vm.setError(e.getMessage());
		}

	}
	
	
	public void eliminarCiudad(String c){
		try {
			cm.eliminarCiudad(c);
			cag.eliminarAgentesConCiudad(c);
			cag.actualizarLista();
			
			vCrearMapa.borrarCiudad(c);
		
			
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
			cm.agregarCamino(cOrig, cDest, medio, cap, cmed.devolverControlador());
			vCrearMapa.pintarCamino(cOrig, cDest, medio);
			
			}
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
			vCrearMapa.borrarCamino(COrig, cDest, medio);
			
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
		vCrearMapa.abrirBrowserGuardar();
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
			String[] cius = listarCiudades();
			for(String s: cius) {
				String[] n = s.split(" ");
				vCrearMapa.pintarCiudad(n[0]);
			}
		} catch (Exception e) {
			vm.setError(e.getMessage());
		}
	}
	
	public void cargarBrowserCaminos(){
		try {
			vm.abrirBrowserCargarCaminos();
			String[] cams = listarCaminos();
			for(String s: cams) {
				String[] n = s.split(" ");
				vCrearMapa.pintarCamino(n[0], n[1], n[2]);
			}
		} catch (Exception e) {
			vm.setError(e.getMessage());
		}
	}
	
	public void cargarBrowser(){
		try {
			vCrearMapa.abrirBrowserCargar();
		} catch (Exception e) {
			vm.setError(e.getMessage());
		}
	}

	public void extraerOcupados(ArrayList<Integer> horiz,
			ArrayList<Integer> vert) {
		//horiz = new ArrayList<Integer>();
		//vert = new ArrayList<Integer>();
		String s = cm.consultarMapaToString();
		String[] sMapa = s.split("\n");
		for(int i = 0; i < sMapa.length ; ++i) {
			String[] sFila = sMapa[i].split(" ");
			for(int j = 0; j < sFila.length ; ++j) {
				if(sFila[j].equals("$")) {
					System.out.println("Un vertice anadido");
					vert.add(i);
					horiz.add(j);
					
				}
			}
		}
		System.out.println("En ControlPresentacionMapa " + horiz.toString());
		System.out.println("En ControlPresentacionMapa " + vert.toString());
		System.out.println("MapaToString" + s);
	}
	
	public VistaGrafo getVGrafo(){
		return vg;
	}
	
}

