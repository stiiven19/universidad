/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package redessemanticas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
//import org.jgrapht.*;
//import org.jgrapht.graph.*;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.stream.file.FileSinkGraphML;
import org.graphstream.stream.file.FileSourceGraphML;
import org.graphstream.ui.view.Viewer;



import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer.CloseFramePolicy;

public class InterfazUsuario extends JFrame {
    private JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8;
    private JTextField nodeNameField;
    private JComboBox<String> nodeComboBox1;
    private JComboBox<String> nodeComboBox2;
    private JTextField relationshipField;
    private JButton addNodeButton;
    private JButton addRelationshipButton;
    
    private JButton showGraphButton;
    private JTextArea relationshipTextArea;
    private List<Nodo> nodos;  
    private DefaultComboBoxModel<String> nodeComboBoxModel1;
    private DefaultComboBoxModel<String> nodeComboBoxModel2;
    
    //activaciones
    private JButton showActivation, showJLC;
    private JTextArea ActivationshipTextArea, JLCArea, AnzuelosArea, ParejasArea;
    private DefaultComboBoxModel<String> nodeComboBoxModel3;
    private DefaultComboBoxModel<String> nodeComboBoxModel4;
    private DefaultComboBoxModel<String> nodeComboBoxModel5;
    private JComboBox<String> nodeComboBox3;
    private JComboBox<String> nodeComboBox4;
    private JComboBox<String> nodeComboBox5;
    private JMenuBar menuBar;
    private JMenuItem importGraphItem, GuardarGrafo;
    // Crear una lista para almacenar nodos
    // Agregamos un JTextArea
    


