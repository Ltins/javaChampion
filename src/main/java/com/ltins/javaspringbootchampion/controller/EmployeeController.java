package com.ltins.javaspringbootchampion.controller;

import com.ltins.javaspringbootchampion.datatransferobjects.*;
import com.ltins.javaspringbootchampion.entity.*;
import com.ltins.javaspringbootchampion.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @GetMapping
    public List<EmployeeDataTransferObject> showBuildingList(){
        List<Employee> listEmployees = service.listAll();
        List<EmployeeDataTransferObject> listBDTO = new ArrayList();
        for(Employee employee : listEmployees){
            listBDTO.add(new EmployeeDataTransferObject(employee));
        }
        return listBDTO;
    }
}
