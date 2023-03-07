package com.example.SpringBootMySql.SpringBootTask.admin.service;

import com.example.SpringBootMySql.SpringBootTask.admin.model.AdminModel;
import com.example.SpringBootMySql.SpringBootTask.admin.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public AdminModel saveDetails(AdminModel payload) {
        return adminRepository.save(payload);
    }
}
