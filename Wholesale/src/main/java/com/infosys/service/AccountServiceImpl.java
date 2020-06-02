package com.infosys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.dto.AccountDto;
import com.infosys.dto.TransactionDto;
import com.infosys.entity.Account;
import com.infosys.entity.Transaction;
import com.infosys.exception.NoSuchAccountException;
import com.infosys.repository.AccountRepository;
import com.infosys.repository.TransactionRepository;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private TransactionRepository transactionRepo;

	public Account createAccount(Account account) {
		return accountRepo.save(account);
	}

	// returns a list of all the Accounts present in the Account database
	public List<AccountDto> getAllAccounts(String userId) {
		List<Account> account = accountRepo.findByUserId(userId);
		List<AccountDto> list = new ArrayList<AccountDto>();
		for (Account entity : account) {
			// conversion of entity to dto
			AccountDto dto = new AccountDto();
			dto.setAccountNumber(entity.getAccountNumber());
			dto.setAccountName(entity.getAccountName());
			dto.setAccountType(entity.getAccountType());
			dto.setCurrency(entity.getCurrency());
			dto.setAvailableBalance(entity.getAvailableBalance());
			dto.setBalanceDate(entity.getBalanceDate());
			list.add(dto);
		}
		return list;
	}

	/*
	 * returns list of all the transactions made by a selected account if the
	 * account number is present in database otherwise throws exception
	 */
	public List<TransactionDto> getAllTransactions(int accountNumber) throws NoSuchAccountException {
		List<Transaction> transactions = transactionRepo.findByAccountNumber(accountNumber);
		List<TransactionDto> list = new ArrayList<TransactionDto>();
		if (transactions.isEmpty()) {
			throw new NoSuchAccountException("Account Number does not exist");
		} else {
			for (Transaction entity : transactions) {
				TransactionDto dto = new TransactionDto();
				// conversion of entity to dto
				dto.setAccountNumber(entity.getAccountNumber());
				dto.setAccountName(entity.getAccountName());
				dto.setCreditAmount(entity.getCreditAmount());
				dto.setDebitAmount(entity.getDebitAmount());
				dto.setCurrency(entity.getCurrency());
				dto.setValueDate(entity.getValueDate());
				dto.setTransType(entity.getTransType());
				dto.setTransNarrative(entity.getTransNarrative());
				list.add(dto);
			}
			return list;
		}
	}
	public Transaction createTransactions(Transaction transaction) {
		return transactionRepo.save(transaction);
	}

}
