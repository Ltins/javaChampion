package com.ltins.javaspringbootchampion.controller;

import com.ltins.javaspringbootchampion.datatransferobjects.CustomerDataTransferObject;
import com.ltins.javaspringbootchampion.entity.Customer;
import com.ltins.javaspringbootchampion.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController     {
    @Autowired
    CustomerService service;

    @GetMapping("/customers")
    public List<CustomerDataTransferObject> showBuildingList(){
        List<Customer> listBuildings = service.listAll();
        List<CustomerDataTransferObject> listBDTO = new ArrayList<CustomerDataTransferObject>();
        for(Customer customer : listBuildings){
            listBDTO.add(new CustomerDataTransferObject(customer));
        }
        return listBDTO;
    }
}
