package ev02;

import java.awt.Graphics;

import javax.swing.JComponent;

public class ex02	extends JComponent {

	
	public void paint (Graphics g) {
		int width=getWidth();
		int height= getHeight();
		
		g.drawOval(width/2-25,40,50,50);
		g.drawLine(width/2, height/2-42, width/2, height/2+42);
		g.drawLine(	width/2-42, height/2, width/2+42, height/2);
		g.drawLine(width/2-42, height-40, width/2, height/2+42);
		g.drawLine(width/2+42, height-40, width/2, height/2+42);
	}
}
