package com.oes.dao;

import java.util.List;

import com.oes.bo.QuestionsBO_C;
import com.oes.bo.QuestionsBO_CPP;
import com.oes.bo.QuestionsBO_JAVA;
import com.oes.bo.TestBO;
import com.oes.bo.UserBO;

public interface AdminOperationDAO {

	Boolean addQuestionToCTable(QuestionsBO_C questionsBO_C);

	Boolean addQuestionToCPPTable(QuestionsBO_CPP questionsBO_CPP);

	Boolean addQuestionToJAVATable(QuestionsBO_JAVA questionsBO_JAVA);

	List<QuestionsBO_C> getCQuestionList();

	List<QuestionsBO_CPP> getCPPQuestionList();

	List<QuestionsBO_JAVA> getJAVAQuestionList();

	Boolean deleteCQuestionFromTable(long questionId);

	Boolean deleteCPPQuestionFromTable(long questionId);

	Boolean deleteJAVAQuestionFromTable(long questionId);

	QuestionsBO_C getQuestionByIdFromCTable(long questionId);

	QuestionsBO_CPP getQuestionByIdFromCPPTable(long questionId);

	QuestionsBO_JAVA getQuestionByIdFromJAVATable(long questionId);

	Boolean updateQuestionToCTable(QuestionsBO_C questionsBO_C);

	Boolean updateQuestionToCPPTable(QuestionsBO_CPP questionsBO_CPP);

	Boolean updateQuestionToJAVATable(QuestionsBO_JAVA questionsBO_JAVA);

	List<UserBO> getUserListFromDB();

	UserBO getUserByID(long userId);

	Boolean updateUserData(UserBO userBO);

	boolean deleteUserFromDB(long userId);

	List<TestBO> getUserResultFromDB();

	Boolean deleteTestResultFromDB(long testId);


}
