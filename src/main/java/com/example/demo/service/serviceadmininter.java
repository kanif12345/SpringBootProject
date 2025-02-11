package com.example.demo.service;

import com.example.demo.Entity.Admin;


public interface serviceadmininter {
	
	public String registerAdmin(Admin admin);
	
	public String adminlogin(Admin admin);
	
	public String logout(String username);

	
  
}
