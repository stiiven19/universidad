package Hw03_ballon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JComponent;

public class BallonsDraw extends JComponent{

	int size,min,max,increase;
	Color color;
	
	public BallonsDraw(int size,int min,int max,Color color, int increase) {
		this.size=size;
		this.min=min;
		this.max=max;
		this.increase=increase;
		this.color=color;
		
		setupEvents();
	}
	
	private void setupEvents() {
		addMouseWheelListener(new MouseWheelListener() {
			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				int rotation=e.getWheelRotation();
				
				int rad;
				if (getWidth()/2<getHeight()/2)rad=(getWidth()/2)+28*getWidth()/97;
				else rad=(getHeight()/2)+28*getHeight()/273;
				if (size>rad)size=rad; 
				if (rotation==1) {
					size-=increase;
				}else {
					size+=increase;
				}
				if (size>max)size=max; 
				if(size<min)size=min;
				repaint();
			}
		});
		
	}

	public void paint(Graphics g) {
		int width=getWidth();
		int height=getHeight();
		
		
		int rad;
		if (width/2<height/2)rad=((width/2)+28*width/97)-2;
		else rad=((height/2)+28*height/273)-2;
		
		g.setColor(Color.black);
		System.out.println("rad: "+rad);
		g.drawOval((width/2)-rad/2, (height/2)-rad/2, rad,rad );
		
		g.setColor(color);
		System.out.println("fill: "+size);
		int positionx=(width/2)-size/2;
		int positiony=(height/2)-size/2;
		if (size>max)size=max; 
		 
		g.fillOval(positionx, positiony, size, size);
		
		
	}
}
