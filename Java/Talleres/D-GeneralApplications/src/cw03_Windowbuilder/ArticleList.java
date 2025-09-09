package cw03_Windowbuilder;

import java.awt.BorderLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ArticleList extends JInternalFrame {
	private JTable table;
	private	DefaultTableModel	tableModel;

	
	
	/**
	 * Create the frame.
	 */
	public ArticleList() {
		setClosable(true);
		setResizable(true);
		setTitle("Article List");
		setBounds(100, 100, 317, 224);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(10, 171, 130, 23);
		
		
		
		getContentPane().setLayout(null);
		
		getContentPane().add(btnRefresh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 301, 171);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(tableModel = new DefaultTableModel(
			new Object[][] {
	
				
			},
			new String[] {
				"Code ", "Name", "Price", "Stock"
			}
		));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(62);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(93);
		scrollPane.setViewportView(table);
		
		JButton bt_delete = new JButton("Delete");
		bt_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowcont=table.getRowCount();
				
					tableModel.removeRow(rowcont-1);
				
			}
		});
		bt_delete.setBounds(165, 171, 126, 23);
		getContentPane().add(bt_delete);
		loadData();
     
     btnRefresh.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int rowcont=table.getRowCount();
			for (int i = 0; i < rowcont; i++) {
				tableModel.removeRow(0);
			}
			loadData();
		}
	});
	}
	
	private void loadData() {
		try {
			BufferedReader reader=new BufferedReader(new FileReader("data/stock.csv"));
			
			String line =reader.readLine();
			while(line!=null) {
				String[] values=line.split(",");
				tableModel.addRow(values);
				line=reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException eo) {
		} catch (IOException eo) {
		}
	}
}
