import java.util.HashMap;
import java.util.Map;
 
/*
 * @author Olga 
 */

public class ControladorMedioTransporte {
	
	//WORK IN PROGRESS --> s'ha de canviar casi tot per TST
	/*private static ControladorAlgoritmo cntrlAl; 
	private static ControladorMapa cntrlMap; */
	//private static Map <String, MedioTransporte> medios =  new HashMap<String,MedioTransporte>(); 
	private TST<MedioTransporte> medios = new TST<MedioTransporte>(); 
	
	//control errors 
	private static Exception NombreYaExiste = new Exception ("El nombre ya existe");
	private static Exception NoExiste = new Exception ("El nombre no existe");
	
	//creadora per defecte
	public ControladorMedioTransporte() {}
	
	//creadora de controlador 
	/* ControladorMedioTransporte(ControladorAlgoritmo al,ControladorMapa map){
		cntrlAl = al; 
		cntrlMap = map; 	
	}*/
	
	//agregar medio de transporte
	public void agregarMedioTransporte(String nombre, int coste) throws Exception{
		if (medios.contains(nombre)) throw NombreYaExiste; 
		else{
			MedioTransporte m = new MedioTransporte(nombre,coste); 
			medios.put(nombre,m);
		}
	}
	
	//borrar un medio de transporte por nombre
	public void borrarMedioTransporte(String nombre) throws Exception{
		if (!medios.contains(nombre)) throw NoExiste;
		//else medios.delete(nombre); 
		//mirar si s'ha de moure tota l'estructura
	}
	
	//modifica el nombre del medio
	public void modificarNombre(String nNuevo, MedioTransporte m) throws Exception {
		String n = m.getNombre();
		if (!medios.contains(n)) throw NoExiste;
		else if (medios.contains(nNuevo)) throw NombreYaExiste; 
		else {
			int c = m.getPrecio();
			borrarMedioTransporte(n);
			agregarMedioTransporte(nNuevo,c);
		}	
	}
	
	//modifica el precio del medio
		public void modificarPrecio(int pNuevo, MedioTransporte m) throws Exception {
			String n = m.getNombre();
			if (!medios.contains(n)) throw NoExiste;
			else {
				borrarMedioTransporte(n);
				agregarMedioTransporte(n,pNuevo);
			}	
		}
	
	//devuelve el num de transportes que hay en el map 
	public int getCantidadTransportes(){
		return medios.size(); 
	}
	

}
