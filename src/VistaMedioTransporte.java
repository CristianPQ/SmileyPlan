import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class VistaMedioTransporte extends Vista2 {
	
	private ControladorPresentacionMedios cpm; 
	private String identificador; 
	private JRadioButton coche; 
	private JRadioButton tren; 
	private ButtonGroup grupob; 
	
	
	VistaMedioTransporte(ControladorPresentacionMedios cntrlpm){
		super(); 
		
		this.cpm = cntrlpm; 
		
		//super.vb.setLabelText(); 
		//super.vb.setButtonText(); 
		
		super.label1.setText("Nombre: ");
		super.label2.setText("Coste: ");
		
		
		grupob = new ButtonGroup(); 
		coche = new JRadioButton("coche");
		tren = new JRadioButton("tren"); 
		grupob.add(coche);
		grupob.add(tren);
	
		
		super.panelLista.add(coche);
		super.panelLista.add(tren); 
		
		
		//coche.setSelected(false);
		//tren.setSelected(false);

		
		
		crearListeners(); 
		
	}
	
	private void actualizarLista(){
		ArrayList<String> medios = cpm.listarMedios();
		if(!medios.isEmpty())
		for(int i = 0; i < medios.size(); ++i) {
			vb.agregar(medios.get(i) + "  "+cpm.consultarCoste(medios.get(i)));
			}
		}
	
	void crearListeners() {
		
		/**
		 * BOTON CREAR
		 */
		botonCrear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = text1.getText(); 
				int coste = Integer.parseInt(text2.getText()); 
				if (!text1.getText().equals("") && !text2.getText().equals("")){
							cpm.agregarMedio(nombre, coste);
							vb.clear();
		                    actualizarLista();
							text1.setText("");
		                    text2.setText("");
						}
					}
		});
		
		/**
		 * BOTON MODIFICAR
		 */
		botonModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = text1.getText(); 
				String coste = text2.getText();
				//text2.setText(identificador);
				if (!text1.getText().equals("") && !text2.getText().equals("")){
					if (identificador.equals(id)) {
						int c = Integer.parseInt(coste); 
						cpm.modificarPrecio(c, id);
						vb.clear();
						actualizarLista();                
					}
					else {
						cpm.modificarNombre(id, identificador);
						vb.clear();
						actualizarLista();             
					}
					
                    text1.setText("");
                    text2.setText("");
                   // vb.quitarSeleccion();
				}
			}
		});
		
		botonEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = text1.getText(); 
				cpm.borrarMedio(id);
				vb.clear();
				actualizarLista();
                text1.setText("");
                text2.setText("");	
			}});
		
		
		
		
		
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
		
		/**
		 * Seleccionar un elemento de la lista y que se vea en cuadros de texto
		 */
		super.vb.agregarSelecListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				   if (vb.haySeleccionado()) {
	                   String linea = vb.devolverSeleccionado();
	                    String nombre = linea.split(" ")[0];
	                    String coste = linea.split("  ")[1];
	                    text1.setText(nombre);
	                    text2.setText(coste);
	                    identificador = nombre;
	                }
	                else {
	                    text1.setText("");
	                    text2.setText("");
	                }
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
