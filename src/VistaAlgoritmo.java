import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

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
	private JPanel PanelAlg; 
	private DefaultListModel model;
	private JList l;
    private JScrollPane scroller;
    private VistaBuscador vis; 
    private JTextField texto; 
	
	private boolean esPrecio = false; 
	private boolean esDistancia = false; 
	
	VistaAlgoritmo(ControladorPresentacionAlgoritmo cpa){
		super(); 
		
		this.cpalg = cpa;
		//super.label1.setText("Funcion de Coste: ");
		vis = new VistaBuscador(this); 
		panelLista.removeAll();
		
		JPanel panelAlg = new JPanel(); 
		panelAlg.setBorder(BorderFactory.createLoweredBevelBorder());
		panelAlg.setMinimumSize(new Dimension(600,100));
		panelAlg.setMaximumSize(new Dimension(600,100));
		grupoAlg = new ButtonGroup(); 
		FF = new JRadioButton("Ford Fulkerson");
		PR = new JRadioButton("Push Relabel"); 
		D = new JRadioButton("Dinic"); 
		FF.setSelected(true); 
		txtalg = new JLabel("Algoritmo");
		txtalg.setFont(new Font("Verdana",1,20));
		panelAlg.add(txtalg);
		grupoAlg.add(FF);
		grupoAlg.add(PR);
		panelAlg.add(FF);
		panelAlg.add(PR); 
		panelAlg.add(D);
		super.panelv2.add(panelAlg);
		super.panelv2.remove(panelBotones);
		super.panelPrincipal.remove(vb); 
		//super.vb.remove(botonBuscar);
		
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
		
		model = new DefaultListModel();
	    l = new JList(model);
	    scroller = new JScrollPane(l);
	    scroller.setMinimumSize(new Dimension(500,250));
	    scroller.setMaximumSize(new Dimension(500,250));
	    //texto = new JTextField();
        //texto.setPreferredSize(new Dimension(120,30));
        
        super.panelv2.add(scroller);
		
	}
	
}
