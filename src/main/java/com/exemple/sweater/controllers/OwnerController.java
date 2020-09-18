package com.exemple.sweater.controllers;

import com.exemple.sweater.domains.Owner;
import com.exemple.sweater.repos.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping("/")
public class OwnerController {
    @Autowired
    private OwnerRepo ownerRepo;


    @GetMapping("owners")
    public String ownersList (@RequestParam(required = false) Integer owner_id, Model model) {
        List<Owner> owners = ownerRepo.findAll();

        if (owner_id != null)
        {
            Owner edit_owner = ownerRepo.findByOwner_id(owner_id);
            model.addAttribute("edit_owner",edit_owner);
        }

        model.addAttribute("owners", owners);
        return "owners.html";
    }

    @PostMapping("add_owner")
    public String addOwner(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String patronymic, @RequestParam String phone, @RequestParam String comment, Map<String, Object> model)
    {
        Owner owner = new Owner(firstname,lastname,patronymic,phone,comment);
        ownerRepo.saveAndFlush(owner);

        return "redirect:/owners";
    }

    @PostMapping("edit_owner")
    public String editOwner(@RequestParam Integer owner_id, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String patronymic, @RequestParam String phone, @RequestParam String comment, Map<String, Object> model)
    {
        Owner owner = new Owner(firstname,lastname,patronymic,phone,comment);
        owner.setOwner_id(owner_id);
        ownerRepo.saveAndFlush(owner);

        return "redirect:/owners";
    }

    @GetMapping("del_owners")
    public String delOwners(@RequestParam List<Integer> mark_item)
    {
        for (Integer item: mark_item) {
            ownerRepo.delByID(item);
        }

        return "redirect:/owners";
    }

    @GetMapping("/")
    public String main (Map<String, Object> model)
    {

        return "main.html";

    }
}