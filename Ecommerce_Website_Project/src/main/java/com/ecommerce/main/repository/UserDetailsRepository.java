package com.ecommerce.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.ecommerce.main.model.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer>{
	public UserDetails findByUserType(String userType);
	
	public UserDetails findByUserNameAndPassword(String userName, String password);


}
