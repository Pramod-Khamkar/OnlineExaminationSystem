package com.oes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.oes.dto.AdminDTO;
import com.oes.dto.QuestionsDTO;
import com.oes.dto.UserDTO;
import com.oes.model.Questions;
import com.oes.model.Test;
import com.oes.model.User;
import com.oes.service.AdminOperationService;

@Controller
@SessionAttributes({"userList"})
public class AdminOperationsController {

	@Autowired
	private AdminOperationService adminOperationService;

	@RequestMapping(value = "/showCategoryToAdmin.html", method = RequestMethod.GET)
	public String showCategory(@ModelAttribute("adminDetails") AdminDTO adminDTO, Model model) {
		model.addAttribute("adminDetails", adminDTO);
		return "administartor";
	}
	
	@RequestMapping(value = "/addQuestion.html", method = RequestMethod.GET)
	public String addQuestions(Model model) {
		model.addAttribute("question", new Questions());
		return "addQuestion";
	}

	@RequestMapping(value = "/addQuestionToTable.html", method = RequestMethod.POST)
	public String addQuestionsToDB(@ModelAttribute("question") Questions questions, BindingResult errors, Model model) {

		if (errors.hasErrors()) {
			return "addQuestion";
		} else {
			QuestionsDTO questionsDTO = new QuestionsDTO();
			questionsDTO.setQuestionDescription(questions.getQuestionDescription());
			questionsDTO.setOptionA(questions.getOptionA());
			questionsDTO.setOptionB(questions.getOptionB());
			questionsDTO.setOptionC(questions.getOptionC());
			questionsDTO.setOptionD(questions.getOptionD());
			questionsDTO.setCorrectAnswer(questions.getCorrectAnswer());
			questionsDTO.setLanguage(questions.getLanguage());

			Boolean flag = adminOperationService.addQuestionToDB(questionsDTO);
			if (flag == true) {
				model.addAttribute("message", "Question Inserted Successfully...");
				return "addQuestion";
			} else {
				model.addAttribute("message", "Something Wents Wrong. Question Not Inserted...");
				return "addQuestion";
			}
		}
	}

	@RequestMapping(value = "/updateOperationOnQuestion.html", method = RequestMethod.GET)
	public String updateOperationOnQuestions(@RequestParam("questionId") long questionId,
			@RequestParam("language") String language, Model model) {
		
		if (language.equalsIgnoreCase("c")) {
			Questions questions = adminOperationService.getQuestionByIdFromCTable(questionId);
			if (questions != null) {
				model.addAttribute("question", questions);
				return "updateQuestion";
			} else {
				model.addAttribute("message", "Something Wents Wrong. Question Not Found...");
				return "questionList";
			}

		} else if (language.equalsIgnoreCase("cpp")) {
			Questions questions = adminOperationService.getQuestionByIdFromCPPTable(questionId);
			if (questions != null) {
				model.addAttribute("question", questions);
				return "updateQuestion";
			} else {
				model.addAttribute("message", "Something Wents Wrong. Question Not Deleted...");
				return "questionList";
			}
		} else {
			Questions questions = adminOperationService.getQuestionByIdFromJAVATable(questionId);
			if (questions != null) {
				model.addAttribute("question", questions);
				return "updateQuestion";
			} else {
				model.addAttribute("message", "Something Wents Wrong. Question Not Deleted...");
				return "questionList";
			}
		}
	}

	@RequestMapping(value = "/deleteOperationOnQuestions.html", method = RequestMethod.GET)
	public String deleteOperationOnQuestions(@RequestParam("questionId") long questionId,
			@RequestParam("language") String language, Model model) {
		
		if (language.equalsIgnoreCase("c")) {
			boolean flag = adminOperationService.deleteCQuestionFromTable(questionId);
			if (flag) {
				model.addAttribute("message", "Question Deleted Successfully...");
				return "chooseLanguageAdmin";
			} else {
				model.addAttribute("message", "Something Wents Wrong. Question Not Deleted...");
				return "questionList";
			}

		} else if (language.equalsIgnoreCase("cpp")) {
			boolean flag = adminOperationService.deleteCPPQuestionFromTable(questionId);
			if (flag) {
				model.addAttribute("message", "Question Deleted Successfully...");
				return "chooseLanguageAdmin";
			} else {
				model.addAttribute("message", "Something Wents Wrong. Question Not Deleted...");
				return "questionList";
			}
		} else {
			boolean flag = adminOperationService.deleteJAVAQuestionFromTable(questionId);
			if (flag) {
				model.addAttribute("message", "Question Deleted Successfully...");
				return "chooseLanguageAdmin";
			} else {
				model.addAttribute("message", "Something Wents Wrong. Question Not Deleted...");
				return "questionList";
			}
		}

	}

	@RequestMapping(value = "/updateQuestion.html", method = RequestMethod.POST)
	public String updateQuestion(@ModelAttribute("question") Questions questions,BindingResult errors,Model model) {
		if (errors.hasErrors()) {
			return "updateQuestion";
		} else {
			QuestionsDTO questionsDTO = new QuestionsDTO();
			questionsDTO.setQuestionId(questions.getQuestionId());
			questionsDTO.setQuestionDescription(questions.getQuestionDescription());
			questionsDTO.setOptionA(questions.getOptionA());
			questionsDTO.setOptionB(questions.getOptionB());
			questionsDTO.setOptionC(questions.getOptionC());
			questionsDTO.setOptionD(questions.getOptionD());
			questionsDTO.setCorrectAnswer(questions.getCorrectAnswer());
			questionsDTO.setLanguage(questions.getLanguage());

			Boolean flag = adminOperationService.updateQuestionToDB(questionsDTO);
			if (flag == true) {
				model.addAttribute("message", "Question Updated Successfully...");
				return "chooseLanguageAdmin";
			} else {
				model.addAttribute("message", "Something Wents Wrong. Question Not Updated...");
				return "updateQuestion";
			}
		}
	}

