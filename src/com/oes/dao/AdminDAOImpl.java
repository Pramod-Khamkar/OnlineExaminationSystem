package com.oes.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oes.bo.AdminBO;

@Repository
public class AdminDAOImpl implements AdminDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Boolean registerAdmin(AdminBO adminBO) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		long result =  (long) session.save(adminBO);
		if(result!=0)
			return true;
		else
			return false;
	}

	@Override
	public AdminBO authenticateAdmin(AdminBO adminBO) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from AdminBO where mailId=:username and password=:password");
		query.setString("username", adminBO.getMailId());
		query.setString("password", adminBO.getPassword());
		AdminBO fetchedUser = (AdminBO) query.uniqueResult();
		if (fetchedUser != null) {
			if (fetchedUser.getMailId().equals(adminBO.getMailId()) && fetchedUser.getPassword().equals(adminBO.getPassword())) {
				return fetchedUser;
			}
		} 
		return null;
	}


}
