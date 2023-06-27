package com.ltins.javaspringbootchampion.controller;

import com.ltins.javaspringbootchampion.datatransferobjects.SaleDataTransferObject;
import com.ltins.javaspringbootchampion.entity.Sale;
import com.ltins.javaspringbootchampion.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SaleController     {
    SaleService service;
    @Autowired
    public SaleController(SaleService service){this.service = service;}

    @GetMapping("/sales")
    public ResponseEntity<List<SaleDataTransferObject>> showBuildingList(){
        List<Sale> listSales = service.listAll();
        List<SaleDataTransferObject> listDTO = new ArrayList<SaleDataTransferObject>();
        for(Sale sale : listSales){
            listDTO.add(new SaleDataTransferObject(sale));
        }
        return new ResponseEntity<>(listDTO, HttpStatus.OK);
    }
    @GetMapping("/sales/{id}")
    public ResponseEntity<SaleDataTransferObject> getBuildingById(@PathVariable("id") Integer id) {
        Sale sale = service.get(id);
        return new ResponseEntity<>(new SaleDataTransferObject(sale), HttpStatus.OK);
    }
    @PostMapping("/sales")
    public ResponseEntity<SaleDataTransferObject> createBuilding(@RequestBody Sale sale) {
        service.save(sale);
        return new ResponseEntity<>(new SaleDataTransferObject(sale), HttpStatus.CREATED);
    }
    @PutMapping("/sales/{id}")
    public ResponseEntity<HttpStatus> updateBuilding(@RequestBody Sale sale) {
        service.save(sale);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/sales/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/sales")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            service.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
