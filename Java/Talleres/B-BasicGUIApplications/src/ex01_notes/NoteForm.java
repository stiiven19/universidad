package ex01_notes;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class NoteForm extends JFrame {
	
	private JLabel 			lb_info;
	private JTextArea		ta_note;
	private JButton 		bt_analyze;
	private JProgressBar 	pb_effort;
	
	public NoteForm(){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Notes");
		setSize(500, 300);
		setupWidgets();
		setLocation(814, 201);
		setVisible(true);
		
		
	}
	
	private void setupWidgets(){
		
		lb_info=new JLabel("write your note inside below field");
		ta_note=new JTextArea();
		bt_analyze=new JButton("Analize Text");
		pb_effort=new JProgressBar(JProgressBar.VERTICAL);
		
		setLayout(new BorderLayout());
		add(lb_info,BorderLayout.NORTH);
		add(ta_note,BorderLayout.CENTER);
		add(bt_analyze,BorderLayout.SOUTH);
		add(pb_effort,BorderLayout.EAST);
	}
}
