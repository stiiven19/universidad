/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package redessemanticas;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author andre
 */
public class ejemploaristas {
    public static void main(String[] args) {
        // Crea un nuevo grafo
        //Graph graph = new SingleGraph("MiGrafo");
        Graph graph = new SingleGraph("Grafo!");
        System.setProperty("org.graphstream.ui", "swing"); 
        graph.setAttribute("ui.stylesheet", "graph { fill-color: red; }");
        graph.setAttribute("ui.quality");
        // Agrega algunos nodos con etiquetas
        Node nodeA = graph.addNode("A");
        nodeA.setAttribute("ui.label", "Nodo A");
        
        Node nodeB = graph.addNode("B");
        nodeB.setAttribute("ui.label", "Nodo B");

        // Agrega una arista de A a B y establece el atributo para mostrar una flecha
        graph.addEdge("AB", "A", "B", true);
        
        // Establece el atributo para mostrar una flecha en la arista
        graph.getEdge("AB").setAttribute("ui.style", "arrow-shape: arrow;");
        
        // Muestra el grafo
        graph.display();
    }
}
