package com.ltins.javaspringbootchampion.repository;

import com.ltins.javaspringbootchampion.entity.Building;
import org.springframework.data.repository.CrudRepository;

public interface BuildingRepository extends CrudRepository<Building, Integer> {
    public Long countById(Integer id);
}