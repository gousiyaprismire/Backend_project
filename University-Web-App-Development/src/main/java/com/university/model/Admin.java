package com.university.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String admin_name;

	@Column
	private String email;

	@Column
	private String admin_password;

	public Admin(int id, String admin_name, String email, String admin_password) {
		this.id = id;
		this.admin_name = admin_name;
		this.email = email;
		this.admin_password = admin_password;
	}


	public Admin() {
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}


	@Override
	public String toString() {
		return "Admin{" +
				"id=" + id +
				", admin_name='" + admin_name + '\'' +
				", email='" + email + '\'' +
				", admin_password='" + admin_password + '\'' +
				'}';
	}
}
