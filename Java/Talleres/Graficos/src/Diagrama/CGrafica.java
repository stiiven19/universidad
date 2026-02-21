
package Diagrama;


import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;
//import cgrafica.Pixel.java;

public class CGrafica extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
        
        //private final Linea line;
	
	public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        CGrafica frame = new CGrafica();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
	}

	
	public CGrafica() {
		
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Draw Frame");
		setBounds(100, 100, 636, 659);
                
                //setLayout(new FlowLayout());
                
                
                //Pixel pixeli = new Pixel(300,300,4);
                //Pixel pixele= new Pixel(400, 400, 4);
                
                /*JPanel panel = new JPanel();
                add(panel);
		Applet line = new Linea (100,100,300,100);
                Applet line2 = new Linea (300,100,300,10);
                add(line);
                add(line2);*/
                
                int x1,x2,y1,y2;
                x1=100;x2=300;
                y1=100;y2=10;
                
                //panel.setSize(this.getSize());
                //line.setBounds(100, 300, 10, 10);
                //panel.add(line);
                //panel.add(line2);
                //panel.repaint();
                
                /*Rectangulo rect = new Rectangulo(200,100,400,10);
                add(rect);*/
		/*Linea l1,l2,l3,l4;
                l1= new Linea(x1, y1, x2, y1);
                l2= new Linea(x2, y1, x2, y2);l2.repint();
                l3= new Linea(x2, y2, x1, y2);l3.repint();
                l4= new Linea(x1, y2, x1, y1);l4.repint();
                
		//add(pixeli);
                //add(pixele);
                //add(line);
                
                //add(line);
                JPanel panel = new JPanel(null);
                
                panel.add(l1);l1.setBounds(0, 0, 20, 20);
                panel.add(l2);l2.setBounds(100,y2, 10, 10);
                panel.add(l3);l3.setBounds(200,y2, 10, 10);
                panel.add(l4);l4.setBounds(300,y2, 10, 10);
                add(panel,BorderLayout.CENTER);*/
                
                //Pixel pixel = new Pixel(getWidth()/2,getHeight()/2,4);
                
		Rectangulo rectangulo = new Rectangulo(x1, y1, x2, y2);
		          add(rectangulo);
		
		
		
		
		
		
		
			
/*		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.add(line);
*/
		
	}
}


