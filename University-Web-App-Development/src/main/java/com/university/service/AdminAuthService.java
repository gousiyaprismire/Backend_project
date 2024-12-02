package com.university.service;

import com.university.model.Admin;

public interface AdminAuthService {

    Admin createAdmin(Admin admin);

    Admin findAdminByEmail(String email);

    boolean validateLogin(String email, String admin_password);
}


