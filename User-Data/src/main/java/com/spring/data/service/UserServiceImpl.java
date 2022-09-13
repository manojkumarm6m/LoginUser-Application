package com.spring.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.data.entity.User;
import com.spring.data.exception.UserAlreayExistsException;
import com.spring.data.exception.UserNotFoundException;
import com.spring.data.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PasswordEncoder pwdEncoder;

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		List<User> all=userRepo.findAll();
		return all;
	}

	public User findByEmail(String email) throws UserNotFoundException{
		// TODO Auto-generated method stub
		if(!userRepo.existsById(email)) {
			throw new UserNotFoundException("User Not Found With This Email"+email);
		}
		else {
			return userRepo.findById(email).get();

		}
		
	}

	@Override
	public boolean check(String email, String pwd) {
		// TODO Auto-generated method stub
		User data=new User();
		if(userRepo.existsById(email)) {
			data=userRepo.findById(email).get();
			if(pwdEncoder.matches(pwd, data.getPassword().replace(',','/'))) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String saveData(User data) throws UserAlreayExistsException {
		
		// TODO Auto-generated method stub
		try {
			if(userRepo.existsById(data.getEmail())) {
				throw new UserAlreayExistsException("User Alredy Exists");
			}
			else {
				if(data.getPassword()==null) {
					return "Password Should Required";
				}
				else {
					data.setPassword(pwdEncoder.encode(data.getPassword()).replace('/',','));
					userRepo.save(data);
					return "Account Created Successfully! 🙂";
				}
			}
		} catch(UserAlreayExistsException e) {
			e.printStackTrace();
		}
		return "User already Exists With the Same Email!";
	}

	
	@Override
	public String updateData(User data) throws UserNotFoundException{
		// TODO Auto-generated method stub
		try {
			if(!(userRepo.existsById(data.getEmail()))) {
				throw new UserNotFoundException("User Not Found With This Email");
			}
			else {
				if(data.getUserName()=="") {
					return "Username Should Not Be Empty";
				}
				if(data.getPassword()=="") {
					return "Password Should Not Be Empty";
				}
				if(data.getPassword().length()<6) {
					return "Password Should Must Contain Atleast 6 Characters";
				}
				if(data.getMobileNo()=="") {
					return "Mobile Number Should Not Be Null";
				}
				if(!(data.getMobileNo().matches("^[0-9]+$"))) {
					return "Mobile Number Must Contain Digits";
				}
				if((data.getMobileNo().length()>10) || (data.getMobileNo().length()<10)) {
					return "Mobile Number Must Contain 10 Digits";
				}
				
				else {
					data.setPassword(pwdEncoder.encode(data.getPassword()).replace('/',','));
					userRepo.save(data);
					return "Details Updated Successfully";
				}
			}
		} catch(UserNotFoundException e) {
			e.printStackTrace();
		}
		return "User Not Found With This Email";
	}

	@Override
	public String deleteByEmail(String email) throws UserNotFoundException{
		// TODO Auto-generated method stub
		
		
			if(!(userRepo.existsById(email))) {
				return "User "+email+ " not exists";
			}
			else {
				userRepo.deleteById(email);
				return "User "+email+ " Deleted Successfully";
			} 
		}
}
