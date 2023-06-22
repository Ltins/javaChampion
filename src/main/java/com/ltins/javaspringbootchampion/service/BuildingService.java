package com.ltins.javaspringbootchampion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ltins.javaspringbootchampion.repository.*;
import com.ltins.javaspringbootchampion.entity.*;

import java.util.List;

@Service
public class BuildingService {
    @Autowired private BuildingRepository repo;

    public List<Building> listAll(){
        return (List<Building>) repo.findAll();
    }

}
