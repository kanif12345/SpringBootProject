package com.example.demo.impl;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.UserInfo;
import com.example.demo.repo.userRepo;
import com.example.demo.service.serviceinter;

@Service
public class userImpl  implements serviceinter{

	 @Autowired
	 private  userRepo repo;

	@Override
	public String registerUser(UserInfo user) {
		
		if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
	        return "Error: Username cannot be null or empty";
	    }
		 Optional<UserInfo> exituser=repo.findByUsername(user.getUsername());
		 if(exituser.isPresent())
		 
			 {
					return "user is Register add new user";
				}
				repo.save(user);
				return "user register of :"+user.getUsername();
		 
			
		
	}

	@Override
	public String userlogin(UserInfo user) {
		
		Optional<UserInfo> exituser=repo.findByUsername(user.getUsername());
		if(exituser.isPresent() && exituser.get().getPassword().equals(user.getPassword()))
		{
			return "Login done";
		}
		
		return "invalid login password and username";
	}

	@Override
	public String logout(String username) {
		Optional<UserInfo> exituser=repo.findByUsername(username);
		
		if(exituser.isPresent())
		{
			return "logout done of:"+username;
		}
		return "invalid username";
	}

	@Override
	public String deletebyid(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> getalluser() {
		
		return repo.findAll();
	}

	@Override
	public Optional<UserInfo> getbyid(long id) {
		
		if(repo.existsById(id))
		{
		  Optional<UserInfo> exit=	repo.findById(id);
		   return exit;
		}
		
		return null;
	}
 

}
	  
	 
	 
	 
	




