
import java.awt.*;

import javax.swing.*;

public abstract class Vista1 extends JPanel {
	
	protected JPanel panelPrincipal;
	protected JPanel panelErrores;
	protected JLabel labelError;
	protected JFileChooser filechooser; 
	
	Vista1(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.X_AXIS));
		
        labelError = new JLabel("Visor de errores");
        panelErrores = new JPanel();
        panelErrores.setMinimumSize(new Dimension(1000,40));
        panelErrores.setMaximumSize(new Dimension(1000,40));
        panelErrores.setBorder(BorderFactory.createEtchedBorder());
        panelErrores.add(labelError);
        
        filechooser = new JFileChooser(); 
		
		this.add(panelPrincipal);
		this.add(panelErrores);
		
	}
	
    //abstract void agregarBotones();
    public void setError(String e) {
        labelError.setText("Error: "+e);
        labelError.setForeground(Color.red);
    }
    
    public void comprovar(String txt) {
        labelError.setText("Visor de errores");
        labelError.setForeground(Color.black);
    }
	
    public void cargarConChooser(){}
    
    public void guardarConChooser(){}
}
