
/**
 * @author Daniel Villanueva 
 */

public class ControladorAgentes {
		private TST<Agente> Agentes;
		private int numAgentes;
		
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
				Agentes.insert(a);
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
					Agentes.insert(a);	
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
					Agentes.insert(a);	
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
					Agentes.insert(a);	
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
		


}
