package com.ltins.javaspringbootchampion.controller;

import com.ltins.javaspringbootchampion.datatransferobjects.ProductDataTransferObject;
import com.ltins.javaspringbootchampion.entity.Product;
import com.ltins.javaspringbootchampion.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController     {
    ProductService service;
    @Autowired
    public ProductController(ProductService service){this.service = service;}
    @GetMapping("/products")
    public List<ProductDataTransferObject> showBuildingList(){
        List<Product> listBuildings = service.listAll();
        List<ProductDataTransferObject> listBDTO = new ArrayList<ProductDataTransferObject>();
        for(Product product : listBuildings){
            listBDTO.add(new ProductDataTransferObject(product));
        }
        return listBDTO;
    }
}
