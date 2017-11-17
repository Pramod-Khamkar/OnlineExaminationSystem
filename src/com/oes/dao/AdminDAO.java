package com.oes.dao;

import com.oes.bo.AdminBO;

public interface AdminDAO {

	Boolean registerAdmin(AdminBO adminBO);

	AdminBO authenticateAdmin(AdminBO adminBO);

}
