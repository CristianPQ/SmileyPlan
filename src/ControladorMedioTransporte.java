import java.util.HashMap;
import java.util.Map;


public class ControladorMedioTransporte {
	
	//per tots els controladors que tinguin relacio amb aquest
	//si te un conjunt de relacions: private ConcurrentSkipListSet<NOMCLASSE>nom; 
	private static ControladorAlgoritmo cntrlAl; //ara fa error pq encara no hi ha els altres controladors creats 
	private static ControladorMapa cntrlMap; 
	private static Map <String, MedioTransporte> medios =  new HashMap<String,MedioTransporte>(); 
	
	
	//control errors 
	private static Exception NombreYaExiste = new Exception ("El nombre ya existe");
	
	//creadora de controlador 
	ControladorMedioTransporte(ControladorAlgoritmo al,ControladorMapa map){
		cntrlAl = al; 
		cntrlMap = map; 	
	}
	
	//borrar todo el map
	public void eliminarMap(){
		medios.clear(); 
	}
	
	//public ControladorMedioTransporte() {}
	
	
	//agregar medio en el map 
	public void agregarMedioTransporte(MedioTransporte med) throws Exception{
		String n = MedioTransporte.getNombre(); 
		if (medios.containsKey(n)) throw NombreYaExiste; 
		else medios.put(n, med);
	}
	
	//borrar un medio de transporte por nombre 
	public void borrarMedioTransporte(String nombre){
		medios.remove(nombre); 
	}
	
	//devuelve el num de transportes que hay en el map 
	public int getCantidadTransportes(){
		return medios.size(); 
	}
	
	
	
	/* 
	 * 
	03	 
	04	public class HashMapExample {
	05	     
	06	    public static void main(String[] args) {
	07	        Map vehicles = new HashMap();
	08	         
	09	        // Add some vehicles.
	10	        vehicles.put("BMW", 5);
	11	        vehicles.put("Mercedes", 3);
	12	        vehicles.put("Audi", 4);
	13	        vehicles.put("Ford", 10);
	14	         
	15	        System.out.println("Total vehicles: " + vehicles.size());
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
