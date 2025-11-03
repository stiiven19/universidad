package ex05_calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalculatorForm extends JFrame {
	
	JButton 		jb_numbers[],jb_Operator[],jb_clear;
	JLabel			jl_display;
	
	public CalculatorForm() {
		setTitle("Calculator");
		setSize(200, 280);
		setupWidgets();
		//setupEvents();
		setVisible(true);
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
