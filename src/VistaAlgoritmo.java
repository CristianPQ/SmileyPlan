import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.util.*;

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

    private VistaBuscador vis2;
    private VistaBuscador vis3;
    private JTextArea textarea; 
    private JButton botonEjecutar; 
    private boolean ff;
    private boolean dinic;
    private boolean pr;
    protected JTextField CiuO;
    protected JTextField CiuD;
    //private JTextField texto; 
   // protected VistaBuscador vb; 
    protected JPanel panelEjec; 
	
	private boolean esPrecio = false; 
	private boolean esDistancia = false; 
	
	VistaAlgoritmo(ControladorPresentacionAlgoritmo cpa){
		super(); 
		ff=true;
		dinic = false;
		pr = false;
		this.cpalg = cpa;

		vis2 = new VistaBuscador(this);
		vis3 = new VistaBuscador(this);
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
		grupoAlg.add(D);
		panelAlg.add(FF);
		panelAlg.add(PR); 
		panelAlg.add(D);
		super.panelv2.add(panelAlg);
		super.panelv2.remove(panelBotones);
		//super.panelPrincipal.remove(vb); 
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
		
		//model = new DefaultListModel();
	    //l = new JList(model);
	//	JTextArea textArea = new JTextArea();
		/*
	    scroller = new JScrollPane(textArea);
	    scroller.setMinimumSize(new Dimension(500,250));
	    scroller.setMaximumSize(new Dimension(500,250));
	    */
	    //texto = new JTextField();
        //texto.setPreferredSize(new Dimension(120,30));
		
		//vb = new VistaBuscador(this);
		        
        super.panelv2.add(vb);
        
		super.panelv2.add(vis2);
		super.panelv2.add(vis3);
        
        panelEjec = new JPanel(); 
		panelEjec.setBorder(BorderFactory.createLoweredBevelBorder());
		panelEjec.setMinimumSize(new Dimension(600,100));
		panelEjec.setMaximumSize(new Dimension(600,100));
		
        CiuO = new JTextField();
      	CiuO.setPreferredSize(new Dimension(100,30));
      	CiuO.setEditable(true);
      	CiuD = new JTextField();
      	CiuD.setPreferredSize(new Dimension(100,30));
      	CiuD.setEditable(true);
      	
      	
      	panelEjec.add(CiuO);
      	panelEjec.add(CiuD);
      	
        botonEjecutar = new JButton();
        botonEjecutar.setText("Ejecutar");
        panelEjec.add(botonEjecutar);
        
        super.panelv2.add(panelEjec);
      
		//actualizarInformacion();
        crearListeners();
	}
	
	void crearListeners() {
		
		
		botonEjecutar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				cpalg.initItinerarios();
				if(ff)vb.clear();
				else if(pr)vis2.clear();
				else if(dinic) vis3.clear();
				String source = CiuO.getText();
				String sink = CiuD.getText();
				if (source.equals("") || sink.equals(""))
					try {
						throw new Exception("Falta rellenar alguno de los espacios");
					} catch (Exception e1) {
						setError(e1.getMessage());
					}
				else {
					boolean funcionCoste;
					if (precio.isSelected()) funcionCoste = false;
					else funcionCoste = true;

					if (ff) cpalg.ejecutar(1,source,sink,funcionCoste);
					else if (pr)  cpalg.ejecutar(2,source,sink,funcionCoste);
					else if (dinic) cpalg.ejecutar(3,source,sink,funcionCoste);
					String carga = cpalg.escribirItinearios();
					String[] l = carga.split("\n");

					 for (int i = 0; i < l.length; ++i ){
						if(ff)vb.agregar(l[i]);
						else if(pr) vis2.agregar(l[i]);
						else if(dinic)  vis3.agregar(l[i]);		
					 	}

					}
				}
		});
		
		FF.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//cpalg.ejecutar(1); 
				//actualizarInformacion(); 
				ff= true;
				dinic=false;
				pr = false;	
				
			}
		});
		
		PR.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//actualizarInformacion(); 
				//cpalg.ejecutar(2); 
				//actualizarInformacion();
				ff= false;
				dinic=false;
				pr = true;
			}
		});
		
		D.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//cpalg.ejecutar(3); 
				//actualizarInformacion();
				ff= false;
				dinic=true;
				pr = false;
			}
		});
		
		precio.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		distancia.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}
	
	public void actualizarInformacion(){
		textarea.setText(null);
		//String respuesta = cpalg.escribirItinearios(); 
		String respuesta = "hola"; 
		textarea.setText(respuesta); 
	}
	
}
