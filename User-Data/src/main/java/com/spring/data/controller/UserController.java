package com.spring.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.data.entity.User;
import com.spring.data.exception.UserAlreayExistsException;
import com.spring.data.exception.UserNotFoundException;
import com.spring.data.service.UserService;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/user")
public class UserController implements UserService{
	
	@Autowired
	UserService userServ;

	@GetMapping("/all")
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userServ.getAll();
	}

	@GetMapping("/{email}")
	public User findByEmail(@PathVariable("email") String email) throws UserNotFoundException {
		// TODO Auto-generated method stub
		
		return userServ.findByEmail(email);
	}

	@GetMapping("/{email}/{password}")
	public boolean check(@PathVariable("email") String email, @PathVariable("password") String pwd) {
		// TODO Auto-generated method stub
		return userServ.check(email, pwd);
	}

	@PostMapping("/save")
	public String saveData(@RequestBody User data) throws UserAlreayExistsException {
		// TODO Auto-generated method stub
		return userServ.saveData(data);
	}

	@PutMapping("/update")
	public String updateData(@RequestBody User data) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return userServ.updateData(data);
	}

	@DeleteMapping("/{email}")
	public String deleteByEmail(@PathVariable("email") String email) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return userServ.deleteByEmail(email);
	}

	

}
