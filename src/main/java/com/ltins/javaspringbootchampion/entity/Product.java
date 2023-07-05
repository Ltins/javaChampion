package com.ltins.javaspringbootchampion.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", columnDefinition="INT")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "provider_id", nullable = true)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JsonIgnore
    private Provider provider;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "building_id", nullable = true)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JsonIgnore
    private Building building;

    @Column(length = 255, nullable = false, name = "product_name", columnDefinition="VARCHAR(255) UNIQUE", unique = true)
    private String name;

    @Column(name = "availability", columnDefinition="INT DEFAULT 1000")
    private Integer availability;

    @Column(name = "price", columnDefinition="INT DEFAULT 300")
    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", provider=" + provider +
                ", building=" + building +
                ", name='" + name + '\'' +
                ", availability=" + availability +
                ", price=" + price +
                '}';
    }
}
