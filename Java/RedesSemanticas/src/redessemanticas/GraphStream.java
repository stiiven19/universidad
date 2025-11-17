/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package redessemanticas;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.SinkAdapter;

/**
 *
 * @author andre
 */
public class GraphStream {
    
        private org.graphstream.graph.Graph graphStream;

    public GraphStream() {
        graphStream = new SingleGraph("Red Semántica");
        System.setProperty("org.graphstream.ui", "swing"); 
        graphStream.addSink(new SinkAdapter() {
            public void graphClosed(String graphId) {
                System.out.println("La ventana del gráfico ha sido cerrada.");
            }
        });
    }
        
        
        
    public void addnodes(String node){
        graphStream.addNode(node);
    }
    public void addedges(String source, String target){
        graphStream.addEdge(source + "-" + target, source, target);
    }
    public void displayGraph() {
                    
        graphStream.display();
            graphStream.addSink(new SinkAdapter() {
                public void graphClosed(String graphId) {
                    System.out.println("La ventana del gráfico ha sido cerrada.");
                }
            });
    }
}
