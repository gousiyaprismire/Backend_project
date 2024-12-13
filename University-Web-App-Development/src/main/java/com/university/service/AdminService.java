package com.university.service;
import com.university.model.Admin;
import com.university.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin registerAdmin(Admin admin) {
        if (adminRepository.existsByUsername(admin.getUsername())) {
            throw new IllegalArgumentException("Username already exists!");
        }
        if (adminRepository.existsByEmail(admin.getEmail())) {
            throw new IllegalArgumentException("Email already registered!");
        }
        return adminRepository.save(admin);
    }

    public Admin login(String username, String password) {
        Admin admin = adminRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password!"));
        if (!admin.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid username or password!");
        }
        return admin;
    }


}