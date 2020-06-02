package com.infosys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	List<Account> findByAccountNumber(int accountNumber);

	List<Account> findByUserId(String userId);
}
