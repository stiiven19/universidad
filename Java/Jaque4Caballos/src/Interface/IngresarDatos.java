/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import jaque4caballos.Ajedrez;
import jaque4caballos.Caballo;
import jaque4caballos.Rey;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author andre
 */
public class IngresarDatos extends JDialog{
	
	private JLabel				lb_01, lb_02,lb_03,lb_04,lb_05;
	private JTextField			tx1,tx2,tx3,tx4,tx5,tx6,tx7,tx8,tx9,tx10;
	private JButton				cancel, verify;
	
	
	public IngresarDatos(	) {
		
		
		setTitle("Ingrese Datos");
		setSize(320, 250);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
		setVisible(true);
		
	}

	private void setupEvents() {
		verify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int ad1 =Integer.parseInt(tx1.getText());
                                int ad2 =Integer.parseInt(tx2.getText());
                                int ad3 =Integer.parseInt(tx3.getText());
                                int ad4 =Integer.parseInt(tx4.getText());
                                int ad5 =Integer.parseInt(tx5.getText());
                                int ad6 =Integer.parseInt(tx6.getText());
                                int ad7 =Integer.parseInt(tx7.getText());
                                int ad8 =Integer.parseInt(tx8.getText());
                                int ad9 =Integer.parseInt(tx9.getText());
                                int ad10 =Integer.parseInt(tx10.getText());
                                
                                
                                
				Caballo C1 = new Caballo(ad1,ad2, "C1");
                                Caballo C2 = new Caballo(ad3, ad4, "C2");
                                Caballo C3 = new Caballo(ad5, ad6, "C3");
                                Caballo C4 = new Caballo(ad7, ad8, "C4");
                                Rey     R = new Rey(ad9, ad10);
                                int Rey_X = R.getPosicionInicial_X();
                                int Rey_Y = R.getPosicionInicial_Y();
                                if ( (Rey_X == 1 && Rey_Y >= 1 && Rey_Y <= 8 ) || (Rey_X == 8 && Rey_Y >= 1 && Rey_Y <= 8) || (Rey_Y == 1 && Rey_X >= 1 && Rey_X <= 8) || (Rey_Y == 1 && Rey_X >= 1 && Rey_X <= 8) ) {
                                    Ajedrez Funcion = new Ajedrez(C1, C2, C3, C4, R);

                                    Funcion.ImprimirAbiertos();

                                    Funcion.imprimirCerrados();
                                    Funcion.ImprimirAntecesores();
                                }else{
                                    JOptionPane.showMessageDialog(null, "Ubicar el rey en una posicion Valida", "Error", HEIGHT);
                                }
				
			}
		});
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		});
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	private void setupWidgets() {
		// ----------------------------------------------------------
		
		lb_01	= new JLabel("Caballo 1: ");
                lb_02	= new JLabel("Caballo 2: ");
                lb_03	= new JLabel("Caballo 3: ");
                lb_04	= new JLabel("Caballo 4: ");
		lb_05	= new JLabel("Rey: ");
		
		tx1		= new JTextField();		
		tx2		= new JTextField();
                tx3		= new JTextField();
                tx4		= new JTextField();
                tx5		= new JTextField();
                tx6		= new JTextField();		
		tx7		= new JTextField();
                tx8		= new JTextField();
                tx9		= new JTextField();
                tx10		= new JTextField();
		
		cancel	= new JButton("Cancel");
		verify	= new JButton("Iniciar Juego");
		
		setLayout(null);
		
		lb_01.setBounds(20, 20, 80, 20); lb_02.setBounds(20, 45, 80, 20);
                lb_03.setBounds(20, 70, 80, 20); lb_04.setBounds(20, 95, 80, 20);
                lb_05.setBounds(20, 120, 180, 20);
		tx1.setBounds(100, 20, 60, 20);  tx2.setBounds(165, 20, 60, 20);
                tx3.setBounds(100, 45, 60, 20);  tx4.setBounds(165, 45, 60, 20);
                tx5.setBounds(100, 70, 60, 20); tx6.setBounds(165, 70, 60, 20);
                tx7.setBounds(100, 95, 60, 20);  tx8.setBounds(165, 95, 60, 20);
                tx9.setBounds(100, 120, 60, 20);  tx10.setBounds(165, 120, 60, 20);
                
                  
		cancel.setBounds(20, 160, 120, 20); verify.setBounds(160, 160, 120, 20);
		
		
		add(lb_01); add(tx1); 
                add(tx2);
		add(lb_02);	add(tx3); 
                add(tx4);
                add(lb_03); add(tx5); 
                add(tx6);
		add(lb_04);	add(tx7); 
                add(tx8);
                add(lb_05);	add(tx9); 
                add(tx10);
		add(cancel); add(verify);
		
	}
}
