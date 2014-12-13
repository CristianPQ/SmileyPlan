import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VistaMedioTransporte extends Vista2 {
	
	private ControladorPresentacionMedios cpm; 
	private String identificador; 
	private JRadioButton coche; 
	private JRadioButton tren; 
	private ButtonGroup grupob; 
	
	private boolean esCoche = false; 
	private boolean esTren = false; 
	
	
	VistaMedioTransporte(ControladorPresentacionMedios cntrlpm){
		super(); 
		
		this.cpm = cntrlpm; 
		
		super.label1.setText("Nombre: ");
		super.label2.setText("Coste: ");
		
		grupob = new ButtonGroup(); 
		coche = new JRadioButton("coche");
		tren = new JRadioButton("tren"); 
		coche.setSelected(true); 
		grupob.add(coche);
		grupob.add(tren);
		super.panelLista.add(coche);
		super.panelLista.add(tren); 
		
		
	    //super.chooser.setFileFilter(new FileNameExtensionFilter(".Medios"));
       // super.filechooser.setApproveButtonText("Abrir Medios de Transporte");
		super.filechooser.setDialogTitle("Elige archivo para los Medios de Transporte");   
		
		crearListeners(); 
	}
	
	public void actualizarLista(){
		ArrayList<String> medios = cpm.listarMedios();
		if(!medios.isEmpty()) 
		for(int i = 0; i < medios.size(); ++i) {
			if (cpm.esTren(medios.get(i))) {
				vb.agregar(medios.get(i) + "  "+cpm.consultarCoste(medios.get(i)) + "  " + "Tren");
			}
			else vb.agregar(medios.get(i) + "  "+cpm.consultarCoste(medios.get(i)) + "  " + "Coche");
		}
	}
	
	public static boolean isNumeric(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}
	
	void crearListeners() {
		
		
		coche.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				esTren = false;
				esCoche = true; 
			}
			
		});
		
		tren.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				esCoche = false; 
				esTren = true;
			}			
		});
		
		
		/**
		 * BOTON CREAR
		 */
		botonCrear.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = text1.getText(); 
				String c = text2.getText(); 
				if (nombre.equals("") || c.equals(""))
					try {
						throw new Exception("Falta rellenar uno de los espacios");
					} catch (Exception e1) {
						setError(e1.getMessage());
					}
				else {
					if (!isNumeric(c)){
						try {
							throw new Exception("El valor de coste debe ser numerico");
						} catch (Exception e1) {
							setError(e1.getMessage());
						}
					}
					if (isNumeric(nombre)) {
						try {
							throw new Exception("Nombre no puede tener un valor numerico");
						} catch (Exception e1) {
							setError(e1.getMessage());
						}
					}
					else{
						int coste = Integer.parseInt(c); 
						if(esCoche)	cpm.agregarCoche(nombre, coste);	
						else if (esTren) cpm.agregarTren(nombre,coste);
						else cpm.agregarCoche(nombre, coste);
						//else throw new Exception("Debes elegir si es tren o coche"); 
						//cpm.agregarMedio(nombre, coste);
						vb.clear();
			            actualizarLista();
			            text1.setText("");
			            text2.setText("");
					}
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
				if (!text1.getText().equals(" ") && !text2.getText().equals(" ")){
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
				try {
					abrirBrowserCargar();
				} catch (Exception e1) {
					setError(e1.getMessage());
				} 	
			}
			
		});
		
		botonGuardar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if (vb.listaEsVacia()) setError("No hay nada para guardar"); 
				else abrirBrowserGuardar();
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
	
	public void abrirBrowserGuardar()  {
		   JFrame parentFrame = new JFrame();
	 		int userSelection = filechooser.showSaveDialog(parentFrame);
	 		if (userSelection == JFileChooser.APPROVE_OPTION) {
	 			String file = filechooser.getSelectedFile().getAbsolutePath(); 
	 			file = file.concat(".medios");
	 			cpm.guardarMedio(file);
	 		}
	}
	
	public void abrirBrowserCargar() throws Exception {
		JFrame parentFrame = new JFrame();
 		int userSelection = filechooser.showOpenDialog(parentFrame);
 		if (userSelection == JFileChooser.APPROVE_OPTION) {
 			String file = filechooser.getSelectedFile().getAbsolutePath(); 
 			boolean success = cpm.cargarMedio(file);
			if (success) actualizarLista();
 		}
		
	}	
	

}
