import java.awt.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public abstract class VistaAlgoritmo extends Vista2 {
	
	private ControladorPresentacionAlgoritmo cpalg; 
	private JRadioButton distancia; 
	private JRadioButton precio; 
	private ButtonGroup GrupoCoste; 
	private JRadioButton FF; 
	private JRadioButton PR; 
	private JRadioButton D; 
	private ButtonGroup grupoAlg; 
	
	private boolean esPrecio = false; 
	private boolean esDistancia = false; 
	
	VistaAlgoritmo(ControladorPresentacionAlgoritmo cpa){
		super(); 
		
		this.cpalg = cpa;
		super.label1.setText("Funcion de Coste: ");
		
		GrupoCoste = new ButtonGroup(); 
		precio = new JRadioButton("precio");
		distancia = new JRadioButton("distancia"); 
		precio.setSelected(true); 
		GrupoCoste.add(precio);
		GrupoCoste.add(distancia);
		super.panelLista.add(precio);
		super.panelLista.add(distancia); 
		
		grupoAlg = new ButtonGroup(); 
		FF = new JRadioButton("Ford Fulkerson");
		PR = new JRadioButton("Push Relabel"); 
		D = new JRadioButton("Dinic"); 
		FF.setSelected(true); 
		grupoAlg.add(FF);
		grupoAlg.add(PR);
		super.panelLista.add(FF);
		super.panelLista.add(PR); 
		super.panelLista.add(D);
		
	}
	
}
