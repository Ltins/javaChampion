package com.ltins.javaspringbootchampion.controller;

import com.ltins.javaspringbootchampion.datatransferobjects.ProviderDataTransferObject;
import com.ltins.javaspringbootchampion.entity.Provider;
import com.ltins.javaspringbootchampion.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProviderController     {
    @Autowired
    ProviderService service;

    @GetMapping("/providers")
    public List<ProviderDataTransferObject> showBuildingList(){
        List<Provider> listBuildings = service.listAll();
        List<ProviderDataTransferObject> listBDTO = new ArrayList<ProviderDataTransferObject>();
        for(Provider provider : listBuildings){
            listBDTO.add(new ProviderDataTransferObject(provider));
        }
        return listBDTO;
    }
}