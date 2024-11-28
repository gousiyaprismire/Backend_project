package com.university.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Scholarships")
public class Scholarship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String eligibility;
    @Column(nullable = false)
    private String benefits;
    @Column(nullable = false)
    private LocalDate application_deadline;
    private String apply_link;
	public Scholarship(Long id, String name, String type, String eligibility, String benefits,
			LocalDate application_deadline, String apply_link) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.eligibility = eligibility;
		this.benefits = benefits;
		this.application_deadline = application_deadline;
		this.apply_link = apply_link;
	}

	public Scholarship() {
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEligibility() {
		return eligibility;
	}
	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}
	public String getBenefits() {
		return benefits;
	}
	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}
	public LocalDate getApplication_deadline() {
		return application_deadline;
	}
	public void setApplication_deadline(LocalDate application_deadline) {
		this.application_deadline = application_deadline;
	}
	public String getApply_link() {
		return apply_link;
	}
	public void setApply_link(String apply_link) {
		this.apply_link = apply_link;
	}
	@Override
	public String toString() {
		return "Scholarship [id=" + id + ", name=" + name + ", type=" + type + ", eligibility=" + eligibility
				+ ", benefits=" + benefits + ", application_deadline=" + application_deadline + ", apply_link="
				+ apply_link + "]";
	}
    
    
}

