package com.example.demo.repo;


import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.example.demo.Entity.UserInfo;
@Repository

public interface userRepo extends JpaRepository<UserInfo, Long> {
	
   Optional<UserInfo>  findByUsername(String username);

	
	


}
