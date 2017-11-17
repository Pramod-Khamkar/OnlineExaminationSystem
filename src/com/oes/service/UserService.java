package com.oes.service;

import com.oes.dto.UserDTO;

public interface UserService {

	Boolean registerUser(UserDTO userDTO);

	UserDTO authenticateUser(UserDTO userDTO);
	
}
