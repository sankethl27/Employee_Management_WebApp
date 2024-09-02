package com.sanketh.EmployeeManagement.controller;


import com.sanketh.EmployeeManagement.dao.EmployeeRepository;
import com.sanketh.EmployeeManagement.models.Employee;
import com.sanketh.EmployeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @RequestMapping("/api")
    public String helloWorld(){
        return "Welcome to Employee Management";
    }

    @GetMapping("/employee")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    Employee findById(@PathVariable int id){
        return employeeService.findById(id);
    }


    @PostMapping("/employee")
    public Employee save( @RequestBody Employee employee){

        //incase if they pass an id in json set it to zero
        employee.setId(0);

        Employee dbEmployee = employeeService.saveEmployee(employee);
        return dbEmployee;
    }

    @PutMapping("/employee")
    Employee updateEmployee(@RequestBody Employee employee){
        Employee dbEmployee = employeeService.saveEmployee(employee);
        return dbEmployee;
    }

    @DeleteMapping("/employee/{id}")
    void delete(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }




}
