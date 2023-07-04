package com.ltins.javaspringbootchampion.controller;

import com.ltins.javaspringbootchampion.datatransferobjects.PaymentDataTransferObject;
import com.ltins.javaspringbootchampion.entity.Payment;
import com.ltins.javaspringbootchampion.service.PaymentService;
import com.ltins.javaspringbootchampion.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class PaymentController     {
    PaymentService paymentService;
    CustomerService customerService;
    @Autowired
    public PaymentController(PaymentService paymentService, CustomerService customerService){
        this.customerService = customerService;
        this.paymentService = paymentService;
    }

    @GetMapping("/payments")
    public ResponseEntity<List<PaymentDataTransferObject>> showPaymentsList(){
        List<Payment> listPayments = paymentService.listAll();
        List<PaymentDataTransferObject> listDTO = new ArrayList<PaymentDataTransferObject>();
        for(Payment payment : listPayments){
            listDTO.add(new PaymentDataTransferObject(payment));
        }
        return new ResponseEntity<>(listDTO, HttpStatus.OK);
    }
    @GetMapping("/payments/{id}")
    public ResponseEntity<PaymentDataTransferObject> getPaymentById(@PathVariable("id") Integer id) {
        Payment payment = paymentService.get(id);
        return new ResponseEntity<>(new PaymentDataTransferObject(payment), HttpStatus.OK);
    }
    @PostMapping("/payments")
    public ResponseEntity<PaymentDataTransferObject> createPayment(@RequestBody PaymentDataTransferObject paymentTransfer) {
        Payment payment = new Payment();
        payment.setDate(Timestamp.valueOf(paymentTransfer.getDate()+ " 00:00:00"));
        if(paymentTransfer.getCustomerId() > 0){
            payment.setCustomer(customerService.get(paymentTransfer.getCustomerId()));
        }else{
            payment.setCustomer(null);
        }
        paymentService.save(payment);
        return new ResponseEntity<>(new PaymentDataTransferObject(payment), HttpStatus.CREATED);
    }
    @PutMapping("/payments/{id}")
    public ResponseEntity<HttpStatus> updatePayment(@PathVariable("id") Integer id, @RequestBody PaymentDataTransferObject paymentTransfer) {
        Payment payment = paymentService.get(id);
        payment.setDate(Timestamp.valueOf(paymentTransfer.getDate()+ " 00:00:00"));
        if(paymentTransfer.getCustomerId() > 0){
            payment.setCustomer(customerService.get(paymentTransfer.getCustomerId()));
        }else{
            payment.setCustomer(null);
        }
        paymentService.save(payment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/payments/{id}")
    public ResponseEntity<HttpStatus> deletePayment(@PathVariable("id") Integer id) {
        try {
            paymentService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/payments")
    public ResponseEntity<HttpStatus> deleteAllPayments() {
        try {
            paymentService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
