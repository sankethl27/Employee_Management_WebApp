package com.sanketh.EmployeeManagement.models;



import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


import java.util.List;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "team_lead_id", nullable = false)
    @JsonBackReference
    private TeamLead teamLead;

    @OneToMany(mappedBy = "project")
    private List<Employee> employees;


    //constructors
    public Project(){

    }

    public Project(Integer id, String name, String description, TeamLead teamLead, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.teamLead = teamLead;
        this.employees = employees;
    }
    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TeamLead getTeamLead() {
        return teamLead;
    }

    public void setTeamLead(TeamLead teamLead) {
        this.teamLead = teamLead;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
