package com.ltins.javaspringbootchampion.repository;

import com.ltins.javaspringbootchampion.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    public Long countById(Integer id);
}
