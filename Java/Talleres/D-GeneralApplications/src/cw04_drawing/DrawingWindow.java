package cw04_drawing;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class DrawingWindow extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public DrawingWindow() {
		setIconifiable(true);
		setTitle("Freehand Window");
		
		setMaximizable(true);
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 376, 276);
		setVisible(true);
		
		JLabel instructionLabel = new JLabel("Click and drag to draw freehand. Right-click to clear the drawing.");
		getContentPane().add(instructionLabel, BorderLayout.NORTH);
		getContentPane().add(new DrawingComponent(), BorderLayout.CENTER);

	}

}
