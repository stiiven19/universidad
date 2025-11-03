package ev02;

import java.awt.Graphics;

import javax.swing.JComponent;

public class ex05 extends JComponent{
	int width	;
	int height	;
	public ex05(int east,int sur) {
	width=sur;
	height=351-east;
	}
	
	public void paint (Graphics g) {
		g.drawOval(width+15, height-15, 20, 40);
		g.drawOval(width-5, height-15, 20,40 );
		g.fillOval(width, height, 10, 20);
		g.fillOval(width+20, height, 10, 20);
		
		
	}
	

	public void setWidth(int width) {
		this.width = width;
		repaint();
	}

	
	public void setHeight(int height) {
		this.height = getHeight()-height;
		repaint();
	}
	
	
}
