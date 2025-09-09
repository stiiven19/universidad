package ex07_colormixer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorMixer extends JFrame{

	private JLabel 		lb_mix,lb_red,lb_green,lb_blue,lb_nred,lb_ngreen,lb_nblue;
	private JSlider		sl_red,sl_green,sl_blue;
	
	public ColorMixer() {
		setTitle("Color Mixer");
		setSize(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}

	private void setupEvents() {
		// TODO Auto-generated method stub
		sl_red.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				lb_mix.setBackground(new Color(sl_red.getValue(), sl_green.getValue(), sl_blue.getValue()));
				lb_nred.setText(""+sl_red.getValue());
			}
		});
		sl_green.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				lb_mix.setBackground(new Color(sl_red.getValue(), sl_green.getValue(), sl_blue.getValue()));
				lb_ngreen.setText(""+sl_green.getValue());
			}
		});
		sl_blue.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				lb_mix.setBackground(new Color(sl_red.getValue(), sl_green.getValue(), sl_blue.getValue()));
				lb_nblue.setText(""+sl_blue.getValue());
			}
		});
	}

	private void setupWidgets() {
	lb_mix		= new JLabel();
	lb_nred		= new JLabel("0");
	lb_ngreen	= new JLabel("0");
	lb_nblue	= new JLabel("0");
	lb_red		= new JLabel("Red");
	lb_green	= new JLabel("Green");
	lb_blue		= new JLabel("Blue");
	
	sl_blue		= new JSlider(JSlider.HORIZONTAL,0,250,0);
	sl_green	= new JSlider(JSlider.HORIZONTAL,0,250,0);
	sl_red		= new JSlider(JSlider.HORIZONTAL,0,250,0);
	
	JPanel pn_south = new JPanel(new BorderLayout());
	JPanel pn_Center = new JPanel(new GridLayout(3,1));
	JPanel pn_west 	= new JPanel(new GridLayout(3,1));
	JPanel pn_east 	= new JPanel(new GridLayout(3,1));
	
	
	add(lb_mix);
	add(pn_south,BorderLayout.SOUTH);
	
	pn_south.add(pn_west,BorderLayout.WEST);
	pn_south.add(pn_Center);
	pn_south.add(pn_east,BorderLayout.EAST);
	
	pn_west.add(lb_red);
	pn_west.add(lb_green);
	pn_west.add(lb_blue);
	
	pn_Center.add(sl_red);
	pn_Center.add(sl_green);
	pn_Center.add(sl_blue);
	
	pn_east.add(lb_nred);
	pn_east.add(lb_ngreen);
	pn_east.add(lb_nblue);
	
	
	lb_mix.setOpaque(true);
	lb_mix.setBackground(new Color(0,0,0));
	
	}
	public static void main(String[] args) {
		new ColorMixer();
	}
}
