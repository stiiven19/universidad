package ex01_graph;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Horizon extends JComponent {

	public void paint (Graphics g){
		int widht	= getWidth();
		int height	= getHeight();
		g.setColor(new Color(201,255,229));
		g.fillRect(0,0, widht, height/2);
	
		g.setColor(new Color(253,184,19));
		g.fillOval(widht/2-widht/8,height/2-widht/8, widht/4, widht/4);
		
		g.setColor(new Color(0,119,190));
		g.fillRect(0, height/2, widht, height/2);
		
	
	}
}
