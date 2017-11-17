package com.oes.service;

import com.oes.dto.AdminDTO;

public interface AdminService {

	Boolean registerAdmin(AdminDTO adminDTO);

	AdminDTO authenticateAdmin(AdminDTO adminDTO);

}
