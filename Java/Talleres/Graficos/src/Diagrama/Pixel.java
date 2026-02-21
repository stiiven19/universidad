/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diagrama;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

class Pixel extends JComponent{
	
    int x,y,widht,height;
    int color;
    
    public Pixel(int x, int y, int c) {

            this.x = x;
            this.y = y;
            this.widht = 20;
            this.height = 5;
            this.color=c;
    }

    public void setSise(int widht,int height) {
            this.widht=widht;
            this.height=height;
    }
    @Override
    public void setLocation(int x, int y) {
            this.x=x;
            this.y=y;
    }
    
    @Override
    public void paint(Graphics g) {
        
        int width=getWidth();
        int Height=getHeight();

        //System.out.println(width);
        //System.out.println(Height);
        int rad;
        if (width/2<Height/2)rad=((width/2)+28*width/97)-2;
        else rad=((Height/2)+28*Height/273)-2;
        //Color colore = new Color(color);
        g.setColor(Color.BLACK);
        //System.out.println("rad: "+rad);
        //g.drawOval((width/2)-rad/2, (Height/2)-rad/2, rad,rad );

        //System.out.println("fill: "+widht);

        int positionx=(width/2)-widht/2;
        int positiony=(Height/2)-widht/2;


        g.fillOval(x, y, 2, 2);
		
	}
    
    public void setColor(int c) {
          this.color = c  ;
    }

    public static class java {

        public java() {
        }
    }

	
	
    
}
