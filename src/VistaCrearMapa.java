import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class VistaCrearMapa extends Vista1{
	//private JPanel medidas;
	private ControladorPresentacionMapa cMapa;
	protected VistaMatriz vMatriz;
	protected VistaGrafo vGrafo;
	protected JButton crear;
	protected JButton crearVacio;
	protected JButton continente;
	private JTextField horizontal;
	private JTextField vertical;
	
	public VistaCrearMapa(ControladorPresentacionMapa contMapa) {
		super();
		cMapa = contMapa;
		vMatriz = new VistaMatriz();
		crearInterficie();
		definirButton();
	}
	
	void definirButton() {
		crear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comprovar("");
				if(!horizontal.getText().equals("") && !vertical.getText().equals("")) {
					try {
						int x = Integer.parseInt(horizontal.getText());
						int y = Integer.parseInt(vertical.getText());
						cMapa.crearMapa(x, y);
						continente.enable();
					} catch (Exception e1) {
						setError(e1.getMessage());
					}
				}
				else {
					setError("Falta rellenar una casilla");
				}
			}
		});
		
		crearVacio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comprovar("");
				if(!horizontal.getText().equals("") && !vertical.getText().equals("")) {
					try {
						int x = Integer.parseInt(horizontal.getText());
						int y = Integer.parseInt(vertical.getText());
						cMapa.crearMapa(x, y, "");
					} catch (Exception e1) {
						setError(e1.getMessage());
					}
				}
				else {
					setError("Falta rellenar una casilla");
				}
			}
		});
		
		continente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comprovar("");
				try {
					String s = vMatriz.consultarContinente();
					cMapa.definirContinente(s);
					continente.disable();
				} catch (Exception e1) {
					setError(e1.getMessage());
				}
			}
		});
		
		
	}

	private void crearInterficie() {
		
		horizontal = new JTextField();
		horizontal.setPreferredSize(new Dimension(70,30));
		horizontal.setEditable(true);
		vertical = new JTextField();
		vertical.setPreferredSize(new Dimension(70,30));
		vertical.setEditable(true);
		JLabel xLabel = new JLabel("X: ");
		JLabel yLabel = new JLabel("Y: ");
		crear = new JButton("Crear con continente");
		crearVacio = new JButton("Crear sin continente");
		
		JPanel medidas = new JPanel();
		medidas.add(xLabel);
		medidas.add(horizontal);
		medidas.add(yLabel);
		medidas.add(vertical);
		medidas.add(crear);
		medidas.add(crearVacio);
		
		GridBagConstraints vMedidas = new GridBagConstraints();
		vMedidas.gridwidth = 2;
		vMedidas.gridy = 0;
		
		super.panelPrincipal.add(medidas, vMedidas);
		
		vMatriz = new VistaMatriz();
		//vMatriz.setMinimumSize(new Dimension(50,50));
		
		GridBagConstraints vM = new GridBagConstraints();
		//vM.fill = GridBagConstraints.BOTH;
		//vM.weightx = 1;
		vM.gridx = 0;
		vM.gridy = 1;
		
		super.panelPrincipal.add(vMatriz, vM);
		
		vGrafo = new VistaGrafo();
		
		
		
		GridBagConstraints vG = new GridBagConstraints();
		//vG.fill = GridBagConstraints.BOTH;
		//vG.weightx = 0.5;
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
		
		continente = new JButton("Definir continente");
		continente.disable();
		
		GridBagConstraints cont = new GridBagConstraints();
		cont.gridy = 2;
		
		super.panelPrincipal.add(continente, cont);
	}
	
}
