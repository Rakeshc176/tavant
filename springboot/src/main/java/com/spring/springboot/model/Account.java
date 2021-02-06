package com.spring.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="accounts")
public class Account {

	@Id
	private Integer accid;
	private String accFirstName;
	private String accLastName;
	private String accType;
	
	
}
