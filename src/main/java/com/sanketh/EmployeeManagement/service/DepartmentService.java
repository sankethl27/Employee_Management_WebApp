package com.sanketh.EmployeeManagement.service;

import com.sanketh.EmployeeManagement.models.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {


    Department saveDepartment(Department department);

    Optional<Department> getDepartmentById(Integer id);

    List<Department> getAllDepartments();

    void deleteDepartment(Integer id);

    // Additional methods if needed
//    List<Department> getDepartmentsByLocation(String location);
}
