package com.oes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oes.bo.QuestionsBO_C;
import com.oes.bo.QuestionsBO_CPP;
import com.oes.bo.QuestionsBO_JAVA;
import com.oes.bo.TestBO;
import com.oes.dao.UserTestDAO;
import com.oes.dto.QuestionsDTO;
import com.oes.dto.UserDTO;
import com.oes.model.CollectResults;
import com.oes.model.Test;

@Service
@Transactional
public class UserTestServiceImpl implements UserTestService {

	@Autowired
	private UserTestDAO userTestDAO;

	@Override
	public List<QuestionsDTO> showCQuestions(int pageNo) {
		int startPos=0;
		List<QuestionsBO_C> listQuestions=null;
		List<QuestionsDTO> listDTO=null;
		QuestionsDTO dto=null;
		//generate StartPosition
		startPos=(pageNo*1)-1;
		
		listQuestions = userTestDAO.getCQuestionData(startPos);
		listDTO=new ArrayList<QuestionsDTO>();
		for(QuestionsBO_C bo : listQuestions){
			dto = new QuestionsDTO();
			dto.setQuestionId(bo.getQuestionId());
			dto.setQuestionDescription(bo.getQuestionDescription());
			dto.setOptionA(bo.getOptionA());
			dto.setOptionB(bo.getOptionB());
			dto.setOptionC(bo.getOptionC());
			dto.setOptionD(bo.getOptionD());
			dto.setLanguage(bo.getLanguage());
			dto.setCorrectAnswer(bo.getCorrectAnswer());
			listDTO.add(dto);
		}
		return listDTO;
	}

	@Override
	public int getCPageCount() {
		int recordsCount=0;
		int pageCount=0;
		recordsCount=userTestDAO.getCQuestionCount();
		//get pages count
		pageCount=recordsCount/1;
		if(recordsCount%1!=0){
			pageCount++;
		}
		return pageCount;
	}


	@Override
	public List<QuestionsDTO> showCPPQuestions(int pageNo) {
		int startPos=0;
		List<QuestionsBO_CPP> listQuestions=null;
		List<QuestionsDTO> listDTO=null;
		QuestionsDTO dto=null;
		//generate StartPosition
		startPos=(pageNo*1)-1;
		
		listQuestions = userTestDAO.getCPPQuestionData(startPos);
		listDTO=new ArrayList<QuestionsDTO>();
		for(QuestionsBO_CPP bo : listQuestions){
			dto = new QuestionsDTO();
			dto.setQuestionId(bo.getQuestionId());
			dto.setQuestionDescription(bo.getQuestionDescription());
			dto.setOptionA(bo.getOptionA());
			dto.setOptionB(bo.getOptionB());
			dto.setOptionC(bo.getOptionC());
			dto.setOptionD(bo.getOptionD());
			dto.setLanguage(bo.getLanguage());
			dto.setCorrectAnswer(bo.getCorrectAnswer());
			listDTO.add(dto);
		}
		return listDTO;
	}

	@Override
	public int getCPPPageCount() {
		int recordsCount=0;
		int pageCount=0;
		recordsCount=userTestDAO.getCPPQuestionCount();
		//get pages count
		pageCount=recordsCount/1;
		if(recordsCount%1!=0){
			pageCount++;
		}
		return pageCount;
	}

	@Override
	public List<QuestionsDTO> showJAVAQuestions(int pageNo) {
		int startPos=0;
		List<QuestionsBO_JAVA> listQuestions=null;
		List<QuestionsDTO> listDTO=null;
		QuestionsDTO dto=null;
		//generate StartPosition
		startPos=(pageNo*1)-1;
		
		listQuestions = userTestDAO.getJAVAQuestionData(startPos);
		listDTO=new ArrayList<QuestionsDTO>();
		for(QuestionsBO_JAVA bo : listQuestions){
			dto = new QuestionsDTO();
			dto.setQuestionId(bo.getQuestionId());
			dto.setQuestionDescription(bo.getQuestionDescription());
			dto.setOptionA(bo.getOptionA());
			dto.setOptionB(bo.getOptionB());
			dto.setOptionC(bo.getOptionC());
			dto.setOptionD(bo.getOptionD());
			dto.setLanguage(bo.getLanguage());
			dto.setCorrectAnswer(bo.getCorrectAnswer());
			listDTO.add(dto);
		}
		return listDTO;
	}

	@Override
	public int getJAVAPageCount() {
		int recordsCount=0;
		int pageCount=0;
		recordsCount=userTestDAO.getJAVAQuestionCount();
		//get pages count
		pageCount=recordsCount/1;
		if(recordsCount%1!=0){
			pageCount++;
		}
		return pageCount;
	}

	@Override
	public List<CollectResults> addAttemptedQuestionToList(List<CollectResults> listResults, long questionId,
			String answer, String correctAnswer, String language) {
		
		CollectResults collectResults = new CollectResults();
		
		for (CollectResults results : listResults) {
			if (results.getQuestionId() == questionId) {
				listResults.remove(results);
			}
		}
		collectResults.setQuestionId(questionId);
		collectResults.setUserAnswer(answer);
		collectResults.setCorrectAnswer(correctAnswer);
		collectResults.setLanguage(language);
		if (answer.equalsIgnoreCase(correctAnswer))
			collectResults.setMarks(true);
		else
			collectResults.setMarks(false);
		listResults.add(collectResults);
		
		return listResults;
	}

	@Override
	public Test storeResult(List<CollectResults> listResults, UserDTO userDTO, String language) {
		int questionAttempted = 0;
		int marks = 0;
		String result = "FAIL";
		for (CollectResults results : listResults) {
			questionAttempted++;
			if (results.getMarks()) {
				marks++;
			}
		}
		if(marks>=5) {
			result="PASS";
		}			
		Test test = new Test();
		test.setUserId(userDTO.getUserId());
		test.setFirstName(userDTO.getFirstName());
		test.setLastName(userDTO.getLastName());
		test.setMailId(userDTO.getMailId());
		test.setLanguage(language);
		test.setMarks(marks);
		test.setQuestionAttempted(questionAttempted);
		test.setResult(result);
		
		TestBO testBO = new TestBO();
		testBO.setUserId(test.getUserId());
		testBO.setFirstName(test.getFirstName());
		testBO.setLastName(test.getLastName());
		testBO.setMailId(test.getMailId());
		testBO.setLanguage(test.getLanguage());
		testBO.setMarks(test.getMarks());
		testBO.setQuestionAttempted(test.getQuestionAttempted());
		testBO.setResult(test.getResult());
		Boolean flag = userTestDAO.storeResult(testBO);
		if(flag) {
			return test;
		}
		return null;
	}
}
