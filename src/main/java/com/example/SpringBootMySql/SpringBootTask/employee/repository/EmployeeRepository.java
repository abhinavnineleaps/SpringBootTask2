package com.example.SpringBootMySql.SpringBootTask.employee.repository;

import com.example.SpringBootMySql.SpringBootTask.employee.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel,Integer> {

}
