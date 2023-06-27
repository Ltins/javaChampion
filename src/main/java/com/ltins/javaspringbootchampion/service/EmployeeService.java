package com.ltins.javaspringbootchampion.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ltins.javaspringbootchampion.repository.EmployeeRepository;
import com.ltins.javaspringbootchampion.entity.Employee;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository repo;
    @Autowired
    public EmployeeService(EmployeeRepository repository){
        this.repo = repository;
    }

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