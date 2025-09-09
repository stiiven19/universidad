package ex04_notes_complete;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class NoteForm extends JFrame {
	
	private JLabel 			lb_info;
	private JTextArea		ta_note;
	private JButton 		bt_analyze;
	private JProgressBar 	pb_effort;
	//----------------------------------------------------------------------------
	public NoteForm(){
		
		setTitle("Notes");
		setSize(500, 300);
		setLocation(814, 201);
		setupWidgets();
		setupEvents();
		setVisible(true);

	}
	
	//----------------------------------------------------------------------------
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
	//----------------------------------------------------------------------------
	private void setupEvents() {
		//----------------------------------------------------------------------
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//-------------------------------------------------------------------------
		
		
		bt_analyze.addActionListener( new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String text = ta_note.getText();
				
				int uppercase =0;
				int lowercase =0;
				int digits    =0;
				
				for (int i = 0; i < text.length(); i++) {
					char symbol = text.charAt(i);
					
					if (symbol>=65 && symbol<=90) {
						uppercase++;
					}
					if(symbol>=97 && symbol<=122){
						lowercase++;
					}
					if(symbol>=48 && symbol<=57){
						digits++;
					}
				}
				
				String message= 	"Upper Cases: "		+uppercase+ "\n"
				 		+"Lower Cases: "	+lowercase+	"\n"
				 		+"Digits: "			+digits;
				
				pb_effort.setValue((digits+lowercase+uppercase));
				
				JOptionPane.showMessageDialog(null, message);
			}
		});
	}
}
