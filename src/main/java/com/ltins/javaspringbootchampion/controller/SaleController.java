package com.ltins.javaspringbootchampion.controller;

import com.ltins.javaspringbootchampion.datatransferobjects.SaleDataTransferObject;
import com.ltins.javaspringbootchampion.entity.Sale;
import com.ltins.javaspringbootchampion.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SaleController     {
    SaleService service;
    @Autowired
    public SaleController(SaleService service){this.service = service;}

    @GetMapping("/sales")
    public List<SaleDataTransferObject> showBuildingList(){
        List<Sale> listBuildings = service.listAll();
        List<SaleDataTransferObject> listBDTO = new ArrayList<SaleDataTransferObject>();
        for(Sale sale : listBuildings){
            listBDTO.add(new SaleDataTransferObject(sale));
        }
        return listBDTO;
    }
}
