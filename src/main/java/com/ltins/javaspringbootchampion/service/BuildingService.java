package com.ltins.javaspringbootchampion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ltins.javaspringbootchampion.repository.*;
import com.ltins.javaspringbootchampion.entity.*;

import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {

    private BuildingRepository repo;
    @Autowired
    public BuildingService(BuildingRepository repo){
        this.repo = repo;
    }
    public List<Building> listAll(){
        return (List<Building>) repo.findAll();
    }

    public void save(Building building) {
        repo.save(building);
    }

    public Building get(Integer id){
        Optional<Building> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        else{
            //throw new BuildinNotFoundException;
            return new Building();
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
