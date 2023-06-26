package com.ltins.javaspringbootchampion.datatransferobjects;

import com.ltins.javaspringbootchampion.entity.Sale;

import java.text.SimpleDateFormat;

public class SaleDataTransferObject {
    private Integer id;
    private String customerName;
    private Integer paymentId;
    private String productName;
    private String purchaseDate;
    private Integer quantity;

    public SaleDataTransferObject(Sale sale){
        this.id = sale.getId();
        if(sale.getCustomer() == null) {
            this.customerName = "NONE";
        }else {
            this.customerName = sale.getCustomer().getFirstname() + " " + sale.getCustomer().getLastname();
        }
        if(sale.getPayment() == null) {
            this.paymentId = -1;
        }else {
            this.paymentId = sale.getPayment().getId();
        }
        if(sale.getProduct() == null) {
            this.productName = "NONE";
        }else {
            this.productName = sale.getProduct().getName();
        }
        this.purchaseDate = new SimpleDateFormat("yyyy:MM:dd").format(sale.getPurchaseDate());
        this.quantity = sale.getQuantity();
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

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
