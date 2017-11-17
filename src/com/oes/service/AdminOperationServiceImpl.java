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
import com.oes.bo.UserBO;
import com.oes.dao.AdminOperationDAO;
import com.oes.dto.QuestionsDTO;
import com.oes.dto.UserDTO;
import com.oes.model.Questions;
import com.oes.model.Test;
import com.oes.model.User;

@Service
@Transactional
public class AdminOperationServiceImpl implements AdminOperationService {

	@Autowired
	private AdminOperationDAO adminOperationDAO;

	@Override
	public Boolean addQuestionToDB(QuestionsDTO questionsDTO) {
		if (questionsDTO.getLanguage().equalsIgnoreCase("c")) {
			QuestionsBO_C questionsBO_C = new QuestionsBO_C();
			questionsBO_C.setQuestionDescription(questionsDTO.getQuestionDescription());
			questionsBO_C.setOptionA(questionsDTO.getOptionA());
			questionsBO_C.setOptionB(questionsDTO.getOptionB());
			questionsBO_C.setOptionC(questionsDTO.getOptionC());
			questionsBO_C.setOptionD(questionsDTO.getOptionD());
			questionsBO_C.setCorrectAnswer(questionsDTO.getCorrectAnswer());
			questionsBO_C.setLanguage(questionsDTO.getLanguage());

			return adminOperationDAO.addQuestionToCTable(questionsBO_C);

		} else if (questionsDTO.getLanguage().equalsIgnoreCase("cpp")) {
			QuestionsBO_CPP questionsBO_CPP = new QuestionsBO_CPP();
			questionsBO_CPP.setQuestionDescription(questionsDTO.getQuestionDescription());
			questionsBO_CPP.setOptionA(questionsDTO.getOptionA());
			questionsBO_CPP.setOptionB(questionsDTO.getOptionB());
			questionsBO_CPP.setOptionC(questionsDTO.getOptionC());
			questionsBO_CPP.setOptionD(questionsDTO.getOptionD());
			questionsBO_CPP.setCorrectAnswer(questionsDTO.getCorrectAnswer());
			questionsBO_CPP.setLanguage(questionsDTO.getLanguage());

			return adminOperationDAO.addQuestionToCPPTable(questionsBO_CPP);
		} else {
			QuestionsBO_JAVA questionsBO_JAVA = new QuestionsBO_JAVA();
			questionsBO_JAVA.setQuestionDescription(questionsDTO.getQuestionDescription());
			questionsBO_JAVA.setOptionA(questionsDTO.getOptionA());
			questionsBO_JAVA.setOptionB(questionsDTO.getOptionB());
			questionsBO_JAVA.setOptionC(questionsDTO.getOptionC());
			questionsBO_JAVA.setOptionD(questionsDTO.getOptionD());
			questionsBO_JAVA.setCorrectAnswer(questionsDTO.getCorrectAnswer());
			questionsBO_JAVA.setLanguage(questionsDTO.getLanguage());

			return adminOperationDAO.addQuestionToJAVATable(questionsBO_JAVA);
		}
	}

	@Override
	public List<Questions> getCQuestionList() {

		List<QuestionsBO_C> questionsBO_CList = adminOperationDAO.getCQuestionList();
		List<Questions> questionsList = new ArrayList<>();
		
		for (QuestionsBO_C questions : questionsBO_CList) {
			Questions question = new Questions();
			question.setQuestionId(questions.getQuestionId());
			question.setQuestionDescription(questions.getQuestionDescription());
			question.setOptionA(questions.getOptionA());
			question.setOptionB(questions.getOptionB());
			question.setOptionC(questions.getOptionC());
			question.setOptionD(questions.getOptionD());
			question.setCorrectAnswer(questions.getCorrectAnswer());
			question.setLanguage(questions.getLanguage());
			questionsList.add(question);
		}
		return questionsList;
	}

	@Override
	public List<Questions> getCPPQuestionList() {
		List<QuestionsBO_CPP> questionsBO_CPPList = adminOperationDAO.getCPPQuestionList();
		List<Questions> questionsList = new ArrayList<>();
	
		for (QuestionsBO_CPP questions : questionsBO_CPPList) {
			Questions question = new Questions();
			question.setQuestionId(questions.getQuestionId());
			question.setQuestionDescription(questions.getQuestionDescription());
			question.setOptionA(questions.getOptionA());
			question.setOptionB(questions.getOptionB());
			question.setOptionC(questions.getOptionC());
			question.setOptionD(questions.getOptionD());
			question.setCorrectAnswer(questions.getCorrectAnswer());
			question.setLanguage(questions.getLanguage());
			questionsList.add(question);
		}
		return questionsList;
	}

