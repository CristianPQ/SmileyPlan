

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

import com.mxgraph.layout.mxFastOrganicLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import java.awt.*;

import javax.swing.*;

import java.util.*;

public class VistaGrafo extends JPanel {
	
	private mxGraph g;
	private TST<Object> vertexs;
	private int LimiteX;
	private int LimiteY;
	
	public VistaGrafo (){
		 g = new mxGraph();
		 /*mxHierarchicalLayout layout = new mxHierarchicalLayout(g);
		 layout.setParallelEdgeSpacing(10); 
		 layout.execute(g.getDefaultParent());*/
		 vertexs = new TST<Object>();
		 this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		 
	        this.setBorder(BorderFactory.createEmptyBorder(10,5,10,5));
	        mxGraphComponent graphComponent = new mxGraphComponent(g);
			 g.getModel().endUpdate();
			 this.add(graphComponent);
			 graphComponent.setEnabled(false);
	};
	
	public void agregarCiudad(int x, int y, String nom){
		Object parent = g.getDefaultParent();
		 g.getModel().beginUpdate();
		 int xscale = (x*this.getWidth())/LimiteX;
		 int yscale = (y*this.getHeight())/LimiteY;
		 int tamano = nom.length() * 7; //6 pixels per lletra
		 //g.insertVertex(parent, nom, nom, xscale, yscale, 200,200);
		// if (xscale+tamano > this.getWidth()) xscale = (this.getWidth()-tamano)-15;
		 //if (yscale+15 > this.getHeight()) yscale = this.getHeight()-40;
		if (!vertexs.existe(nom)){
			Object o = g.insertVertex(parent, nom, nom, xscale, yscale, tamano, 15);
			vertexs.insert(nom,o);
			g.getModel().endUpdate();	
		}
	}
	public void agregarCamino(String nom1, String nom2, String Capacidad){
		Object parent = g.getDefaultParent();
		g.getModel().beginUpdate();
		Object source = vertexs.consultar(nom1);
		Object target = vertexs.consultar(nom2);
		g.insertEdge(parent, null, Capacidad, source, target);
		g.getModel().endUpdate();
	}
	public void borrarCamino(String nom1, String nom2){
		Object parent = g.getDefaultParent();
		g.getModel().beginUpdate();
		Object source = vertexs.consultar(nom1);
		Object target = vertexs.consultar(nom2);
		 Object[] edges = g.getEdgesBetween( source, target);
		g.getModel().endUpdate();
	}
	public static class CustomGraphComponent extends mxGraphComponent
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = -6833603133512882012L;

		/**
		 * 
		 * @param graph
		 */
		public CustomGraphComponent(mxGraph graph)
		{
			super(graph);

			// Sets switches typically used in an editor
			setPageVisible(true);
			setGridVisible(true);
			setToolTips(true);
			getConnectionHandler().setCreateTarget(true);

			// Loads the defalt stylesheet from an external file
			//mxCodec codec = new mxCodec();
			//Document doc = mxUtils.loadDocument(GraphEditor.class.getResource(
			//		"/com/mxgraph/examples/swing/resources/default-style.xml")
			//.toString());
			//codec.decode(doc.getDocumentElement(), graph.getStylesheet());

			// Sets the background to white
			getViewport().setOpaque(true);
			getViewport().setBackground(Color.WHITE);
		}

		/**
		 * Overrides drop behaviour to set the cell style if the target
		 * is not a valid drop target and the cells are of the same
		 * type (eg. both vertices or both edges). 
		 */


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