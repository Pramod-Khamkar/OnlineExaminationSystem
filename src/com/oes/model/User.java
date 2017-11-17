package com.oes.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class User implements Serializable {

	private static final long serialVersionUID = 4154309691664686928L;

	private long userId;

	@NotNull
	@Size(min = 3, max = 15)
	private String firstName;

	@NotNull
	@Size(min = 3, max = 15)
	private String lastName;

	private String gender;

	@NotNull
	@Min(10)
	private int age;

	@NotNull
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private String dateOfBirth;

	@NotNull
	@Min(10)
	private long phone;

	// @Email
	@Size(min = 6, max = 30)
	private String mailId;

	@NotNull
	@Size(min = 8, max = 30)
	private String password;

	@NotNull
	@Size(min = 1, max = 3)
	private String marks_ssc;

	@NotNull
	@Size(min = 1, max = 3)
	private String marks_hsc;

	@NotNull
	@NotEmpty
	private String graduationCollageName;

	@NotNull
	@Size(min = 1, max = 3)
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
}