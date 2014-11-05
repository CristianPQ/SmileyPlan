import java.util.HashMap;
import java.util.Map;
 
 
public class ControladorMedioTransporte {
	
	//WORK IN PROGRESS --> s'ha de canviar casi tot per TST

	
	//per tots els controladors que tinguin relacio amb aquest
	//si te un conjunt de relacions: private ConcurrentSkipListSet<NOMCLASSE>nom; 
	/*private static ControladorAlgoritmo cntrlAl; //ara fa error pq encara no hi ha els altres controladors creats 
	private static ControladorMapa cntrlMap; */
	private static Map <String, MedioTransporte> medios =  new HashMap<String,MedioTransporte>(); 
	
	
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
	
	/*//borrar todo el map
	public void eliminarMap(){
		medios.clear(); 
	}*/ 
	
	//agregar medio en el map 
	public void agregarMedioTransporte(String nombre, int coste) throws Exception{
		if (medios.containsKey(nombre)) throw NombreYaExiste; 
		else{
			MedioTransporte m = new MedioTransporte(nombre,coste); 
			//no hauria de posar directament un MT ??
			medios.put(nombre,m);
		}
	}
	
	//borrar un medio de transporte por nombre 
	public void borrarMedioTransporte(String nombre) throws Exception{
		if (!medios.containsKey(nombre)) throw NoExiste;
		else medios.remove(nombre); 
		//mirar si s'ha de moure tota l'estructura
	}
	
	//modifica el nombre del medio
	public void modificarNombre(String nNuevo, MedioTransporte m) throws Exception {
		String n = m.getNombre();
		if (!medios.containsKey(n)) throw NoExiste;
		else if (medios.containsKey(nNuevo)) throw NombreYaExiste; 
		else {
			int c = m.getPrecio();
			borrarMedioTransporte(n);
			agregarMedioTransporte(nNuevo,c);
		}	
	}
	
	//modifica el precio del medio
		public void modificarPrecio(int pNuevo, MedioTransporte m) throws Exception {
			String n = m.getNombre();
			if (!medios.containsKey(n)) throw NoExiste;
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
