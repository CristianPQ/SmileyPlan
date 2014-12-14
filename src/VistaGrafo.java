
import java.awt.*;

import javax.swing.*;
 import LEDA.graph.*;


public class VistaGrafo extends JPanel{
	
	int PAD = 20;
    boolean drawLine = true;
    boolean drawDots = true;
    int dotRadius = 3;

    // the y coordinates of the points to be drawn; the x coordinates are evenly spaced
    int[] data = { 25, 60, 42, 75 };
    private GrafoAntiguo grafo;
    private String continente;
    private int xCiudad;
    private int yCiudad;
    private int x1p;
    private int x2p;
    private int y1p;
    private int y2p;
    private int xLimite;
    private int yLimite;
    private boolean pintaCamino = false;
    private boolean pintaCiudad = false;
    private boolean pintaGrafo = false;
    private boolean pintaContinente = false;
    private boolean borrar = false;
    private boolean coche = true;

    
    public VistaGrafo(int x, int y){
    	xCiudad = x;
    	yCiudad = y;
    	this.setBackground(Color.white);
    	System.out.print("aqui");
    	Graph G;    //define directed graph G

    	  node center=G.new_node();   //create new node "center" of G

    	  int i; 
    	  for (i=0;i<100;i++) {
    	    node v=G.new_node();     //create new node v of G
    	    G.new_edge(center,v);    //create new edge of G 
    	                             //with source center and target v
    	  }
    	  
    	  edge e;
    	  forall_edges(e,G) {           //iterate over all edges e of G
    	    node source=G.source(e);  //compute source of e
    	    node target=G.target(e);  //compute target of e

    	  
    	    G.print_edge(e);          //print edge
    	
    	    G.print_node(source);     //print source
    
    	    G.print_node(target);     //print target
    	
    	  }

    };
    
    public void agregarGrafo(GrafoAntiguo gra){
    	grafo = gra;
    	pintaGrafo = true;
    }
    public void agregarContinente(String s){
    	continente = s;
    	pintaContinente = true;
    }
    public void agregarCiudad(int x, int y){
    	System.out.print("agregarCiudad");
    	xCiudad = x;
    	yCiudad = y;
    	pintaCiudad = true;
    }
    public void agregarCaminoCoche(int x1, int y1, int x2, int y2){
    	x1p = x1;
    	x2p = x2;
    	y1p = y1;
    	y2p = y2; 
    	coche = true;
    	pintaCamino = true;
    }
    public void agregarCaminoTren(int x1, int y1, int x2, int y2){
    	x1p = x1;
    	x2p = x2;
    	y1p = y1;
    	y2p = y2; 
    	coche = false;
    	pintaCamino = true;
    }
    public void eliminarrGrafo(GrafoAntiguo gra){
    	grafo = gra;
    	borrar = true;
    	pintaGrafo = true;
    }
    public void eliminarContinente(String s){
    	continente = s;
    	borrar = true;
    	pintaContinente = true;	
    }
    public void elimnarCiudad(int x, int y){
    	xCiudad = x;
    	yCiudad = y;
    	borrar=true;
    	pintaCiudad = true;
    }
    public void eliminarCamino(int x1, int y1, int x2, int y2){
    	x1p = x1;
    	x2p = x2;
    	y1p = y1;
    	y2p = y2; 
    	borrar = true;
    	pintaCamino = true;
    }
    public void setlimites(int x, int y){
    	xLimite = x;
    	yLimite = y;
    }

    public void paintComponent (Graphics g)
    {
    	
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        g2.fillOval(xCiudad-dotRadius, yCiudad-dotRadius, 2*dotRadius, 2*dotRadius);
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
     	//System.out.print("aqui");

       // g2.drawLine(PAD, PAD, PAD, h-PAD);
        //g2.drawLine(PAD, h-PAD, w-PAD, h-PAD);
        double xScale = (w - 2*PAD) / (data.length + 1);
        double maxValue = 100.0;
        double yScale = (h - 2*PAD) / maxValue;
        // The origin location
        int x0 = PAD;
        int y0 = h-PAD;

        // draw connecting line
        if (pintaCiudad)
        {
        	System.out.print(w);
        	if (borrar) g2.setPaint(Color.white);
        	else g2.setPaint(Color.black);
        	xCiudad = (xCiudad * w)/xLimite;
        	yCiudad = (yCiudad * h)/yLimite;
        	g2.fillOval(xCiudad-dotRadius, yCiudad-dotRadius, 2*dotRadius, 2*dotRadius);
        	pintaCiudad = false;
        	borrar = false;
        }

        // draw the points as little circles in red
        if (pintaCamino)
        {
        	System.out.println("camino");
        	if (borrar) g2.setPaint(Color.white);
            else if (coche) g2.setPaint(Color.blue);
            else g2.setPaint(Color.black);
        	x1p = (x1p * w)/xLimite;
        	x2p = (x2p * w)/xLimite;
        	y1p = (y1p * h)/yLimite;
        	y1p = (y1p * h)/yLimite;
        	//g2.setPaint(Color.black);
        	g2.drawLine(0, 0, 50, 50);
        	pintaCamino = false; 
        	borrar = false;
        	System.out.println("Surtcamino");
        }
        if (true){
        	System.out.println("aqui");
        g2.drawLine(100, 00, 50, 50);
        }
        
    }   
	
}
/*
    public static void main(String[] args)
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VistaGrafo v = new VistaGrafo();
        f.getContentPane().add(v);
        f.setSize(400,400);
        f.setLocation(200,200);
        f.setVisible(true);
    }
	
}
*/
