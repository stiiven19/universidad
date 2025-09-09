package ex08_registerform_complete;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegisterForm extends JDialog{
//_-------------------------------------------------------------------------------------
	private JLabel				lb_1, lb_2, lb_3, lb_4, lb_5;	
	private JTextField			txf_01, txf_02, txf_03, txf_04;
	private JButton 			bt_01, bt_02;
	private JComboBox<String> 	box;
	private ConferenceRegister	mainframe;		
	
	public RegisterForm(ConferenceRegister mainframe) {
		super(mainframe, true);
		this.mainframe=mainframe	;
		setSize(280, 250);
		setTitle(" Register Form");
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}

	private void setupEvents() {
		bt_01.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object rowinfo[]		= {txf_01.getText(),
											txf_02.getText(),
											box.getSelectedItem(),
											txf_03.getText(),
											txf_04.getText(),
											};
				mainframe.tm_attendants.addRow(rowinfo);
				dispose();
			}
		});
		bt_02.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
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
		
		box 	= new JComboBox<String>();
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
