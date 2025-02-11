package com.example.demo.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Admin;
import com.example.demo.Entity.UserInfo;
import com.example.demo.repo.adminRepo;
import com.example.demo.service.serviceadmininter;
@Service
public class Adminimpl  implements serviceadmininter{
	
	@Autowired 
	private adminRepo repo;
	

	@Override
	public String registerAdmin(Admin admin) {
		
		Optional<Admin> exitadmin=repo.findByAdminname(admin.getAdminname());
		if(exitadmin.isPresent())
		{
			return "Admin is Register add new Admin";
		}
		repo.save(admin);
		return "admin register of :"+admin.getAdminname();
	}

	@Override
	public String adminlogin(Admin admin) {
		Optional<Admin> exituser=repo.findByAdminname( admin.getAdminname());
		if(exituser.isPresent() && exituser.get().getPassword().equals(admin.getPassword()))
		{
			   return "Login successful ";
		}
		return "invalid login password and username";
		
		
		
		
		
	}

	@Override
	public String logout(String username) {
		
	  Optional<Admin> exitadmin=repo.findByAdminname(username);
	  if(exitadmin.isPresent())
	  {
		 return username+"logout::";
	  }
		return username +"not found";
	}

}
