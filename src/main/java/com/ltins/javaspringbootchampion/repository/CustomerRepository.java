package com.ltins.javaspringbootchampion.repository;

import com.ltins.javaspringbootchampion.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    public Long countById(Integer id);
}
