package com.university.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Hall_Of_Fame")
public class HallOfFame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String achievement;

    public HallOfFame(Long id, String achievement, String name) {
        super();
        this.id = id;
        this.achievement = achievement;
        this.name = name;
    }

    public HallOfFame() {
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

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    @Override
    public String toString() {
        return "HallOfFame{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", achievement='" + achievement + '\'' +
                '}';
    }
}
