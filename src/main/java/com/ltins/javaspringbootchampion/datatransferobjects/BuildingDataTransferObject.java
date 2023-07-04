package com.ltins.javaspringbootchampion.datatransferobjects;

import com.ltins.javaspringbootchampion.entity.Building;

import java.text.SimpleDateFormat;

public class BuildingDataTransferObject {

    private Integer id;
    private String address;
    private String rentDate;
    private Integer area;

    public BuildingDataTransferObject(Building building) {
        this.id = building.getId();
        this.address = building.getAddress();
        this.rentDate = new SimpleDateFormat("yyyy-mm-dd").format(building.getRentDate());
        this.area = building.getArea();
    }
    public BuildingDataTransferObject() {
        this.address = "Default";
        this.rentDate = "2003-03-03";
        this.area = 1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }
}
