package com.infosys.service;

import java.util.List;

import com.infosys.dto.AccountDto;
import com.infosys.dto.TransactionDto;
import com.infosys.entity.Account;
import com.infosys.entity.Transaction;
import com.infosys.exception.NoSuchAccountException;

public interface AccountService {
	public List<AccountDto> getAllAccounts(String userId);

	public List<TransactionDto> getAllTransactions(int accountNum) throws NoSuchAccountException;

	public Account createAccount(Account account);

	public Transaction createTransactions(Transaction transaction);
}
