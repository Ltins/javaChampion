package com.ltins.javaspringbootchampion.repository;

import com.ltins.javaspringbootchampion.entity.Sale;
import org.springframework.data.repository.CrudRepository;

public interface SaleRepository  extends CrudRepository<Sale, Integer> {
    public Long countById(Integer id);
}
