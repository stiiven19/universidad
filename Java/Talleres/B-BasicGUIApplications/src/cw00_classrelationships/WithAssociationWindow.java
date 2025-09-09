package cw00_classrelationships;

import javax.swing.JFrame;

public class WithAssociationWindow {

	private JFrame fm_main;
	
	public WithAssociationWindow() {
		fm_main=new JFrame("Creating a window by means of association");
		fm_main.setSize(400, 300);
		fm_main.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new WithAssociationWindow();
	}
	
}
