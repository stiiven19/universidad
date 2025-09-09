package ex03_settings;


import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SettingsFrame extends JFrame{

	private JLabel		lbonline,lbcheck,lbauto,lbcontent;
	private Switcher	sw1,sw2,sw3,sw4;
	
	public SettingsFrame() {
		setTitle("Settings");
		setSize(200, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}

	private void setupEvents() {
		
		
	}

	private void setupWidgets() {
		lbonline	= new JLabel("  Online Help");
		lbcheck		= new JLabel("  Check Spelling");
		lbauto		= new JLabel("  Auto Save");
		lbcontent	= new JLabel("  Content Assist");
		
		sw1			= new Switcher(false);
		sw2			= new Switcher(true);
		sw3			= new Switcher(false);
		sw4			= new Switcher(true);
		
		setLayout(new GridLayout(4,2));
		
		add(lbonline);	add(sw1);
		add(lbcheck);	add(sw2);
		add(lbauto);	add(sw3);
		add(lbcontent);	add(sw4);
		
	}
	public static void main(String[] args) {
		new SettingsFrame();
	}
}
