import java.util.*;

/*
 * @author Daniel Villanueva 
 */

public class ControladorAgentes {
		private TST<Agente> Agentes;
		
		private static Exception NombreYaExiste = new Exception ("El agente ya existe");
		private static Exception NoExiste = new Exception ("El agente no existe");
		private static Exception ListaVacia = new Exception ("No existen elementos que se ajusten a su solicitud");
	
		/*
		 * Constructora del controlador
		 */

		public ControladorAgentes(){
			this.Agentes = new TST<Agente>();
		}
		//constructor Agente
		
		/*
		 * Vaciar todo el contenedor de agentes
		 */
		
	/*	public void eliminarTodo(){
			Agentes.clear();
		}*/
		
		/*
		 * Añadir un agente
		 */
		
		public void anadirAgente(String nombre, String ciudadInicial, String ciudadObjetivo)
				throws Exception{  
			if (Agentes.search(nombre)) throw NombreYaExiste;
			Agente a = new Agente(nombre, ciudadInicial, ciudadObjetivo);
			this.Agentes.insert(nombre, a);
			}
		
		/*
		 * Eliminar un agente
		 */
		
		public void eliminarAgente(String nombre) throws Exception{
			
			Agentes.delete(nombre);
			//acaba al encontrar el agente que quiere eliminar
			//si llega al final y no se encuentra, es que no existe
		}
		/*
		 * Modificar el nombre de un agente
		 */
		
		public void modificarNombreAgente(String nombreAntiguo, String nombreNuevo)throws Exception{
			
			Agente a = Agentes.get(nombreAntiguo);
			Agentes.delete(nombreAntiguo);
			a.setNombre(nombreNuevo);
			Agentes.insert(nombreNuevo, a);
			//acaba al encontrar el agente que quiere eliminar
			//si llega al final y no se encuentra, es que no existe
		}
		/*
		 * Modificar la ciudadInicial de un agente
		 */
		
		public void modificarCiudadInicialAgente(String nombre, String ciudadInicial)
			throws Exception{
			
			Agente a = Agentes.get(nombre);
			Agentes.delete(nombre);
			a.setCiudadInicial(ciudadInicial);
			Agentes.insert(nombre, a);
			}
			//acaba al encontrar el agente que quiere eliminar
			//si llega al final y no se encuentra, es que no existe
		
		/*
		 * Modificar la ciudadObjetivo de un agente
		 */
		
		public void modificarCiudadObjetivoAgente(String nombre, String ciudadObjetivo)
			throws Exception{

			Agente a = Agentes.get(nombre);
			Agentes.delete(nombre);
			a.setCiudadInicial(ciudadObjetivo);
			Agentes.insert(nombre, a);
			}
		
			//acaba al encontrar el agente que quiere eliminar
			//si llega al final y no se encuentra, es que no existe
		
		/*
		 * Consultar agentes con una determinada ciudadInicial
		 */
		

		//COMO IMPLEMEENTO ESTO CON TST? 
		public List<Agente> consultarAgentesCiudadInicial(String ciudadInicial)
			throws Exception{
			
			List<Agente> l = new ArrayList<Agente>();	
			Iterator<Agente> it = Agentes.iterator();
			Agente a;
				while(it.hasNext()){ 
					a = it.next();
					if (a.getCiudadInicial().equals(ciudadInicial)) l.add(a);
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
		
		public List<Agente> consultarAgentesCiudadObjetivo(String ciudadObjetivo)
			throws Exception {
			
			List<Agente> l = new ArrayList<Agente>();
			Iterator<Agente> it = Agentes.iterator();
			Agente a;
			while(it.hasNext()){ 
				a = it.next();
				if (a.getCiudadObjetivo().equals(ciudadObjetivo)) l.add(a);
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
		
		public List<Agente> consultarAgentesCiudadInicialObjetivo(String ciudadInicial, String ciudadObjetivo)
			throws Exception{ 
			
			List<Agente> l = new ArrayList<Agente>();
			Iterator<Agente> it = Agentes.iterator();
			Agente a;
			while(it.hasNext()){ 
				a = it.next();
				if (a.getCiudadObjetivo().equals(ciudadObjetivo) &&
						a.getCiudadInicial().equals(ciudadInicial)) l.add(a);
			}if (l.isEmpty())  throw ListaVacia;
				return l;
			}
			//consultar agentes con una determinada ciuIni y ciuObj (que cumplan ambas) 
			//Si la lista se devuelve vacia, senalamos que no hay elementos que se ajusten a nuestra busuqeda
		
		/*
		 * Consultar el número de agentes que hay en el contenedor
		 */
		
		int getNumeroDeAgentes(){
			
			return Agentes.size();
		}
		
		
		
		
	
}