package com.ltins.javaspringbootchampion.datatransferobjects;

import com.ltins.javaspringbootchampion.entity.Sale;

import java.text.SimpleDateFormat;

public class SaleDataTransferObject {
    private Integer id;
    private Integer customerId;
    private Integer paymentId;
    private Integer productId;
    private String purchaseDate;
    private Integer quantity;

    public SaleDataTransferObject(Sale sale){
        this.id = sale.getId();
        if(sale.getCustomer() == null) {
            this.customerId = -1;
        }else {
            this.customerId = sale.getCustomer().getId();
        }
        if(sale.getPayment() == null) {
            this.paymentId = -1;
        }else {
            this.paymentId = sale.getPayment().getId();
        }
        if(sale.getProduct() == null) {
            this.productId = -1;
        }else {
            this.productId = sale.getProduct().getId();
        }
        this.purchaseDate = new SimpleDateFormat("yyyy-MM-dd").format(sale.getPurchaseDate());
        this.quantity = sale.getQuantity();
    }

    public SaleDataTransferObject(){
        this.customerId= -1;
        this.paymentId = -1;
        this.productId = -1;
        this.purchaseDate = "2003-03-03";
        this.quantity = 1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "SaleDataTransferObject{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", paymentId=" + paymentId +
                ", productId=" + productId +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
