package com.infosys.dto;

import java.time.LocalDate;

public class TransactionDto {
	private int accountNumber;
	private String accountName;
	private LocalDate valueDate;
	private String currency;
	private double debitAmount, creditAmount;
	private String transType, transNarrative;

	public TransactionDto() {
		super();
	}

	public TransactionDto(int accountNumber, String accountName, LocalDate valueDate, String currency,
			double debitAmount, double creditAmount, String transType, String transNarrative) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.valueDate = valueDate;
		this.currency = currency;
		this.debitAmount = debitAmount;
		this.creditAmount = creditAmount;
		this.transType = transType;
		this.transNarrative = transNarrative;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public LocalDate getValueDate() {
		return valueDate;
	}

	public void setValueDate(LocalDate localDate) {
		this.valueDate = localDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getTransNarrative() {
		return transNarrative;
	}

	public void setTransNarrative(String transNarrative) {
		this.transNarrative = transNarrative;
	}

}
