
public class ControladorPresentacionMapa {
	
	private static ControladorMapa cm;
	private static VistaMapa vm;
	private static ControladorPresentacionMedios cmed;
	
	public ControladorPresentacionMapa( ControladorPresentacionMedios cmd){
		cmed = cmd;
		vm = new VistaMapa(this);
		//cm = new ControladorMapa();
		
		}
	
	public void crearMapa(int x, int y){
	
		try{
			cm = new ControladorMapa(x,y," ");
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
	
	public int consultarX(String city){
		try {
			return cm.consultarCiudad(city).consultarCoordenadas().consultarX();
			////CREAR METODO DIRECTO EN CMAPA
		} catch (Exception e) {
			vm.setError(e.getMessage());
		}
		return -1;
	}
	
	public int consultarY(String city){ 
		try {
			return cm.consultarCiudad(city).consultarCoordenadas().consultarY(); 
			////CREAR METODO DIRECTO EN CMAPA
		} catch (Exception e) {
			vm.setError(e.getMessage());
		}
		return -1;
	}
	
	public void eliminarCiudad(String c){
		try {
			cm.eliminarCiudad(c);
		} catch (Exception e) {
			vm.setError(e.getMessage());
		}
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
	
	public void agregarCamino(String cOrig, String cDest, String medio, int cap){
		try{
			cm.agregarCamino(cOrig, cDest, medio, cap, cmed.devolverControlador());}
		catch (Exception e) {
			vm.setError(e.getMessage());
		}
	}

	public ControladorMapa devolverControlador(){
		return cm;
	}
	}

