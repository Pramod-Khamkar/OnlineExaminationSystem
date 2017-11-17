package com.oes.model;

public class CollectResults {
	
	private long questionId;
	private String userAnswer;
	private String correctAnswer;
	private boolean marks;
	private String language;
	
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	public String getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public boolean getMarks() {
		return marks;
	}
	public void setMarks(boolean marks) {
		this.marks = marks;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "CollectResults [questionId=" + questionId + ", userAnswer=" + userAnswer + ", correctAnswer="
				+ correctAnswer + ", marks=" + marks + "]";
	}
}
