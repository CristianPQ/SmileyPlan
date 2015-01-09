import java.awt.*;
import javax.swing.*;


public class VistaCrearMapa extends Vista1{
	public JPanel medidas;
	private ControladorPresentacionMapa cMapa;
	protected VistaMatriz vMatriz;
	
	public VistaCrearMapa(ControladorPresentacionMapa contMapa) {
		super();
		cMapa = contMapa;
		vMatriz = new VistaMatriz();
	}
	
	private void crearInterficie() {
		
		
		GridBagConstraints vM = new GridBagConstraints();
		vM.fill = GridBagConstraints.BOTH;
		
	}
	
}
