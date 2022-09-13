package com.spring.data.exception;

public class UserAlreayExistsException extends Exception {
	private String msg;

	public UserAlreayExistsException(String msg) {
		super();
		this.msg = msg;
	}
	

}
