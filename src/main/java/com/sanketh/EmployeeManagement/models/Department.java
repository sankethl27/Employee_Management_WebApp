package com.sanketh.EmployeeManagement.models;


import jakarta.persistence.*;

@Table
@Entity
public class Department {


    //Table Columns

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String DeptName;

    @Column(name = "location")
    private String Location;

    //Constructors

    public Department(){

    }

    public Department(int id,String DeptName,String Location){
        this.id = id;
        this.DeptName = DeptName;
        this.Location = Location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String deptName) {
        DeptName = deptName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", DeptName='" + DeptName + '\'' +
                ", Location='" + Location + '\'' +
                '}';
    }
}
