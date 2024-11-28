package com.university.model;

import jakarta.persistence.*;
@Entity

public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (nullable = false)
    private String title;
    @Column (nullable = false)
    private String content;
    @Column (nullable = false)
    private String date;

    public Announcement(Integer id, String title, String content, String date){
        this.id= id;
        this.title= title;
        this.content= content;
        this.date= date;
    }
    public Announcement(){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

