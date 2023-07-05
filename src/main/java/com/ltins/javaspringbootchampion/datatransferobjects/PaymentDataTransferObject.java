package com.ltins.javaspringbootchampion.datatransferobjects;

import com.ltins.javaspringbootchampion.entity.Payment;

import java.text.SimpleDateFormat;

public class PaymentDataTransferObject {
    private Integer id;
    private Integer customerId;
    private String date;
    public PaymentDataTransferObject(Payment payment){
        this.id = payment.getId();
        this.date = new SimpleDateFormat("yyyy-MM-dd").format(payment.getDate());
        if(payment.getCustomer() == null){
            this.customerId = -1;
        }else{
            this.customerId = payment.getCustomer().getId();
        }
    }

    public PaymentDataTransferObject(){
        this.date = "2003-03-03";
        this.customerId = -1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PaymentDataTransferObject{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", date='" + date + '\'' +
                '}';
    }
}
