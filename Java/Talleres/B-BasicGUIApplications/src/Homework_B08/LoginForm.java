package Homework_B08;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JDialog{
	
	private JLabel				lb_01, lb_02;
	private JTextField			tx;
	private JPasswordField		pass;
	private JButton				cancel, verify;
	private ConferenceRegister	mainframe;
	
	public LoginForm(ConferenceRegister	mainframe) {
		super(mainframe, true);
		this.mainframe= mainframe;
		setTitle("User Validation");
		setSize(320, 150);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
		setVisible(true);
		
	}

	private void setupEvents() {
		verify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				char[] chars=pass.getPassword();
				String pas = new String(chars);
				String ad =tx.getText();
				if (ad.equals("admin")) {
					System.out.println("si");
					if (pas.equals("123")) {
						dispose();
					}else {
						setTitle("Incorrect");
					}
				}else {
					setTitle("Incorrect");
				}
				
			}
		});
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		});
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
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
}
