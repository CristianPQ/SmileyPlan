import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class VistaMapa extends Vista3{
	private ControladorPresentacionMapa cpmapa;
	
	/*private JPanel panelCiudad; 
	private JPanel panelCaminos; 
	
	private JTextField txtIdCiutat; 
	private JTextField txtY; 
	private JTextField txtX; 
	private JTextField txtCO; 
	private JTextField txtCD; 
	private JTextField txtMedio;
	
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	*/
	boolean mapaCreado = false;
	VistaMapa (ControladorPresentacionMapa controladorPMapa){
		super();
		
		cpmapa = controladorPMapa;
		
		crearListeners();
		super.txtCO.setEditable(false);
		super.txtCD.setEditable(false);
		super.txtMedio.setEditable(false);
		super.txtIdCiutat.setEditable(false);
		super.txtX.setEditable(false);
		super.txtY.setEditable(false);
		
		
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
					String X = txtXMapa.getText();
					String Y = txtYMapa.getText();
					String Continente = txtConti.getText();
					cpmapa.crearMapa(Integer.parseInt(X), Integer.parseInt(Y), Continente);
					
					mapaCreado = true;
					
					txtCO.setEditable(true);
					txtCD.setEditable(true);
					txtMedio.setEditable(true);
					txtIdCiutat.setEditable(true);
					txtX.setEditable(true);
					txtY.setEditable(true);
				}
				//crear ciudad
				else if (txtCO.getText().equals("")){ //si el de cami esta buit
					String nom = txtIdCiutat.getText();
					String X = txtX.getText();
					String Y = txtY.getText();
					cpmapa.agregarCiudad(nom, Integer.parseInt(X), Integer.parseInt(Y));
				}
				//crear camino
				else if(txtIdCiutat.getText().equals("")){
					String ciudadO = txtCO.getText();
					String ciudadD = txtCD.getText();
					String md = txtMedio.getText();
					int cap = Integer.parseInt(txtCap.getText());
					cpmapa.agregarCamino(ciudadO,ciudadD,md,cap);
				}
				
			}
		
		});
	}
		  
		 
		
		
		
	
}
