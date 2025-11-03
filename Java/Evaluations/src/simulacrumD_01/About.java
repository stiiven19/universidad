package simulacrumD_01;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.TextArea;
import java.awt.Panel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Color;

public class About extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		setTitle("About");
		setClosable(true);
		setBounds(100, 100, 406, 280);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		Panel panel = new Panel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("General Info", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblUniversidadDeNario = new JLabel("Universidad de Nariño");
		lblUniversidadDeNario.setBounds(109, 24, 181, 17);
		panel.add(lblUniversidadDeNario);
		
		JLabel lblFacultadDeIngenieria = new JLabel("Facultad de Ingenieria");
		lblFacultadDeIngenieria.setBounds(109, 53, 218, 17);
		panel.add(lblFacultadDeIngenieria);
		
		JLabel lblDepartamentoDeSistemas = new JLabel("Departamento de Sistemas ");
		lblDepartamentoDeSistemas.setBounds(98, 83, 181, 17);
		panel.add(lblDepartamentoDeSistemas);
		
		JLabel lblProgramaDeIngenieria = new JLabel("Programa de Ingenieria de Sistemas");
		lblProgramaDeIngenieria.setBounds(76, 112, 251, 17);
		panel.add(lblProgramaDeIngenieria);
		
		JLabel lblProgramacionIii = new JLabel("Programacion III");
		lblProgramacionIii.setBounds(129, 157, 150, 17);
		panel.add(lblProgramacionIii);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Detalled Info", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblDeiwerHernanChaleal = new JLabel("Deiwer Hernan Chaleal Perez");
		lblDeiwerHernanChaleal.setBounds(91, 37, 204, 17);
		panel_1.add(lblDeiwerHernanChaleal);
		
		JLabel label = new JLabel("218034074");
		label.setBounds(135, 80, 105, 17);
		panel_1.add(label);

	}
}
