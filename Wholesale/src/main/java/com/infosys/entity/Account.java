package com.infosys.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	private int accountNumber;
	private String userId;
	private String accountName;
	private String accountType;
	private LocalDate balanceDate;
	private String currency;
	private double availableBalance;

	public Account() {
		super();
	}

	public Account(int accountNumber, String string, String accountName, String accountType, LocalDate localDate,
			String currency, double availableBalance) {
		super();
		this.accountNumber = accountNumber;
		this.userId = string;
		this.accountName = accountName;
		this.accountType = accountType;
		this.balanceDate = localDate;
		this.currency = currency;
		this.availableBalance = availableBalance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public LocalDate getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(LocalDate balanceDate) {
		this.balanceDate = balanceDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

}
