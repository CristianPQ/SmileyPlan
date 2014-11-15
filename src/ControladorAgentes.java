
/**
 * @author Daniel Villanueva 
 */
import java.util.*;
public class ControladorAgentes {
		private TST<Agente> Agentes;
		private int numAgentes;
		
		public ArrayList<Agente> guardaAg; 
		
		private final static int BUFFER_SIZE = 1000; //ARREGLAR A 250! 
		private int CARGA_MAX = 250; 
		public String buffer = null; 
		
		private static Exception NombreYaExiste = new Exception ("El agente ya existe");
		private static Exception NoExiste = new Exception ("El agente no existe");

		/**
		 * Constructora del controlador
		 */

		public ControladorAgentes(){
			Agentes = new TST<Agente>();
			numAgentes = 0;
		}
		
		
	/**
	 * Vaciar todo el contenedor de agentes
	 */
		
		public void eliminarTodo(){ //SEGURO2
			Agentes.makeEmpty();
            numAgentes = 0;
		}


		/**
		 * Consulta la existencia o no de un agente
		 */
		
		public boolean existeAgente(String nombre){
			return Agentes.existe(nombre);
		}
		
		/**
		 * Anadir un agente
		 */
			
		public void anadirAgente(String nombre, String ciudadInicial, String ciudadObjetivo)
				throws Exception{ 
			
			if (!existeAgente(nombre)){//si no existe, Exception
				Agente a = new Agente(nombre, ciudadInicial, ciudadObjetivo);
				Agentes.insert(nombre,a);
				++numAgentes;
			}	
			else throw NombreYaExiste;	
		}
		
		/**
		 * Eliminar un agente
		 */
		
		public void eliminarAgente(String nombre) throws Exception{ 
		
			if (existeAgente(nombre)){//si no existe, Exception
				Agentes.delete(nombre);
				--numAgentes;
			}
			else throw NoExiste;

			}

		/**
		 * Consultora de la ciudadInicial de un agente
		 */
		
		public String consultarCiudadInicialAgente(String nombre) throws Exception{
			
			if (existeAgente(nombre)){//si no existe, Exception
				return Agentes.consultar(nombre).consultarCiudadInicial();
			}
			else throw NoExiste;
		}
		
		/**
		 * Consultora de la ciudadObjetivo de un agente
		 */
		
		public String consultarCiudadObjetivoAgente(String nombre) throws Exception{
			
			if (existeAgente(nombre)){//si no existe, Exception
				return Agentes.consultar(nombre).consultarCiudadObjetivo();
			}
			else throw NoExiste;	

		}
		
		/**
		 * Modificadora del nombre de un agente (si existe)
		 */
		
		public void modificarNombreAgente(String nombreAntiguo, String nombreNuevo)throws Exception{
			
			if (existeAgente(nombreAntiguo)){ //si no existe, Exception
				Agente a = Agentes.consultar(nombreAntiguo);
				a.modificarNombre(nombreNuevo);
				if (!existeAgente(nombreNuevo)) {
					Agentes.delete(nombreAntiguo);
					Agentes.insert(nombreNuevo,a);	
				}
				else throw NombreYaExiste;
			}
			else throw NoExiste;
			
		}

		/**
		 * Modificadora de la ciudadInicial de un agente (si este existe)
		 */
		
        public void modificarCiudadInicialAgente(String nombre, String ciudadInicial)throws Exception{//NO CREO 8
			
			if (existeAgente(nombre)){ //si no existe, Exception
				Agente a = Agentes.consultar(nombre);
				a.modificarCiudadInicial(ciudadInicial);
				if (!existeAgente(nombre)) {
					Agentes.delete(nombre);
					Agentes.insert(nombre,a);	
				}
				else throw NombreYaExiste;
			}
			else throw NoExiste;
			
		}

		
		/**
		 * Modificadora de la ciudadObjetivo de un agente (si este existe)
		 */
		
