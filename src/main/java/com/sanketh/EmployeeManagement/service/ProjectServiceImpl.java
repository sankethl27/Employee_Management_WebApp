package com.sanketh.EmployeeManagement.service;

import com.sanketh.EmployeeManagement.dao.ProjectRepository;
import com.sanketh.EmployeeManagement.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {


    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl( ProjectRepository projectRepository){
        this. projectRepository = projectRepository;
    }

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Optional<Project> getProjectById(Integer id) {
        return projectRepository.findById(id);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public void deleteProject(Integer id) {
        projectRepository.deleteById(id);
    }

//    @Override
//    public List<Project> getProjectsByTeamLead(Integer teamLeadId) {
//        return projectRepository.findByTeamLeadId(teamLeadId);
//    }
}
