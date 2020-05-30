package com.infosys.service;

import java.util.List;

import com.infosys.dto.AccountDto;
import com.infosys.dto.TransactionDto;
import com.infosys.exception.NoSuchAccountException;

public interface AccountService {
	public List<AccountDto> getAllAccounts();

	public List<TransactionDto> getAllTransactions(int accountNum) throws NoSuchAccountException;
}
