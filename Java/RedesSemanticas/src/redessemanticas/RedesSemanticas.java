/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package redessemanticas;

import javax.swing.JFrame;

import javax.swing.SwingUtilities;

import org.jgrapht.*;
import org.jgrapht.graph.*;
/**
 *
 * @author andre
 */
public class RedesSemanticas {

    public static void main(String[] args) {
        
        
        
        SwingUtilities.invokeLater(() -> {
            //Graph<String, DefaultEdge> graph = null;
            //graph.addEdge("S", "A");
            JFrame frame = new InterfazUsuario();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
