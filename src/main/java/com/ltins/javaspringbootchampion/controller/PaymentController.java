package com.ltins.javaspringbootchampion.controller;

import com.ltins.javaspringbootchampion.datatransferobjects.PaymentDataTransferObject;
import com.ltins.javaspringbootchampion.entity.Payment;
import com.ltins.javaspringbootchampion.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PaymentController     {
    PaymentService service;
    @Autowired
    public PaymentController(PaymentService service){this.service = service;}

    @GetMapping("/payments")
    public List<PaymentDataTransferObject> showBuildingList(){
        List<Payment> listBuildings = service.listAll();
        List<PaymentDataTransferObject> listBDTO = new ArrayList<PaymentDataTransferObject>();
        for(Payment payment : listBuildings){
            listBDTO.add(new PaymentDataTransferObject(payment));
        }
        return listBDTO;
    }
}
