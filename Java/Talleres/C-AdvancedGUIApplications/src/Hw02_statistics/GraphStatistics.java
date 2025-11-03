package Hw02_statistics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;

public class GraphStatistics extends JComponent{

	int		index=0;
	
	long 	cien=1;
	ArrayList<Long> arpopulation;
	
	public GraphStatistics() {
		
	}
	
	public void paint(Graphics g){
		int width = getWidth();
		int height= getHeight();
		
		
		//new TableStatistics(index, width,height);
		g.setColor(Color.black);
		g.drawLine(30, height-30, width-30, height-30);
		g.drawLine(30, 30, 30, height-30);
		
		
		
		
		g.setColor(Color.blue);
		
			if (index>0) {
				for (int j2 = 0; j2 < arpopulation.size(); j2++) {
					if (arpopulation.get(j2)>cien)cien=arpopulation.get(j2); 
					double tamao=((height-60)*arpopulation.get(j2))/cien;
					double altura=((tamao-height-60)*-1)-90 ;
					
					g.fillRect(31+j2*22,(int)altura, 20,(int)tamao);
					g.drawString(""+(j2+1), 31+j2*22, height-10);
					
				}	
			}
			
	}
	
	public void setCity(int index,ArrayList<Long> arpopulation){
		this.index=index+1;
		this.arpopulation=arpopulation;
		repaint();
		
	}
	
}
