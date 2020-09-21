package com.exemple.sweater.controllers;

import com.exemple.sweater.domains.Land;
import com.exemple.sweater.repos.LandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/land")
public class LandController {

    @Autowired
    LandRepo landRepo;

    @GetMapping()
    public ResponseEntity<List<Land>> getAll() {
        return new ResponseEntity<>(landRepo.findAll(), HttpStatus.OK);
    }

//    @PostMapping("/add_land")
//    public String addLand(@RequestParam Integer street_id, @RequestParam String number, @RequestParam String cadastr, @RequestParam Integer people_count, @RequestParam Integer owner_id,Model model) {
//        Street street = streetRepo.findByID(street_id);
//        Owner owner = ownerRepo.findByOwner_id(owner_id);
//        Land land = new Land(street, number, cadastr);
//        land.setPeople_count(people_count);
//        land.setOwner(owner);
//        landRepo.saveAndFlush(land);
//
//        return "redirect:/lands";
//    }
//
//    @PostMapping("/edit_land")
//    public String editLand(@RequestParam("land_id") Land land, @RequestParam("street_id") Street street, @RequestParam("owner_id") Owner owner, @RequestParam String number, @RequestParam String cadastr, @RequestParam Integer people_count, Model model) {
//        land.setPeople_count(people_count);
//        land.setNumber(number);
//        land.setCadastr(cadastr);
//        land.setOwner(owner);
//        land.setStreet(street);
//        landRepo.saveAndFlush(land);
//
//        return "redirect:/lands";
//    }
//
//    @GetMapping("/del_lands")
//    public String delLands(@RequestParam List<Integer> mark_item) {
//        for (Integer item: mark_item) {
//            landRepo.deleteById(item);
//        }
//        return "redirect:/lands";
//    }

}

