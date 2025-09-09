package Homework_B03;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LibraryCard extends JFrame{
		
	/*field code 80x20
	//410x182
	//field2 200x20
	field3 200x20
	field 4 60x20
	field5 300x20
	
	code 35
	title 5+30+5
	
	
	
	*/
	JLabel 		code, title, author, pages, editorial;
	JTextField 	tx1, tx2, tx3, tx4, tx5 ;
	JButton		bt;

	public LibraryCard() {
	
		setTitle("Library Book Card");
		setSize(425, 220);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setupWidgets();
		setVisible(true);
	}

	private void setupWidgets() {
			
		code	 	= new JLabel("Code");
		title	 	= new JLabel("Title");
		author	 	= new JLabel("Author");
		pages	 	= new JLabel("pages"); 
		editorial	= new JLabel("Editorial");
		
		tx1			= new JTextField();
		tx2			= new JTextField();
		tx3			= new JTextField();
		tx4			= new JTextField();
		tx5			= new JTextField();
		
		bt 			= new JButton();
		
		setLayout(null);
		
		code.setBounds(20,20,50,20); code.setFont(new Font("Arial",1,13));
		title.setBounds(150,20,50,20); title.setFont(new Font("Arial",1,13));
		author.setBounds(20,60,50,20); author.setFont(new Font("Arial",1,13));
		pages.setBounds(280,60,60,20); pages.setFont(new Font("Arial",1,13));
		editorial.setBounds(20,100,70,20); editorial.setFont(new Font("Arial",1,13));
		
		tx1.setBounds(60,20,80,20);
		tx2.setBounds(190,20,200,20);
		tx3.setBounds(70,60,200,20);
		tx4.setBounds(330,60,60,20);
		tx5.setBounds(90,100,300,20);
		
		bt.setBounds(20,140,370,20);	bt.setText("Create Card");
		
		add(code); add(tx1); add(title); add(tx2);
		add(author); add(tx3); add(pages); add(tx4);
		add(editorial); add(tx5);
		add(bt);
		
	}
	
	public static void main(String[] args) {
		new LibraryCard();
	}
}
