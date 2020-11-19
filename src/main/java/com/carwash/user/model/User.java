package com.carwash.user.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

	@Id
	private String id;

	@NotBlank(message = "userId cannot be empty")
	private String userId;

	@NotBlank(message = "first name cannot be empty")
	private String firstName;

	@NotBlank(message = "last name cannot be empty")
	private String lastName;

	@NotBlank(message = "email Id cannot be empty")
	private String email;

	@NotBlank(message = "phone cannot be empty")
	private Long phone;

	@NotBlank(message = "password cannot be empty")
	private String password;

	@NotBlank(message = "role cannot be empty")
	private String role;

	@NotBlank(message = "city cannot be empty")
	private String city;

	private Boolean isActive;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phone=" + phone + ", password=" + password + ", role=" + role + ", city="
				+ city + ", isActive=" + isActive + "]";
	}

}
