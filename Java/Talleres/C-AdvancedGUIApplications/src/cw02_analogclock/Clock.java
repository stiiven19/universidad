package cw02_analogclock;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Calendar;

import javax.swing.JComponent;



public class Clock	extends JComponent {
	
	private Battery battery;
	
	public Clock() {
		battery = new Battery(this);	
		battery.start();
	}
	
	public void paint(Graphics g) {
		int cx	= getWidth()/2;
		int cy	= getHeight()/2;
		int rad		= cx<cy?cx-10:cy-10;
		
		
		g.setColor(Color.black);
		g.drawOval(cx-rad, cy-rad, rad*2,rad*2 );
		double angle;
		int x,y;
		int number;
		for (angle = 0;  angle< 2*Math.PI; angle+=2*Math.PI/12) {
			x=cx + (int)( Math.sin(angle) * (rad-10));
			y=cy - (int)( Math.cos(angle) * (rad-10));
			g.fillOval(x-3, y-3, 6, 6);
			
		}
		
		Calendar calendar = Calendar.getInstance();
		
		int hour 	= calendar.get(Calendar.HOUR);
		int minute	= calendar.get(Calendar.MINUTE);
		int second	= calendar.get(Calendar.SECOND);
		
		angle	= 2*Math.PI/(12*60) * (hour*60+minute);
		x = cx + (int)(Math.sin(angle) * (rad/2));
		y = cy - (int)(Math.cos(angle) * (rad/2));
		g.drawLine(cx, cy, x, y);
		
		angle = 2*Math.PI/(60)*(minute);
		x = cx + (int)(Math.sin(angle) * (rad*3/4));
		y = cy - (int)(Math.cos(angle) * (rad*3/4));
		g.drawLine(cx, cy, x, y);
		
		angle = 2*Math.PI/60*second;
		x = cx + (int)(Math.sin(angle) * (rad-5));
		y = cy - (int)(Math.cos(angle) * (rad-5));
		g.drawLine(cx, cy, x, y);
		//repaint();
		
	}
}
