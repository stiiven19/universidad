package cw03_Windowbuilder;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ArticleManager extends JInternalFrame {
	private JTextField tf_code;
	private JTextField tf_name;
	private JTextField tf_price;
	private JTextField tf_stock;


	/**
	 * Create the frame.
	 */
	public ArticleManager() {
		setTitle("Article Manager");
		setClosable(true);
		setBounds(100, 100, 286, 277);
		getContentPane().setLayout(null);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(12, 26, 60, 17);
		getContentPane().add(lblCode);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(12, 66, 60, 17);
		getContentPane().add(lblName);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(12, 114, 60, 17);
		getContentPane().add(lblPrice);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(12, 156, 60, 17);
		getContentPane().add(lblStock);
		
		tf_code = new JTextField();
		tf_code.setBounds(90, 24, 114, 21);
		getContentPane().add(tf_code);
		tf_code.setColumns(10);
		
		tf_name = new JTextField();
		tf_name.setBounds(90, 64, 114, 21);
		getContentPane().add(tf_name);
		tf_name.setColumns(10);
		
		tf_price = new JTextField();
		tf_price.setBounds(90, 112, 114, 21);
		getContentPane().add(tf_price);
		tf_price.setColumns(10);
		
		tf_stock = new JTextField();
		tf_stock.setBounds(90, 154, 114, 21);
		getContentPane().add(tf_stock);
		tf_stock.setColumns(10);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setBounds(10, 208, 105, 27);
		getContentPane().add(btnAccept);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(127, 208, 105, 27);
		getContentPane().add(btnCancel);

		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		btnAccept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (tf_code.getText().equals("")||tf_name.getText().equals("")||tf_price.getText().equals("")||tf_stock.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Error.	Fields empty");
					return;
				}
				
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(new File("data/stock.csv"),true));
					writer.write(	tf_code.getText()+ ", " +
									tf_name.getText()+ ", " +
									tf_price.getText()+ ", " +
									tf_stock.getText()+ "\n");
					
					writer.close();
					tf_code.setText("");
					tf_name.setText("");
					tf_price.setText("");
					tf_stock.setText("");
					
					tf_code.requestFocus();
					
				} catch (IOException e1) {
					
				}				
			}
			
			
		});
		
	}
}
