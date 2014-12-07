



import java.awt.*;

import javax.swing.*;



public abstract class Vista1 extends JPanel {
	JPanel panelPrincipal;
	JPanel panelErrores;
	JLabel error;
	
	Vista1(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.X_AXIS));
		
        error = new JLabel("Visor de errores");
        panelErrores = new JPanel();
        panelErrores.setMinimumSize(new Dimension(1000,40));
        panelErrores.setMaximumSize(new Dimension(1000,40));
        panelErrores.setBorder(BorderFactory.createEtchedBorder());
        panelErrores.add(error);
		
		this.add(panelPrincipal);
		this.add(panelErrores);
		
	}
    abstract void agregarBotones();
    
    public void setError(String e) {
        error.setText("Error: "+e);
        error.setForeground(Color.red);
    }
    
    public void inicializar(String txt) {
        error.setText("Visor de errores");
        error.setForeground(Color.black);
    }
	
	
}
