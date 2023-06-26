package com.ltins.javaspringbootchampion.service;

import com.ltins.javaspringbootchampion.entity.Sale;
import com.ltins.javaspringbootchampion.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SaleService {
    private SaleRepository repo;
    @Autowired
    public SaleService(SaleRepository repository){
        this.repo = repository;
    }

    public List<Sale> listAll(){
        return (List<Sale>) repo.findAll();
    }

    public void save(Sale sale) {
        repo.save(sale);
    }

    public Sale get(Integer id){
        Optional<Sale> result = repo.findById(id);
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

}
