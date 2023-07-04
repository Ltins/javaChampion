package com.ltins.javaspringbootchampion.controller;

import com.ltins.javaspringbootchampion.datatransferobjects.SaleDataTransferObject;
import com.ltins.javaspringbootchampion.entity.Sale;
import com.ltins.javaspringbootchampion.service.SaleService;
import com.ltins.javaspringbootchampion.service.CustomerService;
import com.ltins.javaspringbootchampion.service.ProductService;
import com.ltins.javaspringbootchampion.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class SaleController     {
    SaleService saleService;
    CustomerService customerService;

    ProductService productService;

    PaymentService paymentService;
    @Autowired
    public SaleController(SaleService saleService, CustomerService customerService, ProductService productService, PaymentService paymentService){
        this.saleService = saleService;
        this.customerService = customerService;
        this.productService = productService;
        this.paymentService = paymentService;
    }

    @GetMapping("/sales")
    public ResponseEntity<List<SaleDataTransferObject>> showSalesList(){
        List<Sale> listSales = saleService.listAll();
        List<SaleDataTransferObject> listDTO = new ArrayList<SaleDataTransferObject>();
        for(Sale sale : listSales){
            listDTO.add(new SaleDataTransferObject(sale));
        }
        return new ResponseEntity<>(listDTO, HttpStatus.OK);
    }
    @GetMapping("/sales/{id}")
    public ResponseEntity<SaleDataTransferObject> getSaleById(@PathVariable("id") Integer id) {
        Sale sale = saleService.get(id);
        return new ResponseEntity<>(new SaleDataTransferObject(sale), HttpStatus.OK);
    }
    @PostMapping("/sales")
    public ResponseEntity<SaleDataTransferObject> createSale(@RequestBody SaleDataTransferObject saleTransfer) {
        Sale sale = new Sale();
        sale.setQuantity(saleTransfer.getQuantity());
        sale.setPurchaseDate(Timestamp.valueOf(saleTransfer.getPurchaseDate()+ " 00:00:00"));
        if(saleTransfer.getCustomerId() > 0){
            sale.setCustomer(customerService.get(saleTransfer.getCustomerId()));
        }else{
            sale.setCustomer(null);
        }
        if(saleTransfer.getProductId() > 0){
            sale.setProduct(productService.get(saleTransfer.getProductId()));
        }else{
            sale.setProduct(null);
        }
        if(saleTransfer.getPaymentId() > 0){
            sale.setPayment(paymentService.get(saleTransfer.getPaymentId()));
        }else{
            sale.setPayment(null);
        }
        saleService.save(sale);
        return new ResponseEntity<>(new SaleDataTransferObject(sale), HttpStatus.CREATED);
    }
    @PutMapping("/sales/{id}")
    public ResponseEntity<HttpStatus> updateSale(@PathVariable("id") Integer id, @RequestBody SaleDataTransferObject saleTransfer) {
        Sale sale = saleService.get(id);
        sale.setQuantity(saleTransfer.getQuantity());
        sale.setPurchaseDate(Timestamp.valueOf(saleTransfer.getPurchaseDate()+ " 00:00:00"));
        if(saleTransfer.getCustomerId() > 0){
            sale.setCustomer(customerService.get(saleTransfer.getCustomerId()));
        }else{
            sale.setCustomer(null);
        }
        if(saleTransfer.getProductId() > 0){
            sale.setProduct(productService.get(saleTransfer.getProductId()));
        }else{
            sale.setProduct(null);
        }
        if(saleTransfer.getPaymentId() > 0){
            sale.setPayment(paymentService.get(saleTransfer.getPaymentId()));
        }else{
            sale.setPayment(null);
        }
        saleService.save(sale);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/sales/{id}")
    public ResponseEntity<HttpStatus> deleteSale(@PathVariable("id") Integer id) {
        try {
            saleService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/sales")
    public ResponseEntity<HttpStatus> deleteAllSales() {
        try {
            saleService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
