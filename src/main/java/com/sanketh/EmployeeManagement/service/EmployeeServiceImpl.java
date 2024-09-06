package com.sanketh.EmployeeManagement.service;


import com.sanketh.EmployeeManagement.dao.EmployeeRepository;
import com.sanketh.EmployeeManagement.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl( EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(@PathVariable int employeeId){
        Optional<Employee> result = employeeRepository.findById(employeeId);
        
        Employee employee = null;
        if(result.isPresent()){
            employee = result.get();
        }
        else{
            throw new RuntimeException("Could not find employee id :" + employeeId);
        }
        return employee;
    }

    @Override
    public Optional<List<Employee>> getEmployeesByLoggedInTeamLead(String username) {
        return employeeRepository.findEmployeesByTeamLeadUsername(username);
    }
}
