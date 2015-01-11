import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

public class VistaBuscador extends JPanel{
    
    private JLabel label;
    private JPanel vistaBuscar;
    private JTextField textoBusqueda;
    private JButton botonBuscar;
    
    
    private DefaultListModel model;
    private JList l;
    protected JScrollPane scroller;
    
	
    private Vista1 padre;
    
    
    VistaBuscador(Vista1 v1) {        
        this.setLayout(new GridBagLayout());
        padre = v1;
        //this.setMaximumSize(new Dimension(100, 250));
        //this.setMinimumSize(new Dimension(100, 250));
        
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(10,5,10,5));
        
        //Falta crear titulos, mirar Vista mapa
        
        //#########################################
    	//##########VISTABUSCADOR
        //#########################################
        
        vistaBuscar = new JPanel();
        //vistaBuscar.setMinimumSize(new Dimension(50,50));
        //vistaBuscar.setMaximumSize(new Dimension(50,50));
        
        
        // Texto a buscar
        textoBusqueda = new JTextField();
        textoBusqueda.setPreferredSize(new Dimension(120,30));
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        
        vistaBuscar.add(textoBusqueda, c);
        
        //Fin texto a buscar
        
        //Boton Buscar
        
        botonBuscar = new JButton("Buscar");
        botonBuscar.setBackground(Color.lightGray);
		botonBuscar.setFont(new Font("Verdana",4,10));
        
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent event) {
                if (model.isEmpty()) padre.setError("La lista esta vacia");
                else {
                    boolean trobat = false;
                    int i = 0;
                    while(!trobat && i < model.getSize()) {
                        if (model.get(i).toString().contains(textoBusqueda.getText())) trobat = true;
                        else ++i;
                    }
                    if(!trobat) padre.setError("No hay ningun elemento con el nombre: "+textoBusqueda.getText());
                    else {
                        l.setSelectedIndex(i);
                        l.ensureIndexIsVisible(i);
                        padre.comprovar("Cerca feta");
                    }
                }
            }
        });
        
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.BOTH;
        c1.gridx = 2;
        c1.gridy = 0;
        c1.gridwidth = 1;
        
        vistaBuscar.add(botonBuscar, c1);
        
        //Fin Boton Buscar
        
        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.BOTH;
        c2.gridx = 0;
        c2.gridy = 0;
        c2.gridwidth = 1;
        //c2.gridheight = 6;
        
        this.add(vistaBuscar,c2);
        //this.add(Box.createRigidArea(new Dimension(0, 5)));
        
        //#########################################
    	//##########LABEL
        //#########################################
        
        
        //label = new JLabel();
        //label.setAlignmentX(CENTER_ALIGNMENT);
        
        //this.add(label);
        //this.add(Box.createRigidArea(new Dimension(0, 5)));
        
        //#########################################
    	//##########SCROLLER
        //#########################################
        
        model = new DefaultListModel();
        l = new JList(model);
        
        scroller = new JScrollPane(l);
        
        GridBagConstraints c3 = new GridBagConstraints();
        c3.fill = GridBagConstraints.BOTH;
        c3.gridx = 0;
        c3.gridy = 1;
        c3.gridwidth = 1;
        //c3.gridheight = 5;
        
        scroller.setMinimumSize(new Dimension(250,500));
        scroller.setMaximumSize(new Dimension(250,500));
        
        
        //#########################################
        
        this.add(scroller,c3);
        //this.add(Box.createRigidArea(new Dimension(0, 10)));
        
    }
 
    
    public boolean listaEsVacia(){
    	return model.isEmpty(); 
    }
    
    public void setLabelText(String text) {
        label.setText(text);
    }
    
    
    public void clear() {
        model.clear();
    }
    
    public boolean haySeleccionado() {
        return !l.isSelectionEmpty();
     //   l.clearSelection();
    }
    public void quitarSeleccion() {
    	l.clearSelection();
    }
  
    public void agregar(String s) {
        model.addElement(s);
    }    
    
    public String devolverSeleccionado() {
        return l.getSelectedValue().toString();
    }
    
    public void modificarSeleccionado(String s) {
        model.set(l.getSelectedIndex(), s);
    }
    
    public void eliminarSeleccionado() {
        model.remove(l.getSelectedIndex());
    }
    
    public void agregarSelecListener(ListSelectionListener lista) {
        l.addListSelectionListener(lista);
    }
    
    public DefaultListModel retornarModel() {
        return model;
    }
    
    public void modificarModel(DefaultListModel m) {
        l.setModel(m);
    }
    
    public void activar() {
        scroller.setEnabled(true);
        textoBusqueda.setEnabled(true);
        botonBuscar.setEnabled(true);
    }
    /*
    public void desactivar() {
        scroller.setEnabled(false);
        textoBusqueda.setEnabled(false);
        botonBuscar.setEnabled(false);
    }*/

}
