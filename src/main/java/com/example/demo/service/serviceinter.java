package com.example.demo.service;



import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.UserInfo;

public interface serviceinter {
	
	
	 public String registerUser(UserInfo user);
	 
	 public  String userlogin(UserInfo user);
	 
	 public String logout(String username);
	 
	 
	 public String deletebyid(long id);
	 
	 
	 public List<UserInfo> getalluser();
	
	 public  Optional<UserInfo> getbyid(long id);
	 
	
	
	

}
