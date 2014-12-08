import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaMapa extends Vista2{
	private ControladorPresentacionMapa cpmapa;
	
	
	VistaMapa (ControladorPresentacionMapa controladorPMapa){
		super();
		cpmapa = controladorPMapa;
		
		super.label1.setText("X: ");
		super.label2.setText("Y: ");
		
		crearListeners
	}
}
