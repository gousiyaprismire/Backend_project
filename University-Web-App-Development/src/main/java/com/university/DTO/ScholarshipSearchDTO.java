package com.university.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ScholarshipSearchDTO {
    private String courseName;
    private String level;
    private String duration;
    private String description;
    private String entryRequirements;
}
