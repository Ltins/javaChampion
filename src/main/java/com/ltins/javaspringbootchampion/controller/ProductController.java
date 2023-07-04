package com.ltins.javaspringbootchampion.controller;

import com.ltins.javaspringbootchampion.datatransferobjects.ProductDataTransferObject;
import com.ltins.javaspringbootchampion.entity.Product;
import com.ltins.javaspringbootchampion.service.ProductService;
import com.ltins.javaspringbootchampion.service.BuildingService;
import com.ltins.javaspringbootchampion.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ProductController     {
    ProductService productService;
    BuildingService buildingService;
    ProviderService providerService;
    @Autowired
    public ProductController(ProductService productService, BuildingService buildingService, ProviderService providerService){
        this.productService = productService;
        this.buildingService = buildingService;
        this.providerService = providerService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDataTransferObject>> showProductsList(){
        List<Product> listProducts = productService.listAll();
        List<ProductDataTransferObject> listDTO = new ArrayList<ProductDataTransferObject>();
        for(Product product : listProducts){
            listDTO.add(new ProductDataTransferObject(product));
        }
        return new ResponseEntity<>(listDTO, HttpStatus.OK);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDataTransferObject> getProductById(@PathVariable("id") Integer id) {
        Product product = productService.get(id);
        return new ResponseEntity<>(new ProductDataTransferObject(product), HttpStatus.OK);
    }
    @PostMapping("/products")
    public ResponseEntity<ProductDataTransferObject> createProduct(@RequestBody ProductDataTransferObject productTransfer) {
        Product product = new Product();
        product.setAvailability(productTransfer.getAvailability());
        product.setName(productTransfer.getName());
        product.setPrice(productTransfer.getPrice());
        if(productTransfer.getBuildingId() > 0){
            product.setBuilding(buildingService.get(productTransfer.getBuildingId()));
        }else{
            product.setBuilding(null);
        }
        if(productTransfer.getProviderId() > 0){
            product.setProvider(providerService.get(productTransfer.getProviderId()));
        }else{
            product.setProvider(null);
        }
        productService.save(product);
        return new ResponseEntity<>(new ProductDataTransferObject(product), HttpStatus.CREATED);
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<HttpStatus> updateProduct(@PathVariable("id") Integer id, @RequestBody ProductDataTransferObject productTransfer) {
        Product product = productService.get(id);
        product.setAvailability(productTransfer.getAvailability());
        product.setName(productTransfer.getName());
        product.setPrice(productTransfer.getPrice());
        if(productTransfer.getBuildingId() > 0){
            product.setBuilding(buildingService.get(productTransfer.getBuildingId()));
        }else{
            product.setBuilding(null);
        }
        if(productTransfer.getProviderId() > 0){
            product.setProvider(providerService.get(productTransfer.getProviderId()));
        }else{
            product.setProvider(null);
        }
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") Integer id) {
        try {
            productService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/products")
    public ResponseEntity<HttpStatus> deleteAllProducts() {
        try {
            productService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
