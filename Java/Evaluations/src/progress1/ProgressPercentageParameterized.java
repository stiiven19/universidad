package progress1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

public class ProgressPercentageParameterized extends JComponent{
	
	private int value;
	private ProgressPercentageListener l=null;

	public ProgressPercentageParameterized(int value) {
		
		this.value = value;
		
		setupEvents();
	}
	
	private void setupEvents() {
		// TODO Auto-generated method stub
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				setValue(e.getX()*100/getWidth());
				if (l!=null) {
					l.ProgressChange(value);
				}
			}
		});
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				setValue(e.getX()*100/getWidth());
				
				if (l!=null) {
					l.ProgressChange(value);
				}
			}
		});
		
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		int widht=getWidth();
		int height=getHeight();
		
		g.setColor(Color.black);
		g.drawRect(0, 0	, widht-2, height-2);
		
		if (value>=0 && value<=100) {
			g.setColor(Color.RED);
			g.fillRect(1, 1, value*(widht-2)/100, height-3);
		}
	}

	public void setValue(int value) {
		this.value = value;
		repaint();
	}
	
	public void addProgressPercentageListener(ProgressPercentageListener l) {
		this.l=l;
	}

	public int getValue() {
		return value;
	}

	
}
