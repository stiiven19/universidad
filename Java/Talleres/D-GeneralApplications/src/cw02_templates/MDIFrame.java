package cw02_templates;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MDIFrame extends JFrame {

	protected JMenuBar 			mb_menu;
	protected JMenu				mn_system,mn_games,mn_windows;
	protected JMenuItem			mi_exit,mi_blackjack,mi_guessnumber;
	protected JDesktopPane		dp_mdi;
	protected JLabel			lb_info;
	
	public MDIFrame() {
	
		setTitle("Games");
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setupWidgets();
		setupEvents();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	

	private void setupWidgets() {
		mb_menu		= new JMenuBar();
		mn_system	= new JMenu("System");
		mn_games	= new JMenu("Games");
		mn_windows	= new JMenu("Windows");
		mi_exit		= new JMenuItem("Exit");
		mi_blackjack= new JMenuItem("Black Jack");
		mi_guessnumber= new JMenuItem("Guess Number");
		dp_mdi		= new JDesktopPane();
		lb_info		= new JLabel("Information");
		
		
		mb_menu.add(mn_system); 	mn_system.add(mi_exit);
		mb_menu.add(mn_games);		mn_games.add(mi_blackjack); mn_games.add(mi_guessnumber); 			
		mb_menu.add(mn_windows);
		
		mb_menu.setBackground(Color.gray);
		setJMenuBar(mb_menu);
		
		add(dp_mdi);
		add(lb_info,BorderLayout.SOUTH);
		
	}
	
	private void setupEvents() {
		MDIFrame fr_handle = this;
		
		mi_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null,"Adios Marica");
				System.exit(0);
			}
		});
		
		mi_blackjack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new BlackJack(fr_handle);
				
				
			}
		});
		mi_guessnumber.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new GuessNumber(fr_handle);
			}
		});
	}
	
	public static void main(String[] args) {
		new MDIFrame();
	}

}
