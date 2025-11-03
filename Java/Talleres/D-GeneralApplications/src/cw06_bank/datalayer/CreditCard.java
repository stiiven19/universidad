package cw06_bank.datalayer;

import java.util.Date;

public class CreditCard extends Product {
	// -----------------------------------------------------------------
	private long quota;
	private String expiration;

	// -----------------------------------------------------------------
	public CreditCard(long number, String date, boolean state, long quota, String expiration) {
		super(number, date, state);
		this.quota = quota;
		this.expiration = expiration;
	}

	// -----------------------------------------------------------------
	@Override
	public String getInformation() {
		String info = "========= Credit Card ========" + "\n" + getBasicInformation() + "Quota:       " + quota + "\n"
				+ "Expiration:  " + expiration;
		return info;
	}

}
