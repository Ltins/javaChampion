package com.ltins.javaspringbootchampion.service;

import com.ltins.javaspringbootchampion.entity.Payment;
import com.ltins.javaspringbootchampion.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PaymentService {
    private PaymentRepository repo;
    @Autowired
    public PaymentService(PaymentRepository repository){
        this.repo = repository;
    }

    public List<Payment> listAll(){
        return (List<Payment>) repo.findAll();
    }

    public void save(Payment payment) {
        repo.save(payment);
    }

    public Payment get(Integer id){
        Optional<Payment> result = repo.findById(id);
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