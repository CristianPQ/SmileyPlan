import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

public abstract class Vista3 extends Vista1 {

	protected VistaBuscador vb;
	
	protected JPanel panelv3; 
	protected JPanel panelLista; 
	protected JPanel panelBotones; 
	protected JPanel panelCrear; 
	
	protected JButton botonCargar; 
	protected JButton botonGuardar;
	protected JButton botonModificar;
	protected JButton botonEliminar; 
	protected JButton botonCrear; 
	
	protected JTextField txtXMapa;
	protected JTextField txtYMapa; 
	protected JTextField txtConti; 
	protected JTextField txtCap; 
	
	protected JLabel label1;
	protected JLabel label2; 
	protected JLabel label3; 
	
	protected JPanel panelCiudad; 
	protected JPanel panelCaminos; 
	
	protected JTextField txtIdCiutat; 
	protected JTextField txtY; 
	protected JTextField txtX; 
	protected JTextField txtCO; 
	protected JTextField txtCD; 
	protected JTextField txtMedio;
	
	protected JLabel label4;
	protected JLabel label5;
	protected JLabel label6;
	protected JLabel label7; 
	
	
	
	public Vista3() {
		super(); 
		
		vb = new VistaBuscador(this); 
		//panel que engloba a todos
		panelv3 = new JPanel(); 
		panelv3.setLayout(new BoxLayout(panelv3, BoxLayout.Y_AXIS));
		panelv3.setBorder(BorderFactory.createEmptyBorder(10,20,15,20));
		
		//panellmapa
		TitledBorder Mapa;
		Mapa = BorderFactory.createTitledBorder("Mapa: ");
		panelLista = new JPanel(); 
		panelLista.setBorder(BorderFactory.createTitledBorder(Mapa));
		panelLista.setMinimumSize(new Dimension(700,100));
		panelLista.setMaximumSize(new Dimension(700,100));
		
		txtXMapa = new JTextField(); 
		txtXMapa.setPreferredSize(new Dimension(70,30));
		txtXMapa.setEditable(true);
		label1 = new JLabel();
		label2 = new JLabel(); 
		txtYMapa = new JTextField();
		txtYMapa.setPreferredSize(new Dimension(70,30));
		txtYMapa.setEditable(true);
		label1 = new JLabel(); 
		label2 = new JLabel(); 
		label1.setText("X: ");
		label2.setText("Y: ");
		label3 = new JLabel(); 
		label3.setText("Continente: ");
		txtConti = new JTextField(); 
		txtConti.setPreferredSize(new Dimension(400,30));
		txtConti.setEditable(true);
		
		panelLista.add(label1);
		panelLista.add(txtXMapa);
		panelLista.add(label2);
		panelLista.add(txtYMapa);
		panelLista.add(label3);
		panelLista.add(txtConti);
		
		//panell Ciutat
		TitledBorder Ciudad;
		Ciudad = BorderFactory.createTitledBorder("Ciudad: ");
		panelCiudad = new JPanel(); 
		panelCiudad.setBorder(BorderFactory.createTitledBorder(Ciudad));
		panelCiudad.setMinimumSize(new Dimension(700,100));
		panelCiudad.setMaximumSize(new Dimension(700,100));
		//panelLista.setBorder(Ciudad);
		txtIdCiutat = new JTextField(); 
		txtIdCiutat.setPreferredSize(new Dimension(100,30));
		txtIdCiutat.setEditable(true);
		label1 = new JLabel();
		label1.setText("Nombre: ");
		label2 = new JLabel();
		label2.setText("X: ");
		label3 = new JLabel(); 
		label3.setText("Y: ");
		txtX = new JTextField();
		txtX.setPreferredSize(new Dimension(100,30));
		txtX.setEditable(true);
		txtY = new JTextField();
		txtY.setPreferredSize(new Dimension(100,30));
		txtY.setEditable(true);
		
		panelCiudad.add(label1);
		panelCiudad.add(txtIdCiutat);
		panelCiudad.add(label2);
		panelCiudad.add(txtX);
		panelCiudad.add(label3);
		panelCiudad.add(txtY);

		//panel Camino
		TitledBorder Camino;
		Camino = BorderFactory.createTitledBorder("Camino: ");
		panelCaminos = new JPanel(); 
		panelCaminos.setBorder(BorderFactory.createTitledBorder(Camino));
		panelCaminos.setMinimumSize(new Dimension(700,100));
		panelCaminos.setMaximumSize(new Dimension(700,100));
		txtCO = new JTextField(); 
		txtCO.setPreferredSize(new Dimension(80,30));
		txtCO.setEditable(true);
		label4 = new JLabel();
		label4.setText("Ciudad de Origen: ");
		label5 = new JLabel();
		label5.setText("Ciudad de Destino: ");
		label6 = new JLabel(); 
		label6.setText("Medio de Transporte: ");
		txtCD = new JTextField();
		label7 = new JLabel(); 
		label7.setText("Capacidad: ");
		txtCap = new JTextField(); 
		txtCap.setPreferredSize(new Dimension(80,30));
		txtCD.setEditable(true);
		txtCD.setPreferredSize(new Dimension(80,30));
		txtCD.setEditable(true);
		txtMedio = new JTextField();
		txtMedio.setPreferredSize(new Dimension(80,30));
		txtMedio.setEditable(true);
		
		panelCaminos.add(label4);
		panelCaminos.add(txtCO);
		panelCaminos.add(label5);
		panelCaminos.add(txtCD);
		panelCaminos.add(label6);
		panelCaminos.add(txtMedio);
		panelCaminos.add(label7);
		panelCaminos.add(txtCap);
		
		//panel Botones
		panelBotones = new JPanel(); 
		panelBotones.setBorder(BorderFactory.createLoweredBevelBorder());
		panelBotones.setMinimumSize(new Dimension(700,50));
		panelBotones.setMaximumSize(new Dimension(700,50));
		botonCargar = new JButton(); 
		botonGuardar = new JButton();
		botonModificar = new JButton();
		botonEliminar = new JButton();
		botonCrear = new JButton(); 
		botonGuardar.setText("Guardar"); 
		botonCargar.setText("Cargar");
		botonModificar.setText("Modificar");
		botonEliminar.setText("Eliminar"); 
		botonCrear.setText("Crear");
		panelBotones.add(botonCrear);
		panelBotones.add(botonModificar);
		panelBotones.add(botonEliminar);
		panelBotones.add(botonGuardar);
		panelBotones.add(botonCargar);
		
		
		panelv3.add(panelLista);
		panelv3.add(panelCiudad);
		panelv3.add(panelCaminos);
		panelv3.add(panelBotones);
		
		
		super.panelPrincipal.add(panelv3);
		super.panelPrincipal.add(vb);

		
	}

}
