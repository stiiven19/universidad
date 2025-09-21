package eyes;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

public class EyesPanel extends JComponent{
	int x1;
	int y;
	int x2;
	int directionx=0;
	int directiony=0;
	
	
	
	public EyesPanel() {
		// TODO Auto-generated constructor stub
		
		
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				setDirectionx(e.getX()/(getWidth()/9));
				setDirectiony(e.getY()/(getHeight()/9));
			
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				setDirectionx(e.getX()/(getWidth()/9));
				setDirectiony(e.getY()/(getHeight()/9));
			}
		});
		
	}
@Override
public void paint(Graphics g) {
	int width=getWidth();
	int height=getHeight();
	
	setSize();
	g.drawOval(width/2 -50, height/2-50, 100, 100);
	
	g.drawOval((width/2)-28, (height/2)-15, 20, 20);
	g.drawOval((width/2) +12, (height/2)-15, 20, 20);
	
	g.drawLine(width/2 -18, (height/2)+28, width/2 +22, (height/2)+28);
	
	
	g.fillOval(x1+directionx, y+(directiony), 10, 10);
	g.fillOval(x2+directionx,y+(directiony),10,10);
	
	
	
}
public void setDirectionx(int directionx) {
	this.directionx = directionx+1;
	repaint();
}
public void setDirectiony(int directiony) {
	this.directiony = directiony;
	repaint();
}
public void setSize() {
	x1=getWidth()/2-29;
	 y=getHeight()/2-14;
	x2=getWidth()/2+12;
}

}
