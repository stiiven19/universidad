package cw02_analogclock;



import javax.swing.JFrame;

public class ClockViewer extends JFrame{

	private Clock ct_clock;
	
	public ClockViewer() {
		setTitle("Analog Clock");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
		setVisible(true);
		
	}

	private void setupWidgets() {
		ct_clock	= new Clock();
		add(ct_clock);
		
	}

	private void setupEvents() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new ClockViewer();
	}
}
