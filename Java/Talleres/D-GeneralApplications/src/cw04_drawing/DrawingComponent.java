package cw04_drawing;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JComponent;

public class DrawingComponent extends JComponent{
	
	private ArrayList<Point>	points;
	
	public DrawingComponent() {
		points= new ArrayList<Point>();
		setupEvents();
		}
	private void setupEvents() {
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent arg0) {
				
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				points.add(new Point(e.getPoint()));
				repaint();
				
			}
		});
		
	}
	@Override
	public void paint(Graphics g) {
		if (!points.isEmpty()) {
			Point p1= new Point(points.get(0));
		
		for (Point p2:points) {
			
			g.drawLine(p1.x, p1.y, p2.x, p2.y);
			p1=p2;
		}
		}
		
	}
}
