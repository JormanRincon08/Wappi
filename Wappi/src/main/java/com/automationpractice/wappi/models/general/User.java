package com.automationpractice.wappi.models.general;

public class User {

	private final String userName;
	private final String password;

	public User() {
		this.userName = "";
		this.password = "";
	}

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
}