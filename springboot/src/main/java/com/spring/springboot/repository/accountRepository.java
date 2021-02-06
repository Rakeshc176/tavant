package com.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.springboot.model.Account;


public interface accountRepository extends JpaRepository<Account, Integer> {

}
