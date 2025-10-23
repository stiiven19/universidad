package Graficos;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;

public class DrawingPanel extends JComponent{

	protected ArrayList<Shape> shapes;
	
	public DrawingPanel() {
		shapes=new ArrayList<Shape>();
		
	}
	
	public void addShape(Shape shape) {
		shapes.add(shape);
		repaint();
	}
	
	
	public void paint(Graphics g) {
		for(Shape s:shapes) {
			 if (s.isEstilo()) {
		        	s.estilo(Shape.getPaterno(), Shape.getColor());
			 }
			s.draw(g);
		}
	}
}