	@RequestMapping(value = "/chooseLanguageAdmin.html", method = RequestMethod.GET)
	public String getSignInPageForAdmin() {
		return "chooseLanguageAdmin";
	}

	@RequestMapping(value = "/getQuestionFromDB.html", method = RequestMethod.POST)
	public String getQuestionFromDB(@RequestParam("language") String language, Model model) {
		if (language.equalsIgnoreCase("c")) {
			List<Questions> questionsList = adminOperationService.getCQuestionList();
			if (!questionsList.isEmpty()) {
				model.addAttribute("language", language);
				model.addAttribute("questionList", questionsList);
				return "questionList";
			} else {
				model.addAttribute("message", "C Question Set is Empty...");
				return "chooseLanguageAdmin";
			}
		} else if (language.equalsIgnoreCase("cpp")) {
			List<Questions> questionsList = adminOperationService.getCPPQuestionList();
			if (!questionsList.isEmpty()) {
				model.addAttribute("language", language);
				model.addAttribute("questionList", questionsList);
				return "questionList";
			} else {
				model.addAttribute("message", "CPP Question Set is Empty...");
				return "chooseLanguageAdmin";
			}
		} else {
			List<Questions> questionsList = adminOperationService.getJAVAQuestionList();
			if (!questionsList.isEmpty()) {
				model.addAttribute("language", language);
				model.addAttribute("questionList", questionsList);
				return "questionList";
			} else {
				model.addAttribute("message", "JAVA Question Set is Empty...");
				return "chooseLanguageAdmin";
			}
		}
	}
	
	@RequestMapping(value= "/showUserList.html",method=RequestMethod.GET)
	public String showUserDetails(Model model) {
		List<UserDTO> userList = adminOperationService.getUserListFromDB();
		if(userList!=null) {
			model.addAttribute("userList", userList);
			return "showUserList";
		}else {
			model.addAttribute("message", "User List is Empty...");
			return "showUserList";
		}	
	}
	
	@RequestMapping(value="/updateOperationOnUser.html",method=RequestMethod.GET)
	public String getUserDetailsById(@RequestParam("userId") long userId,Model model) {
		User user = adminOperationService.getUserById(userId);
		if (user != null) {
			model.addAttribute("user", user);
			System.out.println(user);
			return "updateUserDetails";
		} else {
			model.addAttribute("message", "Something Wents Wrong. User Not Found...");
			return "updateUserDetails";
		}
	}
	
	@RequestMapping(value = "/updateUser.html", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") User user, BindingResult errors, Model model) {

		if (errors.hasErrors()) {
			return "updateUserDetails";
		} else {
			UserDTO userDTO = new UserDTO();
			userDTO.setUserId(user.getUserId());
			userDTO.setFirstName(user.getFirstName());
			userDTO.setLastName(user.getLastName());
			userDTO.setAge(user.getAge());
			userDTO.setDateOfBirth(user.getDateOfBirth());
			userDTO.setGender(user.getGender());
			userDTO.setGraduationCollageName(user.getGraduationCollageName());
			userDTO.setMailId(user.getMailId());
			userDTO.setPassword(user.getPassword());
			userDTO.setMarks_ssc(user.getMarks_ssc());
			userDTO.setMarks_hsc(user.getMarks_hsc());
			userDTO.setPostGraduationCollageName(user.getPostGraduationCollageName());
			userDTO.setPhone(user.getPhone());
			userDTO.setMarks_graduation(user.getMarks_graduation());
			userDTO.setMarks_postgraduation(user.getMarks_postgraduation());

			Boolean flag = adminOperationService.updateUserData(userDTO);
			if (flag == true) {
				model.addAttribute("message", "User Updated Successfully...");
				return "showUserList";
			} else {
				model.addAttribute("message", "Something Wents Wrong. User Not Updated...");
				return "showUserList";
			}
		}
	}
	
	@RequestMapping(value="/deleteOperationOnUser.html",method=RequestMethod.GET)
	public String deleteOperationOnUser(@RequestParam("userId") long userId,Model model) {
		boolean flag = adminOperationService.deleteUserFromDB(userId);
		if (flag) {
			model.addAttribute("message", "User Deleted Successfully...");
			return "redirect:/showUserList.html";
		} else {
			model.addAttribute("message", "Something Wents Wrong. User Not Deleted...");
			return "showUserList";
		}
	}
	
	@RequestMapping(value="showMarksList.html",method=RequestMethod.GET)
	public String showMarksList(Model model) {
		List<Test> testResultList = adminOperationService.getUserResultFromDB();
		model.addAttribute("testResultList", testResultList);
		return "showMarksList";
	}
	
	@RequestMapping(value="deleteOperationOnUserMarksList.html",method=RequestMethod.GET)
	public String deleteOperationOnUserMarksList(@RequestParam("testId") long testId,Model model) {
		Boolean flag = adminOperationService.deleteTestResultFromDB(testId);
		if (flag) {
			model.addAttribute("message", "Record Deleted Successfully...");
			return "redirect:/showMarksList.html";
		} else {
			model.addAttribute("message", "Something Wents Wrong. Record Not Deleted...");
			return "showMarksList";
		}
	}
}
