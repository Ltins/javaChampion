package com.ltins.javaspringbootchampion.datatransferobjects;

import com.ltins.javaspringbootchampion.entity.Payment;

import java.text.SimpleDateFormat;

public class PaymentDataTransferObject {
    private Integer id;
    private String customerName;
    private String date;
    public PaymentDataTransferObject(Payment payment){
        this.id = payment.getId();
        this.date = new SimpleDateFormat("yyyy:MM:dd").format(payment.getDate());
        if(payment.getCustomer() == null){
            this.customerName = "NONE";
        }else{
            this.customerName = payment.getCustomer().getFirstname() + " " + payment.getCustomer().getLastname();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
