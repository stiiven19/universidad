package Graficos;

import java.awt.Color;
import java.awt.Graphics;


public class Pixel extends Shape{

	private int color;
	private Color [] colores = {Color.BLACK,
			Color.BLUE,
			Color.CYAN,
			Color.DARK_GRAY,
			Color.GRAY,
			Color.GREEN,
			Color.LIGHT_GRAY,
			Color.MAGENTA,
			Color.ORANGE,
			Color.PINK,
			Color.RED,
			Color.WHITE,
			Color.YELLOW};
	
	public Pixel(int x, int y, int color) {
		super(x, y, 2, 2);
		this.color=color;
				
	}
	
	
	
	public void draw(Graphics g) {
		
		if (color >12 || color<0) {
			color= 0;
		}
		
        g.setColor(colores[color]);
        g.fillRect(x, y, 2, 2);
	}



	@Override
	public void estilo(int paterno, int color) {
		// TODO Auto-generated method stub
		
	}

}
