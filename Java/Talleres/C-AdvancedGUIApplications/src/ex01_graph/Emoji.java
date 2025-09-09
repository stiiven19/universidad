package ex01_graph;

import java.awt.Graphics;

import javax.swing.JComponent;

public class Emoji extends JComponent{
	
	public void paint(Graphics g){
		g.drawOval(50,50, 100, 100);
		g.drawOval(70,80, 20, 20);
		g.drawOval(110, 80, 20, 20);
		g.drawLine(80, 120, 120, 120);
	}
}
