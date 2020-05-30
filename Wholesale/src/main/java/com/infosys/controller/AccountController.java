package com.infosys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.dto.AccountDto;
import com.infosys.dto.TransactionDto;
import com.infosys.exception.NoSuchAccountException;
import com.infosys.service.AccountService;

@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;

	// returns list of all the accounts by using Get method
	@GetMapping("/accounts")
	public List<AccountDto> getAccountDetails() {
		return accountService.getAllAccounts();
	}

	// returns list of all the transactions made by a selected account using Get method
	@GetMapping("/transactions/{accountNumber}")
	public ResponseEntity<List<TransactionDto>> getTransDetails(@PathVariable("accountNumber") int accountNum)
			throws NoSuchAccountException {
		List<TransactionDto> response = accountService.getAllTransactions(accountNum);
		return ResponseEntity.ok(response);
	}
}
