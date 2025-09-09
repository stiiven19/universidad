package ex03_login;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginForm extends JFrame{
	
	JLabel				lb_01, lb_02;
	JTextField			tx;
	JPasswordField		pass;
	JButton				cancel, verify;
	
	public LoginForm() {
		setTitle("User Validation");
		setSize(320, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setupWidgets();
		setVisible(true);
		
	}

	private void setupWidgets() {
		// ----------------------------------------------------------
		
		lb_01	= new JLabel("User Name");
		lb_02	= new JLabel("Password");
		
		tx		= new JTextField();		
		
		pass	= new JPasswordField();
		
		cancel	= new JButton("Cancel");
		verify	= new JButton("Verify");
		
		setLayout(null);
		
		lb_01.setBounds(20, 20, 80, 20); lb_02.setBounds(20, 45, 80, 20);
		tx.setBounds(100, 20, 180, 20);  pass.setBounds(100, 45, 180, 20);
		cancel.setBounds(20, 80, 120, 20); verify.setBounds(160, 80, 120, 20);
		
		
		add(lb_01); add(tx);
		add(lb_02);	add(pass);
		add(cancel); add(verify);
		
	}
		public static void main(String[] args) {
			new LoginForm();
		}
}