    public InterfazUsuario() {
        
        setTitle("Redes Semánticas");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        accesorios();
        updatecombobox();
        eventos();
        
    }    
    private void accesorios(){
        
        
        nodos = new ArrayList<>();
        
        jl1 = new JLabel("Nombre del Nodo:");jl1.setBounds(20, 20, 110, 20);
        nodeNameField = new JTextField();nodeNameField.setBounds(140, 20, 180, 20);
        addNodeButton = new JButton("Agregar Nodo");addNodeButton.setBounds(330, 20, 120, 20);
//        add(jl1);
//        add(nodeNameField);
//        add(addNodeButton);
        nodeComboBoxModel1 = new DefaultComboBoxModel<>();
        nodeComboBoxModel2 = new DefaultComboBoxModel<>();
        nodeComboBoxModel1.addElement("Seleccionar nodo origen");
        nodeComboBoxModel2.addElement("Seleccionar nodo destino");

        jl2 = new JLabel("Relacion: ");jl2.setBounds(210, 50, 120, 20);
        jl3 = new JLabel("Nodo 1: ");jl3.setBounds(20, 50, 120, 20);
        jl4 = new JLabel("Nodo 2: ");jl4.setBounds(380, 50, 120, 20);
        nodeComboBox1 = new JComboBox<>();nodeComboBox1.setBounds(20, 80, 170, 20);
        nodeComboBox2 = new JComboBox<>();nodeComboBox2.setBounds(380, 80, 170, 20);
        relationshipField = new JTextField();relationshipField.setBounds(210, 80, 160, 20);
        addRelationshipButton = new JButton("Agregar Relación");addRelationshipButton.setBounds(215, 110, 150, 20);
        relationshipTextArea = new JTextArea("Relaciones: ");
        relationshipTextArea.setEditable(false); // Configuramos como de solo lectura
        JScrollPane scrollPane = new JScrollPane(relationshipTextArea);scrollPane.setBounds(570, 20, 190, 130);
        nodeComboBox1.setModel(nodeComboBoxModel1);
        nodeComboBox2.setModel(nodeComboBoxModel2);
        add(jl2);
        add(jl3);
        add(jl4);
        add(nodeComboBox1);
        add(nodeComboBox2);
        add(relationshipField);
        add(addRelationshipButton);
        add(scrollPane);
        //activacion
        nodeComboBoxModel3 = new DefaultComboBoxModel<>();
        nodeComboBoxModel4 = new DefaultComboBoxModel<>();
        nodeComboBoxModel3.addElement("Seleccionar nodo origen");
        nodeComboBoxModel4.addElement("Seleccionar nodo destino");
        jl5 = new JLabel("Activaciones: ");jl5.setBounds(210, 140, 120, 20);
        jl6 = new JLabel("Nodo 1: ");jl6.setBounds(20, 140, 120, 20);
        jl7 = new JLabel("Nodo 2: ");jl7.setBounds(380, 140, 120, 20);
        nodeComboBox3 = new JComboBox<>();nodeComboBox3.setBounds(20, 170, 170, 20);
        nodeComboBox4 = new JComboBox<>();nodeComboBox4.setBounds(380, 170, 170, 20);
        showActivation = new JButton("Verificar");showActivation.setBounds(230, 170, 120, 20);
        ActivationshipTextArea = new JTextArea("Activaciones");
        JScrollPane scrollPane2 = new JScrollPane(ActivationshipTextArea);scrollPane2.setBounds(570, 170, 190, 70);/////////
        ActivationshipTextArea.setEditable(false);
        nodeComboBox3.setModel(nodeComboBoxModel3);
        nodeComboBox4.setModel(nodeComboBoxModel4);
        add(jl5);
        add(jl6);
        add(jl7);
        add(nodeComboBox3);
        add(nodeComboBox4);
        add(scrollPane2);
        add(showActivation);
        showGraphButton = new JButton("Mostrar Gráfico");showGraphButton.setBounds(570, 250, 190, 20);
        add(showGraphButton);

//        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel addNodePanel = new JPanel(null);addNodePanel.setBounds(0, 0, 450, 140);
//        JPanel addRelationPanel = new JPanel(new GridLayout(3, 2,10,10));
//        JPanel addActivationPanel = new JPanel(new GridLayout(3, 2,10,10));
//        
//        //AGREGAR NODOS PANEL
        addNodePanel.add(jl1);
        addNodePanel.add(nodeNameField);
        addNodePanel.add(addNodeButton);
        add(addNodePanel);
        nodeComboBoxModel5 = new DefaultComboBoxModel<>();
        nodeComboBoxModel5.addElement("Seleccionar nodo ");
        jl8 = new JLabel("Lista Jerarquica de Clases: ");jl8.setBounds(20, 210, 180, 20);
        nodeComboBox5 = new JComboBox<>();nodeComboBox5.setBounds(200, 210, 170, 20);
        showJLC = new JButton("Obtener LJC");showJLC.setBounds(410, 210, 120, 20);
        JLCArea = new JTextArea("Lista Jerarquica de Clases: ");
        AnzuelosArea = new JTextArea("Anzuelos: ");
        ParejasArea = new JTextArea("Parejas: ");
        JScrollPane scrollPane4 = new JScrollPane(JLCArea);scrollPane4.setBounds(20, 240, 170, 180);/////////
        JScrollPane scrollPane5 = new JScrollPane(AnzuelosArea);scrollPane5.setBounds(200, 240, 170, 180);/////////
        JScrollPane scrollPane6 = new JScrollPane(ParejasArea);scrollPane6.setBounds(380, 240, 170, 180);/////////
        JLCArea.setEditable(false);
        AnzuelosArea.setEditable(false);
        ParejasArea.setEditable(false);
        nodeComboBox5.setModel(nodeComboBoxModel5);
        add(jl8);
        add(showJLC);
        add(scrollPane4);
        add(scrollPane5);
        add(scrollPane6);
        add(nodeComboBox5);
        
//        //AGREGAR RELACIONES PANEL
//        addRelationPanel.add(new JLabel("Nodo 1:"));
//        addRelationPanel.add(new JLabel("Relación:"));
//        addRelationPanel.add(new JLabel("Nodo 2:"));
//        
//        addRelationPanel.add(nodeComboBox1);
//        //addRelationPanel.add(relationshipField);
//        addRelationPanel.add(relationshipField);
//        addRelationPanel.add(nodeComboBox2);
//        addRelationPanel.add(new JLabel());
//        addRelationPanel.add(buttonPanel,BorderLayout.CENTER);
//        //addActivationPanel
//        addActivationPanel.add(new JLabel("Nodo 1:"));
//        addActivationPanel.add(new JLabel("Verificar Activacion:"));
//        addActivationPanel.add(new JLabel("Nodo 2:"));
//        addActivationPanel.add(nodeComboBox3);
//        addActivationPanel.add(ActivationshipTextArea);
//        addActivationPanel.add(nodeComboBox4);
//        addActivationPanel.add(new JLabel());
//        addActivationPanel.add(showActivation);
//        addActivationPanel.add(showGraphButton);
        //addRelationPanel.add(addRelationshipButton,BorderLayout.CENTER);
        // Diseño de la interfaz
//        JPanel mainPanel = new JPanel(new GridLayout(8, 2,50,50));
        //mainPanel.add(new JLabel("Nombre del Nodo:"));
        //mainPanel.add(nodeNameField);
        //mainPanel.add(addNodeButton);
        //mainPanel.add(new JLabel("hola"));
//        mainPanel.add(new JLabel("Nodo 1:"));
//        mainPanel.add(nodeComboBox1);
//        mainPanel.add(new JLabel("Nodo 2:"));
//        mainPanel.add(nodeComboBox2);
        menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("IMPORTAR_EXPORTAR");
        importGraphItem = new JMenuItem("Importar Grafo");
        GuardarGrafo = new JMenuItem("Guardar Grafo");
        fileMenu.add(importGraphItem);
        fileMenu.add(GuardarGrafo);
        menuBar.add(fileMenu);
        
        setJMenuBar(menuBar);
        //mainPanel.add(relationshipField);
        //mainPanel.add(scrollPane, BorderLayout.CENTER);
//        mainPanel.add(nodeComboBox3);mainPanel.add(nodeComboBox4);
//        mainPanel.add(new JLabel("activaciones:"));
//        mainPanel.add(showActivation);
        
//        buttonPanel.add(addRelationshipButton);
        //buttonPanel.add(showGraphButton);
        
        getContentPane().setLayout(null);
        //getContentPane().add(mainPanel, BorderLayout.SOUTH);
//        getContentPane().add(addNodePanel, BorderLayout.NORTH);
//        getContentPane().add(addRelationPanel, BorderLayout.CENTER);
//        
//        getContentPane().add(relationshipTextArea, BorderLayout.EAST);
//        
//        getContentPane().add(addActivationPanel, BorderLayout.SOUTH);
        //getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void eventos(){
        PlainDocument doc = new PlainDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                fb.insertString(offset, text.toUpperCase(), attr); // Convertir a mayúsculas y luego insertar
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                fb.replace(offset, length, text.toUpperCase(), attrs); // Convertir a mayúsculas y luego reemplazar
            }
        });
        nodeNameField.setDocument(doc);
        
        addNodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nodeName = nodeNameField.getText().trim();
                boolean nodoExist = true;
                if(nodeName.isEmpty()){
                   nodeNameField.setText("");
                   nodeNameField.requestFocus();
                   nodeNameField.selectAll();
                   JOptionPane.showMessageDialog(null, "El nombre del nodo ya existe o está vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                   return; 
                }
                for (Nodo nodo : nodos) {
                    if (nodo.getNombre().equals(nodeName)) {
                        nodoExist=false;
                    }                        
                }
                if(nodoExist){ // Agregar el nodo solo si el nombre no está vacío y no existe en el grafo
                    nodeComboBox1.addItem(nodeName);
                    nodeComboBox2.addItem(nodeName);
                    nodeComboBox3.addItem(nodeName);
                    nodeComboBox4.addItem(nodeName);
                    nodeComboBox5.addItem(nodeName);
                    
                    nodos.add(new Nodo(nodeName));
                    
                    nodeNameField.setText(""); // Limpiar el campo de texto
                    nodeNameField.requestFocus();
                    nodeNameField.selectAll();
                } else {
                    JOptionPane.showMessageDialog(null, "El nombre del nodo ya existe o está vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                }
//              graph.addNode(nodeName);  
//                graph.addVertex(nodeName);
            }
        });
        // Lógica para agregar relaciones al hacer clic en el botón
        addRelationshipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String node1 = (String) nodeComboBox1.getSelectedItem();
                String node2 = (String) nodeComboBox2.getSelectedItem();
                String relationship = relationshipField.getText().trim();
                if (node1.equals("Seleccionar nodo origen") || node2.equals("Seleccionar nodo destino")) {
                    JOptionPane.showMessageDialog(null, "Faltan Seleccionar nodos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (nodos.size() < 2) {
                    JOptionPane.showMessageDialog(null, "Debe haber al menos 2 nodos para agregar relaciones.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!node1.equals(node2)) {
                    Nodo nodo_padre = null;
                    Nodo nodo_hijo = null;
                    for (Nodo nodo : nodos) {
                        if (nodo.getNombre().equals(node1)) {
                            nodo_padre = nodo;
                        }
                        if (nodo.getNombre().equals(node2)) {
                            nodo_hijo = nodo;
                        }
                    }
                    List<Relacion> relacionesnodos = nodo_padre.getRelacionesSalientes();
                    for (Relacion relacion_validacion : relacionesnodos) {
                        if(relacion_validacion.getDestino().getNombre().equals(node2)){
                            JOptionPane.showMessageDialog(null, "La relacion ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    nodo_padre.agregarRelacion(nodo_hijo, relationship);
                    relationshipField.setText("");
                    updateRelationshipTextArea(); // Actualizamos el JTextArea
                    updatecombobox();
                    relationshipField.requestFocus();
                    relationshipField.selectAll();
                } else {
                    JOptionPane.showMessageDialog(InterfazUsuario.this, "No se permiten relacionar nodos consigo mismos.");
                }
            }
        });
        
        showGraphButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Graph graph = new SingleGraph("Grafo!");
                System.setProperty("org.graphstream.ui", "swing"); 
                graph.setAttribute("ui.stylesheet", "graph { fill-color: red; }");
                graph.setAttribute("ui.quality");
                for (Nodo nodo : nodos) {
                    //graph.addVertex();
                    String nodeA=nodo.getNombre();
                    Node node1 = graph.addNode(nodeA);
                    node1.setAttribute("ui.label", nodeA);
                    node1.setAttribute("ui.style", "text-alignment: above; text-color: blue; text-size: 20;");
                }
                for (Nodo nodo : nodos) {
                    String  nodeA    =      nodo.getNombre();
                    Node    node1    =      graph.getNode(nodeA);
                    List<Relacion> relacionesnodos = nodo.getRelacionesSalientes();
                    for (Relacion relaciones_nodo : relacionesnodos) {
                        String R_Etiqueta = relaciones_nodo.getNombreRelacion();
                        String nodeB=relaciones_nodo.getDestino().getNombre();
                        Node node2 = graph.getNode(nodeB);
                        Edge edge = graph.addEdge(nodeA + "-" + nodeB, node1, node2,true);
                        edge.setAttribute("ui.label", " "+R_Etiqueta+" ");
                        edge.setAttribute("ui.style", "text-alignment: above; text-size: 15;");
                        graph.getEdge(nodeA+"-"+nodeB).setAttribute("ui.style", "arrow-shape: arrow;");
                    }
                }
                graph.display();
            }
        });
        
        showActivation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String node1 = (String) nodeComboBox3.getSelectedItem();
                String node2 = (String) nodeComboBox4.getSelectedItem();
                
                if (node1.equals("Seleccionar nodo origen") || node2.equals("Seleccionar nodo destino")) {
                    JOptionPane.showMessageDialog(null, "Faltan Seleccionar nodos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (nodos.size() < 2) {
                    JOptionPane.showMessageDialog(null, "Debe haber al menos 2 nodos para Verificar activacion.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!node1.equals(node2)) {
                    updatecombobox();
                    VerificarActivaciones(node1,node2);
                    updateActivacionesTextArea();
                } else {
                    JOptionPane.showMessageDialog(InterfazUsuario.this, "No hay activacion entre el mismo nodo");
                }
            }
        });
        
        GuardarGrafo.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (nodos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Grafo no guardado. no tiene nodos");
                return;
            }
            String fileName = JOptionPane.showInputDialog("Ingrese el nombre del archivo:");
            if (fileName == null || fileName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Grafo no guardado. ");
                return;
            }
            String filePath = "C:\\Users\\andre\\Documents\\NetBeansProjects\\RedesSemanticas\\grafos" + File.separator + fileName + ".ser";
            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
                outputStream.writeObject(nodos);
                System.out.println("ArrayList de nodos guardado en " + filePath);
                JOptionPane.showMessageDialog(null, "Grafo guardado\n Exitosamente!!! ");
            } catch (IOException x) {
                JOptionPane.showMessageDialog(null, "Grafo no guardado. Se perdio la ruta de los grafos");
            }
        }
    });
        
        importGraphItem.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            importGraphFromFile();
        }
    });
        showJLC.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String node1 = (String) nodeComboBox5.getSelectedItem();
            if (node1.equals("Seleccionar nodo ") ) {
                JOptionPane.showMessageDialog(null, "Faltan Seleccionar nodos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            obtenerLJC(node1);
        }
    });
    }
    private void obtenerLJC(String node){
        Nodo LJCnodo = null;
        for (Nodo nodo : nodos) {
            if(nodo.getNombre().equals(node)){
                LJCnodo=nodo;
            }
        }
        String S_Anzuelo="";
        String S_Parejas="";
        String S_LJC="";
        Queue<Queue<Nodo>> anzuelos = LJCnodo.LJCOrdenamientoTopologico();
        System.out.println("Anzuelos: ");
        S_Anzuelo = "Anzuelos: \n";
        for (Queue<Nodo> anzuelo : anzuelos) {
            for (Nodo nodo : anzuelo) {
                S_Anzuelo = S_Anzuelo + nodo.getNombre() + "\n";
                System.out.println(nodo.getNombre());
            }
            S_Anzuelo = S_Anzuelo + "---------\n";
            System.out.println("-----");
        }
        AnzuelosArea.setText(S_Anzuelo);
        AnzuelosArea.requestFocus();
        AnzuelosArea.selectAll();
        List<String> parejas = LJCnodo.construirParejas(anzuelos);
        System.out.println("Parejas: ");
        S_Parejas = "Parejas: \n";
        for (String pareja : parejas) {
            S_Parejas = S_Parejas + pareja + "\n";
            System.out.println(pareja);
        }
        ParejasArea.setText(S_Parejas);
        ParejasArea.requestFocus();
        ParejasArea.selectAll();
        List<String> LJCConParejas = LJCnodo.obtenerLJCConParejas(parejas, anzuelos);
        System.out.println("Lista Jerarquica de Clases: ");
        S_LJC = "Lista Jerarquica de Clases: \n";
        for (String nodo : LJCConParejas) {
            System.out.println(nodo);
            S_LJC = S_LJC + nodo + "\n";
        }
        JLCArea.setText(S_LJC);
        JLCArea.requestFocus();
        JLCArea.selectAll();
       
    }
    private void importGraphFromFile() {
        nodeComboBoxModel1.removeAllElements();
        nodeComboBoxModel2.removeAllElements();
        nodeComboBoxModel3.removeAllElements();
        nodeComboBoxModel4.removeAllElements();
        nodeComboBoxModel5.removeAllElements();
        nodeComboBoxModel1.addElement("Seleccionar nodo origen");
        nodeComboBoxModel2.addElement("Seleccionar nodo destino");
        nodeComboBoxModel3.addElement("Seleccionar nodo origen");
        nodeComboBoxModel4.addElement("Seleccionar nodo destino");
        nodeComboBoxModel5.addElement("Seleccionar nodo ");
        JFileChooser fileChooser = new JFileChooser();
        String initialFolderPath = "C:\\Users\\andre\\Documents\\NetBeansProjects\\RedesSemanticas\\grafos";
        File initialDirectory = new File(initialFolderPath);
        if (initialDirectory.isDirectory()) {
            fileChooser.setCurrentDirectory(initialDirectory);
        }
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
                nodos = (ArrayList<Nodo>) inputStream.readObject();
                JOptionPane.showMessageDialog(null, "Grafo Recuperado\n Exitosamente!!! ");
                for (Nodo nodo : nodos) {
                    nodeComboBox1.addItem(nodo.getNombre());
                    nodeComboBox2.addItem(nodo.getNombre());
                    nodeComboBox3.addItem(nodo.getNombre());
                    nodeComboBox4.addItem(nodo.getNombre());
                    nodeComboBox5.addItem(nodo.getNombre());
                }
                updateRelationshipTextArea(); // Actualizamos el JTextArea
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    private void updateRelationshipTextArea() {
        // Genera y actualiza el contenido del JTextArea con las relaciones entre nodos
        StringBuilder relationships = new StringBuilder();
        for (Nodo nodo : nodos) {
            List<Relacion> relacionesnodos = nodo.getRelacionesSalientes();
            for (Relacion relaciones_nodo : relacionesnodos) {
                String nodo_hijo = relaciones_nodo.getDestino().getNombre();
                String R_Etiqueta = relaciones_nodo.getNombreRelacion();
                if(!R_Etiqueta.equals("")){
                    relationships.append(nodo.getNombre()).append( "  " + R_Etiqueta+ "  " ).append(nodo_hijo).append("\n");
                }else{
                    relationships.append(nodo.getNombre()).append( " a " ).append(nodo_hijo).append("\n");
                }
            }
        }
        relationshipTextArea.setText(relationships.toString());
    }
    private void updatecombobox(){
        // Crear modelos para los JComboBox con elementos predeterminados
        nodeComboBox1.setSelectedIndex(0);
        nodeComboBox2.setSelectedIndex(0);
        nodeComboBox3.setSelectedIndex(0);
        nodeComboBox4.setSelectedIndex(0);
        nodeComboBox5.setSelectedIndex(0);
    }
    private void VerificarActivaciones(String node1, String node2){
        Grafo grafo = new Grafo();
        
        List<Nodo> nodosPadrenode1 = buscarPadres(node1);
        List<Nodo> nodosPadrenode2 = buscarPadres(node2);
        String nodea=" ";
        String nodeb=" ";
        nodea="Activaciones de: " + node1 + " a " + node2 + "\n";
        if(nodosPadrenode1.isEmpty() || nodosPadrenode2.isEmpty()){
            ActivationshipTextArea.setText("No Existen Activaciones");
            return;
        }
            //nodea=nodea+" "+nodosPadrenode1.get(0).getNombre();
            //nodeb=nodeb+" "+nodosPadrenode2.get(0).getNombre();
        if(nodosPadrenode1.size()>1){
            for (Nodo nodosActivacion : nodosPadrenode1) {
                List<String> caminosA = grafo.todosLosCaminosConEtiquetas(nodosActivacion, nodosPadrenode2.get(0));
                List<String> caminosB = grafo.todosLosCaminosConEtiquetas(nodosPadrenode2.get(0),nodosActivacion);
                for (String camino : caminosA) {
                    int indice = camino.indexOf(node1);
                    if(indice != -1){
                        continue;
                    }
                    nodea=nodea+ camino + "\n";
                }
                for (String camino : caminosB) {
                    int indice = camino.indexOf(node1);
                    if(indice != -1){
                        continue;
                    }
                    nodea=nodea+ camino + "\n";
                }
            }
        }
        if(nodosPadrenode2.size()>1){
            for (Nodo nodosActivacion : nodosPadrenode2) {
                List<String> caminosA = grafo.todosLosCaminosConEtiquetas(nodosActivacion, nodosPadrenode1.get(0));
                List<String> caminosB = grafo.todosLosCaminosConEtiquetas(nodosPadrenode1.get(0),nodosActivacion);
                for (String camino : caminosA) {
                    int indice = camino.indexOf(node1);
                    if(indice != -1){
                        continue;
                    }
                    nodea=nodea+ camino + "\n";
                }
                for (String camino : caminosB) {
                    int indice = camino.indexOf(node1);
                    if(indice != -1){
                        continue;
                    }
                    nodea=nodea+ camino + "\n";
                }
            }  
        }
        if(nodosPadrenode2.size()== 1 && nodosPadrenode1.size()== 1){
            List<String> caminosA = grafo.todosLosCaminosConEtiquetas(nodosPadrenode1.get(0), nodosPadrenode2.get(0));
            List<String> caminosB = grafo.todosLosCaminosConEtiquetas(nodosPadrenode2.get(0), nodosPadrenode1.get(0));
            for (String camino : caminosA) {
                int indice = camino.indexOf(node1);
                    if(indice != -1){
                        continue;
                    }
                nodea=nodea+ camino + "\n";
            }
            for (String camino : caminosB) {
                int indice = camino.indexOf(node1);
                    if(indice != -1){
                        continue;
                    }
                nodea=nodea+ camino + "\n";
            }
        }
        
        
//        List<Nodo> nodosactivacionA = BuscarCamino(nodosPadrenode1.get(0), nodosPadrenode2.get(0));
//        List<Nodo> nodosactivacionB = BuscarCamino(nodosPadrenode2.get(0), nodosPadrenode1.get(0));
//        System.out.println("sizeA "+nodosactivacionA.size());
//        System.out.println("sizeB "+nodosactivacionB.size());
//        
//        for (Nodo nodosActivacion : nodosactivacionA) {
//
//            nodea=nodea+" "+nodosActivacion.getNombre();
//        }
//        for (Nodo nodosActivacion : nodosactivacionB) {
//            nodeb=nodeb+" "+nodosActivacion.getNombre();
//        }
        //Collections.reverse(nodosactivacionA);
        
        System.out.println("nodea "+nodea);   
        System.out.println("nodeb "+nodeb);
        
    
        
        
//        if(nodosactivacionA.isEmpty() || nodosactivacionB.isEmpty()){
//            ActivationshipTextArea.setText("No Existen Activaciones");
//        }else{
//            List<Nodo> nodosFinales = new ArrayList<>();
//            if(nodosactivacionB.size()>nodosactivacionA.size()){
//                //agregando nodos finales de los padres nodo a
//                nodosFinales.add(nodosPadrenode1.get(0));
//                for (Nodo nodosActivacion : nodosactivacionB) {//e-g-b-f e-g
//                    //f-b-g-e g-e
//                    if(nodosActivacion.getNombre().equals(nodosactivacionA.get(0).getNombre())){
//                        nodosFinales.add(nodosActivacion);
//                        break;
//                    }
//                    nodosFinales.add(nodosActivacion);
//                }// a b c g d e = a - e = b c g d = b c g = g c b
//                Collections.reverse(nodosFinales);
//                //nodosFinales.add(nodosPadrenode2.get(0));
//                nodea="Activacion de: " + node1 + " a " + node2 + "\n"
//                        + nodosFinales.get(0).getNombre();
//                
//                for (Nodo nodosActivacion : nodosFinales) {
//                    for (Relacion relacion : nodosActivacion.getRelacionesSalientes()) {
//                        for (Nodo nodosPrueba : nodosFinales) {
//                            if (relacion.getDestino().getNombre().equals(nodosPrueba.getNombre())) {
//                                nodea = nodea + " - " + relacion.getNombreRelacion() + " - " + nodosPrueba.getNombre();
//                            } 
//                        }
//                    }
//                }
//            
//            }else{
//                nodosFinales.add(nodosPadrenode2.get(0));
//                for (Nodo nodosActivacion : nodosactivacionA) {//e-g-b-f e-g
//                    //f-b-g-e g-e
//                    // e d g c b a = e - a = d g c b = g c = d g c = b c g d
//                    // e d g c b a = d - a = g c b a = g c = d g c = b c g d
//                    // d - h = g b f = g - h =
//                    if(nodosActivacion.getNombre().equals(nodosactivacionB.get(0).getNombre())){
//                        nodosFinales.add(nodosActivacion);
//                        break;
//                    }
//                    nodosFinales.add(nodosActivacion);
//                }
//                Collections.reverse(nodosFinales);
//               // nodosFinales.add(nodosPadrenode1.get(0));
//                nodea="Activacion de: " + node1 + " a " + node2 + "\n"
//                        + nodosFinales.get(0).getNombre();
//                
//                for (Nodo nodosActivacion : nodosFinales) {
//                    for (Relacion relacion : nodosActivacion.getRelacionesSalientes()) {
//                        for (Nodo nodosPrueba : nodosFinales) {
//                            if (relacion.getDestino().getNombre().equals(nodosPrueba.getNombre())) {
//                                nodea = nodea + " - " + relacion.getNombreRelacion() + " - " + nodosPrueba.getNombre();
//                            } 
//                        }
//                    }
//                }
//            }
            ActivationshipTextArea.setText(nodea);
            System.out.println("nodea activacion "+nodea); 
            System.out.println("puede que si haya activacion");
//        }
 
    }
    private List<Nodo> BuscarCamino(Nodo node1, Nodo node2){// f a g
        //List<Nodo> nodosPadre1 = new ArrayList<>();
        System.out.println(" de " + node1.getNombre() + " a " + node2.getNombre());
        List<Nodo> nodosActivacion = new ArrayList<>();
        nodosActivacion.add(node1);
        //g b f
        for (Relacion relacion : node1.getRelacionesSalientes()) {
            System.out.println("nombre " + relacion.getDestino().getNombre() + " = " + node2.getNombre());
            if (relacion.getDestino().getNombre() == node2.getNombre()) {
                 nodosActivacion.add(node2);
                 System.out.println("size de activaicon " + nodosActivacion.size());
                 return nodosActivacion;
            }
        }
        if (node1.getRelacionesSalientes().size()==1) {
            nodosActivacion.addAll(BuscarCamino(node1.getRelacionesSalientes().get(0).getDestino(), node2));
        }
        int contador = 0;
        for (Relacion relacion : node1.getRelacionesSalientes()) {
            if (relacion.getDestino().getNombre() == node2.getNombre()) {
                 nodosActivacion.add(node2);
                 System.out.println("size de activaicon " + nodosActivacion.size());
                 return nodosActivacion;
            }else{
                nodosActivacion.addAll(BuscarCamino(relacion.getDestino(), node2));
            }
            
        }
        return nodosActivacion;
    }
    private List<Nodo> buscarPadres(String node1){
        List<Nodo> nodosPadre1 = new ArrayList<>();
        //List<Nodo> nodosPadre2 = new ArrayList<>();
        for (Nodo nodo : nodos) {
            for (Relacion relacion : nodo.getRelacionesSalientes()) {
                
                if (relacion.getDestino().getNombre().equals(node1)) {
                    nodosPadre1.add(nodo);
                }
                
            }
            
        }
        return nodosPadre1;
    }
    private List<Nodo> RecursivoPadres(String node1,String node2){
            List<Nodo> nodosPadre1 = buscarPadres(node1);
            System.out.println("padres de  " + node1 + " + " + node2 + " hay: " + nodosPadre1.size());
            
            List<Nodo> nodosActivacion = new ArrayList<>();
            if(!nodosPadre1.isEmpty()){
                for (Relacion relacion : nodosPadre1.get(0).getRelacionesSalientes()) {
                    if(relacion.getDestino().getNombre().equals(node2)){
                        nodosActivacion.add(nodosPadre1.get(0));
                        System.out.println("entro nodos padre hijo2 " + relacion.getDestino().getNombre() + " = " + node1 + " + " + node2);
                        return nodosActivacion;

                    }
                    if(!relacion.getDestino().getRelacionesSalientes().isEmpty()){
                        for (Relacion relacio : relacion.getDestino().getRelacionesSalientes()) {
                            if(relacio.getDestino().getNombre().equals(node2)){
                                nodosActivacion.add(nodosPadre1.get(0));
                                nodosActivacion.add(relacion.getDestino());
                                System.out.println("entro nodos padre hijo2 " + relacion.getDestino().getNombre() + " y " +relacio.getDestino().getNombre() + " = " + node1 + " + " + node2);
                                return nodosActivacion;
                            }//10mil, lugar geografico
                        }
                    }
                }
            }
        for (Nodo nodoP : nodosPadre1) {
            System.out.println("padres: de " + node1 + " ,es " + nodoP.getNombre());
            nodosActivacion.add(nodoP);
            if (nodoP.getNombre().equals(node2)) {
                
                return nodosActivacion;
            }else{
                nodosActivacion.addAll(RecursivoPadres(nodoP.getNombre(),node2));
            }
        }
        return nodosActivacion;
    }
    private void updateActivacionesTextArea(){
        
    }
}