package sc01;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class sm01 extends JFrame{
	
	JButton			bt_month[];
	JComboBox		day;
	
	public sm01() {
		setTitle("Ex1 Day Selector");
		setSize(400, 200);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}

	private void setupEvents() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//-------------------------------------------------------------------------------------------------------------
		for (int i = 0; i < bt_month.length; i++) {
			int j=i;
			bt_month[i].addMouseListener(new MouseListener() {
			
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
					day.removeAllItems();
						setTitle(""+bt_month[j].getText());
						
						if (j==3 || j==5 || j==8 || j==10 ) {
							for (int j2 = 1; j2 <= 30; j2++) {
								day.addItem(j2);
							}
						}else if(j==1){
							for (int j2 = 1; j2 <= 28; j2++) {
								day.addItem(j2);
							}
						}else {
							for (int j2 = 1; j2 <= 31; j2++) {
								day.addItem(j2);
							}
						}
						
						
				}
			});
		}
		
	}

	private void setupWidgets() {
		bt_month	= new JButton[12];
		day			= new JComboBox();
		
		JPanel pn_center = new JPanel(new GridLayout(4,3));
		
		setLayout(new BorderLayout());
		
		add(pn_center,BorderLayout.CENTER);
		add(day,BorderLayout.SOUTH);
		
		pn_center.add(bt_month[0]=new JButton("January"));
		pn_center.add(bt_month[1]=new JButton("February"));
		pn_center.add(bt_month[2]=new JButton("March"));
		pn_center.add(bt_month[3]=new JButton("April"));
		pn_center.add(bt_month[4]=new JButton("May"));
		pn_center.add(bt_month[5]=new JButton("June"));
		pn_center.add(bt_month[6]=new JButton("July"));
		pn_center.add(bt_month[7]=new JButton("August"));
		pn_center.add(bt_month[8]=new JButton("September"));
		pn_center.add(bt_month[9]=new JButton("October"));
		pn_center.add(bt_month[10]=new JButton("November"));
		pn_center.add(bt_month[11]=new JButton("December"));
		
		
	}
	
	public static void main(String[] args) {
		new sm01();
		
	}

}
