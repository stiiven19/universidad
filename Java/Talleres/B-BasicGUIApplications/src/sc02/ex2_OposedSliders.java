package sc02;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ex2_OposedSliders extends JFrame{
	JSlider		sl1,sl2;
	
	public ex2_OposedSliders() {
		setTitle("ex2 Opposed Sliders");
		setSize(400, 100);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}
	
	private void setupWidgets() {
		sl1	= new JSlider(0,50,25);
		sl2 = new JSlider(0,50,25);
		
		setLayout(null);
		
		add(sl1,BorderLayout.NORTH);
		add(sl2,BorderLayout.CENTER);
		
		sl1.setBounds(5, 10, 380, 20);
		sl2.setBounds(5, 40, 380, 20);
		
	}

	private void setupEvents() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		sl1.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				sl2.setValue(50-sl1.getValue());
				
			}
		});
		sl2.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				sl1.setValue(50-sl2.getValue());
				
			}
		});
	}
	
	public static void main(String[] args) {
		new ex2_OposedSliders();
		
	}
}
