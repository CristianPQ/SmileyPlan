import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
//import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
//import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
//import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
//import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.util.*;

public class VistaAlgoritmo extends Vista2 {
	
	private ControladorPresentacionAlgoritmo cpalg; 
	private JRadioButton distancia; 
	private JRadioButton precio; 
	//private ButtonGroup GrupoCoste; 
	private JRadioButton FF; 
	private JRadioButton PR; 
	private JRadioButton D; 
	private ButtonGroup grupoAlg; 
	private JLabel txtalg;
	private JLabel txtcoste; 
	//private JPanel PanelAlg; 
	//private DefaultListModel model;
	//private JList l;
    //private JScrollPane scroller;

    private String ultimo_ej; 
    
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
    private JButton but;
    private JLabel labelco;
    private JLabel labelcd; 
	
	//private boolean esPrecio = false; 
	//private boolean esDistancia = false; 
	
	private GridBagConstraints mainCons = new GridBagConstraints();
	private GridBagConstraints mainCons2 = new GridBagConstraints();
	private GridBagConstraints mainCons3 = new GridBagConstraints();
	private GridBagLayout mainLayout = new GridBagLayout();
	
	private ArrayList<String> Segui = new ArrayList<String>();
	private int nivel = 0;
	
	private JButton solbut; 
	//private JPanel panelsol; 
	private JButton adel; 
	//private JButton atras; 
	
