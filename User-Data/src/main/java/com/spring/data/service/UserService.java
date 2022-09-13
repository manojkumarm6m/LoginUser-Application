package com.spring.data.service;

import java.util.List;

import com.spring.data.entity.User;
import com.spring.data.exception.UserAlreayExistsException;
import com.spring.data.exception.UserNotFoundException;

public interface UserService {
	
	public List<User> getAll();
	
	public User findByEmail(String email) throws UserNotFoundException;
	
	public boolean check(String email, String pwd);
	
	public String saveData(User data) throws UserAlreayExistsException;
	
	public String updateData(User data) throws UserNotFoundException;
	
	public String deleteByEmail(String email) throws UserNotFoundException;
	

}