	@Override
	public List<Questions> getJAVAQuestionList() {
		List<QuestionsBO_JAVA> questionsBO_JAVAList = adminOperationDAO.getJAVAQuestionList();
		List<Questions> questionsList = new ArrayList<>();
		for (QuestionsBO_JAVA questions : questionsBO_JAVAList) {
			Questions question = new Questions();
			question.setQuestionId(questions.getQuestionId());
			question.setQuestionDescription(questions.getQuestionDescription());
			question.setOptionA(questions.getOptionA());
			question.setOptionB(questions.getOptionB());
			question.setOptionC(questions.getOptionC());
			question.setOptionD(questions.getOptionD());
			question.setCorrectAnswer(questions.getCorrectAnswer());
			question.setLanguage(questions.getLanguage());
			questionsList.add(question);
		}
		return questionsList;
	}

	@Override
	public Boolean deleteCQuestionFromTable(long questionId) {
		return adminOperationDAO.deleteCQuestionFromTable(questionId);
	}

	@Override
	public Boolean deleteCPPQuestionFromTable(long questionId) {
		return adminOperationDAO.deleteCPPQuestionFromTable(questionId);
	}

	@Override
	public Boolean deleteJAVAQuestionFromTable(long questionId) {
		return adminOperationDAO.deleteJAVAQuestionFromTable(questionId);
	}

	@Override
	public Questions getQuestionByIdFromCTable(long questionId) {
		QuestionsBO_C questionsBO_C = adminOperationDAO.getQuestionByIdFromCTable(questionId);
		if(questionsBO_C!=null){
			Questions question = new Questions();
			question.setQuestionId(questionsBO_C.getQuestionId());
			question.setQuestionDescription(questionsBO_C.getQuestionDescription());
			question.setOptionA(questionsBO_C.getOptionA());
			question.setOptionB(questionsBO_C.getOptionB());
			question.setOptionC(questionsBO_C.getOptionC());
			question.setOptionD(questionsBO_C.getOptionD());
			question.setCorrectAnswer(questionsBO_C.getCorrectAnswer());
			question.setLanguage(questionsBO_C.getLanguage());
			return question;
		}
		return null;
	}

	@Override
	public Questions getQuestionByIdFromCPPTable(long questionId) {
		QuestionsBO_CPP questionsBO_CPP = adminOperationDAO.getQuestionByIdFromCPPTable(questionId);
		if(questionsBO_CPP!=null){
			Questions question = new Questions();
			question.setQuestionId(questionsBO_CPP.getQuestionId());
			question.setQuestionDescription(questionsBO_CPP.getQuestionDescription());
			question.setOptionA(questionsBO_CPP.getOptionA());
			question.setOptionB(questionsBO_CPP.getOptionB());
			question.setOptionC(questionsBO_CPP.getOptionC());
			question.setOptionD(questionsBO_CPP.getOptionD());
			question.setCorrectAnswer(questionsBO_CPP.getCorrectAnswer());
			question.setLanguage(questionsBO_CPP.getLanguage());
			return question;
		}
		return null;
	}

	@Override
	public Questions getQuestionByIdFromJAVATable(long questionId) {
		QuestionsBO_JAVA questionsBO_JAVA = adminOperationDAO.getQuestionByIdFromJAVATable(questionId);
		if(questionsBO_JAVA!=null){
			Questions question = new Questions();
			question.setQuestionId(questionsBO_JAVA.getQuestionId());
			question.setQuestionDescription(questionsBO_JAVA.getQuestionDescription());
			question.setOptionA(questionsBO_JAVA.getOptionA());
			question.setOptionB(questionsBO_JAVA.getOptionB());
			question.setOptionC(questionsBO_JAVA.getOptionC());
			question.setOptionD(questionsBO_JAVA.getOptionD());
			question.setCorrectAnswer(questionsBO_JAVA.getCorrectAnswer());
			question.setLanguage(questionsBO_JAVA.getLanguage());
			return question;
		}
		return null;
	}

	@Override
	public Boolean updateQuestionToDB(QuestionsDTO questionsDTO) {
		if (questionsDTO.getLanguage().equalsIgnoreCase("c")) {
			QuestionsBO_C questionsBO_C = new QuestionsBO_C();
			questionsBO_C.setQuestionId(questionsDTO.getQuestionId());
			questionsBO_C.setQuestionDescription(questionsDTO.getQuestionDescription());
			questionsBO_C.setOptionA(questionsDTO.getOptionA());
			questionsBO_C.setOptionB(questionsDTO.getOptionB());
			questionsBO_C.setOptionC(questionsDTO.getOptionC());
			questionsBO_C.setOptionD(questionsDTO.getOptionD());
			questionsBO_C.setCorrectAnswer(questionsDTO.getCorrectAnswer());
			questionsBO_C.setLanguage(questionsDTO.getLanguage());

			return adminOperationDAO.updateQuestionToCTable(questionsBO_C);

		} else if (questionsDTO.getLanguage().equalsIgnoreCase("cpp")) {
			QuestionsBO_CPP questionsBO_CPP = new QuestionsBO_CPP();
			questionsBO_CPP.setQuestionId(questionsDTO.getQuestionId());
			questionsBO_CPP.setQuestionDescription(questionsDTO.getQuestionDescription());
			questionsBO_CPP.setOptionA(questionsDTO.getOptionA());
			questionsBO_CPP.setOptionB(questionsDTO.getOptionB());
			questionsBO_CPP.setOptionC(questionsDTO.getOptionC());
			questionsBO_CPP.setOptionD(questionsDTO.getOptionD());
			questionsBO_CPP.setCorrectAnswer(questionsDTO.getCorrectAnswer());
			questionsBO_CPP.setLanguage(questionsDTO.getLanguage());

			return adminOperationDAO.updateQuestionToCPPTable(questionsBO_CPP);
		} else {
			QuestionsBO_JAVA questionsBO_JAVA = new QuestionsBO_JAVA();
			questionsBO_JAVA.setQuestionId(questionsDTO.getQuestionId());
			questionsBO_JAVA.setQuestionDescription(questionsDTO.getQuestionDescription());
			questionsBO_JAVA.setOptionA(questionsDTO.getOptionA());
			questionsBO_JAVA.setOptionB(questionsDTO.getOptionB());
			questionsBO_JAVA.setOptionC(questionsDTO.getOptionC());
			questionsBO_JAVA.setOptionD(questionsDTO.getOptionD());
			questionsBO_JAVA.setCorrectAnswer(questionsDTO.getCorrectAnswer());
			questionsBO_JAVA.setLanguage(questionsDTO.getLanguage());

			return adminOperationDAO.updateQuestionToJAVATable(questionsBO_JAVA);
		}
	}

