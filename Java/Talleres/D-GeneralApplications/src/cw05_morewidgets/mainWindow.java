package cw05_morewidgets;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.JTabbedPane;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;

public class mainWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow frame = new mainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane);
		
		JTree tree = new JTree();
		
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Universidad de Narino") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					node_1 = new DefaultMutableTreeNode("V.Academica");
						node_2 = new DefaultMutableTreeNode("Facultad de Ingenieria");
							node_2.add(new DefaultMutableTreeNode("Ing de Sistemas"));
							node_2.add(new DefaultMutableTreeNode("Ing. Electronica"));
						node_1.add(node_2);
						node_1.add(new DefaultMutableTreeNode("Facultad de Education"));
						node_1.add(new DefaultMutableTreeNode("Facultad de Economia"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("V.Administrativa");
						node_1.add(new DefaultMutableTreeNode("Centro de Informatica"));
						node_1.add(new DefaultMutableTreeNode("Aula de Informatica"));
						node_1.add(new DefaultMutableTreeNode("Tesoreria"));
						node_1.add(new DefaultMutableTreeNode("Almacen"));
					add(node_1);
					add(new DefaultMutableTreeNode("V.de Investigaciones"));
				}
			}
		));
		splitPane.setLeftComponent(tree);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		splitPane.setRightComponent(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Information General", null, panel, null);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\usm\\eclipse-workspace\\D-GeneralApplications\\Images\\shield.jpg"));
		label.setBounds(10, 11, 156, 157);
		panel.add(label);
		
		JTextArea txtrLaUniversidadDe = new JTextArea();
		txtrLaUniversidadDe.setText("La Universidad de Nari\u00F1o es una \r\ninstituci\u00F3n universitaria, aut\u00F3noma de \r\ncar\u00E1cter oficial con gobierno, \r\npatrimonio y rentas propias y con \r\ncapacidad para organizarse, \r\ngobernarse, designar sus propias \r\nautoridades y para dictar normas \r\ny reglamentos de conformidad con la \r\nLey.");
		txtrLaUniversidadDe.setBounds(176, 11, 322, 334);
		panel.add(txtrLaUniversidadDe);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Personal", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 28, 471, 361);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, ""},
				{"", null},
			},
			new String[] {
				"Nombre", "Cargo"
			}
		));
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				
				String path=tree.getLastSelectedPathComponent().toString();
				
				switch (path) {
				case "V.Academica":
					txtrLaUniversidadDe.setText("La Vicerrectoría Académica es la unidad responsable de los programas de estudio que establezca la Universidad de Nariño, para cuyo efecto coordinará acciones con las Facultades, Departamentos, Programas, Laboratorios, Granjas, Liceo de Bachillerato, Biblioteca, Editorial Universitaria, OCARA, Unidad de T.V");
					break;
				case "V.Administrativa":
					txtrLaUniversidadDe.setText("1");
				case "V.de Investigaciones":
					
					break;
				case "Universidad de Narino":
					txtrLaUniversidadDe.setText("La Universidad de Nari\u00F1o es una \r\ninstituci\u00F3n universitaria, aut\u00F3noma de \r\ncar\u00E1cter oficial con gobierno, \r\npatrimonio y rentas propias y con \r\ncapacidad para organizarse, \r\ngobernarse, designar sus propias \r\nautoridades y para dictar normas \r\ny reglamentos de conformidad con la \r\nLey.");
					break;
				default:
					break;
				}
				
				
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(125);
		table.getColumnModel().getColumn(0).setMinWidth(125);
		scrollPane.setViewportView(table);
	}
}
