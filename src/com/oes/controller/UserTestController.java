package com.oes.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.oes.dto.QuestionsDTO;
import com.oes.dto.UserDTO;
import com.oes.model.CollectResults;
import com.oes.model.Questions;
import com.oes.model.Test;
import com.oes.service.UserTestService;

@Controller
@SessionAttributes({ "userDetails", "pageCount", "questiontData","language" })
public class UserTestController {

	@Autowired
	private UserTestService userTestService;

	public List<CollectResults> listResults = new CopyOnWriteArrayList<>();

	public UserDTO userDTO = null;

	@RequestMapping(value = "/showCategoryAfterLogin.html", method = RequestMethod.GET)
	public String showCategory(@ModelAttribute("userDetails") UserDTO userDto, Model model) {
		System.out.println(userDTO);
		userDTO = userDto;
		model.addAttribute("userDetails", userDTO);
		return "showCategory";
	}

	@RequestMapping(value = "/showCategory.html", method = RequestMethod.GET)
	public String showCategory(Model model) {
		return "showCategory";
	}
	
	@RequestMapping(value = "/getQuestions.html", method = RequestMethod.GET)
	public String getQuestionFromTable(@RequestParam("pageNo") int pageNo, @RequestParam("language") String language,
			Model model) {
		if (language.equalsIgnoreCase("C")) {
			List<QuestionsDTO> listDTO = null;
			int pagesCount = 0;
			model.addAttribute("question", new Questions());
			listDTO = userTestService.showCQuestions(pageNo);
			pagesCount = userTestService.getCPageCount();
			model.addAttribute("language", language);
			model.addAttribute("pageCount", pagesCount);
			model.addAttribute("questiontData", listDTO);
			return "quizQuestions";
		} else if (language.equalsIgnoreCase("CPP")) {
			List<QuestionsDTO> listDTO = null;
			int pagesCount = 0;
			model.addAttribute("question", new Questions());
			listDTO = userTestService.showCPPQuestions(pageNo);
			pagesCount = userTestService.getCPPPageCount();
			model.addAttribute("language", language);
			model.addAttribute("pageCount", pagesCount);
			model.addAttribute("questiontData", listDTO);
			return "quizQuestions";
		} else {
			List<QuestionsDTO> listDTO = null;
			int pagesCount = 0;
			model.addAttribute("question", new Questions());
			listDTO = userTestService.showJAVAQuestions(pageNo);
			// get pagesCount
			pagesCount = userTestService.getJAVAPageCount();
			model.addAttribute("language", language);
			model.addAttribute("pageCount", pagesCount);
			model.addAttribute("questiontData", listDTO);
			return "quizQuestions";
		}
	}
	@RequestMapping(value = "/collectAnswers.html", method = RequestMethod.GET)
	public String collectAnswers(@RequestParam(value="answer",defaultValue="E") String answer, @RequestParam("questionId") long questionId,
			@RequestParam("correctAnswer") String correctAnswer, @RequestParam("language") String language,
			Model model) {
		
		if(answer.equalsIgnoreCase("E")) {
			model.addAttribute("message", "Please, Select option to save your answer !!!");
		}else {
			listResults = userTestService.addAttemptedQuestionToList(listResults,questionId,answer,correctAnswer,language);
			model.addAttribute("listResults", listResults);
			model.addAttribute("message", "Answer Saved Successfully...");
		}
		//System.out.println(listResults);
		return "quizQuestions";
	}

	@RequestMapping(value = "/getResult.html", method = RequestMethod.GET)
	public String getResult(@RequestParam("language") String language,Model model) {
		Test test = userTestService.storeResult(listResults,userDTO,language); 
		if(test!=null) {
			model.addAttribute("testResult",test);
			listResults.clear();
			return "showResult";
		}else {
			model.addAttribute("message", "Something Went's wrong. Your Test Not Submitted.");
			listResults.clear();
			return "showResult";
		}
	}
	
	@RequestMapping(value="showAttemptedQuestionAnswers.html",method=RequestMethod.GET)
	public String showAttemptedQuestionAnswers(Model model) {
		model.addAttribute("listResults", listResults);
		return "quizQuestions";
	}
	
}
