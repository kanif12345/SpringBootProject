package com.example.demo.Controoler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Admin;
import com.example.demo.Entity.UserInfo;
import com.example.demo.impl.Adminimpl;
import com.example.demo.impl.userImpl;

@RestController
@RequestMapping("/admin")
public class AdminControoler {
	
	
	
	@Autowired
	private Adminimpl ser;
	
	@Autowired
	private userImpl userser;
	
	
	
	@PostMapping("/save")
	public ResponseEntity<?>saveadmin(@RequestBody Admin admin)
	{
		 String savedUser = ser.registerAdmin(admin);
		    return new ResponseEntity<>(savedUser, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<?>login(@RequestBody Admin admin)
	{
		 String savedUser = ser.adminlogin(admin);
		    return new ResponseEntity<>(savedUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleted/{id}")
	public ResponseEntity<?> deletedById(@PathVariable ("id") Long id)
	{
		String deleted=userser.deletebyid(id);
		return new ResponseEntity<>(deleted,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getUserById(@PathVariable ("id") Long id)
	{
		Optional<UserInfo> deleted=userser.getbyid(id);
		return new ResponseEntity<>(deleted,HttpStatus.OK);
	}
	@GetMapping("/getallusers")
	public ResponseEntity<?> getUsers()
	{
		List<UserInfo> getall=userser.getalluser();
		return new ResponseEntity<>(getall,HttpStatus.OK);
	}
}                           
