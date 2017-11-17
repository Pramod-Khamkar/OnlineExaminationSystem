package com.oes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oes.bo.UserBO;
import com.oes.dao.UserDAO;
import com.oes.dto.UserDTO;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public Boolean registerUser(UserDTO userDTO) {
		UserBO userBO = new UserBO();
		userBO.setFirstName(userDTO.getFirstName());
		userBO.setLastName(userDTO.getLastName());
		userBO.setAge(userDTO.getAge());
		userBO.setDateOfBirth(userDTO.getDateOfBirth());
		userBO.setGender(userDTO.getGender());
		userBO.setGraduationCollageName(userDTO.getGraduationCollageName());
		userBO.setMailId(userDTO.getMailId());
		userBO.setPassword(userDTO.getPassword());
		userBO.setMarks_ssc(userDTO.getMarks_ssc());
		userBO.setMarks_hsc(userDTO.getMarks_hsc());
		userBO.setPostGraduationCollageName(userDTO.getPostGraduationCollageName());
		userBO.setPhone(userDTO.getPhone());
		userBO.setMarks_graduation(userDTO.getMarks_graduation());
		userBO.setMarks_postgraduation(userDTO.getMarks_postgraduation());
		
		return userDAO.registerUser(userBO);
	}

	@Override
	public UserDTO authenticateUser(UserDTO userDTO) {
		UserBO userBO = new UserBO();
		userBO.setMailId(userDTO.getMailId());
		userBO.setPassword(userDTO.getPassword());
		
		UserBO fechedData = userDAO.authenticateUser(userBO);
		if(fechedData!=null) {
			userDTO.setUserId(fechedData.getUserId());
			userDTO.setFirstName(fechedData.getFirstName());
			userDTO.setLastName(fechedData.getLastName());
			userDTO.setAge(fechedData.getAge());
			userDTO.setDateOfBirth(fechedData.getDateOfBirth());
			userDTO.setGender(fechedData.getGender());
			userDTO.setGraduationCollageName(fechedData.getGraduationCollageName());
			userDTO.setMailId(fechedData.getMailId());
			userDTO.setPassword(fechedData.getPassword());
			userDTO.setMarks_ssc(fechedData.getMarks_ssc());
			userDTO.setMarks_hsc(fechedData.getMarks_hsc());
			userDTO.setPostGraduationCollageName(fechedData.getPostGraduationCollageName());
			userDTO.setPhone(fechedData.getPhone());
			userDTO.setMarks_graduation(fechedData.getMarks_graduation());
			userDTO.setMarks_postgraduation(fechedData.getMarks_postgraduation());
			
			return userDTO;
		}
		
		return null;
	}

}
