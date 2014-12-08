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
		 *//*
		botonCrear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		}
		*/
		  
		 
		
		
		
	}
}
