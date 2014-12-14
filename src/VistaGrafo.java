

import javax.swing.JFrame;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import java.awt.*;

import javax.swing.*;
import java.util.*;

public class VistaGrafo extends JPanel {
	
	private mxGraph g;
	private ArrayList<String> vertexs;
	private int LimiteX;
	private int LimiteY;
	
	public VistaGrafo (){
		 g = new mxGraph();
		 vertexs = new ArrayList<String>();
	};
	
	public void agregarCiudad(int x, int y, String nom){
		System.out.println("aqui");
		Object parent = g.getDefaultParent();
		 g.getModel().beginUpdate();
		 int xscale = (x*this.getWidth())/LimiteX;
		 int yscale = (y*this.getHeight())/LimiteY;
		 int tamano = nom.length() * 6; //6 pixels per lletra
		 //g.insertVertex(parent, nom, nom, xscale, yscale, 200,200);
		 g.insertVertex(parent, null, "Hello", 20, 20, 30,
                 30);
		 vertexs.add(nom);
		 mxGraphComponent graphComponent = new mxGraphComponent(g);
		 this.add(graphComponent);
		 
	}
	
	public void setLimites (int x, int y){
		LimiteX = x;
		LimiteY = y;
	}
	
	/*
    public static void main(String[] args) {
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();
        graph.getModel().beginUpdate();
        try {
            Object v1 = graph.insertVertex(parent, null, "Hello", 20, 20, 30,
                    30);
            Object v2 = graph.insertVertex(parent, null, "World!", 240, 150,
                    80, 30);
            graph.insertEdge(parent, null, "Edge", v1, v2);
        } finally {
            graph.getModel().endUpdate();
        }
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        exempleJgraph frame = new exempleJgraph();
        frame.add(graphComponent);
        f.add(frame);
        f.pack();
        f.setVisible(true);
    }/*
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
	*/
}