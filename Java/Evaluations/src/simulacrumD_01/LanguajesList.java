package simulacrumD_01;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LanguajesList extends JInternalFrame {
	private JTable table;
	private	DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LanguajesList frame = new LanguajesList();
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
	public LanguajesList() {
		setClosable(true);
		setTitle("Languajes List");
		setBounds(100, 100, 432, 454);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 421, 424);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBounds(12, 12, 403, 242);
		table.setModel(tableModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Language", "Speakers(M)", "Porcentage of world",
				}
			));
			
			
			scrollPane.setViewportView(table);

			loadData();
		}


	private void loadData() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("data/languages.csv"));
			String line = reader.readLine();
			while (line != null) {
				String[] values = line.split(",");
				tableModel.addRow(values);
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
		} catch (IOException ex) {
		}
	}
}
