import java.util.*;

/*
 * @author Daniel Villanueva 
 */

public class ControladorAgentes {
		private Set<Agente> Agentes;
		
		private static Exception NombreYaExiste = new Exception ("El agente ya existe");
		private static Exception NoExiste = new Exception ("El agente no existe");
		private static Exception ListaVacia = new Exception ("No existen elementos que se ajusten a su solicitud");
	
		/*
		 * Constructora del controlador
		 */

		public ControladorAgentes(){//SEGURO
			this.Agentes = new HashSet<Agente>();
		}
		//constructor Agente
		
		/*
		 * Vaciar todo el contenedor de agentes
		 */
		
		public void eliminarTodo(){ //SEGURO
			Agentes.clear();
		}
		
		/*
		 * Anadir un agente
		 */
		
		public void anadirAgente(String nombre, String ciudadInicial, String ciudadObjetivo)
				throws Exception{ //SEGURO
			Iterator<Agente> it = Agentes.iterator();
			Agente b;
			while (it.hasNext()){
				b = it.next();
				if (b.consultarNombre().equals(nombre)) throw NombreYaExiste;
			}
			Agente a = new Agente(nombre, ciudadInicial, ciudadObjetivo);
			Agentes.add(a);
			}
		
		/*
		 * Eliminar un agente
		 */
		
		public void eliminarAgente(String nombre) throws Exception{ //SEGURO
			
			Iterator<Agente> it = Agentes.iterator();
			boolean fin = false;
			Agente a;
				while (it.hasNext() && !fin){
					a = it.next();
					//String buscado = it.next().getNombre();
					if(a.consultarNombre().equals(nombre)){
						it.remove();
						fin = true;
					}
				}if (!fin) throw NoExiste;		
			}
			//acaba al encontrar el agente que quiere eliminar
			//si llega al final y no se encuentra, es que no existe
		
		/*
		 * Modificar el nombre de un agente
		 */
		
		public void modificarNombreAgente(String nombreAntiguo, String nombreNuevo)throws Exception{//NO CREO
			
			Iterator<Agente> it = Agentes.iterator();
			boolean fin = false;
			Agente a;
				while (it.hasNext() && !fin){
					a = it.next();
					if (a.consultarNombre().equals(nombreAntiguo)) {
						it.remove();
						a.modificarNombre(nombreNuevo); 
						Agentes.add(a);
						fin = true;
					}
				}if (!fin) throw NoExiste;
			}
			//acaba al encontrar el agente que quiere eliminar
			//si llega al final y no se encuentra, es que no existe
	
		/*
		 * Modificar la ciudadInicial de un agente
		 */
		
		public void modificarCiudadInicialAgente(String nombre, String ciudadInicial) //PODRIA SER
			throws Exception{
			
			Iterator<Agente> it = Agentes.iterator();
			boolean fin = false;
			Agente a;
				while (it.hasNext() && !fin){
					a = it.next();
					if (a.consultarNombre().equals(nombre)) {
						it.remove();
						a.modificarCiudadInicial(ciudadInicial); 
						Agentes.add(a);
						fin = true;
					}
				}if (!fin) throw NoExiste;
			}
			//acaba al encontrar el agente que quiere eliminar
			//si llega al final y no se encuentra, es que no existe
		
		/*
		 * Modificar la ciudadObjetivo de un agente
		 */
		
		public void modificarCiudadObjetivoAgente(String nombre, String ciudadObjetivo) //PODRIA SER
			throws Exception{

			Iterator<Agente> it = Agentes.iterator();
			boolean fin = false;
			Agente a;
				while (it.hasNext() && !fin){
					a = it.next();
					if (a.consultarNombre().equals(nombre)) {
						it.remove();
						a.modificarCiudadObjetivo(ciudadObjetivo); 
						Agentes.add(a);
						fin = true;
					}
				}if (!fin) throw NoExiste;
			}
			//acaba al encontrar el agente que quiere eliminar
			//si llega al final y no se encuentra, es que no existe
		
		/*
		 * Consultar agentes con una determinada ciudadInicial
		 */
		
		public List<Agente> consultarAgentesCiudadInicial(String ciudadInicial) //NO CREO
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
		
		public List<Agente> consultarAgentesCiudadObjetivo(String ciudadObjetivo) //NO CREO
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
			//Si la lista se devuelve vacia, senalamos que no hay elementos que se ajusten a nuestra busuqeda
		
		/*
		 * Consultar el número de agentes que hay en el contenedor
		 */
		
		int getNumeroDeAgentes(){ //SEGURO
			
			return Agentes.size();
		}
		
		
		
		
	
}
