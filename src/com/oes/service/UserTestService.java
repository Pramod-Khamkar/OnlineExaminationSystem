package com.oes.service;

import java.util.List;

import com.oes.dto.QuestionsDTO;
import com.oes.dto.UserDTO;
import com.oes.model.CollectResults;
import com.oes.model.Test;

public interface UserTestService {

	List<QuestionsDTO> showCQuestions(int pageNo);

	int getCPageCount();

	List<QuestionsDTO> showCPPQuestions(int pageNo);

	int getCPPPageCount();

	List<QuestionsDTO> showJAVAQuestions(int pageNo);

	int getJAVAPageCount();

	List<CollectResults> addAttemptedQuestionToList(List<CollectResults> listResults, long questionId, String answer, String correctAnswer, String language);

	Test storeResult(List<CollectResults> listResults, UserDTO userDTO, String language);

}
