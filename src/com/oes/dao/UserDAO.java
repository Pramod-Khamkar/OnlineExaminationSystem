package com.oes.dao;

import com.oes.bo.UserBO;

public interface UserDAO {

	Boolean registerUser(UserBO userBO);

	UserBO authenticateUser(UserBO userBO);

}
