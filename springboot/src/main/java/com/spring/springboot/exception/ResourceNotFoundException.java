package com.spring.springboot.exception;

public class ResourceNotFoundException extends Exception {
@Override
public String toString() {
	// TODO Auto-generated method stub
	return super.toString()+this.getMessage();
}

public ResourceNotFoundException(String msg) {
	// TODO Auto-generated constructor stub
	super(msg);
}
}