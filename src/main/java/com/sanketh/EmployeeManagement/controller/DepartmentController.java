package com.sanketh.EmployeeManagement.controller;

import com.sanketh.EmployeeManagement.models.Department;
import com.sanketh.EmployeeManagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public  DepartmentController( DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping("/department")
    public List<Department> findAll(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/department/{id}")
    Optional<Department> findById(@PathVariable int id){
        return departmentService.getDepartmentById(id);
    }


    @PostMapping("/department")
    public Department save(@RequestBody Department department){

        //incase if they pass an id in json set it to zero
        department.setId(0);

        Department theDepartment = departmentService.saveDepartment(department);
        return theDepartment;
    }

    @PutMapping("/department")
    Department updateDepartm(@RequestBody Department theDepartment){
        return departmentService.saveDepartment(theDepartment);
    }

    @DeleteMapping("/department/{id}")
    void deleteDepartment(@PathVariable int id){
        departmentService.deleteDepartment(id);
    }


    }
