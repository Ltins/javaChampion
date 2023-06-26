package com.ltins.javaspringbootchampion.datatransferobjects;

import com.ltins.javaspringbootchampion.entity.Employee;

import java.text.SimpleDateFormat;

public class EmployeeDataTransferObject {
    private Integer id;
    private String name;
    private String hireDate;
    private Integer salary;
    private String jobTitle;
    private String buildingAddress;

    public EmployeeDataTransferObject(Employee employee){
        this.id = employee.getId();
        this.name = employee.getName();
        this.hireDate = new SimpleDateFormat("yyyy:MM:dd").format(employee.getHireDate());
        this.salary = employee.getSalary();
        this.jobTitle = employee.getJobTitle();
        if(employee.getBuilding() == null) {
            this.buildingAddress = "NONE";
        }else {
            this.buildingAddress = employee.getBuilding().getAddress();
        }
    }

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

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getBuildingAddress() {
        return buildingAddress;
    }

    public void setBuildingAddress(String buildingAddress) {
        this.buildingAddress = buildingAddress;
    }
}
