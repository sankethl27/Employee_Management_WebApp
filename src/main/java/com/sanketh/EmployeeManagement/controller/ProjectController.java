package com.sanketh.EmployeeManagement.controller;


import com.sanketh.EmployeeManagement.models.Project;
import com.sanketh.EmployeeManagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController

public class ProjectController {
    ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }


    @GetMapping("/project")
    public List<Project> findAll(){
        return projectService.getAllProjects();
    }

    @GetMapping("/project/{id}")
    Optional<Project> findById(@PathVariable int id){
        return projectService.getProjectById(id);
    }


    @PostMapping("/project")
    public Project save(@RequestBody Project project){

        //incase if they pass an id in json set it to zero
        project.setId(0);

        return projectService.saveProject(project);
    }

    @PutMapping("/project")
    Project updateEmployee(@RequestBody Project project){
        return projectService.saveProject(project);
    }

    @DeleteMapping("/project/{id}")
    void delete(@PathVariable int id){
        projectService.deleteProject(id);
    }
}
