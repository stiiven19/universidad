package cw06_bank.datalayer;

import java.util.Date;

public class CertificateOfDeposit extends Product {

	// ------------------------------------------------------------------
	private int term;
	private long amount;

	// ------------------------------------------------------------------
	public CertificateOfDeposit(long number, String date, boolean state, int term, long amount) {
		super(number, date, state);
		this.term = term;
		this.amount = amount;
	}

	// ------------------------------------------------------------------
	@Override
	public String getInformation() {
		String info = "========= Certificate of Deposit ========" + "\n" + getBasicInformation() + "Term:    " + term
				+ "\n" + "Amount:  " + amount;
		return info;
	}

}
