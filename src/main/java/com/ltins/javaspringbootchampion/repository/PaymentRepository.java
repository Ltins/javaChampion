package com.ltins.javaspringbootchampion.repository;

import com.ltins.javaspringbootchampion.entity.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
    public Long countById(Integer id);
}
