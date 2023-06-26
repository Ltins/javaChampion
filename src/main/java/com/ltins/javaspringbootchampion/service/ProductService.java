package com.ltins.javaspringbootchampion.service;

import com.ltins.javaspringbootchampion.entity.Product;
import com.ltins.javaspringbootchampion.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository repo;
    @Autowired
    public ProductService(ProductRepository repository){
        this.repo = repository;
    }

    public List<Product> listAll(){
        return (List<Product>) repo.findAll();
    }

    public void save(Product product) {
        repo.save(product);
    }

    public Product get(Integer id){
        Optional<Product> result = repo.findById(id);
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
