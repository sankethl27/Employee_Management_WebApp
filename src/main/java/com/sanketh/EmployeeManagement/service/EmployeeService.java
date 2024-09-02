package com.sanketh.EmployeeManagement.service;

import com.sanketh.EmployeeManagement.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    Employee saveEmployee(Employee employee);

    void deleteEmployee(int id);

    Employee findById(int id);


}
