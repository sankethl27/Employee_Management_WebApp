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
    private Model model;
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
    public String getEmployeesForLoggedInTeamLead(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String userName = userDetails.getUsername();
        String passWord = userDetails.getPassword();
//        List<String> UD = new java.util.ArrayList<>(List.of());
//        UD.add(userName);
//        UD.add(passWord);

//        Optional<Employee> employees =  employeeService.getEmployeesByLoggedInTeamLead(teamLeadId);
        model.addAttribute("employees",userName);
        return "employee";
    }
}
