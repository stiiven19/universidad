package	progress1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//...

public class ProgressShowViewerParameterized extends JFrame {
	//--------------------------------------------------------------
	private	JTextField[]			tf_tasks;
	private ProgressPercentageParameterized[]	ct_tasks;
	//--------------------------------------------------------------
	public ProgressShowViewerParameterized() {
		setTitle("ProgressShow (Parameterized)");
		setSize(400,150);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}
	//--------------------------------------------------------------
	private void setupWidgets() {
		setLayout(new GridLayout(4,3));
		tf_tasks	= new JTextField[4];
		ct_tasks	= new ProgressPercentageParameterized[4];
		
		Random random = new Random();
		
		for (int i=0; i<4; i++) {
			int value = random.nextInt(100);
			tf_tasks[i]	= new JTextField(""+value);
			ct_tasks[i]	= new ProgressPercentageParameterized(value);
			tf_tasks[i].setName(""+i);
			add(new JLabel("Item "+i));	add(tf_tasks[i]);	add(ct_tasks[i]);
		}
	}
	//--------------------------------------------------------------
	private void setupEvents() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//-------------------------------------------------------
		for (int i=0; i<4; i++) {
			tf_tasks[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int id = Integer.parseInt( ((JTextField)e.getSource()).getName() );
					try {
						int value = Integer.parseInt( tf_tasks[id].getText() );
						ct_tasks[id].setValue(value);
					} catch(NumberFormatException ex) {
					}
					tf_tasks[id].selectAll();
				}
			});
			
			int y=i;
			ct_tasks[i].addProgressPercentageListener(new ProgressPercentageListener() {
				
				@Override
				public void ProgressChange(int e) {
					
					tf_tasks[y].setText(""+e);
				}
			});
			tf_tasks[i].addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent arg0) {
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					((JTextField)e.getSource()).selectAll();
				}
			});
		}
	}
	//--------------------------------------------------------------
	public static void main(String[] args) {
		new ProgressShowViewerParameterized();
	}
}
