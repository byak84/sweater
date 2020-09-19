package com.exemple.sweater.controllers;

import com.exemple.sweater.domains.Owner;
import com.exemple.sweater.repos.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerRepo ownerRepo;


    @GetMapping
    public List<Owner> GetAll() {
        return ownerRepo.findAll();
    }

    @GetMapping("{id}")
    public Optional<Owner> GetOne(@PathVariable Integer id) {
        Owner owner = new Owner();
        Optional<Owner> result = (ownerRepo.findById(id) == null) ? ownerRepo.findById(id) : Optional.ofNullable(owner);
        return result;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Owner Add(@Valid @RequestBody Owner owner) {
       ownerRepo.saveAndFlush(owner);
       return owner;
    }


//    @PostMapping("add_owner")
//    public String addOwner(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String patronymic, @RequestParam String phone, @RequestParam String comment, Map<String, Object> model)
//    {
//        Owner owner = new Owner(firstname,lastname,patronymic,phone,comment);
//        ownerRepo.saveAndFlush(owner);
//
//        return "redirect:/owners";
//    }
//
//    @PostMapping("edit_owner")
//    public String editOwner(@RequestParam Integer owner_id, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String patronymic, @RequestParam String phone, @RequestParam String comment, Map<String, Object> model)
//    {
//        Owner owner = new Owner(firstname,lastname,patronymic,phone,comment);
//        owner.setOwner_id(owner_id);
//        ownerRepo.saveAndFlush(owner);
//
//        return "redirect:/owners";
//    }
//
//    @GetMapping("del_owners")
//    public String delOwners(@RequestParam List<Integer> mark_item)
//    {
//        for (Integer item: mark_item) {
//            ownerRepo.delByID(item);
//        }
//
//        return "redirect:/owners";
//    }
//
//    @GetMapping("/")
//    public String main (Map<String, Object> model)
//    {
//
//        return "main.html";
//
//    }
}