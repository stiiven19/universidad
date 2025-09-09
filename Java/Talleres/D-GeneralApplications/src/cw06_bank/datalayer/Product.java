package cw06_bank.datalayer;

import java.util.Date;

abstract public class Product {
	// ----------------------------------------------------------------------
	protected long number;
	protected String date;
	protected boolean state;

	// ----------------------------------------------------------------------
	public Product(long number, String date, boolean state) {
		super();
		this.number = number;
		this.date = date;
		this.state = state;
	}

	// ----------------------------------------------------------------------
	public String getBasicInformation() {
		String info = "Number:      " + number + "\n" + "Start date:  " + date + "\n" + "State:       "
				+ (state ? "Active" : "Inactive") + "\n";
		return info;
	}

	// ----------------------------------------------------------------------
	public abstract String getInformation();

	// ----------------------------------------------------------------------
	public long getNumber() {
		return number;
	}

	public String getDate() {
		return date;
	}

	public boolean isState() {
		return state;
	}

}
