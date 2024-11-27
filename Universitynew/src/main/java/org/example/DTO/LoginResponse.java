package org.example.DTO;



public class LoginResponse {

    private String status;
    private String studentId;
    private String message;


    public LoginResponse(String status, Long studentId, String message) {
        this.status = status;
        this.studentId = String.valueOf(studentId);
        this.message = message;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

