package Graficos;

import java.awt.Graphics;
import java.util.ArrayList;

public class Cuadrado extends Shape {

	int x1,y1,L;
	private Shape linea;
	protected ArrayList<Shape> lineas=new ArrayList<Shape>();
    
    
    public Cuadrado(int x1, int y1, int L) {
    	super(x1, y1-L, 2, 2);
        this.x1 = x1;
        this.y1 = y1;
        this.L = L;
    }
    public void draw(Graphics g) {
    	//lineas=new ArrayList<Shape>();
    	
    	linea= new Linea(x1, y1-L, x1, y1);
    	lineas.add(linea);
        linea= new Linea(x1, y1, x1+L, y1);
        lineas.add(linea);
        linea= new Linea(x1+L, y1, x1+L, y1-L);
        lineas.add(linea);
        linea= new Linea(x1, y1-L, x1+L, y1-L);
        lineas.add(linea);
        //System.out.println("color" + this.colores[color] + " color: "+ color);
        
        
        for(Shape s:lineas) {
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
		Shape.setPaterno(paterno);
		Shape.color=color;
		//paterno 0
		if (paterno == 0) return;
		//paterno 1
		if (paterno == 1) {
			for (int i = 0; i < L; i+=2) {
				linea= new Linea(x1, y1-L+i, x1+L, y1-L+i);
		        lineas.add(linea);
		        
			}	
		}
		//paterno 2
		if (paterno == 2) {
			for (int i = 0; i < L/20; i++) {
				linea= new Linea(x1, y1-L+(i*20), x1+L, y1-L+(i*20));
		        lineas.add(linea);
		        
			}	
		}
		//paterno 3
		if (paterno == 3) {
			for (int i = 0; i < L/10; i++) {
				linea= new Linea(x1+(i*10), y1, x1+(i*10), y1-L);
		        lineas.add(linea);
		        
			}	
		}
		//paterno 4
		if (paterno == 4) {
			int cant=40;
			for (int i = 0; i <= L/cant; i++) {
				linea= new Linea(x1, y1-L+(i*cant), x1+L-(i*cant), y1);
		        lineas.add(linea);
		        
			}
			for (int i = 0; i < L/cant; i++) {
				linea= new Linea(x1+(i*cant), y1-L, x1+L, y1-(i*cant));
		        lineas.add(linea);
		        
			}
			
		}
		//paterno 5
		if (paterno == 5) {	
			int cant=40;
			for (int i = 0; i <= L/cant; i++) {
				linea= new Linea(x1, y1-(i*cant), x1+L-(i*cant), y1-L);
		        lineas.add(linea);
		        
			}
			for (int i = 0; i < L/cant; i++) {
				linea= new Linea(x1+(i*cant), y1, x1+L, y1-L+(i*cant));
		        lineas.add(linea);
		        
			}
		}
		//paterno 6
		if (paterno == 6) {
			//paterno 2
			for (int i = 0; i < L/20; i++) {
				linea= new Linea(x1, y1-L+(i*20), x1+L, y1-L+(i*20));
		        lineas.add(linea);
		        
			}
			//paterno 3
			for (int i = 0; i < L/20; i++) {
				linea= new Linea(x1+(i*20), y1, x1+(i*20), y1-L);
		        lineas.add(linea);
		        
			}		
		}
		//paterno 7
		if (paterno == 7) {
			//paterno 4
			int cant=40;
			for (int i = 0; i <= L/cant; i++) {
				linea= new Linea(x1, y1-L+(i*cant), x1+L-(i*cant), y1);
		        lineas.add(linea);
		        
			}
			for (int i = 0; i < L/cant; i++) {
				linea= new Linea(x1+(i*cant), y1-L, x1+L, y1-(i*cant));
		        lineas.add(linea);
		        
			}
			//paterno 5
			for (int i = 0; i <= L/cant; i++) {
				linea= new Linea(x1, y1-(i*cant), x1+L-(i*cant), y1-L);
		        lineas.add(linea);
		        
			}
			for (int i = 0; i < L/cant; i++) {
				linea= new Linea(x1+(i*cant), y1, x1+L, y1-L+(i*cant));
		        lineas.add(linea);
		        
			}
		}//if
	 
	}//fin estilo()

}