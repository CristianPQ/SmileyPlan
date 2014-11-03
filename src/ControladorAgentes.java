import java.util.Iterator;
import java.util.Set;

public class ControladorAgentes {
		private Set<Agente> Agentes;
		
		
		void anadirAgente(String nombre, String ciudadInicial, String ciudadObjetivo){
			Agente a = new Agente(nombre, ciudadInicial, ciudadObjetivo);
			Agentes.add(a);
			
		}
		
		void eliminarAgente(String nombre){
			Iterator<Agente> it = Agentes.iterator();
			boolean fin = false;
				while (it.hasNext() && !fin){
					if ((it.next().getNombre()) == nombre) {
						Agentes.remove(it.next());
						fin = true;
					}
				}					
			}
		
		
	
}
