import java.awt.*;
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
	
	
	VistaPrincipal(ControladorPresentacionMedios cpm,ControladorPresentacionAgentes cpa, ControladorPresentacionMapa cpmapa, ControladorPresentacionAlgoritmo cpalg){
		
		cpm = cpm; 
		cpa = cpa; 
		cpmapa = cpmapa; 
		cpalg = cpalg; 
		
		JFrame frame = new JFrame("Main");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setPreferredSize(new Dimension(1100, 500));
        frame.setResizable(false);
        
        JMenuBar menuBar = new JMenuBar(); 
        
        JMenu menu1 = new JMenu("Guardar");  
        JMenu menu2 = new JMenu("Cargar");
		JMenu menu3 = new JMenu("Deshacer");
		
		menuBar.add(menu1); 
		menuBar.add(menu2); 
		menuBar.add(menu3); 
		
		frame.setJMenuBar(menuBar);
		
		

		
	}
	
	
}
