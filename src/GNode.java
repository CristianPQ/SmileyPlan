import java.util.*;


	
public class GNode {
	
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
	
	public Iterator<GNodePeso> consultarIteradorHijos() {
		return hijos.iterator();
	}
	
}
	
	
