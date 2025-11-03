package Graficos;

import java.awt.Graphics;
import java.util.ArrayList;

public class Poligono extends Shape {

	
	private Shape linea;
	protected ArrayList<Shape> lineas;
    int puntos[], lados;
    
    public Poligono(int puntos[], int lados) {
    	super(puntos[0], puntos[1], 2, 2);
    	this.puntos=puntos;
    	this.lados=lados;
    }
    public void draw(Graphics g) {
    	lineas=new ArrayList<Shape>();
         
    	for (int i = 0; i < (lados*2)-2; i+=2) {
    		linea= new Linea(puntos[i], puntos[i+1], puntos[i+2], puntos[i+3]);
            lineas.add(linea);
		}

    	linea= new Linea(puntos[0], puntos[1],puntos[(lados*2)-2], puntos[(lados*2)-1]);
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