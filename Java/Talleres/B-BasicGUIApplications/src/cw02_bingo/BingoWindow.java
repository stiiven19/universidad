package cw02_bingo;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class BingoWindow extends JFrame{

	private JLabel [] 	letters;
	private JLabel[][]	numbers;
	private Color[]	colors;

	
	public BingoWindow() {
		
		setSize(400, 400);
		setLocationRelativeTo(null);
		setTitle("BINGO WINDOW");
		setupWidgets();
		setupEvents();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void setupEvents() {
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_F5) {
					Random random = new Random();
					for (int row = 0; row < 5; row++) {	
						for (int col = 0; col < 5; col++) {
							int number = random.nextInt(20)+(col*20);
							numbers[row][col].setText(""+number);
						}
					}
					JOptionPane.showMessageDialog(null, "Generado Exitosamente");
				}
				
			}
		});
	letters[0].addMouseWheelListener(new MouseWheelListener() {
		
		@Override
		public void mouseWheelMoved(MouseWheelEvent a) {
			System.out.println(a.getWheelRotation());
			System.out.println(a.getScrollType());
			
		}
	});
	}

	private void setupWidgets() {
		
		letters = new JLabel[5];
		numbers = new JLabel[5][5];
		colors 	= new Color [5];
		addColors();
		setLayout(new GridLayout(6,5));
		String bingo="BINGO";
		Random number = new Random();
		//_____________________________________________________________________
		for (int i = 0; i < 5; i++) {
			letters[i]=new JLabel();
			letters[i].setText(""+bingo.charAt(i));
			letters[i].setHorizontalAlignment(SwingConstants.CENTER);
			letters[i].setOpaque(true);
			letters[i].setFont(new Font("Arial Black",1,40));
			letters[i].setBackground(colors[i]);
			add(letters[i]);
		}
		//--------------------------------------------------------------------------
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
//				numbers[i][j].setOpaque(true);
				numbers[i][j]=new JLabel();
				if (i!=2 || j!=2) {
					numbers[i][j].setText(""+(number.nextInt(20)+(20*j)));
					numbers[i][j].setHorizontalAlignment(SwingConstants.CENTER);
					numbers[i][j].setForeground(colors[j]);
					add(numbers[i][j]);
				}else{
					numbers[i][j].setText("FREE");
					numbers[i][j].setHorizontalAlignment(SwingConstants.CENTER);
					add(numbers[i][j]);	
				}				
				numbers[i][j].setFont(new Font("Arial Black",1,20));
				
			}
		}
	}
	
	private void addColors(){
		colors[0]=Color.red;
		colors[1]=Color.yellow;
		colors[2]=Color.green;
		colors[3]=Color.blue;
		colors[4]=Color.magenta;
	}
	
	public static void main(String[] args) {
		
		
			new BingoWindow();
		
		
		
	}
}
