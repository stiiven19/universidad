package Homework_B04;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class DateForm extends JFrame{
	
	JLabel lb_01, lb_02, lb_03;
	JComboBox year, month, day;
	//--------------------------------------------------------------------
	public DateForm() {
		// ----------------------
		setSize(400, 100);
		setLocationRelativeTo(null);
		setTitle("Date Selection");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}
	//_------------------------------------------------------------------------
	private void setupEvents() {
		// ----------------------------------------------------------------------
		class Action implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// -----------------------------------------------------------------
				int 	year_d 	= (int)year.getSelectedItem();
				String 	month_d	= (String)month.getSelectedItem();
				int		day_d		= (int)day.getSelectedItem();	
				setTitle("Today is "+day_d+" of "+month_d+" of "+year_d);
			}
		}
		//-_-------------------------------
		Action action = new Action();
		year.addActionListener(action);
		month.addActionListener(action);
		day.addActionListener(action);
	}
	//-------------------------------------------------------------------
	private void setupWidgets() {
		// ------------------------------------------------------------------------
		lb_01	=	new JLabel("Year",SwingConstants.CENTER);
		lb_02	=	new JLabel("Month",SwingConstants.CENTER);
		lb_03	=	new JLabel("Day",SwingConstants.CENTER);
		
		year	=	new JComboBox();
		month	=	new JComboBox();
		day	=	new JComboBox();
		
		setLayout(new GridLayout(2,3));
		
		for (int i = 1; i < 32; i++) {
			day.addItem(i);
		}
		
		for (int i = 1900; i < 2100; i++) {
			year.addItem(i);
		}
		
		month.addItem("January");
		month.addItem("February");
		month.addItem("March");
		month.addItem("April");
		month.addItem("May");
		month.addItem("June");
		month.addItem("July");
		month.addItem("August");
		month.addItem("September");
		month.addItem("October");
		month.addItem("November");
		month.addItem("December");
		
		add(lb_01 ); add(lb_02); add(lb_03);
		add(year);   add(month); add(day);
	}
	//---------------------------------------------------------------
	public static void main(String[] args) {
		new DateForm();
	}
}
