package cw04_drawing;

import java.awt.Graphics;

public class Triangle extends Shape{

	private int direction;
	
	public Triangle(int x, int y, int widht, int height,int direction) {
		super(x, y, widht, height);
		// TODO Auto-generated constructor stub
		this.direction=direction;
	}
	
	
	
	public void draw(Graphics g) {
		
		switch (direction) {
		case 1:
			g.drawLine(x, y+height, x+widht/2, y);
			g.drawLine(x+widht/2, y, x+widht, y+height);
			g.drawLine(x+widht, y+height, x, y+height);
			break;
		default:
			break;
		}
		
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getDirection() {
		return direction;
	}
	
}
