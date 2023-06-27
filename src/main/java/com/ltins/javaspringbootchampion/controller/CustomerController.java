package com.ltins.javaspringbootchampion.controller;

import com.ltins.javaspringbootchampion.datatransferobjects.CustomerDataTransferObject;
import com.ltins.javaspringbootchampion.entity.Customer;
import com.ltins.javaspringbootchampion.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController     {
    CustomerService service;
    @Autowired
    public CustomerController(CustomerService service){this.service = service;}

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDataTransferObject>> showCustomersList(){
        List<Customer> listCustomers = service.listAll();
        List<CustomerDataTransferObject> listDTO = new ArrayList<CustomerDataTransferObject>();
        for(Customer customer : listCustomers){
            listDTO.add(new CustomerDataTransferObject(customer));
        }
        return new ResponseEntity<>(listDTO, HttpStatus.OK);
    }
    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerDataTransferObject> getCustomerById(@PathVariable("id") Integer id) {
        Customer customer = service.get(id);
        return new ResponseEntity<>(new CustomerDataTransferObject(customer), HttpStatus.OK);
    }
    @PostMapping("/customers")
    public ResponseEntity<CustomerDataTransferObject> createCustomer(@RequestBody Customer customer) {
        service.save(customer);
        return new ResponseEntity<>(new CustomerDataTransferObject(customer), HttpStatus.CREATED);
    }
    @PutMapping("/customers/{id}")
    public ResponseEntity<HttpStatus> updateCustomer(@RequestBody Customer customer) {
        service.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/customers")
    public ResponseEntity<HttpStatus> deleteAllCustomers() {
        try {
            service.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
