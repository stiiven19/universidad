package cw08_levelsofsatisfaction;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//import org.omg.CORBA.PRIVATE_MEMBER;

public class MeterOfLevels extends JFrame{
	//---------------------------------------------------------------------------------------------------------
	private JSlider		sl_levels[]; 
	private JLabel 		lb_result;
	//-----------------------------------------------------------------------------------------------------------
	public MeterOfLevels() {
		setTitle("Levels of Satisfaction");
		setSize(400, 400);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}
	//-----------------------------------------------------------------------------------------------------
	private void setupWidgets() {
		sl_levels		= new JSlider[4];
		lb_result		= new JLabel();
		
		JPanel	pn_west = new JPanel(new GridLayout(4,1));
		JPanel	pn_center = new JPanel(new GridLayout(4,1));
		
		setLayout(new BorderLayout());
		
		add(pn_west,BorderLayout.WEST);
		add(pn_center,BorderLayout.CENTER);
		add(lb_result,BorderLayout.SOUTH);
		lb_result.setHorizontalAlignment(JLabel.CENTER);;
		
		pn_west.add(new JLabel("Puntualidad"));
		pn_west.add(new JLabel("Metodology"));
		pn_west.add(new JLabel("Clarity"));
		pn_west.add(new JLabel("Evaluation"));
		
		for (int i = 0; i < sl_levels.length; i++) {
			sl_levels[i] = new JSlider(0,5,1);
			pn_center.add(sl_levels[i]);
		}
		
	}
	//_-------------------------------------------------------------------------------------------------------------
	private void setupEvents() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//-------------------------------------------------------------------------------------------------------------
		for (int i = 0; i < sl_levels.length; i++) {
			sl_levels[i].addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					double result=0;
					for (int i = 0; i < sl_levels.length; i++) {
						result=result+sl_levels[i].getValue();
					}
					result=result/4.0;
					lb_result.setText("Promedy of values: "+result);
				}
			});
		}
		
		
	}
	//-----------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		new MeterOfLevels();
	}
	

}
