package GridSelect;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

//............

public class GridSelectionWindow extends JFrame {	
	//-----------------------------------------------------------
	private GridSelection	ct_schedule;
	//-----------------------------------------------------------
	public GridSelectionWindow() {
		setSize(600,400);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}
	//-----------------------------------------------------------
	private void setupWidgets() {
		ct_schedule	= new GridSelection(8, 5,	new String[] {"","8:00","9:00","10:00","11:00","14:00","15:00","16:00","17:00"}, 
												new String[] {"","Monday","Tuesday","Wednesday","Thursday","Friday"});
		
		add(ct_schedule);
	}
	//-----------------------------------------------------------
	private void setupEvents() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new GridSelectionWindow();
	}
}
