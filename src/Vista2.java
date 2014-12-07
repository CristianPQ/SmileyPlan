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
	
	protected JLabel label1;
	protected JLabel label2; 
	
	public Vista2() {
		super(); 
		
		vb = new VistaBuscador(this); 
		
		//panel que engloba a todos
		panelv2 = new JPanel(); 
		panelv2.setLayout(new BoxLayout(panelv2, BoxLayout.Y_AXIS));
		panelv2.setBorder(BorderFactory.createEmptyBorder(10,20,15,20));
		
		//panel de lista
		panelLista = new JPanel(); 
		panelLista.setBorder(BorderFactory.createLoweredBevelBorder());
		panelLista.setMinimumSize(new Dimension(400,40));
		panelLista.setMaximumSize(new Dimension(400,40));
		
		//aixo es el quadrat de la llista?
		text1 = new JTextField(); 
		text1.setPreferredSize(new Dimension(70,30));
		text1.setEditable(false);
		
		panelLista.add(text1);
		
		//panel botones 
		panelBotones = new JPanel(); 
		panelBotones.setBorder(BorderFactory.createLoweredBevelBorder());
		panelBotones.setMinimumSize(new Dimension(250,80));
		panelBotones.setMaximumSize(new Dimension(250,80));
		botonCargar = new JButton(); 
		botonGuardar = new JButton();
		botonModificar = new JButton();
		botonEliminar = new JButton();
		botonGuardar.setText("Guardar"); 
		botonCargar.setText("Cargar");
		botonModificar.setText("Modificar");
		botonEliminar.setText("Eliminar"); 
		panelBotones.add(botonCargar);
		panelBotones.add(botonGuardar);
		panelBotones.add(botonModificar);
		panelBotones.add(botonEliminar);
		
		//panel crear
		panelCrear = new JPanel(); 
		panelCrear.setBorder(BorderFactory.createLoweredBevelBorder());
		panelCrear.setMinimumSize(new Dimension(70,30));
		panelCrear.setMaximumSize(new Dimension(70,30));
		botonCrear = new JButton(); 
		label1 = new JLabel();
		label2 = new JLabel(); 
		text2 = new JTextField(); 
		text1.setPreferredSize(new Dimension(70,30));
		text1.setEditable(true);
		panelCrear.add(botonCrear);
		panelCrear.add(text2); 
		panelCrear.add(label2);
		panelCrear.add(label1);
		
		panelv2.add(panelLista);
		panelv2.add(panelBotones);
		panelv2.add(panelCrear);
		
		
		super.panelPrincipal.add(panelv2); 
		super.panelPrincipal.add(vb); 
	}
	
	//falten classes abstractes per obrir el browser 
}
