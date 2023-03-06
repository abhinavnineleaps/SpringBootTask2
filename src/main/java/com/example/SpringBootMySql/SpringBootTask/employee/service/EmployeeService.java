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
    public EmployeeModel saveEmployee(EmployeeModel employee) {

        return employeeRepository.save(employee);
    }
    public List<EmployeeModel> findAllEmployee() {
        return employeeRepository.findAll();
    }

    public Optional<EmployeeModel> getEmployeeModelById(Integer id) {

            return employeeRepository.findById(id);

    }

    public String deleteAllEmployee() {
        employeeRepository.deleteAll();
        return "All Learners Deleted";
    }
    public EmployeeModel updateEmployee(Integer id, EmployeeModel employeeDetails) {
        if (!employeeRepository.existsById(id)) {
            return null;
        }
        Optional<EmployeeModel> employee= employeeRepository.findById(id);
        EmployeeModel new_employee = employee.get();
        new_employee.setFirstName(employeeDetails.getFirstName());
        new_employee.setEmailId(employeeDetails.getEmailId());
        return employeeRepository.save(new_employee);
    }


}
