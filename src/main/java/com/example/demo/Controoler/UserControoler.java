
package com.example.demo.Controoler;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.UserInfo;

import com.example.demo.impl.userImpl;



@RestController
@RequestMapping("/user")
public class UserControoler {
	
	@Autowired
	private userImpl ser;
	
	
	
	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody UserInfo user) {
	    String savedUser = ser.registerUser(user);
	    return new ResponseEntity<>(savedUser, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?>loginuser(@RequestBody UserInfo user)
	{
		String  loginuser=ser.userlogin(user);
		return new ResponseEntity<>(loginuser,HttpStatus.OK);
	}
	@PostMapping("/logout/{username}")
	public ResponseEntity<String> logout(@PathVariable("username") String username){
		String message = ser.logout(username);
		return ResponseEntity.ok(message);
	}


}
