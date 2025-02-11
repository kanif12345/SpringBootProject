package com.example.demo.repo;


import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Admin;
@Repository
public interface adminRepo extends JpaRepository<Admin, Integer> {
	
	Optional<Admin>  findByAdminname(String adminname);
	

	
	


}
