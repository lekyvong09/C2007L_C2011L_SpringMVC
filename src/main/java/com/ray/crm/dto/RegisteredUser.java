package com.ray.crm.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.ray.crm.validation.ValidEmail;

public class RegisteredUser {
	@NotEmpty(message="username is required")
	@Size(min=3, message="need at least 3 character")
	private String username;
	
	@NotEmpty(message="username is required")
	@ValidEmail
	private String email;
	
	@NotEmpty(message="username is required")
	private String password;
	
	private String matchingPassword;

	public RegisteredUser() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

}
