package com.ltins.javaspringbootchampion.controller;

import com.ltins.javaspringbootchampion.datatransferobjects.ProviderDataTransferObject;
import com.ltins.javaspringbootchampion.entity.Provider;
import com.ltins.javaspringbootchampion.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProviderController     {
    ProviderService service;
    @Autowired
    public ProviderController(ProviderService service){this.service = service;}

    @GetMapping("/providers")
    public ResponseEntity<List<ProviderDataTransferObject>> showProvidersList(){
        List<Provider> listProviders = service.listAll();
        List<ProviderDataTransferObject> listDTO = new ArrayList<ProviderDataTransferObject>();
        for(Provider provider : listProviders){
            listDTO.add(new ProviderDataTransferObject(provider));
        }
        return new ResponseEntity<>(listDTO, HttpStatus.OK);
    }
    @GetMapping("/providers/{id}")
    public ResponseEntity<ProviderDataTransferObject> getProviderById(@PathVariable("id") Integer id) {
        Provider provider = service.get(id);
        return new ResponseEntity<>(new ProviderDataTransferObject(provider), HttpStatus.OK);
    }
    @PostMapping("/providers")
    public ResponseEntity<ProviderDataTransferObject> createProvider(@RequestBody Provider provider) {
        service.save(provider);
        return new ResponseEntity<>(new ProviderDataTransferObject(provider), HttpStatus.CREATED);
    }
    @PutMapping("/providers/{id}")
    public ResponseEntity<HttpStatus> updateProvider(@RequestBody Provider provider) {
        service.save(provider);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/providers/{id}")
    public ResponseEntity<HttpStatus> deleteProvider(@PathVariable("id") Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/providers")
    public ResponseEntity<HttpStatus> deleteAllProviders() {
        try {
            service.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}