package cw03_Windowbuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setTitle("Computer Store");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 516);
		
		JDesktopPane dpMDI = new JDesktopPane();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnStock = new JMenu("Stock");
		menuBar.add(mnStock);
		
		JMenuItem mntmNewArticle = new JMenuItem("New Article");
		mntmNewArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArticleManager articleManager=new ArticleManager();
				dpMDI.add(articleManager);
				articleManager.setVisible(true);
			}
		});
		mnStock.add(mntmNewArticle);
		
		JMenuItem mntmListArticles = new JMenuItem("List Articles");
		mntmListArticles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArticleList articlelist=new ArticleList();
				dpMDI.add(articlelist);
				articlelist.setVisible(true);
			}
		});
		mnStock.add(mntmListArticles);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		contentPane.add(dpMDI, BorderLayout.CENTER);
	}
}
