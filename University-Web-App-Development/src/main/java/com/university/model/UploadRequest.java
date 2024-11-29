package com.university.model;



import jakarta.validation.constraints.NotNull;


import java.util.UUID;

public class UploadRequest {

    @NotNull
    private UUID studentId;

    @NotNull
    private String collegeIdBase64;


    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }

    public String getCollegeIdBase64() {
        return collegeIdBase64;
    }

    public void setCollegeIdBase64(String collegeIdBase64) {
        this.collegeIdBase64 = collegeIdBase64;
    }
}

