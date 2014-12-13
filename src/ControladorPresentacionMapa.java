
public class ControladorPresentacionMapa {
	
	private static ControladorMapa cm;
	private static VistaMapa vm;
	private static ControladorPresentacionMedios cmed;
	
	public ControladorPresentacionMapa( ControladorPresentacionMedios cmd){
		cmed = cmd;
		vm = new VistaMapa(this);
		//cm = new ControladorMapa();
		
		}
	
	public void crearMapa(int x, int y, String cont) throws Exception{
	
		try{
			cm = new ControladorMapa(x, y, cont);
		}
		catch (Exception e) {
			vm.setError(e.getMessage());
		}
	}
	////////////////CIUDADES//////////////////
	public void agregarCiudad(String n, int x, int y) throws Exception{
		cm.agregarCiudad(n,x,y);

	}
	
	public void eliminarCiudad(String c) throws Exception{
		cm.eliminarCiudad(c);
	}
	
	public void modificarCoordenadas(String n, int x, int y) throws Exception{
		cm.modificarAtributosCiudad(n, x, y);
	}
	
	public VistaMapa getVista() {
		return vm;
	}
	
	public void agregarCamino(String cOrig, String cDest, String medio, int cap){
		try{
			cm.agregarCamino(cOrig, cDest, medio, cap, cmed.devolverControlador());		}
		catch (Exception e) {
			vm.setError(e.getMessage());
		}
	}

	public ControladorMapa devolverControlador(){
		return cm;
	}
	}

