package com.infosys.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.infosys.dto.AccountDto;
import com.infosys.dto.TransactionDto;
import com.infosys.entity.Account;
import com.infosys.entity.Transaction;
import com.infosys.exception.NoSuchAccountException;
import com.infosys.repository.AccountRepository;
import com.infosys.repository.TransactionRepository;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {
	@InjectMocks
	AccountServiceImpl account;
	@Mock
	TransactionRepository transRepo;
	@Mock
	AccountRepository repo;
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void getAllAccountsTest() {
		List<Account> list = new ArrayList<Account>();
		Account accOne = new Account(58309209, "56789", "SGSavings726", "Savings", LocalDate.of(2018, 11, 11), "SGD",
				84327.51);
		Account accTwo = new Account(79106619, "56789", "AUSavings933", "Savings", LocalDate.of(2018, 11, 11), "AUD",
				88005.93);
		Account accThree = new Account(3211234, "56789", "SGCurrent456", "Current", LocalDate.of(2018, 11, 11), "SGD",
				38010.62);
		Account accFour = new Account(80250340, "56789", "AUCurrent789", "Current", LocalDate.of(2018, 11, 11), "AUD",
				50664.65);

		list.add(accOne);
		list.add(accTwo);
		list.add(accThree);
		list.add(accFour);

		when(repo.findByUserId("56789")).thenReturn(list);

		List<AccountDto> accountList = account.getAllAccounts("56789");

		assertEquals(4, accountList.size());
		assertEquals(accountList.get(0).getAccountNumber(), accOne.getAccountNumber());
		assertEquals(accountList.get(1).getCurrency(), accTwo.getCurrency());
		verify(repo, times(1)).findByUserId("56789");
	}

	@Test
	public void getAllTransactionsPositiveTest() {
		List<Transaction> transList = new ArrayList<Transaction>();
		Transaction transOne = new Transaction(123231322, 79106619, "AUSavings933", LocalDate.of(2012, 12, 12), "AUD",
				2978.43, 0.0, "Debit", "");
		Transaction transTwo = new Transaction(123231324, 79106619, "AUSavings933", LocalDate.of(2012, 12, 12), "AUD",
				0.0, 1987.33, "Credit", "");

		transList.add(transOne);
		transList.add(transTwo);

		when(transRepo.findByAccountNumber(79106619)).thenReturn(transList);

		try {
			List<TransactionDto> resList = account.getAllTransactions(79106619);
			assertEquals(2, resList.size());
		} catch (Exception e) {
			Assert.fail("Exception: " + e);
		}
		verify(transRepo, times(1)).findByAccountNumber(79106619);
	}

	@Test
	public void getAllTransactionsNegativeTest() throws NoSuchAccountException {
		List<Transaction> list = new ArrayList<Transaction>();
		expectedException.expect(NoSuchAccountException.class);
		expectedException.expectMessage("Account Number does not exist");
		Mockito.when(transRepo.findByAccountNumber(Mockito.anyInt())).thenReturn(list);
		account.getAllTransactions(1);
	}
}
