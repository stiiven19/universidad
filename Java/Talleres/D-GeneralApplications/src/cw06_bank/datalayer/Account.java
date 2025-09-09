package cw06_bank.datalayer;

import java.util.Date;

public class Account extends Product {
	// ----------------------------------------------------------------------
	private char type;
	private long balance;

	// ----------------------------------------------------------------------
	public Account(long number, String date, boolean state, char type, long balance) {
		super(number, date, state);
		this.type = type;
		this.balance = balance;
	}

	// ----------------------------------------------------------------------
	@Override
	public String getInformation() {
		String info = "========= Account ========" + "\n" + getBasicInformation() + "Type of Account:  " + type + "\n"
				+ "Balance:          " + balance;
		return info;
	}
}
