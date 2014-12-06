import javax.swing.*;

public class main {

	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			
			ControladorPresentacionMedios cpm = new ControladorPresentacionMedios(); 
			ControladorPresentacionAgentes cpa = new ControladorPresentacionAgentes(); 
			ControladorPresentacionMapa cpmapa = new ControladorPresentacionMapa(); 
			ControladorPresentacionAlgoritmo cpalg = new ControladorPresentacionAlgoritmo();
			
			VistaPrincipal vp = new VistaPrincipal(cpm,cpa,cpmapa,cpalg);
		}); 
		
	}

}
