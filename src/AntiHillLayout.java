import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.apache.commons.collections15.Factory;
import org.apache.commons.collections15.map.LazyMap;
 
import edu.uci.ics.jung.algorithms.layout.AbstractLayout;
import edu.uci.ics.jung.graph.Graph;
 
 
 
/**
 * A {@code Layout} implementation that positions vertices equally spaced on a regular circle.
 *
 * @author Masanori Harada
 */
public class AntiHillLayout<V, E> extends AbstractLayout<V,E> {
 
        private double radius;
        private List<V> vertex_ordered_list;
        private V antHill;
       
        Map<V, CircleVertexData> circleVertexDataMap =
                        LazyMap.decorate(new HashMap<V,CircleVertexData>(),
                        new Factory<CircleVertexData>() {
                                public CircleVertexData create() {
                                        return new CircleVertexData();
                                }});   
 
        /**
         * Creates an instance for the specified graph.
         */
        public AntiHillLayout(Graph<V,E> g, V antHill) {
                super(g);
                this.antHill = antHill;
        }
 
        /**
         * Returns the radius of the circle.
         */
        public double getRadius() {
                return radius;
        }
 
        /**
         * Sets the radius of the circle.  Must be called before
         * {@code initialize()} is called.
         */
        public void setRadius(double radius) {
                this.radius = radius;
        }
 
        /**
         * Sets the order of the vertices in the layout according to the ordering
         * specified by {@code comparator}.
         */
        public void setVertexOrder(Comparator<V> comparator)
        {
            if (vertex_ordered_list == null)
                vertex_ordered_list = new ArrayList<V>(getGraph().getVertices());
            	System.out.println("Vertex ordered list defined");
            Collections.sort(vertex_ordered_list, comparator);
        }
 
    /**
     * Sets the order of the vertices in the layout according to the ordering
     * of {@code vertex_list}.
     */
        public void setVertexOrder(List<V> vertex_list)
        {
            if (!vertex_list.containsAll(getGraph().getVertices()))
                throw new IllegalArgumentException("Supplied list must include " +
                                "all vertices of the graph");
            this.vertex_ordered_list = vertex_list;
        }
       
        public void reset() {
                initialize();
        }
 
        public void initialize()
        {
        			System.out.println("Entrando en initialize");
        			
               
                Dimension d = getSize();
               
               
                if (d != null)
                {
                		System.out.println("en if de  antihill");
                		System.out.println("getGraph().getVertices(): " + getGraph().getVertices().toString());
                    //if (vertex_ordered_list == null) {
                    	
                    	System.out.println("en if de vertex_ordered_list");
                    	
                        setVertexOrder(new ArrayList<V>(getGraph().getVertices()));
                    //}
                   
                        double height = d.getHeight();
                        double width = d.getWidth();
                        System.out.println("width: " + width);
                        System.out.println("height: " + height);
 
                        if (radius <= 0) {
                                radius = 0.45 * (height < width ? height : width);
                        }
 
                        int i = 0;
                        	System.out.println("vertOrderedList" + vertex_ordered_list.toString());
                        for (V v : vertex_ordered_list)
                        {
                        	System.out.println("en for de  antihill");
                               
                                Point2D coord = transform(v);
                               
                                if(v.equals(antHill)) {
                                        coord.setLocation(width/2, height/2);
                                        continue;
                                }
                               
                                double angle = (2 * Math.PI * i) / (vertex_ordered_list.size() - 1);
 
                                coord.setLocation(Math.cos(angle) * radius + width / 2,
                                                Math.sin(angle) * radius + height / 2);
 
                                CircleVertexData data = getCircleData(v);
                                data.setAngle(angle);
                                i++;
                                System.out.println("coord: " + coord.toString());
                        }
                }
        }
 
        protected CircleVertexData getCircleData(V v) {
                return circleVertexDataMap.get(v);
        }
 
        protected static class CircleVertexData {
                private double angle;
 
                protected double getAngle() {
                        return angle;
                }
 
                protected void setAngle(double angle) {
                        this.angle = angle;
                }
 
                @Override
                public String toString() {
                        return "CircleVertexData: angle=" + angle;
                }
        }
}