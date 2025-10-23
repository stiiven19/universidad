package Graficos;

import java.awt.Graphics;
import java.util.ArrayList;

public class Rectangulo extends Shape {

	int x1,y1, x2, y2, widht,height;
	private Shape linea;
	protected ArrayList<Shape> lineas;
    
    
    public Rectangulo(int x1, int y1, int x2, int y2) {
    	super(x1, y2, 2, 2);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.widht = 2;
		this.height = 2;
    }
    public void draw(Graphics g) {
    	lineas=new ArrayList<Shape>();
    	
        linea= new Linea(x1, y1, x2, y1);
        lineas.add(linea);
        linea= new Linea(x2, y1, x2, y2);
        lineas.add(linea);
        linea= new Linea(x1, y2, x2, y2);
        lineas.add(linea);
        linea= new Linea(x1, y2, x1, y1);
        lineas.add(linea);
        
        for(Shape s:lineas) {
			s.draw(g);
		}
    
    }
	@Override
	public void estilo(int paterno, int color) {
		// TODO Auto-generated method stub
		
	}

}