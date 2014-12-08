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
				ControladorPresentacionMapa cpmapa = new ControladorPresentacionMapa(cpm); 
				ControladorPresentacionAgentes cpa = new ControladorPresentacionAgentes(cpmapa); 
				ControladorPresentacionAlgoritmo cpalg = new ControladorPresentacionAlgoritmo();
				
				VistaPrincipal vp = new VistaPrincipal(cpm,null,cpmapa,cpalg);
			}
			
		}); 
		
	}

}
