package com.ltins.javaspringbootchampion.repository;

import com.ltins.javaspringbootchampion.entity.Provider;
import org.springframework.data.repository.CrudRepository;

public interface ProviderRepository  extends CrudRepository<Provider, Integer> {
    public Long countById(Integer id);
}
