package Graficos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;



public class FrameShapes extends JFrame {

	private DrawingPanel panel;
	private Shape	current;
		
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrameShapes frame = new FrameShapes();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
}
		public FrameShapes() {
			setTitle("Drawing Shapes");
			setResizable(true);
			setBounds(100, 100, 704, 448);
			setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
			panel = new DrawingPanel();			
			panel.setFocusable(true);
			
			//current = new Pixel (100,100,1);
			//current = new Linea (100,100,300,100);
			//current = new Rectangulo(200,400,400,100);
			current = new Cuadrado(200, 200, 200);
			panel.addShape(current);
			//current = new Trectangulo(200, 300, 150, 250);
			current = new Tequilatero(200, 300, 200);
			//current = new Pentagono(200, 300, 50);
			
			panel.addShape(current);
			//int x[] = {20,20,80,10,100,15,130,50,110,60}; current = new Poligono(x, 4);
			current = new Circulo(300, 200, 50);
			panel.addShape(current);
			//current = new Cubo(200, 300, 100);
			//current = new Cubop(200, 300, 100, 300);
			//current.estilo(1, 6);
			current.estilo(7, 5);
			//panel.addShape(current);
			//current = new Linea (300,100,300,10);
			//panel.addShape(current);
			getContentPane().add(panel,BorderLayout.CENTER);
			addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					System.out.println(e.getLocationOnScreen());
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});

		}

	}