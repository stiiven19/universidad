package ev02;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ex04 extends JInternalFrame{
	JLabel		lbselect;
	JCheckBox	cb1,cb2,cb3,cb4,cb5;
	JButton		btaccept;
	
	public ex04() {
		super("Survey",false,true,false,false);
		setSize(400, 300);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}

	private void setupEvents() {
		btaccept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int cont=0;
				if (cb1.isSelected()) {
					cont+=1;
				}
				if (cb2.isSelected()) {
					cont+=1;
				}
				if (cb3.isSelected()) {
					cont+=1;
				}
				if (cb4.isSelected()) {
					cont+=1;
				}
				if (cb5.isSelected()) {
					cont+=1;
				}
				if (cont==2) {
					JOptionPane.showMessageDialog(null, "Thank You");
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "You must select 2 options");
				}
			}
		});
		
	}

	private void setupWidgets() {
		lbselect	= new JLabel("Select only 2 hobbies");
		cb1			= new JCheckBox("Play some musical instrument");
		cb2			= new JCheckBox("Practice Sports");
		cb3			= new JCheckBox("Read literaly novel");
		cb4			= new JCheckBox("Play video games");
		cb5			= new JCheckBox("Go dancing with friends");
		btaccept	= new JButton("Accept");
		
		JPanel pncenter	= new JPanel(new GridLayout(5,1));
		pncenter.add(cb1);
		pncenter.add(cb2);
		pncenter.add(cb3);
		pncenter.add(cb4);
		pncenter.add(cb5);
		
		add(lbselect,BorderLayout.NORTH);
		add(pncenter);
		add(btaccept,BorderLayout.SOUTH);
		
	}
}
