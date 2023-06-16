package com.ecommerce.main.service;

import com.ecommerce.main.model.UserDetails;

public interface LoginService {

	public UserDetails getUserDetailsByUserNameAndPassword(String userName, String password);

}
