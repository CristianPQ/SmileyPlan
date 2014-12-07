import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public abstract class VistaMedioTransporte extends Vista2 {
	
	private ControladorPresentacionMedios cpm; 
	
	
	VistaMedioTransporte(ControladorPresentacionMedios cntrlpm){
		super(); 
		
		this.cpm = cntrlpm; 
		
		//super.vb.setLabelText(); 
		//super.vb.setButtonText(); 
		
		super.label1.setText("Nombre: ");
		super.label2.setText("Coste: ");
		
		crearListeners(); 
		
	}
	
	void crearListeners() {
		
		botonCrear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = text1.getText(); 
				int coste = Integer.parseInt(text2.getText()); 
				if (!text1.getText().equals("") && !text2.getText().equals(""))
					try {
						cpm.agregarMedio(nombre, coste);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}	
		});
		
		botonModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String linea = vb.DevolverSeleccionado(); 
				String nombreviejo = linea.split(" ")[0]; 
				String costeviejo = linea.split(" ")[1]; 
				if (!text1.getText().equals("")) {
					String nombrenuevo = text1.getText(); 
					cpm.modificarNombre(nombrenuevo, nombreviejo);
				}
				if (!text2.getText().equals("")) {
					String costenuevo = text2.getText(); 
					int costeN = Integer.parseInt(costenuevo);
					int costeV = Integer.parseInt(costeviejo);
					cpm.modificarPrecio(costeN, nombreviejo);
				}
			}
		});
		
		botonCargar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				abrirBrowserCargar(); 	
			}
			
		});
		
		botonGuardar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				abrirBrowserGuardar(); 
			}
			
		});
	}
	
	private void abrirBrowserCargar() {
		// TODO Auto-generated method stub
		
	}	
	
	private void abrirBrowserGuardar() {
		// TODO Auto-generated method stub
		
	}
}
