package com.example.SpringBootMySql.SpringBootTask.employee.repository;

import com.example.SpringBootMySql.SpringBootTask.employee.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel,Integer> {

}
