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
	
	public Vista2() {
		super(); 
		
		vb = new VistaBuscador(this); 
		vb.scroller.setMaximumSize(new Dimension(250,500));
		
		//panel que engloba a todos
		panelv2 = new JPanel(); 
		panelv2.setLayout(new BoxLayout(panelv2, BoxLayout.Y_AXIS));
		panelv2.setBorder(BorderFactory.createEmptyBorder(10,20,15,20));
		
		//panel de introduccion datos 
		panelLista = new JPanel(); 
		panelLista.setBorder(BorderFactory.createLoweredBevelBorder());
		//panelLista.setMinimumSize(new Dimension(600,100));
		panelLista.setMaximumSize(new Dimension(600,100));
	
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

		
		//panel botones 
		panelBotones = new JPanel(); 
		panelBotones.setBorder(BorderFactory.createLoweredBevelBorder());
		panelBotones.setMinimumSize(new Dimension(600,100));
		panelBotones.setMaximumSize(new Dimension(600,100));
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
		
				
		panelv2.add(panelLista);
		panelv2.add(panelBotones);
		
		super.panelPrincipal.add(panelv2); 
		super.panelPrincipal.add(vb); 
		
	    
	}
	
}
