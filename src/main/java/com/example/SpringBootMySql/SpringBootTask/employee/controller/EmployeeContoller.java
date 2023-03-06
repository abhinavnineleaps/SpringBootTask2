package com.example.SpringBootMySql.SpringBootTask.employee.controller;


import com.example.SpringBootMySql.SpringBootTask.employee.exception.EmployeeException;
import com.example.SpringBootMySql.SpringBootTask.employee.exception.IdException;
import com.example.SpringBootMySql.SpringBootTask.employee.model.EmployeeModel;
import com.example.SpringBootMySql.SpringBootTask.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/v1/")
@CrossOrigin(origins = "http://localhost:4000")
public class EmployeeContoller {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/saveemployee", method = RequestMethod.GET)
    public EmployeeModel saveUsers(@RequestBody EmployeeModel payload) throws IdException {
        int id=payload.getId();
        if(payload.getId()==0)
            throw new IdException("Id not found");
        return payload;
    }
    @RequestMapping(value = "/getlist", method = RequestMethod.GET)
    public List<EmployeeModel> signupModelList() throws EmployeeException {
        if(employeeService.findAllEmployee()==null) throw new EmployeeException("No content found");
        return employeeService.findAllEmployee();

    }
//
//    @RequestMapping(value = "/finduserbyid/{id}", method = RequestMethod.GET)
//    public EmployeeModel findUserById(@PathVariable("id") Integer id) throws UserException  {
//
//        EmployeeModel signupModel=employeeService.getEmployeeModelById(id);
//        if(signupModel==null)
//            throw new UserException(("user not found"));
//
//        return signupModel;
//    }

}

