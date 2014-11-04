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
		
		public void modificarNombre(String nombreAntiguo, String nombreNuevo)throws Exception{
			Iterator<Agente> it = Agentes.iterator();
			boolean fin = false;
				while (it.hasNext() && !fin){
					if ((it.next().getNombre()) == nombreAntiguo) {
						it.next().setNombre(nombreNuevo);
						fin = true;
					}
				}if (!fin) throw NoExiste;	
			}
		
		public void modificarCiudadInicial(String nombre, String ciudadInicial)
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
		
		public void modificarCiudadObjetivo(String nombre, String ciudadObjetivo)

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
		
		public List<Agente> consultarAgentesCiudadInicial(String ciudadInicial)
			throws Exception{ //AG con CiIni concreta
			List<Agente> l = new ArrayList<Agente>();	
			Iterator<Agente> it = Agentes.iterator();
				while(it.hasNext()){
					if ((it.next().getCiudadInicial()) == ciudadInicial ) l.add(it.next());
				}
				if (l.isEmpty())  throw ListaVacia;
			return l;
			}
		
		public List<Agente> listarAgentesCiudadObjetivo(String ciudadObjetivo)
			throws Exception { //AG con CiObj concreta
			List<Agente> l = new ArrayList<Agente>();	
			Iterator<Agente> it = Agentes.iterator();
				while(it.hasNext()){
					if ((it.next().getCiudadObjetivo()) == ciudadObjetivo ) l.add(it.next());
				}
				if (l.isEmpty())  throw ListaVacia;
			return l;
			}
		
		public List<Agente> consultarAgentesCiudadInicialObjetivo(String ciudadInicial, String ciudadObjetivo)
			throws Exception{ 
			List<Agente> l = new ArrayList<Agente>();	
			Iterator<Agente> it = Agentes.iterator();
				while(it.hasNext()){
					if ((it.next().getCiudadObjetivo()) == ciudadObjetivo &&
							it.next().getCiudadInicial() == ciudadInicial) l.add(it.next());
				}
				if (l.isEmpty())  throw ListaVacia;
			return l;
			}
		
		int numeroDeAgentes(){
			return Agentes.size();
		}
		
		
		
		
	
}
