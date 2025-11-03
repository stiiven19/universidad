package cw02_analogclock;

import cw02_analogclock.Clock;

public class Battery extends Thread{

	private Clock ctClock;
	
	public Battery(Clock ctClock) {
		this.ctClock=ctClock;
	}
	
		public void run(){
		while (true) {
			ctClock.repaint();
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		}
	}
