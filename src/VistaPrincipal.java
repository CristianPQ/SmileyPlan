import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*; 


public class VistaPrincipal {

	private JTabbedPane tabs; 
	private ControladorPresentacionMedios cpm; 
	private ControladorPresentacionAgentes cpa; 
	private ControladorPresentacionMapa cpmapa; 
	private ControladorPresentacionAlgoritmo cpalg; 

	private JMenu menu1; 
	private JMenu menu2; 
	private JMenu menu3; 
	private JMenu menu4; 
	
	
	VistaPrincipal(ControladorPresentacionMedios cpmed,ControladorPresentacionAgentes cpag, ControladorPresentacionMapa cpmap, ControladorPresentacionAlgoritmo cpal){
		
		cpm = cpmed; 
		cpa = cpag; 
		cpmapa = cpmap; 
		cpalg = cpal; 
		
		JFrame frame = new JFrame("Main");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        //JLabel Imatge = new JLabel(new ImageIcon("/Users/olgacarbo/Desktop/SmileyPlan/mapa.jpg")); 
        //Imatge.setLayout(new FlowLayout());
        //frame.add(Imatge); 
        //frame.setContentPane(Imatge);
   
        frame.setPreferredSize(new Dimension(1900, 1080));
        frame.setResizable(true);
        
        JMenuBar menuBar = new JMenuBar(); 
        
        JMenu menu1 = new JMenu("Guardar");  
        JMenu menu2 = new JMenu("Cargar");
		JMenu menu3 = new JMenu("Deshacer");
		JMenu menu4 = new JMenu("Salir"); 
		menuBar.add(menu1); 
		menuBar.add(menu2); 
		menuBar.add(menu3);
		menuBar.add(menu4); 
		frame.setJMenuBar(menuBar);

		//Ayuda ayuda = new Ayuda(); 

		tabs = new JTabbedPane(); 
		tabs.add("Mapa", cpmapa.getVista());
		tabs.add("Agente", cpa.getVista());
		tabs.add("MedioTransporte", cpm.getVista());
		tabs.add("Algoritmo", cpalg.getVista());
		//tabs.add("Ayuda", ayuda); 
		
		frame.add(tabs);
		frame.pack(); 
		frame.setVisible(true); 
		
		menu1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent event) {
	            //cridar les funcions de guardar :
				 //1) guardar mapa
				 //2) guardar medios
				 //3) guardar agentes
				 //
	                
	            }
		}); 
		
		menu2.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent event) {
	                //cridar les funcions de cargar: 
				 	//1) cargar mapa
				 	//2) cargar medios
				 	//3) guardar agentes
	                
				 	/*
				 	 *   ctrlprods.obrirSaveChooserProds();
	                ctrlprods.obrirSaveChooserLlistes();
	                ctrlrel.obrirSaveChooser();
	                ctrlsol.obrirSaveChooser();
				 	 */
	            }
		}); 
		
		menu3.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent event) {
            
				 //accions de deshacer
            }
			
		}); 
		
		menu4.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent event) {
				 System.exit(0); 
				
           }
			
		}); 
		
		

		
	}
	
	
}
