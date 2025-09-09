package cw04_drawing;

import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class shapesWindow extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	
private DrawingPanel panel;
private int ShapeType;
private Shape	current;
	/**
	 * Create the frame.
	 */
	public shapesWindow() {
		setIconifiable(true);
		setTitle("Drawing Shapes");
		
		setMaximizable(true);
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 704, 448);
		setVisible(true);
		
		// Set up the main content pane layout
		getContentPane().setLayout(new BorderLayout());
		
		// Create and configure the drawing panel
		panel = new DrawingPanel();
		panel.setLayout(new BorderLayout());
		
		// Create a panel for instructions
		JPanel instructionPanel = new JPanel(new BorderLayout());
		
		// Create and style the instruction label
		JLabel instructionLabel = new JLabel("<html><div style='text-align: center;'><b>Drawing Shapes Instructions:</b><br>"
			+ "1. Click and drag to draw a shape<br>"
			+ "2. Press 'T' to draw a Triangle<br>"
			+ "3. Press 'D' to draw a Diamond<br>"
			+ "4. Right-click to clear the canvas</div></html>");
		
		// Add some padding around the instructions
		instructionPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		instructionPanel.add(instructionLabel, BorderLayout.CENTER);
		
		// Add components to the content pane
		getContentPane().add(instructionPanel, BorderLayout.NORTH);
		getContentPane().add(panel, BorderLayout.CENTER);
		
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if (current!=null) {
					current.setSise(e.getX()-current.getX(), e.getY()-current.getY());
					
					panel.repaint();
				} 
			}
		});
		
		
		panel.setFocusable(true);
		
		panel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				switch (ShapeType) {
				case 1:
					current=new Triangle(e.getX(), e.getY(), 1, 1, 1);
					panel.addShape(current);
					break;
				case 2:
					current=new Diamond(e.getX(), e.getY(), 1, 1);
					panel.addShape(current);
					break;
				default:
					break;
				}
			}
		});
		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				switch (e.getKeyCode()) {
				case	KeyEvent.VK_T :
					ShapeType=1;//triangle
					break;
				case KeyEvent.VK_D:
					ShapeType=2;
					break;
				case KeyEvent.VK_ESCAPE:
					ShapeType=0;
					current=null;
					break;
				default:
					break;
				}
				
			}
		});
		
		getContentPane().add(panel,BorderLayout.CENTER);
		
		

	}

}
