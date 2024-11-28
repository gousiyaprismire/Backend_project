package com.university.controller;

import com.university.model.Admin;
import com.university.serviceImpl.AdminAuthServiceImpl;
//import com.university.serviceImpl.AdminAuthServiceImpl;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
    private AdminAuthServiceImpl adminServiceImpl;

    public AdminController(AdminAuthServiceImpl adminServiceImpl)
    {
        this.adminServiceImpl = adminServiceImpl;
    }

    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin createdAdmin = adminServiceImpl.createAdmin(admin);
        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
    }


    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email) {
        Admin admin = adminServiceImpl.findAdminByEmail(email);
        if (admin != null) {
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Record not found for email: " + email, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login/{email}/{password}")
    public ResponseEntity<String> login(@PathVariable String email, @PathVariable String password)
    {
        boolean isValid = adminServiceImpl.validateLogin(email, password);
        if (isValid) {
            return new ResponseEntity<>("Successfully logged in!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid email or password!", HttpStatus.UNAUTHORIZED);
        }

    }



    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        // In a real-world scenario, you would invalidate the session or JWT token here.
        return new ResponseEntity<>("Successfully logged out!", HttpStatus.OK);
    }
}

