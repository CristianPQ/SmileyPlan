
import javax.swing.JFrame;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import java.awt.*;

import javax.swing.*;

public class exempleJgraph extends JPanel {
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