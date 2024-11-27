package com.universtiy.service;

import com.university.model.Admin;

public interface AdminAuthService {


    Admin createAdmin(Admin admin);

    Admin findAdminByEmail(String email);

    boolean validateLogin(String email, String password);


}
