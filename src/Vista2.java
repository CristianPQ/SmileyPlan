import javax.swing.*;

import java.awt.*;

public abstract class Vista2 extends Vista1 {

	protected VistaBuscador vb; 
	
	protected JPanel panelv2; 
	protected JPanel panelLista; 
	protected JPanel panelBotones; 
	protected JPanel panelCrear; 
	
	protected JButton botonCargar; 
	protected JButton botonGuardar;
	protected JButton botonModificar;
	protected JButton botonEliminar; 
	protected JButton botonCrear; 
	
	protected JTextField text1;
	protected JTextField text2; 
	protected JTextField text3; 
	
	protected JLabel label1;
	protected JLabel label2; 
	protected JLabel label3; 
	protected JLabel labelError; 
	
	public void reset() {
		text1.setText("");
		text2.setText("");
		//text3.setText("");
		vb.clear();
	}
	
	public Vista2() {
		super(); 
		
		vb = new VistaBuscador(this); 
		//vb.scroller.setMaximumSize(new Dimension(250,500));
		
		//panel que engloba a todos
		panelv2 = new JPanel(); 
		panelv2.setLayout(new GridBagLayout());
		panelv2.setBorder(BorderFactory.createEmptyBorder(10,20,15,20));
		
		//panel de introduccion datos 
		panelLista = new JPanel(); 
		panelLista.setBorder(BorderFactory.createLoweredBevelBorder());
		//panelLista.setMinimumSize(new Dimension(600,100));
		//panelLista.setMaximumSize(new Dimension(600,100));
	
		text1 = new JTextField(); 
		text1.setPreferredSize(new Dimension(100,30));
		text1.setEditable(true);
		label1 = new JLabel();
		label2 = new JLabel(); 
		labelError = new JLabel(); 
		text2 = new JTextField();
		text2.setPreferredSize(new Dimension(100,30));
		text2.setEditable(true);
		
		panelLista.add(label1);
		panelLista.add(text1);
		panelLista.add(label2);
		panelLista.add(text2);
		panelLista.add(labelError);
		panelLista.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder("")));

		
		//panel botones 
		panelBotones = new JPanel(); 
		//panelBotones.setBorder(BorderFactory.createLoweredBevelBorder());
		//Camino = BorderFactory.createTitledBorder("Camino: ");
		panelBotones.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder("")));
		panelBotones.setMinimumSize(new Dimension(600,100));
		//panelBotones.setMaximumSize(new Dimension(600,100));
		botonCargar = new JButton(); 
		botonGuardar = new JButton();
		botonModificar = new JButton();
		botonEliminar = new JButton();
		botonCrear = new JButton(); 
		botonGuardar.setText("Guardar"); 
		botonGuardar.setBackground(Color.lightGray);
		botonGuardar.setFont(new Font("Verdana",4,10));
		botonCargar.setText("Cargar");
		botonCargar.setBackground(Color.lightGray);
		botonCargar.setFont(new Font("Verdana",4,10));
		botonModificar.setText("Modificar");
		botonModificar.setBackground(Color.lightGray);
		botonModificar.setFont(new Font("Verdana",4,10));
		botonEliminar.setText("Eliminar"); 
		botonEliminar.setBackground(Color.lightGray);
		botonEliminar.setFont(new Font("Verdana",4,10));
		botonCrear.setText("Crear");
		botonCrear.setBackground(Color.lightGray);
		botonCrear.setFont(new Font("Verdana",4,10));
		panelBotones.add(botonCrear);
		panelBotones.add(botonModificar);
		panelBotones.add(botonEliminar);
		panelBotones.add(botonGuardar);
		panelBotones.add(botonCargar);
		
		GridBagConstraints gbcPL = new GridBagConstraints();
		gbcPL.gridy = 0;
		gbcPL.fill = GridBagConstraints.BOTH;
				
		panelv2.add(panelLista, gbcPL);
		
		GridBagConstraints gbcPB = new GridBagConstraints();
		gbcPB.gridy = 1;
		gbcPB.fill = GridBagConstraints.BOTH;
		
		panelv2.add(panelBotones, gbcPB);
		
		GridBagConstraints gbcPv2 = new GridBagConstraints();
		gbcPv2.gridx = 0;
		gbcPv2.fill = GridBagConstraints.BOTH;
		
		super.panelPrincipal.add(panelv2,gbcPv2);
		
		GridBagConstraints gbcVB = new GridBagConstraints();
		gbcVB.gridx = 1;
		gbcVB.fill = GridBagConstraints.BOTH;
		
		super.panelPrincipal.add(vb, gbcVB); 
		
	    
	}
	
}
