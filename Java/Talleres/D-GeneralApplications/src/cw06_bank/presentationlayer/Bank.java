package cw06_bank.presentationlayer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cw06_bank.datalayer.Account;
import cw06_bank.datalayer.CertificateOfDeposit;
import cw06_bank.datalayer.Client;
import cw06_bank.datalayer.CreditCard;
import cw06_bank.datalayer.Product;

public class Bank extends JFrame {

	// ---------------------------------------------------------------------
	protected ArrayList<Client> clients;

	private JPanel contentPane;

	// ---------------------------------------------------------------------

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bank frame = new Bank();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// ---------------------------------------------------------------------

	/**
	 * Create the frame.
	 */
	public Bank() {
		setSize(new Dimension(652, 488));
		setTitle("Bank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnClients = new JMenu("Clients");
		menuBar.add(mnClients);

		JMenuItem mntmNewClient = new JMenuItem("New Client");
		mnClients.add(mntmNewClient);

		JMenu mnProducts = new JMenu("Products");
		menuBar.add(mnProducts);

		JMenu mnNewProduct = new JMenu("New Product");
		mnProducts.add(mnNewProduct);

		JMenuItem AccountManager = new JMenuItem("Account");
		mnNewProduct.add(AccountManager);

		JMenuItem mntmCreditCard = new JMenuItem("Credit Card");
		mnNewProduct.add(mntmCreditCard);

		JMenuItem mntmCd = new JMenuItem("CD");
		mnNewProduct.add(mntmCd);

		JMenu mnReports = new JMenu("Reports");
		menuBar.add(mnReports);

		JMenuItem ProductsByClientReport = new JMenuItem("Products by Client");

		mnReports.add(ProductsByClientReport);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);

		Bank bank = this;

		mntmNewClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				desktopPane.add(new ClientManager(bank));
			}
		});

		AccountManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				desktopPane.add(new AccountManager(bank));
			}
		});

		ProductsByClientReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				desktopPane.add(new ProductsByClientReport(bank));
			}
		});

		clients = new ArrayList<>();
		loadClients();
		loadProducts();
	}

	// ------------------------------------------------------------------

	private void loadClients() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("data/bank/clients.csv"));
			String line = reader.readLine();
			while (line != null) {
				String[] values = line.split(",");
				clients.add(new Client(Long.parseLong(values[0]), values[1]));
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException fnfe) {
		} catch (IOException ioe) {
		}
	}

	// ------------------------------------------------------------------

	private void loadProducts() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("data/bank/products.csv"));
			String line = reader.readLine();
			while (line != null) {
				String[] values = line.split(",");
				Product product = null;
				switch (values[0]) {
				case "1":
					product = new Account(Long.parseLong(values[2]), values[3], values[4].equals("1") ? true : false,
							values[5].charAt(0), Long.parseLong(values[6]));
					break;
				case "2":
					product = new CertificateOfDeposit(Long.parseLong(values[2]), values[3],
							values[4].equals("1") ? true : false, Integer.parseInt(values[5]),
							Long.parseLong(values[6]));
					break;
				case "3":
					product = new CreditCard(Long.parseLong(values[2]), values[3], values[4].equals("1") ? true : false,
							Long.parseLong(values[5]), values[6]);
					break;
				}
				clients.get(Integer.parseInt(values[1])).addProduct(product);
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException fnfe) {
		} catch (IOException ioe) {
		}
	}

}
