package com.ltins.javaspringbootchampion.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "providers")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "provider_id", columnDefinition="INT")
    private Integer id;

    @Column(length = 255, nullable = false, name = "provider_name", columnDefinition="VARCHAR(255) DEFAULT 'Ltins Inc.'")
    private String name;

    @Column(length = 255, nullable = false, name = "country_of_origin", columnDefinition="VARCHAR(255) DEFAULT 'Mother Russia'")
    private String country;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
