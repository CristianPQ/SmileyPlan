import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.net.URL;
import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;

//import javax.imageio.ImageIO;
import javax.swing.*;
//import javax.swing.border.Border;


public class VistaCrearMapa extends Vista1{
	//private JPanel medidas;
	private ControladorPresentacionMapa cMapa;
	protected VistaMatriz vMatriz;
	protected VistaGrafo vGrafo;
	protected JButton crear;
	protected JButton crearVacio;
	protected JButton continente;
	protected JButton cargar;
	protected JButton guardar;
	private JTextField horizontal;
	private JTextField vertical;
	private boolean tieneContinente = false; 
	
	
	public void reset() {
		vMatriz.reset();
		vGrafo.reset();
		horizontal.setText("");
		vertical.setText("");
		tieneContinente = false;
		continente.setEnabled(false);
		crear.setEnabled(true);
		crearVacio.setEnabled(true);
	}
	
	public VistaCrearMapa(ControladorPresentacionMapa contMapa) {
		super();
		
		cMapa = contMapa;
		//vMatriz = new VistaMatriz();
		crearInterficie();
		definirButton();
	}
	
	/*@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Image img = new ImageIcon(this.getClass().getResource("/images/back.jpg")).getImage();
		
		//Image scaledImage = img.getScaledInstance((int)this.getWidth(), (int)this.getHeight(), Image.SCALE_SMOOTH);
		//BufferedImage imageBuff = new BufferedImage((int)this.getWidth(), (int)this.getHeight(), BufferedImage.TYPE_INT_RGB);
		//g = imageBuff.createGraphics();
		
		System.out.println("ancho: " + this.getWidth() + "      alto" + this.getHeight());
		
		g.drawImage(img, 0, 0, new Color(0,0,0), null);
		
		//g.dispose();
		
	}*/
	
