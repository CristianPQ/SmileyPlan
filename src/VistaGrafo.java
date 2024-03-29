

/*import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

import com.mxgraph.layout.mxFastOrganicLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.FRLayout;*/
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
//import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
//import edu.uci.ics.jung.samples.SimpleGraphDraw;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
//import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

import java.awt.*;

import javax.swing.*;

import org.apache.commons.collections15.Transformer;

import java.util.*;

public class VistaGrafo extends JPanel {
	
	private Graph <Integer, String> g;
	private ArrayList<String> mapeo;
	private BasicVisualizationServer<Integer,String> vv;
	private Layout<Integer, String> layout;
	
	public void reset() {
		Collection<Integer> a = g.getVertices();
		ArrayList<Integer> as = new ArrayList<Integer>(a);
		for(int i = 0; i < as.size(); ++i) {
			g.removeVertex(as.get(i));
		}
		
		Collection<String> ar = g.getEdges();
		ArrayList<String> ars = new ArrayList<String>(ar);
		for(int i = 0; i < ars.size(); ++i) {
			g.removeEdge(ars.get(i));
		}
		
		mapeo.clear();
		
	}
	
	public  VistaGrafo(/*ControladorPresentacionMapa cm*/){
			System.out.println("Antes de crear Grafo g");
		g = new DirectedSparseMultigraph<Integer, String>();
			System.out.println("Despues de crear Grafo g");
		mapeo = new ArrayList<String>();
		this.setBackground(Color.LIGHT_GRAY);
		layout = new AntiHillLayout<Integer, String>(g, 0);
		//layout = new CircleLayout<Integer,String>(g);
		//layout.setLocation(, arg1);
		layout.setSize(new Dimension(350,350));
		//layout.initialize();
		//layout.
		
		 
		 BasicVisualizationServer<Integer,String> vv =
	              new BasicVisualizationServer<Integer,String>(layout);
	    vv.setPreferredSize(new Dimension(350,350));
		 vv.setBackground(Color.LIGHT_GRAY);

        Transformer<Integer,Paint> vertexPaint = new Transformer<Integer,Paint>() {
            public Paint transform(Integer i) {
                return Color.RED;
} };

        vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint);
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<Integer>());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller<String>());
       vv.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);

       add(vv);
        
	}
	
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(350,350);
    }

	public void crearVertex(Integer i){
		System.out.println("vertices de grafo antes de agregar: " + g.getVertices().toString());
		System.out.println("vertice a agregar: " + i);
		g.addVertex(i);
		System.out.println("vertices de grafo despues de agregar: " + g.getVertices().toString());
		System.out.println("numero vertices: " + g.getVertexCount());
		layout.initialize();
	}
	
	public void eliminarVertex(Integer i){
		System.out.println("Antes de removeVertex: " + g.getVertices().toString());
		g.removeVertex(i);
		System.out.println("Despues de removeVertex: " + g.getVertices().toString());
		//layout.
		layout.initialize();
	}
	
	public void crearAresta(String n1, String n2, String mt){
		int o = mapeo.indexOf(n1);
		int d = mapeo.indexOf(n2);
		g.addEdge(n1 + " - " + n2 + " / " + mt, o,d, EdgeType.DIRECTED);
		layout.initialize();
	}
	
	public void eliminarAresta(String n1, String n2, String mt){
		g.removeEdge(n1 + " - " + n2 + " / " + mt);
		layout.initialize();
	}

	public ArrayList<String> consultarMapeo(){
		return mapeo;
	}
	
	public void modificarMapeo(ArrayList<String> ma){
		mapeo = ma;
	}
	
	public BasicVisualizationServer<Integer,String> getVisual(){
		return vv;
	}
	

	public void dibujar(){
		System.out.println("Entra en dibujar");
		//vv.repaint();
		/* g.addVertex((Integer)1);
		 g.addVertex((Integer)2);
		 g.addVertex((Integer)3);

	 Layout<Integer, String> layout = new CircleLayout(g);
		 
	
		 
		 BasicVisualizationServer<Integer,String> vv =
	              new BasicVisualizationServer<Integer,String>(layout);
	    vv.setPreferredSize(new Dimension(600,600));
		 
        Transformer<Integer,Paint> vertexPaint = new Transformer<Integer,Paint>() {
            public Paint transform(Integer i) {
                return Color.RED;
} };

        vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint);
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
       vv.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);

       add(vv);
  */      
	}
	
	
   /* public static void main(String[] args)
    {
    	
		 Graph <Integer, String> g = new DirectedSparseMultigraph<Integer,String>();

		 g.addVertex((Integer)1);
		 g.addVertex((Integer)2);
		 g.addVertex((Integer)3);
		 
	     g.addEdge("Edge-A", 2, 3, EdgeType.DIRECTED); // Note that Java 1.5 auto-boxes primitives
	     g.addEdge("Edge-B", 1, 3,  EdgeType.DIRECTED);

		 
		 Layout<Integer, String> layout = new CircleLayout(g);
		 
		  vv =
	              new BasicVisualizationServer<Integer,String>(layout);
	     vv.setPreferredSize(new Dimension(350,350));

	        Transformer<Integer,Paint> vertexPaint = new Transformer<Integer,Paint>() {
	            public Paint transform(Integer i) {
	                return Color.RED;
	} };
	
  
 
	        vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint);
	        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
	        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
	       vv.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
	        
	     JFrame frame = new JFrame("Simple Graph View");
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.getContentPane().add(vv);
	     frame.pack();
	     frame.setVisible(true);

	 }*/
}