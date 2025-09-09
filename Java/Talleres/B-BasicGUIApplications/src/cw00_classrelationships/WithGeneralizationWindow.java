package cw00_classrelationships;

import javax.swing.JFrame;

public class WithGeneralizationWindow extends JFrame{

	public WithGeneralizationWindow() {
		
		super("Creating Window by means Generalization");
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		
	public static void main(String[] args) {
		new WithGeneralizationWindow();
	}
	

}
