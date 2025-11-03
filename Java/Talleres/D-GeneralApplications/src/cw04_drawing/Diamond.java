package cw04_drawing;

import java.awt.Graphics;

public class Diamond extends Shape{

	public Diamond(int x, int y, int widht, int height) {
		super(x, y, widht, height);
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics g) {
		g.drawLine(x, y+height/2, x+widht/2	, y);
		g.drawLine(x+widht/2, y, x+widht, y+height/2);
		g.drawLine(x+widht, y+height/2, x+widht/2, y+height);
		g.drawLine(x+widht/2, y+height, x, y+height/2);
	}
}
