import java.util.Iterator;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class ControladorAgentes {
		private Set<Agente> Agentes;
		
		private static Exception NombreYaExiste = new Exception ("El agente ya existe");
		private static Exception NoExiste = new Exception ("El agente no existe");
		private static Exception ListaVacia = new Exception ("No existen elementos que se ajusten a su solicitud");
	
		
		public void eliminarTodo(){
			Agentes.clear();
		}
		
		
		public void anadirAgente(String nombre, String ciudadInicial, String ciudadObjetivo)
				throws Exception{
			
			if (Agentes.contains(nombre)) throw NombreYaExiste;
			else{
				Agente a = new Agente(nombre, ciudadInicial, ciudadObjetivo);
				Agentes.add(a);
				}
			}
		
		
		public void eliminarAgente(String nombre) throws Exception{
			
			Iterator<Agente> it = Agentes.iterator();
			boolean fin = false;
				while (it.hasNext() && !fin){ 
					if ((it.next().getNombre()) == nombre) {
						Agentes.remove(it.next());
						fin = true;
					}
				}if (!fin) throw NoExiste;		
			}
			//acaba al encontrar el agente que quiere eliminar
			//si llega al final y no se encuentra, es que no existe
		
		
		public void modificarNombreAgente(String nombreAntiguo, String nombreNuevo)throws Exception{
			
			Iterator<Agente> it = Agentes.iterator();
			boolean fin = false;
				while (it.hasNext() && !fin){
					if ((it.next().getNombre()) == nombreAntiguo) {
						it.next().setNombre(nombreNuevo);
						fin = true;
					}
				}if (!fin) throw NoExiste;
			}
			//acaba al encontrar el agente que quiere eliminar
			//si llega al final y no se encuentra, es que no existe
	
		
		public void modificarCiudadInicialAgente(String nombre, String ciudadInicial)
			throws Exception{
			
			Iterator<Agente> it = Agentes.iterator();
			boolean fin = false;
				while (it.hasNext() && !fin){
					if ((it.next().getNombre()) == nombre) {
						it.next().setCiudadInicial(ciudadInicial);
						fin = true;
					}
				}if (!fin) throw NoExiste;				
			}
			//acaba al encontrar el agente que quiere eliminar
			//si llega al final y no se encuentra, es que no existe
		
		
		public void modificarCiudadObjetivoAgente(String nombre, String ciudadObjetivo)
			throws Exception{
			
			Iterator<Agente> it = Agentes.iterator();
			boolean fin = false;
				while (it.hasNext() && !fin){
					if ((it.next().getNombre()) == nombre) {
						it.next().setCiudadObjetivo(ciudadObjetivo);
						fin = true; 
					}
				}if (!fin) throw NoExiste;
			}
			//acaba al encontrar el agente que quiere eliminar
			//si llega al final y no se encuentra, es que no existe
		
		
		public List<Agente> consultarAgentesCiudadInicial(String ciudadInicial)
			throws Exception{
			
			List<Agente> l = new ArrayList<Agente>();	
			Iterator<Agente> it = Agentes.iterator();
				while(it.hasNext()){ 
					if ((it.next().getCiudadInicial()) == ciudadInicial ) l.add(it.next());
				}
				if (l.isEmpty())  throw ListaVacia;
			return l;
			}	
			//Listar agentes con CiuIni concreta
			//recorrer toda la lista en busqueda de estos
			//si no se anade ningun elemento, mostrar que no hay elementos que se correspondan
			//con nuestra busqueda
		
		
		public List<Agente> consultarAgentesCiudadObjetivo(String ciudadObjetivo)
			throws Exception {
			
			List<Agente> l = new ArrayList<Agente>();
			Iterator<Agente> it = Agentes.iterator();
				while(it.hasNext()){
					if ((it.next().getCiudadObjetivo()) == ciudadObjetivo ) l.add(it.next());
				}
				if (l.isEmpty())  throw ListaVacia;
			return l;
			}
			//Listar agentes con CiuObj concreta
			//itera todo el set i si no encuentra nada devuelve que no hay elementos que se ajusten
			//a nuestra busqueda
		
		
		public List<Agente> consultarAgentesCiudadInicialObjetivo(String ciudadInicial, String ciudadObjetivo)
			throws Exception{ 
			
			List<Agente> l = new ArrayList<Agente>();
			Iterator<Agente> it = Agentes.iterator();
				while(it.hasNext()){
					if ((it.next().getCiudadObjetivo()) == ciudadObjetivo &&
							it.next().getCiudadInicial() == ciudadInicial) l.add(it.next()); 
				}if (l.isEmpty())  throw ListaVacia;
				return l;
			}
			//consultar agentes con una determinada ciuIni y ciuObj (que cumplan ambas) 
			//Si la lista se devuelve vacia, senalamos que no hay elementos que se ajusten a nuestra busuqeda
		
		
		int getNumeroDeAgentes(){
			
			return Agentes.size();
		}
		
		
		
		
	
}
