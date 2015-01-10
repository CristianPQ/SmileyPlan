import java.awt.*;

import javax.swing.*;


public class VistaCrearMapa extends Vista1{
	//private JPanel medidas;
	private ControladorPresentacionMapa cMapa;
	protected VistaMatriz vMatriz;
	protected VistaGrafo vGrafo;
	
	public VistaCrearMapa(ControladorPresentacionMapa contMapa) {
		super();
		cMapa = contMapa;
		vMatriz = new VistaMatriz();
		crearInterficie();
	}
	
	private void crearInterficie() {
		
		JTextField horizontal = new JTextField();
		horizontal.setPreferredSize(new Dimension(70,30));
		horizontal.setEditable(true);
		JTextField vertical = new JTextField();
		vertical.setPreferredSize(new Dimension(70,30));
		vertical.setEditable(true);
		JLabel xLabel = new JLabel("X: ");
		JLabel yLabel = new JLabel("Y: ");
		
		JPanel medidas = new JPanel();
		medidas.add(xLabel);
		medidas.add(horizontal);
		medidas.add(xLabel);
		medidas.add(vertical);
		
		GridBagConstraints vMedidas = new GridBagConstraints();
		vMedidas.gridwidth = 2;
		vMedidas.gridy = 0;
		
		super.panelPrincipal.add(medidas, vMedidas);
		
		vMatriz = new VistaMatriz();
		//vMatriz.setMinimumSize(new Dimension(50,50));
		
		GridBagConstraints vM = new GridBagConstraints();
		//vM.fill = GridBagConstraints.BOTH;
		vM.gridx = 0;
		vM.gridy = 1;
		
		super.panelPrincipal.add(vMatriz, vM);
		
		vGrafo = new VistaGrafo();
		
		
		
		GridBagConstraints vG = new GridBagConstraints();
		//vG.fill = GridBagConstraints.BOTH;
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
		
		
		//Tendria que ser vGrafo en vez de vMatriz
		super.panelPrincipal.add(vGrafo, vG);
		
		
	}
	
}
