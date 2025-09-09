package ex03_settings;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.GregorianCalendar;

import javax.swing.JComponent;



public class Switcher extends JComponent{

 boolean band;
 public Switcher(boolean band) {
	 this.band=band;
	 setupEvents();
}
	
	private void setupEvents() {
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (isBand()) {
					setBand(false);	
				}else {
					setBand(true);
				}
			}
		});
	
}

	public void paint( Graphics g){
	 int width=getWidth();
	 int height	= getHeight();
	 g.setColor(Color.black);
		g.drawRect(width/10, (height/5)+3, width/2, height/2);
		
		if (band) {
			g.setColor(Color.RED);
			g.fillRect(width/8,(height/3),(width/5)+1,(height/3)+2);
		}else {
			
			g.setColor(Color.GREEN);
			g.fillRect((width/3)+3,(height/3), (width/5)+1,(height/3)+2);
		}
	}

	public boolean isBand() {
		return band;
	}

	public void setBand(boolean band) {
		this.band = band;
		repaint();
	}
	

}
