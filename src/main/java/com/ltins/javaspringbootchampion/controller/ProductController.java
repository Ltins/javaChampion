package com.ltins.javaspringbootchampion.controller;

import com.ltins.javaspringbootchampion.datatransferobjects.ProductDataTransferObject;
import com.ltins.javaspringbootchampion.entity.Product;
import com.ltins.javaspringbootchampion.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController     {
    ProductService service;
    @Autowired
    public ProductController(ProductService service){this.service = service;}

    @GetMapping("/products")
    public ResponseEntity<List<ProductDataTransferObject>> showBuildingList(){
        List<Product> listProducts = service.listAll();
        List<ProductDataTransferObject> listDTO = new ArrayList<ProductDataTransferObject>();
        for(Product product : listProducts){
            listDTO.add(new ProductDataTransferObject(product));
        }
        return new ResponseEntity<>(listDTO, HttpStatus.OK);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDataTransferObject> getBuildingById(@PathVariable("id") Integer id) {
        Product product = service.get(id);
        return new ResponseEntity<>(new ProductDataTransferObject(product), HttpStatus.OK);
    }
    @PostMapping("/products")
    public ResponseEntity<ProductDataTransferObject> createBuilding(@RequestBody Product product) {
        service.save(product);
        return new ResponseEntity<>(new ProductDataTransferObject(product), HttpStatus.CREATED);
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<HttpStatus> updateBuilding(@RequestBody Product product) {
        service.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/products")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            service.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
