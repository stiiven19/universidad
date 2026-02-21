/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diagrama;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author lenovo
 */
public class Rectangulo extends JComponent{
	
    int x1,y1, x2, y2, widht,height;
    
    
    public Rectangulo(int x1, int y1, int x2, int y2) {

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        System.out.println("y1: "+y1);
        System.out.println("y2: "+y2);
        System.out.println("x1: "+x1);
        System.out.println("x2: "+x2);
        DibujarRectangulo();
        
        
    }
        public void paint(Graphics g) {
            //g.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
            //g.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
            int altura = (getHeight()/2);
            int ancho = (getWidth()/2);
            //System.out.println(altura);
            //System.out.println(ancho);
            int j = getWidth()/2;
            int j2 = getWidth()/2;
            for (int i = 20; i < (altura); i+=30) {
                
                
                //for (int j = 0; j < 10; j++) {
                    g.drawLine(ancho,i,j , altura);
                    g.drawLine(ancho,i,j2,altura);
                    //System.out.println("j: "+j);
                j=j + 30;
                j2=j2 - 30;
            }
            j = getWidth()/2;
            j2 = getWidth()/2;
            for (int i = altura*2; i > (altura); i-=30) {
                
                
                //for (int j = 0; j < 10; j++) {
                    g.drawLine(ancho,i,j , altura);
                    g.drawLine(ancho,i,j2,altura);
                    //System.out.println("j: "+j);
                j=j + 30;
                j2=j2 - 30;
            }
            
            
            
        
        //add(null,BorderLayout.CENTER);
            
        //g.drawLine(x1, y1, x2, y1);
        }

    private void DibujarRectangulo() {
        //JPanel panel = new JPanel(null);
            //setLayout(new FlowLayout());
            Linea l1,l2,l3,l4;
            l1= new Linea(x1, y1, x2, y1);
            l2= new Linea(x2, y1, x2, y2);
            l3= new Linea(x2, y2, x1, y2);
            l4= new Linea(x1, y2, x1, y1);
    }
}