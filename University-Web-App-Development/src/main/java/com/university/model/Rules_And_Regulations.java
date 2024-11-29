package com.university.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
public class Rules_And_Regulations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String rule;
    @Column(nullable = false)
    private String description ;

    public Rules_And_Regulations(Long id, String rule, String description) {
        this.id = id;
        this.rule = rule;
        this.description = description;
    }
    public Rules_And_Regulations(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }



    @Override
    public String toString() {
        return "Rules_And_Regulations{" +
                "id=" + id +
                ", rule='" + rule + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
