package com.oes.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oes.bo.QuestionsBO_C;
import com.oes.bo.QuestionsBO_CPP;
import com.oes.bo.QuestionsBO_JAVA;
import com.oes.bo.TestBO;

@Repository
public class UserTestDAOImpl implements UserTestDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionsBO_C> getCQuestionData(int startPos) {
		Session ses=null;
		Criteria criteria=null;
		List<QuestionsBO_C> list=null;
		ses=sessionFactory.getCurrentSession();
		criteria=ses.createCriteria(QuestionsBO_C.class);
		criteria.setFirstResult(startPos);
		criteria.setMaxResults(1);
		list=criteria.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getCQuestionCount() {
		Session ses=null;
		Criteria criteria=null;
		Projection rowCount;
		List<Object> list=null;
		long count;
		ses=sessionFactory.getCurrentSession();
		criteria=ses.createCriteria(QuestionsBO_C.class);
		rowCount=Projections.rowCount();
		criteria.setProjection(rowCount);
		list=criteria.list();
		count=(Long)list.get(0);
		return ((int)count);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionsBO_CPP> getCPPQuestionData(int startPos) {
		Session ses=null;
		Criteria criteria=null;
		List<QuestionsBO_CPP> list=null;
		ses=sessionFactory.getCurrentSession();
		criteria=ses.createCriteria(QuestionsBO_CPP.class);
		criteria.setFirstResult(startPos);
		criteria.setMaxResults(1);
		list=criteria.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getCPPQuestionCount() {
		Session ses=null;
		Criteria criteria=null;
		Projection rowCount;
		List<Object> list=null;
		long count;
		ses=sessionFactory.getCurrentSession();
		criteria=ses.createCriteria(QuestionsBO_CPP.class);
		rowCount=Projections.rowCount();
		criteria.setProjection(rowCount);
		list=criteria.list();
		count=(Long)list.get(0);
		return ((int)count);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionsBO_JAVA> getJAVAQuestionData(int startPos) {
		Session ses=null;
		Criteria criteria=null;
		List<QuestionsBO_JAVA> list=null;
		ses=sessionFactory.getCurrentSession();
		criteria=ses.createCriteria(QuestionsBO_JAVA.class);
		criteria.setFirstResult(startPos);
		criteria.setMaxResults(1);
		list=criteria.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getJAVAQuestionCount() {
		Session ses=null;
		Criteria criteria=null;
		Projection rowCount;
		List<Object> list=null;
		long count;
		ses=sessionFactory.getCurrentSession();
		criteria=ses.createCriteria(QuestionsBO_JAVA.class);
		rowCount=Projections.rowCount();
		criteria.setProjection(rowCount);
		list=criteria.list();
		count=(Long)list.get(0);
		return ((int)count);
	}

	@Override
	public Boolean storeResult(TestBO testBO) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		long result =  (long) session.save(testBO);
		if(result!=0)
			return true;
		else
			return false;
	}
}
