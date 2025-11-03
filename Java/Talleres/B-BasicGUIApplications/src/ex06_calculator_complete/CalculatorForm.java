package ex06_calculator_complete;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalculatorForm extends JFrame {
	
	JButton 		jb_numbers[],jb_Operator[],jb_clear;
	JLabel			jl_display;
	private boolean restartNumber= true;
	private double	total=0;
	private double	operation=1;
	
	public CalculatorForm() {
		setTitle("Calculator");
		setSize(200, 280);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}

	private void setupEvents() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		for (int i = 0; i < jb_numbers.length; i++) {
			jb_numbers[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton bt_current =(JButton)e.getSource();
					
					if (restartNumber) {
						jl_display.setText(bt_current.getText());
						restartNumber=false;
					}else {
						jl_display.setText(jl_display.getText()+bt_current.getText());
					}
				}
			});;
		}
		for (int i = 0; i < jb_Operator.length; i++) {
			jb_Operator[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					restartNumber = true;
					JButton bt_current = (JButton)e.getSource();
					long value =Long.parseLong(jl_display.getText());
					
					switch ((int)operation) {
					case 1:
						total += value; break;
					case 2:
						total -= value; break;
					case 3:
						total *= value; break;
					case 4:
						total /= value; break;
					}
					int totali=(int)total%10;
					if ((totali - (total%10))==0) {
						jl_display.setText(""+(int)total);
					}else {
						jl_display.setText(""+total);
					}
					
					
					
					switch (bt_current.getText()) {
					case "+": operation=1; break;
					case "-": operation=2; break;
					case "x": operation=3; break;
					case "/": operation=4; break;
					case "=": operation=1; total=0;break;
					}
				}
			});
		}
		
		jb_clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				total=0;
				restartNumber=true;
				operation=1;
				jl_display.setText("0");
				
			}
		});
	}

	private void setupWidgets() {
		jb_numbers 		= new JButton[10];
		jb_Operator		= new JButton[5];
		jl_display		= new JLabel("0", JLabel.RIGHT);
		jb_clear		= new JButton("C");
		
		for (int i = 0; i < jb_numbers.length; i++) {
			jb_numbers[i]		= new JButton(""+i);
		}
		
		jb_Operator[0]			= new JButton("+");
		jb_Operator[1]			= new JButton("-");
		jb_Operator[2]			= new JButton("x");
		jb_Operator[3]			= new JButton("/");
		jb_Operator[4]			= new JButton("=");
		
		JPanel jp_numbers 		= new JPanel(new GridLayout(4,3));
		JPanel jp_operators 	= new JPanel(new GridLayout(6,1));

		setLayout(new BorderLayout());
		
		add(jl_display,BorderLayout.NORTH);
		add(jp_numbers,BorderLayout.CENTER);
		add(jp_operators,BorderLayout.EAST);
		
		for (int i = 9; i >=0; i--) {
			jp_numbers.add(jb_numbers[i]);
			System.out.println(i);
		}
		jp_operators.add(jb_clear);
		for (int i = 0; i < jb_Operator.length; i++) {
			jp_operators.add(jb_Operator[i]);
		}
		
	}
	public static void main(String[] args) {
		new CalculatorForm();
	}
}
