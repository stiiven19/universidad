package ev01;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class ev_fib_numbers extends JFrame {
	JLabel		lb_choos[], lb_chooser, lb_pant[];
	JButton		bt_run;
	JSlider		sl;
	
	public ev_fib_numbers() {
		setTitle("Fibbonacci Numbers");
		setSize(300, 400);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}

	private void setupWidgets() {
		// TODO Auto-generated method stub
		lb_pant	= new JLabel[20];
		lb_choos	= new JLabel[20];
		lb_chooser = new JLabel("Choose Top");
		
		bt_run = new JButton("Run");
		sl	= new JSlider(1,20,1);
		
		setLayout(new BorderLayout());
		JPanel pn_top= new JPanel(new BorderLayout());
		JPanel pn_center = new JPanel(new GridLayout(20,1));
		
		add(pn_center,BorderLayout.CENTER);
		add(pn_top, BorderLayout.NORTH);
		pn_top.add(lb_chooser,BorderLayout.WEST);
		pn_top.add(sl,BorderLayout.CENTER);
		pn_top.add(bt_run,BorderLayout.EAST);
		
		for (int i = 0; i < lb_choos.length; i++) {
			lb_choos[i]=new JLabel();
			lb_pant[i]= new JLabel();
			pn_center.add(lb_pant[i]);
		}
		int f=1;
		int cont=0;
		int v=0;
		while (cont<20) {
			v=f-v;
			lb_choos[cont].setText(v+" + "+f+" = "+(f+v));
			f+=v;
			cont++;
		}
		
	}

	private void setupEvents() {
		bt_run.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i=sl.getValue();
				for (int j = 0; j < lb_choos.length; j++) {
					lb_pant[j].setText("");
				}
				for (int j = 0; j < i; j++) {
					lb_pant[j].setText(lb_choos[j].getText());
				}
				
			}
		});
		
	}
	public static void main(String[] args) {
		new ev_fib_numbers();
	}
}
