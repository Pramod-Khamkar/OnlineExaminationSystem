package com.oes.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oes.bo.UserBO;

@Repository
public class UserDAOImpl  implements UserDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Boolean registerUser(UserBO userBO) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		long result =  (long) session.save(userBO);
		if(result!=0)
			return true;
		else
			return false;
	}
	
	@Override
	public UserBO authenticateUser(UserBO userBO) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from UserBO where mailId=:username and password=:password");
		query.setString("username", userBO.getMailId());
		query.setString("password", userBO.getPassword());
		UserBO fetchedUser = (UserBO) query.uniqueResult();
		if (fetchedUser != null) {
			if (fetchedUser.getMailId().equals(userBO.getMailId()) && fetchedUser.getPassword().equals(userBO.getPassword())) {
				return fetchedUser;
			}
		} 
		return null;
	}

}
