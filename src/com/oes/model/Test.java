package com.oes.model;

import java.io.Serializable;

public class Test implements Serializable{

	private static final long serialVersionUID = 1L;

	private long userId;
	private String firstName;
	private String lastName;
	private String mailId;
	private long testId;
	private String language;
	private int marks;
	private String result;
	private int questionAttempted;
	
	public long getTestId() {
		return testId;
	}
	public void setTestId(long testId) {
		this.testId = testId;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getQuestionAttempted() {
		return questionAttempted;
	}
	public void setQuestionAttempted(int questionAttempted) {
		this.questionAttempted = questionAttempted;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	@Override
	public String toString() {
		return "Test [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", mailId=" + mailId
				+ ", testId=" + testId + ", language=" + language + ", marks=" + marks + ", result=" + result
				+ ", questionAttempted=" + questionAttempted + "]";
	}
	
}
