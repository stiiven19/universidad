package ex02_oscilloscope2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class GraphicView extends JFrame{

	private seno 		graph ;
	private JLabel		lb_top,lb_bot,lb_right,lb_left;
	
	public GraphicView() {
	
		setTitle("                                                                     Funtion sine");
		setSize(570, 420);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}

	private void setupWidgets() {
		double A	= (double)Integer.parseInt(JOptionPane.showInputDialog(null, "De y = A.Sen(Bx+C) \nDigite: A", "Funtion sen", JOptionPane.QUESTION_MESSAGE ));
		double B	= (double)Integer.parseInt(JOptionPane.showInputDialog(null, "De y = A.Sen(Bx+C) \nDigite: B", "Funtion sen", JOptionPane.QUESTION_MESSAGE ));
		double P	= 2*Math.PI/Math.abs(B);
		double C	= (double)Integer.parseInt(JOptionPane.showInputDialog(null, "De y = A.Sen(Bx+C) \nDigite: B", "Funtion sen", JOptionPane.QUESTION_MESSAGE ));
		double D	=  C/B;
		graph 		= new seno(A,P,D,B,C,80);
		lb_top		= new JLabel(" ");
		lb_left		= new JLabel("    ");
		lb_right	= new JLabel("    ");
		lb_bot		= new JLabel(" ");
		
		JPanel pn_center = new JPanel(new BorderLayout());
		
		add(pn_center);
		add(lb_bot,BorderLayout.SOUTH);
		add(lb_left,BorderLayout.WEST);
		add(lb_right,BorderLayout.EAST);
		add(lb_top,BorderLayout.NORTH);
		
		lb_top.setFont(new Font("arial", 0, 20));
		lb_left.setFont(new Font("arial", 0, 20));
		lb_right.setFont(new Font("arial", 0, 20));
		lb_bot.setFont(new Font("arial", 0, 20));
		
		lb_top.setBackground(Color.GRAY);
		lb_bot.setBackground(Color.GRAY);
		lb_left.setBackground(Color.GRAY);
		lb_right.setBackground(Color.GRAY);
		pn_center.setBackground(Color.WHITE);
		
//		pn_center.setBorder(new MatteBorder(30, 30, 30, 30, new Color(225, 225, 225) ));
		pn_center.add(graph);
	}

	private void setupEvents() {
		// TODO Auto-generated method stub
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_UP) {
					
				}
				
			}
		});
	}
	public static void main(String[] args) {
		new GraphicView();
	}
}
