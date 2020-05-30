package com.infosys.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction {
	@Id
	private int transactionId;
	private int accountNumber;
	private String accountName;
	private Date valueDate;
	private String currency;
	private double debitAmount, creditAmount;
	private String transType, transNarrative;

	public Transaction() {
		super();
	}

	public Transaction(int transactionId, int accountNumber, String accountName, Date valueDate, String currency,
			double debitAmount, double creditAmount, String transType, String transNarrative) {
		super();
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.valueDate = valueDate;
		this.currency = currency;
		this.debitAmount = debitAmount;
		this.creditAmount = creditAmount;
		this.transType = transType;
		this.transNarrative = transNarrative;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
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

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
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
