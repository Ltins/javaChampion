package com.ltins.javaspringbootchampion.datatransferobjects;

import com.ltins.javaspringbootchampion.entity.Employee;

import java.text.SimpleDateFormat;

public class EmployeeDataTransferObject {
    private Integer id;
    private String name;
    private String hireDate;
    private Integer salary;
    private String jobTitle;
    private Integer buildingId;

    public EmployeeDataTransferObject(Employee employee){
        this.id = employee.getId();
        this.name = employee.getName();
        this.hireDate = new SimpleDateFormat("yyyy-mm-dd").format(employee.getHireDate());
        this.salary = employee.getSalary();
        this.jobTitle = employee.getJobTitle();
        if(employee.getBuilding() == null) {
            this.buildingId = -1;
        }else {
            this.buildingId = employee.getBuilding().getId();
        }
    }

    public EmployeeDataTransferObject(){
        this.name = "Default";
        this.hireDate = "2003-03-03";
        this.salary = 1;
        this.jobTitle = "Default";
        this.buildingId = -1;
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

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }
}