	void definirButton() {
		
		//crear Mapa para luego crear continente
		crear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comprovar("");
				if(!horizontal.getText().equals("") && !vertical.getText().equals("")) {
					if(Integer.parseInt(horizontal.getText()) > 0 && Integer.parseInt(vertical.getText()) > 0){
						try {
							int x = Integer.parseInt(horizontal.getText());
							int y = Integer.parseInt(vertical.getText());
							tieneContinente = true; 
							cMapa.crearMapa(x, y);
								//System.out.println("Antes de redeclarar vMatriz");
							vMatriz.definirMedidas(x, y);
								//System.out.println("Despues de redeclarar vMatriz");
							vMatriz.repaint();
							//continente.setVisible(true);
							continente.setEnabled(true);
							crearVacio.setEnabled(false);
							crear.setEnabled(false);
						} catch (Exception e1) {
							setError(e1.getMessage());
						}
					}
					else setError("No puede ser un numero negativo"); 
				}
				else {
					setError("Falta rellenar una casilla");
				}
			}
		});
		
		//crear Mapa sin continente
		crearVacio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comprovar("");
				if(!horizontal.getText().equals("") && !vertical.getText().equals("")) {
					if(Integer.parseInt(horizontal.getText()) > 0 && Integer.parseInt(vertical.getText()) > 0){
						try {
							int x = Integer.parseInt(horizontal.getText());
							int y = Integer.parseInt(vertical.getText());
							cMapa.crearMapa(x, y, "");
							vMatriz.definirMedidas(x, y);
							vMatriz.repaint();
							tieneContinente = false; 
							crearVacio.setEnabled(false);
							crear.setEnabled(false);
						} catch (Exception e1) {
							setError(e1.getMessage());
						}
					}
					else setError("No puede ser un numero negativo"); 
				}
				else {
					setError("Falta rellenar una casilla");
				}
			}
		});
		
		//Definir continente para mapa con continente
		continente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comprovar("");
				try {
					String s = vMatriz.consultarContinente();
						//System.out.println("continente:  " + s);
					cMapa.definirContinente(s);
					ArrayList<Integer> horiz = new ArrayList<Integer>();
					ArrayList<Integer> vert = new ArrayList<Integer>();
					cMapa.extraerOcupados(horiz, vert);
						//System.out.println(horiz.toString());
						//System.out.println(vert.toString());
					vMatriz.definirOcupadas(horiz, vert);
					vMatriz.repaint();
					continente.setEnabled(false);
				} catch (Exception e1) {
					setError(e1.getMessage());
				}
			}
		});
		
		//Cargar Mapa
		cargar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comprovar("");
				try{
					abrirBrowserCargar();
				} catch (Exception e1) {
					setError(e1.getMessage());
				} 
			}
		});
		
		//Guardar Mapa
		guardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comprovar("");
				try{
					abrirBrowserGuardar();
				} catch (Exception e1) {
					setError(e1.getMessage());
				}
			}
		});
	}

	private void crearInterficie() {
		
		horizontal = new JTextField();
		horizontal.setPreferredSize(new Dimension(70,30));
		horizontal.setEditable(true);
		vertical = new JTextField();
		vertical.setPreferredSize(new Dimension(70,30));
		vertical.setEditable(true);
		JLabel xLabel = new JLabel("X: ");
		JLabel yLabel = new JLabel("Y: ");
		crear = new JButton("Crear con continente");
		crear.setBackground(Color.lightGray);
		crear.setFont(new Font("Verdana",4,10));;
		crearVacio = new JButton("Crear sin continente");
		crearVacio.setBackground(Color.lightGray);
		crearVacio.setFont(new Font("Verdana",4,10));;
		
		JPanel medidas = new JPanel();
		medidas.setLayout(new GridBagLayout());
		
		medidas.add(xLabel);
		medidas.add(horizontal);
		medidas.add(yLabel);
		medidas.add(vertical);
		
		GridBagConstraints bCrear = new GridBagConstraints();
		bCrear.gridy = 1;
		bCrear.gridwidth = 2;
		bCrear.insets = new Insets(10,0,0,20);
		
		medidas.add(crear,bCrear);
		
		GridBagConstraints bCrearVacio = new GridBagConstraints();
		bCrearVacio.gridy = 1;
		bCrearVacio.gridwidth = 2;
		bCrearVacio.insets = new Insets(10,0,0,0);
		
		medidas.add(crearVacio,bCrearVacio);
		//medidas.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		
		GridBagConstraints vMedidas = new GridBagConstraints();
		vMedidas.gridwidth = 2;
		vMedidas.gridy = 0;
		vMedidas.insets = new Insets(10,0,10,0);
		//vMedidas.weighty = 0.2;
		
		super.panelPrincipal.add(medidas, vMedidas);
		
		vMatriz = new VistaMatriz();
		//vMatriz.setMinimumSize(new Dimension(50,50));
		
		GridBagConstraints vM = new GridBagConstraints();
		//vM.fill = GridBagConstraints.BOTH;
		//vM.weightx = 1;
		vM.gridx = 0;
		vM.gridy = 1;
		
		super.panelPrincipal.add(vMatriz, vM);
		
		//vGrafo = cMapa.getVGrafo();
		
		//vGrafo.dibujar();
		
		GridBagConstraints vG = new GridBagConstraints();
		//vG.fill = GridBagConstraints.BOTH;
		//vG.weightx = 0.5;
		vG.gridx = 1;
		vG.gridy = 1;
		
		
		//JPanel vDibujos = new JPanel();
		//vDibujos.add(vMatriz);
		//vDibujos.add(vMatriz);
		//vDibujos.setMinimumSize(new Dimension(350,350));
		
		//GridBagConstraints vD = new GridBagConstraints();
		//vM.fill = GridBagConstraints.BOTH;
		//vD.gridx = 1;
		//vD.gridy = 1;
		
		vGrafo = /*cMapa.getVGrafo()*/new VistaGrafo();
		//Tendria que ser vGrafo en vez de vMatriz
		super.panelPrincipal.add(vGrafo, vG);
		
		continente = new JButton("Definir continente");
		continente.setBackground(Color.lightGray);
		continente.setFont(new Font("Verdana",4,10));;
		//continente.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		//continente.setVisible(false);
		continente.setEnabled(false);
		
		GridBagConstraints cont = new GridBagConstraints();
		cont.gridy = 2;
		cont.insets = new Insets(10,0,0,0);
		
		super.panelPrincipal.add(continente, cont);
		
		JPanel botones = new JPanel();
		botones.setLayout(new GridBagLayout());
		guardar = new JButton("Guardar");
		guardar.setBackground(Color.lightGray);
		guardar.setFont(new Font("Verdana",4,10));;
		//guardar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
		cargar = new JButton("Cargar");
		cargar.setBackground(Color.lightGray);
		cargar.setFont(new Font("Verdana",4,10));;
		GridBagConstraints gGuardar = new GridBagConstraints();
		gGuardar.insets = new Insets(0,0,0,25);
		botones.add(guardar, gGuardar);
		GridBagConstraints gCargar = new GridBagConstraints();
		gCargar.weightx = 0.5;
		botones.add(cargar, gCargar);
		//botones.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		
		GridBagConstraints panelBotones = new GridBagConstraints();
		panelBotones.gridwidth = 2;
		panelBotones.gridy = 3;
		panelBotones.insets = new Insets(10,0,10,0);
		
		super.panelPrincipal.add(botones, panelBotones);
	}
	

	void actualizarGrafo(){
	
	//GridBagConstraints vG = new GridBagConstraints();
	//vGrafo = cMapa.getVGrafo();
	

	
	vGrafo.dibujar();
	//GridBagConstraints vG = new GridBagConstraints();
	
	}
	
	public void pintarCiudad(String n){
		ArrayList<String> m = vGrafo.consultarMapeo();
		
		int i = 0;
		boolean agregado = false;
		System.out.println("mapa tiene un size de: " + m.size());
		System.out.println("mapa contiene: " + m.toString());
		for(int j = 0; j < m.size(); ++j) {
			System.out.println("en el for");
			if(m.get(j).equals("null")){
				System.out.println("en el for en el if");
				m.set(j, n);
				i = j;
				agregado = true;
			}
		}
		
		if(!agregado) {
			System.out.println("en el no agregado");
			m.add(n);
			i = m.indexOf(n);
		}			
		/*for (i = 0; i < m.size() && !insertat; ++i){
			if (m.get(i).equals(null)) m.add(i, n);
			insertat = true;
		}
		*/
		System.out.println(i);

		vGrafo.modificarMapeo(m);
		vGrafo.crearVertex(i);

		//vCrearMapa.actualizarGrafo();
	}
	
	public void borrarCiudad(String n){
		ArrayList<String> m = vGrafo.consultarMapeo();
		
		int i = m.indexOf(n);	
		System.out.println("la i es :" + i);
		m.set(i, "null");
		
		vGrafo.modificarMapeo(m);
		vGrafo.eliminarVertex(i);
		
		//vGrafo.actualizarGrafo();
		
	}
	
	public void pintarCamino(String cOrig, String cDest, String medio){
		vGrafo.crearAresta(cOrig, cDest, medio);
	}
	
	public void borrarCamino(String cOrig, String cDest, String medio){
		vGrafo.eliminarAresta(cOrig, cDest,  medio);
	}
	
	public void abrirBrowserGuardar()  {
	   JFrame parentFrame = new JFrame();
		super.filechooser.setDialogTitle("Elige archivo para el Mapa"); 
		int userSelection = filechooser.showSaveDialog(parentFrame);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			String file = filechooser.getSelectedFile().getAbsolutePath(); 
			file = file.concat(".smiley");
			//System.out.println("CONTINENTE: " + cMapa.consultarContinente()); 
			cMapa.guardarMapa(file, tieneContinente);
		}
	}
	
	public void abrirBrowserCargar() throws Exception {
		JFrame parentFrame = new JFrame();
		super.filechooser.setDialogTitle("Elige archivo para el Mapa"); 
 		int userSelection = filechooser.showOpenDialog(parentFrame);
 		if (userSelection == JFileChooser.APPROVE_OPTION) {
 			String file = filechooser.getSelectedFile().getAbsolutePath(); 
 			boolean success = cMapa.cargarMapa(file);
			if (success) {
				horizontal.setText(Integer.toString(cMapa.consultarAnchura()));
				vertical.setText(Integer.toString(cMapa.consultarAltura()));
				vMatriz.definirMedidas(cMapa.consultarAltura(), cMapa.consultarAnchura());
				vMatriz.repaint(); 
				if(cMapa.existeContinente()){
					System.out.println("existeContinente"); 
					tieneContinente = true; 
					ArrayList<Integer> horiz = new ArrayList<Integer>(); 
					ArrayList<Integer> vert = new ArrayList<Integer>(); 
					cMapa.extraerOcupados(horiz, vert); 
					System.out.println("extrets"); 
					vMatriz.definirOcupadas(horiz, vert);
					System.out.println("definits"); 
					continente.setVisible(false);
					System.out.println("fi"); 
				}
			}
 		}
	}
	
}
