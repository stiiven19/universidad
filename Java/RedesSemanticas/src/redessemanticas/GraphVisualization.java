/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package redessemanticas;
import org.jgrapht.*;
import org.jgrapht.graph.*;


public class GraphVisualization {

    private GraphStream stream = new GraphStream();

    public GraphVisualization(Graph<String, DefaultEdge> jgraphtGraph) {
        

        // Transferir nodos y relaciones de JGraphT a GraphStream
        for (String node : jgraphtGraph.vertexSet()) {
            stream.addnodes(node);
        }

        for (DefaultEdge edge : jgraphtGraph.edgeSet()) {
            String source = jgraphtGraph.getEdgeSource(edge);
            String target = jgraphtGraph.getEdgeTarget(edge);
            stream.addedges(source, target);
        }
    }

    public void displayGraph() {
        stream.displayGraph();
    }
}
