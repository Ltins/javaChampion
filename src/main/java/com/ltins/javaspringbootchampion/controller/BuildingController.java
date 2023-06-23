package com.ltins.javaspringbootchampion.controller;
import com.ltins.javaspringbootchampion.service.*;
import com.ltins.javaspringbootchampion.entity.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BuildingController     {
    @Autowired BuildingService service;

    @GetMapping("/buildings")
    public String showBuildingList(Model model){
        List<Building> listBuildings = service.listAll();
        model.addAttribute("listBuildings", listBuildings);
        return "buildings";
    }

    @GetMapping("/buildings/new")
    public String showNewForm(Model model){
        List<Building> listBuildings = service.listAll();
        model.addAttribute("building", new Building());
        return "building_form";
    }

    @PostMapping("/buildings/save")
    public String saveBuilding(Building building){
        service.save(building);
        return "redirect:/buildings";
    }

    @GetMapping("/buildings/edit{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try{
            Building building = service.get(id);
            model.addAttribute("building", building);
            return "building_form";
        }catch(Throwable e){
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/buildings";
        }
    }

    @GetMapping("/buildings/delete{id}")
    public String deleteBuilding(@PathVariable("id") Integer id, RedirectAttributes ra){
        try{
           service.delete(id);
            ra.addFlashAttribute("message", "The building ID" + id + "has been deleted");
        }catch(Throwable e){
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/buildings";
    }
}
