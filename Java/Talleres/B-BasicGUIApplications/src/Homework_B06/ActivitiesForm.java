package Homework_B06;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ActivitiesForm extends JFrame{

	JCheckBox	jbox[];
	JTextField	jtfield[];
	JButton		jb_send;
	JLabel		jl_text;
	
	public ActivitiesForm() {
		setTitle("Activities");
		setSize(550, 330);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}

	private void setupEvents() {
		for (int i = 0; i < jbox.length; i++) {
			int j=i;
			jbox[i].addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					
					boolean change =jbox[j].isSelected();
					if (change) {
						jtfield[j].setEnabled(true);
					}else{
						jtfield[j].setEnabled(false);
					}
				}
			});
		}
	}

	private void setupWidgets() {
		
		jbox	= new JCheckBox[10];
		jtfield = new JTextField[10];
		jb_send = new JButton("Send Checklist");
		jl_text = new JLabel("List your activities and uncheck the irrelevant ones");
		
		for (int i = 0; i < jbox.length; i++) {
			jbox[i]			= new JCheckBox();
			jbox[i].setSelected(true);
		}
		for (int i = 1; i < 9; i+=2) {
			jbox[i].setSelected(false);
		}	
		
		jtfield[0]		= new JTextField("One");
		jtfield[1]		= new JTextField("Two");jtfield[1].setEnabled(false);
		jtfield[2]		= new JTextField("Three");
		jtfield[3]		= new JTextField("Four");jtfield[3].setEnabled(false);
		jtfield[4]		= new JTextField("Five");
		jtfield[5]		= new JTextField("Six");jtfield[5].setEnabled(false);
		jtfield[6]		= new JTextField("Seven");
		jtfield[7]		= new JTextField("Eight");jtfield[7].setEnabled(false);
		jtfield[8]		= new JTextField("Nine");
		jtfield[9]		= new JTextField("Ten");
		
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
