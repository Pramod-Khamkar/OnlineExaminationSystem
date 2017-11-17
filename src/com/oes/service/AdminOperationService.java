package com.oes.service;

import java.util.List;

import com.oes.dto.QuestionsDTO;
import com.oes.dto.UserDTO;
import com.oes.model.Questions;
import com.oes.model.Test;
import com.oes.model.User;

public interface AdminOperationService {

	Boolean addQuestionToDB(QuestionsDTO questionsDTO);

	List<Questions> getCQuestionList();

	List<Questions> getCPPQuestionList();

	List<Questions> getJAVAQuestionList();

	Boolean deleteCQuestionFromTable(long questionId);

	Boolean deleteCPPQuestionFromTable(long questionId);

	Boolean deleteJAVAQuestionFromTable(long questionId);

	Questions getQuestionByIdFromCTable(long questionId);

	Questions getQuestionByIdFromCPPTable(long questionId);

	Questions getQuestionByIdFromJAVATable(long questionId);

	Boolean updateQuestionToDB(QuestionsDTO questionsDTO);

	List<UserDTO> getUserListFromDB();

	User getUserById(long userId);

	Boolean updateUserData(UserDTO userDTO);

	boolean deleteUserFromDB(long userId);

	List<Test> getUserResultFromDB();

	Boolean deleteTestResultFromDB(long testId);

}
