
public class ControladorPresentacionMapa {
	
	private static ControladorMapa cm;
	private static VistaMapa vm;
	
	
	public ControladorPresentacionMapa(){
		vm = new VistaMapa(this);
		
		}
	
	public void crearMapa(int x, int y, String cont) throws Exception{
		cm = new ControladorMapa(x, y, cont);
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
	
	
	
	}

