//import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.ArrayList;

//import javax.swing.BorderFactory;
//import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
//import javax.swing.filechooser.FileNameExtensionFilter;

public class VistaMapa extends Vista3{
	
	private ControladorPresentacionMapa cpmapa;
	private String identificador; 
	private String id2;
	private String id3; 
	
	//private JLabel cami; 
	//private JLabel ciutat; 
	//private VistaGrafo vg;
	
	//boolean mapaCreado = false;
	
	
	
	public VistaMapa (ControladorPresentacionMapa controladorPMapa){
		super();
		
		cpmapa = controladorPMapa;
		//super.vMatriz.controlador(controladorPMapa);
		
		crearListeners();
		super.botonGuardar.setVisible(false);
		super.botonCargar.setVisible(false);
		//super.panelLista.setVisible(false);
		/*super.txtCO.setEditable(false);
		super.txtCD.setEditable(false);
		super.txtMedio.setEditable(false);
		super.txtIdCiutat.setEditable(false);
		super.txtCap.setEditable(false);
		super.txtX.setEditable(false);
		super.txtY.setEditable(false);*/

		//vciut.add(cami, BorderLayout.NORTH);	

		//vg = new VistaGrafo();
		//super.panelPrincipal.add(vg); 
	}
	
	void crearListeners() {
		/**
		 * BOTON CREAR
		 */
		botonCrear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comprovar("");
				//crear mapa
				/*if (!mapaCreado){ 
					//System.out.println("crear mapa"); 
					String X = txtXMapa.getText();
					String Y = txtYMapa.getText();
					String Continente = txtConti.getText();
					if(Continente.equals(" ")) setError("falta delimitar el continente");
					
					if (!Y.equals("") && !X.equals("")){
						cpmapa.crearMapa(Integer.parseInt(X), Integer.parseInt(Y), Continente);
						mapaCreado = true;
						try {
							String[] s = cpmapa.listarCiudades();
							System.out.println(s[0]); 
							
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						//System.out.print(mapaCreado);
						txtCO.setEditable(true);
						txtCD.setEditable(true);
						txtMedio.setEditable(true);
						txtIdCiutat.setEditable(true);
						txtCap.setEditable(true);
						txtX.setEditable(true);
						txtY.setEditable(true);
						comprovar("");
						//vg.setLimites(Integer.parseInt(X),  Integer.parseInt(Y));
					}
				}
				
				//crear ciudad
				else */if (txtCO.getText().equals("")){ //si el de cami esta buit
					//System.out.println("crear ciudades"); 
					String nom = txtIdCiutat.getText();
					String SX = txtX.getText();
					String SY = txtY.getText();
					if (SX.equals("") || SY.equals("") || nom.equals("")) setError("Hay alguna casilla de Ciudad vacia");
					else{
					//vg.agregarCiudad(X, Y, nom);
						try {
							int X = Integer.parseInt(SX);
							int Y = Integer.parseInt(SY);
							cpmapa.agregarCiudad(nom, X, Y);
							vb.clear(); 
							actualizarListaCiudades();
							 txtIdCiutat.setText("");
					         txtY.setText("");
					         txtX.setText("");
							
						} catch (Exception e1) {
							setError(e1.getMessage());
						}
					}
				}
				//crear camino
				//else if(txtIdCiutat.getText().equals("")){
				else{
					//System.out.println("crear caminos"); 
					if (txtCO.getText().equals("") || txtCD.getText().equals("")
							|| txtCap.getText().equals("") || txtMedio.getText().equals("")) setError("Hay alguna casilla de Camino vacia");
					else {
						String ciudadO = txtCO.getText();
						String ciudadD = txtCD.getText();
						String md = txtMedio.getText();
						//vg.agregarCamino(ciudadO, ciudadD, txtCap.getText());
						try {
							int cap = Integer.parseInt(txtCap.getText());
							cpmapa.agregarCamino(ciudadO,ciudadD,md,cap);
							vciut.clear(); 
							actualizarListaCaminos();
							txtCO.setText("");
							txtCD.setText("");
							txtMedio.setText("");
							txtCap.setText("");
							
						} catch (Exception e1) {
							setError(e1.getMessage());
						} 
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
				comprovar("");
				//cas ciudades
			if (txtCO.getText().equals(""))	 {
				String nom = txtIdCiutat.getText();
				String X = txtX.getText();
				String Y = txtY.getText();	 
				if (!nom.equals("") && !X.equals("") && !Y.equals("")){
					if (identificador.equals(nom)) {
						int x = Integer.parseInt(txtX.getText());
						int y = Integer.parseInt(txtY.getText());
						try {
							cpmapa.modificarCoordenadas(nom,x,y);
							vb.clear();
							actualizarListaCiudades();
						} catch (Exception e1) {
							setError(e1.getMessage());             
					}		
					 txtIdCiutat.setText("");
			         txtY.setText("");
			         txtX.setText("");
					}
				}
			}
			else {
				//cas caminos
				String ciudadO = txtCO.getText();
				String ciudadD = txtCD.getText();
				String md = txtMedio.getText();
				String cap = txtCap.getText();
				if (!ciudadO.equals("") && !ciudadD.equals("") && !md.equals("") && !cap.equals("")){
					if(identificador.equals(ciudadO) && id2.equals(ciudadD) && id3.equals(md)){
						int capac = Integer.parseInt(cap);
						try {
							cpmapa.modificarCamino(ciudadO, ciudadD, md, capac);
							vciut.clear(); 
							actualizarListaCaminos();
						} catch (Exception e1) {
							setError(e1.getMessage());
						}
					} else
						try {
							throw new Exception("en un camino solo se puede modificar la capacidad");
						} catch (Exception e1) {
							setError(e1.getMessage());
						} 
				}
				txtCO.setText("");
				txtCD.setText("");
				txtMedio.setText("");
				txtCap.setText("");
			}
		}

	});
		
