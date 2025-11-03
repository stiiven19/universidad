package cw01_friendlist;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;

public class FriendListWindow extends JFrame{

	private JTextField 	tf_name;
	private JList 		ls_friends;
	private JButton		bt_remove;
	
	public FriendListWindow() {
		setTitle("Friend List");
		setSize(400, 400);
		setupWidgets();
		setVisible(true);
		
	}

	private void setupWidgets() {
		tf_name=new JTextField();
		ls_friends=new JList();
		bt_remove=new JButton("Remove");
		
		setLayout(new BorderLayout());
		add(tf_name, BorderLayout.NORTH);
		add(ls_friends, BorderLayout.CENTER);
		add(bt_remove, BorderLayout.SOUTH);
		
		
	}
	
	
	
	public static void main(String[] args) {
		new FriendListWindow();
	}
	
}

