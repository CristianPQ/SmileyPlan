
/*
 * @author Daniel Villanueva 
 */

public class ControladorAgentes {
		private TST<Agente> Agentes;
		private int numAgentes;
		
		private static Exception NombreYaExiste = new Exception ("El agente ya existe");
		private static Exception NoExiste = new Exception ("El agente no existe");
//		private static Exception ListaVacia = new Exception ("No existen elementos que se ajusten a su solicitud");
	
		/*
		 * Constructora del controlador
		 */

		public ControladorAgentes(){//SEGURO
			Agentes = new TST<Agente>();
			numAgentes = 0;
		}
		
		
		/*
		 * Vaciar todo el contenedor de agentes
		 */
		
		public void eliminarTodo(){ //SEGURO
			Agentes.makeEmpty();
		}


		/*
		 * Consulta la existencia o no de un agente
		 */
		
		public boolean existeAgente(String nombre){
			return Agentes.existe(nombre);
		}	
			/*
			 * Anadir un agente
			 */
			
		public void anadirAgente(String nombre, String ciudadInicial, String ciudadObjetivo)
				throws Exception{ //SEGURO
			if (!existeAgente(nombre)){
				Agente a = new Agente(nombre, ciudadInicial, ciudadObjetivo);
				Agentes.insert(a);
				++numAgentes;
			}	
			else throw NombreYaExiste;	
		}
		
		/*
		 * Eliminar un agente
		 */
		
		public void eliminarAgente(String nombre) throws Exception{ //SEGURO
		
			if (existeAgente(nombre)){
				Agentes.delete(nombre);
				--numAgentes;
			}
			else throw NoExiste;

			}

		/*
		 * Modificar el nombre de un agente
		 */
		
		public String consultarCiudadInicialAgente(String nombre, String ciudadInicial) throws Exception{
			if (existeAgente(nombre)){
				return Agentes.consultar(nombre).consultarCiudadInicial();
			}
			else throw NoExiste;
		}
		
		public String consultarCiudadObjetivoAgente(String nombre, String ciudadObjetivo) throws Exception{
			if (existeAgente(nombre)){
				return Agentes.consultar(nombre).consultarCiudadObjetivo();
			}
			else throw NoExiste;	

		}
		
		public void modificarNombreAgente(String nombreAntiguo, String nombreNuevo)throws Exception{//NO CREO
			
			if (existeAgente(nombreAntiguo)){
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
			//acaba al encontrar el agente que quiere eliminar
			//si llega al final y no se encuentra, es que no existe
	
		/*
		 * Modificar la ciudadInicial de un agente
		 */
		
public void modificarCiudadInicialAgente(String nombre, String ciudadInicial)throws Exception{//NO CREO
			
			if (existeAgente(nombre)){
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
			//acaba al encontrar el agente que quiere eliminar
			//si llega al final y no se encuentra, es que no existe
		
		/*
		 * Modificar la ciudadObjetivo de un agente
		 */
		
public void modificarCiudadObjetivoAgente(String nombre, String ciudadObjetivo)throws Exception{//NO CREO
	
			if (existeAgente(nombre)){
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
			//acaba al encontrar el agente que quiere eliminar
			//si llega al final y no se encuentra, es que no existe
		
		/*
		 * Consultar agentes con una determinada ciudadInicial
		 */
		
/*	public List<Agente> consultarAgentesCiudadInicial(String ciudadInicial) //NO CREO
			throws Exception{
			
			List<Agente> l = new ArrayList<Agente>();	
			Iterator<Agente> it = Agentes.iterator();
			Agente a;
				while(it.hasNext()){ 
					a = it.next();
					if (a.consultarCiudadInicial().equals(ciudadInicial)) l.add(a);
				}
				if (l.isEmpty())  throw ListaVacia;
			return l;
			}	
			//Listar agentes con CiuIni concreta
			//recorrer toda la lista en busqueda de estos
			//si no se anade ningun elemento, mostrar que no hay elementos que se correspondan
			//con nuestra busqueda
		
		/*
		 * Consultar agentes con una determinada ciudadObjetivo
		 */
		
/*		public List<Agente> consultarAgentesCiudadObjetivo(String ciudadObjetivo) //NO CREO
			throws Exception {
			
			List<Agente> l = new ArrayList<Agente>();
			Iterator<Agente> it = Agentes.iterator();
			Agente a;
			while(it.hasNext()){ 
				a = it.next();
				if (a.consultarCiudadObjetivo().equals(ciudadObjetivo)) l.add(a);
			}
				if (l.isEmpty())  throw ListaVacia;
			return l;
			}
			//Listar agentes con CiuObj concreta
			//itera todo el set i si no encuentra nada devuelve que no hay elementos que se ajusten
			//a nuestra busqueda
		
		/*
		 * Consultar agentes con una determinada ciudadInicial y una determinada ciudadObjetivo
		 */
/*	
		public List<Agente> consultarAgentesCiudadInicialObjetivo(String ciudadInicial, String ciudadObjetivo)
			throws Exception{ //NO CREO
			
			List<Agente> l = new ArrayList<Agente>();
			Iterator<Agente> it = Agentes.iterator();
			Agente a;
			while(it.hasNext()){ 
				a = it.next();
				if (a.consultarCiudadObjetivo().equals(ciudadObjetivo) &&
						a.consultarCiudadInicial().equals(ciudadInicial)) l.add(a);
			}if (l.isEmpty())  throw ListaVacia;
				return l;
			}
			//consultar agentes con una determinada ciuIni y ciuObj (que cumplan ambas) 
			//Si la ista se devuelve vacia, senalamos que no hay elementos que se ajusten a nuestra busuqeda
		
		/*
		 * Consultar el número de agentes que hay en el contenedor
		 */
		
		int getNumeroDeAgentes(){ //SEGURO		
			return numAgentes;
		}
		
		
		
		
	
}
