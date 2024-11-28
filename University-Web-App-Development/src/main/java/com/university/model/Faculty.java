package com.university.model;

import jakarta.persistence.*;



@Entity


public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String designation;
    @Column(nullable = false)
    private String biodata;
    @Column(nullable = false,unique = true)
    private String email;

    public Faculty(Long id, String name, String designation, String biodata, String email) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.biodata = biodata;
        this.email = email;
    }
   public Faculty(){

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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getBiodata() {
        return biodata;
    }

    public void setBiodata(String biodata) {
        this.biodata = biodata;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




}

