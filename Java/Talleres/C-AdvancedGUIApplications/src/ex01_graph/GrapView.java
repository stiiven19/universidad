package ex01_graph;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class GrapView extends JFrame{
	
	
		public GrapView() {
		setTitle("Graph Viewer");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}
	private void setupWidgets() {
		setLayout(new GridLayout(2,2));
		add(new Emoji());
		add(new ColombianFlag());
		add(new Horizon());
		add(new Sand());
			
		}
	private void setupEvents() {
			// TODO Auto-generated method stub
			
		}
	public static void main(String[] args) {
		new GrapView();
	}
}
