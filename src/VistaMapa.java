import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class VistaMapa extends Vista3{
	
	private ControladorPresentacionMapa cpmapa;
	private String identificador; 
	private String id2;
	private String id3; 
	
	boolean mapaCreado = false;
	VistaMapa (ControladorPresentacionMapa controladorPMapa){
		super();
		
		cpmapa = controladorPMapa;
		
		crearListeners();
		super.txtCO.setEditable(false);
		super.txtCD.setEditable(false);
		super.txtMedio.setEditable(false);
		super.txtIdCiutat.setEditable(false);
		super.txtCap.setEditable(false);
		super.txtX.setEditable(false);
		super.txtY.setEditable(false);
		//VistaGrafo vg = new VistaGrafo();
		//super.panelPrincipal.add(vg); 
		
	}
	
	//
	public void actualizarListaCiudades() throws Exception{
		String[] ciudades = cpmapa.listarCiudades();
		if(ciudades.length != 0) {
			for(int i = 0; i < ciudades.length; ++i){
				String ciu = ciudades[i]; 
				//System.out.println(ciu + " " + cpmapa.coordX(ciu)+ " " + cpmapa.coordY(ciu)); 
				try {
					vb.agregar(ciu + "  "+ cpmapa.coordX(ciu)+ " " + cpmapa.coordY(ciu));
				} catch (Exception e) {
					setError(e.getMessage());
				}
			}
		}
	}
	
	public void actualizarListaCaminos() throws Exception{
		String[] caminos = cpmapa.listarCaminos();
		//System.out.println("vista mapa");
		//System.out.println(caminos[0]); 
		if(caminos.length != 0) {
			for(int i = 0; i < caminos.length; ++i) vciut.agregar(caminos[i]);
		}
	}

	
	void crearListeners() {
		/**
		 * BOTON CREAR
		 */
		botonCrear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//crear mapa
				if (!mapaCreado){ 
					//System.out.println("crear mapa"); 
					String X = txtXMapa.getText();
					String Y = txtYMapa.getText();
					String Continente = txtConti.getText();
					cpmapa.crearMapa(Integer.parseInt(X), Integer.parseInt(Y), Continente);
					
					mapaCreado = true;
					
					txtCO.setEditable(true);
					txtCD.setEditable(true);
					txtMedio.setEditable(true);
					txtIdCiutat.setEditable(true);
					txtCap.setEditable(true);
					txtX.setEditable(true);
					txtY.setEditable(true);
				}
				//crear ciudad
				else if (txtCO.getText().equals("")){ //si el de cami esta buit
					//System.out.println("crear ciudades"); 
					String nom = txtIdCiutat.getText();
					int X = Integer.parseInt(txtX.getText());
					int Y = Integer.parseInt(txtY.getText());	
					cpmapa.agregarCiudad(nom, X, Y);
					try {
						vb.clear(); 
						actualizarListaCiudades();
						 txtIdCiutat.setText("");
				         txtY.setText("");
				         txtX.setText("");
						
					} catch (Exception e1) {
						setError(e1.getMessage());
					}
				}
				//crear camino
				//else if(txtIdCiutat.getText().equals("")){
				else{
					//System.out.println("crear caminos"); 
					if (!txtCO.getText().equals("") && !txtCD.getText().equals("")
							&& !txtCap.getText().equals("")){
					String ciudadO = txtCO.getText();
					String ciudadD = txtCD.getText();
					String md = txtMedio.getText();
					int cap = Integer.parseInt(txtCap.getText());
					cpmapa.agregarCamino(ciudadO,ciudadD,md,cap);
					try {
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
				//cas ciudades
			if (txtCO.getText().equals(""))	 {
				String nom = txtIdCiutat.getText();
				String X = txtX.getText();
				String Y = txtY.getText();	 
				if (!nom.equals(" ") && !X.equals(" ") && !Y.equals(" ")){
					if (identificador.equals(nom)) {
						int x = Integer.parseInt(txtX.getText());
						int y = Integer.parseInt(txtY.getText());
						cpmapa.modificarCoordenadas(nom,x,y);
						vb.clear();
						try {
							actualizarListaCiudades();
						} catch (Exception e1) {
							setError(e1.getMessage());
						}                
					}		
					 txtIdCiutat.setText("");
			         txtY.setText("");
			         txtX.setText("");
					}
				}
			else {
				//cas caminos
				String ciudadO = txtCO.getText();
				String ciudadD = txtCD.getText();
				String md = txtMedio.getText();
				String cap = txtCap.getText();
				if (!ciudadO.equals(" ") && !ciudadD.equals(" ") && !md.equals(" ") && !cap.equals(" ")){
					if(identificador.equals(ciudadO) && id2.equals(ciudadD) && id3.equals(md)){
						int capac = Integer.parseInt(cap);
						cpmapa.modificarCamino(ciudadO, ciudadD, md, capac);
						vciut.clear(); 
						try {
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
				// TODO Auto-generated method stub
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
		
		
	}
}
		  