	VistaAlgoritmo(ControladorPresentacionAlgoritmo cpa){
		super(); 
		ff=true;
		dinic = false;
		pr = false;
		this.cpalg = cpa;

		//c = new GridBagConstraints(); 
		//c.fill = GridBagConstraints.HORIZONTAL; 
		vis2 = new VistaBuscador(this);
		vis3 = new VistaBuscador(this);
		//vis3.setLayout(null);
		//vis2.setLayout(null);
		//vb.setLayout(null); 
		
		
		super.panelv2.setLayout(mainLayout);
		//vis3.setLayout(new BoxLayout(vis3, BoxLayout.Y_AXIS));
		//vis3.setLayout(mainLayout);
		mainCons.gridy = 1;
		mainCons.gridx = 0; 
		mainCons.weightx = 1;
		mainCons.gridheight = 4;
		//mainCons.gridwidth = 2;
		mainCons.fill = GridBagConstraints.BOTH; 
		// fill, como se rellena el cuadrado donde esta contenido el boton
		mainCons.anchor = GridBagConstraints.WEST; 
	
		//vis2.setLayout(mainLayout);
		mainCons2.gridy = 1;
		mainCons2.gridx = /*(int)1.3*/ GridBagConstraints.RELATIVE;
		mainCons2.weightx = 1; 
		mainCons2.gridheight = 4;
		//mainCons2.gridwidth = 2;
		mainCons2.fill = GridBagConstraints.BOTH; 
		mainCons2.anchor = GridBagConstraints.NORTH; 
	
		
		//vb.setLayout(mainLayout);
		mainCons3.gridy = 1;
		mainCons3.gridx = /*(int)1.5*/ GridBagConstraints.RELATIVE; 
		mainCons3.weightx = 1;
		mainCons3.gridheight = 4;
		//mainCons3.gridwidth = 2;
		mainCons3.fill = GridBagConstraints.BOTH;
		mainCons3.anchor = GridBagConstraints.EAST; 

		panelLista.removeAll();
		
		super.remove(panelLista);
		super.panelv2.remove(panelLista);
		
		precio = new JRadioButton("precio");
		distancia = new JRadioButton("distancia"); 
		precio.setSelected(true); 
		
		txtcoste = new JLabel("Funcion de coste");
		txtcoste.setFont(new Font("Verdana",1,20));
		//panelLista.add(txtcoste);
		
		JPanel coste = new JPanel();
		coste.setBorder(BorderFactory.createLoweredBevelBorder());
		coste.add(txtcoste);
		coste.add(precio);
		coste.add(distancia);
		
		
		//super.panelv2.add(coste, gCoste);
		
		//super.panelLista.add(precio);
		//super.panelLista.add(distancia);
		
		JPanel panelAlg = new JPanel(); 
		panelAlg.setBorder(BorderFactory.createLoweredBevelBorder());
		//panelAlg.setMinimumSize(new Dimension(600,100));
		//panelAlg.setMaximumSize(new Dimension(600,100));
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
		
		super.panelv2.remove(panelBotones);
 
		
		
	
		
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
		        
        /*
		super.panelv2.add(vb, c);
		super.panelv2.add(vis2, c);
		super.panelv2.add(vis3, c);
		*/ 
		
        panelEjec = new JPanel(); 
		panelEjec.setBorder(BorderFactory.createLoweredBevelBorder());
		panelEjec.setMinimumSize(new Dimension(600,100));
		//panelEjec.setMaximumSize(new Dimension(600,100));
		
        CiuO = new JTextField();
      	CiuO.setPreferredSize(new Dimension(100,30));
      	labelco = new JLabel(); 
      	labelcd = new JLabel(); 
      	labelco.setText("Ciudad Origen :");
      	labelcd.setText("Ciudad Destino: ");
      	but = new JButton("Ejecutar Todos"); 
      	but.setBackground(Color.lightGray);
		but.setFont(new Font("Verdana",4,10));;
      	
      	
      	CiuO.setEditable(true);
      	CiuD = new JTextField();
      	CiuD.setPreferredSize(new Dimension(100,30));
      	CiuD.setEditable(true);
      	
      	panelEjec.add(labelco); 
    	panelEjec.add(CiuO);
      	panelEjec.add(labelcd);
      	panelEjec.add(CiuD);
      	panelEjec.add(but);
      	
      	
        botonEjecutar = new JButton();
        botonEjecutar.setText("Ejecutar");
        botonEjecutar.setBackground(Color.lightGray);
		botonEjecutar.setFont(new Font("Verdana",4,10));;
        panelEjec.add(botonEjecutar);
        
        
        JPanel superior = new JPanel();
        superior.setLayout(new GridBagLayout());
        
        coste.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder("")));
        panelAlg.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder("")));
        panelEjec.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder("")));
        
        
        GridBagConstraints gCoste = new GridBagConstraints();
		gCoste.fill = GridBagConstraints.BOTH;
		gCoste.gridy = 0;
		superior.add(coste, gCoste);
		
		GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridy = 1;
        superior.add(panelAlg,c);
        
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.BOTH;
        c1.gridy = 2;
        superior.add(panelEjec,c1);
        
        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.BOTH;
        c2.gridy = 0;
        //c.gridheight = 1;
        super.panelv2.add(superior,c2);
        
        //*********************PANEL SOLUCION PARCIAL *************
  		JPanel panelsol = new JPanel(); 
  		panelsol.setBorder(BorderFactory.createLoweredBevelBorder());
  		solbut = new JButton("Ver seguimiento"); 
  		solbut.setBackground(Color.lightGray);
		solbut.setFont(new Font("Verdana",4,10));;
  		//solbut.setText("Ver Seguimientto"); 
  		adel = new JButton("Adelante"); 
  		adel.setBackground(Color.lightGray);
		adel.setFont(new Font("Verdana",4,10));;
  		//adel.setText("adelante");
  		//atras = new JButton("Atras"); 
  		//atras.setText("atras");
  		panelsol.add(solbut);
  		panelsol.add(adel); 
  		//panelsol.add(atras);
  		
  		
  		GridBagConstraints pSol = new GridBagConstraints();
  		pSol.fill = GridBagConstraints.BOTH;
  		pSol.gridy = 3;
  		
  		panelsol.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder("")));
  		
  		superior.add(panelsol,pSol); 
  		
        
        JPanel inferior = new JPanel();
        GridBagConstraints inf = new GridBagConstraints();
        inf.fill = GridBagConstraints.BOTH;
        inf.gridy = 1;
        inf.gridheight = 5;
        
        GridBagConstraints down = new GridBagConstraints();
        down.gridy = 1;
        
        JPanel vbBig = new JPanel(new GridBagLayout());
        JLabel FFLabel = new JLabel("Ford Fulkerson");
        FFLabel.setFont(new Font("Verdana",1,20));
        vbBig.add(FFLabel);
        vbBig.add(vb, down);
        
        JPanel vis2Big = new JPanel(new GridBagLayout());
        JLabel PRLabel = new JLabel("PushRelabel");
        PRLabel.setFont(new Font("Verdana",1,20));
        vis2Big.add(PRLabel);
        vis2Big.add(vis2, down);
        
        JPanel vis3Big = new JPanel(new GridBagLayout());
        JLabel DLabel = new JLabel("Dinic");
        DLabel.setFont(new Font("Verdana",1,20));
        vis3Big.add(DLabel);
        vis3Big.add(vis3, down);
        
        inferior.add(vbBig);
        inferior.add(vis2Big);
        inferior.add(vis3Big);
        
        
	    
	    super.panelv2.add(inferior,inf);
		//super.panelv2.add(vb, mainCons); 
		//super.panelv2.add(vis2, mainCons2); 
		//super.panelv2.add(vis3, mainCons3); 
      
		//actualizarInformacion();
        crearListeners();
	}
	
	void crearListeners() {
		solbut.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comprovar("");
				if(ultimo_ej != null){
				if(ultimo_ej.equals("ff")){
					vb.clear();
					vb.agregar("Recorrido FordFulkerson");
					vb.agregar("Pulsa adelante para continuar");
				}
				else if(ultimo_ej.equals("pr")){
					vis2.clear();
					vis2.agregar("Recorrido Push Relabel");
					vis2.agregar("Pulsa adelante para continuar");
				}
				
				else if(ultimo_ej.equals("dinic")) {
					vis3.clear();
					vis3.agregar("Recorrido Dinic");
					vis3.agregar("Pulsa adelante para continuar");
				}
				}//	Segui = cpalg.subirSeg();
			}
				
			});
		
		adel.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				comprovar("");
				if (!ultimo_ej.equals(null)){
					Segui = listarSegui(); 
					if (nivel < Segui.size()){
						if(ultimo_ej.equals("ff"))
							vb.agregar(Segui.get(nivel) + " " + Segui.get(nivel+1));
						else if(ultimo_ej.equals("pr"))
							vis2.agregar(Segui.get(nivel) + " " + Segui.get(nivel+1));
						else if(ultimo_ej.equals("dinic"))
							vis3.agregar(Segui.get(nivel) + " " + Segui.get(nivel+1));
						nivel = nivel + 2;
						
				}

				}
				
			}

			});
		
		

	
		botonEjecutar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nivel = 0;
				comprovar("");
				vb.clear();
				vis2.clear();
				vis3.clear();
				
				cpalg.initItinerarios();
				if(ff){
				//	vb.clear();
					ultimo_ej = "ff";
				}
				
				else if(pr){
					//vis2.clear();
					ultimo_ej = "pr";
				}
				else if(dinic) {
					//vis3.clear();
					ultimo_ej = "dinic";
				}
				String source = CiuO.getText();
				String sink = CiuD.getText();
				if (source.equals("") || sink.equals(""))
					try {
						throw new Exception("Falta rellenar alguno de los espacios");
					} catch (Exception e1) {
						setError(e1.getMessage());
					}
				else {
					//System.out.println("thread: " + Thread.currentThread()); 
					boolean funcionCoste;
					if (precio.isSelected()) funcionCoste = false;
					else funcionCoste = true;
					
					//-----------------------------CREA NUEVO THREAD -------------------------
					//Thread appThread = new Thread(){
						//public void run(){
							if (ff) cpalg.ejecutar(1,source,sink,funcionCoste);
							else if (pr)  cpalg.ejecutar(2,source,sink,funcionCoste);
							else if (dinic) cpalg.ejecutar(3,source,sink,funcionCoste);
							//System.out.println("thread: " + Thread.currentThread()); 
						//}
					//};
					
					//appThread.start(); 
					
					String carga = cpalg.escribirItinearios();
					String[] l = carga.split("\n");
					
					if(ff) vb.agregar("Algoritmo de Ford Fulkerson");
					if(pr) vis2.agregar("Algoritmo Push Relabel");
					if(dinic) vis3.agregar("Algoritmo de Dinic");
					
					
					 for (int i = 0; i < l.length; ++i ){
						if(ff)vb.agregar(l[i]);
						else if(pr) vis2.agregar(l[i]);
						else if(dinic)  vis3.agregar(l[i]);		
					 	}

					}
				//comprovar("");
				}
		
		});
		
		but.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comprovar("");
				String source = CiuO.getText();
				String sink = CiuD.getText();
				
				vb.clear();
				vis2.clear();
				vis3.clear();
				
				vb.agregar("Algoritmo de Ford Fulkerson");
				vis2.agregar("Algoritmo Push Relabel");
				vis3.agregar("Algoritmo de Dinic");
				
				/////FFFFF///////////
				
				cpalg.initItinerarios();

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
					
					//-----------------------------CREA NUEVO THREAD -------------------------
					//Thread appThread = new Thread(){
						//public void run(){
							cpalg.ejecutar(1,source,sink,funcionCoste);
						//}
					//};
					//appThread.start();
					
					String carga = cpalg.escribirItinearios();
					String[] l = carga.split("\n");

					 for (int i = 0; i < l.length; ++i ){
						vb.agregar(l[i]);
					 	}

					}
				/////////PR/////////////////////////
				cpalg.initItinerarios();

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

					cpalg.ejecutar(3,source,sink,funcionCoste);
					String carga = cpalg.escribirItinearios();
					String[] l = carga.split("\n");

					 for (int i = 0; i < l.length; ++i ){
						vis3.agregar(l[i]);
					 	}

					}
				
				/////////PR/////////////////////////
				cpalg.initItinerarios();

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

					cpalg.ejecutar(2,source,sink,funcionCoste);
					String carga = cpalg.escribirItinearios();
					String[] l = carga.split("\n");
					
					 for (int i = 0; i < l.length; ++i ){
						vis2.agregar(l[i]);
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
				distancia.setSelected(false);
			}
		});
		
		distancia.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				precio.setSelected(false);
			}
		});
	}
	
	public void actualizarInformacion(){
		textarea.setText(null);
		//String respuesta = cpalg.escribirItinearios(); 
		String respuesta = "hola"; 
		textarea.setText(respuesta); 
	}
	
	public ArrayList<String> listarSegui(){
		String nombre = cpalg.subirSeg();
		ArrayList<String> ret = new ArrayList<String> ();
		if (nombre == null) return ret;
		int i = 0;
		String nom;
		while(i < nombre.length()){
			nom = "";
			nom += nombre.charAt(i);
			++i;
			while (nombre.charAt(i) != ' '){
				nom += nombre.charAt(i);
				++i;
			}
			++i;
			if (nom.charAt(0) != ' ') ret.add(nom);
		}
		return ret;
	}
	
}
