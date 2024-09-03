package com.sanketh.EmployeeManagement.service;

import com.sanketh.EmployeeManagement.models.TeamLead;

import java.util.List;
import java.util.Optional;

public interface TeamLeadService {

    TeamLead saveTeamLead(TeamLead teamLead);

    Optional<TeamLead> getTeamLeadById(Integer id);

    List<TeamLead> getAllTeamLeads();

    void deleteTeamLead(Integer id);

    // Additional methods if needed
//    List<TeamLead> getTeamLeadsByDepartment(Integer departmentId);
//    List<TeamLead> getTeamLeadsForProject(Integer projectId);
}
