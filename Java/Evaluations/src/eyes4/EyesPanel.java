package eyes4;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

public class EyesPanel extends JComponent{

	  private int directionx;
	  private int directiony;
	  
	  public EyesPanel() { 
		  setupEvents(); 
		  }

	  
	  public void paint(Graphics g) {
		  int widht=getWidth();
		  int height=getHeight();
	    
	    g.drawOval(widht/2-50, height/2-50, 100, 100);
	    
	    g.drawLine(widht/2-20, height/2+25, widht/2+20, height/2+25);
	    
	    g.drawOval(widht/2-30, height/2-15, 20, 20);
	    g.drawOval(widht/2+10, height/2-15, 20, 20);
	    
	    double hlmouse = Math.sqrt(Math.pow((widht/2-20 - this.directionx), 2) + Math.pow((height/2-5 - this.directiony), 2));
	    double hrmouse = Math.sqrt(Math.pow((widht/2+20- this.directionx), 2) + Math.pow((height/2-5 - this.directiony), 2));
	    //System.out.println(hlmouse);
	    //g.drawLine(widht/2-20 + this.directionx,(int) height/2-5 + this.directiony,0 ,0 );
	    double langle = Math.asin(Math.abs(widht/2-20 - this.directionx) / hlmouse);
	    double rangle = Math.asin(Math.abs(widht/2+20- this.directionx) / hrmouse);
	    
	    double hpupile = 5;
	    
	    if (this.directiony > height/2-5) langle = Math.PI - langle; 
	    if (this.directionx < widht/2-20) langle = 2*Math.PI - langle;
	    
	    if (this.directiony > height/2-5) rangle = Math.PI - rangle; 
	    if (this.directionx < widht/2+20) rangle = 2*Math.PI - rangle;

	    
	    Point pupilLeft = new Point(widht/2-20 + (int)(Math.sin(langle) * hpupile), height/2-5 - (int)(Math.cos(langle) * hpupile));
	    Point pupilRight = new Point(widht/2+20+ (int)(Math.sin(rangle) * hpupile), height/2-5 - (int)(Math.cos(rangle) * hpupile));
	    
	    g.fillOval(pupilLeft.x - 5, pupilLeft.y - 5, 10, 10);
	    g.fillOval(pupilRight.x - 5, pupilRight.y - 5, 10, 10);
	  }
	  
	  private void setupEvents() {
	    addMouseMotionListener(new MouseMotionListener()
	        {
	          public void mouseMoved(MouseEvent e)
	          {
	            EyesPanel.this.directionx = e.getX();
	            EyesPanel.this.directiony = e.getY();
	            EyesPanel.this.repaint();
	          }
	          
	          public void mouseDragged(MouseEvent arg0) {}
	        });
	  }
	}

