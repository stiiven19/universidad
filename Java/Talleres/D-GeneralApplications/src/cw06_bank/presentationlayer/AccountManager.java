package cw06_bank.presentationlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import cw06_bank.datalayer.Account;
import cw06_bank.datalayer.Client;

public class AccountManager extends JInternalFrame {
	private JComboBox comboBox;

	private Bank bank;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the frame.
	 */
	public AccountManager(Bank bank) {
		
		this.bank = bank;
		setClosable(true);
		setVisible(true);
		setTitle("Account Manager");
		setBounds(100, 100, 393, 269);
		getContentPane().setLayout(null);
		
		JLabel lblClient = new JLabel("Client");
		lblClient.setBounds(10, 26, 46, 14);
		getContentPane().add(lblClient);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setBounds(10, 57, 46, 14);
		getContentPane().add(lblNumber);
		
		JLabel lblStardDate = new JLabel("Stard Date");
		lblStardDate.setBounds(10, 97, 64, 14);
		getContentPane().add(lblStardDate);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(10, 131, 46, 14);
		getContentPane().add(lblType);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(148, 23, 219, 20);
		getContentPane().add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(148, 54, 120, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(148, 94, 120, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Saving", "Checking"}));
		comboBox_2.setBounds(148, 128, 120, 20);
		getContentPane().add(comboBox_2);
		
		JButton btnAddAcount = new JButton("Add Acount");
		
		btnAddAcount.setBounds(10, 205, 168, 23);
		getContentPane().add(btnAddAcount);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(199, 205, 168, 23);
		getContentPane().add(btnCancel);
		
		JLabel lblInitialBalance = new JLabel("Initial Balance");
		lblInitialBalance.setBounds(10, 165, 94, 14);
		getContentPane().add(lblInitialBalance);
		
		textField_2 = new JTextField();
		textField_2.setBounds(148, 159, 158, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameActivated(InternalFrameEvent arg0) {
				comboBox_1.removeAllItems();
				for (Client client:bank.clients) {
					((DefaultComboBoxModel<Client>)comboBox_1.getModel()).addElement(client);
				}
			}
		});
		btnAddAcount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Client client =(Client)comboBox_1.getSelectedItem();
				client.addProduct(new Account(Long.parseLong(textField.getText()), textField_1.getText(), true, ((String)comboBox_2.getSelectedItem()).charAt(0), Long.parseLong(textField_2.getText() )));
				dispose();
			}
		});
	}
}
