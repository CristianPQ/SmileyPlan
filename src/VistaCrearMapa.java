import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;


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
	
	public VistaCrearMapa(ControladorPresentacionMapa contMapa) {
		super();
		cMapa = contMapa;
		//vMatriz = new VistaMatriz();
		crearInterficie();
		definirButton();
	}
	
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
							cMapa.crearMapa(x, y);
								//System.out.println("Antes de redeclarar vMatriz");
							vMatriz.definirMedidas(x, y);
								//System.out.println("Despues de redeclarar vMatriz");
							//vMatriz.repaint();
							continente.setVisible(true);
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
						} catch (Exception e1) {
							setError(e1.getMessage());
						}
					}
					else setError("No puede ser un número negativo"); 
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
					continente.setVisible(false);
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
		crearVacio = new JButton("Crear sin continente");
		
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
		
		vGrafo = cMapa.getVGrafo();
		//Tendria que ser vGrafo en vez de vMatriz
		super.panelPrincipal.add(vGrafo, vG);
		
		continente = new JButton("Definir continente");
		//continente.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		continente.setVisible(false);
		
		GridBagConstraints cont = new GridBagConstraints();
		cont.gridy = 2;
		cont.insets = new Insets(10,0,0,0);
		
		super.panelPrincipal.add(continente, cont);
		
		JPanel botones = new JPanel();
		botones.setLayout(new GridBagLayout());
		guardar = new JButton("Guardar");
		//guardar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
		cargar = new JButton("Cargar");
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
	
	GridBagConstraints vG = new GridBagConstraints();
	vGrafo = cMapa.getVGrafo();
	

	
	vGrafo.dibujar();
	//GridBagConstraints vG = new GridBagConstraints();
	
	}
	
	public void pintarCiudad(String n){
		ArrayList<String> m = vGrafo.consultarMapeo();
		
		m.add(n);
		
		int i = m.indexOf(n);			
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
		m.remove(i);
		
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
			System.out.println("CONTINENTE: " + cMapa.consultarContinente()); 
			cMapa.guardarMapa(file);
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
