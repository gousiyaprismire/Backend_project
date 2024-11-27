package com.university.serviceImpl;

import com.university.model.Admin;
import com.university.repository.AdminRepository;
import com.universtiy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository)
    {
        this.adminRepository = adminRepository;
    }

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
    public boolean validateLogin(String email, String password) {
        Admin admin = adminRepository.findByEmail(email);
        if (admin != null)
        {
            return admin.getPassword().equals(password);
        }
        return false;
    }
}
