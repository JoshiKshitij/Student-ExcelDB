package com.spiders.dto;

import java.io.Serializable;

public class StudentDto implements Serializable {

	private long id;
	private String name;
	private String stream;
	private double percentage;
	private String email;
	private String password;
	private String userName;
	private String mobileNo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDto(String name, String stream, double percentage, String password, String loginName, String email,
			String mobileNo) {
		super();
		this.name = name;
		this.stream = stream;
		this.percentage = percentage;
		this.password = password;
		this.userName = loginName;
		this.mobileNo = mobileNo;
		this.email = email;
	}

	@Override
	public String toString() {
		return "StudentDto [id=" + id + ", name=" + name + ", stream=" + stream + ", percentage=" + percentage
				+ ", password=" + password + ", loginName=" + userName + ", mobileNo=" + mobileNo + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public StudentDto(long id, String name, String stream, double percentage, String email, String password,
			String userName, String mobileNo) {
		super();
		this.id = id;
		this.name = name;
		this.stream = stream;
		this.percentage = percentage;
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.mobileNo = mobileNo;
	}

}
