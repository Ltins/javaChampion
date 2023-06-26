package com.ltins.javaspringbootchampion.controller;
import com.ltins.javaspringbootchampion.service.BuildingService;
import com.ltins.javaspringbootchampion.entity.Building;
import com.ltins.javaspringbootchampion.datatransferobjects.BuildingDataTransferObject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BuildingController     {
    BuildingService service;
    @Autowired
    public BuildingController(BuildingService service){this.service = service;}

    @GetMapping("/buildings")
    public List<BuildingDataTransferObject> showBuildingList(){
        List<Building> listBuildings = service.listAll();
        List<BuildingDataTransferObject> listBDTO = new ArrayList<BuildingDataTransferObject>();
        for(Building building : listBuildings){
            listBDTO.add(new BuildingDataTransferObject(building));
        }
        return listBDTO;
    }
    @GetMapping("/buildings/{id}")
    public BuildingDataTransferObject getBuildingById(@PathVariable("id") Integer id) {
        Building building = service.get(id);
        return new BuildingDataTransferObject(building);
    }
    @PostMapping("/buildings")
    public ResponseEntity<BuildingDataTransferObject> createBuilding(@RequestBody Building building) {
        service.save(building);
        return new ResponseEntity<>(new BuildingDataTransferObject(building), HttpStatus.CREATED);
    }
    @PutMapping("/buildings/{id}")
    public ResponseEntity<HttpStatus> updateBuilding(@RequestBody Building building) {
        service.save(building);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/buildings/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/buildings")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            service.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
