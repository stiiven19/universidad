package Homework_B05;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ActivitiesForm extends JFrame{

	JCheckBox	jbox[];
	JTextField	jtfield[];
	JButton		jb_send;
	JLabel		jl_text;
	
	public ActivitiesForm() {
		setTitle("Activities");
		setSize(550, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setupWidgets();
		setVisible(true);
	}

	private void setupWidgets() {
		
		jbox	= new JCheckBox[10];
		jtfield = new JTextField[10];
		jb_send = new JButton("Send Checklist");
		jl_text = new JLabel("List your activities and uncheck the irrelevant ones");
		
		for (int i = 0; i < jbox.length; i++) {
			jbox[i]			= new JCheckBox();
			jbox[i].setSelected(isEnabled());
			jtfield[i]		= new JTextField();
		}
		
		setLayout(new BorderLayout());
		JPanel check = new JPanel(new GridLayout(10,1));
		JPanel txtf  = new JPanel(new GridLayout(10,1));
		
		add(check,BorderLayout.WEST);
		add(txtf,BorderLayout.CENTER);
		add(jl_text,BorderLayout.NORTH);
		add(jb_send, BorderLayout.SOUTH);
		
		for (int i = 0; i < jbox.length; i++) {
			check.add(jbox[i]); txtf.add(jtfield[i]);
		}
	}
	public static void main(String[] args) {
		new ActivitiesForm();
	}
}
