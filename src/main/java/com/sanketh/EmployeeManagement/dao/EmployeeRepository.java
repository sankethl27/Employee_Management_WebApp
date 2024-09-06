package com.sanketh.EmployeeManagement.dao;

import com.sanketh.EmployeeManagement.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query("SELECT e FROM Employee e JOIN e.teamLead t WHERE t.username = :username")
    Optional<List<Employee>> findEmployeesByTeamLeadUsername(@Param("username") String username);

}
