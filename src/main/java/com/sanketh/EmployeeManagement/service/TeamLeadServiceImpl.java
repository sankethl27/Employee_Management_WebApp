package com.sanketh.EmployeeManagement.service;

import com.sanketh.EmployeeManagement.dao.TeamLeadRepository;
import com.sanketh.EmployeeManagement.models.TeamLead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamLeadServiceImpl implements TeamLeadService {

    private final TeamLeadRepository teamLeadRepository;

    @Autowired
    public TeamLeadServiceImpl(TeamLeadRepository teamLeadRepository){
        this.teamLeadRepository = teamLeadRepository;
    }

    @Override
    public TeamLead saveTeamLead(TeamLead teamLead) {
        return teamLeadRepository.save(teamLead);
    }

    @Override
    public Optional<TeamLead> getTeamLeadById(Integer id) {
        return teamLeadRepository.findById(id);
    }

    @Override
    public List<TeamLead> getAllTeamLeads() {
        return teamLeadRepository.findAll();
    }

    @Override
    public void deleteTeamLead(Integer id) {
        teamLeadRepository.deleteById(id);
    }

//    @Override
//    public List<TeamLead> getTeamLeadsByDepartment(Integer departmentId) {
//        return teamLeadRepository.findByDepartmentId(departmentId);
//    }
//
//    @Override
//    public List<TeamLead> getTeamLeadsForProject(Integer projectId) {
//        return teamLeadRepository.findByProjectsId(projectId);
//    }
}
