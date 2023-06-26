package com.ltins.javaspringbootchampion.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Timestamp;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", columnDefinition = "INT")
    private Integer id;
    @Column(length = 255, nullable = false, name = "name", columnDefinition = "VARCHAR(255) DEFAULT 'oleg'")
    private String name;

    @Column(name = "hire_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp hireDate;

    @Column(name = "salary", columnDefinition = "INT DEFAULT 100")
    private Integer salary;

    @Column(length = 255, nullable = false, name = "job_title", columnDefinition = "VARCHAR(255) default 'worker'")
    private String jobTitle;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "building_id", nullable = true)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JsonIgnore
    private Building building;

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

    public Timestamp getHireDate() {
        return hireDate;
    }

    public void setHireDate(Timestamp hireDate) {
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

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", jobTitle='" + jobTitle + '\'' +
                ", building=" + building +
                '}';
    }
}