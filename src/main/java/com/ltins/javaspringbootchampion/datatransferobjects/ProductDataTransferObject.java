package com.ltins.javaspringbootchampion.datatransferobjects;

import com.ltins.javaspringbootchampion.entity.Product;

public class ProductDataTransferObject {
    private Integer id;
    private String buildingAddress;
    private String providerName;
    private String productName;
    private Integer availability;
    private Integer price;

    public ProductDataTransferObject(Product product){
        this.id = product.getId();
        if(product.getBuilding() == null) {
            this.buildingAddress = "NONE";
        }else {
            this.buildingAddress = product.getBuilding().getAddress();
        }
        if(product.getProvider() == null) {
            this.providerName = "NONE";
        }else {
            this.providerName = product.getProvider().getName();;
        }
        this.productName = product.getName();
        this.availability = product.getAvailability();
        this.price = product.getPrice();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuildingAddress() {
        return buildingAddress;
    }

    public void setBuildingAddress(String buildingAddress) {
        this.buildingAddress = buildingAddress;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
