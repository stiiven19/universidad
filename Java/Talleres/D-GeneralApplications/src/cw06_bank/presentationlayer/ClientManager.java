package cw06_bank.presentationlayer;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cw06_bank.datalayer.Client;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientManager extends JInternalFrame {

	private JTextField textFieldId;
	private JTextField textFieldName;

	private Bank bank;

	/**
	 * Create the frame.
	 */
	public ClientManager(Bank bank) {
		setClosable(true);
		this.bank = bank;
		setVisible(true);
		setTitle("Client Manager");
		setBounds(100, 100, 439, 141);
		getContentPane().setLayout(null);

		JLabel lblIdentification = new JLabel("Identification");
		lblIdentification.setBounds(34, 12, 118, 15);
		getContentPane().add(lblIdentification);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(34, 39, 66, 15);
		getContentPane().add(lblName);

		textFieldId = new JTextField();
		textFieldId.setBounds(160, 10, 124, 19);
		getContentPane().add(textFieldId);
		textFieldId.setColumns(10);

		textFieldName = new JTextField();
		textFieldName.setBounds(160, 39, 241, 19);
		getContentPane().add(textFieldName);
		textFieldName.setColumns(10);

		JButton btnAddClient = new JButton("Add Client");
		
		btnAddClient.setBounds(34, 70, 174, 25);
		getContentPane().add(btnAddClient);

		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBounds(243, 70, 158, 25);
		getContentPane().add(btnNewButton);
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					bank.clients.add(new Client(Long.parseLong(textFieldId.getText()), textFieldName.getText()));
					dispose();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error \nDocumento no valido");
					System.err.println("Error \nDocumento no valido");
					textFieldId.setText("");
					textFieldId.isFocusable();
				}
				
				
			}
		});

	}
}
