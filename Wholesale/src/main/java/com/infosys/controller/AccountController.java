package com.infosys.controller;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.infosys.dto.AccountDto;
import com.infosys.dto.TransactionDto;
import com.infosys.exception.NoSuchAccountException;
import com.infosys.service.AccountService;

@RestController
@Validated
public class AccountController {
	@Autowired
	private AccountService accountService;
	private static final Logger logger = LogManager.getLogger(AccountController.class);

	// returns list of all the accounts by using Get method
	@GetMapping("/accounts/{userId}")
	public ResponseEntity<List<AccountDto>> getAccountDetails(
			@PathVariable("userId") @Pattern(regexp = "[0-9]{5}", message = "UserId is invalid") String userId)
			throws Exception {
		List<AccountDto> response = accountService.getAllAccounts(userId);
		logger.debug("Hello from AccountDetails - userID : " + userId);
		logger.error("Error in UserId");
		return ResponseEntity.ok(response);

	}

	// returns list of all the transactions made by a selected account using Get
	// method
	@GetMapping("/transactions/{accountNumber}")
	public ResponseEntity<List<TransactionDto>> getTransDetails(
			@PathVariable("accountNumber") @Min(value = 1, message = "Account Number can't be less than 1") @Max(value = 99999999, message = "Account Number can't be greater than 99999999") int accountNum)
			throws NoSuchAccountException, Exception {
		List<TransactionDto> response = accountService.getAllTransactions(accountNum);
		logger.debug("Debugging AccountController getTransDetails method for transactionList : {} ", () -> accountNum);
		logger.error("Account Number does not exist");
		return ResponseEntity.ok(response);
	}
}
