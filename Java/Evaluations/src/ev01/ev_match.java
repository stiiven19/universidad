package ev01;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ev_match extends JFrame {

	JLabel		lb_sight,lb_match;
	
	public ev_match() {
		// TODO Auto-generated constructor stub
		setTitle("Match Objects");
		setSize(400, 400);
		setupWidgets();
		setupEvents();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	private void setupWidgets() {
		// TODO Auto-generated method stub
		lb_match = new JLabel();
		lb_sight = new JLabel();
		
		setLayout(null);
		
		add(lb_match);
		add(lb_sight);
		
		lb_sight.setBounds(150, 150, 64, 64);
		Random x = new Random();
		Random y = new Random();
		lb_match.setBounds(x.nextInt(336), y.nextInt(336), 45, 45);
		
		ImageIcon img= new ImageIcon("images/mariquita.png");
		ImageIcon img2=new ImageIcon(img.getImage().getScaledInstance(lb_match.getWidth(),lb_match.getHeight(), java.awt.Image.SCALE_SMOOTH));
		lb_match.setIcon(img2);
		
		ImageIcon img3= new ImageIcon("images/objetivo.png");
		ImageIcon img4=new ImageIcon(img3.getImage().getScaledInstance(lb_sight.getWidth(),lb_sight.getHeight(), java.awt.Image.SCALE_SMOOTH));
		lb_sight.setIcon(img4);
		
	}
			
	private void setupEvents() {
		Rectangle r = lb_sight.getBounds();
		Rectangle r2= lb_match.getBounds();
		
		ImageIcon img5= new ImageIcon("images/lugar.png");
		ImageIcon img6=new ImageIcon(img5.getImage().getScaledInstance(lb_match.getWidth(),lb_match.getHeight(), java.awt.Image.SCALE_SMOOTH));
		addKeyListener(new KeyListener() {
			
			
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_UP) {
					r.y-=2;
					lb_sight.setBounds(r);
				}
				if (e.getKeyCode()==KeyEvent.VK_DOWN) {
					r.y+=2;
					lb_sight.setBounds(r);				
				}
				if (e.getKeyCode()==KeyEvent.VK_LEFT) {
					r.x-=2;
					lb_sight.setBounds(r);
				}
				if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
					r.x+=2;
					lb_sight.setBounds(r);
				}
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					Rectangle r3=  lb_sight.getBounds();
					r3.height=10;
					r3.width=10;
					r3.x+=28;
					r3.y+=52;
					if (r3.getX()<=(r2.getX()+lb_match.getHeight()-3) && r3.getX()>=r2.getX() && r3.getY()>=(r2.getY()+26) && r3.getY()<=(r2.getY()+lb_match.getHeight()+25)){
						lb_match.setIcon(img6);
					}
				}
			}
		});
	}
	public static void main(String[] args) {
		new ev_match();
	}
}
