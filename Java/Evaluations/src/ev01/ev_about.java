package ev01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ev_about extends JFrame{

	JLabel		lb_pant, lb_chooser[];
	JButton		bt_next;
	
	public ev_about() {
		setTitle("About");
		setSize(300, 100);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}

	private void setupWidgets() {
		lb_pant =  new JLabel("");
		lb_chooser= new JLabel[3];
		lb_chooser[0] = new JLabel("University of Nariño");
		lb_chooser[1] = new JLabel("Program: Ingenieria de sistemas");
		lb_chooser[2] = new JLabel("Student: Steven Andres Guerrero Crux");
		bt_next	= new JButton("Next");
		
		setLayout(new BorderLayout());
		
		add(lb_pant,BorderLayout.CENTER);
		add(bt_next,BorderLayout.SOUTH);
		
	}

	private void setupEvents() {
		bt_next.addActionListener(new ActionListener() {
			int i=0;
			@Override
			public void actionPerformed(ActionEvent e) {
				if (i==3) {
					i=0;
				}
				if (i<=2) {
					lb_pant.setText(lb_chooser[i].getText());
					i++;
				}
			}
		});
		
	}
	public static void main(String[] args) {
		new ev_about();
	}
}
