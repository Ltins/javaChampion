package com.ltins.javaspringbootchampion.controller;

import com.ltins.javaspringbootchampion.datatransferobjects.PaymentDataTransferObject;
import com.ltins.javaspringbootchampion.entity.Payment;
import com.ltins.javaspringbootchampion.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PaymentController     {
    PaymentService service;
    @Autowired
    public PaymentController(PaymentService service){this.service = service;}

    @GetMapping("/payments")
    public ResponseEntity<List<PaymentDataTransferObject>> showPaymentsList(){
        List<Payment> listPayments = service.listAll();
        List<PaymentDataTransferObject> listDTO = new ArrayList<PaymentDataTransferObject>();
        for(Payment payment : listPayments){
            listDTO.add(new PaymentDataTransferObject(payment));
        }
        return new ResponseEntity<>(listDTO, HttpStatus.OK);
    }
    @GetMapping("/payments/{id}")
    public ResponseEntity<PaymentDataTransferObject> getPaymentById(@PathVariable("id") Integer id) {
        Payment payment = service.get(id);
        return new ResponseEntity<>(new PaymentDataTransferObject(payment), HttpStatus.OK);
    }
    @PostMapping("/payments")
    public ResponseEntity<PaymentDataTransferObject> createPayment(@RequestBody Payment payment) {
        service.save(payment);
        return new ResponseEntity<>(new PaymentDataTransferObject(payment), HttpStatus.CREATED);
    }
    @PutMapping("/payments/{id}")
    public ResponseEntity<HttpStatus> updatePayment(@RequestBody Payment payment) {
        service.save(payment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/payments/{id}")
    public ResponseEntity<HttpStatus> deletePayment(@PathVariable("id") Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/payments")
    public ResponseEntity<HttpStatus> deleteAllPayments() {
        try {
            service.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
