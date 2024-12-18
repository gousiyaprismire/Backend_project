package com.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // Method for sending registration emails
    public void sendRegistrationEmail(String toEmail, String studentName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Welcome to the University!");
        message.setText("Dear " + studentName + ",\n\n" +
                "Congratulations! You have successfully registered at our University.\n\n" +
                "Thank you for joining us!\n\n" +
                "Regards,\nUniversity Team");

        mailSender.send(message);
    }

    // Method for sending approval emails
    public void sendApprovalEmail(String toEmail, String studentName) {
    	System.out.println("toEmail :"+toEmail+" studentName:"+studentName);
        if (toEmail != null && !toEmail.isEmpty() && studentName != null) {
        	System.out.println("1111");
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(toEmail);
            message.setSubject("Account Approved");
            message.setText("Dear " + studentName + ",\n\n" +
                    "Your registration has been approved!\n\n" +
                    "Regards,\nUniversity Team");
            System.out.println("222");
            mailSender.send(message);
        } else {
        	System.out.println("2222");
            throw new IllegalArgumentException("Email or Student Name is missing");
        }
    }
}
