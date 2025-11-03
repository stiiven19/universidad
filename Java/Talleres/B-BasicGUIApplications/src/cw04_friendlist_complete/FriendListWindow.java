package cw04_friendlist_complete;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;


public class FriendListWindow  extends JFrame{
	//-----------------------------------------------
	private JTextField 					tf_name;
	private DefaultListModel<String>	lm_friends;
	private JList 						ls_friends;
	private JButton 					bt_remove;
	
	//-----------------------------------------------
 	public FriendListWindow() {
	setTitle("Fiend List");
	setSize(400,400);
	setupWidges();
	//setDefaultCloseOperation(EXIT_ON_CLOSE);
	setupEvents();
	setVisible(true);
}
	//------------------------------------------------
	private void setupWidges() {
		tf_name			= new JTextField();
		lm_friends		= new DefaultListModel<String>();
		ls_friends 		= new JList(lm_friends);
		bt_remove 		= new JButton("Remove");
		 
		add(tf_name ,BorderLayout.NORTH);
		add(ls_friends,BorderLayout.CENTER);
		add(bt_remove ,BorderLayout.SOUTH);
	}
	//---------------------------------------------------
	private void setupEvents() {	
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
			System.exit(0);
			
		}
		});
		tf_name.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lm_friends.addElement(tf_name.getText());
				tf_name.setText("");
			}
		});
	}
	//---------------------------------------------------
	public static void main(String[] args) {
	new FriendListWindow();
	}
	//--------------------------------------------------
}
class Listener extends WindowAdapter{
	
}
