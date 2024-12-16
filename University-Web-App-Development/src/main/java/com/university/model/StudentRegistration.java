package com.university.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

@Entity
public class StudentRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Full name is required.")
    private String fullname;

    @Email(message = "Email should be valid.")
    @NotBlank(message = "Email is required.")
    private String email;

    @NotBlank(message = "Mobile number is required.")
    @Pattern(regexp = "^\\d{10,13}$", message = "Mobile number must be between 10 and 13 digits.")
    private String mobile;

    @NotBlank(message = "Upload ID is required.")
    private String uploadId;

    @NotBlank(message = "Username is required.")
    private String username;

    @NotBlank(message = "Password is required.")
    private String password;

    @NotBlank(message = "Country is required.")
    private String country;

    private LocalDate enrollDate;

    private String status = "Pending"; // Default value

    // Constructors
    public StudentRegistration(Long id, String fullname, String email, String mobile, String uploadId,
                               String username, String password, String country,
                               LocalDate enrollDate, String status) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.mobile = mobile;
        this.uploadId = uploadId;
        this.username = username;
        this.password = password;
        this.country = country;
        this.enrollDate = enrollDate;
        this.status = status;
    }

    public StudentRegistration() {
    }

    @PrePersist
    protected void onCreate() {
        this.enrollDate = LocalDate.now(); // Automatically set the current date
    }

    // Getters and Setters
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUploadId() {
        return uploadId;
    }

    public void setUploadId(String uploadId) {
        this.uploadId = uploadId;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(LocalDate enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
