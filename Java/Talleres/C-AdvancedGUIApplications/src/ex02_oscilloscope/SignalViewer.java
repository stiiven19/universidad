package ex02_oscilloscope;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SignalViewer extends JFrame{

	private SignalGraph ct_signal;
	private Scrollbar 	sb_frecuency,sb_ampitude;
	
	public SignalViewer() {
		setTitle("Osciloscope");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
		setVisible(true);
		
	}
	
	private void setupWidgets() {
		ct_signal = new SignalGraph(40, 1, 1);
		sb_ampitude	= new Scrollbar(Scrollbar.HORIZONTAL,10,0,1,100);
		sb_frecuency= new Scrollbar(Scrollbar.HORIZONTAL,10,0,1,100);
		add(ct_signal);
		JPanel pn_south = new JPanel(new GridLayout(2,1));
		pn_south.add(sb_frecuency);
		pn_south.add(sb_ampitude);
		add(pn_south,BorderLayout.SOUTH);
		
		
	}

	private void setupEvents() {
		// TODO Auto-generated method stub
		
		sb_frecuency.addAdjustmentListener(new AdjustmentListener() {
			
			@Override
			public void adjustmentValueChanged(AdjustmentEvent arg0) {
				// TODO Auto-generated method stub
				ct_signal.setFrecuency(sb_frecuency.getValue()/10.0);
				
			}
		});
		sb_ampitude.addAdjustmentListener(new AdjustmentListener() {
			
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				// TODO Auto-generated method stub
				ct_signal.setAmplitude(sb_ampitude.getValue()/10.0);
			}
		});
	ct_signal.addMouseWheelListener(new MouseWheelListener() {
		
		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			ct_signal.setScale(ct_signal.getScale()+e.getWheelRotation());
			
		}
	});
	}

	public static void main(String[] args) {
		new SignalViewer();
	}
}
