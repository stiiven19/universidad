package cw05_sight_complete;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SightWindow extends JFrame {

	private JButton bt_left,bt_rigth,bt_up,bt_down;
	private JLabel lb_sight;
	//................................
	public SightWindow() {
		setTitle("Gun Sight");
		setSize(400, 450);
		setupWidgets();
		setupEvents();
		setVisible(true);
		
	}
	private void setupEvents() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//--------------------------------------------------------------------------------------
		bt_left.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Rectangle rec=lb_sight.getBounds();
				rec.x-=1;
				lb_sight.setBounds(rec);
			}
		});
		
		bt_rigth.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Rectangle rec=lb_sight.getBounds();
				rec.x+=1;
				lb_sight.setBounds(rec);
			}
		});
		
		bt_down.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Rectangle rec=lb_sight.getBounds();
				rec.y+=1;
				lb_sight.setBounds(rec);
			}
		});
		
		bt_up.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Rectangle rec=lb_sight.getBounds();
				rec.y-=1;
				lb_sight.setBounds(rec);
				//lb_sight.setText("gay");
				//lb_sight.setFont(new Font("arial,",2,20));
				//lb_sight.setHorizontalTextPosition(SwingConstants.CENTER);
			}
		});
	}
	private void setupWidgets() {
		
		bt_left  =new JButton();
		bt_rigth =new JButton();
		bt_up    =new JButton();
		bt_down  =new JButton();
		lb_sight =new JLabel();
		setLayout(null);
		
		add(bt_left); bt_left.setBounds(20, 160, 80, 80);
		add(bt_rigth); bt_rigth.setBounds(300, 160, 80, 80);
		add(bt_up); bt_up.setBounds(160, 20, 80, 80);
		add(bt_down); bt_down.setBounds(160, 300, 80, 80);
		add(lb_sight); lb_sight.setBounds(160, 160, 80, 80);
		
		bt_left.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/left.png")));
		bt_rigth.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/right.png")));
		bt_up.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/up.png")));
		bt_down.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/down.png")));
		lb_sight.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/icon.png")));
	}
	public static void main(String[] args) {
		new SightWindow();
	}
	
}
