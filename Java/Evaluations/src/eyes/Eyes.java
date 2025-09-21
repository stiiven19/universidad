package eyes;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

//...

public class Eyes extends JFrame {
	//------------------------------------------------------
	public Eyes() {
		setTitle("eyes");
		setSize(400,400);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}
	//------------------------------------------------------
	private void setupWidgets() {
		add(new EyesPanel());
	}
	//------------------------------------------------------
	private void setupEvents() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//------------------------------------------------------
	public static void main(String[] args) {
		new Eyes();
	}	
	
}