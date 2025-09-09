package cw01_mdi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class AboutFrame extends JInternalFrame{
 
	private JLabel		lb_info[],lb;
	private JButton		bt_next;
	
	//---------------------------------------------------------
	public AboutFrame() {
		super("About", false, true, false, true);
		setSize(300, 100);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}
	//-------------------------------------------------------------
	private void setupWidgets() {
		
		lb = new JLabel();
		lb_info		= new JLabel[3];
		lb_info[0]= new JLabel("University Of Nariño");
		lb_info[1]= new JLabel("Programa: Ingenieria de Systemas");
		lb_info[2]= new JLabel("Name: Steven Guerrero");
		bt_next		= new JButton("Next");
		
		add(lb,BorderLayout.CENTER);
		add(bt_next,BorderLayout.SOUTH);
	}
	//-----------------------------------------------------------------
	private void setupEvents() {
		
		bt_next.addActionListener(new ActionListener() {
			int i=-1;	
			@Override
			public void actionPerformed(ActionEvent e) {
				i++;
				if(i<=2) {
					lb.setText(lb_info[i].getText());
					if (i==2) {
						i=-1;
					
				}
				}
				
				
			}
		});
		
	}
	
}
