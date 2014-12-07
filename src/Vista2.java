import javax.swing.*;
import java.awt.*;

public abstract class Vista2 extends Vista1 {

	private VistaBuscador vb; 
	
	private JPanel panelv2; 
	private JPanel panelLista; 
	private JPanel panelBotones; 
	private JPanel panelCrear; 
	
	private JButton botonCargar; 
	private JButton botonGuardar;
	private JButton botonModificar;
	private JButton botonEliminar; 
	private JButton botonCrear; 
	
	private JTextField text1;
	private JTextField text2; 
	
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
		panelBotones.add(botonCargar);
		panelBotones.add(botonGuardar);
		panelBotones.add(botonModificar);
		panelBotones.add(botonEliminar);
		
		//panel cargar
		panelCrear = new JPanel(); 
		panelCrear.setBorder(BorderFactory.createLoweredBevelBorder());
		panelCrear.setMinimumSize(new Dimension(70,30));
		panelCrear.setMaximumSize(new Dimension(70,30));
		botonCrear = new JButton(); 
		text2 = new JTextField(); 
		text1.setPreferredSize(new Dimension(70,30));
		text1.setEditable(true);
		panelCrear.add(botonCrear);
		panelCrear.add(text2); 
		
		panelv2.add(panelLista);
		panelv2.add(panelBotones);
		panelv2.add(panelCrear);
		
		super.panelv1.add(panelv2); 
		super.panelv1.add(vb); 
	}
	
	//falten classes abstractes per obrir el browser 
}
