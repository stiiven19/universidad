package ev02;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ex01 extends JFrame{
	JButton			btsimplegraph,bttimestable,btsurvey,bteyes,btexit;
	ex03			tables;
	ex04			survey;
	JSlider			slsur,sleast;
	JDesktopPane	dp1;
	
	public ex01() {
		setTitle("Second Evaluation");
		setSize(700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}

	private void setupWidgets() {
		btsimplegraph	= new JButton("Simple Graph");
		bttimestable	= new JButton("Times Table");
		btsurvey		= new JButton("Survey");
		bteyes			= new JButton("Eyes");
		btexit			= new JButton("Exit");
		dp1				= new JDesktopPane();
		
		JPanel pnSouth	= new JPanel(new GridLayout(1,5));
		
		pnSouth.add(btsimplegraph);
		pnSouth.add(bttimestable);
		pnSouth.add(btsurvey);
		pnSouth.add(bteyes);
		pnSouth.add(btexit);
		
		add(dp1);
		add(pnSouth, BorderLayout.SOUTH);
		
	}

	private void setupEvents() {
		// TODO Auto-generated method stub
		btexit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		
		btsimplegraph.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JInternalFrame ifWindow	= new JInternalFrame("Simple Graph",false,true,false,false);
				ifWindow.setSize(300, 300);
				ifWindow.setVisible(true);
				ifWindow.add(new ex02());
				dp1.add(ifWindow);
				
			}
		});
		bttimestable.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tables	= new ex03();
				dp1.add(tables);
				
			}
		});
		btsurvey.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				survey = new ex04();
				dp1.add(survey);
			}
		});
		bteyes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JInternalFrame	ifeyes = new JInternalFrame("Eyes",false,true,false,false);
				ifeyes.setSize(300, 400);
				ifeyes.setVisible(true);
				sleast	= new JSlider(JSlider.VERTICAL,0,ifeyes.getHeight(),300);
				slsur	= new JSlider(JSlider.HORIZONTAL,0,ifeyes.getWidth(),100);
				ifeyes.add(sleast,BorderLayout.EAST);
				ifeyes.add(slsur,BorderLayout.SOUTH);
				ex05	eyes = new ex05(sleast.getValue()-10,slsur.getValue()-10);
				ifeyes.add(eyes);
				dp1.add(ifeyes);
				
				sleast.addChangeListener(new ChangeListener() {
					
					@Override
					public void stateChanged(ChangeEvent arg0) {
						eyes.setHeight(sleast.getValue()-10);
						
						
					}
				});
				slsur.addChangeListener(new ChangeListener() {
					
					@Override
					public void stateChanged(ChangeEvent arg0) {
						// TODO Auto-generated method stub
						eyes.setWidth(slsur.getValue()-10);
						
					}
				});
			}
		});
		
	}
	public static void main(String[] args) {
		new ex01();
	}
}
