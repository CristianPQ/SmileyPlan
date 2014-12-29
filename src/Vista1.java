
import java.awt.*;
import java.io.FileFilter;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public abstract class Vista1 extends JPanel {
	
	protected JPanel panelPrincipal;
	//protected JPanel panelErrores;
	protected JLabel labelError;
	protected JFileChooser filechooser; 
	protected FileNameExtensionFilter filter; 
	
	Vista1(){
        this.setLayout(new GridBagLayout());
        
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints pP = new GridBagConstraints();
        pP.gridy = 0;
        pP.gridx = 0;
        pP.fill = GridBagConstraints.BOTH;
        
		this.add(panelPrincipal,pP);
        //panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.X_AXIS));
		
        labelError = new JLabel("Visor de errores");
        JPanel panelErrores = new JPanel();
        panelErrores.setMinimumSize(new Dimension(1000,40));
        panelErrores.setMaximumSize(new Dimension(1000,40));
        panelErrores.setBorder(BorderFactory.createEtchedBorder());
        panelErrores.add(labelError);
        
        filechooser = new JFileChooser(); 
        filter = new FileNameExtensionFilter(".smiley", "smiley");
        filechooser.setFileFilter(filter);
        filechooser.addChoosableFileFilter(filter);
		
		GridBagConstraints pE = new GridBagConstraints();
        pE.gridy = 1;
        pE.gridx = 0;
        pE.fill = GridBagConstraints.HORIZONTAL;
		
		this.add(panelErrores,pE);
		
	}
	
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
