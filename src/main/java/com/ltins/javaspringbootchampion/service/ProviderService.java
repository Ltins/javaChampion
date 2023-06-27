package com.ltins.javaspringbootchampion.service;

import com.ltins.javaspringbootchampion.entity.Provider;
import com.ltins.javaspringbootchampion.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProviderService {
    private ProviderRepository repo;
    @Autowired
    public ProviderService(ProviderRepository repository){
        this.repo = repository;
    }

    public List<Provider> listAll(){
        return (List<Provider>) repo.findAll();
    }

    public void save(Provider payment) {
        repo.save(payment);
    }

    public Provider get(Integer id){
        Optional<Provider> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        else{
            throw new NoSuchElementException("No such element");
        }
    }

    public void delete(Integer id){
        Long count = repo.countById(id);
        if(count == null || count == 0){
            throw new NoSuchElementException("No such element");
        }
        repo.deleteById(id);
    }
    public void deleteAll(){
        repo.deleteAll();
    }
}