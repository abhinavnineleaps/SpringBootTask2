package com.example.SpringBootMySql.SpringBootTask.employee.controller;



import com.example.SpringBootMySql.SpringBootTask.employee.exception.EmailException;
import com.example.SpringBootMySql.SpringBootTask.employee.exception.EmployeeException;
import com.example.SpringBootMySql.SpringBootTask.employee.model.EmployeeModel;
import com.example.SpringBootMySql.SpringBootTask.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee/v1/")
@CrossOrigin(origins = "http://localhost:4000")
public class EmployeeContoller {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/saveemployee", method = RequestMethod.GET)
    public EmployeeModel saveEmployee(@RequestBody EmployeeModel payload)  {
        return employeeService.saveEmployee(payload);
    }


    @RequestMapping(value = "/getemployee", method = RequestMethod.GET)
    public List<EmployeeModel> employeeModels() {

        return employeeService.findAllEmployee();

    }
    @RequestMapping(value = "/employeeById/{id}", method = RequestMethod.GET)
    public Optional<EmployeeModel> employeeById(@PathVariable("id") int id) throws EmployeeException {
        Optional<EmployeeModel> employeeModel=employeeService.getEmployeeModelById(id);
        if(employeeModel.isEmpty())
            throw new EmployeeException("EMPLOYEE not found");
        return employeeModel;
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
    public String deleteLearners() {
        return employeeService.deleteAllEmployee();
    }
    @RequestMapping(value = "/updateemployeebyid/{id}", method = RequestMethod.PUT)
    public EmployeeModel updateEmployeeById(@PathVariable("id") int id, @RequestBody EmployeeModel emloyeeDetails) throws  EmployeeException, EmailException {
        Optional<EmployeeModel> employeeModel=employeeService.getEmployeeModelById(id);
        if(employeeModel.isEmpty())
        {
            throw  new EmployeeException("can not update user does not exsits");
        }
        String emp=emloyeeDetails.getEmailId();
            if(emp.contains("@"))
                throw new EmailException("Cant change the email");

        return employeeService.updateEmployee(id, emloyeeDetails);
  }
}

