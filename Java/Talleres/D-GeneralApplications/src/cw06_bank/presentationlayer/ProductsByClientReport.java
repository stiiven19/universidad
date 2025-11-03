package cw06_bank.presentationlayer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import cw06_bank.datalayer.Client;
import cw06_bank.datalayer.Product;

public class ProductsByClientReport extends JInternalFrame {
	private Bank bank;
	private Client currentClient;
	private JTable tableClients;
	private JTable tableProduct;
	private JScrollPane scrollPane;

	
	/**
	 * Create the frame.
	 */
	public ProductsByClientReport(Bank bank) {
		

		setClosable(true);
		setVisible(true);
		this.bank = bank;

		setTitle("Product by Client");
		setBounds(100, 100, 335, 374);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 11, 299, 184);
		getContentPane().add(scrollPane);
		
		tableClients = new JTable();
		scrollPane.setViewportView(tableClients);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 206, 299, 127);
		getContentPane().add(scrollPane_1);
		
		tableProduct = new JTable();
		scrollPane_1.setViewportView(tableProduct);
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameActivated(InternalFrameEvent arg0) {
				tableClients.setModel(new TableModel() {
					
					@Override
					public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void removeTableModelListener(TableModelListener l) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public boolean isCellEditable(int rowIndex, int columnIndex) {
						// TODO Auto-generated method stub
						return false;
					}
					
					@Override
					public Object getValueAt(int row, int col) {
						// TODO Auto-generated method stub
						switch (col) {
						case 0:return bank.clients.get(row).getId(); 
						case 1:return bank.clients.get(row).getName();
						
						}
						return null;
					}
					
					@Override
					public int getRowCount() {
						// TODO Auto-generated method stub
						return bank.clients.size();
					}
					
					@Override
					public String getColumnName(int columnIndex) {
						switch (columnIndex) {
						case 0:return "Identification";
						case 1:return "Name";	

						}
						return null;
					}
					
					@Override
					public int getColumnCount() {
						return 2;
					}
					
					@Override
					public Class<?> getColumnClass(int columnIndex) {
						// TODO Auto-generated method stub
						return String.class;
					}
					
					@Override
					public void addTableModelListener(TableModelListener l) {
						// TODO Auto-generated method stub
						currentClient =bank.clients.get(tableClients.getSelectedRow());
						tableProduct.setModel(new TableModel() {
							
							@Override
							public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void removeTableModelListener(TableModelListener l) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public boolean isCellEditable(int rowIndex, int columnIndex) {
								// TODO Auto-generated method stub
								return false;
							}
							
							@Override
							public Object getValueAt(int row, int col) {
								switch (col) {
								case 0: return currentClient.getProducts().get(row).getNumber();
								case 1: return currentClient.getProducts().get(row).getDate();
								case 2: return currentClient.getProducts().get(row).isState()? "Active" : "Inactive";

								}
								return null;
								
							}
							
							@Override
							public int getRowCount() {
								// TODO Auto-generated method stub
								return bank.clients.size();
							}
							
							@Override
							public String getColumnName(int col) {
								// TODO Auto-generated method stub
								switch (col) {
								case 0:return "Number";
								case 1:return "Star Date";
								case 2:return "State";
									

								}
								return null;
							}
							
							@Override
							public int getColumnCount() {
								// TODO Auto-generated method stub
								return 3;
							}
							
							@Override
							public Class<?> getColumnClass(int col) {
								// TODO Auto-generated method stub
								return String.class;
							}
							
							@Override
							public void addTableModelListener(TableModelListener l) {
								// TODO Auto-generated method stub
								
							}
						});
					}
				});
			}
		});
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
		});
	}
}
