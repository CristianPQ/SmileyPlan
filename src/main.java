import javax.swing.*;
import java.awt.*; 
import java.lang.*;

public class main {

	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			
			public void run() {
				try {
	               UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	             }
	             catch (Exception e) {System.out.println(e);}
				ControladorPresentacionMedios cpm = new ControladorPresentacionMedios(); 
				ControladorPresentacionAgentes cpa = new ControladorPresentacionAgentes(); 
				ControladorPresentacionMapa cpmapa = new ControladorPresentacionMapa(cpm, cpa); 				
				ControladorPresentacionAlgoritmo cpalg = new ControladorPresentacionAlgoritmo(cpa,cpmapa,cpm);
				
				VistaPrincipal vp = new VistaPrincipal(cpm,cpa,cpmapa,cpalg);
			}
			
		}); 
		
	}

}
