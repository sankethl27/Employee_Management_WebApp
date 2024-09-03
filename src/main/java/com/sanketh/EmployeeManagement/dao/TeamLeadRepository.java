package com.sanketh.EmployeeManagement.dao;

import com.sanketh.EmployeeManagement.models.TeamLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamLeadRepository extends JpaRepository<TeamLead,Integer> {
}
