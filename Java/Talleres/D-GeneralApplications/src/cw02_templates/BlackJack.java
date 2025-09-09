package cw02_templates;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BlackJack extends Template{
	
	private JLabel lb_heap;
	private JLabel lb_cards[];
	int suma=0;

	
	public BlackJack(MDIFrame fr_handle) {
		super(fr_handle,"Black Jack", "You must collect 21 points to win");
		setSize(400, 250);
		setupWidgets();
		setupEvents();
		
	}

	private void setupEvents() {
		lb_heap.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Random r = new Random();
				
				for (int i = 0; i < 13*4; i++) {
					
					if (lb_cards[i]==null && suma<=21) {
						lb_cards[i]=new JLabel();
						add(lb_cards[i]);
						int card = r.nextInt(13);
						int suit = r.nextInt(4);
						String suitchar[]= {"h","c","s","d"};	
						lb_cards[i].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("deck/"+card+suitchar[suit]+".png")));
						lb_cards[i].setBounds(150+i*30, 30+i*10, 106, 162);
						
						suma+=card;
						if (suma>21) {
							JOptionPane.showMessageDialog(null,"Perdiste Gay");
							dispose();
							new BlackJack(fr_handle);
						}
						if (suma==21) {
							JOptionPane.showMessageDialog(null,"Ganaste gay");
							dispose();
							new BlackJack(fr_handle);
						}
						break;
					}
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			}
		});
		
	}

	private void setupWidgets() {
		setLayout(null);
		lb_heap = new JLabel();
		add(lb_heap);
		lb_heap.setBounds(50, 50, 106, 162);
		lb_heap.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("deck/back.png")));
		lb_cards= new JLabel[13*4];
		
		
		
	}
}
