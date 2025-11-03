package Hw04_text;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.GridLayout;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;

import java.awt.ComponentOrientation;

import javax.swing.border.LineBorder;
import javax.swing.event.ChangeListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.Style;

import java.awt.Color;
import java.util.Enumeration;

public class WindowText extends JFrame {

	private JPanel contentPane;
	private String text;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowText frame = new WindowText();
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
	public WindowText() {
		setTitle("Rich Text");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Switcher swbold,switalic,swenlarged;
		
		swbold		= new Switcher(false);
		switalic	= new Switcher(false);
		swenlarged	= new Switcher(false);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(3, 2));
		
		JLabel lblBold = new JLabel("Bold");
		lblBold.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblBold);panel.add(swbold);
		
		JLabel lblItalic = new JLabel("Italic");
		lblItalic.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblItalic);panel.add(switalic);
		
		JLabel lblNewLabel = new JLabel("Enlarged");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);panel.add(swenlarged);
JTextPane textPane = new JTextPane();
textPane.setBorder(new LineBorder(new Color(0, 0, 0)));
contentPane.add(textPane, BorderLayout.CENTER);
			
		
		
		swbold.addChangeSwitchListener(new ChangeSwitchListener() {
			
			@Override
			public void SwitchChanged() {
				
				if (swbold.isBand()) {
					textPane.setFont(new Font(null, 1, textPane.getFont().getSize()));
					if (switalic.isBand()) {
						textPane.setFont(new Font(null, 3, textPane.getFont().getSize()));
					}
				}else {
					textPane.setFont(new Font(null, 0, textPane.getFont().getSize()));
					if (switalic.isBand()) {
						textPane.setFont(new Font(null, 2, textPane.getFont().getSize()));
					}
					
				}
				
				 
			}
		});
		
		switalic.addChangeSwitchListener(new ChangeSwitchListener() {
			
			@Override
			public void SwitchChanged() {
				// TODO Auto-generated method stub
				
				if (switalic.isBand()) {
					textPane.setFont(new Font(null, 2, textPane.getFont().getSize()));
					if (swbold.isBand()) {
						textPane.setFont(new Font(null, 3, textPane.getFont().getSize()));
					}
				}else {
					
					textPane.setFont(new Font(null, 0, textPane.getFont().getSize()));
					if (swbold.isBand()) {
						textPane.setFont(new Font(null, 1, textPane.getFont().getSize()));
					}
				}
				
			}
		});
		
		swenlarged.addChangeSwitchListener(new ChangeSwitchListener() {
			
			@Override
			public void SwitchChanged() {
				if (swenlarged.isBand()) {
					textPane.setFont(new Font(null, 0, 20));
					if (swbold.isBand()) {
						textPane.setFont(new Font(null, 1, 20));
						if (switalic.isBand()) {
							textPane.setFont(new Font(null, 3, 20));
						}
					}else {
						textPane.setFont(new Font(null, 0, 20));
						if (switalic.isBand()) {
							textPane.setFont(new Font(null, 2, 20));
						}
						
					}
					
				}else {
					textPane.setFont(new Font(null, 0, 12));
					if (swbold.isBand()) {
						textPane.setFont(new Font(null, 1, 12));
						if (switalic.isBand()) {
							textPane.setFont(new Font(null, 3, 12));
						}
					}else {
						textPane.setFont(new Font(null, 0, 12));
						if (switalic.isBand()) {
							textPane.setFont(new Font(null, 2, 12));
						}
					}
					
				}
				
			}
		});
	}

}
