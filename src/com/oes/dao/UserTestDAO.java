package com.oes.dao;

import java.util.List;

import com.oes.bo.QuestionsBO_C;
import com.oes.bo.QuestionsBO_CPP;
import com.oes.bo.QuestionsBO_JAVA;
import com.oes.bo.TestBO;

public interface UserTestDAO {

	List<QuestionsBO_C> getCQuestionData(int startPos);

	int getCQuestionCount();

	List<QuestionsBO_CPP> getCPPQuestionData(int startPos);

	int getCPPQuestionCount();

	List<QuestionsBO_JAVA> getJAVAQuestionData(int startPos);

	int getJAVAQuestionCount();

	Boolean storeResult(TestBO testBO);
	

}
