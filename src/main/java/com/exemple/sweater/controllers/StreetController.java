package com.exemple.sweater.controllers;

import com.exemple.sweater.domains.Land;
import com.exemple.sweater.domains.Street;
import com.exemple.sweater.repos.StreetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class StreetController {

    @Autowired
    StreetRepo streetRepo;

    @GetMapping("/streets")
    public String streetsList(@RequestParam(required = false) Integer street_id, Model model)
    {
        List<Street> streets = streetRepo.findAll();

        if (street_id != null)
        {
            Street edit_street  = streetRepo.findByID(street_id);
            model.addAttribute("edit_street", edit_street);
        }

        model.addAttribute("streets", streets);

        return "streets.html";
    }

    @PostMapping("/add_street")
    public String addStreet(@RequestParam String name, Model model)
    {
        Street street = new Street(name);
        streetRepo.saveAndFlush(street);

        return "redirect:/streets";
    }

    @PostMapping("/edit_street")
    public String editStreet(@RequestParam Integer street_id, @RequestParam String name, Model model)
    {
        Street street = new Street();
        street.setStreet_id(street_id);
        street.setName(name);
        streetRepo.saveAndFlush(street);

        return "redirect:/streets";
    }

    @GetMapping("/del_streets")
    public String delStreet(@RequestParam List<Integer> mark_item)
    {
        for (Integer item: mark_item) {
            try {
                streetRepo.deleteById(item);
            } catch (Exception e) {return "errors/error.html";}

        }
        return "redirect:/streets";

    }
}
