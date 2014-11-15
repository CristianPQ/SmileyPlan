import java.util.*;
public class ControladorAlgoritmo {
	private String[] relacCiudades;
	private Entrada e;
	private Solucion s;
	
	public ControladorAlgoritmo(Entrada ent) throws Exception{
		e = ent;
		s= new Solucion(); //esto puede cambiar
		
	}
	
	public void inicializarRelacCiudades(int size){
		relacCiudades = new String[size];
	}
	public void modificarRelacCiudad(String a, int i){
		relacCiudades[i] = a;
		}
	
	public String consultarElementRelacCiudades(int i){
		return relacCiudades[i];
	}
	
	public int consultarNumeroVertices(){
		return relacCiudades.length;
	}
	
	public int devolverIndiceCiudad(String city){
		int indice = -1;
		for (int i = 0; i < relacCiudades.length; ++i) 
			if (relacCiudades[i] == city) {indice = i; return indice;}
			return indice;
	}
	
	

	
	public void guardarSolucion(String path, String filename){}
}
