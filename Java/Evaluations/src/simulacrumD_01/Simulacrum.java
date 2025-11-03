package simulacrumD_01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class Simulacrum extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Simulacrum frame = new Simulacrum();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Simulacrum() {
		setTitle("Simulacrum");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 883, 663);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSystem = new JMenu("System");
		menuBar.add(mnSystem);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		
		mnSystem.add(mntmAbout);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnSystem.add(mntmExit);
		
		JMenu mnExercises = new JMenu("Exercises");
		menuBar.add(mnExercises);
		
		JMenuItem mntmCitySelection = new JMenuItem("City Selection");
		
		mnExercises.add(mntmCitySelection);
		
		JMenuItem mntmLanguajesList = new JMenuItem("Languajes List");
		
		mnExercises.add(mntmLanguajesList);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(12, 0, 861, 598);
		contentPane.add(desktopPane);
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				About about=new About();
				desktopPane.add(about);
				about.setVisible(true);
				
			}
		});
		
		mntmLanguajesList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LanguajesList languages=new LanguajesList();
				desktopPane.add(languages);
				languages.setVisible(true);
				
			}
		});
		mntmCitySelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CitySelection city = new CitySelection();
				desktopPane.add(city);
				city.setVisible(true);
			}
		});
	}
	
}
