package com.ltins.javaspringbootchampion.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "buildings")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "building_id")
    private Integer id;
    @Column(length = 255, nullable = false, name = "address")
    private String address;
    @Column(name = "rent_date")
    private Timestamp rentDate;
    @Column(name = "area")
    private Integer area;

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

    public Timestamp getRentDate() {
        return rentDate;
    }

    public void setRentDate(Timestamp rentDate) {
        this.rentDate = rentDate;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", rentDate=" + rentDate +
                ", area=" + area +
                '}';
    }
}
