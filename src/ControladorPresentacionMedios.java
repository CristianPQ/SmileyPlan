import java.util.*;
import java.awt.Component;

import javax.swing.*;

public class ControladorPresentacionMedios {
	
	private static ControladorMedioTransporte cm; 
	private static VistaMedioTransporte vistaMedio; 
	
	public ControladorPresentacionMedios() {
		//crea el controlador de datos de medio de transporte
		cm = new ControladorMedioTransporte(); 
		
		//crea la vista de medio de transporte y se pasa a si mismo 
		//como parametro
		vistaMedio = new VistaMedioTransporte(this); 
	}
	
	//A continuación crea todos los metodos que llaman al controlador
	
	public void agregarMedio(String nombre, int coste){
		try {
			cm.agregarMedioTransporte(nombre, coste);
		} catch (Exception e) {
			vistaMedio.setError(e.getMessage());
		}
	}
	
	public void agregarCoche(String nombre, int coste) {
		try {
			cm.agregarCoche(nombre, coste);
		} catch (Exception e) {
			vistaMedio.setError(e.getMessage());
		}
	}
	
	public void agregarTren(String nombre, int coste)  {
		try {
			cm.agregarTren(nombre, coste);
		} catch (Exception e) {
			vistaMedio.setError(e.getMessage());
		}
	}
	
	public void borrarMedio(String nombre) {
		try {
			cm.borrarMedioTransporte(nombre);
		} catch (Exception e) {
			vistaMedio.setError(e.getMessage());
		}
	}
	
	public void modificarNombre(String nNuevo, String n) {
		try {
			cm.modificarNombre(nNuevo, n);
		} catch (Exception e) {
			vistaMedio.setError(e.getMessage());
		}
	}
	
	public ArrayList<String> listarMedios(){
		
		String nombres = cm.NombresMedios();
		ArrayList<String> ret = new ArrayList<String>();
		if(nombres == null) return ret;
		int i = 0;
		String nom;
		while (i < nombres.length()){
			nom = "";
			nom += nombres.charAt(i);
			++i;
			while (nombres.charAt(i) != ' '){
				nom += nombres.charAt(i);
				++i;	
			}
			++i;
			if (nom.charAt(0) != ' ') ret.add(nom);			
		}
		
		return ret;
	}
	
	public int consultarCoste(String nombre){
		return cm.consultarCoste(nombre);
	}
	
	public void modificarPrecio(int pNuevo, String ident) {
		try {
			cm.modificarPrecio(pNuevo, ident);
		} catch (Exception e) {
			vistaMedio.setError(e.getMessage());
		}
	}
	
	public void guardarMedio(String file) {
		try {
			cm.Guardar(file);
		} catch (Exception e) {
			vistaMedio.setError(e.getMessage());
		}
	}
	
	public boolean cargarMedio(String file) throws Exception {
		boolean success = cm.Cargar(file);
		return success; 
	}
	
	public boolean esTren(String ident){
		return cm.esTren(ident); 
	}
	
	//***************************************************
	//*****************PANEL*****************************
	//***************************************************
	
	public VistaMedioTransporte getVista(){
		return vistaMedio; 
	}
	public ControladorMedioTransporte devolverControlador(){
		return cm;	
	}
	
}
