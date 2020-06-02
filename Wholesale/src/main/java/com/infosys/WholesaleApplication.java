package com.infosys;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.infosys.entity.Account;
import com.infosys.entity.Transaction;
import com.infosys.service.AccountService;

@SpringBootApplication
public class WholesaleApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(WholesaleApplication.class, args);
		AccountService service = context.getBean(AccountService.class);
		Account accOne = new Account(58309209, "56789", "SGSavings726", "Savings", LocalDate.of(2018, 11, 11), "SGD",
				84327.51);
		Account accTwo = new Account(79106619, "56789", "AUSavings933", "Savings", LocalDate.of(2018, 11, 11), "AUD",
				88005.93);
		Account accThree = new Account(3211234, "56789", "SGCurrent456", "Current", LocalDate.of(2018, 11, 11), "SGD",
				38010.62);
		Account accFour = new Account(80250340, "56789", "AUCurrent789", "Current", LocalDate.of(2018, 11, 11), "AUD",
				50664.65);
		service.createAccount(accOne);
		service.createAccount(accTwo);
		service.createAccount(accThree);
		service.createAccount(accFour);
		Transaction transOne = new Transaction(123231321, 58309209, "SGSavings726", LocalDate.of(2012, 12, 12), "SGD",
				0.0, 3801.45, "Credit", "");
		Transaction transTwo = new Transaction(123231322, 79106619, "AUSavings933", LocalDate.of(2012, 12, 12), "AUD",
				2978.43, 0.0, "Debit", "");
		service.createTransactions(transOne);
		Transaction transThree = new Transaction(123231323, 58309209, "SGSavings726", LocalDate.of(2012, 12, 12), "SGD",
				0.0, 5632.65, "Credit", "");
		Transaction transFour = new Transaction(123231324, 79106619, "AUSavings933", LocalDate.of(2012, 12, 12), "AUD",
				0.0, 1987.33, "Credit", "");
		Transaction transFive = new Transaction(123231325, 58309209, "SGSavings726", LocalDate.of(2012, 12, 12), "SGD",
				0.0, 7864.12, "Credit", "");
		service.createTransactions(transOne);
		service.createTransactions(transTwo);
		service.createTransactions(transThree);
		service.createTransactions(transFour);
		service.createTransactions(transFive);
	}

}
