package com.university.serviceImpl;

import com.university.model.Admin;
import com.university.repository.AdminRepository;
import com.university.service.AdminAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminAuthServiceImpl implements AdminAuthService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin createAdmin(Admin admin)
    {
        return adminRepository.save(admin);
    }


    @Override
    public Admin findAdminByEmail(String email)
    {
        return adminRepository.findByEmail(email);
    }

    @Override
    public boolean validateLogin(String email, String admin_password) {
        Admin admin = adminRepository.findByEmail(email);
        if (admin != null) {
            return admin.getAdmin_password().equals(admin_password);
        }
        return false;
    }
}
