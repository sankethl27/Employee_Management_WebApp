package com.sanketh.EmployeeManagement.service;

import com.sanketh.EmployeeManagement.models.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Project saveProject(Project project);

    Optional<Project> getProjectById(Integer id);

    List<Project> getAllProjects();

    void deleteProject(Integer id);

//    Additional methods if needed
//    List<Project> getProjectsByTeamLead(Integer teamLeadId);
}

