package com.oes.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TestResult")
public class TestBO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long testId;
	private long userId;
	private String firstName;
	private String lastName;
	private String mailId;
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
		return "TestBO [testId=" + testId + ", userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mailId=" + mailId + ", language=" + language + ", marks=" + marks + ", result=" + result
				+ ", questionAttempted=" + questionAttempted + "]";
	}
}
