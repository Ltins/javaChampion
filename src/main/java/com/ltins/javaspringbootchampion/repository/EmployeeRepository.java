package com.ltins.javaspringbootchampion.repository;

import com.ltins.javaspringbootchampion.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    List<Employee> findByBuildingId(Integer buildingId);
    public Long countById(Integer id);
    @Transactional
    void deleteByBuildingId(Integer buildingId);
}