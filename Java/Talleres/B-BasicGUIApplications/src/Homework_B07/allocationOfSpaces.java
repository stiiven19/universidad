package Homework_B07;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class allocationOfSpaces extends JFrame{

	private JLabel				lb_fSpaces,lb_TSpaces;
	private JComboBox<String>	cb_fSpaces,cb_TSpaces;
	private JButton				bt_fSpaces,bt_tSpaces;
	private String				Spaces[];
	
	public allocationOfSpaces() {
		setTitle("Allocation Of  Spaces");
		setSize(400, 160);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}

	private void setupWidgets() {
		Spaces 			= new String[5];
		Spaces[0]="Coliseo";
		Spaces[1]="Piscina";
		Spaces[2]="Cancha";
		Spaces[3]="Hotel";
		Spaces[4]="Coctel";
		
		lb_fSpaces		= new JLabel("Free Spaces");
		lb_TSpaces		= new JLabel("Taked Spaces");
		cb_fSpaces		= new JComboBox<String>(Spaces);
		cb_TSpaces		= new JComboBox<String>();
		bt_fSpaces		= new JButton("Take Space ->");
		bt_tSpaces		= new JButton("<- Free Space");
		
		setLayout(null);
		
		lb_fSpaces.setBounds(20, 20, 160, 20);lb_TSpaces.setBounds(200, 20, 160, 20);
		cb_fSpaces.setBounds(20, 40, 160, 20);cb_TSpaces.setBounds(200, 40, 160, 20);
		bt_fSpaces.setBounds(20, 80, 160, 20);bt_tSpaces.setBounds(200, 80, 160, 20);
		
		add(lb_fSpaces);add(lb_TSpaces);
		add(cb_fSpaces);add(cb_TSpaces);
		add(bt_fSpaces);add(bt_tSpaces);
		
	}

	private void setupEvents() {
		bt_fSpaces.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cb_fSpaces.getItemCount()!=0) {
					int index=cb_fSpaces.getSelectedIndex();
					cb_TSpaces.addItem(cb_fSpaces.getItemAt(index));
					cb_fSpaces.removeItemAt(index);	
				}else {
					JOptionPane.showMessageDialog(null, "There isn't elements","Error",0);
				}
			}
		});
		bt_tSpaces.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cb_TSpaces.getItemCount()!=0) {
					int index=cb_TSpaces.getSelectedIndex();
					cb_fSpaces.addItem(cb_TSpaces.getItemAt(index));
					cb_TSpaces.removeItemAt(index);	
				}else {
					JOptionPane.showMessageDialog(null, "There isn't elements","Error",0);
				}
				
			}
		});
	}
	public static void main(String[] args) {
		new allocationOfSpaces();
	}
}