        public void modificarCiudadObjetivoAgente(String nombre, String ciudadObjetivo)throws Exception{
	
			if (existeAgente(nombre)){//si no existe, Exception
				Agente a = Agentes.consultar(nombre);
				a.modificarCiudadObjetivo(ciudadObjetivo);
				if (!existeAgente(nombre)) {
					Agentes.delete(nombre);
					Agentes.insert(nombre,a);	
					}
				else throw NombreYaExiste;
			}
			else throw NoExiste;
		}
        
		/**
		 * Consultora del numero de agentes contenidos
		 */
        
        public int getNumeroDeAgentes(){ 
		return numAgentes;
		}
        
        public ArrayList<String> getNombresAgentes()
        {
        	return Agentes.consultar();
        }
        
        
        /**
    	 * Cargar agentes
    	 * @param path donde esta el archivo
    	 * @param file donde esta la informacion que queremos cargar
    	 * @throws Exception si el fichero esta vacio 
    	 */
    	public void Cargar(String path, String file) throws Exception{
    		
    		GestorDatos gd = new GestorDatos(path,file); 
    		
    		gd.createFile();
    		gd.openFile("read"); 
    		
    		int num = Integer.parseInt(gd.readLine()); 
    		
    		buffer = gd.readBuffer(num); 
    		if(buffer == null) throw new Exception("fichero vacio"); 
    		
    		String[] lineas = buffer.split("\n"); 
    		int i = 0; 
    		
    		if (num <= CARGA_MAX) {
    			while(i < num) {
    				String[] cortarstring = lineas[i].split(" "); 
    				String nombre = cortarstring[0];
    				String ci = cortarstring[1];
    				String co = cortarstring[2]; 
    				anadirAgente(nombre,ci,co); 
    				
    				/////////////per comprovar ////////////////
    				System.out.print(nombre + " "+ ci + " "+ co + "\n"); 
    				/////////////////////////////////////////////
    				i++; 
    			}
    		} 
    		else {
    			while(num >= CARGA_MAX) {
    				buffer = gd.readBuffer(CARGA_MAX); 
    				num = num - CARGA_MAX; 
    				while(i < CARGA_MAX) {
    					String[] cortarstring = lineas[i].split(" "); 
    					String nombre = cortarstring[0];
        				String ci = cortarstring[1];
        				String co = cortarstring[2]; 
        				anadirAgente(nombre,ci,co); 
        				
        				/////////////per comprovar ////////////////
        				System.out.print(nombre + " "+ ci + " "+ co + "\n"); 
        				/////////////////////////////////////////////
        				i++;  
    				}
    			}
    		}
    		gd.closeFile(); 
    	}
        
        
        
    	
    	/**
    	 * Guardar agentes
    	 * @param path donde vamos a guardar el arhivo
    	 * @param file donde vamos a guardar la informacion
    	 * @Exception al crear archivo 
    	 */
    	public void Guardar(String path, String file) throws Exception {
    		GestorDatos gd = new GestorDatos(path,file);
    		
    		gd.createFile(); 
    		gd.openFile("write"); 
    		
    		
    		ArrayList<String> lista = new ArrayList<String>();
    		lista = Agentes.consultar(); //obtenim un array ordenada amb els ident de TST
    		
    		String linea = Integer.toString(lista.size()) + "\n"; 
    		buffer = linea; 
    		
    		
    		
    		for(int i = 0; i < lista.size(); ++i){
    			String s = lista.get(i); 
    			Agente aux = Agentes.consultar(s); 
    			linea = s + " " + consultarCiudadInicialAgente(s)+ " " + consultarCiudadObjetivoAgente(s); 
    			buffer = buffer + linea + "\n"; 
    			
    			if(buffer.length() > BUFFER_SIZE) {
    				gd.writeBuffer(buffer); 
    				buffer = null; 
    			}
    		}
    		
    		if(buffer != null) {
    			gd.writeBuffer(buffer);
    		}
    		
    		gd.closeFile(); 

    	}
    	
    	
      
		


}
