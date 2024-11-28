package com.university.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Student_1 {

    @Id
    private Long studentId;
    private String country;
    private String university;
    private String name;
    private String email;
    private boolean isVerified = false;
	public Student_1(Long studentId, String country, String university, String name, String email, boolean isVerified) {
		super();
		this.studentId = studentId;
		this.country = country;
		this.university = university;
		this.name = name;
		this.email = email;
		this.isVerified = isVerified;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	@Override
	public String toString() {
		return "Student_1 [studentId=" + studentId + ", country=" + country + ", university=" + university + ", name="
				+ name + ", email=" + email + ", isVerified=" + isVerified + "]";
	}
    
    


}
