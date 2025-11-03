package Graficos;

import java.awt.Graphics;
import java.util.ArrayList;

public class Trectangulo extends Shape {

	int x1,y1,L1,L2;
	private Shape linea;
	protected ArrayList<Shape> lineas;
    
    
    public Trectangulo(int x1, int y1, int L1, int L2) {
    	super(x1, y1-L1, 2, 2);
        this.x1 = x1;
        this.y1 = y1;
        this.L1 = L1;
        this.L2 = L2;
    }
    public void draw(Graphics g) {
    	lineas=new ArrayList<Shape>();
    	
    	linea= new Linea(x1, y1, x1, y1-L1);
        lineas.add(linea);//
        linea= new Linea(x1, y1, x1+L2, y1);
        lineas.add(linea);
        linea= new Linea(x1, y1-L1, x1+L2, y1);
        lineas.add(linea);
 
        for(Shape s:lineas) {
			s.draw(g);
		}
        if (this.isEstilo()) {
        	estilo(Shape.getPaterno(), Shape.getColor());
   	 	}
    }
	@Override
	public void estilo(int paterno, int color) {
		// TODO Auto-generated method stub
		
	}

}