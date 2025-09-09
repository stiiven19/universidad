package ex01_graph;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class ColombianFlag extends JComponent{
	public void paint(Graphics g){
		int width = getWidth();
		int height = getHeight();
		g.setColor(Color.YELLOW);
		g.fillRect(width/4,height/4,2*width/4, 2*height/4);
		g.setColor(Color.BLUE);
		g.fillRect(width/4, height/2,2*width/4, 2*height/8);
		g.setColor(Color.RED);
		g.fillRect(width/4,5*height/8, 2*width/4, height/8);
	}
}
