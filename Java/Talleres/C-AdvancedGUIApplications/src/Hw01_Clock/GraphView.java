package Hw01_Clock;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class GraphView extends JFrame{

	Polygon numbers[];
	
	public GraphView() {
		setTitle("Digital Clock");
		setSize(410, 260);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}

	private void setupWidgets() {
		numbers 	= new Polygon[4];
		numbers[0]	= new Polygon(0); 
		numbers[1]	= new Polygon(0); 	
		numbers[2]	= new Polygon(2);
		numbers[3]	= new Polygon(1);
		
		setLayout(new GridLayout(1,4));
		add(numbers[0]);
		add(numbers[1]);
		add(numbers[2]);
		add(numbers[3]);
		//numbers[0].paint(g);
	}

	private void setupEvents() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new GraphView();
	}
}
