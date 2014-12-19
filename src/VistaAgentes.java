import java.awt.*;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class VistaAgentes extends Vista2 {
	
	private ControladorPresentacionAgentes ctrlPAg;
	private String identificador;
	private String tempIni;
	private String tempFi;
	
	VistaAgentes(ControladorPresentacionAgentes cpag){
		super();
		ctrlPAg = cpag;
		
		super.label1.setText("Nombre: ");
		super.label2.setText("Ciudad Inicial: ");
		label3 = new JLabel(); 
		super.label3.setText("Ciudad Objetivo: ");
		text3 = new JTextField(); 
		text3.setPreferredSize(new Dimension(100,30));
		text3.setEditable(true);
		super.panelLista.add(label3);
		super.panelLista.add(text3);
		super.filechooser.setDialogTitle("Elige archivo para los Agentes");   
		
		crearListeners();
	
	}
	
	public void actualizarLista(){
			//System.out.println("dentro de actualizarLista");
		vb.clear();
		ArrayList<String> agentes = ctrlPAg.listarAgentes();
		if(!agentes.isEmpty()) {
			for(int i = 0; i < agentes.size(); ++i) {
					//System.out.println("Agente: " + agentes.get(i));
				vb.agregar(agentes.get(i) + "  "
						+ctrlPAg.consultarCiudadInicial(agentes.get(i)) + "  "
						+	ctrlPAg.consultarCiudadObjetivo(agentes.get(i)));
			}	
		}
	}

	
	void crearListeners()  {
		
		botonCrear.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String nombre = text1.getText();
				String ciuIni = text2.getText();
				String ciuObj = text3.getText();
				if (nombre.equals("") || ciuIni.equals("") || ciuObj.equals(""))
					try {
						throw new Exception("Falta rellenar uno de los espacios");
					} catch (Exception e1) {
						setError(e1.getMessage());
					}
				
				else {
						ctrlPAg.agregarAgente(nombre, ciuIni, ciuObj);
						actualizarLista();
					}
				comprovar("");
				}	
		});
		
		botonModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = text1.getText(); 
				String ciuIni = text2.getText();
				String ciuObj = text3.getText();
				
				if (id.equals("") || ciuIni.equals("") || ciuObj.equals(""))
					try {
						throw new Exception("Falta rellenar uno de los espacios");
					} catch (Exception e1) {
						setError(e1.getMessage());
					}
				
				//text2.setText(identificador);
	//			if (!text1.getText().equals("") && !text2.getText().equals("")){
					if (identificador.equals(id)) {
				//		ctrlPAg.modificarCiudadInicial(id, ciuIni);
					if(ciuIni.equals(tempFi) && ciuObj.equals(tempIni)){
						try{
							throw new Exception("Para intercambiar, inténtelo por pasos");
							} catch (Exception e1){
								setError(e1.getMessage());
								
							}
						
					}
						if(!ciuIni.equals(tempIni)) {
							ctrlPAg.modificarCiudadInicial(id,ciuIni);
						}
						if(!ciuObj.equals(tempFi)) ctrlPAg.modificarCiudadObjetivo(id,ciuObj);
						vb.clear();
						actualizarLista();                
					}
					
					else {
						ctrlPAg.modificarNombre(identificador, id);
						vb.clear();
						actualizarLista();             
					}
					
                    text1.setText("");
                    text2.setText("");
			
        			comprovar("");
			}
		});
	
		
		botonEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = text1.getText(); 
				ctrlPAg.eliminarAgente(id);
				vb.clear();
				actualizarLista();
                text1.setText("");
                text2.setText("");	
                text3.setText("");
			}});
		
		
		super.vb.agregarSelecListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				   if (vb.haySeleccionado()) {
	                   String linea = vb.devolverSeleccionado();
	                    String nombre = linea.split(" ")[0];
	                    String ciuIni = linea.split("  ")[1];
	                    String ciuObj = linea.split("  ")[2];
	                    text1.setText(nombre);
	                    text2.setText(ciuIni);
	                    text3.setText(ciuObj);
	                    identificador = nombre;
	                    tempIni = ciuIni;
	                    tempFi = ciuObj;
	                    
	                }
	                else {
	                    text1.setText("");
	                    text2.setText("");
	                    text3.setText(" ");
	                }
					comprovar("");
			}       
        });
		
		botonCargar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				abrirBrowserCargar(); 	
				comprovar("");	
			}
			
			
		});
		
		botonGuardar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if (vb.listaEsVacia()) setError("No hay nada para guardar"); 
				else abrirBrowserGuardar(); 
				comprovar("");
			}
			
		});

	}
	public void abrirBrowserGuardar() {
		   JFrame parentFrame = new JFrame();
	 		int userSelection = filechooser.showSaveDialog(parentFrame);
	 		if (userSelection == JFileChooser.APPROVE_OPTION) {
	 			String file = filechooser.getSelectedFile().getAbsolutePath(); 
	 			file = file.concat(".smiley");
	 			ctrlPAg.guardarAgente(file);
	 		}
	}
	
	public void abrirBrowserCargar() {
		JFrame parentFrame = new JFrame();
		int userSelection = filechooser.showOpenDialog(parentFrame);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			String file = filechooser.getSelectedFile().getAbsolutePath();
			ctrlPAg.cargarAgente(file);
			actualizarLista();
		}
		
	}		
}

	
