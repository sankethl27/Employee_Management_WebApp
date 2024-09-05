package com.sanketh.EmployeeManagement.controller;


import com.sanketh.EmployeeManagement.models.TeamLead;
import com.sanketh.EmployeeManagement.service.TeamLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeamLeadController {
    TeamLeadService teamLeadService;

    @Autowired
    public TeamLeadController(TeamLeadService teamLeadService){
        this.teamLeadService = teamLeadService;
    }

    @GetMapping("/teamLead")
    public List<TeamLead> findAll(){
        return teamLeadService.getAllTeamLeads();
    }

    @GetMapping("/teamLead/{id}")
    Optional<TeamLead> findById(@PathVariable int id){
        return teamLeadService.getTeamLeadById(id);
    }


    @PostMapping("/teamLead")
    public TeamLead save(@RequestBody TeamLead teamLead){

        //incase if they pass an id in json set it to zero
        teamLead.setId(0);

        return teamLeadService.saveTeamLead(teamLead);
    }

    @PutMapping("/teamLead")
    TeamLead updateEmployee(@RequestBody TeamLead teamLead){
        return teamLeadService.saveTeamLead(teamLead);
    }

    @DeleteMapping("/teamLead/{id}")
    void delete(@PathVariable int id){
        teamLeadService.deleteTeamLead(id);
    }
}
