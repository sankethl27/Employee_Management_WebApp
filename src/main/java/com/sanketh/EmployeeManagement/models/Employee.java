package com.sanketh.EmployeeManagement.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
@Table(name = "employee")
public class Employee {

    //Columns Of Table

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    public String username;

    @Column(name = "phone_number")
    private String phoneNo;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department departmentId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    @JsonBackReference
    private Project project;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_lead_id") // Ensure this column exists if using this relation
    @JsonBackReference
    private TeamLead teamLead;

    // Getters and Setters


    //Constructors

    public Employee() {

    }

    public Employee(int id, String firstName, String lastName, String username, String phoneNo, Department departmentId, Project project, TeamLead teamLead) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.phoneNo = phoneNo;
        this.departmentId = departmentId;
        this.project = project;
        this.teamLead = teamLead;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return username;
    }

    public void setEmail(String username) {
        this.username = username;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public TeamLead getTeamLead() {
        return teamLead;
    }

    public void setTeamLead(TeamLead teamLead) {
        this.teamLead = teamLead;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", PhoneNo='" + phoneNo + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
