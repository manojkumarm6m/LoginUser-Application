package com.spring.data.exception;

public class UserNotFoundException extends Exception {
	
	private String msg;

	public UserNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	
	

}
