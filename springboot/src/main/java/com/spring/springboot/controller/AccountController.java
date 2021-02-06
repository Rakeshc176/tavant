package com.spring.springboot.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springboot.exception.ResourceNotFoundException;
import com.spring.springboot.model.Account;
import com.spring.springboot.repository.accountRepository;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private accountRepository repository;

	@GetMapping("/all")
	public List<Account> getAccounts() {
		return this.repository.findAll();
	}

	@GetMapping("/{id}")
	public Account getAccount(@PathVariable Integer id) throws ResourceNotFoundException {
		return this.repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Record Not Found"));
	}

	
	@PostMapping("/create")
	public Account create(@RequestBody @Valid Account acc) {
		return this.repository.save(acc);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		this.repository.deleteById(id);
	}

	@PutMapping("/{Id}")
	public ResponseEntity<Account> updateAccount(@PathVariable("Id") Integer id,
			@Valid @RequestBody Account resourceDetails) throws ResourceNotFoundException {

		Account acc = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Record Not Found"));

		acc.setAccid(resourceDetails.getAccid());
		acc.setAccFirstName(resourceDetails.getAccFirstName());
		acc.setAccLastName(resourceDetails.getAccLastName());
		acc.setAccType(resourceDetails.getAccType());

		final Account newDetails = repository.save(acc);
		return ResponseEntity.ok(newDetails);
	}

}
