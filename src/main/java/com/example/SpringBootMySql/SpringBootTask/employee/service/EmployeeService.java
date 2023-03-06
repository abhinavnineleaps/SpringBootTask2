package com.example.SpringBootMySql.SpringBootTask.employee.service;

import com.example.SpringBootMySql.SpringBootTask.employee.model.EmployeeModel;
import com.example.SpringBootMySql.SpringBootTask.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeModel getEmployeeModelById(Integer id) {
        Optional<EmployeeModel> checkEmployee =employeeRepository.findById(id);
        if (checkEmployee.isPresent())
            return checkEmployee.get();
        return null;
    }
    public EmployeeModel saveEmployee(EmployeeModel employee) {

        return employeeRepository.save(employee);
    }

    public List<EmployeeModel> findAllEmployee() {
        return employeeRepository.findAll();
    }

    public EmployeeModel updateEmployee(Integer id, EmployeeModel employeeDetails) {
        if (!employeeRepository.existsById(id)) {
            return null;
        }
        Optional<EmployeeModel> user = employeeRepository.findById(id);
        EmployeeModel new_Employee = user.get();

        new_Employee.setFirstName(employeeDetails.getFirstName());
        new_Employee.setEmailId(employeeDetails.getEmailId());
        return employeeRepository.save(employeeDetails);
    }

}
