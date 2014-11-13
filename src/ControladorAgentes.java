
/**
 * @author Daniel Villanueva 
 */
import java.util.*;
public class ControladorAgentes {
		private TST<Agente> Agentes;
		private int numAgentes;
		
		public ArrayList<Agente> guardaAg; 
		
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
    	 * Cargar 
    	 * @param path donde esta el archivo
    	 * @param file donde esta la informacion que queremos cargar
    	 * @throws Exception si el fichero esta vacio 
    	 */
    	public void Cargar(String path, String file) throws Exception{
    		
    		GestorDatosAgente ga = new GestorDatosAgente(); 
    		guardaAg = ga.cargarAgente(path,file); 
    		
    		 for(int i = 0; i < guardaAg.size(); ++i ){
    			 Agente aux = guardaAg.get(i); 
    			 String n = aux.consultarNombre(); 
    			 String ci = aux.consultarCiudadInicial();
    			 String co = aux.consultarCiudadObjetivo();
    			 anadirAgente(n,ci,co); 
    		 }	
    	}
    	
    	/**
    	 * Guarda los agentes 
    	 * @param path donde vamos a guardar el arhivo
    	 * @param file donde vamos a guardar la informacion
    	 * @Exception al crear archivo 
    	 */
    	public void Guardar(String path, String file) throws Exception {
    		guardaAg = new ArrayList<Agente>();
    		ArrayList<String> lista = new ArrayList<String>();
    		lista = Agentes.consultar(); //obtenim un array ordenada amb els ident de TST
    		for(int i = 0; i < lista.size(); ++i){
    			String s = lista.get(i); //obtenim el primer nom
    			Agente aux = Agentes.consultar(s); 
    			guardaAg.add(aux); //ho passem a l'array 
    		}
    		GestorDatosAgente ag = new GestorDatosAgente();
    		
    		ag.guardarAgentes(path,file,guardaAg); 
    	}
    	
    	
      
		


}
