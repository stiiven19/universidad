package ex02_registerform;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegisterForm extends JFrame{
//_-------------------------------------------------------------------------------------
	private JLabel				 lb_1, lb_2, lb_3, lb_4, lb_5;	
	private JTextField			 txf_01, txf_02, txf_03, txf_04;
	private JButton 			 bt_01, bt_02;
	private JComboBox 			 box;
	
	public RegisterForm() {
		setSize(300, 300);
		setTitle(" Register Form");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setupWidgets();
		setVisible(true);
		
	}

	private void setupWidgets() {
		
		lb_1	= new JLabel("Identification",SwingConstants.CENTER);
		lb_2 	= new JLabel("Name",SwingConstants.CENTER);
		lb_3 	= new JLabel("Gender",SwingConstants.CENTER);
		lb_4 	= new JLabel("Address",SwingConstants.CENTER);
		lb_5 	= new JLabel("Phone",SwingConstants.CENTER);
		
		txf_01 	= new JTextField();
		txf_02 	= new JTextField();
		txf_03 	= new JTextField();
		txf_04 	= new JTextField();
		
		bt_01 	= new JButton("Save");
		bt_02 	= new JButton("Cancel");
		
		box 	= new JComboBox();
		box.addItem("Male");
		box.addItem("Female");
		
		setLayout(new GridLayout(6,2));
		
		add(lb_1);  add(txf_01);
		add(lb_2);  add(txf_02);
		add(lb_3);  add(box);
		add(lb_4);  add(txf_03);
		add(lb_5);  add(txf_04);
		add(bt_01); add(bt_02);
		
		
	}
}
