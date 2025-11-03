package Graficos;


import java.awt.Graphics;
import java.util.ArrayList;

public class Linea extends Shape{

	int x1,y1, x2, y2, widht,height;
	private Shape pixel;
	protected ArrayList<Shape> pixels;
	
	public Linea(int x1, int y1, int x2, int y2) {
		super(x1, y1, 2, 2);
		this.x1 = x1;
		this.y1 = y1;
	    this.x2 = x2;
		this.y2 = y2;
		this.widht = 2;
		this.height = 2;
		
	}
	
	
	
	public void draw(Graphics g) {
		pixels=new ArrayList<Shape>();

        int guardado=-10;
        float M=0,y=y1;
        if(x1>x2){
            guardado=x1;
            x1=x2;
            x2=guardado;
            
            guardado=y2;
            y2=y1;
            y1=guardado;
            y=y1;
        }
        //System.out.println("y1: "+y1);
        //System.out.println("y2: "+y2);
        //System.out.println("x1: "+x1);
        //System.out.println("x2: "+x2);
        
        //System.out.println("M: ("+y1+" - "+y2+")/"+x2+" - "+x1+";");
        
        M=(float)(y2-y1)/(x2-x1);
        int h=y1;
        boolean band;
        
        band = y2>y1;
        if(M == Double.NEGATIVE_INFINITY || M==Double.POSITIVE_INFINITY){
            M=0;
            h=y2;
        }
        //System.out.println(band );
        for (int j = x1; j <= x2; j++) {
            y=M*(j-x1)+y1;
            
            //System.out.println("-------------------------------------");
            //System.out.println("y: M*("+j+" - "+x1+")+"+y1);
            //System.out.println("M: "+M);
            //System.out.println("x: "+j);
            //System.out.println("y: "+y);
            //System.out.println("-------------------------------------");
            pixel= new Pixel(j, Math.round(y), color);
            pixels.add(pixel);

            //System.out.println(""+y+" - "+h+" = "+(y-h>1));
            if(band){//bajando
            	if(x1-x2==0) {
                	h=y2;
                	for (int i = Math.round(y); i <= h; i++) {
                        //System.out.println("j,i "+j+" , "+i);
                        pixel= new Pixel(j, i, color);
                        pixels.add(pixel);
                    }
            	}
                if(y-h>1){
                for (int i = h; i <= Math.round(y); i++) {
                    //System.out.println("j,i "+j+" , "+i);
                    pixel= new Pixel(j, i, color);
                    pixels.add(pixel);
                }
            }
            }else if(!band){//subiendo
                //System.out.println("entro");//y=y1--h=y2-- y2 es menor que y1  // h es menor que y
                if(x1-x2==0) {
                	h=y2;
                	for (int i = h; i <= y; i++) {
                        //System.out.println("j,i "+j+" , "+i);
                        pixel= new Pixel(j, i, color);
                        pixels.add(pixel);
                    }
                }
                if(h-y>1){
                    for (int i = Math.round(y); i <= h; i++) {
                        //System.out.println("j,i "+j+" , "+i);
                        pixel= new Pixel(j, i, color);
                        pixels.add(pixel);
                    }
                    
                }
            }
            
            h=Math.round(y);
        }
	    for(Shape s:pixels) {
			s.draw(g);
		}
    }



	@Override
	public void estilo(int paterno, int color) {
		
	}	
    
	
}
		
