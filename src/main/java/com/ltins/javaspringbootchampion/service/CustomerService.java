package com.ltins.javaspringbootchampion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ltins.javaspringbootchampion.repository.CustomerRepository;
import com.ltins.javaspringbootchampion.entity.Customer;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository repo;

    @Autowired CustomerService(CustomerRepository repository){
        this.repo = repository;
    }
    public List<Customer> listAll(){
        return (List<Customer>) repo.findAll();
    }

    public void save(Customer customer) {
        repo.save(customer);
    }

    public Customer get(Integer id){
        Optional<Customer> result = repo.findById(id);
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
