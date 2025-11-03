package cw04_drawing;

import java.awt.Graphics;

abstract public class Shape {
	
protected int x,y,widht,height;

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
	
	
}
