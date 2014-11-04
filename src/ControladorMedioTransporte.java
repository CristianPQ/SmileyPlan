import java.util.HashMap;
import java.util.Map;


public class ControladorMedioTransporte {
	
	//per tots els controladors que tinguin relacio amb aquest
	//si te un conjunt de relacions: private ConcurrentSkipListSet<NOMCLASSE>nom; 
	/*private static ControladorAlgoritmo cntrlAl; //ara fa error pq encara no hi ha els altres controladors creats 
	private static ControladorMapa cntrlMap;*/ 
	private static Map <String, MedioTransporte> medios =  new HashMap<String,MedioTransporte>(); 
	
	
	//control errors 
	private static Exception NombreYaExiste = new Exception ("El nombre ya existe");
	private static Exception NoExiste = new Exception ("El nombre no existe");
	
	//creadora de controlador 
	/*ControladorMedioTransporte(ControladorAlgoritmo al,ControladorMapa map){
		cntrlAl = al; 
		cntrlMap = map; 	
	}*/
	
	//borrar todo el map
	public void eliminarMap(){
		medios.clear(); 
	}
	
	//public ControladorMedioTransporte() {}
	
	
	//agregar medio en el map 
	public void agregarMedioTransporte(String nombre, int coste) throws Exception{
		if (medios.containsKey(nombre)) throw NombreYaExiste; 
		else{
			MedioTransporte m = new MedioTransporte(nombre,coste); 
			medios.put(nombre,m);
		}
	}
	
	//borrar un medio de transporte por nombre 
	public void borrarMedioTransporte(String nombre) throws Exception{
		if (!medios.containsKey(nombre)) throw NoExiste;
		else medios.remove(nombre); 
	}
	
	/*public void modificarNombre(String nombre, MedioTransporte m) {
		String n = m.getNombre();
		if (!medios.containsKey(n)) throw NoExiste;
		else if (medios.containsKey(nombre)) throw NombreYaExiste; 
		else {
			//medios.get(n)
			
		}
		
	}*/
	
	//devuelve el num de transportes que hay en el map 
	public int getCantidadTransportes(){
		return medios.size(); 
	}
	
	
	
	/* 

	16	         
	17	        // Iterate over all vehicles, using the keySet method.
	18	        for(String key: vehicles.keySet())
	19	            System.out.println(key + " - " + vehicles.get(key));
	20	        System.out.println();
	21	         
	22	        String searchKey = "Audi";
	23	        if(vehicles.containsKey(searchKey))
	24	            System.out.println("Found total " + vehicles.get(searchKey) + " "
	25	                    + searchKey + " cars!\n");
	26	 
	29	      
	33	}
	 * 
	 */
	
	
	

}
