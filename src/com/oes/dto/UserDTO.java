package com.oes.dto;

import java.io.Serializable;

public class UserDTO  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private long userId;
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private String dateOfBirth;
	private long phone;
	private String mailId;
	private String password;
	private String marks_ssc;
	private String marks_hsc;
	private String graduationCollageName;
	private String marks_graduation;
	private String marks_postgraduation;
	private String postGraduationCollageName;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMarks_ssc() {
		return marks_ssc;
	}
	public void setMarks_ssc(String marks_ssc) {
		this.marks_ssc = marks_ssc;
	}
	public String getMarks_hsc() {
		return marks_hsc;
	}
	public void setMarks_hsc(String marks_hsc) {
		this.marks_hsc = marks_hsc;
	}
	public String getGraduationCollageName() {
		return graduationCollageName;
	}
	public void setGraduationCollageName(String graduationCollageName) {
		this.graduationCollageName = graduationCollageName;
	}
	public String getMarks_graduation() {
		return marks_graduation;
	}
	public void setMarks_graduation(String marks_graduation) {
		this.marks_graduation = marks_graduation;
	}
	public String getMarks_postgraduation() {
		return marks_postgraduation;
	}
	public void setMarks_postgraduation(String marks_postgraduation) {
		this.marks_postgraduation = marks_postgraduation;
	}
	public String getPostGraduationCollageName() {
		return postGraduationCollageName;
	}
	public void setPostGraduationCollageName(String postGraduationCollageName) {
		this.postGraduationCollageName = postGraduationCollageName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", age=" + age + ", dateOfBirth=" + dateOfBirth + ", phone=" + phone + ", mailId=" + mailId
				+ ", password=" + password + ", marks_ssc=" + marks_ssc + ", marks_hsc=" + marks_hsc
				+ ", graduationCollageName=" + graduationCollageName + ", marks_graduation=" + marks_graduation
				+ ", marks_postgraduation=" + marks_postgraduation + ", postGraduationCollageName="
				+ postGraduationCollageName + "]";
	}
	
}
