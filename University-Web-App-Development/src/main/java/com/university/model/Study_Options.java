package com.university.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Study_Options
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String level;
    String field_of_study;
    String duration;

    @Lob
    private String description;

    @Lob
    private String entry_requirements;

    public Study_Options(int id, String name, String level, String field_of_study, String duration, String description, String entry_requirements) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.field_of_study = field_of_study;
        this.duration = duration;
        this.description = description;
        this.entry_requirements = entry_requirements;
    }

    public Study_Options() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getField_of_study() {
        return field_of_study;
    }

    public void setField_of_study(String field_of_study) {
        this.field_of_study = field_of_study;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEntry_requirements() {
        return entry_requirements;
    }

    public void setEntry_requirements(String entry_requirements) {
        this.entry_requirements = entry_requirements;
    }


}
