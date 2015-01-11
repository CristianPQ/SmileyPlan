import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*; 


public class VistaPrincipal {

	private JTabbedPane tabs; 
	private static ControladorPresentacionMedios cpm; 
	private static ControladorPresentacionAgentes cpa; 
	private static ControladorPresentacionMapa cpmapa; 
	private static ControladorPresentacionAlgoritmo cpalg; 

	private JMenu menu1; 
	private JMenu menu2; 
	private JMenu menu3; 
	//private JMenu menu4; 
	
	
	VistaPrincipal(ControladorPresentacionMedios cpmed,ControladorPresentacionAgentes cpag, ControladorPresentacionMapa cpmap, ControladorPresentacionAlgoritmo cpal){
		
		cpm = cpmed; 
		cpa = cpag; 
		cpmapa = cpmap; 
		cpalg = cpal; 
		
		JFrame frame = new JFrame("Main");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setLayout(new GridBagLayout());
   
        //frame.setPreferredSize(new Dimension(1900, 1080));
        
        frame.setResizable(true);
        
        fullVPrincipal(frame);
        
        
		
	}
	
	private static void fullVPrincipal(JFrame frame) {
		
		
		//GridBagConstraints mBar = new GridBagConstraints();
		//mBar.gridheight = 5;
        //mBar.gridx = 0;
        //mBar.gridy = 0;
        
		JMenuBar menuBar = new JMenuBar(); 
        
        JButton menu1 = new JButton("Guardar");
        menu1.setBackground(Color.lightGray);
		menu1.setFont(new Font("Verdana",4,10));;
        menuBar.add(menu1); 
        
        JButton menu2 = new JButton("Cargar");
        menu2.setBackground(Color.lightGray);
		menu2.setFont(new Font("Verdana",4,10));;
        menuBar.add(menu2);
        
		frame.setJMenuBar(menuBar);

		//Ayuda ayuda = new Ayuda(); 
		JTabbedPane tabs = new JTabbedPane();

		
		//tabs.setPreferredSize(new Dimension(1500, 500));
		//Provisional 
		
		tabs.addTab("Mapa", null, cpmapa.getVistaCrearMapa(), "Crea un mapa");
		tabs.setBackgroundAt(0,Color.lightGray);
		tabs.addTab("Ciudades y caminos", null, cpmapa.getVistaMapa(), "Edita las ciudades y los caminos");
		tabs.setBackgroundAt(1,Color.lightGray);
		tabs.addTab("Agente", null, cpa.getVista(), "Edita los agentes");
		tabs.setBackgroundAt(2,Color.lightGray);
		tabs.addTab("MedioTransporte", null, cpm.getVista(), "Edita los medios de transporte");
		tabs.setBackgroundAt(3,Color.lightGray);
		tabs.addTab("Algoritmo", null, cpalg.getVista(), "Ejecuta el programa");
		tabs.setBackgroundAt(4,Color.lightGray);
		
		
		GridBagConstraints gbcTabs = new GridBagConstraints();
		//mBar.gridheight = 5;
        //gbcTabs.gridx = 0;
        //gbcTabs.gridy = 1;
        //gbcTabs.gridheight = 2;
        //gbcTabs.fill = GridBagConstraints.BOTH;
		
		frame.add(tabs, gbcTabs);
		frame.pack(); 
		frame.setVisible(true); 
		//frame.setSize(1920, 1080);
		
		menu1.addActionListener(new ActionListener() {
			@Override
			 public void actionPerformed(ActionEvent event) {
					cpm.guardarBrowser();
					cpmapa.guardarBrowser();
					cpa.guardarBrowser(); 
					cpmapa.guardarBrowserCaminos();
					cpmapa.guardarBrowserCiudades();  
	            }
		}); 
		
		menu2.addActionListener(new ActionListener() {
			@Override
			 public void actionPerformed(ActionEvent event) {
					cpm.cargarBrowser();
					cpmapa.cargarBrowser(); 
					cpmapa.cargarBrowserCiudades();
					cpmapa.cargarBrowserCaminos();
					cpa.cargarBrowser(); 
					
	            }
		}); 
	}
	
	
}
