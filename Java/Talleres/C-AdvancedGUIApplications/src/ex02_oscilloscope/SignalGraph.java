package ex02_oscilloscope;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SignalGraph extends JComponent{

	private int		scale;
	private double	frecuency;
	private double	amplitude;
	
	public SignalGraph(int s,double f, double a) {
		// TODO Auto-generated constructor stub
		scale=s;
		frecuency=f;
		amplitude=a;
	}
	public void paint(Graphics g){
		int width	= getWidth();
		int height	= getHeight();
		
		g.drawLine(width/2, 0, width/2, height);
		g.drawLine(0, height/2, width, height/2);
		
		g.setColor(Color.GRAY);
		for (int i = scale; i< height/2; i+=scale) {
			g.drawLine(0, height/2-i,width , height/2-i);
			g.drawLine(0, height/2+i,width , height/2+i);
		}
		
		for (int i = scale; i < width/2; i+=scale) {
			g.drawLine(width/2-i, 0, width/2-i, height);
			g.drawLine(width/2+i, 0, width/2+i, height);
		}
		
		g.setColor(Color.BLUE);
		
		for (double x = -width/2/scale; x < width/2/scale; x+=0.01) {
			double y = amplitude*Math.sin(x*Math.PI*frecuency);
			
			int px=(int)(width/2  + x*scale);
			int py=(int)(height/2 - y*scale);
			
			g.drawLine(px, py, px, py);
		}
	}
	public int getScale() {
		return scale;
	}
	public void setScale(int scale) {
		this.scale = scale;
		repaint();
	}
	public double getFrecuency() {
		return frecuency;
	}
	public void setFrecuency(double frecuency) {
		this.frecuency = frecuency;
		repaint();
	}
	public double getAmplitude() {
		return amplitude;
	}
	public void setAmplitude(double amplitude) {
		this.amplitude = amplitude;
		repaint();
	}
	
}
