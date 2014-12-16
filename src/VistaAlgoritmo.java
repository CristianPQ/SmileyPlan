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
    private JTextArea textarea; 
    private JButton botonEjecutar; 
    private boolean ff;
    private boolean dinic;
    private boolean pr;
    protected JTextField text1;
    protected JTextField text2;
    //private JTextField texto; 
	
	private boolean esPrecio = false; 
	private boolean esDistancia = false; 
	
	VistaAlgoritmo(ControladorPresentacionAlgoritmo cpa){
		super(); 
		ff=false;
		dinic = false;
		pr = false;
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
		
		//model = new DefaultListModel();
	    //l = new JList(model);
		JTextArea textArea = new JTextArea();
		
	    scroller = new JScrollPane(textArea);
	    scroller.setMinimumSize(new Dimension(500,250));
	    scroller.setMaximumSize(new Dimension(500,250));
	    //texto = new JTextField();
        //texto.setPreferredSize(new Dimension(120,30));
        
        super.panelv2.add(scroller);
        panelLista = new JPanel(); 
		panelLista.setBorder(BorderFactory.createLoweredBevelBorder());
		panelLista.setMinimumSize(new Dimension(600,100));
		panelLista.setMaximumSize(new Dimension(600,100));
		
        text2 = new JTextField();
      	text2.setPreferredSize(new Dimension(100,30));
      	text2.setEditable(true);
      	text1 = new JTextField();
      	text1.setPreferredSize(new Dimension(100,30));
      	text1.setEditable(true);
      	
      	
      	super.panelLista.add(text1);
      	super.panelLista.add(text2);
      	
        botonEjecutar = new  JButton("Ejecutar");
        super.panelLista.add(botonEjecutar);
        
        super.panelv2.add(panelLista);
      
		
	}
	
	void crearListeners() {
		botonEjecutar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String source = text1.getText();
				String sink = text2.getText();
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