	@Override
	public List<UserDTO> getUserListFromDB() {
		List<UserDTO> dtoList = new ArrayList<>();
		List<UserBO> userList = adminOperationDAO.getUserListFromDB();
		
		if(userList!=null) {
			for(UserBO bo : userList) {
				UserDTO userDTO = new UserDTO();
				userDTO.setUserId(bo.getUserId());
				userDTO.setFirstName(bo.getFirstName());
				userDTO.setLastName(bo.getLastName());
				userDTO.setAge(bo.getAge());
				userDTO.setDateOfBirth(bo.getDateOfBirth());
				userDTO.setGender(bo.getGender());
				userDTO.setGraduationCollageName(bo.getGraduationCollageName());
				userDTO.setMailId(bo.getMailId());
				userDTO.setPassword(bo.getPassword());
				userDTO.setMarks_ssc(bo.getMarks_ssc());
				userDTO.setMarks_hsc(bo.getMarks_hsc());
				userDTO.setPostGraduationCollageName(bo.getPostGraduationCollageName());
				userDTO.setPhone(bo.getPhone());
				userDTO.setMarks_graduation(bo.getMarks_graduation());
				userDTO.setMarks_postgraduation(bo.getMarks_postgraduation());
				dtoList.add(userDTO);
			}
			return dtoList;
		}
		return null;
	}

	@Override
	public User getUserById(long userId) {
		UserBO bo = adminOperationDAO.getUserByID(userId);
		if(bo!=null) {
			User user = new User();
			user.setUserId(bo.getUserId());
			user.setFirstName(bo.getFirstName());
			user.setLastName(bo.getLastName());
			user.setAge(bo.getAge());
			user.setDateOfBirth(bo.getDateOfBirth());
			user.setGender(bo.getGender());
			user.setGraduationCollageName(bo.getGraduationCollageName());
			user.setMailId(bo.getMailId());
			user.setPassword(bo.getPassword());
			user.setMarks_ssc(bo.getMarks_ssc());
			user.setMarks_hsc(bo.getMarks_hsc());
			user.setPostGraduationCollageName(bo.getPostGraduationCollageName());
			user.setPhone(bo.getPhone());
			user.setMarks_graduation(bo.getMarks_graduation());
			user.setMarks_postgraduation(bo.getMarks_postgraduation());
			return user;
		}
		return null;
	}

	@Override
	public Boolean updateUserData(UserDTO userDTO) {
		UserBO userBO = new UserBO();
		userBO.setUserId(userDTO.getUserId());
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
		
		return adminOperationDAO.updateUserData(userBO);
	}

	@Override
	public boolean deleteUserFromDB(long userId) {
		return adminOperationDAO.deleteUserFromDB(userId);
	}

	@Override
	public List<Test> getUserResultFromDB() {
		List<TestBO> testBO_ResultList = adminOperationDAO.getUserResultFromDB();
		List<Test> testResultList = new ArrayList<>();
		for (TestBO bo : testBO_ResultList) {
			Test test = new Test();
			test.setUserId(bo.getUserId());
			test.setTestId(bo.getTestId());
			test.setFirstName(bo.getFirstName());
			test.setLastName(bo.getLastName());
			test.setMailId(bo.getMailId());
			test.setLanguage(bo.getLanguage());
			test.setMarks(bo.getMarks());
			test.setQuestionAttempted(bo.getQuestionAttempted());
			test.setResult(bo.getResult());
			testResultList.add(test);
		}
		return testResultList;
	}

	@Override
	public Boolean deleteTestResultFromDB(long testId) {
		return adminOperationDAO.deleteTestResultFromDB(testId);
	}
}
