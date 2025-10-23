package Graficos;

import java.awt.Color;
import java.awt.Graphics;

abstract public class Shape {
	
protected int x,y,widht,height;
protected Color [] colores = {Color.BLACK,
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
	static int color=0;
	static boolean estilo;
	static int paterno;
	
public Shape(int x, int y, int widht, int height) {
	
	this.x = x;
	this.y = y;
	this.widht = widht;
	this.height = height;
        
}

	public void setSise(int widht,int height) {
		this.widht=widht;
		this.height=height;
	}
	
	public void setLocation(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public abstract void draw(Graphics g);

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidht() {
		return widht;
	}

	public int getHeight() {
		return height;
	}
	
	public abstract void estilo(int paterno, int color);
	
	public void setColor(int color) {
		this.color=color;
	}
	public void setEstilo(boolean Estilo) {
		Shape.estilo=Estilo;
	}

	public boolean isEstilo() {
		return estilo;
	}

	public static int getPaterno() {
		return paterno;
	}

	public static void setPaterno(int paterno) {
		Shape.paterno = paterno;
	}

	public static int getColor() {
		return color;
	}
	
}
