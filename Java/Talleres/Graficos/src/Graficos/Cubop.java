package Graficos;

import java.awt.Graphics;
import java.util.ArrayList;

public class Cubop extends Shape {

	int x1,y1,L,p;
	private Shape cuadrado;
	private Shape linea;
	protected ArrayList<Shape> figuras;
    
    
    public Cubop(int x1, int y1, int L, int p) {
    	super(x1, y1, 2, 2);
        this.x1 = x1;
        this.y1 = y1;
        this.L = L;
        this.p = p;
    }
    public void draw(Graphics g) {
    	figuras=new ArrayList<Shape>();
    	
    	cuadrado = new Cuadrado(x1, y1, L);
    	figuras.add(cuadrado);
    	cuadrado = new Cuadrado(x1+p, y1-(L/2), L);
    	figuras.add(cuadrado);
    	
    	linea = new Linea(x1, y1, x1+p, y1-(L/2));
    	figuras.add(linea);
    	linea = new Linea(x1, y1-L, x1+p, y1-(L/2)-L);
    	figuras.add(linea);
    	linea = new Linea(x1+L, y1, x1+p+L, y1-(L/2));
    	figuras.add(linea);
    	linea = new Linea(x1+L, y1-L, x1+p+L, y1-(L/2)-L);
    	figuras.add(linea);
    	 
        for(Shape s:figuras) {
			s.draw(g);
		}
        
    }
	@Override
	public void estilo(int paterno, int color) {
		// TODO Auto-generated method stub
		
	}

}