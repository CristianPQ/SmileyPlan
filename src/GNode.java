import java.util.*;


	
public class GNode {
	
	private ArrayList<GNodePeso> hijos;
	private String nombreCiudad;

	public GNode(String nCiudad) {
		nombreCiudad = nCiudad;
	}
	
	public void agregarHijo(int f, int ca, int co, String nCiudad) {
		hijos.add(new GNodePeso(f, ca, co, nCiudad));
		hijos = new ArrayList<GNodePeso>();
	}
	
	public void eliminarHijo(String nCiudad) {
		hijos.remove(nCiudad);
	}
	
	public Iterator<GNodePeso> consultarIteradorHijos() {
		return hijos.iterator();
	}
	
	/*public void modificarNodoHijo(Iterator<GNodePeso> it, GNode n) {
		GNodePeso np = it.;
		
	}*/
	
}
	
	
