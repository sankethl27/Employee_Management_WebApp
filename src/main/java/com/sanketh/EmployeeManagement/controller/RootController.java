package com.sanketh.EmployeeManagement.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import com.sanketh.EmployeeManagement.models.Employee;
import com.sanketh.EmployeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class RootController {


    private final EmployeeService employeeService;
    @Autowired
    public RootController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/")
    public String homePage(){
        return "home";
    }
    @GetMapping("/login")
    public String loginController(){
        return "login";
    }

    @GetMapping("/systems")
    public String aboutSystem(){
        return "systems";
    }

    //Get Employees Under a particular Team Lead
    @GetMapping("employee/teamLead")
    public String getEmployeesForLoggedInTeamLead(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("username is : " + userDetails.getUsername());
        System.out.println("Authorities are : " + userDetails.getAuthorities());
        String username = userDetails.getUsername();

        Optional<List<Employee>> employeesOpt =  employeeService.getEmployeesByLoggedInTeamLead(username);
        if (employeesOpt.isPresent()) {
            List<Employee> employees = employeesOpt.get();
            model.addAttribute("employees", employees);
        } else {
            model.addAttribute("message", "No employees found.");
        }
        return "employees";
    }
}
