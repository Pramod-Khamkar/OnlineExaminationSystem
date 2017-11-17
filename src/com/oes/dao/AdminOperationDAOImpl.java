package com.oes.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oes.bo.QuestionsBO_C;
import com.oes.bo.QuestionsBO_CPP;
import com.oes.bo.QuestionsBO_JAVA;
import com.oes.bo.TestBO;
import com.oes.bo.UserBO;

@Repository
public class AdminOperationDAOImpl implements AdminOperationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Boolean addQuestionToCTable(QuestionsBO_C questionsBO_C) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		long result = (long) session.save(questionsBO_C);
		if (result != 0)
			return true;
		else
			return false;

	}

	@Override
	public Boolean addQuestionToCPPTable(QuestionsBO_CPP questionsBO_CPP) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		long result = (long) session.save(questionsBO_CPP);
		if (result != 0)
			return true;
		else
			return false;
	}

	@Override
	public Boolean addQuestionToJAVATable(QuestionsBO_JAVA questionsBO_JAVA) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		long result = (long) session.save(questionsBO_JAVA);
		if (result != 0)
			return true;
		else
			return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionsBO_C> getCQuestionList() {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		List<QuestionsBO_C> questionsBO_CList = session.createQuery("from QuestionsBO_C").list();
		return questionsBO_CList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionsBO_CPP> getCPPQuestionList() {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		List<QuestionsBO_CPP> questionsBO_CPPList = session.createQuery("from QuestionsBO_CPP").list();
		return questionsBO_CPPList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionsBO_JAVA> getJAVAQuestionList() {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		List<QuestionsBO_JAVA> questionsBO_JAVAList = session.createQuery("from QuestionsBO_JAVA").list();
		return questionsBO_JAVAList;
	}

	@Override
	public Boolean deleteCQuestionFromTable(long questionId) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		Query query = session.createQuery("from QuestionsBO_C where questionId=:questionId");
		query.setLong("questionId", questionId);
		QuestionsBO_C fetchedQuestion = (QuestionsBO_C) query.uniqueResult();
		if(fetchedQuestion!=null){
			session.delete(fetchedQuestion);
			return true;
		}
		else
			return false;
	}
	

	@Override
	public Boolean deleteCPPQuestionFromTable(long questionId) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}		
		Query query = session.createQuery("from QuestionsBO_CPP where questionId=:questionId");
		query.setLong("questionId", questionId);
		QuestionsBO_CPP fetchedQuestion = (QuestionsBO_CPP) query.uniqueResult();
		if(fetchedQuestion!=null){
			session.delete(fetchedQuestion);
			return true;
		}
		else
			return false;
	}

	@Override
	public Boolean deleteJAVAQuestionFromTable(long questionId) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}		
		Query query = session.createQuery("from QuestionsBO_JAVA where questionId=:questionId");
		query.setLong("questionId", questionId);
		QuestionsBO_JAVA fetchedQuestion = (QuestionsBO_JAVA) query.uniqueResult();
		if(fetchedQuestion!=null){
			session.delete(fetchedQuestion);
			return true;
		}
		else
			return false;
	}

	@Override
	public QuestionsBO_C getQuestionByIdFromCTable(long questionId) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}		
		Query query = session.createQuery("from QuestionsBO_C where questionId=:questionId");
		query.setLong("questionId", questionId);
		QuestionsBO_C fetchedQuestion = (QuestionsBO_C) query.uniqueResult();
		if(fetchedQuestion!=null){
			return fetchedQuestion;
		}
		else
			return null;
	}

	@Override
	public QuestionsBO_CPP getQuestionByIdFromCPPTable(long questionId) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}		
		Query query = session.createQuery("from QuestionsBO_CPP where questionId=:questionId");
		query.setLong("questionId", questionId);
		QuestionsBO_CPP fetchedQuestion = (QuestionsBO_CPP) query.uniqueResult();
		if(fetchedQuestion!=null){
			return fetchedQuestion;
		}
		else
			return null;
	}

	@Override
	public QuestionsBO_JAVA getQuestionByIdFromJAVATable(long questionId) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}		
		Query query = session.createQuery("from QuestionsBO_JAVA where questionId=:questionId");
		query.setLong("questionId", questionId);
		QuestionsBO_JAVA fetchedQuestion = (QuestionsBO_JAVA) query.uniqueResult();
		if(fetchedQuestion!=null){
			return fetchedQuestion;
		}
		else
			return null;
	}

	@Override
	public Boolean updateQuestionToCTable(QuestionsBO_C questionsBO_C) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		if(session!=null) {
			session.update(questionsBO_C);
			return true;
		}
		return false;
	}

	@Override
	public Boolean updateQuestionToCPPTable(QuestionsBO_CPP questionsBO_CPP) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		if(session!=null) {
			session.update(questionsBO_CPP);
			return true;
		}
		return false;
	}

	@Override
	public Boolean updateQuestionToJAVATable(QuestionsBO_JAVA questionsBO_JAVA) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		if(session!=null) {
			session.update(questionsBO_JAVA);
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserBO> getUserListFromDB() {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		List<UserBO> userList = session.createQuery("from UserBO").list();
		if(userList!=null) {
			return userList;
		}
		return null;
	}

	@Override
	public UserBO getUserByID(long userId) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}		
		Query query = session.createQuery("from UserBO where userId=:userId");
		query.setLong("userId", userId);
		UserBO userBO = (UserBO) query.uniqueResult();
		if(userBO!=null){
			return userBO;
		}
		else
			return null;
	}

	@Override
	public Boolean updateUserData(UserBO userBO) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		if(session!=null) {
			session.update(userBO);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteUserFromDB(long userId) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}		
		Query query = session.createQuery("from UserBO where userId=:userId");
		query.setLong("userId", userId);
		UserBO fetchedQuestion = (UserBO) query.uniqueResult();
		if(fetchedQuestion!=null){
			session.delete(fetchedQuestion);
			return true;
		}
		else
			return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TestBO> getUserResultFromDB() {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		List<TestBO> testBO_ResultList = session.createQuery("from TestBO").list();
		return testBO_ResultList;
	}

	@Override
	public Boolean deleteTestResultFromDB(long testId) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}		
		Query query = session.createQuery("from TestBO where testId=:testId");
		query.setLong("testId", testId);
		TestBO fetchedQuestion = (TestBO) query.uniqueResult();
		if(fetchedQuestion!=null){
			session.delete(fetchedQuestion);
			return true;
		}
		else
			return false;
	}
}
