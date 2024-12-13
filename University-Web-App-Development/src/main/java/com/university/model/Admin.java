package com.university.model;

import jakarta.persistence.*;


@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String fullname;
	private String email;
	private String contactNumber;
	private String adminId;
	private String username;
	private String password;

	public Admin() {
	}

	public Admin(Long id, String fullname, String email, String contactNumber, String adminId, String username, String password) {
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.contactNumber = contactNumber;
		this.adminId = adminId;
		this.username = username;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin{" +
				"id=" + id +
				", fullname='" + fullname + '\'' +
				", email='" + email + '\'' +
				", contactNumber='" + contactNumber + '\'' +
				", adminId='" + adminId + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
