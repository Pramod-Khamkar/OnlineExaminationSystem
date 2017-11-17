package com.oes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oes.bo.AdminBO;
import com.oes.dao.AdminDAO;
import com.oes.dto.AdminDTO;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDAO adminDAO;
	
	@Override
	public Boolean registerAdmin(AdminDTO adminDTO) {
		AdminBO adminBO = new AdminBO();
		adminBO.setFirstName(adminDTO.getFirstName());
		adminBO.setLastName(adminDTO.getLastName());
		adminBO.setMailId(adminDTO.getMailId());
		adminBO.setPassword(adminDTO.getPassword());
		
		return adminDAO.registerAdmin(adminBO);
	}

	@Override
	public AdminDTO authenticateAdmin(AdminDTO adminDTO) {
		AdminBO adminBO = new AdminBO();
		adminBO.setMailId(adminDTO.getMailId());
		adminBO.setPassword(adminDTO.getPassword());
		
		AdminBO fechedData = adminDAO.authenticateAdmin(adminBO);
		if(fechedData!=null) {
			adminDTO.setAdminId(fechedData.getAdminId());
			adminDTO.setFirstName(fechedData.getFirstName());
			adminDTO.setLastName(fechedData.getLastName());
			adminDTO.setMailId(fechedData.getMailId());
			adminDTO.setPassword(fechedData.getPassword());
			
			return adminDTO;
		}
		
		return null;
	}

}
