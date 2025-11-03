package Hw02_statistics;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StatisticsView extends JFrame{

	JLabel				lbCity,lbPopulation;
	JTextField			tfCity,tfPopulation;
	JButton				btAdd;
	GraphStatistics		graph;
	JTable				tb_table;
	DefaultTableModel	tm_table;
	ArrayList<Long>  	arpopulation;
	
	public StatisticsView() {
		setTitle("Statistics");
		setSize(600, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}

	private void setupWidgets() {
		
		lbCity			= new JLabel("City");
		lbPopulation	= new JLabel("Population");
		tfCity			= new JTextField();
		tfPopulation	= new JTextField();
		btAdd			= new JButton("Add");
		graph			= new GraphStatistics();
		arpopulation	= new ArrayList<Long>();
		tm_table		= new DefaultTableModel(new Object[]{
															"Index",
															"City",
															"Population"
															}, 0);
		
		tb_table		= new JTable(tm_table);
		
		JPanel	pnNorth	= new JPanel(new GridLayout(5,1));
		JPanel	pnCenter= new JPanel(new GridLayout(1,2));
		
		pnNorth.add(lbCity);
		pnNorth.add(tfCity);
		pnNorth.add(lbPopulation);
		pnNorth.add(tfPopulation);
		pnNorth.add(btAdd);
		
		pnCenter.add(new JScrollPane(tb_table));
		pnCenter.add(graph);
		
		add(pnNorth,BorderLayout.NORTH);
		add(pnCenter);
	}

	private void setupEvents() {
		
		btAdd.addActionListener(new ActionListener() {
			int i=1;
			@Override
			public void actionPerformed(ActionEvent e) {
				String city 		= tfCity.getText();
				String population 	= tfPopulation.getText();
						
				if (city.isEmpty() || population.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter text in City or Population","ERROR",JOptionPane.ERROR_MESSAGE);
				}else {
					long band=1;
					boolean bander=false;
					try {
						band = Long.parseLong(tfPopulation.getText());
						bander=true;
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Enter numbers in population","ERROR",JOptionPane.ERROR_MESSAGE);
						tfPopulation.setText("");
					}
					
					if (bander) {
						if (i!=12) {
							Object[] row_info = {i,
									tfCity.getText(),
									tfPopulation.getText()};
							tm_table.addRow(row_info);
							
							arpopulation.clear();
							for (int i = 0; i < tm_table.getRowCount(); i++) {
								arpopulation.add(Long.parseLong((String)tm_table.getValueAt(i, 2)));
							}
							
							for (int j = 0 ; j <arpopulation.size() ; j++) {
								graph.setCity(j,arpopulation);
								graph.paint(graph.getGraphics());
								//graph.repaint();
							}
							i+=1;
							tfCity.			setText("");
							tfPopulation.	setText("");
							tfCity.requestFocus();
									
						}else {
							JOptionPane.showMessageDialog(null, "Max 11 Cities","ERROR",JOptionPane.ERROR_MESSAGE);	
						}
						
					}
					
				}
				
			}
		});
		
	}
	public static void main(String[] args) {
		new StatisticsView();
	}
}
