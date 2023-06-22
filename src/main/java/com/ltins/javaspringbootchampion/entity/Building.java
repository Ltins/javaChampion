package com.ltins.javaspringbootchampion.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "buildings")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int building_id;
    @Column(length = 255, nullable = false)
    private String address;
    //@Column(name = "CURRENT_TIMESTAMP")
    private Timestamp rent_date;
    //@Column(columnDefinition = "300")
    private Integer area;

    public Integer getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(Integer building_id) {
        this.building_id = building_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getRent_date() {
        return rent_date;
    }

    public void setRent_date(Timestamp rent_date) {
        this.rent_date = rent_date;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
