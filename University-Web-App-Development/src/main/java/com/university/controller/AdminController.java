package com.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.university.model.Admin;
import com.university.repository.AdminRepository;

@RestController
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/admin/{name}")
    public Admin getAdminDetails(@PathVariable("name") String name){
    	System.out.println("Admin get Call");
        return this.adminRepository.findByName(name);
        
    }

    @PostMapping("/admin")
    public Admin addNewAdmin(@RequestBody Admin admin){
        return this.adminRepository.save(admin);
    }
}

