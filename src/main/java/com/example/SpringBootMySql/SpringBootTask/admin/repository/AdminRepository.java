package com.example.SpringBootMySql.SpringBootTask.admin.repository;

import com.example.SpringBootMySql.SpringBootTask.admin.model.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminModel,Integer> {

}
