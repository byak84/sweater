package com.exemple.sweater.controllers;

import com.exemple.sweater.domains.Land;
import com.exemple.sweater.domains.Owner;
import com.exemple.sweater.domains.Street;
import com.exemple.sweater.repos.LandRepo;
import com.exemple.sweater.repos.OwnerRepo;
import com.exemple.sweater.repos.StreetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class LandController {

    @Autowired
    LandRepo landRepo;

    @Autowired
    StreetRepo streetRepo;

    @Autowired
    OwnerRepo ownerRepo;

    @GetMapping("/lands")
    public String landsList(@RequestParam(required = false) Integer land_id, Model model) {
        List<Land> lands = landRepo.findAll();
        List<Street> streets = streetRepo.findAll();
        List<Owner> owners = ownerRepo.findAllOrderById();

        if (land_id != null) {
            Land edit_land = landRepo.findByLand_id(land_id);
            model.addAttribute("edit_land", edit_land);
        }

        model.addAttribute("lands", lands);
        model.addAttribute("streets", streets);
        model.addAttribute("owners", owners);

        return "lands.html";
    }

    @PostMapping("/add_land")
    public String addLand(@RequestParam Integer street_id, @RequestParam String number, @RequestParam String cadastr, @RequestParam Integer people_count, @RequestParam Integer owner_id,Model model) {
        Street street = streetRepo.findByID(street_id);
        Owner owner = ownerRepo.findByOwner_id(owner_id);
        Land land = new Land(street, number, cadastr);
        land.setPeople_count(people_count);
        land.setOwner(owner);
        landRepo.saveAndFlush(land);

        return "redirect:/lands";
    }

    @PostMapping("/edit_land")
    public String editLand(@RequestParam("land_id") Land land, @RequestParam("street_id") Street street, @RequestParam("owner_id") Owner owner, @RequestParam String number, @RequestParam String cadastr, @RequestParam Integer people_count, Model model) {
        land.setPeople_count(people_count);
        land.setNumber(number);
        land.setCadastr(cadastr);
        land.setOwner(owner);
        land.setStreet(street);
        landRepo.saveAndFlush(land);

        return "redirect:/lands";
    }

    @GetMapping("/del_lands")
    public String delLands(@RequestParam List<Integer> mark_item) {
        for (Integer item: mark_item) {
            landRepo.deleteById(item);
        }
        return "redirect:/lands";
    }

}

