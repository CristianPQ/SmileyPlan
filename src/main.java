import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.plaf.ColorUIResource;

import com.alee.laf.WebLookAndFeel;

import java.awt.*; 
import java.lang.*;

public class main {

	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(
				new Runnable(){
					public void run() {
						try {
						    /*for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						        if ("Nimbus".equals(info.getName())) {
						            UIManager.setLookAndFeel(info.getClassName());
						            break;
						        }
						    }*/
							
							WebLookAndFeel.install();
						} catch (Exception e) {
							try{
								UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
							}
							catch (Exception e1){
								e1.getMessage(); 
							} 
						}  
						ControladorPresentacionMedios cpm = new ControladorPresentacionMedios(); 
						ControladorPresentacionAgentes cpa = new ControladorPresentacionAgentes(); 
						ControladorPresentacionMapa cpmapa = new ControladorPresentacionMapa(cpm, cpa); 				
						ControladorPresentacionAlgoritmo cpalg = new ControladorPresentacionAlgoritmo(cpa,cpmapa,cpm);
				
						VistaPrincipal vp = new VistaPrincipal(cpm,cpa,cpmapa,cpalg);
					}}); 
	}

}
