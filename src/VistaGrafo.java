

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

import com.mxgraph.layout.mxFastOrganicLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.samples.SimpleGraphDraw;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

import java.awt.*;

import javax.swing.*;

import org.apache.commons.collections15.Transformer;

import java.util.*;

public class VistaGrafo extends JPanel {
	
	private Graph <Integer, String> g;
	private ArrayList<String> mapeo;
	
	public  VistaGrafo(){
		g = new DirectedSparseMultigraph<Integer, String>();
		mapeo = new ArrayList<String>();
		
	}
	
	public void crearVertex(Integer i){
		g.addVertex((Integer)i);
	}
	
	public void eliminarVertex(Integer i){
		g.removeVertex(i);
	}
	
	public void crearAresta(String n1, String n2){

		g.addEdge(n1 + " - " + n2, 2, 3, EdgeType.DIRECTED);
		
	}
	
	public void eliminarAresta(String n1, String n2){
		g.removeEdge(n1 + " - " + n2);
	}

	public ArrayList<String> consultarMapeo(){
		return mapeo;
	}
	
    public static void main(String[] args)
    {
    	
		 Graph <Integer, String> g = new DirectedSparseMultigraph<Integer,String>();

		 g.addVertex((Integer)1);
		 g.addVertex((Integer)2);
		 g.addVertex((Integer)3);
		 
	     g.addEdge("Edge-A", 2, 3, EdgeType.DIRECTED); // Note that Java 1.5 auto-boxes primitives
	     g.addEdge("Edge-B", 1, 3,  EdgeType.DIRECTED);

		 
		 Layout<Integer, String> layout = new CircleLayout(g);
		 
		 BasicVisualizationServer<Integer,String> vv =
	              new BasicVisualizationServer<Integer,String>(layout);
	     vv.setPreferredSize(new Dimension(350,350));

	        Transformer<Integer,Paint> vertexPaint = new Transformer<Integer,Paint>() {
	            public Paint transform(Integer i) {
	                return Color.CYAN;
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

	 }
}