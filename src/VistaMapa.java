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
	
	private JPanel panelCiudad; 
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
	
	VistaMapa (ControladorPresentacionMapa controladorPMapa){
		super();
		
		cpmapa = controladorPMapa;
		
		crearListeners();
	}
	
	void crearListeners() {
		
	}
}
