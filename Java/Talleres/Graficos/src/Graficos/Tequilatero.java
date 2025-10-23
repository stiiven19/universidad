package Graficos;

import java.awt.Graphics;
import java.util.ArrayList;

public class Tequilatero extends Shape {

	int x1,y1,L;
	private Shape linea;
	protected ArrayList<Shape> lineas = new ArrayList<Shape>();;
    
    
    public Tequilatero(int x1, int y1, int L) {
    	super(x1, y1-L, 2, 2);
        this.x1 = x1;
        this.y1 = y1;
        this.L = L;
    }
    public void draw(Graphics g) {
    	
    	
    	 double y2;
    	 y2= Math.sqrt(   (Math.pow(L, 2)) - (Math.pow((L/2), 2))   );

    	 linea= new Linea(x1, y1, x1+(L/2),y1- (int) Math.round(y2));
         lineas.add(linea);
    	 linea= new Linea(x1, y1, x1+L, y1);
         lineas.add(linea);
         linea= new Linea(x1+(L/2),(y1-(int) Math.round(y2)), x1+L, y1);
         lineas.add(linea);
         
 
        for(Shape s:lineas) {
			s.draw(g);
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
			for (int i = 0; i < L/2; i+=1) {
				int L2;
		    	L2=(int) Math.round(i/Math.cos(Math.toRadians(60)));
		    	int y3;
		    	y3= (int) Math.round(Math.sqrt(   (Math.pow(L2, 2)) - (Math.pow(i, 2))   ));
				linea= new Linea(x1+i, y1-y3, x1+L-i, y1-y3);
		        lineas.add(linea);
		        
			}	
		}
		//paterno 2
		if (paterno == 2) {
			for (int i = 0; i < L/2; i+=10) {
				int L2;
		    	L2=(int) Math.round(i/Math.cos(Math.toRadians(60)));
		    	int y3;
		    	y3= (int) Math.round(Math.sqrt(   (Math.pow(L2, 2)) - (Math.pow(i, 2))   ));
				linea= new Linea(x1+i, y1-y3, x1+L-i, y1-y3);
		        lineas.add(linea);
		        
			}
		}
		//paterno 3
		if (paterno == 3) {
			for (int i = 0; i <= L/2; i+=10) {
				int L2;
		    	L2=(int) Math.round(i/Math.cos(Math.toRadians(60)));
		    	int y3;
		    	y3= (int) Math.round(Math.sqrt(   (Math.pow(L2, 2)) - (Math.pow(i, 2))   ));
		    	linea= new Linea(x1+i, y1, x1+i, y1-y3);
				lineas.add(linea);
				linea= new Linea(x1+L-i, y1, x1+L-i, y1-y3);
		        lineas.add(linea);

			}
		}
		//paterno 4
		if (paterno == 4) {
			int puntosx [] ;
			puntosx= new int [100] ;
			int puntosy [] ;
			puntosy= new int [100] ;
			int cont=0;
			for (int i = 0; i <= L/2; i+=10) {
				int L2;
		    	L2=(int) Math.round(i/Math.cos(Math.toRadians(60)));
		    	int y3;
		    	y3= (int) Math.round(Math.sqrt(   (Math.pow(L2, 2)) - (Math.pow(i, 2))   ));
		    	
				if (x1+(i*3)>x1+L) {
					linea= new Linea(x1+i, y1-y3, puntosx[cont]+L, puntosy[cont]);
					lineas.add(linea);
					cont+=2;
				}else {
					puntosx [i/10] = x1-i;
			    	puntosy [i/10] = y1-y3;
					linea= new Linea(x1+i, y1-y3, x1+(i*3), y1);
					lineas.add(linea);
					
				}
			}
			
		}
		//paterno 5
		if (paterno == 5) {	
			int puntosx [] ;
			puntosx= new int [100] ;
			int puntosy [] ;
			puntosy= new int [100] ;
			int cont=0;
			for (int i = 0; i <= L/2; i+=10) {
				int L2;
		    	L2=(int) Math.round(i/Math.cos(Math.toRadians(60)));
		    	int y3;
		    	y3= (int) Math.round(Math.sqrt(   (Math.pow(L2, 2)) - (Math.pow(i, 2))   ));
		    	
				if (x1+(i*3)>x1+L) {
					linea= new Linea(puntosx[cont], puntosy[cont],	 x1+L-i,y1-y3 );
					lineas.add(linea);
					cont+=2;
				}else {
					puntosx [i/10] = x1+i;
			    	puntosy [i/10] = y1-y3;
					linea= new Linea(x1+L-(i*3), y1, x1+L-i, y1-y3);
					lineas.add(linea);
					
				}
			}
		}
		//paterno 6
		if (paterno == 6) {
			for (int i = 0; i <= L/2; i+=10) {
				int L2;
		    	L2=(int) Math.round(i/Math.cos(Math.toRadians(60)));
		    	int y3;
		    	y3= (int) Math.round(Math.sqrt(   (Math.pow(L2, 2)) - (Math.pow(i, 2))   ));
				linea= new Linea(x1+i, y1-y3, x1+L-i, y1-y3);
		        lineas.add(linea);
		        linea= new Linea(x1+i, y1, x1+i, y1-y3);
				lineas.add(linea);
				linea= new Linea(x1+L-i, y1, x1+L-i, y1-y3);
		        lineas.add(linea);
			}	
		}
		//paterno 7
		if (paterno == 7) {
			int puntosx [] ;
			puntosx= new int [100] ;
			int puntosy [] ;
			puntosy= new int [100] ;
			int cont=0;
			for (int i = 0; i <= L/2; i+=10) {
				int L2;
		    	L2=(int) Math.round(i/Math.cos(Math.toRadians(60)));
		    	int y3;
		    	y3= (int) Math.round(Math.sqrt(   (Math.pow(L2, 2)) - (Math.pow(i, 2))   ));
		    	
				if (x1+(i*3)>x1+L) {
					linea= new Linea(puntosx[cont], puntosy[cont],	 x1+L-i,y1-y3 );
					lineas.add(linea);
					cont+=2;
				}else {
					puntosx [i/10] = x1+i;
			    	puntosy [i/10] = y1-y3;
					linea= new Linea(x1+L-(i*3), y1, x1+L-i, y1-y3);
					lineas.add(linea);
					
				}
			}
			cont=0;
			for (int i = 0; i <= L/2; i+=10) {
				int L2;
		    	L2=(int) Math.round(i/Math.cos(Math.toRadians(60)));
		    	int y3;
		    	y3= (int) Math.round(Math.sqrt(   (Math.pow(L2, 2)) - (Math.pow(i, 2))   ));
		    	
				if (x1+(i*3)>x1+L) {
					linea= new Linea(x1+i, y1-y3, puntosx[cont]+L, puntosy[cont]);
					lineas.add(linea);
					cont+=2;
				}else {
					puntosx [i/10] = x1-i;
			    	puntosy [i/10] = y1-y3;
					linea= new Linea(x1+i, y1-y3, x1+(i*3), y1);
					lineas.add(linea);
					
				}
			}
		}//if*/
	 
	}//fin estilo()

}