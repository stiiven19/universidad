package Hyperlink;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

public class HyperLink extends JComponent{

	String word;
	Color	color=Color.BLACK;
	HyperLinkListener	listener=null;
	
	public HyperLink(String word) {
		this.word=word;
		setupEvents();
	}
	
	private void setupEvents() {
		// TODO Auto-generated method stub
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
				setcolor(color.black);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setcolor(color.BLUE);
				
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if (listener!=null) {
					listener.linkTaked();
				}
			}
		});
		
		
	}

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
		int widht=getWidth();
		int height=getHeight();
		
		g.setColor(color
				);
		g.drawString(word,widht/4, height/4);
	}
	
	private void setcolor(Color a) {
		this.color=a;
		repaint();
				
	}
	
	public void addHyperLinkListener(HyperLinkListener l) {
		listener=l;
	}
}
