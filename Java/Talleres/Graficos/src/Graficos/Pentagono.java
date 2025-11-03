package Graficos;

import java.awt.Graphics;
import java.util.ArrayList;

public class Pentagono extends Shape {

	int x1,y1,L;
	private Shape linea;
	protected ArrayList<Shape> lineas;
    
    
    public Pentagono(int x1, int y1, int L) {
    	super(x1, y1-L, 2, 2);
        this.x1 = x1;
        this.y1 = y1;
        this.L = L;
    }
    public void draw(Graphics g) {
    	lineas=new ArrayList<Shape>();
    	
    	double co = (Math.sin(Math.toRadians(72)))*L;
    	double ca = (Math.cos(Math.toRadians(72)))*L;
    	//System.out.println("co: "+ co + " ca: "+ ca);
    	int l1 = (x1+(L/2))-(x1-(int)Math.round(ca));
        double y2;
    	y2= Math.sqrt(  (Math.pow(L, 2))-(Math.pow(l1, 2))  );
    	//System.out.println((L^2)+" - "+((L/2)^2)+" = "+ y2 + " int:  "+(int) Math.round(y2));
    	linea= new Linea(x1, y1, x1+L, y1);
        lineas.add(linea);
    	linea= new Linea(x1+L, y1, x1+L+(int)Math.round(ca), y1-(int)Math.round(co));
        lineas.add(linea);
        linea= new Linea(x1-(int)Math.round(ca), y1-(int)Math.round(co), x1, y1);
        lineas.add(linea);
        linea= new Linea(x1-(int)Math.round(ca), y1-(int)Math.round(co), x1+(L/2), y1-(int)Math.round(co)-(int)Math.round(y2));
        lineas.add(linea);
        linea= new Linea(x1+(L/2), y1-(int)Math.round(co)-(int)Math.round(y2), x1+L+(int)Math.round(ca), y1-(int)Math.round(co));
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