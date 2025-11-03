package cw03_sight;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;



public class SightWindow extends JFrame{
	private JButton 	bt_left, bt_right, bt_up, bt_down;
	private JLabel		lb_sight;
	
	public SightWindow() {
		setTitle("Gun Sight");
		setSize(400, 450);
		setupWidgets();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void setupWidgets() {
		// crear
		bt_left		= new JButton();
		bt_up		= new JButton();
		bt_right	= new JButton();
		bt_down		= new JButton();
		lb_sight	= new JLabel();
		
		setLayout(null);
		
		//icons
		bt_left.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/left.png")));
		bt_up.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/up.png")));
		bt_right.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/right.png")));
		bt_down.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/down.png")));
		lb_sight.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/icon.png")));
		lb_sight.setHorizontalAlignment(SwingConstants.CENTER);
		//alineaciones
		lb_sight.setBounds(160, 160, 80, 80);
		bt_left.setBounds(20, 160, 80, 80);	
		bt_right.setBounds(300, 160, 80, 80);
		bt_up.setBounds(160, 20, 80, 80);
		bt_down.setBounds(160, 300, 80, 80);
		//agregar
		add(bt_up);
		add(bt_left); add(lb_sight); add(bt_right);
		add(bt_down);
		
	}
	public static void main(String[] args) {
		new SightWindow();
	}
}
