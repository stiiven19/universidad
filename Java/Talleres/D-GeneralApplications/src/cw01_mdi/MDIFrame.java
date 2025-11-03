package cw01_mdi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MDIFrame extends JFrame {
	//----------------------------------------------------------------------
	private JMenuBar 			mb_menu;
	private JMenu				mn_file, mn_edit, mn_help;
	private JMenuItem			mi_new, mi_exit, mi_about;
	private JDesktopPane		dp_mdi;
	private AboutFrame			fi_about;
	
	public MDIFrame() {
		setTitle("MDI Application");
		setSize(600, 400);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}
	
	//-------------------------------------------------------------------------------------------
	private void setupWidgets() {
		
		mb_menu		= new JMenuBar();
		
		mn_edit		= new JMenu("Edition");
		mn_file		= new JMenu("File");
		mn_help		= new JMenu("Help");
		
		mi_new		= new JMenuItem("New Document");
		mi_exit		= new JMenuItem("Exit");
		mi_about	= new JMenuItem("About");
		
		dp_mdi		= new JDesktopPane();
		
		
		mb_menu.setBackground(Color.gray);
		mn_file.setForeground(Color.WHITE);
		mn_edit.setForeground(Color.white);
		mn_help.setForeground(Color.white);
		setJMenuBar(mb_menu);
		
		mb_menu.add(mn_file);
		mb_menu.add(mn_edit);
		mb_menu.add(mn_help);
		
		mn_file.add(mi_new);
		mn_file.add(mi_exit);
		mn_help.add(mi_about);
		add(dp_mdi);
		
	}
	//------------------------------------------------------------------------------------------
	private void setupEvents() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//------------------------------------------------------------------------
		mi_new.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JInternalFrame if_child = new JInternalFrame("New Document",true,true,true,true);
				if_child.setSize(300, 200); 
				if_child.setVisible(true);
				dp_mdi.add(if_child);
			}
		});
		
		mi_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Adios Marica");
				System.exit(0);
			}
		});
		
		mi_about.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fi_about	= new AboutFrame();
				dp_mdi.add(fi_about);
			}
		});
	}
	//-----------------------------------------------------------------------------------------
	public static void main(String[] args) {
		new MDIFrame();
	}
}
