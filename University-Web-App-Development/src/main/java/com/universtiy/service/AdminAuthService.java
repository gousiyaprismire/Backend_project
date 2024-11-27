package com.universtiy.service;

import com.university.model.Admin;
import java.util.List;

public interface AdminService {


    Admin createAdmin(Admin admin);

    Admin findAdminByEmail(String email);

    boolean validateLogin(String email, String password);
}
