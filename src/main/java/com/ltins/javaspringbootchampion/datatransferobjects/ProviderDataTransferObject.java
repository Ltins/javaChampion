package com.ltins.javaspringbootchampion.datatransferobjects;

import com.ltins.javaspringbootchampion.entity.Provider;

public class ProviderDataTransferObject {
    private Integer id;
    private String name;
    private String country;
    public ProviderDataTransferObject(Provider provider){
        this.id = provider.getId();
        this.name = provider.getName();
        this.country = provider.getCountry();
    }

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
}
