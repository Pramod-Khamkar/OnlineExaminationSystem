package com.oes.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Questions implements Serializable{

	private static final long serialVersionUID = 1928644518429550367L;

	private long questionId;
	
	@NotEmpty
	@Size(min=50,max=1000)
	private String questionDescription;
	
	@NotEmpty
	@Size(min=5,max=500)
	private String optionA;
	
	@NotEmpty
	@Size(min=5,max=500)
	private String optionB;
	
	@NotEmpty
	@Size(min=5,max=500)
	private String optionC;
	
	@NotEmpty
	@Size(min=5,max=500)
	private String optionD;
	
	@NotEmpty
	@Min(1)
	private String correctAnswer;
	
	private String language;
	
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	public String getQuestionDescription() {
		return questionDescription;
	}
	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "Questions [questionId=" + questionId + ", questionDescription=" + questionDescription + ", optionA="
				+ optionA + ", optionB=" + optionB + ", optionC=" + optionC + ", optionD=" + optionD
				+ ", correctAnswer=" + correctAnswer + ", language=" + language + "]";
	}
}
