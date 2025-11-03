package Homework_B08;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConferenceRegister extends JFrame{
//----------------------------------------------------------------------------
	private JTable				tb_attendants;
	protected DefaultTableModel	tm_attendants;
	private JButton				bt_new;
	private ConferenceRegister	mainframe= this;
		
	public ConferenceRegister() {
		setTitle("Conference Register");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setupWidgets();
		setupEvents();
		setVisible(true);
		new LoginForm(mainframe);
	}

	private void setupWidgets() {
		
		tm_attendants		= new DefaultTableModel( new Object[]{
														"Id",
														"name",
														"Genre",
														"Address",
														"Phone"},0);
		tb_attendants		= new JTable(tm_attendants);
		bt_new				= new JButton("New Register");
		
		add(new JScrollPane(tb_attendants));
		add(bt_new,BorderLayout.SOUTH);
		
	}
	
	private void setupEvents() {
		bt_new.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new RegisterForm(mainframe);
				
			}
		});
		
	}
	public static void main(String[] args) {
		new ConferenceRegister();
	}
}
