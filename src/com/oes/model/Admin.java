package com.oes.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Admin implements Serializable{

	private static final long serialVersionUID = -8915873600903744503L;

	private long adminId;
	
	@NotNull
	@Size(min = 3, max = 15)
	private String firstName;
	
	@NotNull
	@Size(min = 3, max = 15)
	private String lastName;
	
	@NotNull
	@Min(10)
	private int phone;
	
	//@Email
	@Size(min = 6, max = 30)
	private String mailId;
	
	@NotNull
	@Size(min = 8, max = 30)
	private String password;
	
	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
