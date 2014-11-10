import java.util.*;

import GNode.GNodePeso;

	
public class GNode {
	
	public class GNodePeso {
		int flujo;
		int capacidad;
		int coste;
		GNode nodo = null;
		
		public GNodePeso(int f, int ca, int co, String nCiudad) {
			flujo = f;
			capacidad = ca;
			coste = co;
			nodo = new GNode(nCiudad);
		}
		
		public int consultarCapacidad() {
			return capacidad;
		}
		
		public int consultarFlujo() {
			return flujo;
		}
		
		public void modificarFlujo(int nuevoFlujo) {
			flujo = nuevoFlujo;
		}
		
		public int consultarCoste() {
			return coste;
		}
		
	}
	
	ArrayList<GNodePeso> hijos;
	String nombreCiudad;

	public GNode(String nCiudad) {
		nombreCiudad = nCiudad;
	}
	
	public void agregarHijo(int f, int ca, int co, String nCiudad) {
		hijos.add(new GNodePeso(f, ca, co, nCiudad));
	}
	
	public void eliminarHijo(String nCiudad) {
		hijos.remove(nCiudad);
	}
	
	public Iterator<GNodePeso> primerHijo() {
		return hijos.iterator();
	}
	
}
	
	
