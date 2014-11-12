import java.util.*;


public class GNode {
	String nombreCiudad;
	private ArrayList<GNode> hijos;
	
	public GNode(String nCiudad) {
		nombreCiudad = nCiudad;
		hijos = new ArrayList<GNode>();
	}
	
	public ArrayList<GNode> consultarHijos() {
		return hijos;
	}
	
	/*private ArrayList<GNodePeso> hijos;
	private String nombreCiudad;

	public GNode(String nCiudad) {
		nombreCiudad = nCiudad;
		hijos = new ArrayList<GNodePeso>();
	}
	
	public void agregarHijo(int f, int ca, int co, String nCiudad) {
		hijos.add(new GNodePeso(f, ca, co, nCiudad));
	}
	
	public void eliminarHijo(String nCiudad) {
		hijos.remove(nCiudad);
	}
	
	public Iterator<GNodePeso> consultarIteradorHijos() {
		return hijos.iterator();
	}*/
	
	/*public void modificarNodoHijo(Iterator<GNodePeso> it, GNode n) {
		GNodePeso np = it.;
		
	}*/
	
}
	
	
