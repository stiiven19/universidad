package ex01_graph;

import java.awt.Graphics;

import javax.swing.JComponent;

public class Sand extends JComponent{

	public void paint(Graphics g){
		int widht	= getWidth();
		int height	= getHeight();
		
		g.fillArc(widht/4, 0, 2*widht/4,2*height/4,	180,180);
		g.fillArc(widht/4, height/2, 2*widht/4, 2*height/4, 0, 180);
		//g.drawLine(widht/4, height/4, 3*widht/4, height/4);
		//g.drawLine(widht/4, 3*height/4, 3*widht/4, 3*height/4);
	}
}
