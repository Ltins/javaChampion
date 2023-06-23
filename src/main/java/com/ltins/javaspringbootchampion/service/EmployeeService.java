package com.ltins.javaspringbootchampion.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ltins.javaspringbootchampion.repository.*;
import com.ltins.javaspringbootchampion.entity.*;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired private EmployeeRepository repo;

    public List<Employee> listAll(){
        return (List<Employee>) repo.findAll();
    }

    public void save(Employee employee) {
        repo.save(employee);
    }

    public Employee get(Integer id){
        Optional<Employee> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        else{
            //throw new BuildinNotFoundException;
            return new Employee();
        }
    }

    public void delete(Integer id){
        Long count = repo.countById(id);
        if(count == null || count == 0){
            //throw new BuildingNotFoundException();
        }
        repo.deleteById(id);
    }

}