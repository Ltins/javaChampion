package com.ltins.javaspringbootchampion.datatransferobjects;

import com.ltins.javaspringbootchampion.entity.Product;

public class ProductDataTransferObject {
    private Integer id;
    private Integer buildingId;
    private Integer providerId;
    private String name;
    private Integer availability;
    private Integer price;

    public ProductDataTransferObject(Product product){
        this.id = product.getId();
        if(product.getBuilding() == null) {
            this.buildingId = -1;
        }else {
            this.buildingId = product.getBuilding().getId();
        }
        if(product.getProvider() == null) {
            this.providerId = -1;
        }else {
            this.providerId = product.getProvider().getId();;
        }
        this.name = product.getName();
        this.availability = product.getAvailability();
        this.price = product.getPrice();
    }

    public ProductDataTransferObject(){
        this.buildingId = -1;
        this.providerId = -1;
        this.name = "Default";
        this.availability = 1;
        this.price = 1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String productName) {
        this.name = productName;
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
