package com.ltins.javaspringbootchampion.controller;

import com.ltins.javaspringbootchampion.datatransferobjects.EmployeeDataTransferObject;
import com.ltins.javaspringbootchampion.entity.Employee;
import com.ltins.javaspringbootchampion.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    EmployeeService service;
    @Autowired
    public EmployeeController(EmployeeService service){this.service = service;}

    @GetMapping("/employees")
    public List<EmployeeDataTransferObject> showBuildingList(){
        List<Employee> listEmployees = service.listAll();
        List<EmployeeDataTransferObject> listBDTO = new ArrayList();
        for(Employee employee : listEmployees){
            listBDTO.add(new EmployeeDataTransferObject(employee));
        }
        return listBDTO;
    }
}
