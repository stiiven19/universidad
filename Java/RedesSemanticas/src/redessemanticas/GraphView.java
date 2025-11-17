/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package redessemanticas;
//import org.jgrapht.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

import org.graphstream.ui.view.Viewer;


import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer.CloseFramePolicy;

public class GraphView {
    List<Relacion> relacionesSalientes;

    public GraphView() {
        relacionesSalientes = new ArrayList<>();
    }
     public List<Relacion> getRelacionesSalientes() {
        return relacionesSalientes;
    }
    
    public static void main(String args[]) {
            GraphView v = new GraphView();
            System.out.println("size " + v.getRelacionesSalientes().size());
            Graph graph = new MultiGraph("Bazinga!");
            graph.setStrict(false);
            graph.setAutoCreate( true );
            System.setProperty("org.graphstream.ui", "swing"); 
            //graph.addEdge( "AB", "A", "B" );
            //graph.addEdge( "BC", "B", "C" );
            //graph.addEdge( "CA", "C", "A" );
            
            //SpriteManager sman = new SpriteManager(graph);
            //Sprite s = sman.addSprite("S1");
            //s.setPosition(2, 1, 0);
            //s.attachToNode("A");
            //s.attachToEdge("AB");
            //s.setPosition(0.5);
            //s.detach();
            
            //s.attachToNode("A");
            //s.setPosition(Units.PX, 12, 180, 0);
            
            graph.setAttribute("ui.stylesheet", "graph { fill-color: red; }");
            
            graph.setAttribute("ui.quality");
            
            String nodeB = "B";

           
            Node node2 = graph.addNode(nodeB);

            // Agregar etiquetas a los nodos
            
            node2.setAttribute("ui.label", nodeB);
            String nodeA = "A";
            Node node1 = graph.addNode(nodeA);
            node1.setAttribute("ui.label", nodeA);
            node1.setAttribute("ui.style", "text-alignment: above; text-color: blue; text-size: 20;");
            node2.setAttribute("ui.style", "text-alignment: above; text-color: blue; text-size: 20;");

            // Agregar arista entre los nodos
            //graph.addEdge(nodeA + "aaaaaaaaaa" + nodeB, nodeA, nodeB);
            
            // Agregar arista entre los nodos con etiqueta
            Edge edge = graph.addEdge(nodeA + "-" + nodeB, nodeA, nodeB);
            edge.setAttribute("ui.label", "Relación");
            edge.setAttribute("ui.style", "text-alignment: above; text-size: 15;");

            
            // view = viewer.addDefaultView(false);   // false indicates "no JFrame".
            //Viewer viewer = graph.display();
            //View view = viewer.getDefaultView();
            //myJFrame.add(view);
            Viewer viewer = graph.display();

        // Configurar el cierre de la ventana del gráfico
        

        // Configurar el cierre de la ventana del gráfico
        viewer.enableAutoLayout();
        viewer.setCloseFramePolicy(CloseFramePolicy.CLOSE_VIEWER);

        // Crear una ventana para el gráfico
        JFrame frame = new JFrame("Red Semántica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        View view = viewer.getDefaultView();
        frame.add((Component) view);

        // Crear un botón para cerrar la ventana del gráfico
        JButton closeButton = new JButton("Cerrar Gráfico");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewer.close();
            }
        });
        frame.getContentPane().add(closeButton, BorderLayout.SOUTH);

        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}