		/**
		 * Seleccionar un elemento de la lista ciudades y que se vea en cuadros de texto
		 */
		super.vb.agregarSelecListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				   if (vb.haySeleccionado()) {
	                   String linea = vb.devolverSeleccionado();
	                    String nom = linea.split(" ")[0];
	                    String X = linea.split(" ")[1];
	                    String Y = linea.split(" ")[2]; 
	                    txtIdCiutat.setText(nom);
	                    txtX.setText(X);
	                    txtY.setText(Y);
	                    identificador = nom;
	                }
	                else {
	                	txtIdCiutat.setText(" ");
	                    txtX.setText(" ");
	                    txtY.setText(" ");
	                }
			}       
        });
		
		/**
		 * Seleccionar un elemento de la lista caminos y que se vea en cuadros de texto
		 */
		super.vciut.agregarSelecListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				   if (vciut.haySeleccionado()) {
	                   String linea = vciut.devolverSeleccionado();
	                    String cdo = linea.split(" ")[0];
	                    String cdd = linea.split(" ")[1];
	                    String med = linea.split(" ")[2]; 
	                    String cap = linea.split(" ")[3]; 
	                    txtCO.setText(cdo);
						txtCD.setText(cdd);
						txtMedio.setText(med);
						txtCap.setText(cap);
	                    identificador = cdo;
	                    id2 = cdd;
	                    id3 = med; 
	                }
	                else {
	                	txtCO.setText("");
						txtCD.setText("");
						txtMedio.setText("");
						txtCap.setText("");
	                }
			}       
        });
		
		/**
		 * Boton Eliminar
		 */
		
		botonEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comprovar("");
				if (txtCO.getText().equals(""))	 {
					//cas ciutat
					String c = txtIdCiutat.getText(); 
					//vg.borarCiudad(c);
					//vb.clear(); 
					//vciut.clear();
					try {
						cpmapa.eliminarCiudad(c);
						actualizarListaCiudades();
						actualizarListaCaminos();
					} catch (Exception e1) {
						setError(e1.getMessage());
					}
					txtIdCiutat.setText("");
                    txtX.setText("");
                    txtY.setText("");
				}
				else {
					//cas caminos
					String ciudadO = txtCO.getText();
					String ciudadD = txtCD.getText();
					String md = txtMedio.getText();
					//vciut.clear(); 
					//vg.borrarCamino(ciudadO, ciudadD);
					try {
						cpmapa.eliminarCamino(ciudadO, ciudadD, md);
						actualizarListaCaminos();
					} catch (Exception e1) {
						setError(e1.getMessage()); 
					}
					txtCO.setText("");
					txtCD.setText("");
					txtMedio.setText("");
					txtCap.setText("");
				}
			}
		});
		
		//***************GESTION DATOS ***********//
		
		
		botoncaG.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				comprovar("");
				if (vciut.listaEsVacia()) setError("No hay nada para guardar"); 
				abrirBrowserGuardarCaminos();
			}
		});
		
		botoncaC.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				comprovar("");
				try {
					abrirBrowserCargarCaminos();
				} catch (Exception e1) {
					setError(e1.getMessage());
				} 	
			}
			
		});
		
		botonciG.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				comprovar("");
				if (vb.listaEsVacia()) setError("No hay nada para guardar"); 
				abrirBrowserGuardarCiudades();
			}
		});
		
		botonciC.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				comprovar("");
				try {
					abrirBrowserCargarCiudades();
				} catch (Exception e1) {
					setError(e1.getMessage());
				} 	
			}
			
		});
		
	}
		
		///FUNCIONES DE CARGAR/GUARDAR///////
		
	
		public void abrirBrowserGuardarCiudades()  {
			   JFrame parentFrame = new JFrame();
			   super.filechooser.setDialogTitle("Elige archivo para la Ciudad"); 
			   int userSelection = filechooser.showSaveDialog(parentFrame);
		 		if (userSelection == JFileChooser.APPROVE_OPTION) {
		 			String file = filechooser.getSelectedFile().getAbsolutePath(); 
		 			file = file.concat(".smiley");
		 			cpmapa.guardarCiudades(file);
		 		}
		}
		
		public void abrirBrowserCargarCiudades() throws Exception {
			JFrame parentFrame = new JFrame();
	 		super.filechooser.setDialogTitle("Elige archivo para la Ciudad");
	 		int userSelection = filechooser.showOpenDialog(parentFrame);  
	 		if (userSelection == JFileChooser.APPROVE_OPTION) {
	 			String file = filechooser.getSelectedFile().getAbsolutePath(); 
	 			boolean success = cpmapa.cargarCiudades(file);
				if (success) actualizarListaCiudades();
	 		}
		}
		
		public void abrirBrowserGuardarCaminos()  {
			   JFrame parentFrame = new JFrame();
		 		super.filechooser.setDialogTitle("Elige archivo para el Camino");
		 		int userSelection = filechooser.showSaveDialog(parentFrame);  
		 		if (userSelection == JFileChooser.APPROVE_OPTION) {
		 			String file = filechooser.getSelectedFile().getAbsolutePath(); 
		 			file = file.concat(".smiley");
		 			cpmapa.guardarCaminos(file);
		 		}
		}
		
		public void abrirBrowserCargarCaminos() throws Exception {
			JFrame parentFrame = new JFrame();
	 		super.filechooser.setDialogTitle("Elige archivo para el Camino");  
	 		int userSelection = filechooser.showOpenDialog(parentFrame);
	 		//FileNameExtensionFilter filtermapa = new FileNameExtensionFilter(".smiley", "smiley");
	 		//super.filechooser.setFileFilter(filtermapa);
	        //super.filechooser.addChoosableFileFilter(filtermapa);
	 		if (userSelection == JFileChooser.APPROVE_OPTION) {
	 			String file = filechooser.getSelectedFile().getAbsolutePath(); 
	 			boolean success = cpmapa.cargarCaminos(file);
				if (success) {
					//System.out.println("success"); 
					actualizarListaCaminos();
				}
	 		}
		}
		
		
		//// ACTUALIZAR LISTAS ////
		public void actualizarListaCiudades() throws Exception{
			vb.clear();
			String[] ciudades = cpmapa.listarCiudades();
			if(/*ciudades != null &&*/ ciudades.length > 0) {
				for(int i = 0; i < ciudades.length; ++i){
					String ciu = ciudades[i]; 
					//try{
						vb.agregar(ciu);
					//} catch (Exception e) {
						//setError(e.getMessage());
					//}
				}
			}
		}
		
		public void actualizarListaCaminos() throws Exception{
			String[] caminos = cpmapa.listarCaminos();
			vciut.clear();
			if(caminos.length > 0) {
				for(int i = 0; i < caminos.length; ++i) vciut.agregar(caminos[i]);
			}
		}
		
}
		  