package com.ltins.javaspringbootchampion.controller;

import com.ltins.javaspringbootchampion.datatransferobjects.EmployeeDataTransferObject;
import com.ltins.javaspringbootchampion.entity.Employee;
import com.ltins.javaspringbootchampion.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController     {
    EmployeeService service;
    @Autowired
    public EmployeeController(EmployeeService service){this.service = service;}

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDataTransferObject>> showBuildingList(){
        List<Employee> listEmployees = service.listAll();
        List<EmployeeDataTransferObject> listDTO = new ArrayList<EmployeeDataTransferObject>();
        for(Employee employee : listEmployees){
            listDTO.add(new EmployeeDataTransferObject(employee));
        }
        return new ResponseEntity<>(listDTO, HttpStatus.OK);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDataTransferObject> getBuildingById(@PathVariable("id") Integer id) {
        Employee employee = service.get(id);
        return new ResponseEntity<>(new EmployeeDataTransferObject(employee), HttpStatus.OK);
    }
    @PostMapping("/employees")
    public ResponseEntity<EmployeeDataTransferObject> createBuilding(@RequestBody Employee employee) {
        service.save(employee);
        return new ResponseEntity<>(new EmployeeDataTransferObject(employee), HttpStatus.CREATED);
    }
    @PutMapping("/employees/{id}")
    public ResponseEntity<HttpStatus> updateBuilding(@RequestBody Employee employee) {
        service.save(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            service.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
