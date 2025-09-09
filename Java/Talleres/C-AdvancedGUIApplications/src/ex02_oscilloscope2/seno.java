package ex02_oscilloscope2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class seno extends JComponent{

	double amplitude,period,gap,B,C;
	int scale;
	
	public seno(double amplitude, double period, double gap,double B,double C, int scale) {
		this.amplitude = amplitude;
		this.period = period;
		this.gap = gap;
		this.B=B;
		this.C=C;
		this.scale=scale;
	}

	public void paint (Graphics g){
		int width = getWidth();
		int height = getHeight();
		
		g.setColor(Color.BLACK);
		g.drawLine(0, height/2, width, height/2);
		g.drawLine(width/2, 0, width/2, height);
		
		g.setColor(new Color(225, 225, 225));
		for (int i = 50; i <height ; i+=50) {
			g.drawLine(0, height/2-i,width , height/2-i);
			g.drawLine(0, height/2+i,width , height/2+i);
		}
		for (int i = 80; i < width; i+=80) {
			g.drawLine(width/2+i, 0, width/2+i, height);
			g.drawLine(width/2-i, 0, width/2-i, height);
		}
		
		g.setColor(Color.RED);
		System.out.println("periodo: "+((width/2)/8));
		for (double x = 0; x < period*(width/2/8); x+=0.01) {
			double y = amplitude*Math.sin(x*Math.PI*C);
			
			int px = (int)(width/2 + x*80);
			int py = (int)(height/2 - y*80);
			g.drawLine(px,py,px,py);
		}
		
	}
}
