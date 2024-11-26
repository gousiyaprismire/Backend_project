package com.university.controller;

import com.university.model.Admin;
import com.university.serviceImpl.AdminServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
public class AdminController {

    private final AdminServiceImpl adminServiceImpl;

    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin createdAdmin = adminServiceImpl.createAdmin(admin);
        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
    }

//    @GetMapping("/findByEmail")
//    public ResponseEntity<?> findByEmail(@RequestParam String email) {
//        Admin admin = adminServiceImpl.findAdminByEmail(email);
//        if (admin != null) {
//            return new ResponseEntity<>(admin, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Record not found for email: " + email, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping("/login")                                        // http://localhost:8080/api/admin/login?email=Admin-2@example.com&password=password2
//    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
//        boolean isValid = adminServiceImpl.validateLogin(email, password);
//        if (isValid) {
//            return new ResponseEntity<>("Successfully logged in!", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Invalid email or password!", HttpStatus.UNAUTHORIZED);
//        }
//    }


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
    public ResponseEntity<String> login(@PathVariable String email, @PathVariable String password) {
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
