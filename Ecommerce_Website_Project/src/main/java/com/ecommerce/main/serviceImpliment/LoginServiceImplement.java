package com.ecommerce.main.serviceImpliment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.main.exceptionHandller.UserNotFoundException;
import com.ecommerce.main.model.UserDetails;
import com.ecommerce.main.repository.UserDetailsRepository;
import com.ecommerce.main.service.LoginService;

@Service
public class LoginServiceImplement implements LoginService {
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@Override
	public UserDetails getUserDetailsByUserNameAndPassword(String userName, String password) {
		UserDetails userDetails = userDetailsRepository.findByUserNameAndPassword(userName,password);
		if (userDetails!=null) {
			return userDetails;
		} 
	else {
		 throw new UserNotFoundException("Username or password is invelid");
	}
	}
}
