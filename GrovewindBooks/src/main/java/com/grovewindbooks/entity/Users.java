package com.grovewindbooks.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Users.findAll", query =  "SELECT u FROM Users u ORDER BY u.fullName"),
	@NamedQuery(name = "Users.countAll", query = "SELECT Count(*) FROM Users u")
})
	
public class Users {

	private Integer userId;
	private String email;
	private String fullName;
	private String password;

	@Column(name = "user_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "full_name")
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
