package com.ltins.javaspringbootchampion.controller;
import com.ltins.javaspringbootchampion.service.BuildingService;
import com.ltins.javaspringbootchampion.entity.Building;
import com.ltins.javaspringbootchampion.datatransferobjects.BuildingDataTransferObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BuildingController     {
    @Autowired BuildingService service;

    @GetMapping("/buildings")
    public List<BuildingDataTransferObject> showBuildingList(){
        List<Building> listBuildings = service.listAll();
        List<BuildingDataTransferObject> listBDTO = new ArrayList<BuildingDataTransferObject>();
        for(Building building : listBuildings){
            listBDTO.add(new BuildingDataTransferObject(building));
        }
        return listBDTO;
    }
}
