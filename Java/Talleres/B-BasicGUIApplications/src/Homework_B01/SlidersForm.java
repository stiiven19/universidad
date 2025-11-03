package Homework_B01;

	import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
	
public class SlidersForm extends JFrame{
	
	private JSlider			sl_n1;
	private JSlider			sl_n2;
	private JSlider			sl_n3;
	private JSlider			sl_n4;
	private JButton 		bt;
	
	
	
	
	
	public SlidersForm(){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Sliders");
		setSize(500, 300);
		setupWidgets();
		setVisible(true);
		
	}
	
	private void setupWidgets(){
		
		sl_n1=new JSlider();
		sl_n2=new JSlider();
		sl_n3=new JSlider(SwingConstants.VERTICAL);
		sl_n4=new JSlider(SwingConstants.VERTICAL);
		
		bt=new JButton();
		
		setLayout(new BorderLayout());
		add(sl_n1,BorderLayout.NORTH);
		add(bt,BorderLayout.CENTER);
		add(sl_n2,BorderLayout.SOUTH);
		add(sl_n3,BorderLayout.EAST);
		add(sl_n4,BorderLayout.WEST);
	}
		
		
}
