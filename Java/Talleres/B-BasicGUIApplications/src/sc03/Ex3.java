package sc03;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import sc02.ex2_OposedSliders;

public class Ex3 extends JFrame{
	JTextField 	jt;
	JButton		jb;
	JLabel		jl;
	
	public Ex3() {
		setTitle("Ex3 Number Validation");
		setSize(300, 120);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}
	
	private void setupWidgets() {
		jt	= new JTextField();
		jb	= new JButton("Validate");
		jl	= new JLabel();
		
		setLayout(new GridLayout(3,1));
		
		add(jt);
		add(jb);
		add(jl);
	
	}

	private void setupEvents() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jb.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				String text=jt.getText();
				char chars;
				int cont=0;
				boolean band=false;
				for (int i = 0; i <= (jt.getText().length()-1); i++) {
					chars=text.charAt(i);
					if (chars>45 && chars<58 && band==false) {
						if (chars==46) {
							cont=cont+1;
						}
						if (cont>1) {
							band=true;
						}
						if (i==text.length()-1 && band==false) {
							jl.setText("OK");
						}else {
							jl.setText("Error");
						}
					}else{
						jl.setText("Error");
					}
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new Ex3();
		
	}
}
