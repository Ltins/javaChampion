package com.ltins.javaspringbootchampion.datatransferobjects;

import com.ltins.javaspringbootchampion.entity.Customer;

public class CustomerDataTransferObject {
    private Integer id;
    private String firstname;
    private String lastname;
    public CustomerDataTransferObject(Customer customer){
        this.id = customer.getId();
        this.firstname = customer.getFirstname();
        this.lastname = customer.getLastname();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
