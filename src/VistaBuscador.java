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
    private JScrollPane scroller;
    
	protected JLabel ciutat; 
    private Vista1 padre;
    
    
    VistaBuscador(Vista1 v1) {        
        
        padre = v1;
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(10,5,10,5));
        
        vistaBuscar = new JPanel();
        vistaBuscar.setMinimumSize(new Dimension(250,50));
        vistaBuscar.setMaximumSize(new Dimension(250,50));
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        
        
        // Texto a buscar
        textoBusqueda = new JTextField();
        textoBusqueda.setPreferredSize(new Dimension(120,30));
        
        vistaBuscar.add(textoBusqueda);
        
        botonBuscar = new JButton("Buscar");
        
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
        
        vistaBuscar.add(botonBuscar);
        
        label = new JLabel();
        label.setAlignmentX(CENTER_ALIGNMENT);
        
        model = new DefaultListModel();
        l = new JList(model);
        
        scroller = new JScrollPane(l);
        scroller.setMinimumSize(new Dimension(250,500));
        scroller.setMaximumSize(new Dimension(250,500));
		JLabel ciutat = new JLabel(); 
        
        this.add(label);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(ciutat); 
        this.add(vistaBuscar);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(scroller);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
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
    
    public void desactivar() {
        scroller.setEnabled(false);
        textoBusqueda.setEnabled(false);
        botonBuscar.setEnabled(false);
    }

}
