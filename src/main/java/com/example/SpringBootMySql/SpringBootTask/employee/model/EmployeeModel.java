package com.example.SpringBootMySql.SpringBootTask.employee.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "employee")
public class EmployeeModel {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO) //for long int generation
    private int id;
    @Column(name = "age")
    private int age;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "email_id")
    private String emailId;



}
