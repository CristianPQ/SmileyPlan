
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
		//vistaMedio = new VistaMedioTransporte(this); 
	}
	
	//A continuación crea todos los metodos que llaman al controlador
	
	public void agregarMedio(String nombre, int coste) throws Exception{
		cm.agregarMedioTransporte(nombre, coste);
	}
	
	public void agregarCoche(String nombre, int coste) throws Exception {
		cm.agregarCoche(nombre, coste);
	}
	
	public void agregarTren(String nombre, int coste) throws Exception {
		cm.agregarTren(nombre, coste);
	}
	
	public void borrarMedio(String nombre) throws Exception {
		cm.borrarMedioTransporte(nombre);
	}
	
	public void modificarNombre(String nNuevo, String n) throws Exception {
		cm.modificarNombre(nNuevo, n);
	}
	
	public void modificarPrecio(int pNuevo, String ident) throws Exception {
		cm.modificarPrecio(pNuevo, ident);
	}
	
	public void guardarMedio(String path, String file) throws Exception {
		cm.Guardar(file);
	}
	
	public void cargarMedio(String path, String file) throws Exception {
		cm.Cargar(file);
	}
	
	//***************************************************
	//*****************PANEL*****************************
	//***************************************************
	
	public VistaMedioTransporte getVista(){
		return vistaMedio; 
	}
	
	
}
