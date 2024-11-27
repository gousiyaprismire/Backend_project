package com.university.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Study_Options
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String level;
    String field_of_study;
    String duration;

    @Lob  // Marks this field as a large object, equivalent to TEXT in SQL
    private String description;

    @Lob  // Marks this field as a large object, equivalent to TEXT in SQL
    private String entry_requirements;


}
