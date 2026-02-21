/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diagrama;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.text.DecimalFormat;
import javax.swing.JComponent;
//import cgrafica.Pixel.java;
/**
 *
 * @author lenovo
 */
public class Linea  extends Applet{
	
    int x1,y1, x2, y2, widht,height;
    
public Linea(int x1, int y1, int x2, int y2) {
	
	this.x1 = x1;
	this.y1 = y1;
        this.x2 = x2;
	this.y2 = y2;
	this.widht = 5;
	this.height = 5;
}
    
    
    public void repint(){
        repaint();
    };
    
    public void paint(Graphics g) {
        System.out.println("joas");
        int width=getWidth();
        int Height=getHeight();

        int guardado=-10;
        float M=0,y=y1;
        /*if(x1>x2){
            guardado=x1;
            
            x1=x2;
            x2=guardado;
            guardado=y2;
            y2=y1;
            y1=guardado;
            y=y2;
        }*/
        System.out.println("y1: "+y1);
        System.out.println("y2: "+y2);
        System.out.println("x1: "+x1);
        System.out.println("x2: "+x2);
        
        System.out.println("M: ("+y1+" - "+y2+")/"+x2+" - "+x1+";");
        
        M=(float)(y2-y1)/(x2-x1);
        int h=y1;
        //g.drawLine(x1+50, y1+50, x2+50, y2+50);
        boolean band;
        band = y2>y1;
        if(M == Double.NEGATIVE_INFINITY || M==Double.POSITIVE_INFINITY){
            M=0;
            h=y2;
        }
        System.out.println(band );
        for (int j = x1; j <= x2; j++) {
            y=M*(j-x1)+y1;
            /*if (y>y2) {
                y=y2;
            }*/
        //float h=(float)(y-y2)/(x2-x1);    
        
            
            //i=x2;
            //System.out.println("h: "+h);
            System.out.println("-------------------------------------");
            System.out.println("y: M*("+j+" - "+x1+")+"+y1);
            System.out.println("M: "+M);
            System.out.println("x: "+j);
            System.out.println("y: "+y);
            System.out.println("-------------------------------------");
            //Pixel pixeli = new Pixel(i,y,4);
            g.setColor(Color.BLACK);
            g.fillOval(j, Math.round(y), 2, 2);
            System.out.println(""+y+" - "+h+" = "+(y-h>1));
            if(band){
                if(h-y>1){
                for (int i = Math.round(y); i <= h; i++) {
                    System.out.println("j,i "+j+" , "+i);
                    g.fillOval(j, i, 2, 2);
                }
            }
            }else if(!band){
                System.out.println("entro");
                if(y-h>1){
                    for (int i = h; i <= y; i++) {
                        System.out.println("j,i "+j+" , "+i);
                        g.fillOval(j, i, 2, 2);
                    }
                }
            }
            
            h=Math.round(y);
        }
        
	//g.drawLine(x1, y1, x2, y2);
    }	
    
}

