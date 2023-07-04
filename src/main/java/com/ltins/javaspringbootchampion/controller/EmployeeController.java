package com.ltins.javaspringbootchampion.controller;

import com.ltins.javaspringbootchampion.datatransferobjects.EmployeeDataTransferObject;
import com.ltins.javaspringbootchampion.entity.Employee;
import com.ltins.javaspringbootchampion.service.EmployeeService;
import com.ltins.javaspringbootchampion.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class EmployeeController     {
    EmployeeService employeeService;
    BuildingService buildingService;
    @Autowired
    public EmployeeController(EmployeeService employeeService, BuildingService buildingService){
        this.employeeService = employeeService;
        this.buildingService = buildingService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDataTransferObject>> showEmployeesList(){
        List<Employee> listEmployees = employeeService.listAll();
        List<EmployeeDataTransferObject> listDTO = new ArrayList<EmployeeDataTransferObject>();
        for(Employee employee : listEmployees){
            listDTO.add(new EmployeeDataTransferObject(employee));
        }
        return new ResponseEntity<>(listDTO, HttpStatus.OK);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDataTransferObject> getEmployeeById(@PathVariable("id") Integer id) {
        Employee employee = employeeService.get(id);
        return new ResponseEntity<>(new EmployeeDataTransferObject(employee), HttpStatus.OK);
    }
    @PostMapping("/employees")
    public ResponseEntity<EmployeeDataTransferObject> createEmployee(@RequestBody EmployeeDataTransferObject employeeTransfer) {
        Employee employee = new Employee();
        employee.setName(employeeTransfer.getName());
        employee.setSalary(employeeTransfer.getSalary());
        employee.setJobTitle(employeeTransfer.getJobTitle());
        employee.setHireDate(Timestamp.valueOf(employeeTransfer.getHireDate() + " 00:00:00"));
        if(employeeTransfer.getBuildingId() > 0) {
            employee.setBuilding(buildingService.get(employeeTransfer.getBuildingId()));
        }else{
            employee.setBuilding(null);
        }
        employeeService.save(employee);
        return new ResponseEntity<>(new EmployeeDataTransferObject(employee), HttpStatus.CREATED);
    }
    @PutMapping("/employees/{id}")
    public ResponseEntity<HttpStatus> updateEmployee(@PathVariable("id") Integer id, @RequestBody EmployeeDataTransferObject employeeTransfer) {
        Employee employee = employeeService.get(id);
        employee.setName(employeeTransfer.getName());
        employee.setSalary(employeeTransfer.getSalary());
        employee.setJobTitle(employeeTransfer.getJobTitle());
        employee.setHireDate(Timestamp.valueOf(employeeTransfer.getHireDate() + " 00:00:00"));
        if(employeeTransfer.getBuildingId() > 0) {
            employee.setBuilding(buildingService.get(employeeTransfer.getBuildingId()));
        }else{
            employee.setBuilding(null);
        }
        employeeService.save(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") Integer id) {
        try {
            employeeService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteAllEmployees() {
        try {
            employeeService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
