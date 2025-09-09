package Hw03_ballon;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ballonWindow extends JFrame{
	
	private BallonsDraw	bd1,bd2,bd3;
	
	public ballonWindow() {
	setTitle("Ballon Test");
	setSize(400, 300);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setupWidgets();
	setupEvents();
	setVisible(true);
	}

	private void setupWidgets() {
		bd1		= new BallonsDraw(20,0,100,Color.RED,10);
		bd2		= new BallonsDraw(85,0,100,Color.BLUE,5);
		bd3		= new BallonsDraw(65,0,100,Color.orange,1);
		
		setLayout(new GridLayout(2,3));
		add(bd1);
		add(bd2);
		add(bd3);
                add(new JLabel("Use Scrooll in your mouse"));
		
	}

	private void setupEvents() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new ballonWindow();
	}
}
