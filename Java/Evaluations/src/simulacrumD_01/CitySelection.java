package simulacrumD_01;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class CitySelection extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public CitySelection() {
		setTitle("City Selection");
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(31, 53, 92, 17);
		getContentPane().add(lblDepartamento);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(31, 113, 92, 17);
		getContentPane().add(lblCity);
		
		JButton btnNewButton = new JButton("Accept");
		btnNewButton.setBounds(12, 185, 392, 27);
		getContentPane().add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(182, 48, 191, 26);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(182, 108, 191, 26);
		getContentPane().add(comboBox_1);

	}
	
}
