package Graficos;

import java.awt.Graphics;
import java.util.ArrayList;

public class Circulo extends Shape {

	int x,y,r;
	private Shape pixel,linea;
	protected ArrayList<Shape> pixeles=new ArrayList<Shape>();
    
    
    public Circulo(int x, int y, int r) {
    	super(x, y, 2, 2);
        this.x = x;
        this.y = y;
        this.r = r;
    }
    public void draw(Graphics g) {
    	 double co ;
    	 double ca ;
    	 for (double i = 0; i < 360; i+=0.5) {
    		 co = (Math.sin(Math.toRadians(i)))*r;
    		 ca = (Math.cos(Math.toRadians(i)))*r;
    		 pixel= new Pixel(x+(int)Math.round(ca), y-(int)Math.round(co),color);
    		 
             pixeles.add(pixel);
    	 }
    	 
    	 for(Shape s:pixeles) {
    		 
    		 s.setColor(color);
    		 s.draw(g);
    	 } 
    	 if (this.isEstilo()) {
    		 estilo(Shape.getPaterno(), Shape.getColor());
    	 }
    }
	@Override
	public void estilo(int paterno, int color) {
		this.setEstilo(true);
		Shape.color=color;
		Shape.setPaterno(paterno);
		int co ;
   	 	int ca ;
		//paterno 0
		if (paterno == 0) return;
		//paterno 1
		if (paterno == 1) {
			
	    	 for (int i = 0; i < 360; i+=2) {
	    		 co = (int)Math.round((Math.sin(Math.toRadians(i)))*r);
	    		 ca = (int)Math.round((Math.cos(Math.toRadians(i)))*r);
	    		 linea= new Linea(x,y,x+ca, y-co);
	    		 
	             pixeles.add(linea);
			}
		}
		//paterno 2
		if (paterno == 2) {
			for (int i = 0; i < 360; i+=20) {
	    		 co = (int)Math.round((Math.sin(Math.toRadians(i)))*r);
	    		 ca = (int)Math.round((Math.cos(Math.toRadians(i)))*r);
	    		 linea= new Linea(x-ca,y-co,x+ca, y-co);
	             pixeles.add(linea);
			}
		}
		//paterno 3
		if (paterno == 3) {
			for (int i = 0; i < 360; i+=20) {
	    		 co = (int)Math.round((Math.sin(Math.toRadians(i)))*r);
	    		 ca = (int)Math.round((Math.cos(Math.toRadians(i)))*r);
	    		 linea= new Linea(x+ca,y-co,x+ca, y+co);
	    		 
	             pixeles.add(linea);
			}
		}
		//paterno 4
		if (paterno == 4) {
			for (int i = 0; i < 360; i+=20) {
	    		 co = (int)Math.round((Math.sin(Math.toRadians(i)))*r);
	    		 ca = (int)Math.round((Math.cos(Math.toRadians(i)))*r);
	    		 int ca2 = (int)Math.round((Math.cos(Math.toRadians(i+45)))*r);
	    		 int co2 = (int)Math.round((Math.sin(Math.toRadians(i+45)))*r); 
	    		 linea= new Linea(x+ca,y+co,x+ca2, y-co2);
	             pixeles.add(linea);
			}
			
		}
		//paterno 5
		if (paterno == 5) {	
			for (int i = 0; i < 360; i+=20) {
	    		 co = (int)Math.round((Math.sin(Math.toRadians(i)))*r);
	    		 ca = (int)Math.round((Math.cos(Math.toRadians(i)))*r);
	    		 int ca2 = (int)Math.round((Math.cos(Math.toRadians(i+45)))*r);
	    		 int co2 = (int)Math.round((Math.sin(Math.toRadians(i+45)))*r); 
	    		 linea= new Linea(x+ca,y-co,x+ca2, y+co2);
	             pixeles.add(linea);
			}
		}
		//paterno 6
		if (paterno == 6) {
			//paterno 2
			for (int i = 0; i < 360; i+=20) {
	    		 co = (int)Math.round((Math.sin(Math.toRadians(i)))*r);
	    		 ca = (int)Math.round((Math.cos(Math.toRadians(i)))*r);
	    		 linea= new Linea(x-ca,y-co,x+ca, y-co);
	    		 pixeles.add(linea);
	    		 linea= new Linea(x+ca,y-co,x+ca, y+co);
	             pixeles.add(linea);
			}
			//paterno 3
		}
		//paterno 7
		if (paterno == 7) {
			//paterno 4
			for (int i = 0; i < 360; i+=20) {
	    		 co = (int)Math.round((Math.sin(Math.toRadians(i-45)))*r);
	    		 ca = (int)Math.round((Math.cos(Math.toRadians(i-45)))*r);
	    		 int ca2 = (int)Math.round((Math.cos(Math.toRadians(i+45)))*r);
	    		 int co2 = (int)Math.round((Math.sin(Math.toRadians(i+45)))*r); 
	    		 linea= new Linea(x+ca,y+co,x+ca2, y-co2);
	             pixeles.add(linea);
	             linea= new Linea(x+ca,y-co,x+ca2, y+co2);
	             pixeles.add(linea);
			}
			
			
		}//if*/
	 
	}//fin estilo()

}
