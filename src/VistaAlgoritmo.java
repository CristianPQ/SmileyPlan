import java.awt.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class VistaAlgoritmo extends Vista2 {
	
	private ControladorPresentacionAlgoritmo cpalg; 
	private JRadioButton distancia; 
	private JRadioButton precio; 
	private ButtonGroup GrupoCoste; 
	private JRadioButton FF; 
	private JRadioButton PR; 
	private JRadioButton D; 
	private ButtonGroup grupoAlg; 
	private JLabel txtalg;
	private JLabel txtcoste; 
	
	private boolean esPrecio = false; 
	private boolean esDistancia = false; 
	
	VistaAlgoritmo(ControladorPresentacionAlgoritmo cpa){
		super(); 
		
		this.cpalg = cpa;
		//super.label1.setText("Funcion de Coste: ");
		
		panelLista.removeAll();
		GrupoCoste = new ButtonGroup(); 
		precio = new JRadioButton("precio");
		distancia = new JRadioButton("distancia"); 
		precio.setSelected(true); 
		GrupoCoste.add(precio);
		GrupoCoste.add(distancia);
		txtcoste = new JLabel("Funcion de coste");
		txtcoste.setFont(new Font("Verdana",1,20));
		panelLista.add(txtcoste);
		super.panelLista.add(precio);
		super.panelLista.add(distancia); 
		
		grupoAlg = new ButtonGroup(); 
		FF = new JRadioButton("Ford Fulkerson");
		PR = new JRadioButton("Push Relabel"); 
		D = new JRadioButton("Dinic"); 
		FF.setSelected(true); 
		
		txtalg = new JLabel("Algoritmos");
		txtalg.setFont(new Font("Verdana",1,20));
		panelLista.add(txtalg);
		grupoAlg.add(FF);
		grupoAlg.add(PR);
		super.panelLista.add(FF);
		super.panelLista.add(PR); 
		super.panelLista.add(D);
		
	}
	
}
