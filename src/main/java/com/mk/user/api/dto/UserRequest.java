package com.mk.user.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
public class UserRequest {

	@JsonProperty("first_name")
	@NotNull(message = "firstName is required")
	private String firstName;

	@JsonProperty("last_name")
	@NotNull(message = "lastName is required")
	private String lastName;

	@JsonProperty("email")
	@NotNull(message = "email is required")
	private String email;

	@JsonProperty("password")
	@NotNull(message = "password is required")
	private String password;

	public UserRequest() {
	}

	public UserRequest(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
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
}
