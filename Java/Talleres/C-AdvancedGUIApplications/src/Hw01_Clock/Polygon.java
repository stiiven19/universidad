package Hw01_Clock;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Polygon extends JComponent{

	int number;
	public Polygon(int number) {
		this.number=number;

	}
	public void paint (Graphics g){
		
		int width = getWidth();
		int height= getHeight();
		System.out.println(width);
		System.out.println(height);
		int xpoints[]	={35*width/100,70*width/100,75*width/100,70*width/100,35*width/100,30*width/100};
		int ypoints[]	={30*height/233,30*height/233,35*height/233,40*height/233,40*height/233,35*height/233};
		
		
		int xpoint[]	={81*width/100,81*width/100,76*width/100,71*width/100,71*width/100,76*width/100};
		int ypoint[]	={40*height/233,85*height/233,90*height/233,85*height/233,40*height/233,35*height/233};
		
		
		
		int xpoin[]	={34*width/100,34*width/100,29*width/100,24*width/100,24*width/100,29*width/100};
		int ypoin[]	={40*height/233,85*height/233,90*height/233,85*height/233,40*height/233,35*height/233};
		
		
		int xpoi[]	={35*width/100,70*width/100,75*width/100,70*width/100,35*width/100,30*width/100};
		int ypoi[]	={85*height/233,85*height/233,90*height/233,95*height/233,95*height/233,90*height/233};
		
		
		int xpo[]	={81*width/100,81*width/100,76*width/100,71*width/100,71*width/100,76*width/100};
		int ypo[]	={95*height/233,140*height/233,145*height/233,140*height/233,95*height/233,90*height/233};
		
		
		int xp[]	={34*width/100,34*width/100,29*width/100,24*width/100,24*width/100,29*width/100};
		int yp[]	={95*height/233,140*height/233,145*height/233,140*height/233,95*height/233,90*height/233};
		
		
		int x[]	={35*width/100,70*width/100,75*width/100,70*width/100,35*width/100,30*width/100};
		int y[]	={140*height/233,140*height/233,145*height/233,150*height/233,150*height/233,145*height/233};
		Color colo = new Color(209, 209, 209);
		g.setColor(colo);
		if (number==2 ||number==0 ||number==3 ||number==5 ||number==6 ||number==7 ||number==8 ||number==9 ) {
			g.setColor(Color.BLACK);
		}
		g.fillPolygon(xpoints, ypoints, 6);	//1
		g.setColor(colo);
		if (number==1 ||number==0 ||number==2 ||number==3 ||number==4 ||number==7 ||number==8 ||number==9 ) {
			g.setColor(Color.BLACK);
		}
		g.fillPolygon(xpoint, ypoint, 6);	//2
		g.setColor(colo);
		if (number==4 ||number==0 ||number==5 ||number==6 ||number==8 ||number==9 ) {
			g.setColor(Color.BLACK);
		}
		g.fillPolygon(xpoin, ypoin, 6);		//3
		g.setColor(colo);
		if (number==2 ||number==3 ||number==4 ||number==5 ||number==6 ||number==8 ||number==9) {
			g.setColor(Color.BLACK);	
		}
		g.fillPolygon(xpoi, ypoi, 6);		//4
		g.setColor(colo);
		if (number!=2) {
			g.setColor(Color.BLACK);
		}
		g.fillPolygon(xpo, ypo, 6);			//5
		g.setColor(colo);
		if (number==2 ||number==6||number==0 ||number==8) {
			g.setColor(Color.BLACK);
		}
		g.fillPolygon(xp, yp, 6);			//6
		g.setColor(colo);	
		if (number==2||number==0 ||number==3 ||number==5 ||number==6 ||number==8 ) {
			g.setColor(Color.BLACK);
		}
		g.fillPolygon(x, y, 6);				//7
	}
	
	
}
