package com.university.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student_1 {

    @Id
    private Long studentId;
    private String country;
    private String university;
    private String name;
    private String email;
    private boolean isVerified = false;


}
